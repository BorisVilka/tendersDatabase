package com.tender.database.info

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch


class LoaderFragment : Fragment() {

    private lateinit var name: String
    private lateinit var id: String
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
        name = arguments?.getString("key","\uD83C\uDDED\uD83C\uDDFA Hungary").toString()
        id = arguments?.getString("id","").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        navController = Navigation.findNavController(requireActivity(),R.id.fragmentContainerView)
        flow<Unit> {
            coroutineScope {
                launch {
                    //println("GEGEGEG")
                    var code = "hu"
                    if(name.lowercase().contains("po")) code = "po"
                    else if(name.lowercase().contains("ro")) code = "ro"
                    else if(name.lowercase().contains("sp")) code = "es"
                    var get = MyApp.api.getHun(id,code).execute()
                    var error = get.errorBody()
                    if(error!=null) {
                        Log.d("TAG", error.toString())
                        requireActivity().runOnUiThread {
                            navController.popBackStack()
                            navController.navigate(R.id.notFoundFragment, Bundle().apply {
                                putString("key",name)
                                putString("id",id)
                                }
                            )
                        }
                    } else {
                        requireActivity().runOnUiThread {
                            navController.popBackStack()
                            navController.navigate(R.id.resultFragment, Bundle().apply {
                                putString("key",name)
                                putString("id",id)
                                putSerializable("value",get.body())
                             }
                            )
                        }
                    }
                }
            }
        }.launchIn(CoroutineScope(Dispatchers.IO))

        return inflater.inflate(R.layout.fragment_loader, container, false)
    }

    suspend fun get() {
        coroutineScope {

        }
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoaderFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}