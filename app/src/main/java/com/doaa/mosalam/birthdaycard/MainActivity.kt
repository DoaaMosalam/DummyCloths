package com.doaa.mosalam.birthdaycard

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.doaa.mosalam.birthdaycard.Products.Products
import com.doaa.mosalam.birthdaycard.common.BasicActivity
import com.doaa.mosalam.birthdaycard.databinding.ActivityMainBinding

class MainActivity : BasicActivity<ActivityMainBinding>(ActivityMainBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.startedBtn.setOnClickListener{
            val intent = Intent(this, Products::class.java)
            startActivity(intent)
        }



    }
}