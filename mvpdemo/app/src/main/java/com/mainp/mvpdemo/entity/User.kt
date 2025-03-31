package com.mainp.mvpdemo.entity

// đối tượng
data class User (
    val fullName: String,
    val password: String,
){
    fun isValid(): Boolean {
        return fullName.isNotBlank() && password.length >= 6
    }
}



