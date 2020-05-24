package com.github.lalbuquerque.pipa.presenter

import android.content.Context
import com.github.lalbuquerque.pipa.ui.view.MainView
import com.github.lalbuquerque.pipa.conversationstarter.ConversationStarter
import java.lang.Exception
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(private val conversationStarter: ConversationStarter,
                                            private val context: Context) : MainPresenter {

    private var view: MainView? = null

    override fun initView(view: MainView) {
        this.view = view
    }

    override fun onWhatsAppButtonClick(phoneNumber: String, message: String) {
        try {
            conversationStarter.goToWhatsAppMessageView(context, phoneNumber, message)
        } catch (e: Exception) {
            view?.showError(e.message ?: "")
        }
    }

    override fun onTelegramButtonClick(userId: String) {
        try {
            conversationStarter.goToTelegramMessageView(context, userId)
        } catch (e: Exception) {
            view?.showError(e.message ?: "")
        }
    }

    override fun onFacebookButtonClick(userId: String, phoneNumber: String) {
        try {
            conversationStarter.goToFacebookMessageView(context, phoneNumber, userId)
        } catch (e: Exception) {
            view?.showError(e.message ?: "")
        }
    }

    override fun onSkypeButtonClick(userName: String) {
        try {
            conversationStarter.goToSkypeMessageView(context, userName)
        } catch (e: Exception) {
            view?.showError(e.message ?: "")
        }
    }
}