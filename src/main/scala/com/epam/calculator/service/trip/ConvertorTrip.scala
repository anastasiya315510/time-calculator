/*
  author Anastasiya
  created on 27/03/2021
  */

package com.epam.calculator.service.trip

import com.epam.calculator.model.api_coordinates.{ResponseLocation, TripCoordinatesGoogle}

trait ConvertorTrip {
  def convertToOriginAndDestination(origin: ResponseLocation, destination: ResponseLocation): TripCoordinatesGoogle


}
