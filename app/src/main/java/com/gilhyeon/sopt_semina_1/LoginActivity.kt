package com.gilhyeon.sopt_semina_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val idEditText:EditText = findViewById(R.id.idEditText)
        val passwordEditText:EditText = findViewById(R.id.passwordEditText)
        val loginButton:Button = findViewById(R.id.loginButton)
        val signupButton:Button = findViewById(R.id.signUpButton)

        val signUpIntent = Intent(this, SignUpActivity::class.java)
        val mainIntent = Intent(this,MainActivity::class.java)

        signupButton.setOnClickListener{
            startActivityForResult(signUpIntent,5000)
        }

        loginButton.setOnClickListener{
            if(idEditText.text.isEmpty() || passwordEditText.text.isEmpty()){

                Toast.makeText(this, "아이디와 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
            else if (blankCheck(idEditText.text.toString()) || blankCheck(passwordEditText.text.toString())){
                Toast.makeText(this, "대충 띄어쓰기 하지말라는 경고", Toast.LENGTH_SHORT).show()
            }
            else{
                startActivity(mainIntent)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            when(requestCode){
                5000 -> {
                    idEditText.setText(data!!.getStringExtra("id"))
                    passwordEditText.setText(data!!.getStringExtra("password"))
                }
            }
        }
    }

    fun blankCheck(a:String):Boolean{
        for(i in a){
            if(i.toString().isBlank()){
                return true
            }
        }
        return false
    }
}
