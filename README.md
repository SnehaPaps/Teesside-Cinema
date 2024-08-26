**The Movies Info**

*The Movies Info app*, crafted for *Teeside*, is a dynamic application designed with cutting-edge technologies, including *Jetpack Compose* and *Kotlin*. This project follows to clean code principles, thanks to the clarity and maintainability they bring. The application is built with the *Model-View-ViewModel (MVVM)* design pattern, which promotes a stable and scalable codebase. Additionally, *Dagger Hilt* is used for efficient dependency injection, which improves modularity and testability.

 About The App
With this app you can get information about movies and TV series, watch trailer, search and find the latest, most popular and top rated movies and TV series.

 Key Features

- Jetpack Compose: The app leverages *Jetpack Compose*, a modern Android UI toolkit, to create a seamless and interactive user experience.
- Kotlin: Developed entirely in *Kotlin*, the codebase benefits from the conciseness and expressiveness of the language, promoting efficient and readable code.
- MVVM Design Pattern: The application structure is organized following the *MVVM* design pattern, promoting separation of concerns and facilitating maintainability.
- Dagger Hilt: Dependency injection is handled by *Dagger Hilt*, streamlining the management of dependencies and improving the overall architecture.
- Retrofit: Network calls are facilitated by *Retrofit*, enabling seamless communication with remote APIs.
- Room: *Room* is used for local data storage, providing a reliable and efficient way to manage app-related data.
- Offline Capability: This is a first offline app, ensuring users best possible experience even without an active internet connection.
- Biometrics security: Thanks to the android Biometrics authentication, The users cans elect they type of biometrics security supported by their devices to permit them secured
- Onboarding screen: The app has an Onboardingwalking screen to present to the user at first impression upon installing the App
- The app also supports push notifcation : Firebase cloud messaging third party dependencies were used to leverage the notification system of the app to alert the users about up coming Movies
- MVVM: The Model view ViewModel architectural patten was used alongside with ROOM database for caching local data in the app.
- Retrofit: The Retrofit library by Square was used to do API calls from web server providing the movies data contents.
- Paging 3 library: The Paging 3 library was used to send events to the Repository and receiving a paginated response of flows.
- Coroutines: This is a Reactive programming library built with Kotlin working with ViewModel and liveData for lifecycle awareness of the whole app.
- Datastore: This is a NoSQL database provided by google to cache key pair data locally to maintain the states of the app.
- SharedPreference: This is also a key pair value database built in android to cache data locally.
-  Splashscreen API: The newly Splashscreen API introduced by google in Android 12 was used to power the Splashscreen of the app.





Jetpack Compose:
Description: A modern Android UI toolkit for building native UIs.
How it works: Allows you to create UI components in a declarative way, making it easier to build and maintain complex layouts. 
In the Teeside University Cinema app, it helps create a seamless and interactive interface for browsing and viewing movie lists.


Kotlin:
Description: A modern, statically-typed programming language for the JVM.
How it works: Provides concise and expressive syntax, reducing boilerplate code. This improves development speed and code readability, 
making the app more maintainable.

MVVM Design Pattern:
Description: Model-View-ViewModel design pattern.
How it works: Separates the UI (View) from the business logic (ViewModel) and data (Model). 
This separation of concerns enhances code organization and testing. In the app, 
the ViewModel handles data fetching and provides data to the UI, ensuring a responsive and consistent user experience.


Dagger Hilt:
Description: A dependency injection library for Android.
How it works: Simplifies the management of dependencies, making the codebase more modular and testable. 
In the app, it ensures that dependencies like network clients and databases are provided efficiently.

Retrofit:
Description: A type-safe HTTP client for Android and Java.
How it works: Facilitates network calls to fetch movie data from remote APIs. 
It handles API requests and responses, converting them into Java/Kotlin objects for easier use within the app.


Room:
Description: A database library for local data storage.
How it works: Provides an abstraction layer over SQLite to handle database access. 
In the app, Room is used to cache movie data locally, allowing users to access content even when offline.

Offline Capability:
Description: Ensures app functionality without an active internet connection.
How it works: Utilizes local storage (Room) to save data fetched from remote sources, 
ensuring the app can display movie lists even without internet access.


Biometrics Security:
Description: Utilizes device biometrics for authentication.
How it works: Allows users to secure the app using fingerprint or face recognition, enhancing security and user trust.

