package com.example.amgad.domain.model.MyLibraryModel

data class MyLibraryModel (
    val title:String,
    val description: String?, val image:Int?, val type: ItemType,val videoUrl: Int? = null)