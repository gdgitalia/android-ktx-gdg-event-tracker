package com.github.gdgitalia.gdgeventtracker.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.gdgitalia.gdgeventtracker.R
import com.github.gdgitalia.gdgeventtracker.model.Talk
import com.google.firebase.firestore.FirebaseFirestore

class TalkDetailActivity : AppCompatActivity() {

    private val talkId: String by lazy { intent.getStringExtra(TALK_ID_KEY) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_talk_detail)
        retrieveTalk()
    }

    private fun retrieveTalk() {
        val db = FirebaseFirestore.getInstance()
        db.collection(TalkListFragment.TALKS_KEY).document(talkId).get().addOnSuccessListener {
            populateActivity(it.toObject(Talk::class.java))
        }
    }

    private fun populateActivity(talk: Talk?) {
        talk?.apply {
//            titleTextView.text = title
//            speakerTextView.text = speaker
        }

    }
}
