/*
  author Anastasiya
  created on 31/03/2021
  */

package com.epam.calculator.model.timescala

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Row  extends Serializable {
    var elements: Array[Element] = _

    def getElements: Array[Element] = elements

    override def toString = s"Row($getElements, )" + elements.foreach(el=>el.duration_in_traffic.text)
}


object Row {
    def apply(elements: Array[Element]):Row = this(elements)

    def unApply(rows: Row): Option[Array[Element]] = {
        Option.apply(rows.elements)

    }
}


