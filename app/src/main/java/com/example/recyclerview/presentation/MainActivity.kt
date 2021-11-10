package com.example.recyclerview.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import com.example.recyclerview.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        initRecycler()
    }

    private fun initRecycler() {
        editText.setOnClickListener {
            val bottomSheetDialogFragment = DialogFragment.newInstance { videoCard ->
                editText.text = Editable.Factory.getInstance().newEditable(videoCard.model)
            }
            bottomSheetDialogFragment.show(supportFragmentManager, DialogFragment.TAG)
        }
    }
}
