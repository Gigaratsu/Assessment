package com.thedomain.benboyceassessment

class Country (
    var capital: String,
    var code: String,
    var currency: Currency,
    var flag: String,
    var language: Language,
    var name: String,
    var region: String
) {
    /**
     * Country object contains:
     * capital
     * code
     * Currency - Object class
     * flag
     * Language - Object class
     * name
     */

    override fun toString(): String {
        return "Country(Region='$region', capital='$capital', code='$code', currency=$currency, flag='$flag', language=$language, name='$name')"
    }
}