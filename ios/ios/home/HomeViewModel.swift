import Foundation
import Combine
import shared

class HomeViewModel: ObservableObject {
    
    private let getYumenomemoList: GetYumenomemoListUseCase
    
    @Published var state = HomeViewState()
    
    init(
        getYumenomemoList: GetYumenomemoListUseCase = Container.shared.getYumenomemoList
    ) {
        self.getYumenomemoList = getYumenomemoList
    }
    
    func load() {
        getYumenomemoList.invoke { (list: [Yumenomemo]?, _) in
            self.state = HomeViewState(
                yumenomemoList: list ?? []
            )
        }
    }
}
