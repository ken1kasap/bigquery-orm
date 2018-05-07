package com.github.ken1kasap.bigquery.orm.converter.required

import org.joda.time.{ DateTime, DateTimeZone }
import org.scalatest.{ DiagrammedAssertions, FlatSpec }

class DateTimeConverterSpec extends FlatSpec with DiagrammedAssertions {

  "required.DateTimeConverter#convert" should "return DateTime value" in {
    // 2016-11-02 07:00:00 UTC
    // Double value is 1.47807E9
    val expectedValue = new DateTime(2016, 11, 2, 7, 0, 0, DateTimeZone.UTC)
    val input         = (expectedValue.getMillis / 1000).toDouble.toString

    val converted = DateTimeConverter.convert(input)

    assert(converted == expectedValue)
  }

}
