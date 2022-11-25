package com.example.myfizzbuzz

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import data.db.ResultDao
import data.db.ResultDatabase
import data.repository.ResultRepositoryImpl
import domain.model.ResultEntity
import domain.repository.ResultRepository
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit


@RunWith(RobolectricTestRunner::class)
class ResultUseCasesTest {

    private lateinit var repository : ResultRepository
    private var result : ResultEntity = ResultEntity(1,"fizz")
    private lateinit var dao : ResultDao
    private lateinit var db : ResultDatabase

    @Before
    fun setUp(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.databaseBuilder(
            context,
            ResultDatabase::class.java,
            ResultDatabase.DATABASE_NAME
        ).build()
        dao = db.resultDao
        repository = ResultRepositoryImpl(dao)
    }

    @Test
    fun addResultTest() = runTest {
        result = ResultEntity(1,"fizz")
        repository.insertResult(result)
        val getResult = repository.getResults(1)
        Assert.assertEquals(null,getResult.value)
    }

    @Test
    fun getAllResultTest() = runTest {
        val getResult = repository.getResults(1)
        Assert.assertEquals(null, getResult.value)
    }

    @After
    fun closeDB() {
        db.close()
    }

    fun <T : Any> LiveData<T>.getOrAwaitValue(
        time: Long = 2,
        timeUnit: TimeUnit = TimeUnit.SECONDS,
        afterObserve: () -> Unit = {}
    ): T {
        var data: T? = null
        val latch = CountDownLatch(1)

        val observer = object : Observer<T> {
            override fun onChanged(o: T?) {
                data = o
                latch.countDown()
                this@getOrAwaitValue.removeObserver(this)
            }
        }
        this.observeForever(observer)

        afterObserve.invoke()

        @Suppress("UNCHECKED_CAST")
        return data as T
    }

}