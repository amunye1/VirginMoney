package com.tc.virginmoney.data

import com.tc.virginmoney.ui.people.data.PeopleFactsItemModel
import com.tc.virginmoney.ui.rooms.data.RoomFactsItemModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiEndpoint {

    //lets retro fit know we are doing get request
    @GET(ApiDetails.ROOMS_ENDPOINT)
    suspend fun getRoomFacts(): Response<ArrayList<RoomFactsItemModel>>

    @GET(ApiDetails.PEOPLE_ENDPOINT)
    suspend fun getPeopleFacts(): Response<ArrayList<PeopleFactsItemModel>>
}