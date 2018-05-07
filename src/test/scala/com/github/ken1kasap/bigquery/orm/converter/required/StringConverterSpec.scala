package com.github.ken1kasap.bigquery.orm.converter.required

import org.scalatest.{ DiagrammedAssertions, FlatSpec }

class StringConverterSpec extends FlatSpec with DiagrammedAssertions {

  "required.StringConverter#convert" should "return String value" in {
    val expectedValue = "value"

    val converted = StringConverter.convert("value")

    assert(converted == expectedValue)
  }
}
