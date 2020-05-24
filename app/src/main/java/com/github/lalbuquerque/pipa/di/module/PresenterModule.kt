package com.github.lalbuquerque.pipa.di.module

import android.content.Context
import com.github.lalbuquerque.pipa.presenter.MainPresenter
import com.github.lalbuquerque.pipa.presenter.MainPresenterImpl
import com.github.lalbuquerque.pipa.conversationstarter.ConversationStarter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {

    @Provides
    @Singleton
    fun provideMainPresenter(context: Context,
                             conversationStarter: ConversationStarter) : MainPresenter {

        return MainPresenterImpl(conversationStarter, context)
    }
}