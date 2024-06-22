//
//  ContentView.swift
//  BaseProjectIOS
//
//  Created by Faris Ghilmany on 22/06/24.
//

import SwiftUI
import shared

struct ContentView: View {
    var body: some View {
        Text(Greeting().greet())
        .padding()
    }
}

#Preview {
    ContentView()
}
