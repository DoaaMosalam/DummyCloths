package com.doaa.mosalam.birthdaycard.ui.setting

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.viewModels
import com.doaa.mosalam.birthdaycard.R
import com.doaa.mosalam.birthdaycard.common.BaseFragment
import com.doaa.mosalam.birthdaycard.databinding.FragmentSettingBinding
import com.doaa.mosalam.birthdaycard.ui.HomeFragment
import com.doaa.mosalam.birthdaycard.ui.setting.viewModel.SettingViewModel
import com.doaa.mosalam.birthdaycard.util.LocaleManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingFragment : BaseFragment<FragmentSettingBinding, SettingViewModel>() {

    override val viewModel: SettingViewModel by viewModels()
    override fun getLayoutResID(): Int = com.doaa.mosalam.birthdaycard.R.layout.fragment_setting

    private val PREFS = "app_prefs"
    private val KEY_THEME = "pref_dark"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Load user image (replace with real url or local path if you have)
        // If you don't use Glide, remove this block.
//        val userImageUrl: String? = null // or your URL
//        if (!userImageUrl.isNullOrBlank()) {
//            Glide.with(this)
//                .load(userImageUrl)
//                .circleCrop()
//                .into(binding.imageUser)
//        } else {
//            // fallback to drawable resource
//            binding.imageUser.setImageResource(com.doaa.mosalam.birthdaycard.R.drawable.img_1)
//        }

        setupThemeSwitch()
        setupLanguageSpinner()
        setupLogoutButton()
    }

    private fun setupThemeSwitch() {
        val prefs = requireContext().getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        val isDarkSaved = prefs.getBoolean(KEY_THEME, false)
        binding.switchTheme.isChecked = isDarkSaved
        applyTheme(isDarkSaved)

        // listen to switch changes
        binding.switchTheme.setOnCheckedChangeListener { _: CompoundButton, isChecked: Boolean ->
            prefs.edit().putBoolean(KEY_THEME, isChecked).apply()
            applyTheme(isChecked)
        }
    }

    private fun applyTheme(isDark: Boolean) {
        if (isDark) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    private fun setupLanguageSpinner() {
        val languages = listOf(getString(R.string.english), getString(R.string.arabic))
        val languageCodes = listOf("en", "ar")

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, languages)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerLanguage.adapter = adapter

        // set current selection
        val currentLang = LocaleManager.getLanguage(requireContext())
        val currentIndex = languageCodes.indexOf(currentLang).coerceAtLeast(0)
        binding.spinnerLanguage.setSelection(currentIndex)

        binding.spinnerLanguage.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedCode = languageCodes[position]
                val saved = LocaleManager.getLanguage(requireContext())
                if (selectedCode != saved) {
                    // Apply locale and recreate activity so resources update
                    LocaleManager.setLocale(requireActivity(), selectedCode)
                    // Save also via ViewModel if needed
                    viewModel.changeLanguage(requireContext(), selectedCode)
                    activity?.recreate()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun setupLogoutButton() {
        binding.btnLogout.setOnClickListener {
            // call viewmodel logout (it can clear tokens etc)
            viewModel.logout()

            // Clear shared prefs (optional)
            val prefs = requireContext().getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            prefs.edit().clear().apply()

            // Redirect to login activity (replace with your LoginActivity)
//             val intent = Intent(requireContext(), HomeFragment::class.java)
//             intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//             startActivity(intent)

            // For now show simple feedback
            androidx.appcompat.app.AlertDialog.Builder(requireContext())
                .setTitle(getString(R.string.logout))
                .setMessage(getString(R.string.logout) + "؟")
                .setPositiveButton(android.R.string.yes) { _, _ ->
                    // handle confirm logout (navigate)
                }
                .setNegativeButton(android.R.string.no, null)
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // clear binding reference to avoid leaks
        _binding = null
    }
}
