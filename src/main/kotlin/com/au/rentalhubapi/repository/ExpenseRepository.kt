package com.au.rentalhubapi.repository

import com.au.rentalhubapi.model.Expense
import org.springframework.data.jpa.repository.JpaRepository

interface ExpenseRepository: JpaRepository<Expense, Long> {
}