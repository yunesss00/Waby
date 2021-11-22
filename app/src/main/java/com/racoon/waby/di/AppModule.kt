package com.racoon.waby.di

import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesFirestoreInstance() = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun providesBookList(
        firestore: FirebaseFirestore
    ) = firestore.collection("Spot")

}