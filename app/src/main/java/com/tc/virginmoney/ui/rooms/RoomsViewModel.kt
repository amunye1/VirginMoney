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


// This ViewModel manages room-related data for our app.
class RoomsViewModel : ViewModel() {

    // This MutableLiveData is a container for holding and updating room information.
    private val _roomFacts = MutableLiveData<ArrayList<RoomFactsItemModel>>()
    // This LiveData is a read-only window into the room data for observing changes.
    val roomFact  :LiveData<ArrayList<RoomFactsItemModel>>  = _roomFacts

    // This function fetches room data from a remote service.
    fun getRoomFacts(){
        // We're launching a coroutine to make this task asynchronous.
        GlobalScope.launch {
            // We're sending a request to the service to retrieve room data.
            val result = ApiDetails.service.getRoomFacts()
            // We're checking if the request was successful.
            if (result.isSuccessful) {
                // If it was successful, we update the MutableLiveData with the received data.
                _roomFacts.postValue(result.body())
                } else {
                // If not, we set an empty container to handle the error gracefully.
                _roomFacts.postValue(RoomFacts())
                }
            }
        }

}