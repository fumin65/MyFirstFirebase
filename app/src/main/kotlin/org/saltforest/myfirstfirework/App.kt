package org.saltforest.myfirstfirework

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import org.saltforest.myfirstfirework.di.DaggerAppComponent

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>
            = DaggerAppComponent.create()
}