package com.emrys.firebaselab

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
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
import com.google.firebase.storage.ktx.storage
import java.io.ByteArrayOutputStream
import java.io.File

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

        val storage = Firebase.storage
        var storageRef = storage.reference

        val androidRef = storageRef.child("android.jpg")


        view.findViewById<Button>(R.id.button_first).setOnClickListener {

            // Get the data from an ImageView as bytes
//            binding.imageView.isDrawingCacheEnabled = true
//            binding.imageView.buildDrawingCache()
//            val bitmap = (binding.imageView.drawable as BitmapDrawable).bitmap
//            val baos = ByteArrayOutputStream()
//            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
//            val data = baos.toByteArray()
//
//            var uploadTask = androidRef.putBytes(data)
//            uploadTask.addOnFailureListener {
//                // Handle unsuccessful uploads
//            }
//                .addOnSuccessListener {
//                // taskSnapshot.metadata contains file metadata such as size, content-type, etc.
//                // ...
//                   // here is the fucking url !!
//                    val url = it.uploadSessionUri
//            }


//            val localFile = File.createTempFile("images", "jpg")

            androidRef.delete()

        }
    }
}