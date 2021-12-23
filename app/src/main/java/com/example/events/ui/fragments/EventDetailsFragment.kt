package com.example.events.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.events.databinding.EventFragmentBinding
import com.example.events.ui.adapter.EventAdapter
import com.google.android.material.chip.Chip

class EventDetailsFragment : Fragment() {

    private lateinit var binding: EventFragmentBinding
    private lateinit var eventDetailsAdapter: EventAdapter
    private lateinit var eventId: TextView
    private lateinit var title: TextView
    private lateinit var description: TextView
    private lateinit var imageView: ImageView
    private lateinit var price: TextView
    private lateinit var date: TextView
    private lateinit var longitude: TextView
    private lateinit var latitude: TextView
    private lateinit var people: Chip

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = EventFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val recyclerEvents = view.findViewById<RecyclerView>(R.id.recycler_details_fragment)
//
//        eventDetailsAdapter = EventDetailsAdapter(requireContext(), )
//        recyclerEvents.adapter = eventDetailsAdapter
//        eventDetailsAdapter.notifyDataSetChanged()
//        val linearLayout =
//            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//        binding.recyclerDetailsFragment.layoutManager = linearLayout
//        binding.recyclerDetailsFragment.adapter = eventDetailsAdapter
//    }
//
//    private fun goToFragment() {
//        binding.recyclerDetailsFragment.setOnClickListener {
//            findNavController().navigate(R.id.action_global_eventFragment)
//        }
//    }
}
