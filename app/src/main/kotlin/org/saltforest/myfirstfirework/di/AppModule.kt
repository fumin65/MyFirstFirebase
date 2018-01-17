package org.saltforest.myfirstfirework.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class AppModule {

    @Provides
    fun provideAuth() = FirebaseAuth.getInstance()

    @Provides
    fun provideDb() = FirebaseDatabase.getInstance()

    @Provides
    @Named("user_ref")
    fun provideUserRef(db: FirebaseDatabase) = db.reference.child("user")

}