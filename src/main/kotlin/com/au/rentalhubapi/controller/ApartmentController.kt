package com.au.rentalhubapi.controller

import com.au.rentalhubapi.dto.ApartmentDetailView
import com.au.rentalhubapi.dto.ApartmentForm
import com.au.rentalhubapi.dto.ApartmentView
import com.au.rentalhubapi.dto.UpdateApartmentForm
import com.au.rentalhubapi.model.Apartment
import com.au.rentalhubapi.service.ApartmentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
@RequestMapping("/api/apartments")
class ApartmentController(@Autowired private val apartmentService: ApartmentService) {

    @PostMapping("/create")
    fun createApartment(@RequestBody apartment: ApartmentForm): ResponseEntity<ApartmentView> {
        val createdApartment = apartmentService.createApartment(apartment)
        return ResponseEntity(createdApartment, HttpStatus.CREATED)
    }

    @GetMapping("/list")
    fun getAllApartments(): ResponseEntity<List<ApartmentView>> {
        val apartments = apartmentService.getAllApartments()
        return ResponseEntity(apartments, HttpStatus.OK)
    }

    @GetMapping("/{apartmentId}")
    fun getApartmentById(@PathVariable apartmentId: Long): ResponseEntity<ApartmentDetailView?> {
        val apartment =  apartmentService.getApartmentById(apartmentId)
        return ResponseEntity(apartment, HttpStatus.OK)
    }

    @DeleteMapping("/delete/{apartmentId}")
    fun deleteApartmentById(@PathVariable apartmentId: Long) {
        return apartmentService.deleteApartment(apartmentId)
    }

    @PutMapping("/update/{apartmentId}")
    fun updateApartment(@PathVariable apartmentId: Long,
                        @RequestBody updatedApartment: UpdateApartmentForm
    ): ResponseEntity<ApartmentView> {
        val apartment = apartmentService.updateApartment(apartmentId, updatedApartment)
        return ResponseEntity(apartment, HttpStatus.OK)

    }

}
