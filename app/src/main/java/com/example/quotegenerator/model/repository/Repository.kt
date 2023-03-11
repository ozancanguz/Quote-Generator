package com.example.quotegenerator.model.repository

import com.example.quotegenerator.model.remote.RemoteDataSource
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
@ViewModelScoped
class Repository@Inject constructor(private val remoteDataSource: RemoteDataSource) {

    var remote=remoteDataSource
}