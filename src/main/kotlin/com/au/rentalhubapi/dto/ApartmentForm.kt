package com.au.rentalhubapi.dto

import com.au.rentalhubapi.model.Address
import com.au.rentalhubapi.model.Bedroom

data class ApartmentForm (
    var name: String?,
    var description: String?,
    var valueRent: Double? = 2000.0,
    var address: Address,
    var bedrooms: List<Bedroom> = ArrayList(),
    val garageQuantity: Int
)