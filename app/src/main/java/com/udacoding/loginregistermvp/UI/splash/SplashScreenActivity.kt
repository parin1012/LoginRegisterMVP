package com.udacoding.loginregistermvp.UI.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.udacoding.loginregistermvp.MainActivity
import com.udacoding.loginregistermvp.R
import com.udacoding.loginregistermvp.UI.login.LoginActivity
import com.udacoding.loginregistermvp.helper.SessionManager

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val session= SessionManager(this)
        Handler().postDelayed(Runnable {
            if(session.login ?: true){
                startActivity(Intent(this, MainActivity::class.java))
            }else{
                startActivity(Intent(this, LoginActivity::class.java))
            }
            finish()
        }, 2000)

    }
}