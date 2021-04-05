package com.epam.calculator.model.timescala

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Duration extends Serializable {
  var text: String = _
  var value: Int = _

  def getText: String = text
  def getValue: Int = value

  override def toString = s"Duration($text, $value)"
}


object Duration {
def apply(text: String, value: Int):Duration = this(text, value)

  def unApply(duration: Duration):Option[(String, Int)]={
   Option.apply(duration.text, duration.value)
  }

}