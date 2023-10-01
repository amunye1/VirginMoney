package com.tc.virginmoney.ui.people.data


import com.google.gson.annotations.SerializedName
//simple immutable data structure

/*
serialization in our case allows us to pass json data to
Kotlin then we will have the json data formatted like
the body represent a body attribute of the json data etc
 */
data class DataModel(
    @SerializedName("body")
    val body: String? = "",
    @SerializedName("fromId")
    val fromId: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("meetingid")
    val meetingid: String? = "",
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("toId")
    val toId: String? = ""
)