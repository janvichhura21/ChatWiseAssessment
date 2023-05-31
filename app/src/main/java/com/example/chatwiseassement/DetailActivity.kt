package com.example.chatwiseassement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatwiseassement.databinding.ActivityDetailBinding
import com.example.chatwiseassement.databinding.ActivityMainBinding
import com.example.chatwiseassement.model.UserAdapter
import com.example.chatwiseassement.viewmodel.MainViewModel

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    private val viewModel: MainViewModel by viewModels()
    lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userAdapter= UserAdapter(this)
        viewModel.getMovie()
        setUpRv()
    }
    private fun setUpRv() {
        binding.rv.apply {
            viewModel.getMovieObserve().observe(this@DetailActivity, Observer {
                Log.d("janvi", it.toString())
                userAdapter.getMovieItems(it)
            })
            layoutManager = LinearLayoutManager(this@DetailActivity)
            adapter = userAdapter
        }
    }
}