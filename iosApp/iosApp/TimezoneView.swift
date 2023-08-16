//
//  TimezoneView.swift
//  iosApp
//
//  Created by Khatri, Niranjan on 14/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared


struct TimezoneView: View {
    @EnvironmentObject private var timezoneItems : TimezoneItems
    private var timezoneHelper = TimeHelperImpl()
    @State private var currentDate = Date()
    let timer = Timer.publish(every: 1000, on: .main, in: .common).autoconnect()
    @State private var showTimezoneDialog = false
    
    var body: some View {
        NavigationView {
            VStack {
                TimeCard(timezone: timezoneHelper.currentTimeZone(),
                         time: DateFormatter.short.string(from: currentDate),
                         date: DateFormatter.long.string(from: currentDate))
                Spacer()
                List {
                    ForEach(Array(timezoneItems.selectedTimezones), id: \.self){
                        timezone in NumberTimeCard(timezone: timezone,
                                       time: timezoneHelper.getTime(timeZoneId: timezone),
                                                   hours: "\(timezoneHelper.hoursFromTimeZone(otherTimeZoneId: timezone)) hours from local",
                                                   date: timezoneHelper.getDate(timeZoneId: timezone))
                    }.onDelete(perform: deleteItems)
                } // List
                .listStyle(.plain)
                Spacer()
            } // VStack
            .onReceive(timer){ input in
                currentDate = input
            }
            .navigationTitle("World Clocks")
            .toolbar{
                ToolbarItem(
                    placement: .navigationBarTrailing
                ){
                    Button(action: {
                        showTimezoneDialog = true
                    }){
                        Image(systemName: "plus")
                            .frame(alignment:.trailing)
                            .foregroundColor(.black)
                    }
                }// ToolbarItem
            }// toolbar
        }// NavigationView
        .fullScreenCover(isPresented: $showTimezoneDialog){
            // show timezone dialog
            TimezoneDialog().environmentObject(timezoneItems)
        }
    }// body
    
    func deleteItems(at offsets: IndexSet) {
           let timezoneArray = Array(timezoneItems.selectedTimezones)
           for index in offsets {
               let element = timezoneArray[index]
               timezoneItems.selectedTimezones.remove(element)
           }
       }
}

struct TimezoneView_Previews: PreviewProvider {
    static var previews: some View {
        TimezoneView().environmentObject(TimezoneItems())
    }
}
