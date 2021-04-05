/*
  author Anastasiya
  created on 01/04/2021
  */

package com.epam.calculator.model.timescala

class Distance extends Serializable{
  var text: String = _
  var value: Int = _

  def getText  : String = text
  def getValue : Int = value

  override def toString = s"Distance($text, $value)"
}


object Distance {
  def apply(text: String, value: Int):Distance = this(text, value)

  def unApply(distance: Distance):Option[(String, Int)]={
    Option.apply(distance.text, distance.value)
  }

}