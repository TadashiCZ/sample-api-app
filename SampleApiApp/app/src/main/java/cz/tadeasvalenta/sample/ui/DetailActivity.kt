package cz.tadeasvalenta.sample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import cz.tadeasvalenta.sample.R
import cz.tadeasvalenta.sample.constants.NetworkConstants
import cz.tadeasvalenta.sample.domain.responses.RepoDataItem
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val repo: RepoDataItem? = intent.extras?.getParcelable(NetworkConstants.REPOSITORY_BUNDLE)
        if (repo != null) {
            Picasso.with(applicationContext).load(repo.owner.avatarUrl).into(ivProfilePhoto)
            tvRepoName.text = repo.name
            tvAuthorLogin.text = getString(R.string.author_login, repo.owner.login)
            tvCreatedAt.text = getString(R.string.created_at, repo.createdAt)
            tvFork.text = getString(R.string.fork, if (repo.fork) "yes" else "no")
            tvStars.text = getString(R.string.stars, repo.stargazersCount.toString())
            tvScore.text = getString(R.string.score, repo.score.toString())
            tvDescription.text = getString(R.string.description, repo.description)
        } else {
            Toast.makeText(applicationContext, "NO DATA", Toast.LENGTH_LONG).show()
        }
    }
}
