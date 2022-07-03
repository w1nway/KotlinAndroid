package com.example.hw1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.hw1.CarRepository.cars
import com.example.hw1.databinding.FragmentInformationBinding

class InformationFragment : Fragment(R.layout.fragment_information) {
    private var _binding: FragmentInformationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_information, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentInformationBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)


        val args by navArgs<InformationFragmentArgs>()
        val text = args.argument

        with(binding) {
            tvIdInformation.text = "Id of car: ${cars[text].id.toString()}"
            tvCarInformation.text = "Car: ${cars[text].name}"
            tvCreatorInformation.text = "Creator: ${cars[text].creator}"
            Glide.with(this@InformationFragment).load(cars[text].url).into(ivInfo)
        }
    }
}