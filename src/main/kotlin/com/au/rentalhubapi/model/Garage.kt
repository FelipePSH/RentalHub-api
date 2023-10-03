package com.au.rentalhubapi.model

import jakarta.persistence.*

@Entity
data class Garage(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val vacancies: String?,
    val description: String?,

    @ManyToOne
    @JoinColumn(name = "resident_id")
    val resident: Resident?
)