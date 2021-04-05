/*
  author Anastasiya
  created on 27/03/2021
  */

package com.epam.calculator.controller
import com.epam.calculator.model.api_coordinates.{IncorrectRequest, ResponseLocation, TripAddress, TripCoordinatesGoogle}
import com.epam.calculator.model.request_body_var.Address
import com.epam.calculator.model.timescala.Duration
import com.epam.calculator.service.calculate.Calculator
import com.epam.calculator.service.convertor_double.DoubleConvertor
import com.epam.calculator.service.coordinate.Coordinate
import com.epam.calculator.service.time_from_address.TimeFromAddress
import com.epam.calculator.service.trip.ConvertorTrip
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.{PostMapping, RequestBody, RestController}


@RestController
case class TimeTripCalculator(calculator:Calculator,
                              coordinate:Coordinate,
                              convertorTrip:ConvertorTrip,
                              timeFromAddress:TimeFromAddress,
                              doubleConvertor:DoubleConvertor) {

  val logger:Logger = LoggerFactory.getLogger(this.getClass)

  @PostMapping(value = Array("/address"))
  def convertAddressToCoordinate( @RequestBody address: Address): ResponseLocation = {
    if(address==null) {
      logger.warn(" "+this.getClass+" convertAddressToCoordinate method, address is not correct "+address)
      ResponseLocation.apply(0.0, 0.0)
    }
    else coordinate.calculateCoordinate(address: Address)

  }



  @PostMapping(value = Array("/double"), consumes = Array(MediaType.APPLICATION_JSON_VALUE))
  def convertToOriginAndDestinationCoordinates(@RequestBody tripAddress: TripAddress): TripCoordinatesGoogle = {
    if(tripAddress==null){
      logger.warn(" "+this.getClass+" convertToOriginAndDestinationCoordinates method, address is not correct "+tripAddress)
      TripCoordinatesGoogle.apply("0.0, 0.0", "0.0, 0.0")
    }else{

        doubleConvertor.convert(tripAddress)
    }
  }

  @PostMapping(value = Array("/time"), consumes = Array(MediaType.APPLICATION_JSON_VALUE))
  def timeCalculator(@RequestBody tripCoordinates: TripCoordinatesGoogle): Any = {
    if(tripCoordinates==null|| tripCoordinates.origins==""||tripCoordinates.destinations==""){
      logger.warn(" "+this.getClass+" timeCalculator method, address is not correct "+tripCoordinates)
      Duration.apply("0 min", 0)
    }
    else calculator.calculate(tripCoordinates)
  }

  @PostMapping(value = Array("/crd/time"), consumes = Array(MediaType.APPLICATION_JSON_VALUE))
  def timeFromAddress(@RequestBody tripAddress: TripAddress):Any ={
        if(tripAddress==null) {
          logger.warn(" "+this.getClass+" timeFromAddress method, tripAddress is not correct "+tripAddress)
          return IncorrectRequest
        }
   timeFromAddress.convert(tripAddress)

  }
}