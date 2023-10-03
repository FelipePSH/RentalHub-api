package com.au.rentalhubapi.mapper

import com.au.rentalhubapi.dto.ApartmentDetailView
import com.au.rentalhubapi.dto.BedroomView
import com.au.rentalhubapi.model.Apartment
import org.springframework.stereotype.Component

@Component
class ApartmentDetailsMapper: Mapper<Apartment, ApartmentDetailView> {
    override fun map(t: Apartment): ApartmentDetailView {
        return ApartmentDetailView(
            id = t.id,
            description = t.description,
            name = t.name,
            valueRent = t.valueRent,
            address = t.address,
        )
    }
}