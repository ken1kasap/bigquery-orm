package com.github.ken1kasap.bigquery.orm.converter.nullable

import org.scalatest.{ DiagrammedAssertions, FlatSpec }

class BooleanConverterSpec extends FlatSpec with DiagrammedAssertions {

  "nullable.BooleanConverter#convert" should "return Some when the value is not null" in {
    val input         = "true"
    val expectedValue = true
    val expectedType  = Some(expectedValue)

    val converted = BooleanConverter.convert(input)

    assert(converted == expectedType)
    converted.foreach(v => assert(v == expectedValue))
  }

  it should "return Some(true) when the input is 1" in {
    val input         = "1"
    val expectedValue = true
    val expectedType  = Some(expectedValue)

    val converted = BooleanConverter.convert(input)

    assert(converted == expectedType)
    converted.foreach(v => assert(v == expectedValue))
  }

  it should "return Some(false) when the input is false" in {
    val input         = "false"
    val expectedValue = false
    val expectedType  = Some(expectedValue)

    val converted = BooleanConverter.convert(input)

    assert(converted == expectedType)
    converted.foreach(v => assert(v == expectedValue))
  }

  it should "return Some(false) when the input is 0" in {
    val input         = "0"
    val expectedValue = false
    val expectedType  = Some(expectedValue)

    val converted = BooleanConverter.convert(input)

    assert(converted == expectedType)
    converted.foreach(v => assert(v == expectedValue))
  }

  it should "return Some(false) when the input is not matched value" in {
    val input         = "etc"
    val expectedValue = false
    val expectedType  = Some(expectedValue)

    val converted = BooleanConverter.convert(input)

    assert(converted == expectedType)
    converted.foreach(v => assert(v == expectedValue))
  }

  it should "return None when the value is null" in {
    assert(BooleanConverter.convert(null).isEmpty)
  }
}
