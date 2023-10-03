package com.au.rentalhubapi.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*

@Entity
data class Bedroom(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val name: String,
    val description: String?,
    val vacancy: Int? = 2,

    @ManyToMany
    @JoinTable(
        name = "bedroom_resident",
        joinColumns = [JoinColumn(name = "bedroom_id")],
        inverseJoinColumns = [JoinColumn(name = "resident_id")]
    )
    var residents: List<Resident> = ArrayList(),

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    @JsonIgnore
    var apartment: Apartment?
)

