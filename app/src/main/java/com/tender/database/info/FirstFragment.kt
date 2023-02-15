package com.tender.database.info

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.tender.database.info.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }
    private lateinit var binding: FragmentFirstBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater,container,false)
        navController = Navigation.findNavController(requireActivity(),R.id.fragmentContainerView)
        binding.button.setOnClickListener {
            if(requireActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE).getBoolean("privacy",true)) {
                navController.navigate(R.id.startFragment)
            } else {
                navController.navigate(R.id.startFragment)
            }
        }
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}