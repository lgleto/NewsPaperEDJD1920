package ipca.examples.newspaper.ui.home

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ipca.examples.newspaper.R
import ipca.examples.newspaper.entities.BaseModel
import ipca.examples.newspaper.entities.Category
import ipca.examples.newspaper.entities.News
import org.jetbrains.anko.doAsync
import java.net.URL
import java.nio.charset.Charset
import java.util.*
import kotlin.collections.ArrayList

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    val BASE_API = "https://newsapi.org/v2/top-headlines?country=pt&apiKey=1765f87e4ebc40229e80fd0f75b6416c"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })
        downloadData()
        //testPOO ()
        return root
    }

    fun downloadData(){
        /*
        object : AsyncTask<String, Void, String>() {
            override fun doInBackground(vararg strings: String): String? {
                val result: String

                var url = URL(BASE_API)
                var urlContent = url.readText(Charset.defaultCharset())
                Log.d("TestPOO", urlContent)

                return null
            }
        }.execute(null, null, null)

         */

        doAsync {
            var url = URL(BASE_API)
            var urlContent = url.readText(Charset.defaultCharset())
            Log.d("TestPOO", urlContent)
        }
    }

    fun testPOO (){
        val base = BaseModel()
        base.title = "base test"
        base.id = 1

        val news = News()
        news.id = 2
        news.title = "News Title Test"
        news.url = "http://publico.pt"
        news.date = Date()

        val cat = Category()
        cat.id = 3
        cat.title = "Title Test"
        cat.image = 32423

        news.category = cat

        var models : MutableList<BaseModel> = ArrayList()
        models.add(base)
        models.add(news)
        models.add(cat)

        for (m in models){
            Log.d("TestPOO", m.toJson().toString())
        }

    }


}