package com.sentia.test.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sentia.test.R
import com.sentia.test.network.model.HouseDetails
import com.sentia.test.presenter.SharedModel
import kotlinx.android.synthetic.main.detail_fragment.*

/**
 * Created by don.chummar on 22/3/18.
 */
class DetailFragment : Fragment() {

    private var sharedModel: SharedModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.detail_fragment, null)
        sharedModel = ViewModelProviders.of(activity).get(SharedModel::class.java)
        sharedModel!!.selected.observe(this, Observer { houseDetails -> selectedProperty(houseDetails) })
        return view
    }


    /**
     * fun to update property title (id is same for all property so using title)
     */
    fun selectedProperty(houseDetails: HouseDetails?) {
        propertyId!!.text = houseDetails!!.title.toString()
    }
}