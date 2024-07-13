package com.example.myapplication.network

import com.example.myapplication.bean.AnswerData
import com.example.myapplication.bean.Story
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("v3/queries/hot")
    fun getSearchData(
    ): Observable<List<String>>
}