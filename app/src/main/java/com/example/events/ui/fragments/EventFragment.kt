package com.example.events.ui.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.events.databinding.EventFragmentBinding

class EventFragment : Fragment() {
    private lateinit var binding: EventFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = EventFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}
