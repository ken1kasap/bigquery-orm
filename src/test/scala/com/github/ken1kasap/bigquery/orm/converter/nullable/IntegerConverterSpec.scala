package com.github.ken1kasap.bigquery.orm.converter.nullable

import org.scalatest.{ DiagrammedAssertions, FlatSpec }

class IntegerConverterSpec extends FlatSpec with DiagrammedAssertions {

  "nullable.IntegerConverter#convert" should "return Some(Long) when the value is not null" in {
    val expectedValue = 100L

    val expectedType = Some(expectedValue)

    val converted = IntegerConverter.convert(expectedValue.toString)

    assert(converted == expectedType)
    converted.foreach { v =>
      assert(v == expectedValue)
      assert(v.isInstanceOf[Long])
    }
  }

  it should "return None when the value is null" in {
    assert(IntegerConverter.convert(null).isEmpty)
  }
}
