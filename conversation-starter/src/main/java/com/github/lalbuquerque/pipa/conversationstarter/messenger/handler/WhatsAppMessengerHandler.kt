package com.github.lalbuquerque.pipa.conversationstarter.messenger.handler

import android.content.Context
import java.net.URLEncoder

class WhatsAppMessengerHandler(val args: Map<MessengerHandler.Args, Any>) : AbstractMessengerHandler() {

    override fun getPackage() = "com.whatsapp"

    override fun getPlayStoreUri() = "market://details?id=com.whatsapp"

    override fun getUri() : String {
        val phoneNumber = args[MessengerHandler.Args.PHONE_NUMBER]
        val encodedMessage = URLEncoder.encode(args[MessengerHandler.Args.MESSAGE] as String,
            "UTF-8")

        return "https://api.whatsapp.com/send?phone=$phoneNumber&text=$encodedMessage"
    }

    override fun getContext() = args[MessengerHandler.Args.CONTEXT] as Context

    /* If we need any custom behaviour to open a specific messenger, we just have to override
     * this very method (openMessageView()) with the required behaviour and it's done!
     * We quickly develop our needs without hurting the initial structure proposal.
     */
    override fun openMessageView() {
        super.openMessageView()


    }
}