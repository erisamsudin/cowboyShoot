package com.catnip.cowboyshoot.ui.splashscreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.provider.CalendarContract
import androidx.appcompat.app.AppCompatActivity
import com.catnip.cowboyshoot.databinding.ActivitySplashScreenBinding
import com.catnip.cowboyshoot.ui.onboarding.OnBoardingActivity
import com.github.appintro.AppIntroFragment

class SplashScreenActivity : AppCompatActivity() {
    private var timer: CountDownTimer? = null
    private val binding: ActivitySplashScreenBinding by lazy {
        ActivitySplashScreenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstances: Bundle?){
        super.onCreate(savedInstances)
        setContentView(binding.root)
        supportActionBar?.hide()
        setTimerSplashScreen()

    }

    override fun onDestroy() {
        super.onDestroy()
        //destroy the timer for case new activity still opened when splashscreen destoryed
        if (timer != null) {
            timer?.cancel()
            timer = null
        }
    }

    private fun setTimerSplashScreen() {
        timer = object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                val intent = Intent(this@SplashScreenActivity, OnBoardingActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
        }
        timer?.start()
    }




}