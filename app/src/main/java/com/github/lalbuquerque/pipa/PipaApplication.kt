package com.github.lalbuquerque.pipa

import android.app.Application
import com.github.lalbuquerque.pipa.di.module.ApplicationModule
import com.github.lalbuquerque.pipa.di.component.ApplicationComponent
import com.github.lalbuquerque.pipa.di.component.DaggerApplicationComponent
import com.github.lalbuquerque.pipa.di.module.PresenterModule

class PipaApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .presenterModule(PresenterModule())
            .build()

        component?.inject(this)
    }

    companion object {
        @JvmStatic var component: ApplicationComponent? = null
    }
}

