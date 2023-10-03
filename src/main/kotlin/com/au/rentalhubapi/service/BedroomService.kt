package com.au.rentalhubapi.service

import com.au.rentalhubapi.dto.BedroomView
import com.au.rentalhubapi.mapper.BedroomViewMapper
import com.au.rentalhubapi.model.Bedroom
import com.au.rentalhubapi.repository.ApartmentRepository
import com.au.rentalhubapi.repository.BedroomRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BedroomService(@Autowired private val bedroomRepository: BedroomRepository,
    private val apartmentRepository: ApartmentRepository,
    private val bedroomViewMapper: BedroomViewMapper) {

    @Transactional
    fun addBedroom(newBedroom: List<Bedroom>, apartmentId: Long?): List<Bedroom>{
        val apartment = apartmentId?.let { apartmentRepository.findById(it).get() }
        newBedroom.forEach{
            it.apartment = apartment
            bedroomRepository.save(it)
        }
        return newBedroom
    }

    fun listBedroomsByApartmentId(apartmentId: Long): List<BedroomView>? {
        val apartment = apartmentRepository.findById(apartmentId)
        val bedroomsView: MutableList<BedroomView> = mutableListOf()
        return if (apartment.isPresent){
            val mApartment = apartment.get()
            mApartment.bedrooms?.forEach {
                bedroomsView.add(bedroomViewMapper.map(it))
            }
            bedroomsView
        } else {
            null
        }
    }
}