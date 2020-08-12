package com.gpillaca.bcpchallenge.ui.launcher

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gpillaca.bcpchallenge.databinding.ActivityLauncherBinding
import com.gpillaca.bcpchallenge.ui.main.MainActivity
import com.gpillaca.bcpchallenge.util.onAnimatorEnd

private const val DURATION_ANIMATION = 1200L

class LauncherActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLauncherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLauncherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initLogoAnimation()
    }

    private fun initLogoAnimation() {
        val animator = ObjectAnimator.ofFloat(binding.imageViewLogo, View.ALPHA, 0.0f, 1.0f)
        animator.duration =
            DURATION_ANIMATION
        animator.onAnimatorEnd {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        animator.start()
    }
}