package com.example.amgad.domain.model.HrRequestModel

import com.example.amgad.ui.theme.HrWeHearYouBackground
import com.example.amgad.ui.theme.HrWeHearYouBorder
import com.example.amgad.ui.theme.HrWeHearYouText

class WeHearYouRequestType : IRequestType {
    override val title = "نسمعك"
    override val titleColor = HrWeHearYouText
    override val backgroundColor = HrWeHearYouBackground
    override val borderColor = HrWeHearYouBorder
}