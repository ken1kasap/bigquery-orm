package com.github.ken1kasap.bigquery.orm.converter

import com.github.ken1kasap.bigquery.orm.schema.DataType._
import com.github.ken1kasap.bigquery.orm.schema.FieldSchema
import com.github.ken1kasap.bigquery.orm.schema.Mode._
import org.scalatest.{ DiagrammedAssertions, FlatSpec }

class TypeConverterSpec extends FlatSpec with DiagrammedAssertions {

  "TypeConverter#apply" should "return required converter when the mode is not NULLABLE" in {
    import required.StringConverter

    val requiredSchema = FieldSchema("field", STRING, REQUIRED)
    val converter      = TypeConverter(requiredSchema)
    assert(converter == StringConverter)
  }

  it should "return option converter when the mode is NULLABLE" in {
    import nullable.StringConverter

    val nullableSchema = FieldSchema("field", STRING, NULLABLE)
    val converter      = TypeConverter(nullableSchema)
    assert(converter == StringConverter)
  }

  it should "return exact required converter when the mode is not NULLABLE" in {
    val stringConverter = TypeConverter(FieldSchema("field", STRING, REQUIRED))
    assert(stringConverter == required.StringConverter)

    val integerConverter = TypeConverter(FieldSchema("field", INTEGER, REQUIRED))
    assert(integerConverter == required.IntegerConverter)

    val floatConverter = TypeConverter(FieldSchema("field", FLOAT, REQUIRED))
    assert(floatConverter == required.FloatConverter)

    val booleanConverter = TypeConverter(FieldSchema("field", BOOLEAN, REQUIRED))
    assert(booleanConverter == required.BooleanConverter)

    val timestampConverter = TypeConverter(FieldSchema("field", TIMESTAMP, REQUIRED))
    assert(timestampConverter == required.DateTimeConverter)

    val defaultConverter = TypeConverter(FieldSchema("field", RECORD, REQUIRED))
    assert(defaultConverter == required.StringConverter)
  }

  it should "return exact option converter when the mode is NULLABLE" in {
    val stringConverter = TypeConverter(FieldSchema("field", STRING, NULLABLE))
    assert(stringConverter == nullable.StringConverter)

    val integerConverter = TypeConverter(FieldSchema("field", INTEGER, NULLABLE))
    assert(integerConverter == nullable.IntegerConverter)

    val floatConverter = TypeConverter(FieldSchema("field", FLOAT, NULLABLE))
    assert(floatConverter == nullable.FloatConverter)

    val booleanConverter = TypeConverter(FieldSchema("field", BOOLEAN, NULLABLE))
    assert(booleanConverter == nullable.BooleanConverter)

    val timestampConverter = TypeConverter(FieldSchema("field", TIMESTAMP, NULLABLE))
    assert(timestampConverter == nullable.DateTimeConverter)

    val defaultConverter = TypeConverter(FieldSchema("field", RECORD, NULLABLE))
    assert(defaultConverter == nullable.StringConverter)
  }
}
