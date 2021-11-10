package com.example.recyclerview.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recyclerview.R
import com.example.recyclerview.presentation.recycler.DialogAdapter
import com.example.recyclerview.presentation.recycler.VideoCard
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_dialog.*


class DialogFragment(private val listener: (VideoCard) -> Unit) : BottomSheetDialogFragment() {

    companion object {
        const val TAG = "DialogFragment"
        fun newInstance(listener: (VideoCard) -> Unit) = DialogFragment(listener)
    }

    private val adapter by lazy { DialogAdapter() }
    private val viewModel by lazy { DialogFragmentViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_dialog, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObserves()
        recyclerDialog.adapter = adapter

        adapter.setOnItemClickListener { videoCard ->
            listener.invoke(videoCard)
            dismiss()
        }
    }

    private fun initObserves() {
        viewModel.messages.observe(viewLifecycleOwner) { messages ->
            adapter.submitList(messages)
        }
    }
}




