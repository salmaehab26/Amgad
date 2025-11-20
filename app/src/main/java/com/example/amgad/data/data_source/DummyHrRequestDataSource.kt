package com.example.amgad.data.data_source

import com.example.amgad.domain.model.HrRequestModel.DocumentRequestType
import com.example.amgad.domain.model.HrRequestModel.EquipmentRequestType
import com.example.amgad.domain.model.HrRequestModel.LeaveDayRequestType
import com.example.amgad.domain.model.HrRequestModel.RemoteRequestType
import com.example.amgad.domain.model.HrRequestModel.HrRequestItemsScreenModel
import com.example.amgad.domain.model.HrRequestModel.RequestStatus
import kotlinx.coroutines.delay

class DummyHrRequestDataSource {
    suspend fun fetchHrRequests(): List<HrRequestItemsScreenModel> {
        delay(250)

        return listOf(
            HrRequestItemsScreenModel(
                id = "1",
                name = "نورة إبراهيم",
                time = "3 نوفمبر 2024 - 12:47 م",
                status = RequestStatus.ACCEPTED,
                type = EquipmentRequestType()
            ),
            HrRequestItemsScreenModel(
                id = "2",
                name = "سارة العتيبي",
                time = "4 نوفمبر 2024 - 09:15 ص",
                status = RequestStatus.REJECTED,
                type = RemoteRequestType()

            ),
            HrRequestItemsScreenModel(
                id = "3",
                name = "ليان الحربي",
                time = "4 نوفمبر 2024 - 02:30 م",
                status = RequestStatus.REJECTED,
                type = DocumentRequestType()
            ),

            HrRequestItemsScreenModel(
                id = "4",
                name = "أمل القحطاني",
                time = "5 نوفمبر 2024 - 10:05 م",
                status = RequestStatus.ACCEPTED,
                type = EquipmentRequestType()
            ),
            HrRequestItemsScreenModel(
                id = "5",
                name = "نوف السبيعي",
                time = "5 نوفمبر 2024 - 03:22 م",
                status = RequestStatus.PENDING,
                type = RemoteRequestType()
            ),
            HrRequestItemsScreenModel(
                id = "6",
                name = "ريم العنزي",
                time = "6 نوفمبر 2024 - 01:10 م",
                status = RequestStatus.REJECTED,
                type = LeaveDayRequestType()
            ),
            HrRequestItemsScreenModel(
                id = "7",
                name = "منيرة الدوسري",
                time = "6 نوفمبر 2024 - 05:45 م",
                status = RequestStatus.PENDING,
                type = DocumentRequestType()
            ),
            HrRequestItemsScreenModel(
                id = "8",
                name = "سارة العتيبي",
                time = "4 نوفمبر 2024 - 09:15 ص",
                status = RequestStatus.PENDING,
                type = RemoteRequestType()
            ),
            HrRequestItemsScreenModel(
                id = "9",
                name = "أمل القحطاني",
                time = "5 نوفمبر 2024 - 10:05 م",
                status = RequestStatus.ACCEPTED,
                type = EquipmentRequestType()
            ),
//            HrRequestItemsScreenModel(
//                id = "10",
//                name = "مي الغامدي",
//                time = "8 نوفمبر 2024 - 04:15 م",
//                status = RequestStatus.PENDING,
//                type = RemoteRequestType()
//            ),
//            HrRequestItemsScreenModel(
//                id = "11",
//                name = "نورة المطيري",
//                time = "8 نوفمبر 2024 - 06:30 م",
//                status = RequestStatus.REJECTED,
//                type = DocumentRequestType()
//            ),
//            HrRequestItemsScreenModel(
//                id = "12",
//                name = "أمل القحطاني",
//                time = "5 نوفمبر 2024 - 10:05 م",
//                status = RequestStatus.ACCEPTED,
//                type = WeHearYouRequestType()
//            ),
//            HrRequestItemsScreenModel(
//                id = "13",
//                name = "هيفاء الزهراني",
//                time = "9 نوفمبر 2024 - 12:15 م",
//                status = RequestStatus.PENDING,
//                type = LeaveDayRequestType()
//            ),
//            HrRequestItemsScreenModel(
//                id = "14",
//                name = "لمى الشهراني",
//                time = "10 نوفمبر 2024 - 10:40 ص",
//                status = RequestStatus.REJECTED,
//                type = RemoteRequestType()
//            ),
//            HrRequestItemsScreenModel(
//                id = "15",
//                name = "العنود الرشيد",
//                time = "10 نوفمبر 2024 - 01:55 م",
//                status = RequestStatus.ACCEPTED,
//                type = DocumentRequestType()
//            ),
//            HrRequestItemsScreenModel(
//                id = "16",
//                name = "جنى الشمري",
//                time = "13 نوفمبر 2024 - 05:00 م",
//                status = RequestStatus.PENDING,
//                type = WeHearYouRequestType()
//            ),
//            HrRequestItemsScreenModel(
//                id = "17",
//                name = "أمل القحطاني",
//                time = "5 نوفمبر 2024 - 10:05 م",
//                status = RequestStatus.ACCEPTED,
//                type = RemoteRequestType()
//            ),
//            HrRequestItemsScreenModel(
//                id = "18",
//                name = "رغد السبيعي",
//                time = "12 نوفمبر 2024 - 09:10 ص",
//                status = RequestStatus.REJECTED,
//                type = EquipmentRequestType()
//            ),
//            HrRequestItemsScreenModel(
//                id = "19",
//                name = "عهود العتيبي",
//                time = "12 نوفمبر 2024 - 02:20 م",
//                status = RequestStatus.ACCEPTED,
//                type = LeaveDayRequestType(),
//
//                ),
//            HrRequestItemsScreenModel(
//                id = "20",
//                name = "جنى الشمري",
//                time = "13 نوفمبر 2024 - 05:00 م",
//                status = RequestStatus.PENDING,
//                type = DocumentRequestType()
//            )
        )
    }
}