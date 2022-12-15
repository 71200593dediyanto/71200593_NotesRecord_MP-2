package com.example.myapplication

import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions


class RVAdaptor(options: FirestoreRecyclerOptions<Note>) : FirestoreRecyclerAdapter<Note,RVAdaptor.RVViewHolder>(
    options
) {
    class RVViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val titleNote: TextView = itemView.findViewById(R.id.tvHeader)
        val contentNote: TextView = itemView.findViewById(R.id.tvDescription)
        val lastModified: TextView = itemView.findViewById(R.id.tvDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVViewHolder {
        return RVViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cardnoteview,parent,false))
    }

    override fun onBindViewHolder(holder: RVViewHolder, position: Int, model: Note) {
        holder.titleNote.text = model.tittleNote
        holder.contentNote.text = model.contentNote
        holder.lastModified.text = model.lastModified
    }
}

