package com.example.events.ui.model

//class EventViewModel() : ViewModel() {
//    private val getEventUseCase = EventUseCase()
//
//    private val _eventLiveData = MutableLiveData<List<EventsItem>>()
//    val eventListLiveData: LiveData<List<EventsItem>> = _eventLiveData
//
//    private val _viewStateLiveData = MutableLiveData<ViewState>()
//    val viewStateLiveData: LiveData<ViewState> = _viewStateLiveData
//
//    private val disposable = CompositeDisposable()
//
//    fun getEvents() {
//        getEventUseCase.execute()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                { result ->
//                    _eventLiveData.value
//                },
//                { error ->
//                    Log.e("ErroReq", "erro: " + error.cause)
//                    _viewStateLiveData.value = ViewState.GeneralError
//                }
//            ).handleDisposable()
//    }
//
//    override fun onCleared() {
//        disposable.dispose()
//        super.onCleared()
//    }
//
//    private fun Disposable.handleDisposable(): Disposable = apply { disposable.add(this) }
//}
