package com.au.rentalhubapi.dto

import com.au.rentalhubapi.model.MonthlyPayment
import java.time.LocalDate

data class ResidentView (
    val id: Long? = null,
    val name: String,
    val email: String,
    val firstDay: LocalDate,
    val monthlyPayments: List<MonthlyPayment>? = ArrayList(),
)