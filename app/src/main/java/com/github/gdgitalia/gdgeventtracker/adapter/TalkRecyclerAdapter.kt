package com.github.gdgitalia.gdgeventtracker.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.github.gdgitalia.gdgeventtracker.R
import com.github.gdgitalia.gdgeventtracker.model.Talk
import com.github.gdgitalia.gdgeventtracker.navigator.TalkItemNavigator
import kotlinx.android.synthetic.main.item_talk.view.*



class TalkRecyclerAdapter(options: FirestoreRecyclerOptions<Talk>, val navigator: TalkItemNavigator) : FirestoreRecyclerAdapter<Talk, TalkHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TalkHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_talk, parent, false)
        return TalkHolder(view)
    }

    override fun onBindViewHolder(holder: TalkHolder, position: Int, model: Talk) {
        holder.title.text = model.title
        holder.speaker.text = model.speakerName
        holder.level.rating = model.level.toFloat()
        holder.itemView.setOnClickListener {
            val snapshot = snapshots.getSnapshot(position)
            navigator.openTaskDetail(snapshot.id)
        }
        holder.level.setIsIndicator(false)
        val countryPath = "https://raw.githubusercontent.com/madebybowtie/FlagKit/master/Assets/PNG/${model.country}.png"
        Glide.with(holder.itemView.context).load(countryPath).into(holder.country)
        Glide.with(holder.itemView.context).load(model.pic).into(holder.pic)
    }
}

class TalkHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title = itemView.titleTextView
    val speaker = itemView.speakerTextView
    val level = itemView.levelRatingBar
    val pic = itemView.picImageView
    val country = itemView.countryImageView
    val location = itemView.locationTextView

}