/*
  author Anastasiya
  created on 27/03/2021
  */

package com.epam.calculator.service.calculate

import com.epam.calculator.model.api_coordinates.TripCoordinatesGoogle

trait Calculator {
  def calculate(tripCoordinates: TripCoordinatesGoogle): Any

}
