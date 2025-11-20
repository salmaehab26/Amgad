package com.example.amgad.domain.model.HrRequestModel

import com.example.amgad.ui.theme.HrRemoteBackground
import com.example.amgad.ui.theme.HrRemoteBorder
import com.example.amgad.ui.theme.HrRemoteText

class RemoteRequestType : IRequestType {
    override val title = "طلب عمل عن بعد"
    override val titleColor = HrRemoteText
    override val backgroundColor = HrRemoteBackground
    override val borderColor = HrRemoteBorder
}