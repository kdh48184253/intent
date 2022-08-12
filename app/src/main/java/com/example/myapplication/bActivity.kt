package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityBactivityBinding
import com.example.myapplication.databinding.ActivityMainBinding

class bActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBactivityBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            intent.putExtra("code", 1)
            setResult(RESULT_OK, intent)
            finish()
//            val intent: Intent = Intent(this,cctivity::class.java)
//            startActivity(intent)
        }
        binding.button2.setOnClickListener {
            intent.putExtra("code", 2)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}