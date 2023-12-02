import SwiftUI

@main
struct TimeApp: App {
    init() {
            let tabBarItemAppearance = UITabBarItemAppearance()
            tabBarItemAppearance.configureWithDefault(for: .stacked)
            tabBarItemAppearance.normal.titleTextAttributes = [.foregroundColor: UIColor.systemBlue]
            tabBarItemAppearance.selected.titleTextAttributes = [.foregroundColor: UIColor.white]
            tabBarItemAppearance.normal.iconColor = .black
            tabBarItemAppearance.selected.iconColor = .white
            
            let appearance = UITabBarAppearance()
            appearance.configureWithOpaqueBackground()
            appearance.stackedLayoutAppearance = tabBarItemAppearance
            appearance.backgroundColor = .systemBlue
            
            UITabBar.appearance().standardAppearance = appearance
            if #available(iOS 15.0, *) {
                UITabBar.appearance().scrollEdgeAppearance = appearance
            }
        }
    
	var body: some Scene {
		WindowGroup {
			// ContentView()
            PlatformContentView()
		}
	}
}

/**
 3 important commands in iOS
 1. Command + B -> to build your application
 2. Command + R -> to run your applicaiton
 3. Command + N -> to create a new file
 */
