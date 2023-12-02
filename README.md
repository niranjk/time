
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



15. How to run your iOS App from Android Studio in your KMM App?
- select iOS Configuration from EditConfigurations 
- Select your Execution Target. 


16. What is XCode?

17. Let's understand UI System in iOS. 
- StoryBoard 
- UIKit 
- SwiftUI

"UIKit," "Storyboard," and "SwiftUI" are all terms related to user interface development in the context
of iOS and macOS app development using the Swift programming language. Let me explain each of them:

1. **UIKit:**
   UIKit is a framework provided by Apple for building user interfaces in iOS and macOS applications.
It's been around since the early days of iOS development and provides a collection of classes, views, 
and controllers that you can use to create your app's user interface. With UIKit, you write code to 
define and customize UI elements, layout, and behavior. It's a procedural approach to building interfaces.

2. **Storyboard:**
   A storyboard is a visual interface builder tool provided by Apple as part of the Xcode development 
environment. It allows developers to design their app's user interface using a graphical interface rather
than writing all the interface code manually. Storyboards enable you to create and connect view controllers,
design the layout of screens, and define the flow of navigation between different screens. 
Storyboards are tightly integrated with UIKit.

3. **SwiftUI:**
   SwiftUI is a newer declarative UI framework introduced by Apple. 
It aims to simplify the process of creating user interfaces by allowing developers to describe 
the user interface and its behavior using a declarative syntax. With SwiftUI, you define the 
interface's structure and appearance using a series of views and modifiers. 
SwiftUI automatically handles many aspects of layout, animation, and responsiveness. 
It's designed to work across all Apple platforms, including iOS, macOS, watchOS, and tvOS.

Key Differences:

- **Approach:**
    - **UIKit:** Requires writing code to define the UI, layout, and behavior. It's a more procedural approach.
    - **Storyboard:** Allows for visual design of interfaces and navigation flows, reducing the need for some code.
    - **SwiftUI:** Uses a declarative approach, where you describe the UI's structure and appearance using code. It aims to minimize the amount of code needed.

- **Complexity:**
    - **UIKit:** Can be more complex and require more code for certain tasks.
    - **Storyboard:** Simplifies UI design and navigation flow but can become complex for larger apps with multiple screens.
    - **SwiftUI:** Aims to reduce complexity by abstracting away many of the manual tasks involved in UI development.

- **Flexibility:**
    - **UIKit:** Offers a high degree of customization and control over UI elements and behavior.
    - **Storyboard:** Provides a visual way to configure UI components and their connections.
    - **SwiftUI:** Balances customization with built-in behaviors, making it easier to achieve certain common UI patterns.

- **Adoption:**
    - **UIKit:** Has been the standard for iOS UI development for many years.
    - **Storyboard:** Widely adopted for creating interfaces, especially in smaller projects.
    - **SwiftUI:** Gaining traction and popularity due to its modern approach and cross-platform capabilities.

In recent years, SwiftUI has gained significant attention due to its streamlined approach and capabilities, while UIKit and storyboards remain relevant for developers who have existing projects or prefer more fine-grained control over their interfaces. Your choice between these options would depend on factors like project requirements, personal preference, and the platform you're targeting.

18. Some key concepts of SwiftUI
- @main tag : starting point 
- App protocol 
- var name body : retruns a Scene 
- Scene is a container for the root view of a view hierarchy 
- WindowGroup is a Scene
- on iOS you can contain only one window, but on macOS and iPadOS it can contain multiple windows- 

19. Commands for Xcode 
/**
3 important commands in Xcode
1. Command + B -> to build your application
2. Command + R -> to run your applicaiton
3. Command + N -> to create a new file
   */

20. What is State in SwiftUI?
- @State is used with simple struct types 
- it saves states between redraws of screens 
- any @State property wrapper meanse that the current view owns this data. 
- SwiftUI will keep track of this @State variable changes and redraws whenever 
it's value changes. 


21. What is NavigationView?
    `NavigationView` is a SwiftUI container view that's specifically
designed for managing navigation and creating navigation hierarchies 
within an app's user interface. It's part of the SwiftUI framework,
introduced by Apple as a modern way to create user interfaces in a
declarative manner. 
`NavigationView` is particularly useful when you want to implement 
navigation between different views or screens within your app.

With `NavigationView`, you can create a navigation interface 
similar to what you might find in a navigation controller 
in UIKit or a UINavigationController in iOS development. 
It provides a navigation bar at the top of the screen that
typically contains a title, navigation controls, and back buttons,
making it easier for users to move between different content.

Here's a simple example of how you might use `NavigationView`:

```swift
import SwiftUI

struct ContentView: View {
    var body: some View {
        NavigationView {
            List {
                NavigationLink("First Screen", destination: Text("This is the first screen"))
                NavigationLink("Second Screen", destination: Text("This is the second screen"))
            }
            .navigationBarTitle("Navigation Example")
        }
    }
}

@main
struct MyApp: App {
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
```

In this example, the `NavigationView` contains a `List` of items,
each wrapped in a `NavigationLink`. When a user taps on one of the links,
they'll be taken to a destination view. The `navigationBarTitle` 
modifier sets the title of the navigation bar.

`NavigationView` also provides support for navigation stacks,
allowing you to push and pop views onto and off the navigation hierarchy, 
similar to how you would with a UINavigationController. 
It automatically handles the navigation bar and back button behavior for you.

In summary, `NavigationView` in SwiftUI is a powerful tool for
managing navigation flows and creating hierarchies of views within
your app's user interface. It simplifies the process of creating 
navigation-based user experiences and integrates well with other
SwiftUI components.

