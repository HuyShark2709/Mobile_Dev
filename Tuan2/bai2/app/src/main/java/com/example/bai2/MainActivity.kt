package com.example.bai2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import android.util.Patterns
import com.example.bai2.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var vb: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)

        vb.edtEmail.doAfterTextChanged {
            vb.tilEmail.error = null
            vb.tvResult.text = ""
        }

        vb.btnCheck.setOnClickListener { validateEmail() }
    }

    private fun validateEmail() {
        val email = vb.edtEmail.text?.toString()?.trim()

        // 1) null hoặc rỗng
        if (email.isNullOrEmpty()) {
            vb.tilEmail.error = "Email không hợp lệ"
            return
        }

        // 2) không chứa '@' (đúng theo đề), hoặc dùng regex chuẩn:
        if (!email.contains("@")) {
            vb.tilEmail.error = "Email không đúng định dạng"
            return
        }
        // (tuỳ chọn, chuẩn hơn)
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            vb.tilEmail.error = "Email không đúng định dạng"
            return
        }

        // 3) hợp lệ
        vb.tilEmail.error = null
        vb.tvResult.setTextColor(0xFF1B5E20.toInt())
        vb.tvResult.text = "Bạn đã nhập email hợp lệ"
        Snackbar.make(vb.root, "Email hợp lệ: $email", Snackbar.LENGTH_SHORT).show()
    }
}
