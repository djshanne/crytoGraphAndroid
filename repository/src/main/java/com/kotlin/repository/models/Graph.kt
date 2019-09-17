package com.kotlin.repository.models

data class Graph(
    val description: String,
    val name: String,
    val period: String,
    val status: String,
    val unit: String,
    val values: List<Value>
)