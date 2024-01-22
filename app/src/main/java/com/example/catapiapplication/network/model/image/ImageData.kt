package com.example.catapi

import com.google.gson.annotations.SerializedName


data class ImageData (

  @SerializedName("id"     ) var id     : String?           = null,
  @SerializedName("url"    ) var url    : String?           = null,
  @SerializedName("breeds" ) var breeds : ArrayList<CatBreeds> = arrayListOf(),
  @SerializedName("width"  ) var width  : Int?              = null,
  @SerializedName("height" ) var height : Int?              = null

)