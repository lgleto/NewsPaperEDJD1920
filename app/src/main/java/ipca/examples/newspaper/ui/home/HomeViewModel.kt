package ipca.examples.newspaper.ui.home

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ipca.examples.newspaper.entities.Article
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONObject
import java.net.URL
import java.nio.charset.Charset
import android.graphics.BitmapFactory
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log


class HomeViewModel : ViewModel() {

    val BASE_API = "https://newsapi.org/v2/top-headlines?country=pt&apiKey=1765f87e4ebc40229e80fd0f75b6416c"


    var articles : MutableList<Article> = ArrayList();

    private val _articlesData = MutableLiveData<List<Article>>().apply {
        doAsync {
            var url = URL(BASE_API)
            var urlContent = url.readText(Charset.defaultCharset())

            val jsonObject = JSONObject(urlContent)
            val statusStr = if (jsonObject.has("status"))
                                jsonObject.getString("status")
                            else
                                "not ok"
            if (statusStr.compareTo("ok")==0){
                val jsonArrayArticles = jsonObject.getJSONArray("articles")
                for ( index in 0 until jsonArrayArticles.length()){
                    val jsonArticle : JSONObject = jsonArrayArticles.get(index) as JSONObject
                    val article = Article(jsonArticle)
                    articles.add(article)
                }
            }
            uiThread {
                value = articles
            }
        }
    }
    val articlesData: LiveData<List<Article>> = _articlesData

    
}