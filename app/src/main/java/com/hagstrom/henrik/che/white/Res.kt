package com.hagstrom.henrik.che.white

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hagstrom.henrik.che.R
import com.hagstrom.henrik.che.databinding.ActivityResBinding

class Res : AppCompatActivity() {
    lateinit var binding:ActivityResBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityResBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.scoret.text=getIntent().getStringExtra("key")
        binding.start.setOnClickListener{
            val intent= Intent(this@Res,Play::class.java)
            startActivity(intent)
        }
        binding.rules.setOnClickListener {
            val intent1=Intent(this@Res,Rules::class.java)
            startActivity(intent1)
        }
    }
}