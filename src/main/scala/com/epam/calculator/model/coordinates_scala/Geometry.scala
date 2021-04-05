/*
  author Anastasiya
  created on 01/04/2021
  */

package com.epam.calculator.model.coordinates_scala

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
@JsonIgnoreProperties(ignoreUnknown = true)
class Geometry extends Serializable {
  var location: Location = _
  var location_type: String = _
  var viewport: Viewport = _
  def getLocation(): Location ={
    location
  }
  def getLocationType(): String ={
    location_type
  }
  def getViewport():Viewport={
    viewport
  }

  override def toString = s"Geometry($location, $location_type, $viewport)"
}

object Geometry{
  def apply(location: Location, location_type: String, viewport: Viewport):Geometry = this(location, location_type, viewport)
  def unApply(geometry: Geometry):Option[(Location,String, Viewport)]={
    Option.apply(geometry.location, geometry.location_type, geometry.viewport)
  }
}
