package br.com.adrianofpinheiro.testeapp.view.main

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.adrianofpinheiro.testeapp.R
import br.com.adrianofpinheiro.testeapp.model.Filme
import br.com.adrianofpinheiro.testeapp.model.Sprites
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.filme_item.view.*

class MainListAdapter(

        val context: Context,
        val filmes: List<Filme>,
        val listener: (Filme) -> Unit,
        val listenerDelete: (Filme) -> Unit) : RecyclerView.Adapter<MainListAdapter.FilmeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder {
        val itemView = LayoutInflater.from(context)
                .inflate(R.layout.filme_item, parent, false)
        return FilmeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {
        val filme = filmes[position]
        holder?.let {
            holder.bindView(filme, listener, listenerDelete)
        }
    }

    override fun getItemCount(): Int {
        return filmes.size
    }

    class FilmeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(filme: Filme,
                     listener: (Filme) -> Unit,
                     listenerDelete: (Filme) -> Unit) = with(itemView) {
            tvTitle.text = filme.title
            tvOverview.text = filme.overview
            tvDuration.text = filme.duration
            tvReleaseYear.text = filme.release_year

            Picasso.get().load(filme?.coverUrl?.cover_url)


            setOnClickListener { listener(filme) }
        }
    }
}


