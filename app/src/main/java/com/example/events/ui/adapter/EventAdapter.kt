package com.example.events.ui.adapter

import android.content.Context
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

class EventAdapter(
    val context: Context,
    var dataSet: List<EventsItem>
) : RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var eventId: TextView? = view.findViewById(R.id.event_id)
        var title: TextView = view.findViewById(R.id.titleTextView)
        var description: TextView = view.findViewById(R.id.description_textView)
        var imageView: ImageView = view.findViewById(R.id.imageView5)

        init {
            eventId = itemView.event_id
            title = itemView.titleTextView
            description = itemView.description_textView
            imageView = itemView.imageView5
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_events_list, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.eventId?.text = dataSet[position].id
        holder.description.text = dataSet[position].description
        holder.title.text = dataSet[position].title

        holder.imageView?.let {
            Glide.with(holder.imageView.context)
                .load(dataSet[position].image)
                .into(holder.imageView)
        }
    }

    override fun getItemCount() = dataSet.size
}
