package com.github.ken1kasap.bigquery.orm.converter.nullable

import org.scalatest.{ DiagrammedAssertions, FlatSpec }

class StringConverterSpec extends FlatSpec with DiagrammedAssertions {

  "nullable.StringConverter#convert" should "return Some when the value is not null" in {
    val expectedValue = "value"
    val expected      = Some(expectedValue)

    val converted = StringConverter.convert("value")

    assert(converted == expected)
    converted.foreach(v => assert(v == expectedValue))
  }

  it should "return None when the value is null" in {
    assert(StringConverter.convert(null).isEmpty)
  }
}
