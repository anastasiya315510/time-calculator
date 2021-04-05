/*
  author Anastasiya
  created on 01/04/2021
  */

package com.epam.calculator.model.coordinates_scala

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Location{
  var lat: Double = _
  var lng: Double = _

  def getLat():Double=lat
  def getLng():Double=lng

  override def toString = s"Location($lat, $lng)"
}

object Location{
  def apply(lat: Double, lng: Double ):Location=this(lat, lng)
  def unApply(location: Location):Option[(Double, Double)]={
    Option.apply(location.lat, location.lng)
  }
}