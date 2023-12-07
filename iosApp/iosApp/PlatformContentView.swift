//
//  PlatformContentView.swift
//  iosApp
//
//  Created by Khatri, Niranjan on 03/09/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared


private struct RowItem : Hashable {
    let title: String
    let desc: String
}

/*
 private let platformItems: [RowItem] = {
 let platform = Platform()
 
 var result: [RowItem] = [
 .init(
 title: "OS Name: ", desc: platform.operatingSystemName),
 .init(
 title: "OS Version: ",
 desc: platform.operatingSystemVersion
 ),
 .init(
 title: "Cpu Type: ",
 desc: platform.cpuType
 ),
 .init(
 title: "Device Model: ",
 desc: platform.deviceModel
 ),
 ]
 
 if let screen = platform.screenInfo {
 let width = min(screen.width, screen.height)
 let height = max(screen.width, screen.height)
 result.append(
 .init(title: "Display", desc: "\(width)x\(height) @\(screen.density)" )
 )
 }
 return result
 }()
 
 struct PlatformContentView: View {
 var body: some View {
 List{
 ForEach(platformItems, id: \.self){ item in
 VStack(alignment: .leading){
 Text(item.title).font(.footnote).foregroundColor(.secondary)
 Text(item.desc).font(.body).foregroundColor(.primary)
 }.padding(.vertical, 4)
 }
 }
 }
 }
 
 struct PlatformContentView_Previews: PreviewProvider {
 static var previews: some View {
 PlatformContentView()
 }
 }
 */
