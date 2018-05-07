package com.github.ken1kasap.bigquery.orm

import com.github.ken1kasap.bigquery.orm.converter.TypeConverter
import com.github.ken1kasap.bigquery.orm.schema.{ FieldSchema, SchemaTree }
import com.google.cloud.bigquery.{ FieldValue, FieldValueList }

import scala.collection.JavaConverters._
import scala.reflect.runtime.universe
import scala.reflect.runtime.universe._

object EntityFactory {

  def toEntitySeq[T](st: SchemaTree, xs: Iterable[FieldValueList])(implicit tag: TypeTag[T]): Seq[T] =
    xs.map { fv: FieldValueList =>
      val vs: Seq[_] = toValueSeq(st.fields, fv)
      create(vs: _*)
    }(collection.breakOut)

  def create[T](args: Any*)(implicit ttag: TypeTag[T]): T = {
    val theType           = universe.typeOf[T]
    val classSymbol       = theType.typeSymbol.asClass
    val runtimeMirror     = universe.typeTag[T].mirror
    val classMirror       = runtimeMirror.reflectClass(classSymbol)
    val constructorMethod = theType.member(universe.termNames.CONSTRUCTOR).asMethod
    val constructorMirror = classMirror.reflectConstructor(constructorMethod)
    constructorMirror(args: _*).asInstanceOf[T]
  }

  def toValueSeq(fields: Seq[FieldSchema], row: java.util.List[FieldValue]): Seq[_] = {
    val zipped: Seq[(FieldSchema, FieldValue)] = (fields, row.asScala).zipped.toSeq
    zipped.map {
      case (fs, cs) =>
        if (fs.fields.nonEmpty) {
          toValueSeq(fs.fields, cs.getRepeatedValue)
        } else {
          TypeConverter(fs).convert(cs.getStringValue)
        }
    }
  }

}
