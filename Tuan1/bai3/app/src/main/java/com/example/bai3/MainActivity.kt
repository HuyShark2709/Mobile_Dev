package com.example.bai3   // phải trùng namespace trong Gradle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bai3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var scale = 1f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabZoomIn.setOnClickListener { zoom(0.05f) }
        binding.fabZoomOut.setOnClickListener { zoom(-0.05f) }
    }

    private fun zoom(delta: Float) {
        scale = (scale + delta).coerceIn(0.8f, 1.3f)
        binding.profileCard.animate().scaleX(scale).scaleY(scale).setDuration(120).start()
    }
}
