package com.hagstrom.henrik.che.white

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.hagstrom.henrik.che.R

class Rules : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rules)
        val menu=findViewById<Button>(R.id.menu)
        menu.setOnClickListener {
            val intent2= Intent(this@Rules,Res::class.java)
            startActivity(intent2)
        }
    }
}