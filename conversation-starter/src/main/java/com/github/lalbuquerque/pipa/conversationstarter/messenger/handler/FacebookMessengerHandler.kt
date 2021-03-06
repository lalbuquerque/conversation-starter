package com.github.lalbuquerque.pipa.conversationstarter.messenger.handler

import android.content.Context

class FacebookMessengerHandler(val args: Map<MessengerHandler.Args, Any>) : AbstractMessengerHandler() {

    override fun getPackage() = "com.facebook.orca"

    override fun getPlayStoreUri() = "market://details?id=com.facebook.orca"

    override fun getContext() = args[MessengerHandler.Args.CONTEXT] as Context

    override fun getUri() : String {
        val userId = args[MessengerHandler.Args.USER] as String
        val phoneNumber = args[MessengerHandler.Args.PHONE_NUMBER] as String

        return "https://m.me/${ if (userId.isEmpty()) phoneNumber else userId }"
    }
}