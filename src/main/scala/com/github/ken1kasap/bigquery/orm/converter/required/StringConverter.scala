package com.github.ken1kasap.bigquery.orm.converter.required

import com.github.ken1kasap.bigquery.orm.converter.TypeConverter

object StringConverter extends TypeConverter[String] {
  def convert(value: String): String = value
}
