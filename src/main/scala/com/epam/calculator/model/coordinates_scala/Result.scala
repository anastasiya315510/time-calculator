/*
  author Anastasiya
  created on 01/04/2021
  */

package com.epam.calculator.model.coordinates_scala

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Result{
  var address_components: Array[AddressComponent]=_
  var formatted_address: String = _
  var geometry: Geometry = _
  var place_id: String = _
  var types: Array[String] =_

  def getAddress_components: Array[AddressComponent]=address_components
  def getFormatted_address: String= formatted_address
  def getGeometry: Geometry= geometry
  def getPlace_id: String=place_id
  def getTypes: Array[String]=types

  override def toString = s"Result($address_components, $formatted_address, $geometry, $place_id, $types)"
}
object Result{
  def apply(address_components: Array[AddressComponent], formatted_address: String, geometry: Geometry, place_id: String, types: Array[String]):Result={
    this(address_components, formatted_address, geometry, place_id, types)
  }
  def unApply(result: Result):Option[(Array[AddressComponent],  String, Geometry,  String, Array[String])]={
    Option.apply(result.address_components, result.formatted_address, result.geometry, result.place_id, result.types)
  }
}

