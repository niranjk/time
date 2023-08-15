//
//  TimezoneItems.swift
//  iosApp
//
//  Created by Khatri, Niranjan on 14/08/23.
//  Copyright © 2023 orgName. All rights reserved.
//
import SwiftUI
import shared

class TimezoneItems : ObservableObject{
    @Published var timezones: [String] = []
    @Published var selectedTimezones = Set<String>()
    
    init(){
        self.timezones = TimeZoneHelperImpl().getTimeZoneStrings()
    }
}
