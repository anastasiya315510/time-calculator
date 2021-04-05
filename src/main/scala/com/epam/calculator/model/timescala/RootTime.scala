package com.epam.calculator.model.timescala

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class RootTime  extends Serializable{
                 var destination_addresses: Array[String] = _
                 var origin_addresses: Array[String] = _
                 var rows: Array[Row] = _
                 var status:String = _


  def getDestination_addresses: Array[String] = destination_addresses
  def getOrigin_addresses: Array[String] = origin_addresses
  def getRows: Array[Row] = rows
  def getStatus: String =status

  override def toString = s"RootTime(destination_addresses: $destination_addresses, " +
    s"origin_addresses: $origin_addresses, rows: $rows, status: $status)"
}


object RootTime {
def apply(destination_addresses: Array[String], origin_addresses: Array[String], rows: Array[Row], status:String ): RootTime ={
  this(destination_addresses, origin_addresses, rows, status )
}


  def unApply(rootTime: RootTime): Option[(Array[String], Array[String], Array[Row], String)] = {
    Option.apply(rootTime.destination_addresses, rootTime.origin_addresses, rootTime.rows, rootTime.status)

  }

}