import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.example.amgad.ui.compose.MainScreen.AmjadConsultantCard
import com.example.amgad.ui.compose.MainScreen.AssessmentCard
import com.example.amgad.ui.compose.MainScreen.FeelingBox
import com.example.amgad.ui.compose.MainScreen.HrCard
import com.example.amgad.ui.compose.MainScreen.HrRequestCard
import com.example.amgad.ui.compose.MainScreen.ImageSliderCard
import com.example.amgad.ui.compose.MainScreen.MostUsedOffersPart
import com.example.amgad.ui.compose.MainScreen.NewsCardPart
import com.example.amgad.ui.compose.MainScreen.OffersCategoryPart
import com.example.amgad.ui.compose.MainScreen.PersonlityTest
import com.example.amgad.ui.compose.MainScreen.SurveysTabs
import com.example.amgad.ui.compose.MainScreen.TopAppbar

@Composable
fun HomeScreen(
    onCardClick: () -> Unit,
    onPersonalityClick: () -> Unit,
    navigatProfile: () -> Unit,
    navigatAttendence: () -> Unit,
    navigatHrRequest: () -> Unit,
    navigatMyLibrary: () -> Unit,
    navigatDocumentAtachement: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            item { TopAppbar(navigatProfile, navigatAttendence) }
            item { ImageSliderCard() }
            item { Spacer(modifier = Modifier.height(24.dp)) }
            item { HrCard(navigatHrRequest) }
            item { Spacer(modifier = Modifier.height(40.dp)) }

            item { HrRequestCard() }
            item { Spacer(modifier = Modifier.height(30.dp)) }

            item { AmjadConsultantCard(onClick = onCardClick) }
            item { PersonlityTest(onClick = onPersonalityClick) }
            item { Spacer(modifier = Modifier.height(40.dp)) }
            item { AssessmentCard() }
            item { Spacer(modifier = Modifier.height(20.dp)) }

            item { SurveysTabs() }
            item { NewsCardPart() }
            item { Spacer(modifier = Modifier.height(40.dp)) }

            item {
                OffersCategoryPart(
                    navigatMyLibrary = navigatMyLibrary
                )
            }
            item { Spacer(modifier = Modifier.height(40.dp)) }

            item { MostUsedOffersPart(navigatDocumentAtachement = navigatDocumentAtachement) }

        }
        FeelingBox(modifier = Modifier.align(Alignment.BottomCenter))
    }

}

