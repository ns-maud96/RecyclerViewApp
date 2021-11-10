package com.example.recyclerview.data

import com.example.recyclerview.domain.VideoCardInteractor
import com.example.recyclerview.presentation.recycler.VideoCard

class DataSource: VideoCardInteractor{

    private val videoCardModels: List<VideoCard> = loadModels()

    private fun loadModels(): List<VideoCard> {
        val videoCardModelsList = mutableListOf<VideoCard>()

        for (i in 3000 until 3100 step 11) {
            videoCardModelsList.add(
                VideoCard(
                    model = "RTX$i"
                )
            )
        }
        return videoCardModelsList
    }

    override fun loadVideoCardModels(): List<VideoCard> {
        return videoCardModels
    }
}