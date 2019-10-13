package com.example.studentportal

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_portal.*
import kotlinx.android.synthetic.main.item_portal.*

const val EXTRA_PORTAL = "EXTRA_PORTAL"

class CreatePortalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_portal)
        initViews()

       btnAddPortal.setOnClickListener { onAddNewPortal() }
    }

    private fun initViews() {
        //Enable the supportActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Create a Portal"
    }

    //Return to the previous activity
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    //Adds a new portal
    private fun onAddNewPortal() {
        if (etTitle.text.toString().isNotBlank() && etUrl.text.toString().isNotBlank()) {
            val newPortal = Portal(etTitle.text.toString(), etUrl.text.toString())
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_PORTAL, newPortal)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else {
            Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show()
        }
    }
}
