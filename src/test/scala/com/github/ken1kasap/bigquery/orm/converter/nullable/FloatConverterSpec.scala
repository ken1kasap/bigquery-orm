package com.github.ken1kasap.bigquery.orm.converter.nullable

import org.scalatest.{ DiagrammedAssertions, FlatSpec }

class FloatConverterSpec extends FlatSpec with DiagrammedAssertions {

  "nullable.FloatConverter#convert" should "return Some when the value is not null" in {
    val expectedValue = 1.6196954972465177E-4
    val expectedType  = Some(expectedValue)

    val converted = FloatConverter.convert(expectedValue.toString)

    assert(converted == expectedType)
    converted.foreach(v => assert(v == expectedValue))
  }

  it should "return None when the value is null" in {
    assert(FloatConverter.convert(null).isEmpty)
  }
}
