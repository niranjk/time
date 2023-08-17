//
//  Tutorial.swift
//  iosApp
//
//  Created by Khatri, Niranjan on 16/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI


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

// Step 1 : Define an ObservableObjet

class UserData: ObservableObject {
    @Published var username: String = ""
}

struct Tutorial: View {
    @State private var showDialog = false
    
    let userData = UserData()
    
    var body: some View {
        NavigationView{
            UsernameContentView()
                .environmentObject(userData) // inject the environment object
            
            // Step 2. set up the environment object in your app's entry point
        }
}

struct ListItemView : View{
    var body: some View {
        VStack{
            List(items) { item in
                            NavigationLink(destination: DetailView(item: item)) {
                                Text(item.name)
                            }
                        }
            .navigationBarTitle("Items")
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
        }
        }
    }
}

struct FullScreenContentView: View {
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
        .background(Color.yellow)
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

struct CardView: View {
    var body: some View {
        VStack {
            Image(systemName: "abc") // Replace with your image name
                .resizable()
                .aspectRatio(contentMode: .fill)
                .frame(height: 150)
                .clipped()

            Text("Card Title")
                .font(.title)
                .padding()

            Text("This is the content of the card. You can put any text or other views here.")
                .font(.body)
                .padding()

            Spacer()
        }
        .background(Color.green) // Background color of the card
        .cornerRadius(10) // Corner radius to round the edges
        .shadow(radius: 5) // Drop shadow effect
        .padding() // Padding around the card
    }
}

struct UsernameContentView: View {
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

struct Tutorial_Previews: PreviewProvider {
    static var previews: some View {
        Tutorial()
    }
}
