package com.natlus.yarsi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.natlus.yarsi.databinding.ActivityResultFormBinding
import com.natlus.yarsi.models.Parent
import com.natlus.yarsi.models.Pribadi
import com.natlus.yarsi.models.School

class ResultFormActivity : AppCompatActivity() {
    private val DATA_PRIBADI = "DATA_PRIBADI"
    private val DATA_PARENT = "DATA_PARENT"
    private val DATA_SCHOOL = "DATA_SCHOOL"
    private lateinit var binding: ActivityResultFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_result_form)

        binding.school = intent.getParcelableExtra<School>(DATA_SCHOOL)!!
        binding.parent = intent.getParcelableExtra<Parent>(DATA_PARENT)!!
        binding.pribadi = intent.getParcelableExtra<Pribadi>(DATA_PRIBADI)!!
    }
}