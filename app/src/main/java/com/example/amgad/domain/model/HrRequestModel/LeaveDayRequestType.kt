package com.example.amgad.domain.model.HrRequestModel

import com.example.amgad.ui.theme.HrLeaveBorder
import com.example.amgad.ui.theme.HrLeaveDayBackground
import com.example.amgad.ui.theme.HrLeaveText

class LeaveDayRequestType : IRequestType {
    override val title = "طلب إجازة"
    override val titleColor = HrLeaveText
    override val backgroundColor = HrLeaveDayBackground
    override val borderColor = HrLeaveBorder
}