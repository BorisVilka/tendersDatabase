package com.tender.database.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.tender.database.info.databinding.FragmentProcurentBinding


class ProcurentFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    private lateinit var binding: FragmentProcurentBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProcurentBinding.inflate(inflater,container,false)
        navController = Navigation.findNavController(requireActivity(),R.id.fragmentContainerView)
        binding.back.setOnClickListener {
            navController.popBackStack()
        }
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProcurentFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}