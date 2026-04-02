package com.example.profileapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.profileapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Spinner
        val prodiArray = resources.getStringArray(R.array.list_prodi)
        val adapter = object : ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_item,
            prodiArray
        ) {
            // Memblokir item pertama agar tidak bisa dipilih
            override fun isEnabled(position: Int): Boolean {
                return position != 0
            }

            // Mengubah warna item pertama menjadi abu-abu agar terlihat seperti hint
            override fun getDropDownView(position: Int, convertView: android.view.View?, parent: android.view.ViewGroup): android.view.View {
                val view = super.getDropDownView(position, convertView, parent) as android.widget.TextView
                if (position == 0) {
                    view.setTextColor(android.graphics.Color.GRAY)
                } else {
                    view.setTextColor(android.graphics.Color.rgb(99,5,128))
                }
                return view
            }
        }

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerProdi.adapter = adapter

        binding.btnSubmit.setOnClickListener {

            val nama = binding.etNama.text.toString().trim()
            val nimStr = binding.etNim.text.toString().trim()
            val prodi = binding.spinnerProdi.selectedItem?.toString() ?: ""

            if (nama.isEmpty()) {
                binding.etNama.error = "Nama tidak boleh kosong!"
                binding.etNama.requestFocus()
                return@setOnClickListener
            }

            if (nimStr.isEmpty()) {
                binding.etNim.error = "NIM tidak boleh kosong!"
                binding.etNim.requestFocus()
                return@setOnClickListener
            }
            if (prodi.isEmpty()) {
                binding.etNim.error = "Program Studi tidak boleh kosong!"
                binding.spinnerProdi.requestFocus()
                return@setOnClickListener
            }

            val genderSelected = binding.radioGroupGender.checkedRadioButtonId
            if (genderSelected == -1) {
                Toast.makeText(this, "Silakan pilih Jenis Kelamin!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val gender = findViewById<RadioButton>(genderSelected).text.toString()

            val hobiList = mutableListOf<String>()
            if (binding.cbMembaca.isChecked) hobiList.add("Membaca")
            if (binding.cbOlahraga.isChecked) hobiList.add("Olahraga")
            if (binding.cbGaming.isChecked) hobiList.add("Gaming")
            if (binding.cbMusik.isChecked) hobiList.add("Musik")
            if (binding.cbTraveling.isChecked) hobiList.add("Traveling")
            if (binding.cbFotografi.isChecked) hobiList.add("Fotografi")

            if (hobiList.isEmpty()) {
                Toast.makeText(this, "Pilih minimal satu hobi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val hobi = hobiList.joinToString(", ")

            // (Opsional) Jika Anda ingin berpindah ke Activity lain, Anda bisa menggunakan Intent di sini
            /*
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("NAMA", nama)
            intent.putExtra("NIM", nimStr)
            startActivity(intent)
            */
        }
    }
}