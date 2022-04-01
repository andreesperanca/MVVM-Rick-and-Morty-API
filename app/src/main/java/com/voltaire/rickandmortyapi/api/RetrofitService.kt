package com.voltaire.rickandmortyapi.api

import com.voltaire.rickandmortyapi.model.CharacterList
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query

interface RetrofitService {

    @GET("api/character")
    suspend fun getCharacters(@Query("page") page : Int): CharacterList

    companion object {

        private val retrofitService: RetrofitService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(RetrofitService::class.java)
        }

        fun getInstance() : RetrofitService {
            return retrofitService
        }
    }
}



