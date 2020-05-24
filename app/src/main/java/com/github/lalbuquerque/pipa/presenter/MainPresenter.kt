package com.github.lalbuquerque.pipa.presenter

import com.github.lalbuquerque.pipa.ui.view.MainView

interface MainPresenter {

    fun initView(view: MainView)

    fun onWhatsAppButtonClick(phoneNumber: String, message: String)
    fun onTelegramButtonClick(userId: String)
    fun onFacebookButtonClick(userId: String, phoneNumber: String)
    fun onSkypeButtonClick(userName: String)
}