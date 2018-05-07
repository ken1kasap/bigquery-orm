package com.github.ken1kasap.bigquery.orm.testkit

object TestSupport {
  def projectId = sys.env.get("BQ_PROJECT_ID").getOrElse("")
}
