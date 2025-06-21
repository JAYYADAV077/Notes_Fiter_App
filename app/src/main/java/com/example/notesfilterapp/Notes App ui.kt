package com.example.notesfilterapp


import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


fun filterNotes(notes: List<NotesData>, keyword: String): List<NotesData> {
    return notes.filter {
        it.tittle.contains(keyword, ignoreCase = true) ||
                it.tittle.contains(keyword, ignoreCase = true)
    }
}

@Composable
fun notes(notesList: List<NotesData>) {
    var keyword by remember { mutableStateOf("") }
    val filterList = filterNotes(notesList, keyword)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(top = 30.dp)
    ) {
        OutlinedTextField(
            value = keyword,
            onValueChange = { keyword = it },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(8.dp))

        LazyColumn {
            itemsIndexed(filterList) { index: Int, item: NotesData ->
                filterUi(item)
            }
        }

    }
}

@Composable
fun filterUi(note: NotesData) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = note.tittle,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = note.content,
                style = MaterialTheme.typography.bodyLarge
            )

        }
    }

}
