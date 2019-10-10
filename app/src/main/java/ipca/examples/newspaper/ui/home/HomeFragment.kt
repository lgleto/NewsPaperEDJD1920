package ipca.examples.newspaper.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ipca.examples.newspaper.R
import ipca.examples.newspaper.entities.Article
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import java.text.FieldPosition

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    var articles : List<Article> = ArrayList()
    var adapter = ArticlesAdpater()

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        homeViewModel.articlesData.observe(this, Observer { articlesData ->
            articles = articlesData
            adapter.notifyDataSetChanged()
        })


        listViewArticles.adapter = adapter
    }

    inner class ArticlesAdpater : BaseAdapter() {
        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {

            val v = layoutInflater.inflate(R.layout.row_article, viewGroup, false)

            var textViewTitle = v.findViewById<TextView>(R.id.textViewTitle)
            var textViewDescription= v.findViewById<TextView>(R.id.textViewDescription)
            textViewTitle.text = articles.get(position).title
            textViewDescription.text = articles.get(position).description


            return v
        }

        override fun getItem(position: Int): Any {
            return articles.get(position)
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getCount(): Int {
            return articles.size
        }

    }

}