package com.au.rentalhubapi.service

import com.au.rentalhubapi.dto.ApartmentDetailView
import com.au.rentalhubapi.dto.ApartmentForm
import com.au.rentalhubapi.dto.ApartmentView
import com.au.rentalhubapi.dto.UpdateApartmentForm
import com.au.rentalhubapi.mapper.ApartmentDetailsMapper
import com.au.rentalhubapi.mapper.ApartmentViewMapper
import com.au.rentalhubapi.mapper.NewApartmentFormMapper
import com.au.rentalhubapi.model.Apartment
import com.au.rentalhubapi.repository.ApartmentRepository
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ApartmentService(@Autowired private val apartmentRepository: ApartmentRepository,
    private val bedroomService: BedroomService,
    private val addressService: AddressService,
    private val apartmentFormMapper: NewApartmentFormMapper,
    private val apartmentViewMapper: ApartmentViewMapper,
    private val apartmentDetailViewMapper: ApartmentDetailsMapper) {

    @Transactional
    fun createApartment(apartment: ApartmentForm): ApartmentView {
        val newApartment = apartmentFormMapper.map(apartment)
        apartmentRepository.save(newApartment)
        bedroomService.addBedroom(apartment.bedrooms, newApartment.id)
        addressService.addAddress(newApartment.address)
        apartmentRepository.flush()
        return apartmentViewMapper.map(newApartment)
    }

    fun getApartmentById(id: Long): ApartmentDetailView? {
        val apartment = apartmentRepository.findById(id).orElse(null)
        val bedrooms = bedroomService.listBedroomsByApartmentId(id)
        val mountApartment = apartmentDetailViewMapper.map(apartment)
        mountApartment.bedrooms = bedrooms
        return mountApartment
    }

    @Transactional
    fun deleteApartment(id: Long) {
        apartmentRepository.deleteById(id)
    }

    fun getAllApartments(): List<ApartmentView> {
        val allApartments = apartmentRepository.findAll()
        val apartmentsView: MutableList<ApartmentView> = mutableListOf()

        allApartments.forEach { apartment ->
            apartmentsView.add(apartmentViewMapper.map(apartment))
        }

        return apartmentsView
    }

    @Transactional
    fun updateApartment(id: Long, updatedApartment: UpdateApartmentForm): ApartmentView? {
        val existingApartment = apartmentRepository.findById(id)
        return if (existingApartment.isPresent) {
            val apartmentToUpdate = existingApartment.get()

            apartmentToUpdate.name = updatedApartment.name
            apartmentToUpdate.description = updatedApartment.description
            apartmentToUpdate.valueRent = updatedApartment.valueRent

            apartmentRepository.save(apartmentToUpdate)
            apartmentViewMapper.map(apartmentToUpdate)
        } else {
            null
        }
    }

}