package com.example.a30daysofrapmusic.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Songs(
    @StringRes val nameRes: Int,
    @StringRes val artistRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int
)