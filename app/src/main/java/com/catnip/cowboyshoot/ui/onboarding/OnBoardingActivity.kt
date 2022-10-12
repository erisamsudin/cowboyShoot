package com.catnip.cowboyshoot.ui.onboarding

import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import com.catnip.cowboyshoot.R
import com.catnip.cowboyshoot.ui.onboarding.entername.EnterNameFragment
import com.github.appintro.AppIntro2
import com.github.appintro.AppIntroFragment
import com.github.appintro.model.SliderPage

class OnBoardingActivity : AppIntro2() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setupSliderFragment()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        if (currentFragment is OnFinishNavigateListner){
            currentFragment.onFinishNavigateListener()
        }
    }

    private fun setupSliderFragment() {
        isSkipButtonEnabled = false
        addSlide(
            AppIntroFragment.createInstance(
                SliderPage(
                    title = getString(R.string.title_onboarding_one),
                    description = getString(R.string.desc_on_boarding_one),
                    imageDrawable = R.drawable.ic_cowboy_left_shoot_true,
                    titleTypefaceFontRes = R.font.pixelated_font,
                    descriptionTypefaceFontRes = R.font.pixelated_font,
                    backgroundDrawable = R.drawable.bg_game,
                    descriptionColorRes = R.color.white,
                    titleColorRes = R.color.white
                )
            )
        )
        addSlide(
            AppIntroFragment.createInstance(
                SliderPage(
                    title = getString(R.string.title_onboarding_two),
                    description = getString(R.string.desc_on_boarding_two),
                    imageDrawable = R.drawable.ic_cowboy_left_shoot_true,
                    titleTypefaceFontRes = R.font.pixelated_font,
                    descriptionTypefaceFontRes = R.font.pixelated_font,
                    backgroundDrawable = R.drawable.bg_game,
                    descriptionColorRes = R.color.white,
                    titleColorRes = R.color.white
                )
            )
        )
        addSlide(EnterNameFragment())
    }
}

interface OnFinishNavigateListner{
        fun onFinishNavigateListener()
}