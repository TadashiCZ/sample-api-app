package cz.tadeasvalenta.sample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import cz.tadeasvalenta.sample.domain.ApiResponse
import cz.tadeasvalenta.sample.domain.ApiSuccessResponse
import cz.tadeasvalenta.sample.domain.IApi
import cz.tadeasvalenta.sample.domain.RetrofitHelper
import cz.tadeasvalenta.sample.domain.responses.RepoDataItem
import cz.tadeasvalenta.sample.domain.responses.RepoSearchResponse
import cz.tadeasvalenta.sample.ui.RecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var iApi: IApi
    var searchResults: MutableList<RepoDataItem> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        iApi = RetrofitHelper.instance
        setContentView(R.layout.activity_main)
        rvSearchResults.layoutManager = LinearLayoutManager(this)
        rvSearchResults.adapter = RecyclerViewAdapter(searchResults)
        btnSearch.setOnClickListener {
            pbCircualProgress.visibility = View.VISIBLE
            val response = iApi.searchRepositories(etSearchInput.text.toString())
            response.observe(this, Observer { data ->
                putDataIntoRecycler(data)
            })
            pbCircualProgress.visibility = View.INVISIBLE
        }
    }


    private fun putDataIntoRecycler(data: ApiResponse<RepoSearchResponse>?) {
        if (data is ApiSuccessResponse<RepoSearchResponse>) {
            val repos = data.body.items
            for (repo in repos){
                searchResults.add(repo)
            }
            rvSearchResults.adapter?.notifyDataSetChanged()
        }
    }
}
