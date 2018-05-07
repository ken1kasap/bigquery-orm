package com.github.ken1kasap.bigquery.orm.resolver

import org.joda.time.{ DateTime, DateTimeZone }
import org.scalatest.{ DiagrammedAssertions, FlatSpec }

class TableSuffixResolverSpec extends FlatSpec with DiagrammedAssertions {

  "TableSuffixResolver#getTableSuffixClause" should "return BETWEEN clause" in new TableSuffixResolver {
    val from = new DateTime(2016, 12, 11, 0, 0, DateTimeZone.UTC)
    val to   = new DateTime(2017, 12, 13, 0, 0, DateTimeZone.UTC)

    val expect = "_TABLE_SUFFIX BETWEEN '20161211' AND '20171213'"
    val result = getTableSuffixClause(from, to)

    assert(result == expect)
  }

  it should "return a date of _TABLE_SUFFIX" in new TableSuffixResolver {
    val from = new DateTime(2016, 12, 13, 0, 0, DateTimeZone.UTC)
    val to   = new DateTime(2016, 12, 13, 0, 0, DateTimeZone.UTC)

    val expect = "_TABLE_SUFFIX = '20161213'"
    val result = getTableSuffixClause(from, to)

    assert(result == expect)
  }

  "TableSuffixResolver#resolveTableSuffix" should "return BETWEEN clause" in new TableSuffixResolver {
    val from = new DateTime(2016, 12, 11, 13, 11, 10, DateTimeZone.UTC)
    val to   = new DateTime(2017, 12, 13, 12, 30, 11, DateTimeZone.UTC)

    val expect = "_TABLE_SUFFIX BETWEEN '20161211' AND '20171213'"
    val result = resolveTableSuffix(from, to)(getTableSuffixClause)

    assert(result == expect)
  }

  it should "return a date of _TABLE_SUFFIX" in new TableSuffixResolver {
    val from = new DateTime(2017, 7, 7, 15, 10, 10, DateTimeZone.UTC)
    val to   = new DateTime(2017, 7, 7, 17, 30, 11, DateTimeZone.UTC)

    val expect = "_TABLE_SUFFIX = '20170707'"
    val result = resolveTableSuffix(from, to)(getTableSuffixClause)

    assert(result == expect)
  }
}
