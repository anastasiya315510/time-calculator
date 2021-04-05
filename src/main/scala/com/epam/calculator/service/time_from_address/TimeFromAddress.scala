/*
  author Anastasiya
  created on 05/04/2021
  */

package com.epam.calculator.service.time_from_address

import com.epam.calculator.model.api_coordinates.TripAddress

trait TimeFromAddress {
  def convert(tripAddress: TripAddress): Any

}
