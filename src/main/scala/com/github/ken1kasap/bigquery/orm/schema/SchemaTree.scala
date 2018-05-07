package com.github.ken1kasap.bigquery.orm.schema

import com.google.cloud.bigquery.Schema

import scala.collection.JavaConverters._

case class SchemaTree(fields: Seq[FieldSchema])

object SchemaTree {
  def apply(schema: Schema): SchemaTree = {
    SchemaTree(schema.getFields.asScala.map { f =>
      FieldSchema.fromField(f)
    })
  }
}
