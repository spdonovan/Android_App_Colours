package com.example.colours

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.colour_app_button)
            ?.setOnClickListener {
                var redChannelText = findViewById<TextInputEditText>(R.id.red_channel)?.text.toString()
                var greenChannelText = findViewById<TextInputEditText>(R.id.green_channel)?.text.toString()
                var blueChannelText = findViewById<TextInputEditText>(R.id.blue_channel)?.text.toString()

                if (redChannelText.isEmpty() or
                    greenChannelText.isEmpty()
                    or blueChannelText.isEmpty()) {
                    Toast.makeText(this, "All Values are required",
                    Toast.LENGTH_LONG).show()
                } else {
                    if (redChannelText.length == 1) redChannelText =
                        redChannelText.plus(redChannelText)
                    if (greenChannelText.length == 1) greenChannelText =
                        greenChannelText.plus(greenChannelText)
                    if (blueChannelText.length == 1) blueChannelText =
                        blueChannelText.plus(blueChannelText)

                    val colourToDisplay = redChannelText
                        .plus(greenChannelText).plus(blueChannelText)

                    val colourAsInt = Color.parseColor("#".plus(colourToDisplay))
                    findViewById<TextView>(R.id.colour_app_display)
                        ?.setBackgroundColor(colourAsInt)
                }
            }
    }
}