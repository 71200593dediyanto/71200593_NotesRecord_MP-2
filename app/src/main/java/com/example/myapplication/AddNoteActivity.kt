package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class AddNoteActivity : AppCompatActivity() {

    private lateinit var ettitleNote: EditText
    private lateinit var etcontentNote : EditText
    private lateinit var btsaveNote : Button
    private lateinit var noteDao: NoteDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        ettitleNote = findViewById(R.id.et_tittleNote)
        etcontentNote = findViewById(R.id.et_contentNote)
        btsaveNote = findViewById(R.id.bt_saveNote)

        noteDao = NoteDao()

        btsaveNote.setOnClickListener{
            var titleNote = ettitleNote.text.toString()
            val contentNote = etcontentNote.text.toString()
            val currentTime = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
            val dateFormatted = currentTime.format(formatter)

            if ((titleNote.isNotEmpty()) || (contentNote.isNotEmpty() && !contentNote.equals("Type Something Here ...."))) {

                if(titleNote.equals("Add Your Tittle")){
                    val formatterUniq = DateTimeFormatter.ofPattern("dd-MM-yyyy")
                    val uniq = currentTime.format(formatterUniq)
                    titleNote = "Text Note " + uniq
                }
                //simpan data ke firebase
                noteDao.addNote(titleNote,contentNote,dateFormatted)

                // navigasi ke main activity jika sudah menekan tombol save
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}