package com.example.quotegenerator.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.quotegenerator.model.data.Quote
import com.example.quotegenerator.model.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewmodel@Inject constructor(val repository: Repository,application: Application): AndroidViewModel(application) {

    var quotesList=MutableLiveData<Quote>()

    fun getQuotes(){
        viewModelScope.launch {
            val response=repository.remote.getQuote()
            if(response.isSuccessful){
                quotesList.postValue(response.body())
            }else{
                Log.d("viewmodel","no data")
            }
        }
    }


}