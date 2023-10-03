package com.au.rentalhubapi.model

import jakarta.persistence.*

@Entity
data class MonthlyPayment(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val month: String, // Pode ser o mês como uma string, por exemplo, "Janeiro 2023"
    val amountPaid: Double,

    @ManyToOne
    @JoinColumn(name = "resident_id") // Associe o pagamento a um residente específico
    val resident: Resident,

    @ManyToOne
    @JoinColumn(name = "apartment_id") // Associe o pagamento ao apartamento específico
    val apartment: Apartment,

    @ManyToOne
    @JoinColumn(name = "expense_id") // Associe o pagamento à despesa correspondente
    val expense: Expense
)