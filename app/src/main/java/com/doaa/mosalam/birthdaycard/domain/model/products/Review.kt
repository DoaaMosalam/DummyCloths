package com.doaa.mosalam.birthdaycard.domain.model.products

data class Review(
    val comment: String,
    val date: String,
    val rating: Int,
    val reviewerEmail: String,
    val reviewerName: String
)