package org.saltforest.myfirstfirework.data

import android.arch.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class AuthStateLiveData @Inject constructor(
        private val auth: FirebaseAuth
) : LiveData<FirebaseUser>() {

    private val listener = FirebaseAuth.AuthStateListener { value = it.currentUser }

    override fun onActive() {
        super.onActive()
        auth.addAuthStateListener(listener)
    }

    override fun onInactive() {
        super.onInactive()
        auth.removeAuthStateListener(listener)
    }
}