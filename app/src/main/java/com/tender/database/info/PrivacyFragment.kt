package com.tender.database.info

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.tender.database.info.databinding.FragmentPrivacyBinding


class PrivacyFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }
    private lateinit var binding: FragmentPrivacyBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPrivacyBinding.inflate(inflater,container,false)
        navController = Navigation.findNavController(requireActivity(),R.id.fragmentContainerView)
        binding.button2.setOnClickListener {
            requireActivity().getSharedPreferences("prefs", Context.MODE_PRIVATE)
                .edit()
                .putBoolean("privacy",false)
                .apply()
            navController.popBackStack()
            navController.navigate(R.id.startFragment)
        }
        binding.button3.setOnClickListener {
            navController.popBackStack()
        }
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PrivacyFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}