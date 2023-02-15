package com.tender.database.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.tender.database.info.databinding.FragmentStartBinding


class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStartBinding.inflate(inflater,container,false)
        navController = Navigation.findNavController(requireActivity(),R.id.fragmentContainerView)
        binding.procurent.setOnClickListener {
            navController.navigate(R.id.procurentFragment)
        }
        binding.hun.setOnClickListener {
            navController.navigate(R.id.inputFragment,Bundle().apply {
                    putString("key",binding.hun.text.toString())
                }
            )
        }
        binding.pol.setOnClickListener {
            navController.navigate(R.id.inputFragment,Bundle().apply {
                putString("key",binding.pol.text.toString())
                }
            )
        }
        binding.rom.setOnClickListener {
            navController.navigate(R.id.inputFragment,Bundle().apply {
                putString("key",binding.rom.text.toString())
                }
            )
        }
        binding.spain.setOnClickListener {
            navController.navigate(R.id.inputFragment,Bundle().apply {
                putString("key",binding.spain.text.toString())
                }
            )
        }
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StartFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}