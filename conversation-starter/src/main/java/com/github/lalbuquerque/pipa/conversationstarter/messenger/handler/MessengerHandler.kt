package com.github.lalbuquerque.pipa.conversationstarter.messenger.handler

interface MessengerHandler {

    enum class Args {
        CONTEXT,
        PHONE_NUMBER,
        USER,
        MESSAGE
    }

    fun openMessageView()
}