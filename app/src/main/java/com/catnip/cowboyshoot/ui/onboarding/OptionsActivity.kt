package com.catnip.cowboyshoot.ui.onboarding

import android.app.ActivityOptions
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.catnip.cowboyshoot.databinding.ActivityOptionsBinding

class OptionsActivity : AppCompatActivity() {
    private val binding: ActivityOptionsBinding by lazy {
        ActivityOptionsBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        val playerName = intent.getStringExtra("PLAYERNAME")
        binding.tvPlayerName.text = playerName
    }

}