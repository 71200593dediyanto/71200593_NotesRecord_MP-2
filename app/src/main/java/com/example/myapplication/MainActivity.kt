package com.example.myapplication

import android.app.DownloadManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var recylerView:RecyclerView
    private lateinit var fab: Button
    private lateinit var noteDao: NoteDao
    private lateinit var adaptor: RecyleViewAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recylerView = findViewById(R.id.rv_showcardnote)
        fab = findViewById(R.id.bt_addNote)

        noteDao = NoteDao()

        fab.setOnClickListener {

            // navigasi untuk berpindah ke aktivitas lain
            val intent = Intent(this,AddNoteActivity::class.java)
            startActivity(intent)
        }

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        recylerView.layoutManager = LinearLayoutManager(this)
        val noteCollection = noteDao.noteCollection
        val query = noteCollection.orderBy("date")
        val recylerViewOption = FirestoreRecyclerOptions.Builder<Note>().setQuery(query,Note::class.java).build()
        adaptor = RecyleViewAdaptor(recylerViewOption)
        recylerView.adapter = adaptor
    }

    override fun onStart() {
        super.onStart()
        adaptor.startListening()
    }

    override fun onStop() {
        super.onStop()
        adaptor.stopListening()
    }
}