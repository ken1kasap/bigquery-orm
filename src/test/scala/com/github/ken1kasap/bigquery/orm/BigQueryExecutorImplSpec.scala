package com.github.ken1kasap.bigquery.orm

import com.github.ken1kasap.bigquery.orm.schema.SchemaTree
import com.github.ken1kasap.bigquery.orm.testkit.{ FlatEntity, TestSupport }
import com.google.cloud.RetryOption
import com.google.cloud.bigquery._
import org.joda.time.{ DateTime, DateTimeZone }
import org.scalatest.{ FlatSpec, Matchers }
import org.threeten.bp.Duration

import scala.collection.JavaConverters._
import scala.reflect.runtime.universe._

class BigQueryExecutorImplSpec extends FlatSpec with Matchers {

  private val projectId = TestSupport.projectId

  "Flat result" should "be mapped to FlatEntity" in {

    val sql =
      s"""SELECT "abc" AS str_rst, 1 AS int_rst, 2.3 AS dbl_rst, true AS bool_rst, TIMESTAMP("2018-05-06 18:34:08.000") AS dt_rst;"""

    val expected = Seq(
      FlatEntity(
        Some("abc"),
        Some(1L),
        Some(2.3),
        Some(true),
        Some(new DateTime(2018, 5, 6, 18, 34, 8, DateTimeZone.UTC))
      )
    )

    val bigQuery: BigQuery = BigQueryFactory.create()
    val executor           = new BigQueryExecutorImpl(projectId, bigQuery)
    val job: Job           = executor.run(sql)
    val waitedJob: Job     = job.waitFor(RetryOption.totalTimeout(Duration.ofHours(1)))

    val queryResult: TableResult                  = waitedJob.getQueryResults()
    val schemaTree: SchemaTree                    = SchemaTree(queryResult.getSchema)
    val fieldValueLists: Iterable[FieldValueList] = queryResult.getValues.asScala

    implicit val ttag           = typeTag[FlatEntity]
    val result: Seq[FlatEntity] = EntityFactory.toEntitySeq[FlatEntity](schemaTree, fieldValueLists)

    result should equal(expected)
  }
}
