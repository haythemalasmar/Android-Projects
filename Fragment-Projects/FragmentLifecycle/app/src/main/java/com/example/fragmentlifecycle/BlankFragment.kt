package com.example.fragmentlifecycle

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null;
    private var param2: String? = null;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onAttach(context: Context) {
        Toast.makeText(activity, "onAttach", Toast.LENGTH_LONG).show();
        super.onAttach(context);
    }

    override fun onPause() {
        Toast.makeText(activity, "onPause", Toast.LENGTH_LONG).show();
        super.onPause()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Toast.makeText(activity, "onActivityCreated", Toast.LENGTH_LONG).show();
        super.onActivityCreated(savedInstanceState);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Toast.makeText(activity, "onCreate", Toast.LENGTH_LONG).show();
        super.onCreate(savedInstanceState);
    }

    override fun onStart() {
        Toast.makeText(activity, "onStart", Toast.LENGTH_LONG).show();
        super.onStart();
    }

    override fun onResume() {
        Toast.makeText(activity, "onResume", Toast.LENGTH_LONG).show();
        super.onResume();
    }

    override fun onDetach() {
        Toast.makeText(activity, "onDetach", Toast.LENGTH_LONG).show();
        super.onDetach();
    }

    override fun onDestroyView() {
        Toast.makeText(activity, "onDestroyView", Toast.LENGTH_LONG).show();
        super.onDestroyView();
    }

    override fun onStop() {
        Toast.makeText(activity, "onStop", Toast.LENGTH_LONG).show();
        super.onStop();
    }

    override fun onDestroy() {
        Toast.makeText(activity, "onDestroy", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}