package com.vidya.aplikasipengaduan

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.provider.MediaStore
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text



class LoginActivity : AppCompatActivity() {


    lateinit var et_username: EditText
    lateinit var et_pass: EditText


    lateinit var btn_log: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        et_username = findViewById(R.id.et_username)as EditText
        et_pass = findViewById(R.id.et_pass);
        btn_log = findViewById(R.id.btn_log);

        btn_log.setOnClickListener { view ->
            if(et_username.text.toString() == "vidya" && et_pass.text.toString() == "vidya" ){
                Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show()
                val message = "ok"
                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtra(EXTRA_MESSAGE, message)
                }
                startActivity(intent)
            }else{
                Toast.makeText(this, "Login gagal", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun login() {


    }

}
