package com.github.ken1kasap.bigquery.orm.sql.function

import enumeratum._

sealed trait DatePart extends EnumEntry

object DatePart extends Enum[DatePart] {

  val values = findValues

  case object MICROSECOND extends DatePart
  case object MILLISECOND extends DatePart
  case object SECOND      extends DatePart
  case object MINUTE      extends DatePart
  case object HOUR        extends DatePart
  case object DAY         extends DatePart
  case object WEEK        extends DatePart
  case object MONTH       extends DatePart
  case object QUARTER     extends DatePart
  case object YEAR        extends DatePart
}
