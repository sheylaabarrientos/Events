package com.example.events.ui.adapter

// class EventDetailsAdapter(
//    val context: Context,
//    var dataSet: List<EventsItem>
// ) : RecyclerView.Adapter<EventDetailsAdapter.ViewHolder>() {
//
//    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        var eventId: TextView? = view.findViewById(R.id.event_id)
//        var title: TextView = view.findViewById(R.id.titleTextView)
//        var description: TextView = view.findViewById(R.id.description_textView)
//        var imageView: ImageView = view.findViewById(R.id.event_details_image)
//        var price: TextView = view.findViewById(R.id.price_textView)
//        var date: TextView = view.findViewById(R.id.date_textView)
//        var longitude: TextView = view.findViewById(R.id.longitude_textView)
//        var latitude: TextView = view.findViewById(R.id.latitude_textView)
//        val people: Chip? = view.findViewById(R.id.recycler_peoples)
//
//        init {
//            eventId = itemView.event_id
//            title = itemView.titleTextView
//            description = itemView.description_textView
//            imageView = itemView.imageView5
//            price = itemView.price_textView
//            date = itemView.date_textView
//            longitude.item_search_cardView.longitude_textView
//            latitude.item_search_cardView.latitude_textView
//            people?.item_search_cardView?.recycler_peoples
//        }
//    }
//
//    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(viewGroup.context)
//            .inflate(R.layout.item_events_details_list, viewGroup, false)
//
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//
//        holder.eventId?.text = dataSet[position].id
//        holder.description.text = dataSet[position].description
//        holder.title.text = dataSet[position].title
//        holder.price.text = dataSet[position].price.toString()
//        holder.date.text = dataSet[position].date.toString()
//        holder.longitude.text = dataSet[position].longitude.toString()
//        holder.latitude.text = dataSet[position].latitude.toString()
//
//        holder.people?.text = dataSet[position].people.toString()
//
//        holder.imageView?.let {
//            Glide.with(holder.imageView.context)
//                .load(dataSet[position].image)
//                .into(holder.imageView)
//        }
//    }
//
//    override fun getItemCount() = dataSet.size
// }
