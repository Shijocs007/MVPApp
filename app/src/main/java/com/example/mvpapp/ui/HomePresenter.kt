package com.example.mvpapp.ui

import com.example.mvpapp.http.responsemodels.PropertyResponse
import com.example.mvpapp.models.Property
import com.example.mvpapp.utils.TYPE_OPTION
import com.example.mvpapp.utils.TYPE_PROPERTY
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class HomePresenter(val repository : HomeMVP.Model) : HomeMVP.Presenter {


    var disposable: Disposable? = null
    var view : HomeMVP.View? = null

    override fun loadData() {
        disposable = repository.result()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<PropertyResponse?>() {
                override fun onNext(response: PropertyResponse) {
                    val properties = mutableListOf<Property>()
                    response.facilities.forEach {
                        properties.add(Property(it.facility_id, it.name, TYPE_PROPERTY))
                        it.options.map { properties.add(Property(it.id, it.name, TYPE_OPTION)) }
                    }
                    view?.setFacilities(properties)
                    view?.setExclusions(response.exclusions)
                }

                override fun onError(e: Throwable) {
                    if (view != null) {
                        view!!.dismissProgressDialog()
                    }
                }

                override fun onComplete() {
                    view!!.dismissProgressDialog()
                }
            })
    }

    override fun rxUnsubscribe() {
        disposable?.let {
            if (it.isDisposed) {
                it.dispose()
            }
        }
    }

    override fun makeView(view: HomeMVP.View) {
        this.view = view
    }
}