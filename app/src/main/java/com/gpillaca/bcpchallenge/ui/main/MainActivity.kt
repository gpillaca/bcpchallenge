package com.gpillaca.bcpchallenge.ui.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.gpillaca.bcpchallenge.R
import com.gpillaca.bcpchallenge.databinding.ActivityMainBinding
import com.gpillaca.bcpchallenge.domain.Country
import com.gpillaca.bcpchallenge.ui.countries.CountriesActivity

private const val DEFAULT_CODE_YOU_SEND_MONEY = "PEN"
private const val DEFAULT_CODE_YOU_GET_MONEY = "USD"
private const val REQUEST_CODE_CURRENCY_SEND = 0
private const val REQUEST_CODE_CURRENCY_GET = 1

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.cardViewChangeCurrency
        setContentView(binding.root)

        binding.buttonYouGet.setOnClickListener(this)
        binding.buttonYouSend.setOnClickListener(this)
        binding.buttonChange.setOnClickListener(this)

        binding.editTextSendValue.doOnTextChanged { text, _, _, count ->
            //TODO calculate
        }
    }

    override fun onClick(v: View?) {
        val id = v?.id ?: return

        when (id) {
            R.id.buttonInitOperation -> {

            }
            R.id.buttonYouSend -> {
                val intent = Intent(this, CountriesActivity::class.java)
                startActivityForResult(intent, REQUEST_CODE_CURRENCY_SEND)
            }
            R.id.buttonYouGet -> {
                val intent = Intent(this, CountriesActivity::class.java)
                intent.putExtra(CountriesActivity.PARAM_CURRENCY, DEFAULT_CODE_YOU_GET_MONEY)
                startActivityForResult(intent, REQUEST_CODE_CURRENCY_GET)
            }
            R.id.buttonChange -> {

            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CODE_CURRENCY_SEND) {
                val country: Country = data?.getParcelableExtra(CountriesActivity.PARAM_COUNTRY) ?: return
                binding.textViewNameSendCurrency.text = country.currency.description
            }
            if (requestCode == REQUEST_CODE_CURRENCY_GET) {
                val country: Country = data?.getParcelableExtra(CountriesActivity.PARAM_COUNTRY) ?: return
                binding.textViewNameGetCurrency.text = country.currency.description
            }
        }
    }
}