package com.sentia.test.presenter

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.sentia.test.network.ApiManager
import com.sentia.test.network.model.HouseList
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by don.chummar on 22/3/18.
 */


class ListViewModel : ViewModel() {


    var houseListMetaData: MutableLiveData<HouseList>? = null

    fun getHouseList(): MutableLiveData<HouseList>{
        if (houseListMetaData == null) {
            houseListMetaData = MutableLiveData()
            loadList()
        }
        return houseListMetaData as MutableLiveData<HouseList>
    }



    private fun loadList() {
        ApiManager.getHouseList()
                .subscribe(object : Observer<HouseList> {
                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onNext(houseList: HouseList) {
                        houseListMetaData!!.value = houseList
                    }

                    override fun onError(e: Throwable) {

                    }

                    override fun onComplete() {

                    }
                })
    }

}
