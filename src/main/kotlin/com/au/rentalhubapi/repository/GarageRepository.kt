package com.au.rentalhubapi.repository

import com.au.rentalhubapi.model.Garage
import org.springframework.data.jpa.repository.JpaRepository

interface GarageRepository: JpaRepository<Garage, Long> {
}