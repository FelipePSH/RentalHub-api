package com.au.rentalhubapi.repository

import com.au.rentalhubapi.model.MonthlyPayment
import org.springframework.data.jpa.repository.JpaRepository

interface MonthlyPaymentRepository: JpaRepository<MonthlyPayment, Long> {
}