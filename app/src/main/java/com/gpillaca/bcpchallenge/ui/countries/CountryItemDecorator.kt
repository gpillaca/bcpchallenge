package com.gpillaca.bcpchallenge.ui.countries

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class CountryItemDecorator() : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val density = parent.context.resources.displayMetrics.density
        val padding = 8

        outRect.bottom = (density * padding).toInt()
    }
}