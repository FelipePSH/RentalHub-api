package com.au.rentalhubapi.dto

import com.au.rentalhubapi.model.Resident

data class BedroomView(
    var id: Long? = null,
    val name: String,
    val description: String?,
    val vacancy: Int? = 2,
    var residents: Int?,
)
