package com.example.quotegenerator.model.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView.RecyclerListener
import androidx.recyclerview.widget.RecyclerView
import com.example.quotegenerator.R
import com.example.quotegenerator.model.data.Quote
import com.example.quotegenerator.model.data.QuoteItem
import kotlinx.android.synthetic.main.quote_row_layout.view.*

class QuoteAdapter(): RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder>() {

    var quoteList=emptyList<QuoteItem>
    inner class QuoteViewHolder(private val binding: QuoteRowLayoutBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(quoteItem: QuoteItem) {
            binding.quoteText.text = quoteItem.text
            binding.quoteAuthor.text = quoteItem.author
        }
    }

    fun setData(newData:Quote){
        this.quoteList=newData
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = QuoteRowLayoutBinding.inflate(inflater, parent, false)
        return QuoteViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return quoteList.size
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val currentQuote = quoteList[position]
        holder.bind(currentQuote)
    }
}
