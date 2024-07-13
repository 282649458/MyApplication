package com.example.myapplication.network

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET


interface ApiService {
    @GET("v3/queries/hot")
    fun getSearchData(): Observable<List<String>>
}