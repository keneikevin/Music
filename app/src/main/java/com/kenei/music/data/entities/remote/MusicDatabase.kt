package com.kenei.music.data.entities.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.kenei.music.data.entities.Song
import com.kenei.music.other.Constants.SONG_COLLECTION
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class MusicDatabase {
    private val firestore = FirebaseFirestore.getInstance()
    private val sonCollection = firestore.collection(SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song>{
        return try {
            sonCollection.get().await().toObjects(Song::class.java)
        } catch (e: Exception){
            emptyList()}
    }
}