package com.example.mvpapp.ui

import com.example.mvpapp.http.responsemodels.PropertyResponse
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
                    view?.setFacilities(response.facilities)
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