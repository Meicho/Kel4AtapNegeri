package com.example.atapnegeri.activities

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.atapnegeri.R

class RatingActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rating_main)

        val ratingActivity = RatingActivity()

        val timeTextView: TextView = findViewById(R.id.time_text)
        val titleTextView: TextView = findViewById(R.id.title_text)
        val usernameTextView: TextView = findViewById(R.id.username_text)
        val descriptionEditText: EditText = findViewById(R.id.description_edit_text)
        val ratingBar: RatingBar = findViewById(R.id.rating_bar)
        val addPhotoImageView: ImageView = findViewById(R.id.add_photo_image_view)
        val postButton: Button = findViewById(R.id.post_button)

        timeTextView.text = ratingActivity.time
        titleTextView.text = ratingActivity.title
        usernameTextView.text = ratingActivity.userName
        descriptionEditText.hint = getString(R.string.kisah)
        ratingBar.rating = ratingActivity.rating

        if (ratingActivity.addPhoto) {
            addPhotoImageView.visibility = View.VISIBLE
        } else {
            addPhotoImageView.visibility = View.GONE
        }

        postButton.setOnClickListener {
            handlePostButtonClick()
        }
    }

    private fun handlePostButtonClick() {
        // Implement the logic for handling the button click
    }
}

