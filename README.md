
# Kotlin Multiplatform 

1. What is Kotlin Multiplatform?

- KMP uses Kotlin as programming language and supports MultiPlatform 
- KMP supports 
- Android
- iOS - macOS - watchOS - tvOS 
- Windows 
- Linux 
- Web 
- Kotlin already works on platform that support JVM 
- for non JVM platforms it uses the Kotlin Native. 
- Kotlin Native compiles Kotlin to Native bytecode that can work natively 
on Apple OS. 

2. What is difference between KMP and KMM?
- KMP means we write code using Kotlin programming lanaguage for Multiple Platforms. 
- KMM is specially for crossplatform mobile application development. 
- KMP includes : Mobile , Desktop, Web and Server 
- KMM : Only include the Mobile 

3. What is the history of Cross-platform?
Web Based Frameworks 
- PhoneGap : HTML5, CSS3 and JavaScript 
- Apache Cordova : Fork of PhoneGap and opensource 
- Ionic : Angular, React and Vue UI frameworks 
- Appcelerator Titanium : JavaScript based SDK .. 

- Xamarin : Microsoft C# , .NET runtime , JIT compilation 
- React Native : JavaScript and Web based 

- Flutter : Dart 

4. Why we should use KMM? 
- uses Kotlin programming language
- Compile both JVM and Native platforms 
- Ideal also for Server Development with Ktor library 
- Kotlin is similar to Swift 
- Shared Business Logic both for iOS and Android 
- for iOS you use : SwiftUI 
- for Android you use : Jetpack Compose 
- for Desktop you can use : Compose Multiplatfom 
- It is 100% native because UI are created natively only business logic 
is shared.


5. How to setup your Environment for KMM Application Development?

6. What are different layers of the ANY APP ?
- NETWORK LAYER
- DATABASE LAYER
- REPOSITORY LAYER (interacting with DB or Network layers)
- BUSINESS LOGIC LAYER 
- UI LAYER 

7. What is Business Logic layer in terms of KMM?
- iOS Business Logic 
- Android Business Logic 
- set of specifications : and each team has to implement them 
- finally they have to test each edge cases and make sure that both platform 
follows the specifications. 
- With KMM we have only one business logic and you need to write the test 
just once. 

8. Database Layer 
- SQLDelight Library 
- multiplatfom library designed for all platforms. 
- also you need to write the test just once. 
[https://cashapp.github.io/sqldelight/2.0.0/]

9. KMM UI Layer
- SwiftUI for iOS 
- Jetpack Compose for Android 

10. Jetbrains DateTime Library 
[https://github.com/Kotlin/kotlinx-datetime]
- multiplatform 
- working with date and time

11. Napier Loggin Library 
- [https://github.com/AAkira/Napier]
- logging library 

12. How do you create a common business logic in KMM?

13. Understanding Android Jetpack Compose
- is a declarative UI System i.e. it uses the function to create 
complete UI or parts of the UI 
- reduced boiler plate codes
- the UI is drawn with current State no listen for changes is required 
- One Entry Point : Activity 
- no fragment is required 
- setContent{}
- no xml files is required 
- @Composable annotation this tells the Jetpack Compose that this function
can be drawn on screen. 
- no composable function returns a value

14. Theming in Jetpack Compose
- Material Compose Library : so we can use MaterialTheme class 
- set our colors, fonts and shapes 
- also check the system is using dark theme or light theme 

































