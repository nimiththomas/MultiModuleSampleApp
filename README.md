### 🚀 Android Multimodule Template
A modular, scalable, and maintainable Android project template built using modern Android development practices. This project is intended to serve as a reference for developers exploring the multimodular approach in Android. It is not a production-ready app but a code-driven showcase of clean architecture and modularization techniques.

### 📝 Description
This template demonstrates a fully decoupled Android app structure using Jetpack Compose, Kotlin, and modern Android development tools. The goal is to showcase a clean architecture pattern with separation of concerns, making development, testing, and scaling easier for complex Android apps.

### Technologies used:

🧑‍💻 Kotlin

🧱 Jetpack Compose

🌐 Retrofit (for network calls)

📦 Jetpack DataStore (for local persistence)

🧭 Compose Navigation 2

⚙️ Coroutines (for async operations)

🌒 Dark Mode Support

### 🧩 Modularization Structure
plaintext
Copy
Edit
├── build-logic/            # Custom Gradle plugins and shared build logic
├── core/
│   ├── datastore/          # Handles DataStore setup and access
│   ├── network/            # Handles Retrofit, API interfaces, and interceptors
|   ├── data/               # Repositories combining data from core modules
|   ├── domain/             # Use cases for business logic
|   ├── common/             # Shared model classes and common utility classes
|   ├── designsystem/       # App-wide color palette, typography, and themes
|   ├── uicomponents/       # Reusable composables built on top of design system
|── feature/
|   ├── feature1/           # Feature 1 - includes screens, viewmodels, navigation
|   ├── feature2/           # Feature 2 - includes screens, viewmodels, navigation
└── app/                    # Entry point, injects features and applies theme

### 📂 Layer Breakdown

## build-logic/
Contains custom Gradle plugins to simplify setup across modules.

Centralizes build configuration (e.g., Kotlin/Compose compiler settings, dependency versions).

Promotes DRY (Don't Repeat Yourself) principles for build scripts.

## core/
 
network/:Retrofit setup, API interfaces, interceptors, and network config.

datastore/: DataStore instance and related getters/setters for persistent storage.

 data/
Connects with both network and datastore to provide data to the app.

Hosts repositories that abstract data sources and expose data to the domain layer.
Depends on:
network/
datastore/

domain/
Pure Kotlin modules with no Android dependencies.

Contains use cases that wrap around repositories and apply business logic.
Depends on:
data/

common/
Shared utility classes and model definitions.

Promotes reuse across all modules.

designsystem/
Centralized color definitions, typography, and theme support (including dark mode).

Ensures consistent UI across modules.

uicomponents/
Contains reusable Composable UI components (buttons, cards, etc.).
Built on top of the designsystem.
Depends on:
designsystem/

feature1/ & feature2/
Self-contained features including:
Navigation graph
Screens
ViewModels
UI state management

Depends on:
domain/
common/
uicomponents/
designsystem/

📱 app/
Main entry point of the application.

Injects and assembles all features.

Applies theming via the design system.

🗺️ Modular Architecture Diagram
plaintext
Copy
Edit

## ✅ Advantages of This Approach
🔄 Separation of Concerns: Each module has a single responsibility.

🚀 Scalability: Easy to add new features without affecting existing ones.

🧪 Testability: Domain and data logic can be unit tested in isolation.

📦 Reusability: Common components and models can be reused across features.

📐 Maintainability: Isolated modules reduce the risk of code conflicts.

## ⚠️ Disadvantages
📁 Initial Complexity: The learning curve for beginners can be steep.

🕸️ Overhead for Small Projects: Might be overkill for simple apps.

⏱️ Setup Time: Setting up modules and wiring dependencies takes time.

## 🛠️ How to Clone and Use
bash
Copy
Edit
git clone https://github.com/nimiththomas/MultiModuleSampleApp.git
Open in Android Studio
Open Android Studio.

Choose "Open an existing project".

Navigate to the cloned directory.

Let Gradle sync complete.

Build & Run
Select the app module.

Hit Run ▶️ on your emulator/device.
