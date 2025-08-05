package com.doaa.mosalam.birthdaycard.ui.Navigation

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.doaa.mosalam.birthdaycard.R
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

        // إيجاد NavHostFragment و NavController
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigation.setupWithNavController(navController)


        navController.addOnDestinationChangedListener { _, destination, _ ->
            val hideOn = setOf(R.id.homeFragment, R.id.loginFragment)
//            val hideOn = setOf(R.id.loginFragment,R.id.registerFragment,R.id.homeFragment)
            binding.bottomNavigation.visibility =
                if (destination.id in hideOn) View.GONE else View.VISIBLE
        }


    }
}