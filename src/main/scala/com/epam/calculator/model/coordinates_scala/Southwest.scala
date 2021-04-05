/*
  author Anastasiya
  created on 01/04/2021
  */

package com.epam.calculator.model.coordinates_scala

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Southwest extends Serializable {
  var lat: Double = _
  var lng: Double = _

  def getLat: Double=lat
  def getLng: Double=lng


  override def toString = s"Southwest($lat, $lng)"
}
object Southwest{
  def apply(lat: Double, lng: Double):Southwest=this(lat, lng)
  def unApply(southwest: Southwest):Option[(Double, Double)]={
    Option.apply(southwest.lat, southwest.lng)
  }
}