package com.example.mvpapp.root

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mvpapp.R

open class BaseActivity : AppCompatActivity() {

    private var mProgressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mProgressDialog = ProgressDialog(this, R.style.AppTheme_Dark_Dialog)
        mProgressDialog!!.setCanceledOnTouchOutside(false)
    }

    protected fun showProgress(msg: String?) {
        if (mProgressDialog != null) {
            if (mProgressDialog!!.isShowing) dismissProgress()
            mProgressDialog!!.setMessage(msg)
            mProgressDialog!!.setCancelable(false)
            mProgressDialog!!.show()
        }
    }


    protected fun dismissProgress() {
        if (mProgressDialog != null) {
            mProgressDialog!!.setCancelable(true)
            mProgressDialog!!.dismiss()
        }
    }
}