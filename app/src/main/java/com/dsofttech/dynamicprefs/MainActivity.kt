package com.dsofttech.dynamicprefs

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import DPrefs Instance.DPrefs
import com.dsofttech.dynamicprefs.databinding.ActivityMainBinding
import com.dsofttech.dynamicprefs.utils.TestObject
import com.dsofttech.dynamicprefs.utils.Utils.getSampleObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var btnReadString: Button
    private lateinit var btnRemoveString: Button
    private lateinit var btnReadInt: Button
    private lateinit var btnRemoveInt: Button
    private lateinit var btnReadLong: Button
    private lateinit var btnRemoveLong: Button
    private lateinit var btnReadDouble: Button
    private lateinit var btnRemoveDouble: Button
    private lateinit var btnReadObject: Button
    private lateinit var btnRemoveObject: Button
    private lateinit var btnClearAllPrefs: Button
    private lateinit var btnResetAllPrefs: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        intViews()

        btnReadString.setOnClickListener {
            val retrievedData = DPrefs.getString("PREFS_STRING", "PREFS_STRING")
            makeToast("PREFS_STRING", retrievedData)
        }
        btnReadInt.setOnClickListener {
            val retrievedData = DPrefs.getInt("PREFS_INT")
            makeToast("PREFS_INT", retrievedData.toString())
        }
        btnReadLong.setOnClickListener {
            val retrievedData = DPrefs.getLong("PREFS_LONG", 111L)
            makeToast("PREFS_LONG", "$retrievedData")
        }
        btnReadDouble.setOnClickListener {
            val retrievedData = DPrefs.getDouble("PREFS_DOUBLE")
            makeToast("PREFS_DOUBLE", "$retrievedData")
        }
        btnReadObject.setOnClickListener {
            val retrievedData = DPrefs.getObject("PREFS_OBJECT", TestObject::class)
            makeToast("PREFS_OBJECT", retrievedData.toString())
        }
        btnRemoveString.setOnClickListener {
            DPrefs.removePref("PREFS_STRING")
        }
        btnRemoveInt.setOnClickListener {
            DPrefs.removePref("PREFS_INT")
        }
        btnRemoveLong.setOnClickListener {
            DPrefs.removePref("PREFS_LONG")
        }
        btnRemoveDouble.setOnClickListener {
            DPrefs.removePref("PREFS_DOUBLE")
        }
        btnRemoveObject.setOnClickListener {
            DPrefs.removePref("PREFS_OBJECT")
        }
        btnClearAllPrefs.setOnClickListener {
            DPrefs.clearAllPrefs()
        }
        btnResetAllPrefs.setOnClickListener {
            setPrefs()
        }
    }

    private fun intViews() {
        with(binding) {
            btnReadString = button
            btnReadInt = button2
            btnReadLong = button3
            btnReadDouble = button4
            btnReadObject = button5
            btnRemoveString = rmStr
            btnRemoveInt = rmInt
            btnRemoveLong = rmLong
            btnRemoveDouble = rmDouble
            btnRemoveObject = rmObject
            btnClearAllPrefs = clrPrfs
            btnResetAllPrefs = button12
        }
    }

    private fun setPrefs() {
        DPrefs.putString("PREFS_STRING", "This is a string")
        DPrefs.putInt("PREFS_INT", 125)
        DPrefs.putLong("PREFS_LONG", 150L)
        DPrefs.putDouble("PREFS_DOUBLE", 123.03)
        DPrefs.putObject("PREFS_OBJECT", getSampleObject())
    }

    private fun makeToast(tag: String, message: String) {
        Log.d("$tag===>", message)
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
