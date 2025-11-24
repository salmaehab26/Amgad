package com.example.amgad.data.data_source

import com.example.amgad.R
import com.example.amgad.domain.model.MyLibraryModel.ItemType

import com.example.amgad.domain.model.MyLibraryModel.MyLibraryModel
import kotlinx.coroutines.delay

class DummyMyLibraryDataSource {
    suspend fun fetchLibraryItems(): List<MyLibraryModel> {
        delay(250)

        return listOf(
            MyLibraryModel(

                title = "نظرة شاملة على التأمين وحماية المستقبل",
                description = "فيديو تعريفي يشرح أساسيات التأمين، أهميته، وأنواعه المختلفة لحماية الأفراد والشركات",
                image = R.drawable.banner,
                type = ItemType.Video,
                videoUrl = R.raw.dancing_kitten

            ),
            MyLibraryModel(

                title = "دليل العميل لفهم وثائق التأمين خطوة بخطوة",
                description = null,
                image = null, type = ItemType.Video, videoUrl = R.raw.dancing_kitten


            ),
            MyLibraryModel(

                videoUrl = R.raw.dancing_kitten,
                title = "3إضاءات تأمينية",
                description = "سلسلة فيديوهات تستعرض المصطلحات التأمينية الشائعة وتطبيقاتها في الحياة اليومية",
                image = null, type = ItemType.Video

            ),

            MyLibraryModel(
                videoUrl = R.raw.dancing_kitten,
                title = "كيف تختار وثيقة التأمين المناسبة لاحتياجاتك؟",
                description = "فيديو توضيحي يساعد العملاء على اختيار التغطية التأمينية المناسبة وفقًا لاحتياجاتهم الشخصية والمهنية",
                image = R.drawable.banner,
                type = ItemType.Video

            ),
            MyLibraryModel(
                videoUrl = R.raw.dancing_kitten,
                title = "قصص حقيقية عن أهمية التأمين في مواجهة المخاطر",
                description = "فيديو توضيحي يساعد العملاء على اختيار التغطية التأمينية المناسبة وفقًا لاحتياجاتهم الشخصية والمهنية",
                image = R.drawable.banner, type = ItemType.Video

            ),

            /////////////////////////////////


            MyLibraryModel(

                title = "الصوت التأميني: كل ما تحتاج لمعرفته عن التأمين في دقائق",
                description = "حلقات صوتية قصيرة تشرح مفاهيم التأمين وتجيب على الأسئلة الشائعة",
                image = R.drawable.banner,
                type = ItemType.Audio,
                videoUrl = R.raw.shouts_and




            ),
            MyLibraryModel(

                title = "نغمة الحماية: نصائح تأمينية مباشرة من الخبراء",
                description = "سلسلة تسجيلات تحتوي على نصائح من خبراء التأمين حول اختيار الوثائق المناسبة والاستفادة منها",
                image = null,
                type = ItemType.Audio,
                videoUrl = R.raw.shouts_and

            ),


            MyLibraryModel(

                title = "دليل شامل لفهم أساسيات التأمين الشخصي والعائلي",
                description = "مقال يشرح مبادئ التأمين للأفراد والعائلات، بما في ذلك التأمين الصحي، الحياتي، والممتلكات",
                image = R.drawable.banner,
                type = ItemType.Article

            ),
            MyLibraryModel(

                title = "زاوية التأمين: مقالات تحليلية حول أحدث التطورات في قطاع التأمين",
                description = "سلسلة مقالات تناقش التغييرات في سوق التأمين والقوانين الجديدة",
                image = null,
                type = ItemType.Article

            ),
        )
    }
}