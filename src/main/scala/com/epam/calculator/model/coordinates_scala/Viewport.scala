/*
  author Anastasiya
  created on 01/04/2021
  */

package com.epam.calculator.model.coordinates_scala

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Viewport extends Serializable {
  var southwest: Southwest=_
  var northeast: Northeast=_

  def getSouthwest: Southwest= southwest

  def getNortheast: Northeast= northeast

  override def toString = s"Viewport($southwest, $northeast)"
}

object Viewport{
  def apply(southwest: Southwest,northeast: Northeast):Viewport=this(southwest, northeast)
  def unApply(viewport: Viewport):Option[(Southwest,Northeast)]={
    Option.apply(viewport.southwest, viewport.northeast)
  }
}