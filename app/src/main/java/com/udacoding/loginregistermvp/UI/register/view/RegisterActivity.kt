package com.udacoding.loginregistermvp.UI.register.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.udacoding.loginregistermvp.R
import com.udacoding.loginregistermvp.UI.login.LoginActivity
import com.udacoding.loginregistermvp.UI.register.model.ResponseRegister
import com.udacoding.loginregistermvp.UI.register.presenter.RegisterPresenter
import com.udacoding.loginregistermvp.UI.register.presenter.RegisterView
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), RegisterView {

    private var presenter : RegisterPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        presenter = RegisterPresenter(this)
        btnSignup.setOnClickListener {
            val nama = eNama.text.toString()
            val email = eEmail.text.toString()
            val password = ePassword.text.toString()
            val passwordConfirm = ePasswordConfirm.text.toString()
            val hp = eHp.text.toString()
            presenter?.register(nama, email, hp, password, passwordConfirm)
            //Toast.makeText(this,"Tes", Toast.LENGTH_SHORT).show()
        }
    }

    override fun succesRegister(response: ResponseRegister) {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    override fun erorRegister(msg: String) {
        showToast(msg)
    }

    override fun empty() {
        showToast("Tidak boleh ada yang kososng")
    }

    override fun notMatch() {
        showToast("Password tidak cocok")
    }

    override fun startProgressBar() {
        progress.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progress.visibility = View.GONE
    }

    fun showToast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}