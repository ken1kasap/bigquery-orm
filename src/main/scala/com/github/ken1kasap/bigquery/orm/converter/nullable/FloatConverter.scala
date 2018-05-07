package com.github.ken1kasap.bigquery.orm.converter.nullable

import com.github.ken1kasap.bigquery.orm.converter.{ required, TypeConverter }

object FloatConverter extends TypeConverter[Option[Double]] {
  def convert(value: String): Option[Double] =
    if (value == null) None
    else Some(required.FloatConverter.convert(value))
}
