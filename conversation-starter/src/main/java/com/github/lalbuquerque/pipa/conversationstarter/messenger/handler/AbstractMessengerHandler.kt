package com.github.lalbuquerque.pipa.conversationstarter.messenger.handler

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.content.pm.PackageManager
import android.net.Uri


abstract class AbstractMessengerHandler :
    MessengerHandler {

    abstract fun getPackage() : String

    abstract fun getUri() : String

    abstract fun getContext() : Context

    abstract fun getPlayStoreUri() : String

    override fun openMessageView() {
        if (!appInstalled()) {
            goToPlayStoreAppPage()
            return
        }

        try {
            val context = getContext()
            val intent = Intent(Intent.ACTION_VIEW)

            intent.setPackage(getPackage())
            intent.data = Uri.parse(getUri())
            intent.flags = FLAG_ACTIVITY_NEW_TASK

            context.startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun appInstalled(): Boolean {
        try {
            getContext().packageManager.getPackageInfo(getPackage(), PackageManager.GET_ACTIVITIES)
        } catch (e: PackageManager.NameNotFoundException) {
            return false
        }
        return true
    }

    private fun goToPlayStoreAppPage() {
        val marketUri = Uri.parse(getPlayStoreUri())
        val goToPlayStore = Intent(Intent.ACTION_VIEW, marketUri)
        goToPlayStore.flags = FLAG_ACTIVITY_NEW_TASK
        getContext().startActivity(goToPlayStore)
        return
    }
}