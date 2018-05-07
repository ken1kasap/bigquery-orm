package com.github.ken1kasap.bigquery.orm.converter.nullable

import com.github.ken1kasap.bigquery.orm.converter.TypeConverter

object StringConverter extends TypeConverter[Option[String]] {
  def convert(value: String): Option[String] = Option(value)
}
