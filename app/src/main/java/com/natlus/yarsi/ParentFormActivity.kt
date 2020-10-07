package com.natlus.yarsi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.natlus.yarsi.databinding.ActivityMainBinding
import com.natlus.yarsi.databinding.ActivityParentFormBinding
import com.natlus.yarsi.models.Parent
import com.natlus.yarsi.models.Pribadi

class ParentFormActivity : AppCompatActivity() {
    private val DATA_PRIBADI = "DATA_PRIBADI"
    private val DATA_PARENT = "DATA_PARENT"
    private lateinit var binding: ActivityParentFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_parent_form)

        binding.btnParenttoSchool.setOnClickListener {
            intentToSchool()
        }
    }


    private fun intentToSchool() {
        val dataParent = Parent(
            namaAyah = binding.editTextNamaAyah.text.toString(),
            nikAyah = binding.editTextNikAyah.text.toString(),
            namaIbu = binding.editTextNamaIbu.text.toString(),
            nikIbu = binding.editTextNikIbu.text.toString(),
            tanggalLahirAyah = binding.editTextLahirAyah.text.toString(),
            tanggalLahirIbu = binding.editTextLahirIbu.text.toString(),
            alamatParent = binding.editTextAlamat.text.toString(),
            phoneOrtu = binding.editTextPhone.text.toString(),
            emailParent = binding.editTextEmail.text.toString(),
            pendidikanAyah = binding.editTextPendidikanAyah.text.toString(),
            pendidikanIbu = binding.editTextPendidikanIbu.text.toString(),
            pekerjaanAyah = binding.editTextPekerjaanAyah.text.toString(),
            pekerjaanIbu = binding.editTextPekerjaanIbu.text.toString(),
        )

        val dataPribadi = intent.getParcelableExtra<Pribadi>(DATA_PRIBADI)!!
        val resultIntent = Intent(this, SchoolFormActivity::class.java)
        resultIntent.putExtra(DATA_PARENT, dataParent)
        resultIntent.putExtra(DATA_PRIBADI, dataPribadi)
        startActivity(resultIntent)
    }
}