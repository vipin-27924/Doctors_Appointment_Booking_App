package com.example.project001.core.model

data class doctorModel(
    val name:String,
    val picture:String,
    val special: String,
    val rating: Double = 0.0,
    val experinse : Int = 0,

    )