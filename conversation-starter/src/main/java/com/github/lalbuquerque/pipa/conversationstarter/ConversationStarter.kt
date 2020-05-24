package com.github.lalbuquerque.pipa.conversationstarter

import android.content.Context
import com.github.lalbuquerque.pipa.conversationstarter.messenger.Messenger
import com.github.lalbuquerque.pipa.conversationstarter.messenger.handler.MessengerHandler
import com.github.lalbuquerque.pipa.conversationstarter.messenger.handler.resolver.MessengerHandlerResolver
import java.security.InvalidParameterException

class ConversationStarter {

    fun goToWhatsAppMessageView(context: Context?, phoneNumber: String?, message: String? = "") {
        if (context == null && context is Context) throw InvalidParameterException(getContextErrorMessage())

        if (phoneNumber.isNullOrEmpty()) throw InvalidParameterException(getGenericErrorMessage("phoneNumber"))

        val args = LinkedHashMap<MessengerHandler.Args, Any>()
        args[MessengerHandler.Args.CONTEXT] = context as Context
        args[MessengerHandler.Args.PHONE_NUMBER] = phoneNumber
        args[MessengerHandler.Args.MESSAGE] = message as String

        val whatsAppMessengerHandler = MessengerHandlerResolver()
            .getHandlerFor(Messenger.WHATSAPP, args)

        whatsAppMessengerHandler.openMessageView()
    }

    fun goToTelegramMessageView(context: Context?, userId: String? = "") {
        if (context == null && context is Context) throw InvalidParameterException(getContextErrorMessage())

        if (userId.isNullOrEmpty()) throw InvalidParameterException(getGenericErrorMessage("userId"))

        val args = LinkedHashMap<MessengerHandler.Args, Any>()
        args[MessengerHandler.Args.CONTEXT] = context as Context
        args[MessengerHandler.Args.USER] = userId

        val telegramMessengerHandler = MessengerHandlerResolver()
            .getHandlerFor(Messenger.TELEGRAM, args)

        telegramMessengerHandler.openMessageView()
    }

    fun goToFacebookMessageView(context: Context?, phoneNumber: String? = "", userId: String? = "") {
        if (context == null && context is Context) throw InvalidParameterException(getContextErrorMessage())

        if (phoneNumber.isNullOrEmpty() && userId.isNullOrEmpty()) {
            throw InvalidParameterException(getPairGenericErrorMessage("phoneNumber",
                "userId"))
        }

        val args = LinkedHashMap<MessengerHandler.Args, Any>()
        args[MessengerHandler.Args.CONTEXT] = context as Context
        args[MessengerHandler.Args.USER] = userId as String
        args[MessengerHandler.Args.PHONE_NUMBER] = phoneNumber as String

        val facebookMessengerHandler = MessengerHandlerResolver()
            .getHandlerFor(Messenger.FACEBOOK, args)

        facebookMessengerHandler.openMessageView()
    }

    fun goToSkypeMessageView(context: Context?, userName: String?) {
        if (context == null && context is Context) throw InvalidParameterException(getContextErrorMessage())

        if (userName.isNullOrEmpty()) throw InvalidParameterException(getGenericErrorMessage("userName"))

        val args = LinkedHashMap<MessengerHandler.Args, Any>()
        args[MessengerHandler.Args.CONTEXT] = context as Context
        args[MessengerHandler.Args.USER] = userName

        val skypeMessengerHandler = MessengerHandlerResolver()
            .getHandlerFor(Messenger.SKYPE, args)

        skypeMessengerHandler.openMessageView()
    }

    private fun getContextErrorMessage() = "Argument [context] cannot be null or invalid"

    private fun getGenericErrorMessage(argName: String) = "Argument [$argName] cannot be null or " +
            "empty"

    private fun getPairGenericErrorMessage(argName1: String, argName2: String) = "You must" +
            " inform at leat one of these two arguments: [$argName1] or [$argName2] "
}