package com.example.headsupsqlitesaveonly

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.headsupsqlitesaveonly.databinding.ActivityAddnewcelebritiesBinding

class Addnewcelebrities : AppCompatActivity() {
    lateinit var binding: ActivityAddnewcelebritiesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddnewcelebritiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            val name=binding.edName.text.toString()
            val taboo1=binding.edTaboo1.text.toString()
            val taboo2=binding.edTaboo2.text.toString()
            val taboo3=binding.edTaboo3.text.toString()
            val dbHelper=DBHelper(applicationContext)
            val status=dbHelper.saveData(name,taboo1,taboo2,taboo3)
            
            if (status!=-1L) Toast.makeText(
                applicationContext,
                "celebrity added $status",
                Toast.LENGTH_SHORT
            ).show()
            
        }
    }
}