Onboarding Screen:
Description: Introduces users to the app's features on first launch.
How it works: Presents a series of screens explaining key functionalities, improving user engagement and understanding.

Push Notifications:
Description: Uses Firebase Cloud Messaging for notifications.
How it works: Alerts users about new and upcoming movies, engaging them and encouraging app usage.

Paging 3 Library:
Description: Handles loading of paginated data.
How it works: Efficiently loads large datasets in smaller chunks, reducing memory usage and improving performance. 
In the app, it helps load movie lists smoothly as users scroll.

Coroutines:
Description: A concurrency library for Kotlin.
How it works: Manages background tasks like network calls and database operations without blocking the main thread. 
This ensures a smooth and responsive UI.

Datastore:
Description: A modern data storage solution for key-value pairs.
How it works: Replaces SharedPreferences for better performance and reliability. 
It stores small amounts of data, like user preferences, enhancing the app's customization options.

SharedPreference:
Description: Stores key-value pairs locally.
How it works: Manages user-specific settings and preferences, providing a personalized user experience.

Firebase Google authentication
Description: It helps to authenticate users while using the Backend as a service from google, 
Removing the stress of building and authenticate users

Splashscreen API:
Description: Powers the app's splash screen.
How it works: Displays a branded launch screen, improving the app's initial user experience.


Report on Jetpack Compose
Background: Jetpack Compose was introduced by Google in 2019 as a modern UI toolkit for Android development, becoming stable in 2020. It was designed to address the limitations of the traditional Android UI framework, which relied heavily on XML for layout design.

Challenges Before:

Complexity and Boilerplate: The traditional approach required a lot of boilerplate code and complex XML files, making UI development cumbersome.
Fragmentation: Managing different UI components and states across various Android versions was challenging.
Maintenance: Maintaining complex UIs often resulted in tangled code that was hard to manage and debug.
Improvements:

Declarative UI: Compose allows developers to create UIs in a declarative way, reducing boilerplate and making the code more readable and maintainable.
Single Language: UI components are built using Kotlin, unifying the development process.
Reactive Programming: It simplifies state management, making UIs more predictable and easier to debug.

Report on Kotlin
Background: Kotlin, developed by JetBrains, was introduced in 2011 and became an official language for Android development in 2017.

Challenges Before:

Verbosity: Java, the primary language for Android development, required a lot of boilerplate code.
Null Safety: Null pointer exceptions were a common issue in Java.
Modern Features: Java lacked many modern language features that developers desired.
Improvements:

Conciseness: Kotlin’s syntax is concise, reducing the amount of code required.
Null Safety: Kotlin provides built-in null safety, reducing runtime errors.
Interoperability: Kotlin is fully interoperable with Java, allowing gradual adoption.

Report on MVVM Design Pattern
Background: MVVM (Model-View-ViewModel) originated from the Microsoft community for use in WPF (Windows Presentation Foundation). It was adopted by the Android community to improve code organization.

Challenges Before:

Tight Coupling: Traditional Android apps often had tightly coupled UI and business logic, making maintenance difficult.
Testing: It was hard to test UI components independently from the business logic.
Improvements:

Separation of Concerns: MVVM separates UI, business logic, and data handling, improving code maintainability.
Testability: ViewModels can be tested independently, improving code quality.

Report on Dagger Hilt
Background: Dagger, a popular dependency injection library, was adapted into Dagger Hilt by Google to provide a simpler API for Android development.

Challenges Before:

Manual Dependency Management: Managing dependencies manually was error-prone and tedious.
Code Reusability: Lack of proper dependency injection made code less modular and reusable.
Improvements:

Simplified API: Hilt simplifies dependency injection, reducing boilerplate.
Modularity: Enhances code modularity and reusability.
Report on Retrofit
Background: Retrofit, developed by Square, was introduced to simplify HTTP requests in Android applications.

Challenges Before:

Complex Networking Code: Writing networking code using HttpURLConnection or Apache HttpClient was complex and error-prone.
Manual Parsing: Parsing JSON responses manually was cumbersome.
Improvements:

Type Safety: Retrofit provides a type-safe way to handle network requests.
Easy Parsing: Integrates with libraries like Gson or Moshi to automatically parse JSON responses.
Report on Room library
Background: Room was introduced as part of Android Jetpack in 2018 to simplify local database management.

Challenges Before:

Raw SQL Queries: Using SQLite directly required writing raw SQL queries, which were error-prone.
Lack of Abstraction: No abstraction layer made it hard to manage database migrations and operations.
Improvements:

