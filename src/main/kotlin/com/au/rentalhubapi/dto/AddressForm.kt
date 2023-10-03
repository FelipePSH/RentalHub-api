package com.au.rentalhubapi.dto

data class AddressForm (
    val id: Long? = null,
    val country: String,
    val city: String ,
    val stateOrProvince: String ,
    val street: String,
    val zipCode: String,
)
