package com.gpillaca.bcpchallenge.ui.common

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import com.gpillaca.bcpchallenge.databinding.CustomCardviewChangeCurrencyBinding

class CardViewChangeCurrency @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    private var binding: CustomCardviewChangeCurrencyBinding =
        CustomCardviewChangeCurrencyBinding.inflate(LayoutInflater.from(context), this, true)
}