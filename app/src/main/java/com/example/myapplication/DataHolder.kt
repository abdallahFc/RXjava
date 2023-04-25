package com.example.myapplication

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject

object DataHolder {

    private var bus = BehaviorSubject.create<Any>()

    fun send(event: Any) {
        bus.onNext(event)
    }
    fun destroy(){
        bus=BehaviorSubject.create<Any>()
    }
    fun <T : Any> listen(eventType: Class<T>): Observable<T> = bus.ofType(eventType)


}
