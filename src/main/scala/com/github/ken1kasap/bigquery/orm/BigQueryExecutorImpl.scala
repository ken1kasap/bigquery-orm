package com.github.ken1kasap.bigquery.orm

import com.github.ken1kasap.bigquery.orm.util.JobIdGenerator
import com.google.cloud.bigquery._

class BigQueryExecutorImpl(
    projectId: String,
    bigQuery: BigQuery
) {

  def run(sql: String): Job = {
    val jobId = JobId.of(projectId, JobIdGenerator.generate())
    val jobConfiguration = QueryJobConfiguration
      .newBuilder(sql)
      .setUseQueryCache(true)
      //.setAllowLargeResults(true)
      .build()

    val jobInfo = JobInfo
      .newBuilder(jobConfiguration)
      .setJobId(jobId)
      .build()

    bigQuery.create(jobInfo)
  }

  def isDone(job: Job): Boolean = job.isDone
}
