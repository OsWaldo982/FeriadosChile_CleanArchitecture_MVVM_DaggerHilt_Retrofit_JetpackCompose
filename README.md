# FeriadosApp

FeriadosApp is a modern Android application designed to fetch and display a list of holidays using clean and maintainable architecture. The app is focused on providing a professional user experience and a seamless way to visualize holiday information.

## Features

- Fetches holiday data from a remote API using **Retrofit**.
- Displays holidays in a clean and organized interface using **Jetpack Compose**.
- Implements the **MVVM (Model-View-ViewModel)** pattern for better separation of concerns.
- Uses **Dagger Hilt** for dependency injection to ensure scalability and testability.
- Adopts **Clean Architecture** principles for maintainability.
- Fully written in **Kotlin**.

## Architecture Overview

The app follows **Clean Architecture** with distinct layers:
1. **Domain**: Contains business logic and use cases.
2. **Data**: Manages data sources (e.g., API or local database).
3. **Presentation**: Manages UI logic using Jetpack Compose and ViewModels.

### Technologies Used

- **Kotlin**: Modern and concise language for Android development.
- **Jetpack Compose**: Declarative UI toolkit for building native Android apps.
- **Retrofit**: HTTP client for API communication.
- **Dagger Hilt**: Simplifies dependency injection in Android apps.
- **LiveData**: Observes and reacts to data changes in real-time.
- **Material 3**: For a sleek and modern UI design.

## Screenshots

*(Add screenshots of your app here to showcase its design and functionality)*

## How It Works

1. **API Integration**:
   - The app fetches holiday data from a remote API using Retrofit.
   - Responses are parsed into data models using Kotlin's data classes.

2. **Display Holidays**:
   - Holidays are shown in a scrollable list with details like title, date, type, and extra information.
   - A loading spinner is displayed while data is being fetched.

3. **Architecture**:
   - The **ViewModel** fetches data and provides it to the composables.
   - UI components react to state changes observed via LiveData.

## Folder Structure

The app has a well-organized folder structure to follow Clean Architecture and MVVM:

com.example.feriadosapp ├── data │ ├── api # Retrofit service and API configurations │ ├── model # Data classes for API responses │ └── repository # Repository implementation for data handling ├── domain │ └── usecase # Business logic encapsulated in use cases ├── di │ └── HiltModules # Dependency injection modules ├── presentation │ ├── ui # Composables for UI screens │ ├── viewmodel # ViewModels for each feature │ └── theme # Custom Material 3 theme
