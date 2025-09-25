package com.example.project001.core.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.project001.core.model.CategoryModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainViewModel: ViewModel() {
    private val db = FirebaseDatabase.getInstance()
    private val _categories = MutableLiveData<List<CategoryModel>>()
    val Category: LiveData<List<CategoryModel>> = _categories
    private var categoryLoaded = false

    fun loadCategories(force: Boolean = false) {
        if (categoryLoaded && !force) {
            return
        }

        val ref = db.getReference("categories")
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
}