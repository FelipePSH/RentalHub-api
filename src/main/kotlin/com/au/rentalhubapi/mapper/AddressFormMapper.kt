package com.au.rentalhubapi.mapper

import com.au.rentalhubapi.dto.AddressForm
import com.au.rentalhubapi.model.Address
import org.springframework.stereotype.Component

@Component
class AddressFormMapper : Mapper<AddressForm, Address>{
    override fun map(t: AddressForm): Address {
       return Address(
           id = t.id,
           street = t.street,
           zipCode = t.zipCode,
           city = t.city,
           stateOrProvince = t.stateOrProvince,
           country = t.country
       )
    }
}