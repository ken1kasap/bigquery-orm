package com.github.ken1kasap.bigquery.orm.converter

import com.github.ken1kasap.bigquery.orm.schema.DataType._
import com.github.ken1kasap.bigquery.orm.schema.FieldSchema
import com.github.ken1kasap.bigquery.orm.schema.Mode._

trait TypeConverter[T] {
  def convert(value: String): T
}

object TypeConverter {
  def apply(schema: FieldSchema): TypeConverter[_] = {
    if (schema.mode == NULLABLE) getOptionConverter(schema)
    else getRequiredConverter(schema)
  }

  private def getRequiredConverter(schema: FieldSchema): TypeConverter[_] = {
    import required._
    schema.typ match {
      case STRING    => StringConverter
      case INTEGER   => IntegerConverter
      case FLOAT     => FloatConverter
      case BOOLEAN   => BooleanConverter
      case TIMESTAMP => DateTimeConverter
      case _         => StringConverter
    }
  }

  private def getOptionConverter(schema: FieldSchema): TypeConverter[_] = {
    import nullable._
    schema.typ match {
      case STRING    => StringConverter
      case INTEGER   => IntegerConverter
      case FLOAT     => FloatConverter
      case BOOLEAN   => BooleanConverter
      case TIMESTAMP => DateTimeConverter
      case _         => StringConverter
    }
  }
}
