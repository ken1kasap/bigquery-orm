package com.github.ken1kasap.bigquery.orm.testkit

import org.joda.time.DateTime

case class FlatEntity(
    str_rst: Option[String],
    int_rst: Option[Long],
    dbl_rst: Option[Double],
    bool_rst: Option[Boolean],
    dt_rst: Option[DateTime]
)
