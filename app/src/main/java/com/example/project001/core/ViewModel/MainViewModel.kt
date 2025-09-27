package com.example.project001.core.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.project001.core.model.CategoryModel
import com.example.project001.core.model.doctorModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainViewModel : ViewModel() {
    private val db = FirebaseDatabase.getInstance()
    private val _categories = MutableLiveData<List<CategoryModel>>()
    val Category: LiveData<List<CategoryModel>> = _categories

    private val _doctors = MutableLiveData<List<doctorModel>>()
    val doctors: LiveData<List<doctorModel>> = _doctors
    private var categoryLoaded = false
    private var doctorsLoaded = false

    fun loadCategories(force: Boolean = false) {
        if (categoryLoaded && !force) {
            return
        }

        val ref = db.getReference("Category")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val items = mutableListOf<CategoryModel>()
                for (child in snapshot.children) {
                    child.getValue(CategoryModel::class.java)?.let { items.add(it) }
                }
                _categories.value = items
                categoryLoaded = true
            }

            override fun onCancelled(error: DatabaseError) {
                categoryLoaded = false
            }
        })
    }

    fun loadDoctors(force: Boolean = false) {
        if (doctorsLoaded && !force) {
            return
        }
        val ref = db.getReference("Doctors")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d("Firebase", "onDataChange called for Doctors")
                if (snapshot.exists()) {
                    val items = mutableListOf<doctorModel>()
                    for (child in snapshot.children) {
                        Log.d("Firebase", "Child snapshot: ${child.toString()}")
                        try {
                            val doctor = child.getValue(doctorModel::class.java)
                            if (doctor != null) {
                                items.add(doctor)
                                Log.d("Firebase", "Successfully parsed doctor: $doctor")
                            } else {
                                Log.w("Firebase", "Parsed doctor is null for child: ${child.key}")
                            }
                        } catch (e: Exception) {
                            Log.e("Firebase", "Error parsing doctor for child: ${child.key}", e)
                        }
                    }
                    _doctors.value = items
                    doctorsLoaded = true
                    Log.d("Firebase", "Finished loading doctors. Total count: ${items.size}")
                } else {
                    Log.w("Firebase", "Snapshot for Doctors does not exist.")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("Firebase", "Database read for Doctors was cancelled: ${error.message}")
                doctorsLoaded = false
            }
        })
    }
}