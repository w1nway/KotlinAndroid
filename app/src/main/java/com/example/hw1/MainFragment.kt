package com.example.hw1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.hw1.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private var adapter: CarAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)
        initAdapter()
    }

    private fun initAdapter() {
        adapter = CarAdapter(
            CarRepository.cars,
            Glide.with(this)

        ) {
            val action = MainFragmentDirections.actionMainFragmentToInformationFragment(it.id)
             binding.root.findNavController().navigate(action)
        }
        binding.rvMain.adapter = adapter
        binding.rvMain.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroyView()
    }
}