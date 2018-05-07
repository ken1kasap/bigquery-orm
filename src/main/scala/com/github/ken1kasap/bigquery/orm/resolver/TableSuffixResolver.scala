package com.github.ken1kasap.bigquery.orm.resolver

import org.joda.time.{ DateTime, DateTimeZone, Duration }

trait TableSuffixResolver {

  def resolveTableSuffix(min: DateTime, max: DateTime)(f: (DateTime, DateTime) => String): String = {
    val truncatedMin = new DateTime(min.getMillis, DateTimeZone.UTC).dayOfMonth().roundFloorCopy()
    val truncatedMax = new DateTime(max.getMillis, DateTimeZone.UTC).dayOfMonth().roundFloorCopy()
    f(truncatedMin, truncatedMax)
  }

  def getTableSuffixClause(from: DateTime, to: DateTime): String = {
    val diff = new Duration(to, from).getStandardDays
    if (diff == 0) s"_TABLE_SUFFIX = '${from.toString("yyyyMMdd")}'"
    else s"_TABLE_SUFFIX BETWEEN '${from.toString("yyyyMMdd")}' AND '${to.toString("yyyyMMdd")}'"
  }
}
