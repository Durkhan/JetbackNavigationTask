package com.tasks.jetbacknavigation.mainscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.tasks.jetbacknavigation.R
import com.tasks.jetbacknavigation.databinding.FragmentFirstBinding

class FirstFragment:Fragment() {
    private var _binding :FragmentFirstBinding?=null
    private val binding get()=_binding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentFirstBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "First Fragment"

         binding?.button?.setOnClickListener {
             val name:String=binding?.editTextTextPersonName?.text.toString()
             val navDirections=FirstFragmentDirections.actionFirstFragmentToSecondFragment(name)
             Navigation.findNavController(it).navigate(navDirections)
         }
        requireActivity().onBackPressedDispatcher.addCallback{
            requireActivity().finishAffinity()
        }

        binding?.globalDestination?.setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToGlobalDestination(R.id.action_globalDestination_to_firstFragment)
            findNavController().navigate(action)

        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}