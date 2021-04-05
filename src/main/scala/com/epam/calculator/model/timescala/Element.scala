package com.epam.calculator.model.timescala

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Element extends Serializable{
                var distance: Distance = _
                var duration: Duration = _
                var duration_in_traffic: DurationInTraffic = _
                var  status: String = _



  def getDistance: Distance = Distance.apply(distance.text, distance.value)
  def getDuration: Duration = Duration.apply(duration.text, duration.value)
  def getDuration_In_Traffic: DurationInTraffic = DurationInTraffic.apply(duration_in_traffic.text, duration_in_traffic.value)
  def getStatus: String = status

  override def toString = s"Element($distance, $duration, $duration_in_traffic, $status)"
}


object Element {
  def apply(distance: Distance, duration: Duration, duration_in_traffic: DurationInTraffic, status:String ): Element =
    this(distance, duration, duration_in_traffic, status)

  def unApply(element: Element):Option[(Distance, Duration, DurationInTraffic, String)]={
    Option.apply(element.distance, element.duration, element.duration_in_traffic, element.status)
  }

}