/*
  author Anastasiya
  created on 01/04/2021
  */

package com.epam.calculator.model.coordinates_scala

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Root{
  var results: Array[Result] =_
  var  status: String =_
  def getResults: Array[Result]=results
  def getStatus: String=status

  override def toString = s"Root($results, $status)"
}

object Root{
  def apply(results: Array[Result], status:String):Root=this(results, status)
  def unApply(root: Root):Option[(Array[Result], String)]={
    Option.apply(root.results, root.status)
  }
}
