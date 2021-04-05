/*
  author Anastasiya
  created on 05/04/2021
  */

package com.epam.calculator.service.convertor_double
import com.epam.calculator.model.api_coordinates.{TripAddress, TripCoordinatesGoogle}
import com.epam.calculator.model.request_body_var.Address
import com.epam.calculator.service.coordinate.Coordinate
import com.epam.calculator.service.trip.ConvertorTrip
import org.springframework.stereotype.Service
@Service
case class DoubleConvertorImpl(convertorTrip:ConvertorTrip, coordinate:Coordinate) extends DoubleConvertor {
  override def convert(tripAddress: TripAddress): TripCoordinatesGoogle = {
          val origin = Address.apply(tripAddress.countryFrom, tripAddress.cityFrom, tripAddress.streetFrom, tripAddress.buildingFrom)
          val destination = Address.apply(tripAddress.countryTo, tripAddress.cityTo, tripAddress.streetTo, tripAddress.buildingTo)
          val origins =coordinate.calculateCoordinate(origin: Address)
          val destinations = coordinate.calculateCoordinate(destination: Address)
          convertorTrip.convertToOriginAndDestination(origins, destinations)
  }
}
