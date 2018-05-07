package com.github.ken1kasap.bigquery.orm.util

import java.util.UUID

object JobIdGenerator {
  def generate(): String = "job_" + UUID.randomUUID().toString
}
