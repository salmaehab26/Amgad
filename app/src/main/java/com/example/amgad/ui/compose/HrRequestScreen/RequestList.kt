package com.example.amgad.ui.compose.HrRequestScreen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.amgad.domain.model.HrRequestModel.HrRequestItemsScreenModel

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
