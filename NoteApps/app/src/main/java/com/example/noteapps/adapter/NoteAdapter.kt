package com.example.noteapps.adapter

import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapps.R
import com.example.noteapps.db.Note

class NoteAdapter(private val listData:List<Note>, private val listener: OnItemClickListener): RecyclerView.Adapter<NoteAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val currentData = listData[position]
        holder.title.text = currentData.title
        holder.text.text = currentData.note

        holder.itemView.findViewById<View>(R.id.edit_button).setOnClickListener {
            listener.onEditClick(currentData)
        }

        holder.itemView.findViewById<View>(R.id.delete_button).setOnClickListener {
            listener.onDeleteClick(currentData)
        }
    }

    override fun getItemCount(): Int {
        return listData.count()
    }

    class DataViewHolder(item: View): RecyclerView.ViewHolder(item){
        val text: TextView = item.findViewById(R.id.text)
        val title: TextView = item.findViewById(R.id.title)
    }

    interface OnItemClickListener {
        fun onEditClick(note: Note)
        fun onDeleteClick(note: Note)
    }
}