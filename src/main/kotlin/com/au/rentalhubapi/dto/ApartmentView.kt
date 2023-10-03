package com.au.rentalhubapi.dto

import com.au.rentalhubapi.model.Address
import com.au.rentalhubapi.model.Expense

data class ApartmentView(
    val id: Long?,
    var name: String?,
    var description: String?,
    var address: Address?,
    var bedrooms: Int? = 2,
    var valueRent: Double?,
    val bills: List<Expense>? = ArrayList()
)
