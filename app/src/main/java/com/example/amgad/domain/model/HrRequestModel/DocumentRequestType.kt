package com.example.amgad.domain.model.HrRequestModel

import com.example.amgad.ui.theme.HrDocumentBackground
import com.example.amgad.ui.theme.HrDocumentBorder
import com.example.amgad.ui.theme.HrDocumentText

class DocumentRequestType : IRequestType {
    override val title = "طلب وثيقة"
    override val titleColor = HrDocumentText
    override val backgroundColor = HrDocumentBackground
    override val borderColor = HrDocumentBorder
}