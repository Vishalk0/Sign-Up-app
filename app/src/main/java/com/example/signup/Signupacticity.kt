package com.example.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.signup.databinding.ActivitySignupBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth

class Signupacticity : AppCompatActivity() {
    private val binding:ActivitySignupBinding by lazy {
        ActivitySignupBinding.inflate(layoutInflater)
    }
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        auth=FirebaseAuth.getInstance()
        binding.sign.setOnClickListener{
            startActivity(Intent(this,loginactivity::class.java))
            finish()
        }

        binding.reg.setOnClickListener{
            val email=binding.textView4.text.toString()
            val user=binding.textView6.text.toString()
            val password=binding.textView7.text.toString()
            val confirmpassword=binding.textView8.text.toString()
            //this logic use for cheak deatails feel in column
            if (email.isEmpty()||user.isEmpty()||password.isEmpty()||confirmpassword.isEmpty()){
                Toast.makeText(this,"Please fill all the details",Toast.LENGTH_SHORT).show()
            }
            else if(password!= confirmpassword){
                Toast.makeText(this,"confirm password is wrong",Toast.LENGTH_SHORT).show()

            }
            else{

                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this) {  Task->
                    if (Task.isSuccessful){
                        Toast.makeText(this,"Register Sucessfully Done",Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,loginactivity::class.java))

                    }
                    else{
                        Toast.makeText(this,"Register is Failed :${Task.exception?.message} ",Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }
    }
}