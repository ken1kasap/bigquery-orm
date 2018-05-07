package com.github.ken1kasap.bigquery.orm.converter.nullable

import com.github.ken1kasap.bigquery.orm.converter.{ required, TypeConverter }

object BooleanConverter extends TypeConverter[Option[Boolean]] {
  def convert(value: String): Option[Boolean] =
    if (value == null) None
    else Some(required.BooleanConverter.convert(value))
}
