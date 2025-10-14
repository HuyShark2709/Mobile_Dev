package com.example.bai1

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bai1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var vb: ActivityMainBinding
    private val adapter = NumberAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)

        vb.rvNumbers.layoutManager = LinearLayoutManager(this)
        vb.rvNumbers.adapter = adapter

        vb.btnCreate.setOnClickListener {
            val input = vb.edtNumber.text?.toString()?.trim()
            val number = input?.toIntOrNull()

            if (number == null || number <= 0) {
                vb.tilNumber.error = "Dữ liệu bạn nhập không hợp lệ"
                return@setOnClickListener
            }

            vb.tilNumber.error = null
            vb.emptyState.visibility = View.GONE
            adapter.submit((1..number).toList())
        }
    }
}
