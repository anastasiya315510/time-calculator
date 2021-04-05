/*
  author Anastasiya
  created on 01/04/2021
  */

package com.epam.calculator.model.coordinates_scala

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class AddressComponent extends Serializable{
  var long_name: String = _
  var  short_name: String = _
  var types:Array[String] = _

  def getLong_name():String ={
    long_name
  }
  def getShort_name():String ={
    short_name
  }
  def getTypes():Array[String] ={
    types
  }

  override def toString = s"AddressComponent($long_name, $short_name, $types)"
}

object AddressComponent{
  def apply(long_name: String,short_name: String, types:Array[String]):AddressComponent = this(long_name, short_name, types)
  def unApply(addressComponent: AddressComponent):Option[(String, String, Array[String])]={
    Option.apply(addressComponent.long_name, addressComponent.short_name, addressComponent.types)
  }
}
