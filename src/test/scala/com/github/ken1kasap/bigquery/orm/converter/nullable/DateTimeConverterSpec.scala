package com.github.ken1kasap.bigquery.orm.converter.nullable

import org.joda.time.{ DateTime, DateTimeZone }
import org.scalatest.{ DiagrammedAssertions, FlatSpec }

class DateTimeConverterSpec extends FlatSpec with DiagrammedAssertions {

  "nullable.DateTimeConverter#convert" should "return Some when the value is not null" in {
    // 2016-11-02 07:00:00 UTC
    // Double value is 1.47807E9
    val expectedValue = new DateTime(2016, 11, 2, 7, 0, 0, DateTimeZone.UTC)
    val input         = (expectedValue.getMillis / 1000).toDouble.toString
    val expectedType  = Some(expectedValue)

    val converted = DateTimeConverter.convert(input)

    assert(converted == expectedType)
    converted.foreach(v => assert(v == expectedValue))
  }

  it should "return None when the value is null" in {
    assert(DateTimeConverter.convert(null).isEmpty)
  }

}
