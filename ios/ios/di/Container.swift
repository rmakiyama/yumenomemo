import shared

final class Container {
    
    public static let shared = Container()
    
    private let sharedModule = SharedModule(platform: Platform())
    
    private init() {}
    
    func getYumenomemoListUseCase() -> GetYumenomemoListUseCase {
        return sharedModule.getYumenomemoList
    }
}
