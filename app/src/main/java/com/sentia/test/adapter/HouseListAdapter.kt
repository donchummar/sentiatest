package com.sentia.test.adapter

import android.content.res.Configuration
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.sentia.test.R
import com.sentia.test.fragment.ListFragment
import com.sentia.test.interfaces.PropertyListener
import com.sentia.test.network.model.HouseDetails
import com.sentia.test.utils.CircleTransform
import com.sentia.test.utils.SystemUtils
import com.squareup.picasso.Picasso
import java.util.*


/**
 * Created by don.chummar on 22/3/18.
 */


class HouseListAdapter(context: ListFragment) : RecyclerView.Adapter<HouseListAdapter.ListViewHolder>() {

    private var houseList: MutableList<HouseDetails>? = null
    private val listener: PropertyListener

    init {
        listener = context
        houseList = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        var view: View = parent.inflate(R.layout.property_list_item, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var houseDetails = houseList!![position];
        if (SystemUtils.getScreenOrientation(holder.propImage.context) ==  Configuration.ORIENTATION_PORTRAIT){
            Picasso.with(holder.propImage.context).load(houseDetails.photo?.image?.url)
                    .resize(SystemUtils.getSystemWidth(holder.propImage.context), 400)
                    .into(holder.propImage)
        }else{
            Picasso.with(holder.propImage.context).load(houseDetails.photo?.image?.url)
                    .resize(400, SystemUtils.getSystemHeight(holder.propImage.context))
                    .into(holder.propImage)
        }

        Picasso.with(holder.ownerImage.context).load(houseDetails.owner?.avatar?.small?.url)
                .resize(60, 60)
                .transform(CircleTransform())
                .into(holder.ownerImage)
        holder.textBed.text = houseDetails.bedrooms.toString()
        holder.textBath.text = houseDetails.bathrooms.toString()
        holder.textCar.text = houseDetails.carspots.toString()
        holder.textOwnerName.text = houseDetails.owner?.firstName +" " + houseDetails.owner?.lastName
        holder.textAddress1.text = houseDetails.location.address1
        holder.textAddress2.text = houseDetails.location.address2
        holder.suburb.text = houseDetails.location.suburb
        holder.pincode.text =", " +houseDetails.location.postcode
        holder.propImage.setOnClickListener { listener.onPropertySelected(houseDetails) }
        if(houseDetails.isPremium){
            holder.premiumBadge.visibility = View.VISIBLE;
        }else{
            holder.premiumBadge.visibility = View.GONE;
        }
    }

    fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }

    override fun getItemCount(): Int {
        return houseList!!.size
    }


    fun updateList(data: MutableList<HouseDetails>) {
        if (houseList != null) {
            houseList!!.clear()
        }
        houseList = data
        notifyDataSetChanged()
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textBed: TextView
        var propImage: ImageView
        var textBath: TextView
        var textCar: TextView
        var ownerImage: ImageView
        var textAddress1: TextView
        var textAddress2: TextView
        var suburb: TextView
        var pincode: TextView
        var textOwnerName: TextView
        var premiumBadge: ImageView

        init {
            this.textBed = itemView.findViewById<TextView>(R.id.txtBed)
            this.textBath = itemView.findViewById<TextView>(R.id.txtBath)
            this.textCar = itemView.findViewById<TextView>(R.id.txtCar)
            this.textAddress1 = itemView.findViewById<TextView>(R.id.address1)
            this.textAddress2 = itemView.findViewById<TextView>(R.id.address2)
            this.suburb = itemView.findViewById<TextView>(R.id.suburb)
            this.pincode = itemView.findViewById<TextView>(R.id.pincode)
            this.textOwnerName = itemView.findViewById<TextView>(R.id.ownerName)
            this.propImage = itemView.findViewById<ImageView>(R.id.propImage)
            this.ownerImage = itemView.findViewById<ImageView>(R.id.ownerImage)
            this.premiumBadge = itemView.findViewById<ImageView>(R.id.premiumBadge)
        }
    }

}

