package com.example.amgad.domain.model.HrRequestModel

import kotlinx.serialization.Serializable

@Serializable
data class HrRequestItemsScreenModel(
    val id: String,
    val name: String,
    val type: IRequestType,
    val time: String,
    val status: RequestStatus
)