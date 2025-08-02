package com.doaa.mosalam.birthdaycard.ui.Navigation

import android.os.Bundle
import com.doaa.mosalam.birthdaycard.common.BasicActivity
import com.doaa.mosalam.birthdaycard.databinding.ActivityNavigationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavigationActivity :
    BasicActivity<ActivityNavigationBinding>(ActivityNavigationBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding.startedBtn.setOnClickListener{
//            val intent = Intent(this, ProductsActivity::class.java).apply {
//                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
//            }
//            startActivity(intent)
//            finish()

//        }
    }
}