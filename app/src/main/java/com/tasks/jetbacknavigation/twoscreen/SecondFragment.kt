package com.tasks.jetbacknavigation.twoscreen

import android.annotation.SuppressLint
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.tasks.jetbacknavigation.R
import com.tasks.jetbacknavigation.databinding.SecondFragmentBinding

class SecondFragment:Fragment() {
    private var _binding:SecondFragmentBinding?=null
    private val binding get() = _binding
    private  val args:SecondFragmentArgs? by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=SecondFragmentBinding.inflate(inflater,container,false)
        return binding?.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Second Fragment"
        val inflater = TransitionInflater.from(requireContext())
        enterTransition = inflater.inflateTransition(R.transition.slide_right)

            binding?.argument?.text="Hello,"+args?.name


        binding?.thirdFragment?.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_secondFragment_to_thirdFragment)
        }

        binding?.globalDestination?.setOnClickListener {
            val action = SecondFragmentDirections.actionSecondFragmentToGlobalDestination(R.id.action_globalDestination_to_secondFragment)
            findNavController().navigate(action)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}