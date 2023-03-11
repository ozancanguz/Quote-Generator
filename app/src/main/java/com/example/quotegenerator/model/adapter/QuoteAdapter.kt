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

class QuoteAdapter:RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder>() {
    class QuoteViewHolder(view: View):RecyclerView.ViewHolder(view){

    }

    var quoteList= emptyList<QuoteItem>()

    fun setData(newData: Quote){
        this.quoteList=newData
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
       val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.quote_row_layout,parent,false)
        return QuoteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  quoteList.size
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        var currentQuote=quoteList[position]
        holder.itemView.quote_text.text=currentQuote.text
        holder.itemView.quote_author.text=currentQuote.author
    }

}