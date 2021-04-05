/*
  author Anastasiya
  created on 05/04/2021
  */

package com.epam.calculator.service.time_from_address
import com.epam.calculator.model.api_coordinates.{IncorrectRequest, TripAddress}
import com.epam.calculator.service.calculate.Calculator
import com.epam.calculator.service.convertor_double.DoubleConvertor
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.stereotype.Service
@Service
case class TimeFromAddressGoogleImpl(doubleConvertor:DoubleConvertor, calculator:Calculator) extends TimeFromAddress {


  val logger:Logger = LoggerFactory.getLogger(this.getClass)
  override def convert(tripAddress: TripAddress): Any = {

    val tripCoordinates =doubleConvertor.convert(tripAddress)
    if(tripCoordinates.destinations==""||tripCoordinates.origins==""||tripCoordinates==null) {
      logger.warn(" "+this.getClass+" convertAddressToCoordinate method, ripCoordinates is not correct "+tripCoordinates)
            return IncorrectRequest
          }
    calculator.calculate(tripCoordinates)
  }
}
