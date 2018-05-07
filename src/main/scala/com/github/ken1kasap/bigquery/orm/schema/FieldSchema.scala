package com.github.ken1kasap.bigquery.orm.schema

import com.google.cloud.bigquery.Field
import enumeratum.{ Enum, EnumEntry }

import scala.collection.JavaConverters._

case class FieldSchema(name: String, typ: DataType, mode: Mode, fields: Seq[FieldSchema] = Seq.empty)

object FieldSchema {
  def apply(name: String, typ: String, mode: String, fields: Seq[FieldSchema]): FieldSchema =
    FieldSchema(name, DataType.withName(typ), Mode.withName(mode), fields)

  def fromField(f: Field): FieldSchema = {
    val subFields = f.getSubFields
    if (subFields == null)
      FieldSchema(f.getName, f.getType.toString, f.getMode.toString, Seq.empty)
    else {
      val nestedFields = subFields.asScala.map { f =>
        fromField(f)
      }
      FieldSchema(f.getName, f.getType.toString, f.getMode.toString, nestedFields)
    }
  }
}

sealed trait DataType extends EnumEntry

object DataType extends Enum[DataType] {

  val values = findValues

  // TODO DataType should be StandardSQLTypeName
  case object STRING    extends DataType
  case object BYTES     extends DataType
  case object INTEGER   extends DataType
  case object FLOAT     extends DataType
  case object BOOLEAN   extends DataType
  case object TIMESTAMP extends DataType
  case object RECORD    extends DataType

}

sealed trait Mode extends EnumEntry

object Mode extends Enum[Mode] {

  val values = findValues

  case object REQUIRED extends Mode
  case object NULLABLE extends Mode
  case object REPEATED extends Mode
}
