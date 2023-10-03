package com.au.rentalhubapi.mapper

import com.au.rentalhubapi.dto.ResidentView
import com.au.rentalhubapi.model.Resident
import org.springframework.stereotype.Component

@Component
class ResidentViewMapper: Mapper<Resident, ResidentView > {
    override fun map(t: Resident): ResidentView {
        return ResidentView(
            id = t.id,
            email = t.email,
            name = t.name,
            firstDay = t.firstDay,
        )
    }
}