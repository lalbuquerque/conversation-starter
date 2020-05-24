package com.github.lalbuquerque.pipa.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.github.lalbuquerque.pipa.PipaApplication
import com.github.lalbuquerque.pipa.R
import com.github.lalbuquerque.pipa.presenter.MainPresenter
import com.github.lalbuquerque.pipa.ui.view.MainView
import com.google.android.material.snackbar.Snackbar

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {
    @Inject lateinit var presenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        PipaApplication.component?.inject(this)
    }

    override fun onStart() {
        super.onStart()

        presenter.initView(this)

        btn_submit_whatsapp.setOnClickListener {
            presenter.onWhatsAppButtonClick(phoneNumber = tiet_whatsapp_phone.text.toString(),
                message = tiet_whatsapp_message.text.toString())
        }

        btn_submit_telegram.setOnClickListener {
            presenter.onTelegramButtonClick(userId = tiet_telegram_userid.text.toString())
        }

        btn_submit_facebook.setOnClickListener {
            presenter.onFacebookButtonClick(userId = tiet_facebook_userid.text.toString(),
                phoneNumber = tiet_facebook_phone.text.toString())
        }

        btn_submit_skype.setOnClickListener {
            presenter.onSkypeButtonClick(userName = tiet_skype_username.text.toString())
        }
    }

    override fun showError(errorMessage: String) {
        Snackbar.make(findViewById(android.R.id.content), errorMessage, Snackbar.LENGTH_LONG).show()
        Log.e(
            MainActivity::class.java.name, "[conversationStarter." +
                "goToWhatsAppMessageView()] $$errorMessage ")
    }

}
