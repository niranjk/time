//
//  NumberTimeCard.swift
//  iosApp
//
//  Created by Khatri, Niranjan on 14/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct NumberTimeCard: View {
  var timezone: String
  var time: String
  var hours: String
  var date: String
  var body: some View {
    HStack {
      VStack(alignment: .leading) {
        Text(timezone)
          .font(.system(size: 16.0))
          .bold()
          .foregroundColor(Color.blue)
        Spacer().frame(height:32.0)
        Text(hours)
          .lineLimit(1)
          .font(.system(size: 14.0))
          .foregroundColor(Color.blue)
      }
      .padding(.leading, 8).padding(.bottom, 16)
      Spacer()
      VStack(alignment: .trailing) {
        Text(time)
          .font(.system(size: 16.0))
          .bold()
          .foregroundColor(Color.blue)
        Spacer().frame(height:32.0)
        Text(date)
          .lineLimit(1)
          .font(.system(size: 10.0))
          .foregroundColor(Color.blue)
      }
      .padding(.trailing, 8).padding(.bottom, 16)
    }
    .frame(maxWidth: .infinity, minHeight: 90, alignment: Alignment(horizontal: .leading, vertical: .bottom))
    .cornerRadius(10)
    .overlay(
      RoundedRectangle(cornerRadius: 8)
        .stroke(Color(.sRGB, red: 150/255, green: 150/255, blue: 150/255, opacity: 1.0), lineWidth: 1)
    )
    .padding(.leading, 16).padding(.bottom, 16).padding(.trailing, 16)
//    .padding([.vertical, .horizontal])
  }
}

struct NumberTimeCard_Previews: PreviewProvider {
    static var previews: some View {
        NumberTimeCard(
            timezone: "Europe/London", time: "2:20am", hours: "12:00 hrs from local",
            date: "Sunday, Nov 15"
        )
    }
}
