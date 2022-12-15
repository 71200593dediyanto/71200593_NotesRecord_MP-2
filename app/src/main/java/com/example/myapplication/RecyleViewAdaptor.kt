package com.example.myapplication

import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions


class RecyleViewAdaptor(options: FirestoreRecyclerOptions<Note>) : FirestoreRecyclerAdapter<Note,RecyleViewAdaptor.RecyleViewViewHolder>(
    options
) {
    class RecyleViewViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val titleNote: TextView = itemView.findViewById(R.id.et_tittleNote)
        val contentNote: TextView = itemView.findViewById(R.id.et_contentNote)
        val dateNote: TextView = itemView.findViewById(R.id.tvDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyleViewViewHolder {
        return RecyleViewViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.cardnoteview,parent,false))
    }

    override fun onBindViewHolder(holder: RecyleViewViewHolder, position: Int, model: Note) {
        holder.titleNote.text = model.tittleNote
        holder.contentNote.text = model.contentNote
        holder.dateNote.text = model.lastModified
    }
}

