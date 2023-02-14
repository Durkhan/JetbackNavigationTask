package com.tasks.jetbacknavigation.twoscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.tasks.jetbacknavigation.R
import com.tasks.jetbacknavigation.databinding.FragementThirdBinding

class ThirdFragment:Fragment(){
    private var _binding:FragementThirdBinding?=null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragementThirdBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Third Fragment"
        binding?.mainScreen?.setOnClickListener {
            Navigation.findNavController(it).popBackStack(R.id.firstFragment, false)
        }

        requireActivity().onBackPressedDispatcher.addCallback{
            findNavController().popBackStack(R.id.firstFragment, false)

        }
        binding?.globalDestination?.setOnClickListener {
            val action = ThirdFragmentDirections.actionThirdFragmentToGlobalDestination(R.id.action_globalDestination_to_thirdFragment)
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }



}