package com.github.lalbuquerque.pipa.conversationstarter.messenger.handler

import android.content.Context

class TelegramMessengerHandler(val args: Map<MessengerHandler.Args, Any>) : AbstractMessengerHandler() {

    override fun getPackage() = "org.telegram.messenger"

    override fun getPlayStoreUri() = "market://details?id=org.telegram.messenger"

    override fun getContext() = args[MessengerHandler.Args.CONTEXT] as Context

    override fun getUri() : String {
        val userId = args[MessengerHandler.Args.USER] as String

        return "http://telegram.me/$userId"
    }

}