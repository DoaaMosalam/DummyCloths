package com.doaa.mosalam.birthdaycard

import android.content.Intent
import android.os.Bundle
import com.doaa.mosalam.birthdaycard.ui.Products.ProductsActivity
import com.doaa.mosalam.birthdaycard.common.BasicActivity
import com.doaa.mosalam.birthdaycard.databinding.ActivityMainBinding

class MainActivity : BasicActivity<ActivityMainBinding>(ActivityMainBinding::inflate){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.startedBtn.setOnClickListener{
            val intent = Intent(this, ProductsActivity::class.java)
            startActivity(intent)
        }
    }
}