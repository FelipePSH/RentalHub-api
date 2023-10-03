package com.au.rentalhubapi.mapper

import com.au.rentalhubapi.dto.ApartmentForm
import com.au.rentalhubapi.model.Apartment
import org.springframework.stereotype.Component

@Component
class NewApartmentFormMapper: Mapper<ApartmentForm, Apartment> {
    override fun map(t: ApartmentForm): Apartment {
        return Apartment(
            name = t.name ,
            description = t.description,
            valueRent = t.valueRent,
            address = t.address,
            ourDueDate = "12-10-1999"
        )
    }

}