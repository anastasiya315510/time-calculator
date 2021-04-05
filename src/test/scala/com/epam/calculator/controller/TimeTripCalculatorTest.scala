package com.epam.calculator.controller

import com.epam.calculator.constants.Constants
import com.epam.calculator.constants.Constants.{address, address2, calculator, convertorTrip, coordinateMaker, destination, destinations, origin, origins, timeFromAddress, tripCoordinateGoogle}
import com.epam.calculator.model.api_coordinates.{ResponseLocation, TripCoordinatesGoogle}
import com.epam.calculator.model.timescala.{Duration, DurationInTraffic}
import org.scalatest.FunSuite

class TimeTripCalculatorTest extends FunSuite {



  test("testTimeFromAddress") {
    //todo if we pass null
   val res =  timeFromAddress.convert(Constants.tripAddress)
    assert(res.isInstanceOf[Duration])
//    val res1 = timeFromAddress.convert(null)
//    assert(res.isInstanceOf[IncorrectRequest])
  }

  test("testTimeCalculator") {
    //todo check Traffic
   val res =  calculator.calculate(tripCoordinateGoogle)
    assert(res.isInstanceOf[Duration])
    val res1 = calculator.calculate(null)
    assert(res.isInstanceOf[Duration])
  }

  test("testConvertorTrip") {
    val res = convertorTrip.convertToOriginAndDestination(origin, destination)
    assert(res.isInstanceOf[TripCoordinatesGoogle])
  }

  test("testConvertorTripIsNull") {
    val res = convertorTrip.convertToOriginAndDestination(null, null)
    assert(res.isInstanceOf[TripCoordinatesGoogle])
  }

  test("testLogger") {
    //todo
  }

  test("testCoordinate") {
    val res =coordinateMaker.calculateCoordinate(address)
    assert(res.isInstanceOf[ResponseLocation])
    assert(res.lat==32.0122878)
    assert(res.lng==34.7794304)
  }

  test("testConvertAddressToCoordinate") {
    //todo if we pass null
   val res = coordinateMaker.calculateCoordinate(address2)
    assert(res.lat==31.9466434)
    assert(res.lng==34.90582)
    res.isInstanceOf[TripCoordinatesGoogle]
  }

  test("testCalculator") {
    val res = calculator.calculate(TripCoordinatesGoogle.apply(origins, destinations))
    assert(res.isInstanceOf[Duration])
    res.asInstanceOf[Duration].value >10
  }
  test("testCalculatorInTraffic") {
//    assert(res.isInstanceOf[Duration])
    //todo
  }



}
