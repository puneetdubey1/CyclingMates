**Cycling Mates Android Project**

This is the readme file for the Cycling Mates Android project. This project is built using the Gradle build system and utilizes various libraries and plugins to develop a cycling-related application.

**Screens:**

**Night mode on:**

<img width="367" alt="Screenshot 2023-06-16 at 10 01 13" src="https://github.com/puneetdubey1/CyclingMates/assets/123604789/74736420-62e3-4bd1-8af1-8a94a4cc60bc">
<img width="363" alt="Screenshot 2023-06-16 at 10 02 06" src="https://github.com/puneetdubey1/CyclingMates/assets/123604789/6e249322-ca68-4785-bcd5-dc4faf28f9ed">



**Night Mode off: **

<img width="364" alt="Screenshot 2023-06-16 at 10 03 01" src="https://github.com/puneetdubey1/CyclingMates/assets/123604789/e34ecec9-6632-446a-99e6-dd82cbc6a7d1">
<img width="366" alt="Screenshot 2023-06-16 at 10 02 45" src="https://github.com/puneetdubey1/CyclingMates/assets/123604789/d5247d5a-677a-4c07-bcbe-66453497d857">


**Project Structure**

The project follows a standard Android project structure. The main components of the project are:



**app:** This module contains the main application code, including activities, fragments, and other UI components.

**buildSrc:** This module contains custom Gradle build logic and dependencies.

**gradle:** This directory contains the Gradle wrapper files.

**src:** This directory contains the source code and resources for the application.

**Prerequisites**

Android SDK

Kotlin

**Getting Started**

To build and run the project, follow these steps:



**Clone the repository:** git clone <repository_url>

Open the project in Android Studio.

Build the project using the Gradle build system.


Connect an Android device or emulator.

Run the application on the device/emulator.

**Configuration**

The project uses several plugins and libraries, which are defined in the project's Gradle file (build.gradle). Here is an overview of the major configurations:



**Plugins**


com.android.application: Enables building an Android application.

kotlin-android: Adds Kotlin language support to the Android project.

kotlin-kapt: Enables Kotlin annotation processing.

kotlin-parcelize: Allows automatic Parcelable implementation generation for Kotlin classes.

androidx.navigation.safeargs.kotlin: Generates Kotlin code for Android Navigation component arguments.

dagger.hilt.android.plugin: Integrates Dagger Hilt for dependency injection.

Android Configuration

compileSdkVersion: Specifies the Android SDK version used for compilation.

defaultConfig: Defines the default configuration for the application, including application ID, minimum and target SDK versions, and version information.

buildTypes: Configures build types, such as release and debug.

compileOptions: Sets the source and target compatibility to Java 8.

kotlinOptions: Sets the JVM target to version 1.8.

buildFeatures: Enables the View Binding feature.

testOptions: Configures options for unit tests.

Dependencies

The project includes various dependencies that are used to implement different features and libraries. Some notable dependencies include:



**Kotlin Standard Library**

AndroidX libraries (Core, Material, ConstraintLayout)

Android Navigation Component


Android Lifecycle components (LiveData, ViewModel)

Dagger Hilt for dependency injection

Retrofit and OkHttp for network requests

Kotlin Coroutines for asynchronous programming

Glide for image loading and caching

JUnit and MockK for testing



**License**

This project is licensed under the MIT License.



**Contributing**

Contributions to this project are welcome. If you find any issues or have suggestions for improvement, please create a new issue or submit a pull request.
