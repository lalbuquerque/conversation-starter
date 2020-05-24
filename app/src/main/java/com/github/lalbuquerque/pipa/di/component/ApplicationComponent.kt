package com.github.lalbuquerque.pipa.di.component

import android.content.Context
import com.github.lalbuquerque.pipa.PipaApplication
import com.github.lalbuquerque.pipa.di.module.ApplicationModule
import com.github.lalbuquerque.pipa.di.module.PresenterModule
import com.github.lalbuquerque.pipa.ui.activity.MainActivity

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, PresenterModule::class))
interface ApplicationComponent {
    fun app(): PipaApplication
    fun context(): Context

    fun inject(application: PipaApplication)
    fun inject(mainActivity: MainActivity)
}
