package com.tecsup.evaluacion04app.pokedetail

import com.google.gson.annotations.SerializedName

data class DetailResponse (
    @SerializedName("order"          ) var order        : Int?              = null,
    @SerializedName("pokemon"        ) var pokemon      : Pokemon?          = Pokemon(),
    @SerializedName("types"          ) var types        : ArrayList<Types>  = arrayListOf(),
    @SerializedName("version_group"  ) var versionGroup : VersionGroup?     = VersionGroup()
)

data class Pokemon (
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("url"  ) var url  : String? = null
)


data class Type (
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("url"  ) var url  : String? = null
)

data class Types (
    @SerializedName("slot" ) var slot : Int?  = null,
    @SerializedName("type" ) var type : Type? = Type()
)

data class VersionGroup (
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("url"  ) var url  : String? = null
)