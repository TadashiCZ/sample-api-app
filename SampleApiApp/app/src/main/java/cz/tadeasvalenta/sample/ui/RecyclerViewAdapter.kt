package cz.tadeasvalenta.sample.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cz.tadeasvalenta.sample.domain.responses.RepoDataItem


class RecyclerViewAdapter(private val resultsList: List<RepoDataItem>) :
    RecyclerView.Adapter<SearchResultViewHolder>() {

    val list = resultsList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return SearchResultViewHolder(
            inflater,
            parent
        )
    }

    override fun getItemCount(): Int = resultsList.size

    override fun onBindViewHolder(holder: SearchResultViewHolder, position: Int) {
        val result = resultsList[position]
        holder.bind(result)
    }


}