import ViewModel.ChatViewModel;
import ViewModel.UserListViewModel;
import ViewModel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;
import model.ModelManager;
import view.ViewHandler;

public class MyApplication extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    Model model = new ModelManager("UnnamedUser");
    ChatViewModel chatViewModel = new ChatViewModel(model);
    UserListViewModel userListViewModel = new UserListViewModel(model);
    ViewModelFactory viewModelFactory = new ViewModelFactory(model);

    ViewHandler viewHandler = new ViewHandler(viewModelFactory);
    viewHandler.start(stage);
  }
}
