package com.dinhthi2004.restaurantmanager.model

data class Account(
    val created_at: String,
    val email: String,
    val full_name: String,
    val id: Int,
    val image_url: String,
    val role: Int,
    val sdt: String,
    val token: String,
    val updated_at: String
)