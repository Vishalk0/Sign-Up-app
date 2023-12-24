package com.example.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.signup.databinding.ActivitySplace2Binding

class splaceActivity2 : AppCompatActivity() {
    private val binding:ActivitySplace2Binding by lazy {
        ActivitySplace2Binding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this,loginactivity::class.java))
        },3000)


    }
}