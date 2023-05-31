package com.example.chatwiseassement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.chatwiseassement.databinding.ActivityMainBinding
import com.example.chatwiseassement.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.go.setOnClickListener {
            startActivity(Intent(this,DetailActivity::class.java))
            finish()
        }
    }
}