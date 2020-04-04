package cz.tadeasvalenta.sample

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cz.tadeasvalenta.sample.domain.responses.RepoDataItem

class SearchResultViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.search_result_item, parent, false)) {

    var tvName: TextView = itemView.findViewById(R.id.tvName)
    var tvCreatedAt: TextView = itemView.findViewById(R.id.tvCreatedAt)
    var tvStars: TextView = itemView.findViewById(R.id.tvStars)

    fun bind(repo: RepoDataItem){
        tvName.text = repo.name
        tvCreatedAt.text = repo.createdAt
        tvStars.text = repo.stargazersCount.toString()
    }

}