package com.denizk0461.bsag.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.denizk0461.bsag.adapter.LineDiversionAdapter
import com.denizk0461.bsag.databinding.FragmentOverviewBinding
import com.denizk0461.bsag.model.Diversion
import com.denizk0461.bsag.model.Line
import com.denizk0461.bsag.util.setRainbowProgressCircle
import com.denizk0461.bsag.util.showErrorSnackBar
import com.denizk0461.bsag.viewmodel.LineDiversionViewModel

class LineDiversionFragment : AppFragment<FragmentOverviewBinding>(),
    LineDiversionAdapter.OnClickListener {

    private val lineDiversionAdapter = LineDiversionAdapter(this)

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

//        (binding.recyclerViewContainer as ViewGroup).layoutTransition.enableTransitionType(LayoutTransition.CHANGING)

        viewModel.getLinesWithDiversions().observe(viewLifecycleOwner) { lines ->
            lineDiversionAdapter.setNewData(lines)
        }

        binding.swipeRefreshLayout.setRainbowProgressCircle()
        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.fetchDiversions(context, onFinish = {
                binding.swipeRefreshLayout.isRefreshing = false
            }, onError = { message ->
                binding.swipeRefreshLayout.isRefreshing = false
                context.theme.showErrorSnackBar(binding.rootCoordinatorLayout, message)
            })
        }

    }

    override fun onLineClick(line: Line) {
//        TransitionManager.beginDelayedTransition(binding.recyclerView)
    }

    override fun onDiversionClick(diversion: Diversion) {
        Log.d("asdf", "yo wtf! this is ${diversion.title} you're messin with!")
    }
}