package com.au.rentalhubapi.controller

import com.au.rentalhubapi.dto.BedroomView
import com.au.rentalhubapi.model.Bedroom
import com.au.rentalhubapi.service.BedroomService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/apartments/bedroom")
class BedroomController(@Autowired private val bedroomService: BedroomService) {

    @PostMapping("/{apartmentId}")
    fun addBedroom(@PathVariable apartmentId:Long, @RequestBody newBedroom: List<Bedroom>): List<Bedroom>{
        return bedroomService.addBedroom(newBedroom,apartmentId)
    }

    @GetMapping("/{apartmentId}")
    fun listBedroomsByApartmentId(@PathVariable apartmentId: Long) : List<BedroomView>? {
        return bedroomService.listBedroomsByApartmentId(apartmentId)
    }

    @GetMapping("/{apartmentId}/{bedroomId}")
    fun getBedroomById(@PathVariable apartmentId: Long, @PathVariable bedroomId: Long){
        //TODO:LIST ONE BEDROOM
    }
}