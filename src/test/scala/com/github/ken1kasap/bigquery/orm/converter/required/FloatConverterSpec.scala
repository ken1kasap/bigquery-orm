package com.github.ken1kasap.bigquery.orm.converter.required

import org.scalatest.{ DiagrammedAssertions, FlatSpec }

class FloatConverterSpec extends FlatSpec with DiagrammedAssertions {

  "required.FloatConverter#convert" should "return Double value" in {
    val expectedValue = 1.6196954972465177E-4

    val converted = FloatConverter.convert(expectedValue.toString)

    assert(converted == expectedValue)
  }
}
