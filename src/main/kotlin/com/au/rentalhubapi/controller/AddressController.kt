package com.au.rentalhubapi.controller

import com.au.rentalhubapi.dto.AddressForm
import com.au.rentalhubapi.model.Address
import com.au.rentalhubapi.service.AddressService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/apartments/address")
class AddressController(@Autowired private val addressService: AddressService) {


    @PutMapping("/update/{apartmentId}")
    fun updateAddress(@PathVariable apartmentId: Long, @RequestBody updatedAddress: AddressForm) {
        addressService.updateAddress(apartmentId, updatedAddress)
    }

    @GetMapping("/{apartmentId}")
    fun findAddressById(@PathVariable apartmentId: Long): Address {
       return addressService.findAddressById(apartmentId)
    }

}