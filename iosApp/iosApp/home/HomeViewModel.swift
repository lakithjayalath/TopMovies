//
//  HomeViewModel.swift
//  iosApp
//
//  Created by Lakith Jayalath on 2023-10-23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

extension HomeScreen {
    
    // @MainActor - any changes in the HomeViewModel will happen on the main thread
    @MainActor class HomeViewModel: ObservableObject {
        
        private let getMoviesUseCase = GetMoviesUseCase.init()
        
        @Published private(set) var movies: [Movie] = []
        @Published private(set) var isLoading: Bool = false
        
        private var currentPage = 1
        private(set) var loadFinished: Bool = false
        
        func loadMovies() async {
            // use async - await as it's not possible to access a couroutine scope
            if isLoading {
                return
            }
            
            do {
                let movies = try await getMoviesUseCase.invoke(page: Int32(currentPage)) // Int32 - convert swift int to kotlin int
                isLoading = false
                loadFinished = movies.isEmpty
                
                currentPage += 1
                
                self.movies = self.movies + movies
            } catch {
                isLoading = false
                loadFinished = true
                
                print(error.localizedDescription)
            }
        }
     }
    
}
