package com.au.rentalhubapi.repository

import com.au.rentalhubapi.model.Resident
import org.springframework.data.jpa.repository.JpaRepository

interface ResidentRepository: JpaRepository<Resident, Long> {
}