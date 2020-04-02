package cz.tadeasvalenta.sample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import cz.tadeasvalenta.sample.domain.ApiResponse
import cz.tadeasvalenta.sample.domain.ApiSuccessResponse
import cz.tadeasvalenta.sample.domain.IApi
import cz.tadeasvalenta.sample.domain.RetrofitHelper
import cz.tadeasvalenta.sample.domain.responses.RepoSearchResponse

class MainActivity : AppCompatActivity() {

    lateinit var iApi: IApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        iApi = RetrofitHelper.instance
        val response = iApi.searchRepositories("joker")
        response.observe(this, Observer { data ->
            logAnswer(data)
        })
        setContentView(R.layout.activity_main)
    }

    private fun logAnswer(data: ApiResponse<RepoSearchResponse>?) {
        if (data is ApiSuccessResponse<RepoSearchResponse>) {
            Log.d(
                "NewMainActivity",
                data.body.items.toString()
            )
        }
    }
}
