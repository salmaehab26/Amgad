package com.example.amgad.data.datasource

import androidx.compose.ui.graphics.Color
import com.example.amgad.R
import com.example.amgad.domain.model.AssessmentModel
import com.example.amgad.domain.model.HrRequestModel
import com.example.amgad.domain.model.ImageSliderModel
import com.example.amgad.domain.model.MostUsedOfferModel
import com.example.amgad.domain.model.NewsCardModel
import com.example.amgad.domain.model.OfferCategoryModel
import com.example.amgad.ui.theme.HrRequestBox1
import com.example.amgad.ui.theme.HrRequestBox2
import com.example.amgad.ui.theme.HrRequestBox3
import com.example.amgad.ui.theme.HrRequestBox4
import com.example.amgad.ui.theme.HrRequestBox5
import com.example.amgad.ui.theme.HrRequestBox6
import com.example.amgad.ui.theme.HrRequestBox7
import kotlinx.coroutines.delay
import kotlin.collections.listOf

class DummyHomeDataSource {
    suspend fun fetchSliderImages(): List<ImageSliderModel> {
        delay(300)
        return listOf(
            ImageSliderModel(R.drawable.banner1),
            ImageSliderModel(R.drawable.banner),
            ImageSliderModel(R.drawable.banner2)
        )
    }

    suspend fun fetchHrRequestCardData(): List<HrRequestModel> {
        delay(300)
        return listOf(
            HrRequestModel("سجل حضوري", HrRequestBox1, R.drawable.ic_we_hear_you),
            HrRequestModel("اعتماداتي", HrRequestBox2, R.drawable.ic_we_hear_you),
            HrRequestModel("إجازاتي", HrRequestBox3, R.drawable.ic_we_hear_you),
            HrRequestModel("عمل عن بعد", HrRequestBox4, R.drawable.ic_we_hear_you),
            HrRequestModel("مستنداتي", HrRequestBox5, R.drawable.ic_we_hear_you),
            HrRequestModel("عُهداتي", HrRequestBox6, R.drawable.ic_we_hear_you),
            HrRequestModel("أذناتي", HrRequestBox7, R.drawable.ic_we_hear_you),
            HrRequestModel("سجل حضوري", HrRequestBox1, R.drawable.ic_we_hear_you),
            HrRequestModel("اعتماداتي", HrRequestBox2, R.drawable.ic_we_hear_you),
            HrRequestModel("إجازاتي", HrRequestBox3, R.drawable.ic_we_hear_you),
            HrRequestModel("عمل عن بعد", HrRequestBox4, R.drawable.ic_we_hear_you),
        )

    }

    suspend fun fetchAssessments(): List<AssessmentModel> {
        delay(250)

        return listOf(
            AssessmentModel(
                "الذكاء العاطفي",
                2,
                9,
                R.drawable.illu_assessment_emotional_intelligence
            ),
            AssessmentModel(
                "القلق", 2,
                9, R.drawable.illu_assessment_emotional_intelligence
            ),
            AssessmentModel(
                "الصحة النفسية العامة",
                2,
                9,
                R.drawable.illu_assessment_depression
            ),
            AssessmentModel(
                "الرضا عن الحياة",
                2,
                9,
                R.drawable.illu_assessment_life_satisfaction
            ),
            AssessmentModel("الاكتئاب", 5, 12, R.drawable.illu_assessment_emotional_intelligence),
            AssessmentModel(
                "جاهزية المدير",
                2,
                9,
                R.drawable.illu_assessment_manager_readiness
            ),
            AssessmentModel(
                "الرفاهية النفسية",
                2,
                9,
                R.drawable.illu_assessment_psychological_well_being
            ),
            AssessmentModel(
                "الوسواس القهري",
                2,
                9,
                R.drawable.illu_assessment_ocd
            ),
            AssessmentModel(
                "تقدير الذات",
                2,
                9,
                R.drawable.illu_assessment_self_esteem
            ),
            AssessmentModel(
                "الضغوط المهنية",
                2,
                9,
                R.drawable.illu_assessment_work_stress
            ),
            AssessmentModel(
                "جاهزية ادارة التغير",
                2,
                9,
                R.drawable.illu_assessment_change_management_readiness
            ),
            AssessmentModel(
                "معنى الحياه",
                2,
                9,
                R.drawable.illu_assessment_life_meaning
            ),
            AssessmentModel(
                "التفكير الابداعي و الابتكار",
                2,
                9,
                R.drawable.illu_assessment_creative_thinking_and_innovation
            ),
            AssessmentModel(
                "الاداء الوظيفي الذاتي",
                2,
                9,
                R.drawable.illu_assessment_self_assessment_of_job_performance
            ),
            AssessmentModel(
                "الوسواس القهري",
                2,
                9,
                R.drawable.illu_assessment_ocd
            ),
            AssessmentModel(
                "تقدير الذات",
                2,
                9,
                R.drawable.illu_assessment_self_esteem
            ),
            AssessmentModel(
                "الذكاء العاطفي",
                2,
                9,
                R.drawable.illu_assessment_emotional_intelligence
            ),
            AssessmentModel("القلق", 5, 12, R.drawable.illu_assessment_emotional_intelligence),
            AssessmentModel(
                "الصحة النفسية العامة",
                2,
                9,
                R.drawable.illu_assessment_general_mental_health
            ),

            )
    }
    suspend fun fetchOffersCategory(): List<OfferCategoryModel> {
        delay(250)

        return listOf(
            OfferCategoryModel("مطاعم", R.drawable.ic_restaurants),
            OfferCategoryModel("الأزياء", R.drawable.ic_fashion),
            OfferCategoryModel("الإلكترونيات", R.drawable.ic_electronics),
            OfferCategoryModel("جمال", R.drawable.ic_beauty),
            OfferCategoryModel("عطور", R.drawable.ic_perfume_fragrance),
            OfferCategoryModel("سيارات", R.drawable.ic_cars),
            OfferCategoryModel("صيدليات", R.drawable.ic_pharmacy),
            OfferCategoryModel("مجوهرات", R.drawable.ic_jewelry),
        )
    }
    suspend fun fetchNews(): List<NewsCardModel> {
        delay(250)

        return  listOf(
            NewsCardModel(
                R.drawable.offer_image, "كيف استفيد من برنامج إمداد", 198
            ), NewsCardModel(
                R.drawable.offer_image2, "إيجاد وطن شك", 245
            ), NewsCardModel(
                R.drawable.offer_image3, "التطوير المستمر", 320
            ))
    }


    suspend fun fetchMostUsedOffers(): List<MostUsedOfferModel> {
        delay(250)

        return listOf(
            MostUsedOfferModel(
                R.drawable.offer_image2, "مكتبة جرير", "خصم 25% على اجمالي ا...", "اونلاين"
            ), MostUsedOfferModel(
                R.drawable.offer_image3, "أسواق عبد الله العثيم", "عروض أسواق عبد الله ال...", "بالمحل"
            ), MostUsedOfferModel(
                R.drawable.offer_image, "مكتبة جرير", "خصم 25% على أحمالي أب...", "أونلاين"
            )
        )
    }
}
