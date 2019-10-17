package ipca.examples.newspaper.ui.home


import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity

import ipca.examples.newspaper.R
import ipca.examples.newspaper.entities.Article
import kotlinx.android.synthetic.main.fragment_article_detail.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONObject

/**
 * A simple [Fragment] subclass.
 */
class ArticleDetailFragment : Fragment() {

    var article : Article? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{bundle ->
            var articleJson = bundle.getString("articleJson")
            articleJson?.let{
                article = Article(JSONObject(it))
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = article?.title
        textViewTilteArt.text =  article?.title
        downloadImageFromUrl(article?.urlToImage!!){
            imageViewArt.setImageBitmap(it)
        }
        textViewDescription.text=article?.description
    }

    fun downloadImageFromUrl(urlImage : String, callback : (Bitmap) -> Unit )  {
        doAsync {
            val input = java.net.URL(urlImage).openStream()
            var bmp = BitmapFactory.decodeStream(input)
            uiThread {
                callback(bmp)
            }
        }
    }


}
