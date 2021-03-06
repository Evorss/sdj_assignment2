package ViewModel;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Model;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class UserListViewModel implements PropertyChangeListener
{
  private Model model;
  private ObservableList<String> items;
  public UserListViewModel(Model model)
  {
    this.model = model;
    this.model.addListener(this);
    this.items = FXCollections.observableArrayList();
  }

  public ObservableList<String> getItems()
  {
    return items;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    Platform.runLater(() ->
            {
              if(evt.getPropertyName().equals("List"))
              {
                System.out.println("Property change for user list fired");
                ArrayList<String> list = (ArrayList<String>) evt.getNewValue();
                items.clear();
                for(int i=0;i<list.size();i++)
                  items.add((list.get(i)));
              }
            }
    );
  }
}