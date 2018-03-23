package com.sentia.test.presenter

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.sentia.test.network.model.HouseDetails

/**
 * Created by don.chummar on 22/3/18.
 */

class SharedModel : ViewModel() {
    internal val selected = MutableLiveData<HouseDetails>()

    fun select(item: HouseDetails) {
        selected.value = item
    }

    fun getSelected(): LiveData<HouseDetails> {
        return selected
    }
}