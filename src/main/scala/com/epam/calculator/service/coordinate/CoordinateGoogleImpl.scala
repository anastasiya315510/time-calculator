/*
  author Anastasiya
  created on 27/03/2021
  */

package com.epam.calculator.service.coordinate

import com.epam.calculator.config.Constance.{googleGetCoordinatesURI, key}
import com.epam.calculator.model.api_coordinates.ResponseLocation
import com.epam.calculator.model.coordinates_scala.Root
import com.epam.calculator.model.request_body_var.Address
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
case class CoordinateGoogleImpl(restTemplate: RestTemplate) extends Coordinate {
  val logger:Logger = LoggerFactory.getLogger(this.getClass)

  override def calculateCoordinate(address: Address): ResponseLocation= {
    val newURI: String = googleGetCoordinatesURI + "?address=" + address.country + "+" + address.city + "+" + address.street + "+" + address.building + "&key=" + key;

    logger.debug("Method: "+this.getClass.getDeclaredMethods.head+" uri="+newURI)

      val resp = restTemplate.getForObject(newURI, classOf[Root])
    if(resp==null) logger.warn("Method: "+this.getClass.getDeclaredMethods.head+"  response is null")
   ResponseLocation.apply(lat=resp.results.head.geometry.location.lat, lng=resp.results.head.geometry.location.lng)

  }
}
