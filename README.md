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

<img src="https://github.com/user-attachments/assets/b5260f4d-f5ae-4f09-bf23-1990d0824fb4" width="350" />

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


## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/OsWaldo982/FeriadosChile_CleanArchitecture_MVVM_DaggerHilt_Retrofit_JetpackCompose.git

   Open the project in Android Studio.

Ensure you have the latest Android Studio and SDKs installed.

Sync Gradle and run the project on an emulator or physical device.

API Used
The app fetches data from the Boostr Holidays API:

Endpoint: https://api.boostr.cl/holidays.json
