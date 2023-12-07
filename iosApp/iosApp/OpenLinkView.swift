//
//  OpenLinkView.swift
//  iosApp
//
//  Created by Khatri, Niranjan on 07/12/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared
import OpenLink // add this import

struct OpenLinkView: View {
    var body: some View {
        Text("Home Screen").padding()
        Button("Open Link"){
            // navigate to url link
            Linker().openLink(url: "https://www.google.com")
        }.padding()
    }
}

struct OpenLinkView_Previews: PreviewProvider {
    static var previews: some View {
        OpenLinkView()
    }
}
