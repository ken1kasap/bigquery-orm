package com.github.ken1kasap.bigquery.orm.converter.required

import com.github.ken1kasap.bigquery.orm.converter.TypeConverter

object IntegerConverter extends TypeConverter[Long] {
  def convert(value: String): Long = value.toLong
}
