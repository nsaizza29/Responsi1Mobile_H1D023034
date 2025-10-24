package com.unsoed.responsi1mobileh1d023034.data.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("crest")
    val crest: String?,

    @SerializedName("venue")
    val venue: String?,

    @SerializedName("founded")
    val founded: Int?,

    @SerializedName("clubColors")
    val clubColors: String?,

    @SerializedName("website")
    val website: String?,

    @SerializedName("coach")
    val coach: Coach?,

    @SerializedName("squad")
    val squad: List<Player>?
)

data class Coach(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("firstName")
    val firstName: String?,

    @SerializedName("lastName")
    val lastName: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("dateOfBirth")
    val dateOfBirth: String?,

    @SerializedName("nationality")
    val nationality: String?,

    @SerializedName("contract")
    val contract: Contract?
)

data class Contract(
    @SerializedName("start")
    val start: String?,

    @SerializedName("until")
    val until: String?
)

data class Player(
    @SerializedName("id")
    val id: Int?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("position")
    val position: String?,

    @SerializedName("dateOfBirth")
    val dateOfBirth: String?,

    @SerializedName("nationality")
    val nationality: String?,

    @SerializedName("shirtNumber")
    val shirtNumber: Int?
)

