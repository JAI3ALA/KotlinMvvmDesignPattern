package com.bala.core.kotlin.domain.entity

data class PhotoEntity(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)