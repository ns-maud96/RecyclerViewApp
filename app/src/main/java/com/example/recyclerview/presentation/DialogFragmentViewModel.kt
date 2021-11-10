package com.example.recyclerview.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerview.data.DataSource
import com.example.recyclerview.presentation.recycler.VideoCard
import com.example.recyclerview.domain.VideoCardInteractor

class DialogFragmentViewModel: ViewModel() {

    private val videoCardInteractor: VideoCardInteractor = DataSource()

    val messages: LiveData<List<VideoCard>> get() = _messages
    private val _messages = MutableLiveData<List<VideoCard>>(videoCardInteractor.loadVideoCardModels())

}