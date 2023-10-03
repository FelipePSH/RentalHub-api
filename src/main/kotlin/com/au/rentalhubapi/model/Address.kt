package com.au.rentalhubapi.model

import jakarta.persistence.*

@Entity
data class Address(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var country: String = "Australia",
    var city: String = "Melbourne",
    var stateOrProvince: String = "Victoria",
    @Column(nullable = false)
    var street: String,
    @Column(nullable = false)
    var zipCode: String,
)
