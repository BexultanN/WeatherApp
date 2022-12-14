package com.example.weatherapp.ui.settingsPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherapp.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SettingsPageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sendFeedbackTextview.setOnClickListener() {
            viewModel.sendFeedback(requireContext())
        }

        binding.temperatureFormatButton.setOnClickListener(){
            viewModel.onToggleTemperatureFormat()
        }

        binding.darkModeSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            viewModel.toDarkMode(isChecked)
        }

        viewModel.currentTemperatureType.observe(viewLifecycleOwner) { type ->
            binding.temperatureFormatButton.text = type.toFormattedString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}