22. What is VStack? 
- is a continer view in SwiftUI that arranges its child views vertically
in a column. 
- VStack stands for Vertical Stack 

23. Lets learn about List and ForEach?
- ForEach is used to iterate over a collection of data and create views 
dynamically.
# part 1 
  struct Item: Identifiable {
  let id: UUID
  let name: String
  let description: String
  }

let items: [Item] = [
Item(id: UUID(), name: "Item 1", description: "Description 1"),
Item(id: UUID(), name: "Item 2", description: "Description 2"),
// Add more items as needed
]


# part 2 

  import SwiftUI

struct ContentView: View {
var body: some View {
NavigationView {
List(items) { item in
NavigationLink(destination: DetailView(item: item)) {
Text(item.name)
}
}
.navigationBarTitle("Items")
}
}
}

struct DetailView: View {
let item: Item

    var body: some View {
        VStack {
            Text(item.name)
            Text(item.description)
        }
        .navigationBarTitle(item.name)
    }
}

@main
struct MyApp: App {
var body: some Scene {
WindowGroup {
ContentView()
}
}
}


24. How to add ToolbarItem in SwiftUI NavigationView?
    .toolbar{
    ToolbarItem(placement: .navigationBarLeading){
    Button("Edit"){
    // handle your edit action here
    }
    } // Toolbar
    ToolbarItem(
    placement: .navigationBarTrailing
    ){
    Button(action: {
    // do sth
    }){
    Image(systemName: "plus")
    .frame(alignment:.trailing)
    .foregroundColor(.black)
    }
    }// ToolbarItem

            }// toolbar


25. How to use fullScreenCover for presenting your view in full-screen mode?
    The `fullScreenCover` modifier in SwiftUI allows you to present a view
in full-screen mode that covers the entire screen. 
It's often used for modal presentations, such as displaying a form,
settings, or other temporary views. 
Here's an example of how to use `fullScreenCover`:

```swift
import SwiftUI

struct ContentView: View {
    @State private var isPresentingModal = false
    
    var body: some View {
        Button("Present Modal") {
            isPresentingModal = true
        }
        .fullScreenCover(isPresented: $isPresentingModal) {
            ModalView(dismissAction: {
                isPresentingModal = false
            })
        }
    }
}

struct ModalView: View {
    let dismissAction: () -> Void
    
    var body: some View {
        VStack {
            Text("This is a modal view")
            Button("Dismiss") {
                dismissAction()
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .background(Color.white)
    }
}

@main
struct MyApp: App {
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
```

In this example:
- The `ContentView` has a button that triggers the presentation of the modal
view.
- The `fullScreenCover` modifier is used on the button. 
It takes a binding to a Boolean value (`isPresented`) that controls 
whether the modal view is displayed.
- When the `isPresented` value becomes `true`, the `ModalView` 
is presented in full-screen mode.
- The `ModalView` contains a dismiss button that, when tapped,
sets the `isPresentingModal` value back to `false`, which dismisses 
the modal view.

The `ModalView` is presented in full-screen mode and covers the entire screen.
You can customize the content of the modal view as needed.

Remember that `fullScreenCover` is available in iOS 15 and later. 
If you're using an earlier version of iOS, you might need to use 
other presentation methods such as `sheet` or `presentationMode`.


26. How to create a simple CardView in SwiftUI?

27. Using @EnvironmetalObject
    In SwiftUI, the `@EnvironmentObject` property wrapper is used 
to share data between different views in your app's hierarchy without
passing the data explicitly. It relies on an `ObservableObject` 
being injected into the environment of a view, allowing any child view
to access and observe changes to that object.

Here's an example of how to use `@EnvironmentObject` to share data between
views:

1. Define an ObservableObject class:

```swift
import SwiftUI
import Combine

class UserData: ObservableObject {
    @Published var username: String = ""
}
```

2. Set up the environment object in your app's entry point 
(usually in the `App` struct):

```swift
@main
struct MyApp: App {
    let userData = UserData()

    var body: some Scene {
        WindowGroup {
            ContentView()
                .environmentObject(userData) // Inject the environment object
        }
    }
}
```

3. Use `@EnvironmentObject` in your views:

```swift
struct ContentView: View {
    @EnvironmentObject var userData: UserData

    var body: some View {
        VStack {
            Text("Welcome, \(userData.username)!")
                .padding()

            EditUsernameView()
        }
    }
}

struct EditUsernameView: View {
    @EnvironmentObject var userData: UserData

    var body: some View {
        TextField("Enter your username", text: $userData.username)
            .padding()
    }
}
```

In this example:
- The `UserData` class is an `ObservableObject` that contains a
`@Published` property `username`.
- In the `MyApp` struct, the `UserData` instance is injected into
the environment using the `.environmentObject` modifier.
- Both `ContentView` and `EditUsernameView` access the `userData` 
object using the `@EnvironmentObject` property wrapper.
- When the `username` property changes, the `@Published` attribute
triggers an update to the views that observe it, causing automatic UI updates.

This pattern is especially useful for sharing data across multiple views 
without needing to pass it through each level of the view hierarchy. 
It's a fundamental mechanism for managing and syncing shared data
throughout your SwiftUI app.



# How do you connect to Platform Specific API in KMM ??
- with Examples I am gonna explain you how you structure your code 
according to KMP's suggested approach to handle Platform Specific APIs 
- how we reuse code between platforms ?? 

- expect / actual mechanism 

- expect : think as Interface in Android & protocol in Swift 


- define classes, properties and function/methods using expect 
- actual implementation in each platform 



 # Regular Framework vs Cocoapods for iOS Framework distribution management 

- Compose Navigation added 
[https://developer.android.com/jetpack/compose/navigation]

























































