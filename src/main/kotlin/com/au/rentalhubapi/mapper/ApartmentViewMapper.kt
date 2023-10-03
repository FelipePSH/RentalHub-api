package com.au.rentalhubapi.mapper

import com.au.rentalhubapi.dto.ApartmentView
import com.au.rentalhubapi.model.Apartment
import org.springframework.stereotype.Component

@Component
class ApartmentViewMapper: Mapper<Apartment, ApartmentView> {
    override fun map(t: Apartment): ApartmentView {
        return ApartmentView(
            id = t.id,
            name = t.name,
            description = t.description,
            address = t.address,
            bedrooms = t.bedrooms?.size,
            valueRent = t.valueRent
            //TODO: ADD DUE DATE OF RENT TO THE COMPANY
        )
    }
}