 /*
  author Anastasiya
  created on 05/04/2021
  */

package com.epam.calculator.service.convertor_double

import com.epam.calculator.model.api_coordinates.{TripAddress, TripCoordinatesGoogle}

trait DoubleConvertor {
  def convert(tripAddress: TripAddress): TripCoordinatesGoogle

}
