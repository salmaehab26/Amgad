package com.example.amgad.ui.compose.HrRequestScreen

import com.example.amgad.domain.model.HrRequestModel.DocumentRequestType
import com.example.amgad.domain.model.HrRequestModel.EquipmentRequestType
import com.example.amgad.domain.model.HrRequestModel.RemoteRequestType
import com.example.amgad.domain.model.HrRequestModel.RequestStatus
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.amgad.domain.model.HrRequestModel.HrRequestItemsScreenModel
import com.example.amgad.ui.compose.TopBar
import com.example.amgad.ui.viewModel.HrScreenViewModel.HrRequestScreenViewModel

@Composable
fun HRRequestScreen(
    viewModel: HrRequestScreenViewModel = hiltViewModel(),
    onNavigateBack: () -> Unit,
    onNavigateToDetails: (HrRequestItemsScreenModel) -> Unit
) {
    val filteredItems by viewModel.filteredItems.collectAsState()
    val selectedStatus by viewModel.selectedStatus.collectAsState()

    HRRequestScreenPart(
        items = filteredItems,
        status = selectedStatus,

        onStatusSelected = { viewModel.onStatusSelected(it) },
        onNavigateBack = onNavigateBack, onNavigateToDetails = onNavigateToDetails

    )
}


@Composable
fun HRRequestScreenPart(
    onNavigateToDetails: (HrRequestItemsScreenModel) -> Unit ,

    items: List<HrRequestItemsScreenModel>,
    status: RequestStatus,
    onStatusSelected: (RequestStatus) -> Unit,
    onNavigateBack: () -> Unit
) {

    val tabs = listOf("مرفوضة", "مقبولة", "بانتظار موافقتك")
    val statuses = listOf(RequestStatus.REJECTED, RequestStatus.ACCEPTED, RequestStatus.PENDING)
    val selectedTab = statuses.indexOf(status).takeIf { it >= 0 } ?: 2

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F5FB))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TopBar(title = "طلبات مرسلة إليك في انتظار قرارك", onNavigateBack = onNavigateBack,
            showIcon = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        TabsRow(tabs = tabs, selectedTab = selectedTab, onTabSelected = { index ->
            onStatusSelected(statuses[index])
        })

        Spacer(modifier = Modifier.height(16.dp))

        RequestList(items,onNavigateToDetails)
    }
}



@Composable
fun RequestList(
    items: List<HrRequestItemsScreenModel>,
    onNavigateToDetails: (HrRequestItemsScreenModel) -> Unit
) {
    LazyColumn {
        items(items) { item ->
            RequestCard(item, onCardClick ={onNavigateToDetails(item)} )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HrRequestPreview() {
    val mockItems = listOf(
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
    )
    HRRequestScreenPart(
        items = mockItems,
        status = RequestStatus.PENDING,
        onStatusSelected = {}, onNavigateBack = {}, onNavigateToDetails = {}
    )
}