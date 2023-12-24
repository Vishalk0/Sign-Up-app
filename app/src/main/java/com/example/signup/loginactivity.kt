package com.example.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.signup.databinding.ActivityLoginactivityBinding
import com.google.firebase.auth.FirebaseAuth

class loginactivity : AppCompatActivity() {
    private val binding:ActivityLoginactivityBinding by lazy {
        ActivityLoginactivityBinding.inflate(layoutInflater)
    }
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //intialize the firebase
        auth=FirebaseAuth.getInstance()
        binding.login.setOnClickListener{
            val user=binding.textView2.text.toString()
            val password=binding.textView3.text.toString()
            if (user.isEmpty()||password.isEmpty()){
                Toast.makeText(this, "fill all the details", Toast.LENGTH_SHORT).show()
            }
            else{
                auth.signInWithEmailAndPassword(user,password).addOnCompleteListener{
                    task->
                    if (task.isSuccessful){
                        Toast.makeText(this, "logIn is Successfully", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,MainActivity::class.java))
                    }else{
                        Toast.makeText(this, "login is Falled:${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }



        binding.signin.setOnClickListener{
            startActivity(Intent(this,Signupacticity::class.java))
            finish()
        }
    }
}