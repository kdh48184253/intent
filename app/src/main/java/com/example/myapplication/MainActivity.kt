package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.bActivity
import com.example.myapplication.databinding.ActivityBactivityBinding
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var resultLauncher : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){
            if (it.resultCode == RESULT_OK){
//                Log.d("ActivityMain", it.data!!.getStringExtra("1234").toString())
//                val code:Int = it.data!!.getIntExtra("code",0
                val n = it.data!!.getIntExtra("code",0)
                when(n){
                    1->{
                        binding.ivIcon.setImageResource(R.drawable.ic_launcher_foreground)
                    }
                    2->{
                        binding.ivIcon.setImageResource(R.drawable.ic_launcher_background)
                    }
                }
                binding.btnTv.text = it.data!!.getStringExtra("1234").toString()
                Toast.makeText(this, "성공", Toast.LENGTH_SHORT).show()

            } else if (it.resultCode == RESULT_CANCELED){
                Toast.makeText(this, "실패", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnTv.setOnClickListener {
           val intent: Intent = Intent(this,bActivity::class.java)
            intent.putExtra("msg",binding.edMsg.text.toString())
//            startActivity(intent)
            resultLauncher.launch(intent)
        }

//        binding.btnTv.setOnClickListener {
//            val intent: Intent = Intent(this,bActivity::class.java)
//            intent.putExtra("msg",binding.edMsg.text.toString())
//            startActivity(intent)
//        }
    }
}
