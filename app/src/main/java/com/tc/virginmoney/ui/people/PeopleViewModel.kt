package com.tc.virginmoney.ui.people
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tc.virginmoney.data.ApiDetails
import com.tc.virginmoney.ui.people.data.PeopleFacts
import com.tc.virginmoney.ui.people.data.PeopleFactsItemModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// This ViewModel manages data related to people.
class PeopleViewModel : ViewModel() {

    // This is a LiveData container for holding information about people.
    val _peopleFacts = MutableLiveData<ArrayList<PeopleFactsItemModel>>()
    // This is an immutable LiveData window to observe the data.
    val peopleFact  :LiveData<ArrayList<PeopleFactsItemModel>> =_peopleFacts

    // This method fetches data about people from an API service.
    fun getPeopleFacts(){
        // We're launching a coroutine to do this task asynchronously.
        GlobalScope.launch {
            // We're making a request to the API service to get people data.
            val result = ApiDetails.service.getPeopleFacts()
            // We're checking if the request was successful.
            if (result.isSuccessful) {
                // If it was successful, we update the LiveData container with the data.
                _peopleFacts.postValue(result.body())
            } else {
                // If not, we set an empty container to handle the error gracefully.
                _peopleFacts.postValue(PeopleFacts())
            }
        }
    }
}