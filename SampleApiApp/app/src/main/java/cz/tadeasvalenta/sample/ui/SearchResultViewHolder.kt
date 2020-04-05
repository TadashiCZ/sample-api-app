package cz.tadeasvalenta.sample.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import cz.tadeasvalenta.sample.R
import cz.tadeasvalenta.sample.constants.NetworkConstants
import cz.tadeasvalenta.sample.domain.responses.RepoDataItem

class SearchResultViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.search_result_item, parent, false)) {

    private lateinit var repoItem: RepoDataItem

    private var tvName: TextView = itemView.findViewById(R.id.tvName)
    private var tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
    private var tvStars: TextView = itemView.findViewById(R.id.tvStars)

    init {
        itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelable(NetworkConstants.REPOSITORY_BUNDLE, repoItem)
            val intent = Intent(itemView.context, DetailActivity::class.java)
            intent.putExtras(bundle)
            startActivity(itemView.context, intent, null)
        }
    }

    fun bind(repo: RepoDataItem) {
        repoItem = repo
        tvName.text = repo.name
        tvDescription.text = repo.description ?: "Missing description"
        tvStars.text = repo.stargazersCount.toString()
    }

}