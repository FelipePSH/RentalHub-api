package com.au.rentalhubapi.repository

import com.au.rentalhubapi.model.Address
import org.springframework.data.jpa.repository.JpaRepository

interface AddressRepository: JpaRepository<Address, Long> {
}