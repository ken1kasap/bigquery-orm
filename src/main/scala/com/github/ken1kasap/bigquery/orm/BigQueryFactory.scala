package com.github.ken1kasap.bigquery.orm

import com.google.cloud.bigquery.{ BigQuery, BigQueryOptions }
import com.google.cloud.http.HttpTransportOptions

trait BigQueryFactory {
  def create(): BigQuery
}

class BigQueryFactoryImpl(
    connectTimeout: Int,
    readTimeout: Int
) extends BigQueryFactory {
  def create(): BigQuery = {
    val httpTransportOptions = HttpTransportOptions
      .newBuilder()
      .setConnectTimeout(connectTimeout)
      .setReadTimeout(readTimeout)
      .build()

    val bigQueryOptions = BigQueryOptions
      .newBuilder()
      .setTransportOptions(httpTransportOptions)
      .build()

    bigQueryOptions.getService
  }
}

object BigQueryFactory extends BigQueryFactory {
  def defaultFactory: BigQueryFactory = newFactory(600000, 0)

  def newFactory(connectTimeout: Int, readTimeout: Int): BigQueryFactory =
    new BigQueryFactoryImpl(connectTimeout, readTimeout)

  override def create(): BigQuery = defaultFactory.create()
}
