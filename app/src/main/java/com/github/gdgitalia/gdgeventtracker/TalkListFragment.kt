package com.github.gdgitalia.gdgeventtracker

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.github.gdgitalia.gdgeventtracker.model.Talk
import com.google.firebase.firestore.FirebaseFirestore

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [TalkListFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [TalkListFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class TalkListFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val query = FirebaseFirestore.getInstance().collection(TALKS_KEY).orderBy(DATE_FIELD)
        FirestoreRecyclerOptions.Builder<Talk>().setQuery(query, Talk::class.java).build()
        return inflater.inflate(R.layout.fragment_talk_list, container, false)
    }

    companion object {

        const val TALKS_KEY = "talks"
        const val DATE_FIELD = "date"
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment TalkListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
                TalkListFragment().apply {

                }
    }
}
