package com.gpillaca.bcpchallenge.util

import android.animation.Animator
import android.animation.ObjectAnimator

fun ObjectAnimator.onAnimatorEnd(onAnimatedEnd: (animation: Animator) -> Unit) {
    this.addListener(object : Animator.AnimatorListener {
        override fun onAnimationEnd(animation: Animator) {
            onAnimatedEnd(animation)
        }
        override fun onAnimationRepeat(animation: Animator) {}
        override fun onAnimationCancel(animation: Animator) {}
        override fun onAnimationStart(animation: Animator) {}
    })
}