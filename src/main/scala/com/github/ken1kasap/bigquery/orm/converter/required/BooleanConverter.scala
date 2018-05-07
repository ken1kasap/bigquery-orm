package com.github.ken1kasap.bigquery.orm.converter.required

import com.github.ken1kasap.bigquery.orm.converter.TypeConverter

object BooleanConverter extends TypeConverter[Boolean] {
  def convert(value: String): Boolean =
    value.toLowerCase match {
      case "true"  => true
      case "1"     => true
      case "false" => false
      case "0"     => false
      case _       => false
    }
}
