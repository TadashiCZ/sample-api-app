package cz.tadeasvalenta.sample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import cz.tadeasvalenta.sample.R
import cz.tadeasvalenta.sample.constants.NetworkConstants
import cz.tadeasvalenta.sample.domain.responses.RepoDataItem

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val repo : RepoDataItem? = intent.extras?.getParcelable(NetworkConstants.REPOSITORY_BUNDLE)
        if (repo!= null){
            Toast.makeText(applicationContext, repo.name, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(applicationContext, "NO DATA", Toast.LENGTH_LONG).show()
        }
    }
}
