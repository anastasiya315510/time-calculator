/*
  author Anastasiya
  created on 27/03/2021
  */

package com.epam.calculator.service.trip

import com.epam.calculator.model.api_coordinates.{ResponseLocation, TripCoordinatesGoogle}
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.stereotype.Service

@Service
case class ConvertorTripForGoogleImpl() extends ConvertorTrip {
  val logger:Logger = LoggerFactory.getLogger(this.getClass)
  override def convertToOriginAndDestination(origin: ResponseLocation, destination: ResponseLocation): TripCoordinatesGoogle = {
    if(origin==null||destination==null) return new TripCoordinatesGoogle
    logger.debug("Method: "+this.getClass.getDeclaredMethods.head+", origin: "+origin+", destination: "+destination)
    TripCoordinatesGoogle.apply(origin.lat+","+origin.lng, destination.lat+","+destination.lng)
  }
}
