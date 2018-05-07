package com.github.ken1kasap.bigquery.orm.converter.nullable

import com.github.ken1kasap.bigquery.orm.converter.{ required, TypeConverter }

object IntegerConverter extends TypeConverter[Option[Long]] {
  override def convert(value: String): Option[Long] =
    if (value == null) None
    else Some(required.IntegerConverter.convert(value))
}
