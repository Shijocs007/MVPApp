package com.example.mvpapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvpapp.R
import com.example.mvpapp.adapters.PropertyAdapter
import com.example.mvpapp.databinding.ActivityMainBinding
import com.example.mvpapp.http.responsemodels.Exclusions
import com.example.mvpapp.http.responsemodels.Facilities
import com.example.mvpapp.models.Property
import com.example.mvpapp.root.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : BaseActivity(), HomeMVP.View {

    @Inject
    lateinit var presenter: HomeMVP.Presenter

    private lateinit var binding: ActivityMainBinding
    val mAdapter = PropertyAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context)
        }
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

    override fun setFacilities(facilities: List<Property>) {
        mAdapter.submitList(facilities)
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