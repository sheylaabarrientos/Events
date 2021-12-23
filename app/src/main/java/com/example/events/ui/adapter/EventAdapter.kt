package com.example.events.ui.adapter

import android.content.Context
import android.location.Address
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.events.R
import com.example.events.domain.EventsItem
import kotlinx.android.synthetic.main.item_events_list.view.*
import java.text.SimpleDateFormat
import java.util.*
import android.location.Geocoder
import java.lang.Exception
import java.lang.StringBuilder


class EventAdapter(
    val context: Context,
    var dataSet: List<EventsItem>
) : RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var eventId: TextView? = view.findViewById(R.id.event_id)
        var title: TextView = view.findViewById(R.id.titleTextView)
        var description: TextView = view.findViewById(R.id.description_textView)
        var imageView: ImageView = view.findViewById(R.id.event_details_image)
        var price: TextView = view.findViewById(R.id.price_textView)
        var date: TextView = view.findViewById(R.id.date_textView)
        var longitude: TextView = view.findViewById(R.id.longitude_textView)
        var latitude: TextView = view.findViewById(R.id.latitude_textView)
//        val people: Chip? = view.findViewById(R.id.recycler_peoples)

        init {
            eventId = itemView.event_id
            title = itemView.titleTextView
            date = itemView.date_textView
            price = itemView.price_textView
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_events_list, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.eventId?.text = dataSet[position].id
        holder.title.text = dataSet[position].title

        holder.imageView?.let {
            Glide.with(holder.imageView.context)
                .load(dataSet[position].image)
                .into(holder.imageView)
        }

        holder.description.text = dataSet[position].description
        holder.price.text = dataSet[position].price.toString()
        holder.date.text = dataSet[position].date.dateFormatter()
        holder.longitude.text = dataSet[position].longitude.toString()
        holder.latitude.text = dataSet[position].latitude.toString()

//        holder.people?.text = dataSet[position].people.toString()
    }

    override fun getItemCount() = dataSet.size
}

private fun Double.getAdress(context: Context, latLng: EventsItem) {
    val geocoder = Geocoder(context, Locale.getDefault())
    val addresses: List<Address>?
    val address: Address?
    var fulladdress = ""
    addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1)

    if (addresses.isNotEmpty()) {
        address = addresses[0]
        fulladdress =
            address.getAddressLine(0) // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex
        var city = address.getLocality()
        var state = address.getAdminArea()
        var country = address.getCountryName()
        var postalCode = address.getPostalCode()
        var knownName = address.getFeatureName() // Only if available else return NULL
    } else {
        fulladdress = "Location not found"
    }
}

private fun String.dateFormatter(): String {
    val date = Date()
    val format = SimpleDateFormat("dd.MM.yyyy")
    return format.format(date)
}

