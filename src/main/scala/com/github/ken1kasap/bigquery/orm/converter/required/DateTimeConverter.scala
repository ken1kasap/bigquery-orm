package com.github.ken1kasap.bigquery.orm.converter.required

import com.github.ken1kasap.bigquery.orm.converter.TypeConverter
import org.joda.time.{ DateTime, DateTimeZone }

object DateTimeConverter extends TypeConverter[DateTime] {
  def convert(value: String): DateTime = {
    val timestamp = value.toDouble.toLong * 1000
    new DateTime(timestamp, DateTimeZone.UTC)
  }
}
