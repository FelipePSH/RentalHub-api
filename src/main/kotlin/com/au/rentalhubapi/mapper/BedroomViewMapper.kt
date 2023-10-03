package com.au.rentalhubapi.mapper

import com.au.rentalhubapi.dto.BedroomView
import com.au.rentalhubapi.model.Bedroom
import org.springframework.stereotype.Component

@Component
class BedroomViewMapper: Mapper<Bedroom, BedroomView> {
    override fun map(t: Bedroom): BedroomView {
        return BedroomView(
            id = t.id,
            name = t.name,
            description = t.description,
            residents = t.residents.size,
            vacancy = t.vacancy
        )
    }
}