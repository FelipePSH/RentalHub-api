package com.au.rentalhubapi.controller

import com.au.rentalhubapi.dto.ResidentView
import com.au.rentalhubapi.model.Resident
import com.au.rentalhubapi.service.ResidentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/resident")
class ResidentController(@Autowired private val residentService:ResidentService) {
    @PostMapping("/create/{bedRoomID}")
    fun addResident(@RequestBody newResident: List<Resident>, @PathVariable bedRoomID: Long)
    : List<Resident>{
        return residentService.addResident(newResident, bedRoomID)
    }


    @GetMapping("/list/{bedroomID}")
    fun listResident(@PathVariable bedroomID: Long): List<ResidentView>{
        return residentService.listResidentByBedroomId(bedroomID)
    }

}