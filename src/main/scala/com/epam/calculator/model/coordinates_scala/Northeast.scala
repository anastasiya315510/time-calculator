/*
  author Anastasiya
  created on 01/04/2021
  */

package com.epam.calculator.model.coordinates_scala

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Northeast {
  var lat: Double = _
  var lng: Double = _

  def getLat():Double ={
    lat
  }
  def getLng():Double ={
    lng
  }

  override def toString = s"Northeast($lat, $lng)"
}
object Northeast{
  def apply(lat:Double, lng:Double):Northeast = this(lat, lng)
  def unApply(northeast: Northeast):Option[(Double, Double)]={
    Option.apply(northeast.lat, northeast.lng)
  }
}
