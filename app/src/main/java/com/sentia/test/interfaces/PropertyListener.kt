package com.sentia.test.interfaces

import com.sentia.test.network.model.HouseDetails

/**
 * Created by don.chummar on 22/3/18.
 */
interface PropertyListener {
    fun onPropertySelected(houseDetails : HouseDetails)
}