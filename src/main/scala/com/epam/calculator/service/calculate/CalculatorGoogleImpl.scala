/*
  author Anastasiya
  created on 27/03/2021
  */

package com.epam.calculator.service.calculate
import com.epam.calculator.config.Constance.{URI, key}
import com.epam.calculator.model.api_coordinates.{IncorrectRequest, TripCoordinatesGoogle}
import com.epam.calculator.model.timescala.{Duration, RootTime}
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate


@Service
case class CalculatorGoogleImpl(restTemplate: RestTemplate)extends Calculator {
  val logger:Logger = LoggerFactory.getLogger(this.getClass)

  override def calculate(tripCoordinates: TripCoordinatesGoogle):Any = {
    if(tripCoordinates==null) return IncorrectRequest.apply("incorrect value, please enter trip coordinates...")

      val uri: String = URI + tripCoordinates.origins + "&destinations=" + tripCoordinates.destinations + "&key=" + key + "&departure_time=now"
      logger.debug("Method: " + this.getClass.getDeclaredMethods.head + " " + uri)

      val res = restTemplate.getForObject(uri, classOf[RootTime])
      logger.debug("Method: " + this.getClass.getDeclaredMethods.head + " " + res)

      if (res.getRows.head.getElements.head.duration_in_traffic == null) res.getRows.head.getElements.head.duration
      else if (res.getRows.head.getElements.head.duration == null) Duration.apply("0 min", 0)
      else res.rows.head.elements.head.duration_in_traffic

  }
}
