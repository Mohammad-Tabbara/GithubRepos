package com.mohammad.githubrepos

import androidx.test.platform.app.InstrumentationRegistry
import com.mohammad.githubrepos.framework.Prefs
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@Config(manifest= Config.NONE)
@RunWith(RobolectricTestRunner::class)
class PrefsUnitTest {

    lateinit var prefs: Prefs

    @Before
    fun init(){
        prefs = Prefs(InstrumentationRegistry.getInstrumentation().context)
    }

    @Test
    fun testTrendingSpanDefault() {
        assertEquals(30,prefs.getTrendingSpan())
    }

    @Test
    fun testTrendingSpan() {
        prefs.setTrendingSpan(3)
        assertEquals(3,prefs.getTrendingSpan())
        prefs.setTrendingSpan(7)
        assertEquals(7,prefs.getTrendingSpan())
        prefs.setTrendingSpan(14)
        assertEquals(14,prefs.getTrendingSpan())
        prefs.setTrendingSpan(30)
        assertEquals(30,prefs.getTrendingSpan())
    }
}
