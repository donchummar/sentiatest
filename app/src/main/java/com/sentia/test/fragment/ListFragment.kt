package com.sentia.test.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import com.sentia.test.R
import com.sentia.test.adapter.HouseListAdapter
import com.sentia.test.interfaces.PropertyListener
import com.sentia.test.network.model.HouseDetails
import com.sentia.test.presenter.SharedModel
import kotlinx.android.synthetic.main.house_list_fragment.*


/**
 * Created by don.chummar on 22/3/18.
 */

class ListFragment : Fragment(), PropertyListener {


    private var listAdapter: HouseListAdapter? = null
    private var sharedModel: SharedModel  = SharedModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.house_list_fragment, null)
        ButterKnife.bind(this, view)
        //sharedModel = ViewModelProviders.of(activity).get(SharedModel::class.java)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        houseList!!.layoutManager = LinearLayoutManager(activity)
        listAdapter = HouseListAdapter(this@ListFragment)
        houseList!!.adapter = listAdapter
    }

    fun updateList(houseList: MutableList<HouseDetails>?) {
        if (houseList != null)
            listAdapter!!.updateList(houseList)
    }


    override fun onPropertySelected(houseDetails: HouseDetails) {
        sharedModel!!.select(houseDetails)
    }
}
