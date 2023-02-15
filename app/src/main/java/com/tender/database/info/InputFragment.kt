package com.tender.database.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.tender.database.info.databinding.FragmentInputBinding

class InputFragment : Fragment() {

    private lateinit var name: String
    private lateinit var url: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
        name = arguments?.getString("key","\uD83C\uDDED\uD83C\uDDFA Hungary").toString()
    }

    private lateinit var binding: FragmentInputBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInputBinding.inflate(inflater,container,false)
        binding.textView4.text = name
        navController = Navigation.findNavController(requireActivity(),R.id.fragmentContainerView)
        binding.sumbit.setOnClickListener {
            if(binding.editTextNumber.text.toString().isEmpty()) {
                Toast.makeText(context,"Please enter a ID!",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            navController.navigate(R.id.loaderFragment,Bundle().apply {
                putString("key",name)
                putString("id",binding.editTextNumber.text.toString().trim())
             }
            )
        }
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InputFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}