package com.github.ken1kasap.bigquery.orm.testkit

case class NestedEntity(str_rst: Option[String],
                        int_rst: Option[Int],
                        dbl_rst: Option[Double],
                        nst_rst: Seq[NestedFields])

case class NestedFields(value: Option[String], count: Option[Int])
