package com.example.apitesting.model

data class BookOrder(
    val bookId: Int,
    val createdBy: String,
    val customerName: String,
    val id: String,
    val quantity: Int,
    val timestamp: Long
)