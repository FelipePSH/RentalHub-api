package com.au.rentalhubapi.service

import com.au.rentalhubapi.dto.AddressForm
import com.au.rentalhubapi.mapper.AddressFormMapper
import com.au.rentalhubapi.mapper.NewApartmentFormMapper
import com.au.rentalhubapi.model.Address
import com.au.rentalhubapi.repository.AddressRepository
import com.au.rentalhubapi.repository.ApartmentRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AddressService(@Autowired private val addressRepository: AddressRepository,
                     private val apartmentRepository: ApartmentRepository,
                    private val addressFormMapper: AddressFormMapper) {

    @Transactional
    fun addAddress(newAddress: Address): Address{
        return addressRepository.save(newAddress)
    }

    @Transactional
    fun updateAddress(id: Long, newAddress: AddressForm): Address? {
        val apartment = apartmentRepository.findById(id).get()
        val existingAddress = apartment.address.id?.let { addressRepository.findById(it) }

        return if (existingAddress != null && existingAddress.isPresent) {
            val addressToUpdate =  existingAddress.get()
            val newAddressMapped = addressFormMapper.map(newAddress)
            addressToUpdate.city = newAddressMapped.city
            addressToUpdate.country = newAddressMapped.country
            addressToUpdate.stateOrProvince = newAddressMapped.stateOrProvince
            addressToUpdate.zipCode = newAddressMapped.zipCode
            addressToUpdate.street = newAddressMapped.street

            addressRepository.save(addressToUpdate)
        } else {
            null
        }
    }

    fun findAddressById(id: Long): Address {
        val apartment = apartmentRepository.findById(id).get()
        return apartment.address
    }

}