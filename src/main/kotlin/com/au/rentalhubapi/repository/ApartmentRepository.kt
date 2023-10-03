package com.au.rentalhubapi.repository

import com.au.rentalhubapi.model.Apartment
import org.springframework.data.jpa.repository.JpaRepository

interface ApartmentRepository: JpaRepository<Apartment, Long> {

}