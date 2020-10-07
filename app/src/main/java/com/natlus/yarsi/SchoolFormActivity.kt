package com.natlus.yarsi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.natlus.yarsi.databinding.ActivityParentFormBinding
import com.natlus.yarsi.databinding.ActivitySchoolFormBinding
import com.natlus.yarsi.models.Parent
import com.natlus.yarsi.models.Pribadi
import com.natlus.yarsi.models.School

class SchoolFormActivity : AppCompatActivity() {
    private val DATA_PRIBADI = "DATA_PRIBADI"
    private val DATA_PARENT = "DATA_PARENT"
    private val DATA_SCHOOL = "DATA_SCHOOL"
    private lateinit var binding: ActivitySchoolFormBinding

    private lateinit var dataProvinsi: Array<String>
    private lateinit var dataKota: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_school_form)
        setUp()
        loadDataSpinner()

        binding.btnGoToResult.setOnClickListener {
            intentToResult()
        }
    }

    private fun setUp() {
        dataProvinsi = resources.getStringArray(R.array.dataProvinsi)
        dataKota = resources.getStringArray(R.array.dataKota)
    }

    private fun loadDataSpinner() {
        val adapterProvinsi = ArrayAdapter(this, android.R.layout.simple_spinner_item, dataProvinsi)
        val adapterKota = ArrayAdapter(this, android.R.layout.simple_spinner_item, dataKota)

        adapterProvinsi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterKota.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerProvinsiUnivAsal.adapter = adapterProvinsi
        binding.spinnerKotaUnivAsal.adapter = adapterKota
    }

    private fun intentToResult() {
        val dataSchool = School(
            namaUnivAsal = binding.editTextUnivAsal.text.toString(),
            namaFakultasAsal = binding.editTextFakultasAsal.text.toString(),
            namaProdiAsal = binding.editTextProdiAsal.text.toString(),
            provinsiUnivAsal = binding.spinnerProvinsiUnivAsal.selectedItem.toString(),
            kotaUnivAsal = binding.spinnerKotaUnivAsal.selectedItem.toString(),
            alamatUnivAsal = binding.editTextAlamatUnivAsal.text.toString(),
            kodePosUnivAsal = binding.editTextKodePos.text.toString(),
            akreditasiUnivAsal = binding.editTextAkreditasiUnivAsal.text.toString(),
            nilaiIPK = binding.editTextNilaiIPK.text.toString(),
        )

        val dataParent = intent.getParcelableExtra<Parent>(DATA_PARENT)!!
        val dataPribadi = intent.getParcelableExtra<Pribadi>(DATA_PRIBADI)!!
        val resultIntent = Intent(this, ResultFormActivity::class.java)
        resultIntent.putExtra(DATA_SCHOOL, dataSchool)
        resultIntent.putExtra(DATA_PARENT, dataParent)
        resultIntent.putExtra(DATA_PRIBADI, dataPribadi)
        startActivity(resultIntent)
    }
}