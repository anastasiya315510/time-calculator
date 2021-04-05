package com.epam.calculator.model.timescala

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class DurationInTraffic extends Serializable {
  var text: String = _
  var value: Int = _

  def getText : String = text
  def getValue  : Int = value

  override def toString = s"DurationInTraffic($text, $value)"
}


object DurationInTraffic {
def apply(text: String, value: Int):DurationInTraffic = this(text, value)

  def unApply(durationInTraffic: DurationInTraffic):Option[(String, Int)]={
   Option.apply(durationInTraffic.text, durationInTraffic.value)
  }

}