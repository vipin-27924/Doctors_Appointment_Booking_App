package com.example.project001.core.model

data class doctorModel(
    val Name: String?= null,
    val Picture: String? = null ,
    val Special: String? = null,
    val Rating: Double? = 0.0,
    val Expriense: Int? = 0,
    val Biography: String? = null,
    val Id: Int? = 0,
    val Location : String = "",
    val Mobile : String = "",
    val Patients: Int? = 0

)