package com.au.rentalhubapi.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.time.LocalDate


@Entity
data class Resident(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val email: String,
    val firstDay: LocalDate,

    @OneToMany(mappedBy = "resident")
    val monthlyPayments: List<MonthlyPayment>? = ArrayList(),

    @ManyToOne
    @JoinColumn(name = "bedroom_id")
    @JsonIgnore
    var bedroom: Bedroom?
)
