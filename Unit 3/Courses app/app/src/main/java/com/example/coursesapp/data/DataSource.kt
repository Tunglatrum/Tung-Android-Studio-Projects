package com.example.coursesapp.data

import com.example.coursesapp.R
import com.example.coursesapp.model.Topic

object DataSource {
    val topics = listOf(
        Topic(R.string.architecture, 58, R.drawable.architecture),
        Topic(R.string.crafts, 121, R.drawable.crafts_image_150x150),
        Topic(R.string.business, 78, R.drawable.business_image_150x150),
        Topic(R.string.culinary, 118, R.drawable.culinary_image_150x150),
        Topic(R.string.design, 423, R.drawable.design_image_150x150),
        Topic(R.string.fashion, 92, R.drawable.fashion_image_150x150),
        Topic(R.string.film, 165, R.drawable.film_image_150x150),
        Topic(R.string.gaming, 164, R.drawable.gaming_image_150x150),
        Topic(R.string.drawing, 326, R.drawable.drawing_image_150x150),
        Topic(R.string.lifestyle, 305, R.drawable.lifestyle_image_150x150),
        Topic(R.string.music, 212, R.drawable.music_image_150x150),
        Topic(R.string.painting, 172, R.drawable.painting_image_150x150),
        Topic(R.string.photography, 321, R.drawable.photography_image_150x150),
        Topic(R.string.tech, 118, R.drawable.tech_image_150x150)
    )
}