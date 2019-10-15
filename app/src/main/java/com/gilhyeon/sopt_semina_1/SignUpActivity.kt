package com.gilhyeon.sopt_semina_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlin.math.log

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val name:EditText = findViewById(R.id.nameEditText)
        val id:EditText = findViewById(R.id.idEditText)
        val password:EditText = findViewById(R.id.passwordEditText)
        val passwordCheck:EditText = findViewById(R.id.passwordCheckEditText)
        val hobby:EditText = findViewById(R.id.hobbyEditText)
        val like:EditText = findViewById(R.id.likeEditText)
        val hate:EditText = findViewById(R.id.hateEditText)
        val introduce:EditText = findViewById(R.id.introduceEditText)
        val signupButton:Button = findViewById(R.id.signUpButton)

        signupButton.setOnClickListener {
            val information_user = arrayOf(name.text.toString(), id.text.toString(), password.text.toString(), passwordCheck.text.toString(), hobby.text.toString(), like.text.toString(), hate.text.toString(), introduce.text.toString())
            if (check(information_user)){
                Toast.makeText(this, "대충 하나도 빼지말고 다 입력하라는 경고",Toast.LENGTH_SHORT).show()
            }
            else if (password.text.toString() != passwordCheck.text.toString()){
                Toast.makeText(this,"비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
            }
            else{
                val loginIntent = Intent()
                loginIntent.putExtra("id",idEditText.text.toString())
                loginIntent.putExtra("password",password.text.toString())
                setResult(Activity.RESULT_OK,loginIntent)
                finish()
            }
        }
    }

    fun check (array : Array<String>):Boolean{
        for(a in array){
            if (a.isBlank() || a.isEmpty()){
                return true
            }
        }
        return false
    }
}
