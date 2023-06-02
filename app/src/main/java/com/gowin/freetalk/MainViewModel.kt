package com.gowin.freetalk

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class MainViewModel : ViewModel() {

    fun getImage(): String {
        return "https://wjddnjs754.cafe24.com/web/product/small/202303/5b9279582db2a92beb8db29fa1512ee9.jpg"
    }
    fun getData(){
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

    }
}