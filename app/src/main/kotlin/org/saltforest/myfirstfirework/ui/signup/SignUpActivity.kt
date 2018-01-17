package org.saltforest.myfirstfirework.ui.signup

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import dagger.android.AndroidInjection
import org.saltforest.myfirstfirework.R
import org.saltforest.myfirstfirework.databinding.ActivitySignUpBinding
import org.saltforest.myfirstfirework.viewmodel.ViewModelFactory
import javax.inject.Inject

class SignUpActivity : AppCompatActivity() {

    @Inject
    internal lateinit var factory: ViewModelFactory

    private val viewModel: SignUpViewModel by lazy {
        ViewModelProviders.of(this, factory).get(SignUpViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivitySignUpBinding>(
                this, R.layout.activity_sign_up)
        binding.viewModel = viewModel

        viewModel.authStateLiveData.observe(this, Observer {
            if (it == null) {
                Log.d("test", "no user")
            } else {
                Log.d("test", "user id : ${it.uid}")
            }
        })
    }
}