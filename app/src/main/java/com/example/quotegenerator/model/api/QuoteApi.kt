package com.example.quotegenerator.model.api

import com.example.quotegenerator.model.data.Quote
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApi {


    @GET("api/quotes")
    suspend fun getQuotes(): Response<Quote>


}