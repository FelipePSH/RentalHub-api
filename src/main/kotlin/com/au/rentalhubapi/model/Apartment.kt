package com.au.rentalhubapi.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*


@Entity
data class Apartment(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String?,
    var description: String?,
    var valueRent: Double? = 2000.0,
    var ourDueDate: String,
    @OneToOne(cascade = [CascadeType.ALL])
    var address: Address,
    @OneToMany(mappedBy = "apartment", cascade =  [CascadeType.REMOVE])
    @JsonIgnoreProperties("apartment")
    var bedrooms: List<Bedroom>? = ArrayList(),
    @OneToMany(mappedBy = "apartment", cascade =  [CascadeType.REMOVE])
    @JsonManagedReference
    val expenses: List<Expense> = ArrayList(),
)

