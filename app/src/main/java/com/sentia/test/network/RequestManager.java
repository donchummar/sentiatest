package com.sentia.test.network;

import android.content.Context;


/**
 * Created by  don.chummar on 22/3/18.
 */

public class RequestManager {

    /**
     * Log cat.
     */
    private static final String TAG = RequestManager.class.getSimpleName();

    /**
     * Singleton pattern.
     */
    private static RequestManager sInstance;


    /**
     * Manage app sections.
     */
    public RequestManager(Context context) {
        if(sInstance == null) {
        }
    }




    /**
     * Retrieve Sections manager instance.
     *
     * @param context context used to instantiate internal component.
     * @return unique instance.
     */
    public static RequestManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new RequestManager(context);
        }
        return sInstance;
    }

}
