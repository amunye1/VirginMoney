package com.tc.virginmoney.ui.rooms.data


import com.google.gson.annotations.SerializedName
//This is serialization of json data
//this will tell kotlin that there will be json data
//that data will be represented in a specific way
//for example id will call avatar data with a image url property
data class RoomFactsItemModel(
    @SerializedName("createdAt")
    val createdAt: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("isOccupied")
    val isOccupied: Boolean? = false,
    @SerializedName("maxOccupancy")
    val maxOccupancy: Int? = 0
)