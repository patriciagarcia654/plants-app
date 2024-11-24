package com.bignerdranch.android.plantsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.bignerdranch.android.plantsapp.databinding.FragmentPlantListBinding


class PlantListFragment : Fragment() {

    private var _binding: FragmentPlantListBinding? = null
    private val binding get() = checkNotNull(_binding) { "Cannot access binding because it is null." }

    private val plantListViewModel: PlantListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlantListBinding.inflate(inflater, container, false)
        binding.plantsRecyclerView.layoutManager = LinearLayoutManager(context)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observe and bind the plant list
        val plants = plantListViewModel.plants
        binding.plantsRecyclerView.adapter = PlantAdapter(plants) { plant ->
            Snackbar.make(
                binding.plantsRecyclerView,
                "${plant.name} Clicked!",
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
