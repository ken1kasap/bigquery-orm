package com.github.ken1kasap.bigquery.orm.converter.nullable

import com.github.ken1kasap.bigquery.orm.converter.{ required, TypeConverter }
import org.joda.time.DateTime

object DateTimeConverter extends TypeConverter[Option[DateTime]] {
  def convert(value: String): Option[DateTime] =
    if (value == null) None
    else Some(required.DateTimeConverter.convert(value))
}
