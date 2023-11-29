package com.example.android.testing.espresso.BasicSample



import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView

class ShowTextActivity : Activity() {

    companion object {
        const val KEY_EXTRA_MESSAGE = "com.example.android.testing.espresso.basicsample.MESSAGE"

        fun newStartIntent(context: Context, message: String): Intent {
            val newIntent = Intent(context, ShowTextActivity::class.java)
            newIntent.putExtra(KEY_EXTRA_MESSAGE, message)
            return newIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_text)

        // Get the message from the Intent and set it to the TextView.
        val message = intent.getStringExtra(KEY_EXTRA_MESSAGE).orEmpty()
        findViewById<TextView>(R.id.show_text_view).text = message
    }
}
