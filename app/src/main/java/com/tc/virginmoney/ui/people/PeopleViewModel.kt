package com.tc.virginmoney.ui.people

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tc.virginmoney.data.ApiDetails
import com.tc.virginmoney.ui.people.data.PeopleFacts
import com.tc.virginmoney.ui.people.data.PeopleFactsItemModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PeopleViewModel : ViewModel() {


    val _peopleFact = MutableLiveData<ArrayList<PeopleFactsItemModel>>()
    fun getPeopleFacts(){
        GlobalScope.launch {
            val result = ApiDetails.service.getPeopleFacts()
            if (result.isSuccessful) {
                _peopleFact.postValue(result.body())
            } else {
                _peopleFact.postValue(PeopleFacts())
            }
        }
    }
}