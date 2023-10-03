package com.au.rentalhubapi.service

import com.au.rentalhubapi.dto.ResidentView
import com.au.rentalhubapi.mapper.ResidentViewMapper
import com.au.rentalhubapi.model.Resident
import com.au.rentalhubapi.repository.BedroomRepository
import com.au.rentalhubapi.repository.ResidentRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class ResidentService(
    @Autowired private val residentRepository: ResidentRepository,
    private val bedroomRepository: BedroomRepository,
    private val residentViewMapper: ResidentViewMapper) {

    @Transactional
    fun addResident(newResidents: List<Resident>, bedroomId: Long): List<Resident> {
        val bedroom = bedroomRepository.findById(bedroomId).orElse(null)

        if (bedroom != null) {
            newResidents.forEach { resident ->
                resident.bedroom = bedroom
                residentRepository.save(resident)
            }

            bedroom.residents = bedroom.residents.plus(newResidents)
            bedroomRepository.save(bedroom)
        }

        return newResidents
    }

    fun listResidentByBedroomId(bedroomID: Long): List<ResidentView> {
        val bedroom = bedroomRepository.findById(bedroomID).get()
        val residentsView: MutableList<ResidentView> = mutableListOf()
        bedroom.residents.forEach {
            residentsView.add(
                residentViewMapper.map(it)
            )
        }
        return residentsView
    }

}