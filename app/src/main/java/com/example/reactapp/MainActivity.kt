package com.example.reactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.reactapp.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.getPersons()
        setupRecycler()
    }

    private fun setupRecycler() {
        val adapter = NameAdapter()
        viewModel.persons.observe(this) {
            adapter.submitList(it)
        }
    }
}