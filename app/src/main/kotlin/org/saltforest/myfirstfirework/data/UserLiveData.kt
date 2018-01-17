package org.saltforest.myfirstfirework.data

import android.arch.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import javax.inject.Inject
import javax.inject.Named

class UserLiveData @Inject constructor(
        @Named("user_ref") private val userRef: DatabaseReference,
        private val auth: FirebaseAuth
) : LiveData<User>(), ValueEventListener {

    override fun onActive() {
        super.onActive()
        val user = auth.currentUser ?: return
        userRef.child(user.uid).addValueEventListener(this)
    }

    override fun onInactive() {
        super.onInactive()
        val user = auth.currentUser ?: return
        userRef.child(user.uid).removeEventListener(this)
    }

    override fun onCancelled(p0: DatabaseError?) {

    }

    override fun onDataChange(ds: DataSnapshot?) {
        value = ds?.getValue(User::class.java) ?: return
    }
}