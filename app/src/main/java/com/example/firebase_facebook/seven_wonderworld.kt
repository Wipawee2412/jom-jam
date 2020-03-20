package com.example.firebase_facebook


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction

/**
 * A simple [Fragment] subclass.
 */
class seven_wonderworld : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_seven_wonderworld, container, false)
        // Inflate the layout for this fragment
        val button1: Button = view.findViewById(R.id.button_con1);
        val button2: Button = view.findViewById(R.id.button_con2);

        button1.setOnClickListener {
            val fragment_recycler_view = Recycler_view()
            val fm = fragmentManager
            val transaction: FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.layout, fragment_recycler_view, "fragment_recycler_view")
            transaction.addToBackStack("fragment_recycler_view")
            transaction.commit()
        }

        button2.setOnClickListener {
            val fragment_recycler_view2 = Recycler_view2()
            val fm = fragmentManager
            val transaction: FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.layout, fragment_recycler_view2, "fragment_recycler_view2")
            transaction.addToBackStack("fragment_recycler_view2")
            transaction.commit()
        }

        return view;
    }
}
