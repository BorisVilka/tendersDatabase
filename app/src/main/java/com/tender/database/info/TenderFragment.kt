package com.tender.database.info

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.tender.database.info.api.Answer
import com.tender.database.info.databinding.FragmentResultBinding
import com.tender.database.info.databinding.FragmentTenderBinding


class TenderFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
        name = arguments?.getString("key","\uD83C\uDDED\uD83C\uDDFA Hungary").toString()
        id = arguments?.getString("id","").toString()
        value = arguments?.getSerializable("value") as Answer
    }
    private lateinit var name: String
    private lateinit var id: String
    private lateinit var value: Answer
    private lateinit var navController: NavController
    private lateinit var binding: FragmentTenderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTenderBinding.inflate(inflater,container,false)
        navController = Navigation.findNavController(requireActivity(),R.id.fragmentContainerView)
        binding.textView6.text = name
        binding.textView7.text = "Tender ID: $id"
        binding.textView13.setOnClickListener {
            navController.popBackStack(R.id.inputFragment,false)
        }
        binding.textView14.setOnClickListener {
            navController.popBackStack(R.id.startFragment,false)
        }
        if(value.purchaser_name==null) value.purchaser_name = value.purchaser!!.name
        binding.incude.tender = value
        binding.incude.invalidateAll()
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TenderFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}