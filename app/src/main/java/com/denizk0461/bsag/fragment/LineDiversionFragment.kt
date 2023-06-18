package com.denizk0461.bsag.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.denizk0461.bsag.adapter.LineDiversionAdapter
import com.denizk0461.bsag.databinding.FragmentOverviewBinding
import com.denizk0461.bsag.viewmodel.LineDiversionViewModel

class LineDiversionFragment : AppFragment<FragmentOverviewBinding>() {

    private val lineDiversionAdapter = LineDiversionAdapter()

    private val viewModel: LineDiversionViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOverviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply {
            adapter = lineDiversionAdapter
            layoutManager = LinearLayoutManager(context)
        }

        viewModel.getAllLines().observe(viewLifecycleOwner) { lines ->
            lineDiversionAdapter.setNewData(lines)
        }
//        lineDiversionAdapter.setNewData(listOf(
//            Line(0, "1", LineType.TRAM, LineColor.GREEN_DARK),
//            Line(1, "4", LineType.TRAM, LineColor.RED),
//            Line(2, "57", LineType.BUS, LineColor.ORANGE),
//        ))
    }
}