package com.gpillaca.bcpchallenge.ui.countries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.gpillaca.bcpchallenge.R
import com.gpillaca.bcpchallenge.domain.Country
import kotlinx.android.synthetic.main.item_country.view.*
import kotlin.properties.Delegates

class CountriesAdapter(private val listener: (Country) -> Unit) :
    RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {

    var countries: List<Country> by Delegates.observable(emptyList()) { _, old, new ->
        DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return old[oldItemPosition].name == new[newItemPosition].name
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return old[oldItemPosition] == new[newItemPosition]
            }

            override fun getOldListSize(): Int = old.size

            override fun getNewListSize(): Int = new.size
        }).dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = countries.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countries[position]
        holder.bind(country)
        holder.itemView.setOnClickListener {
            listener(country)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(country: Country) {
            itemView.imageViewFlag.load(country.flag)
            itemView.textViewName.text = country.name
            itemView.textViewDescription.text = country.currency.description
        }
    }
}