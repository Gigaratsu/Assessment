package com.thedomain.benboyceassessment

class Currency(
    /**
     * Currency object contains
     * code
     * name
     * symbol
     */


    var code: String, var name: String, var symbol: String
) {
    override fun toString(): String {
        return "Currency(code='$code', name='$name', symbol='$symbol')"
    }
}