package com.sentia.test.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.sentia.test.R
import com.sentia.test.fragment.DetailFragment
import com.sentia.test.fragment.ListFragment
import com.sentia.test.network.model.HouseList
import com.sentia.test.presenter.ListViewModel
import kotlinx.android.synthetic.main.activity_list_detail.*

/**
 * Created by don.chummar on 23/3/18.
 */
class PropertyList : AppCompatActivity() {

    private var fragmentManager: FragmentManager? = null
    private var viewModel: ListViewModel = ListViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_page)
        title = "PropertyList"
        fragmentManager = supportFragmentManager

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            initLandscape()
        } else {
            initPotrait()
        }
        loadData()
    }

    private fun initPotrait() {
        val fragment = fragmentManager?.findFragmentByTag("list")
        if (fragment == null) {
            fragmentManager?.beginTransaction()?.add(R.id.list_container, ListFragment(), "list")?.commit()
        }
    }

    private fun initLandscape() {
        var fragment: Fragment? = fragmentManager?.findFragmentByTag("list")
        if (fragment == null) {
            fragmentManager?.beginTransaction()?.add(R.id.list_container, ListFragment(), "list")?.commit()
        }
        fragment = fragmentManager?.findFragmentByTag("detail")
        if (fragment == null) {
            fragmentManager?.beginTransaction()?.add(R.id.detail_container, DetailFragment(), "detail")?.commit()
        }
    }


    private fun loadData() {
        viewModel?.getHouseList()?.observe(this, Observer { houseList ->
            if (houseList != null) {
                updateUI(houseList)
            }
        })
    }

    private fun updateUI(houseList: HouseList?) {
        if (houseList != null && houseList.data != null) {
            progressBar?.visibility = View.GONE
            val listFragment = fragmentManager?.findFragmentByTag("list") as ListFragment
            listFragment.updateList(houseList.data)
            if (fragmentManager?.findFragmentByTag("detail") != null) {
                val detailFragment = fragmentManager?.findFragmentByTag("detail") as DetailFragment
                detailFragment?.selectedProperty(houseList.data[0])
            }
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_list_page)
            if (fragmentManager?.findFragmentByTag("detail") == null) {
                fragmentManager?.beginTransaction()?.add(R.id.detail_container, DetailFragment(), "detail")?.commit()
            }
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_list_page)
            val fragment = fragmentManager?.findFragmentByTag("detail")
            if (fragment != null) {
                fragmentManager?.beginTransaction()?.remove(fragment)?.commit()
            }
        }
    }

}