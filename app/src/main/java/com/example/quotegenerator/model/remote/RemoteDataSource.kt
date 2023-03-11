package com.example.quotegenerator.model.remote

import com.example.quotegenerator.model.api.QuoteApi
import com.example.quotegenerator.model.data.Quote
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource@Inject constructor(private val quoteApi: QuoteApi) {

    suspend fun getQuote(): Response<Quote> {
        return quoteApi.getQuotes()
    }

}