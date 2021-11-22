package com.racoon.waby.data.repository

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.racoon.waby.data.model.Spot
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SpotsRepository @Inject  constructor(private val bookList : CollectionReference){

    fun addNewSpot(spot : Spot){
        try {
            bookList.document(spot.idSpot).set(spot)
        }catch (e : Exception){
            e.printStackTrace()
        }

    }
}