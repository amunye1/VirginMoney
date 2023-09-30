package com.tc.virginmoney.ui.rooms

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tc.virginmoney.data.ApiDetails
import com.tc.virginmoney.ui.people.data.PeopleFacts
import com.tc.virginmoney.ui.rooms.data.RoomFacts
import com.tc.virginmoney.ui.rooms.data.RoomFactsItemModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RoomsViewModel : ViewModel() {

    val _roomFacts = MutableLiveData<ArrayList<RoomFactsItemModel>>()
        fun getRoomFacts(){
            GlobalScope.launch {
                val result = ApiDetails.service.getRoomFacts()
                if (result.isSuccessful) {
                    _roomFacts.postValue(result.body())
                } else {
                    _roomFacts.postValue(RoomFacts())
                }
            }
        }

}