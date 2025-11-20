package com.example.amgad.domain.model.HrRequestModel

import com.example.amgad.ui.theme.HrEquipmentBackground
import com.example.amgad.ui.theme.HrEquipmentBorder
import com.example.amgad.ui.theme.HrEquipmentText

class EquipmentRequestType : IRequestType {
    override val title = "طلب عهدة"
    override val titleColor = HrEquipmentText
    override val backgroundColor = HrEquipmentBackground
    override val borderColor = HrEquipmentBorder
}