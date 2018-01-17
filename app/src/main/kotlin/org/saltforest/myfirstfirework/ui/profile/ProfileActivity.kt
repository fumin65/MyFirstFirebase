package org.saltforest.myfirstfirework.ui.profile

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import org.saltforest.myfirstfirework.R
import org.saltforest.myfirstfirework.databinding.ActivityProfileBinding
import org.saltforest.myfirstfirework.viewmodel.ViewModelFactory
import javax.inject.Inject

class ProfileActivity : AppCompatActivity() {

    @Inject
    internal lateinit var factory: ViewModelFactory

    private val viewModel: ProfileViewModel by lazy {
        ViewModelProviders.of(this, factory).get(ProfileViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityProfileBinding>(
                this, R.layout.activity_profile)
        binding.viewModel = viewModel
        viewModel.userLiveData.observe(this, Observer {
            it ?: return@Observer
            binding.firstName.setText(it.firstName)
            binding.lastName.setText(it.lastName)
        })
    }
}