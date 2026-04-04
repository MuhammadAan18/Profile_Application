@file:Suppress("DEPRECATION")

package com.example.profileapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.profileapplication.databinding.ActivitySubBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<UserProfile>("dataUser")

        if (user != null) {
            binding.tvNama.text = user.nama
            binding.tvProdi.text = user.prodi
            binding.tvNimDetail.text = user.nim
            binding.tvGenderDetail.text = user.gender
            binding.tvHobiDetail.text = user.hobi
        }

        binding.btnBack.setOnClickListener {
            val intentBack = android.content.Intent(this, MainActivity::class.java)
            intentBack.flags = android.content.Intent.FLAG_ACTIVITY_NEW_TASK or android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intentBack)
            finish()
        }
    }
}