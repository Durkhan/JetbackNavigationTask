package com.tasks.jetbacknavigation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.tasks.jetbacknavigation.databinding.GlobalDestinationsBinding

class GlobalDestination:Fragment() {
    private var _binding:GlobalDestinationsBinding?=null
    private val binding get() = _binding
    private  val args:GlobalDestinationArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=GlobalDestinationsBinding.inflate(inflater,container,false)
        return binding?.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Global Destination"
        binding?.back?.setOnClickListener {
           requireActivity().onBackPressed()
        }
        binding?.back?.setOnClickListener {
            Navigation.findNavController(it).navigate(args.id)
        }
        requireActivity().onBackPressedDispatcher.addCallback {
            findNavController().navigate(args.id)

        }

    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}