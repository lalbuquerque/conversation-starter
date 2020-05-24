package com.github.lalbuquerque.pipa.conversationstarter.messenger.handler.resolver

import com.github.lalbuquerque.pipa.conversationstarter.messenger.Messenger
import com.github.lalbuquerque.pipa.conversationstarter.messenger.handler.*

class MessengerHandlerResolver {

    fun getHandlerFor(messenger: Messenger,
                      args: Map<MessengerHandler.Args, Any>): MessengerHandler {

        when (messenger) {
            Messenger.WHATSAPP -> return WhatsAppMessengerHandler(
                args
            )
            Messenger.TELEGRAM -> return TelegramMessengerHandler(
                args
            )
            Messenger.FACEBOOK -> return FacebookMessengerHandler(
                args
            )
            Messenger.SKYPE -> return SkypeMessengerHandler(
                args
            )

            else -> throw UnsupportedOperationException("Messenger not supported yet")
        }
    }
}