Abstraction Layer: Room provides an abstraction over SQLite, making database operations simpler and safer.
LiveData Integration: Easily integrates with LiveData, making it easier to observe database changes.

Report on Offline Capability
Background: Offline capability has always been a critical requirement, especially for apps in areas with unstable internet connectivity.

Challenges Before:

Data Synchronization: Ensuring data consistency between local storage and remote servers was challenging.
User Experience: Apps without offline capability provided a poor user experience during connectivity issues.
Improvements:

Local Caching: Libraries like Room and Retrofit enable efficient local caching.
Seamless Experience: Ensures that users can access content and continue using the app even without an internet connection.

Report on Biometrics Security
Background: Biometrics security became a mainstream feature with the introduction of fingerprint sensors and facial recognition on mobile devices.

Challenges Before:

User Authentication: Traditional authentication methods like passwords and PINs were less secure and user-friendly.
Security: Ensuring secure access to sensitive information was difficult.
Improvements:

Enhanced Security: Biometrics provide a secure and convenient way to authenticate users.
User Experience: Improves the user experience by offering quick and easy authentication.

Report on Onboarding Screen
Background: Onboarding screens became a standard practice to improve user engagement and retention.

Challenges Before:

User Understanding: Users often struggled to understand the app’s features and navigation.
User Retention: Poor onboarding could lead to high user drop-off rates.
Improvements:

User Engagement: Onboarding screens educate users about key features, improving engagement.
Retention: Helps retain users by providing a smooth initial experience.

Report on Push Notifications
Background: Push notifications have been used for real-time user engagement and communication.

Challenges Before:

User Engagement: Keeping users engaged with the app was difficult without timely updates.
Complex Implementation: Implementing push notifications required complex setup and maintenance.
Improvements:

Real-time Updates: Push notifications keep users informed about new content and updates.
User Retention: Encourages users to return to the app regularly.

Report on Paging 3 Library
Background: The Paging library was introduced to handle large datasets efficiently in Android apps.

Challenges Before:

Performance Issues: Loading large datasets at once led to performance issues and high memory usage.
Smooth Scrolling: Ensuring smooth scrolling with large datasets was challenging.
Improvements:

Efficient Data Loading: Paging 3 loads data in smaller chunks, improving performance.
User Experience: Ensures smooth scrolling and a better user experience.

Report on Coroutines
Background: Kotlin Coroutines were introduced to simplify asynchronous programming.

Challenges Before:

Complex Asynchronous Code: Handling asynchronous tasks with callbacks or RxJava was complex and error-prone.
Thread Management: Managing threads manually was difficult.
Improvements:

Simplified Concurrency: Coroutines provide a simple way to manage background tasks.
Readability: Makes asynchronous code more readable and maintainable.

Report on Datastore
Background: DataStore was introduced as a modern solution to replace SharedPreferences.

Challenges Before:

Performance Issues: SharedPreferences had performance issues and was not suitable for large data sets.
Concurrency Issues: Handling concurrent read/write operations was problematic.
Improvements:

Improved Performance: DataStore offers better performance and reliability.
Safety: Provides a safer way to store key-value pairs, reducing concurrency issues.

Report on SharedPreference
Background: SharedPreferences has been a part of Android since its early days for storing simple key-value pairs.

Challenges Before:

Limited Capability: Not suitable for large or complex data.
Concurrency: Issues with concurrent access and updates.
Improvements:

Simple Storage: Suitable for storing small amounts of user-specific settings and preferences.
Easy Access: Provides a straightforward API for accessing data.

Report on Firebase Google Authentication
Background: Firebase Authentication provides a backend as a service for user authentication.

Challenges Before:

Authentication Management: Building and managing authentication systems was complex and time-consuming.
Security: Ensuring secure authentication was difficult.
Improvements:

Simplified Authentication: Firebase provides a ready-to-use solution for authentication, reducing development time.
Security: Offers robust security features, enhancing user trust.

Report on Splashscreen API
Background: The Splashscreen API was introduced to provide a standardized way to implement splash screens.

Challenges Before:

Inconsistent Implementations: Developers had to implement custom solutions, leading to inconsistent user experiences.
Performance: Improperly implemented splash screens could negatively impact app performance.
Improvements:

Consistency: Provides a standardized way to implement splash screens across Android apps.
User Experience: Ensures a smooth and branded launch experience.
