package com.github.lalbuquerque.pipa.conversationstarter.messenger.handler

import android.content.Context

class SkypeMessengerHandler(val args: Map<MessengerHandler.Args, Any>) : AbstractMessengerHandler() {

    override fun getPackage() = "com.skype.raider"

    override fun getPlayStoreUri() = "market://details?id=com.skype.raider"

    override fun getContext() = args[MessengerHandler.Args.CONTEXT] as Context

    override fun getUri() : String {
        val userId = args[MessengerHandler.Args.USER] as String

        return "skype:$userId?chat"
    }
}