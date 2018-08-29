package com.github.gdgitalia.gdgeventtracker.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.github.gdgitalia.gdgeventtracker.R
import com.github.gdgitalia.gdgeventtracker.adapter.TalkRecyclerAdapter
import com.github.gdgitalia.gdgeventtracker.model.Talk
import com.github.gdgitalia.gdgeventtracker.navigator.TalkItemNavigator
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_talk_list.*

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
    val query = FirebaseFirestore.getInstance().collection(TALKS_KEY).orderBy(DATE_FIELD)
    val firestoreRecyclerOptions by lazy {
        FirestoreRecyclerOptions.Builder<Talk>().setLifecycleOwner(this)
            .setQuery(query, Talk::class.java).build()
    }
    val myAdapter by lazy { TalkRecyclerAdapter(firestoreRecyclerOptions, activity as TalkItemNavigator) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_talk_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = myAdapter
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
