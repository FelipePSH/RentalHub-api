package com.au.rentalhubapi.dto

import com.au.rentalhubapi.model.Address
import com.au.rentalhubapi.model.Expense

data class ApartmentDetailView(
    var id: Long?,
    var name: String?,
    var description: String?,
    var valueRent: Double?,
    var address: Address,
    var bedrooms: List<BedroomView>? = ArrayList(),
    val expenses: List<Expense> = ArrayList(),
)