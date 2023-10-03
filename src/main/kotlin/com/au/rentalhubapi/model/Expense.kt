package com.au.rentalhubapi.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class Expense(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val value: Double,
    val dueDate: LocalDate,

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    val apartment: Apartment,

    @ManyToMany
    @JoinTable(
        name = "expense_resident",
        joinColumns = [JoinColumn(name = "expense_id")],
        inverseJoinColumns = [JoinColumn(name = "resident_id")]
    )
    val residents: List<Resident> = ArrayList()
)