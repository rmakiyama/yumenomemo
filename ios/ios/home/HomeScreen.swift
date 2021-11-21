import SwiftUI

struct HomeScreen: View {
    
    @ObservedObject var viewModel = HomeViewModel()
    
    var body: some View {
        List(viewModel.state.yumenomemoList, id: \.id) { memo in
            Text(memo.detail)
        }
        .onAppear {
            self.viewModel.load()
        }
    }
}

struct HomeScreen_Previews: PreviewProvider {
    static var previews: some View {
        HomeScreen()
    }
}
