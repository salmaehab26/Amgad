package com.example.amgad.data.dataSource

import com.example.amgad.domain.model.HrRequestItemsScreenModel
import kotlinx.coroutines.delay

class DummyHrRequestDataSource {
    suspend fun fetchHrRequests(): List<HrRequestItemsScreenModel> {
        delay(250)

        return listOf(
            HrRequestItemsScreenModel(
                id = "1",
                title = "طلب #1",
                name = "نورة إبراهيم",
                description = "3 نوفمبر 2024 - 12:47 م",
//                status = RequestStatus.ACCEPTED
            ),
            HrRequestItemsScreenModel(
                id = "2",
                title = "طلب #2",
                name = "سارة العتيبي",
                description = "4 نوفمبر 2024 - 09:15 ص",
//                status = RequestStatus.PENDING
            ),
            HrRequestItemsScreenModel(
                id = "3",
                title = "طلب #3",
                name = "ليان الحربي",
                description = "4 نوفمبر 2024 - 02:30 م",
//                status = RequestStatus.REJECTED
            ),
            HrRequestItemsScreenModel(
                id = "4",
                title = "طلب #4",
                name = "أمل القحطاني",
                description = "5 نوفمبر 2024 - 10:05 ص",
//                status = RequestStatus.ACCEPTED
            ),
            HrRequestItemsScreenModel(
                id = "5",
                title = "طلب #5",
                name = "نوف السبيعي",
                description = "5 نوفمبر 2024 - 03:22 م",
//                status = RequestStatus.PENDING
            ),
            HrRequestItemsScreenModel(
                id = "6",
                title = "طلب #6",
                name = "ريم العنزي",
                description = "6 نوفمبر 2024 - 01:10 م",
//                status = RequestStatus.ACCEPTED
            ),
            HrRequestItemsScreenModel(
                id = "7",
                title = "طلب #7",
                name = "منيرة الدوسري",
                description = "6 نوفمبر 2024 - 05:45 م",
//                status = RequestStatus.PENDING
            ),
            HrRequestItemsScreenModel(
                id = "8",
                title = "طلب #8",
                name = "علياء المطيري",
                description = "7 نوفمبر 2024 - 08:50 ص",
//                status = RequestStatus.REJECTED
            ),
            HrRequestItemsScreenModel(
                id = "9",
                title = "طلب #9",
                name = "شهد الحارثي",
                description = "7 نوفمبر 2024 - 11:40 ص",
//                status = RequestStatus.ACCEPTED
            ),
            HrRequestItemsScreenModel(
                id = "10",
                title = "طلب #10",
                name = "مي الغامدي",
                description = "8 نوفمبر 2024 - 04:15 م",
//                status = RequestStatus.PENDING
            ),
            HrRequestItemsScreenModel(
                id = "11",
                title = "طلب #11",
                name = "نورة المطيري",
                description = "8 نوفمبر 2024 - 06:30 م",
//                status = RequestStatus.REJECTED
            ),
            HrRequestItemsScreenModel(
                id = "12",
                title = "طلب #12",
                name = "جود السبيعي",
                description = "9 نوفمبر 2024 - 09:00 ص",
//                status = RequestStatus.ACCEPTED
            ),
            HrRequestItemsScreenModel(
                id = "13",
                title = "طلب #13",
                name = "هيفاء الزهراني",
                description = "9 نوفمبر 2024 - 12:15 م",
//                status = RequestStatus.PENDING
            ),
            HrRequestItemsScreenModel(
                id = "14",
                title = "طلب #14",
                name = "لمى الشهراني",
                description = "10 نوفمبر 2024 - 10:40 ص",
//                status = RequestStatus.REJECTED
            ),
            HrRequestItemsScreenModel(
                id = "15",
                title = "طلب #15",
                name = "العنود الرشيد",
                description = "10 نوفمبر 2024 - 01:55 م",
//                status = RequestStatus.ACCEPTED
            ),
            HrRequestItemsScreenModel(
                id = "16",
                title = "طلب #16",
                name = "فرح الحربي",
                description = "11 نوفمبر 2024 - 03:30 م",
//                status = RequestStatus.PENDING
            ),
            HrRequestItemsScreenModel(
                id = "17",
                title = "طلب #17",
                name = "دانة القحطاني",
                description = "11 نوفمبر 2024 - 07:45 م",
//                status = RequestStatus.ACCEPTED
            ),
            HrRequestItemsScreenModel(
                id = "18",
                title = "طلب #18",
                name = "رغد السبيعي",
                description = "12 نوفمبر 2024 - 09:10 ص",
//                status = RequestStatus.REJECTED
            ),
            HrRequestItemsScreenModel(
                id = "19",
                title = "طلب #19",
                name = "عهود العتيبي",
                description = "12 نوفمبر 2024 - 02:20 م",
//                status = RequestStatus.ACCEPTED
            ),
            HrRequestItemsScreenModel(
                id = "20",
                title = "طلب #20",
                name = "جنى الشمري",
                description = "13 نوفمبر 2024 - 05:00 م",
//                status = RequestStatus.PENDING
            )
        )
    }
}