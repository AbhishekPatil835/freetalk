package com.gowin.freetalk.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.bookmyshow.multiverseofmovies.utils.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.gowin.freetalk.adapters.TagAdapter
import com.gowin.freetalk.databinding.ActivityMainBinding
import com.gowin.freetalk.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val viewModel by viewModels<MainViewModel>()
    private val binding by viewBinding(ActivityMainBinding::inflate)
    private fun <T : ViewBinding> initBinding(binding: T): View {
        return with(binding) {
            root
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(initBinding(binding))
        setupView()

    }

    private fun setupView() {
        val url = viewModel.getImage()

        Glide.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .into(binding.imageViewPost);

        val header = "지난 월요일에 했던 이벤트 중 가장 괜찮은 상품 뭐야?"
        val decrisption = "지난 월요일에 2023년 S/S 트렌드 알아보기 이벤트 참석했던 팝들아~\n" +
                "혹시 어떤 상품이 제일 괜찮았어? \n" +
                "\n" +
                "후기 올라오는거 보면 로우라이즈? 그게 제일 반응 좋고 그 테이블이 \n" +
                "제일 재밌었다던데 맞아???\n" +
                "\n" +
                "올해 로우라이즈가 트렌드라길래 나도 도전해보고 싶은데 말라깽이가\n" +
                "아닌 사람들도 잘 어울릴지 너무너무 궁금해ㅜㅜ로우라이즈 테이블에\n" +
                "있었던 팝들 있으면 어땠는지 후기 좀 공유해주라~~!"
        val comment1 = "어머 제가 있던 테이블이 제일 반응이 좋았나보네요\uD83E\uDD2D \n" +
                "우짤래미님도 아시겠지만 저도 일반인 몸매 그 이상도 이하도\n" +
                "아니잖아요?! 그런 제가 기꺼이 도전해봤는데 생각보다\n" +
                "괜찮았어요! 오늘 중으로 라이브 리뷰 올라온다고 하니\n" +
                "꼭 봐주세용~!"

        val comment2 = "오 대박! 라이브 리뷰 오늘 올라온대요? 챙겨봐야겠다"

        binding.apply {
            textViewPostDescription.text = decrisption
            textViewPostHeader.text = header
            textViewComment1Description.text = comment1
            textViewComment1Description2.text =comment2
        }

        val recyclerView = binding.viewTags
        recyclerView.layoutManager = createFlexboxLayoutManager()

        val tags = listOf("#2023", "#TODAYISMONDAY", "#TOP", "#POPS!", "#WOW", "#ROW")
        val adapter = TagAdapter(tags)
        recyclerView.adapter = adapter
    }
    private fun createFlexboxLayoutManager(): FlexboxLayoutManager {
        val flexboxLayoutManager = FlexboxLayoutManager(this)
        flexboxLayoutManager.flexWrap = FlexWrap.WRAP
        flexboxLayoutManager.flexDirection = FlexDirection.ROW
        flexboxLayoutManager.justifyContent = JustifyContent.FLEX_START
        return flexboxLayoutManager
    }
}