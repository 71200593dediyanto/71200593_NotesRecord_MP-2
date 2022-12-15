package com.example.myapplication

import com.google.firebase.firestore.FirebaseFirestore

class NoteDao {
    private val db = FirebaseFirestore.getInstance() // get db instance
    val noteCollection = db.collection("MyNotes") // create a note collection

    fun addNote(tittle: String,content: String, date: String) {
        val note = Note(tittle,content,date)
        noteCollection.document().set(note)
    }
}