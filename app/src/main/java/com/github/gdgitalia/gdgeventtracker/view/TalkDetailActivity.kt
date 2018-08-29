package com.github.gdgitalia.gdgeventtracker.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.github.gdgitalia.gdgeventtracker.R
import com.github.gdgitalia.gdgeventtracker.model.Talk
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_talk_detail.*

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
            talkTitleTextView.text = title
            talkAbstractTextView.text = abstract
            talkTechnologyTextView.text = technology
            talkTypeTextView.text = type
            talkDateTextView.text = date.toString()
            talkHashtagTextView.text = hashtag
            talkLanguageTextView.text = language
            val countryPath = "https://raw.githubusercontent.com/madebybowtie/FlagKit/master/Assets/PNG/$country.png"
            talkCountryTextView.text = country
            talkLevelTextView.text = level.toString()
            Glide.with(this@TalkDetailActivity).load(pic).into(talkPicImageView)
            talkLocationTextView.text = location

            speakerNameTextView.text = speakerName
            speakerBioTextView.text = speakerBio
            speakerCommunityTextView.text = speakerCommunity
            speakerCompanyTextView.text = speakerCompany
            speakerTypeTextView.text = speakerType
            Glide.with(this@TalkDetailActivity).load(speakerPic).into(speakerPicImageView)
        }

    }
}
