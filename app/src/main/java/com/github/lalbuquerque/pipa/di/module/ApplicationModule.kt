package com.github.lalbuquerque.pipa.di.module

import android.content.Context
import com.github.lalbuquerque.pipa.PipaApplication
import com.github.lalbuquerque.pipa.conversationstarter.ConversationStarter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(var application: PipaApplication) {

    @Provides
    @Singleton
    fun provideApp(): PipaApplication = application

    @Provides
    @Singleton
    fun provideContext(): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideConversationStarter() = ConversationStarter()

}
