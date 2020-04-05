package cz.tadeasvalenta.sample

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cz.tadeasvalenta.sample.domain.responses.RepoDataItem

class SearchResultViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.search_result_item, parent, false)) {

    var tvName: TextView = itemView.findViewById(R.id.tvName)
    var tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
    var tvStars: TextView = itemView.findViewById(R.id.tvStars)

    fun bind(repo: RepoDataItem){
        tvName.text = repo.name
        tvDescription.text = repo.description ?: "Missing description"
        tvStars.text = repo.stargazersCount.toString()
    }

}