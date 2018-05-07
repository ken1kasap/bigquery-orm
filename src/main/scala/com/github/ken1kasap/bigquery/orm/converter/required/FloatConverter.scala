package com.github.ken1kasap.bigquery.orm.converter.required

import com.github.ken1kasap.bigquery.orm.converter.TypeConverter

object FloatConverter extends TypeConverter[Double] {
  def convert(value: String): Double = value.toDouble
}
