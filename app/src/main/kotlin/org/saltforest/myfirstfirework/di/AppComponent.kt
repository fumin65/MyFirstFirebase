package org.saltforest.myfirstfirework.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import org.saltforest.myfirstfirework.App

@Component(modules = [
    AndroidInjectionModule::class,
    AppBindingModule::class,
    AppModule::class
])
interface AppComponent : AndroidInjector<App>