package com.sentia.test.network;

import com.sentia.test.network.model.HouseList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by don.chummar on 22/3/18.
 */

public interface SentiaApi {

    @GET
    Observable<HouseList> getHouseList(@Url String url);
}
