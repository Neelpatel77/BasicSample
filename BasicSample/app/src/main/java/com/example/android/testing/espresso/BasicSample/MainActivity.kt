package com.example.android.testing.espresso.BasicSample



import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

/**
 * An [Activity] that gets a text string from the user and displays it back when the user
 * clicks on one of the two buttons. The first one shows it in the same activity and the second
 * one opens another activity and displays the message.
 */
class MainActivity : Activity(), View.OnClickListener {

    // The TextView used to display the message inside the Activity.
    private lateinit var mTextView: TextView

    // The EditText where the user types the message.
    private lateinit var mEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set the listeners for the buttons.
        findViewById<View>(R.id.changeTextBt).setOnClickListener(this)
        findViewById<View>(R.id.activityChangeTextBtn).setOnClickListener(this)

        mTextView = findViewById(R.id.textToBeChanged)
        mEditText = findViewById(R.id.editTextUserInput)
    }

    override fun onClick(view: View) {
        // Get the text from the EditText view.
        val text = mEditText.text.toString()

        when (view.id) {
            R.id.changeTextBt -> {
                // First button's interaction: set a text in a text view.
                mTextView.text = text
            }
            R.id.activityChangeTextBtn -> {
                // Second button's interaction: start an activity and send a message to it.
                val intent = ShowTextActivity.newStartIntent(this, text)
                startActivity(intent)
            }
        }
    }
}
