package com.example.hw1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hw1.databinding.FragmentStoreBinding

class StoreFragment : Fragment(R.layout.fragment_store) {

    private var _binding: FragmentStoreBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentStoreBinding.bind(view)

        with(binding) {
            btnUnactive.setOnClickListener {
                findNavController().navigate(
                    R.id.action_storeFragment_to_unactiveFragment,
                    UnactiveFragment.createBundle((tvStore.text ?: "Error").toString()))
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}