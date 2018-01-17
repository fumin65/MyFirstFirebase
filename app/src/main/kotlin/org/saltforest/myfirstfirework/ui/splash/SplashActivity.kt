package org.saltforest.myfirstfirework.ui.splash

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import dagger.android.AndroidInjection
import org.saltforest.myfirstfirework.ui.profile.ProfileActivity
import org.saltforest.myfirstfirework.ui.signup.SignUpActivity
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject
    internal lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        val intent = Intent(this, if (auth.currentUser == null) {
            SignUpActivity::class.java
        } else {
            ProfileActivity::class.java
        })

        startActivity(intent)
        finish()
    }
}