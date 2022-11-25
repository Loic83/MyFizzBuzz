# MyFizzBuzz

## Used librairies

- ViewModel, LiveData => for faciliate configuration management and respect the architecture MVVM)
- Room => for persist data
- Hilt => for dependency injection
- Coroutines => for asynchronous tasks
- JUnit => for unit tests
- Robolectric => for implement unit tests

## Architecture

- This project is based on the Clean Architecture. 
- I have created three packages : Presentation(Activity/ViewModel), Domain(UseCases/Repository) and Data(Database).
- I also use the architecture MVVM with the implementation of Architectures Components (ViewModel, LiveData and Room).
- Dependency injection completes the architecture to define all dependencies into classes.

## To come later

- Improve the UI with Jetpack Compose.
- Use the multi-modularization for the Clean Architecture.
- Improve performances when the limit are very big.
- Improve unit tests for the LiveData.


