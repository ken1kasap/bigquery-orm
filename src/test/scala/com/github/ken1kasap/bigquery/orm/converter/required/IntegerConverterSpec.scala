package com.github.ken1kasap.bigquery.orm.converter.required

import org.scalatest.{ DiagrammedAssertions, FlatSpec }

class IntegerConverterSpec extends FlatSpec with DiagrammedAssertions {

  "required.IntegerConverter#convert" should "return Long value" in {
    val expectedValue = 100L

    val converted = IntegerConverter.convert(expectedValue.toString)

    assert(converted == expectedValue)
    assert(converted.isInstanceOf[Long])
  }
}
