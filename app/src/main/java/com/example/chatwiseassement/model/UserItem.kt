package com.example.chatwiseassement.model


import com.google.gson.annotations.SerializedName

data class UserItem(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)