package org.saltforest.myfirstfirework.ui.profile

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import org.saltforest.myfirstfirework.data.User
import org.saltforest.myfirstfirework.data.UserLiveData
import javax.inject.Inject
import javax.inject.Named

class ProfileViewModel @Inject constructor(
        @Named("user_ref") private val userRef: DatabaseReference,
        private val auth: FirebaseAuth,
        val userLiveData: UserLiveData
) : ViewModel() {

    val firstName = ObservableField<String>()
    val lastName = ObservableField<String>()

    fun apply() {
        val user = auth.currentUser
        user ?: return
        val userData = User(firstName.get(), lastName.get())
        userRef.child(user.uid).setValue(userData)
    }

}