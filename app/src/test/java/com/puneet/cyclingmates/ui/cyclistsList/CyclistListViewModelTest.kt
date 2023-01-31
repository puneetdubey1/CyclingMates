package com.puneet.cyclingmates.ui.cyclistsList

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.puneet.cyclingmates.data.model.Cyclists
import com.puneet.cyclingmates.data.repository.CyclistRepository
import com.puneet.cyclingmates.ui.cyclingmateslist.CyclistListViewModel
import io.mockk.MockKAnnotations
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.invoke
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

@RunWith(JUnit4::class)
class CyclistListViewModelTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @get:Rule
    var rule = InstantTaskExecutorRule()

    @MockK
    lateinit var repository: CyclistRepository

    lateinit var viewModel: CyclistListViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        MockKAnnotations.init(this, relaxUnitFun = true)
        viewModel = CyclistListViewModel(repository)
    }

    @Test
    fun `verify fetchRandomUserApi call and loading observer changed when viewModel gets created`() {
        //Arrange
        val loadingObserver = mockk<Observer<Boolean>>()
        every { loadingObserver.onChanged(any()) } answers {}
        viewModel.loading.observeForever(loadingObserver)

        //Assert
        coVerify { repository.fetchCyclists(any(), any()) }
        verify { loadingObserver.onChanged(true) }
    }

    @Test
    fun `verify cyclistList observer changed on successful fetchcyclistApi call`() {
        //Arrange
        val cyclistListObserver = mockk<Observer<List<Cyclists>>>()
        every { cyclistListObserver.onChanged(any()) } answers {}
        viewModel.cyclistList.observeForever(cyclistListObserver)
        val listUser: List<Cyclists> = listOf()
        val slotSuccess = slot<(List<Cyclists>) -> Unit>()
        val slotError = slot<(String) -> Unit>()
        coVerify { repository.fetchCyclists(capture(slotSuccess), capture(slotError)) }

        //Act
        slotSuccess.invoke(listUser)

        //Assert
        verify { cyclistListObserver.onChanged(listUser) }
    }

    @Test
    fun `verify error observer changed on failure fetchCyclistApi call`() {
        //Arrange
        val errorMessageObserver = mockk<Observer<String>>()
        every { errorMessageObserver.onChanged(any()) } answers {}
        viewModel.errorMessage.observeForever(errorMessageObserver)
        val error = "error thrown"
        val slotSuccess = slot<(List<Cyclists>) -> Unit>()
        val slotError = slot<(String) -> Unit>()
        coVerify { repository.fetchCyclists(capture(slotSuccess), capture(slotError)) }

        //Act
        slotError.invoke(error)

        //Assert
        verify { errorMessageObserver.onChanged(error) }
    }
}