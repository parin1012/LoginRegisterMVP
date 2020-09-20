package com.udacoding.loginregistermvp.UI.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.udacoding.loginregistermvp.MainActivity
import com.udacoding.loginregistermvp.R
import com.udacoding.loginregistermvp.UI.login.model.DataItem
import com.udacoding.loginregistermvp.UI.login.presenter.LoginPresenter
import com.udacoding.loginregistermvp.UI.login.presenter.LoginView
import com.udacoding.loginregistermvp.UI.register.view.RegisterActivity
import com.udacoding.loginregistermvp.helper.SessionManager
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {

    private var presenter : LoginPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = LoginPresenter(this)
        linkRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        btnLogin.setOnClickListener {
            val email = eEmail.text.toString()
            val password = ePassword.text.toString()
            presenter?.login(email,password)
        }
    }

    override fun loginSucces(msg: String, user: List<DataItem?>) {
        val session = SessionManager(this)
        session.email = user.get(0)?.userEmail
        session.nama = user.get(0)?.userNama
        session.hp = user.get(0)?.userHp
        session.login = true
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun erorLogin(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }
}