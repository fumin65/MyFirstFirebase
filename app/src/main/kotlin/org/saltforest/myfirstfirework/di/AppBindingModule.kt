package org.saltforest.myfirstfirework.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import org.saltforest.myfirstfirework.ui.profile.ProfileActivity
import org.saltforest.myfirstfirework.ui.profile.ProfileViewModel
import org.saltforest.myfirstfirework.ui.signup.SignUpActivity
import org.saltforest.myfirstfirework.ui.signup.SignUpViewModel
import org.saltforest.myfirstfirework.ui.splash.SplashActivity
import org.saltforest.myfirstfirework.viewmodel.ViewModelFactory

@Module
abstract class AppBindingModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory)
            : ViewModelProvider.Factory

    @ContributesAndroidInjector
    abstract fun contributeSignInActivity(): SignUpActivity

    @Binds
    @IntoMap
    @ViewModelKey(SignUpViewModel::class)
    abstract fun bindSignUpViewModel(signUpViewModel: SignUpViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun contributeSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun contributeProfileActivity(): ProfileActivity

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(profileViewModel: ProfileViewModel): ViewModel
}