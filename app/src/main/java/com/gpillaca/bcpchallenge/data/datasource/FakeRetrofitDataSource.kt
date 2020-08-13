package com.gpillaca.bcpchallenge.data.datasource

import android.content.Context
import com.gpillaca.bcpchallenge.R
import com.gpillaca.bcpchallenge.domain.Countries
import com.gpillaca.bcpchallenge.ui.common.OperationResults
import com.gpillaca.bcpchallenge.util.toEntity
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets

class FakeRetrofitDataSource(
    private val context: Context
) : RemoteDataSource {
    override suspend fun listCountries(): OperationResults<Countries> {
        return try {
            val countries = stringListCountries().toEntity<Countries>()
            OperationResults.Success(emptyList())
        } catch (e: Exception) {
            OperationResults.Error(e)
        }
    }

    private fun stringListCountries(): String {
        var bufferedReader: BufferedReader? = null

        try {
            val inputStream = context.resources.openRawResource(R.raw.countries)
            bufferedReader = BufferedReader(InputStreamReader(inputStream, StandardCharsets.UTF_8))

            var line: String?
            val text = StringBuilder()

            do {
                line = bufferedReader.readLine()
                line?.let { text.append(line) }
            } while (line != null)

            bufferedReader.close()
            return text.toString()
        } finally {
            bufferedReader?.close()
        }
    }
}