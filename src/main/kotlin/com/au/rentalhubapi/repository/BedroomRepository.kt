package com.au.rentalhubapi.repository

import com.au.rentalhubapi.model.Bedroom
import org.springframework.data.jpa.repository.JpaRepository

interface BedroomRepository: JpaRepository<Bedroom, Long> {
}