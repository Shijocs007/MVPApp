package com.example.mvpapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvpapp.R
import com.example.mvpapp.http.responsemodels.Exclusions
import com.example.mvpapp.http.responsemodels.Facilities
import com.example.mvpapp.root.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : BaseActivity(), HomeMVP.View {

    @Inject
    lateinit var presenter: HomeMVP.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        presenter.makeView(this)
        presenter.loadData()
    }

    override fun onStop() {
        super.onStop()
        presenter.rxUnsubscribe()
    }

    override fun setFacilities(facilities: List<Facilities>) {
        TODO("Not yet implemented")
    }

    override fun setExclusions(exclusions: List<List<Exclusions>>) {
        TODO("Not yet implemented")
    }

    override fun showProgressDialog() {
        showProgress("Loading...")
    }

    override fun dismissProgressDialog() {
        dismissProgress()
    }
}