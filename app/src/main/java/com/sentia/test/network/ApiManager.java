package com.sentia.test.network;

import com.sentia.test.network.model.HouseList;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by don.chummar on 22/3/18.
 */

public class ApiManager {

    private Observable<HouseList> videosObservable = null;
    private SentiaApi appService;
    private static ApiManager sInstance;


    public static ApiManager getInstance() {
        if (sInstance == null) {
            sInstance = new ApiManager();
        }
        return sInstance;
    }

    private ApiManager() {
       appService = NetworkModule.getNetworkClient();
    }

    /**
     * Get house list
     *
     */
    public static Observable<HouseList> getHouseList() {
        ApiManager apiManager = getInstance();

        apiManager.videosObservable = apiManager.appService.getHouseList(SentiaApiUrl.lISTAPI)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        return apiManager.videosObservable;
    }
}

