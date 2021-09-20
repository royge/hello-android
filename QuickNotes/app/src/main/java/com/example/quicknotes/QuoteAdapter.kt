package com.example.quicknotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuoteAdapter(val quotes: ArrayList<String>)
    : RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder>() {
    class QuoteViewHolder(v: View): RecyclerView.ViewHolder(v) {
        var view: View = v
        var quote: String = ""
        var textView: TextView = view.findViewById(R.id.textView)

        fun bindQuote(quote: String) {
            this.quote = quote

            textView.text = quote
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        return QuoteViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_row, parent, false))
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.bindQuote(quotes[position])
    }

    override fun getItemCount(): Int {
        return quotes.count()
    }
}