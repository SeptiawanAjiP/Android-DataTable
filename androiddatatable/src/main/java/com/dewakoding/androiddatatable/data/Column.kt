package com.dewakoding.androiddatatable.data

import com.google.gson.annotations.SerializedName

data class Column(

	@field:SerializedName("data")
	val data: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)
