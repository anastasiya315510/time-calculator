/*
    author Anastasiya
    created on 05/04/2021
  */

package com.epam.calculator.constants

import com.epam.calculator.model.api_coordinates.{ResponseLocation, TripAddress, TripCoordinatesGoogle}
import com.epam.calculator.model.request_body_var.Address
import com.epam.calculator.service.calculate.{Calculator, CalculatorGoogleImpl}
import com.epam.calculator.service.convertor_double.{DoubleConvertor, DoubleConvertorImpl}
import com.epam.calculator.service.coordinate.{Coordinate, CoordinateGoogleImpl}
import com.epam.calculator.service.time_from_address.TimeFromAddressGoogleImpl
import com.epam.calculator.service.trip.{ConvertorTrip, ConvertorTripForGoogleImpl}
import org.springframework.web.client.RestTemplate

object Constants {
  implicit val restTemplate = new RestTemplate()
  implicit val calculator = CalculatorGoogleImpl(restTemplate:RestTemplate)
  implicit val coordinateMaker = CoordinateGoogleImpl(restTemplate)
  implicit val convertorTrip = ConvertorTripForGoogleImpl()
  implicit val doubleConvertor: DoubleConvertor =DoubleConvertorImpl(convertorTrip:ConvertorTrip, coordinateMaker:Coordinate)
  implicit val timeFromAddress = TimeFromAddressGoogleImpl(doubleConvertor:DoubleConvertor, calculator:Calculator)
  implicit val address = Address.apply("Israel", "Holon", "Golda Meir", 7)
  implicit val address2 = Address.apply("Israel", "Lod", "HaEla", 3)
  implicit val origin = ResponseLocation.apply(31.9604783, 34.8772998)
  implicit val destination = ResponseLocation.apply(32.062010, 34.838190)
  implicit val origins = "31.9604783,34.8772998"
  implicit val destinations = "32.062010,34.838190"
  implicit val tripCoordinateGoogle = TripCoordinatesGoogle.apply(origins, destinations)
  implicit val tripAddress = TripAddress.apply(countryFrom = "Israel",  cityFrom = "Holon",
    streetFrom =  "Golda Meir", buildingFrom =  7,countryTo = "Israel",cityTo =  "Lod", streetTo = "HaEla", buildingTo = 3)
}
