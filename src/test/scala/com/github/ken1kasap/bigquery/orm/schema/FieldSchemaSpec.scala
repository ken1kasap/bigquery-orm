package com.github.ken1kasap.bigquery.orm.schema

import com.github.ken1kasap.bigquery.orm.schema.DataType._
import com.github.ken1kasap.bigquery.orm.schema.Mode._
import org.scalatest.{ DiagrammedAssertions, FlatSpec }

class FieldSchemaSpec extends FlatSpec with DiagrammedAssertions {

  "FieldSchema#apply" should "return new FieldSchema" in {
    val schema = FieldSchema("field", "STRING", "NULLABLE", Seq.empty)
    assert(schema.name == "field")
    assert(schema.typ == STRING)
    assert(schema.mode == NULLABLE)
  }

  it should "return exact DataType" in {
    val byteSchema = FieldSchema("field", "BYTES", "NULLABLE", Seq.empty)
    assert(byteSchema.typ == BYTES)

    val integerSchema = FieldSchema("field", "INTEGER", "NULLABLE", Seq.empty)
    assert(integerSchema.typ == INTEGER)

    val floatSchema = FieldSchema("field", "FLOAT", "NULLABLE", Seq.empty)
    assert(floatSchema.typ == FLOAT)

    val booleanSchema = FieldSchema("field", "BOOLEAN", "NULLABLE", Seq.empty)
    assert(booleanSchema.typ == BOOLEAN)

    val timestampSchema = FieldSchema("field", "TIMESTAMP", "NULLABLE", Seq.empty)
    assert(timestampSchema.typ == TIMESTAMP)

    val recordSchema = FieldSchema("field", "RECORD", "NULLABLE", Seq.empty)
    assert(recordSchema.typ == RECORD)
  }

  it should "return exact Mode" in {
    val nullable = FieldSchema("field", "STRING", "NULLABLE", Seq.empty)
    assert(nullable.mode == NULLABLE)

    val required = FieldSchema("field", "STRING", "REQUIRED", Seq.empty)
    assert(required.mode == REQUIRED)

    val repeated = FieldSchema("field", "STRING", "REPEATED", Seq.empty)
    assert(repeated.mode == REPEATED)
  }
}
