package com.sgk.compose_sdui.features.profile.domain.use_case

import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject


@HiltAndroidTest
class GetProfilePageDataTest{

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var getProfilePageData: com.sgk.profile.domain.use_case.GetProfilePageData

    @Before
    fun setUp(){
        hiltRule.inject()
    }

    @Test
    fun GetPrfilePageDataTest(){
        runBlocking {
            getProfilePageData.invoke().collectLatest {
                assertNotNull(it)
            }
        }
    }

}