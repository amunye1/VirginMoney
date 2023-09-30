package com.tc.virginmoney.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiDetails {

    // this is gonna be the base url we gonna use then we will attach
    // a ednpoint / path that the website has to go to
    const val BASE_URL = "https:// 61e947967bc0550017bc61bf.mockapi.io/api/v1/"
    const val ROOMS_ENDPOINT = "rooms"
    const val PEOPLE_ENDPOINT = "people"


    //builder will have the retrofit.builder object
    //gsonconvert converts java into java object into json representation
    //base url is just the domain of the site you want to go to
    val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    //take api interfaces as a parameter and it refrences the class . java
    val service = retrofit.create(ApiEndpoint::class.java)
}