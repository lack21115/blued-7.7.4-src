package com.soft.blued.ui.discover.observer;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class DiscoverSquareViewModel extends AndroidViewModel {
  public MutableLiveData<Integer> a = new MutableLiveData();
  
  public MutableLiveData<Void> b = new MutableLiveData();
  
  public DiscoverSquareViewModel(Application paramApplication) {
    super(paramApplication);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\observer\DiscoverSquareViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */