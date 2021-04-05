/*
  author Anastasiya
  created on 27/03/2021
  */

package com.epam.calculator.service.coordinate


import com.epam.calculator.model.api_coordinates.ResponseLocation
import com.epam.calculator.model.request_body_var.Address

trait Coordinate {
  def calculateCoordinate(address: Address): ResponseLocation

}
