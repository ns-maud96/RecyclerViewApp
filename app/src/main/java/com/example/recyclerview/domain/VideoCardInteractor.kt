package com.example.recyclerview.domain

import com.example.recyclerview.presentation.recycler.VideoCard

interface VideoCardInteractor {

    fun loadVideoCardModels(): List<VideoCard>
}