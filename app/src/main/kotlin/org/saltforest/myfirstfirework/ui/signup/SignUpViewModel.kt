package org.saltforest.myfirstfirework.ui.signup

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.text.TextUtils
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import org.saltforest.myfirstfirework.data.AuthStateLiveData
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
        private val auth: FirebaseAuth,
        val authStateLiveData: AuthStateLiveData
) : ViewModel() {

    val account = object : ObservableField<String>() {
        override fun set(value: String?) {
            super.set(value)
            updateRegisterEnabled()
        }
    }
    val password = object : ObservableField<String>() {
        override fun set(value: String?) {
            super.set(value)
            updateRegisterEnabled()
        }
    }

    val registerEnabled = ObservableField<Boolean>()

    fun onRegisterBtnClicked() {
        auth.createUserWithEmailAndPassword(account.get(), password.get()).addOnCompleteListener {
            Log.d("test", "create is ${it.isSuccessful}")
        }
    }

    private fun updateRegisterEnabled() {
        registerEnabled.set(!TextUtils.isEmpty(account.get())
                && !TextUtils.isEmpty(password.get()))
    }

}