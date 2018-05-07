package com.github.ken1kasap.bigquery.orm.converter.required

import org.scalatest.{ DiagrammedAssertions, FlatSpec }

class BooleanConverterSpec extends FlatSpec with DiagrammedAssertions {

  "required.BooleanConverter#convert" should "return true when the value is not null" in {
    val input         = "true"
    val expectedValue = true

    val converted = BooleanConverter.convert(input)

    assert(converted == expectedValue)
  }

  it should "return true when the input is 1" in {
    val input         = "1"
    val expectedValue = true

    val converted = BooleanConverter.convert(input)

    assert(converted == expectedValue)
  }

  it should "return false when the input is false" in {
    val input         = "false"
    val expectedValue = false

    val converted = BooleanConverter.convert(input)

    assert(converted == expectedValue)
  }

  it should "return false when the input is 0" in {
    val input         = "0"
    val expectedValue = false

    val converted = BooleanConverter.convert(input)

    assert(converted == expectedValue)
  }

  it should "return false when the input is not matched value" in {
    val input         = "etc"
    val expectedValue = false

    val converted = BooleanConverter.convert(input)

    assert(converted == expectedValue)
  }

}
