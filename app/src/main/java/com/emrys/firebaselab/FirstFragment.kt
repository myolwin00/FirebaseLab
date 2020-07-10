package com.emrys.firebaselab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.emrys.firebaselab.databinding.FragmentFirstBinding
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return FragmentFirstBinding.inflate(inflater, container, false)
            .also { binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = Firebase.firestore

        FirebaseCrashlytics.getInstance().log("First fragment sa p")

        db.collection("users")
            .addSnapshotListener { value, error ->
                var dataString = ""
                value?.let {
                    for (document in it.documents) {
                        dataString = dataString + "\n" + document.data.toString()
                    }
                }
                binding.textviewFirst.text = dataString
            }


        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            // Create a new user with a first and last name
            // Create a new user with a first, middle, and last name
            val user = hashMapOf(
                "first" to "Alan",
                "middle" to "Mathison",
                "last" to "Turing",
                "born" to 1912
            )
            // Add a new document with a generated ID
            db.collection("users")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(
                        requireContext(),
                        "DocumentSnapshot added with ID: ${documentReference.id}",
                        Toast.LENGTH_LONG
                    ).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(
                        requireContext(),
                        "Error adding document${e.localizedMessage}",
                        Toast.LENGTH_LONG
                    ).show()
                }
        }
    }
}