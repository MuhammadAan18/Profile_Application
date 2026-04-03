package com.example.profileapplication

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.profileapplication.databinding.ActivitySubBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val namaLengkap = intent.getStringExtra("nama")
        val nimMahasiswa = intent.getStringExtra("nim")
        val programStudi = intent.getStringExtra("prodi")
        val jenisKelamin = intent.getStringExtra("gender")
        val hobiPilihan = intent.getStringExtra("hobi")

        binding.tvNama.text = namaLengkap
        binding.tvProdi.text = programStudi
        binding.tvNimDetail.text = nimMahasiswa
        binding.tvGenderDetail.text = jenisKelamin
        binding.tvHobiDetail.text = hobiPilihan

        binding.btnBack.setOnClickListener {
            val intent = android.content.Intent(this, MainActivity::class.java)
            // FLAG menghapus semua riwayat halaman sebelumnya
            intent.flags = android.content.Intent.FLAG_ACTIVITY_NEW_TASK or android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}