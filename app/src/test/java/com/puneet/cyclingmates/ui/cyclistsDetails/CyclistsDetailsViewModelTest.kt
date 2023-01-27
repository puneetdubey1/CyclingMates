package com.puneet.cyclingmates.ui.cyclistsDetails

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateHandle
import com.puneet.cyclingmates.data.model.Cyclists
import com.puneet.cyclingmates.data.model.Location
import com.puneet.cyclingmates.data.model.Name
import com.puneet.cyclingmates.data.model.ProfilePic
import com.puneet.cyclingmates.ui.cyclingmatesdetails.CyclistDetailsViewModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
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
    class CyclistsDetailsViewModelTest {

        @get:Rule
        val mockitoRule: MockitoRule = MockitoJUnit.rule()

        @get:Rule
        var rule = InstantTaskExecutorRule()

        @MockK
        lateinit var savedStateHandle: SavedStateHandle

        lateinit var viewModel: CyclistDetailsViewModel

        @Before
        fun setUp() {
            Dispatchers.setMain(Dispatchers.Unconfined)
            MockKAnnotations.init(this, relaxUnitFun = true)
            every { savedStateHandle.get<Cyclists>("cyclists") } returns getMockedUser()
        }

        @Test
        fun `verify name observer changed when viewModel gets created`() {
            //Arrange
            val nameObserver = mockk<Observer<String>>()
            every { nameObserver.onChanged(any()) } answers {}

            //Act
            viewModel = CyclistDetailsViewModel(savedStateHandle)
            viewModel.name.observeForever(nameObserver)

            //Assert
            verify { nameObserver.onChanged("Mr Puneet Dubey") }
        }

        @Test
        fun `verify email observer changed when viewModel gets created`() {
            //Arrange
            val emailObserver = mockk<Observer<String>>()
            every { emailObserver.onChanged(any()) } answers {}

            //Act
            viewModel = CyclistDetailsViewModel(savedStateHandle)
            viewModel.email.observeForever(emailObserver)

            //Assert
            verify { emailObserver.onChanged("puneet@gmail.com") }
        }

        @Test
        fun `verify location observer changed when viewModel gets created`() {
            //Arrange
            val locationObserver = mockk<Observer<String>>()
            every { locationObserver.onChanged(any()) } answers {}

            //Act
            viewModel = CyclistDetailsViewModel(savedStateHandle)
            viewModel.location.observeForever(locationObserver)

            //Assert
            verify { locationObserver.onChanged("London, United Kingdom") }
        }

        @Test
        fun `verify profile image observer changed when viewModel gets created`() {
            //Arrange
            val imageObserver = mockk<Observer<String>>()
            every { imageObserver.onChanged(any()) } answers {}

            //Act
            viewModel = CyclistDetailsViewModel(savedStateHandle)
            viewModel.image.observeForever(imageObserver)

            //Assert
            verify { imageObserver.onChanged("large_pic_url") }
        }

        @Test
        fun `verify launchDialpad observer changed when callButtonClicked`() {
            //Arrange
            val dialpadObserver = mockk<Observer<String>>()
            every { dialpadObserver.onChanged(any()) } answers {}
            viewModel = CyclistDetailsViewModel(savedStateHandle)
            viewModel.launchDialpad.observeForever(dialpadObserver)

            //Act
            viewModel.callButtonClicked()

            //Assert
            verify { dialpadObserver.onChanged("9876543211") }
        }

        @Test
        fun `verify launchEmail observer changed when emailButtonClicked`() {
            //Arrange
            val launchEmailObserver = mockk<Observer<String>>()
            every { launchEmailObserver.onChanged(any()) } answers {}
            viewModel = CyclistDetailsViewModel(savedStateHandle)
            viewModel.launchEmail.observeForever(launchEmailObserver)

            //Act
            viewModel.emailButtonClicked()

            //Assert
            verify { launchEmailObserver.onChanged("puneet@gmail.com") }
        }

        private fun getMockedUser(): Cyclists {
            val user = mockk<Cyclists>()
            val name = mockk<Name>()
            every { name.title } returns "Mr"
            every { name.first } returns "Puneet"
            every { name.last } returns "Dubey"
            every { user.name } returns name

            every { user.phone } returns "9876543211"
            every { user.email } returns "puneet@gmail.com"

            val location = mockk<Location>()
            every { location.city } returns "London"
            every { location.country } returns "United Kingdom"
            every { user.location } returns location

            val picture = mockk<ProfilePic>()
            every { picture.medium } returns "medium_pic_url"
            every { picture.large } returns "large_pic_url"
            every { user.picture } returns picture
            return user
        }
    }
