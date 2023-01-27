package com.puneet.cyclingmates.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.puneet.cyclingmates.data.api.EndpointApiCall
import com.puneet.cyclingmates.data.model.Cyclists
import com.puneet.cyclingmates.data.model.CyclistsResponse
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import retrofit2.Response

@RunWith(JUnit4::class)
class CyclistsRepositoryTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @get:Rule
    var rule = InstantTaskExecutorRule()

    @MockK
    lateinit var endpointApiCall: EndpointApiCall

    lateinit var repository: CyclistRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        repository = CyclistRepository(endpointApiCall)
    }

    @Test
    fun `verify listUser when fetchRandomUsers call is success`() = runBlocking {
        //Arrange
        val listUser: List<Cyclists> = listOf()
        val response = mockk<CyclistsResponse>()
        every { response.results } returns listUser
        coEvery { endpointApiCall.fetchCyclists() } returns Response.success(response)
        val successCallback = mockk<(List<Cyclists>) -> Unit>()
        val errorCallback = mockk<(String) -> Unit>()
        every { successCallback.invoke(any()) } answers {}
        every { errorCallback.invoke(any()) } answers {}

        //Act
        repository.fetchCyclists(successCallback, errorCallback)

        //Assert
        verify { successCallback.invoke(listUser) }
    }

    @Test
    fun `verify error message when fetchRandomUsers call is failed`() = runBlocking {
        //Arrange
        coEvery { endpointApiCall.fetchCyclists() } throws RuntimeException("Timeout error")
        val successCallback = mockk<(List<Cyclists>) -> Unit>()
        val errorCallback = mockk<(String) -> Unit>()
        every { successCallback.invoke(any()) } answers {}
        every { errorCallback.invoke(any()) } answers {}

        //Act
        repository.fetchCyclists(successCallback, errorCallback)

        //Assert
        verify { errorCallback.invoke("Timeout error") }
    }
}