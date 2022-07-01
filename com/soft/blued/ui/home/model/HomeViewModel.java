package com.soft.blued.ui.home.model;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import com.soft.blued.model.SingleLiveEvent;

public class HomeViewModel extends AndroidViewModel {
  public SingleLiveEvent<Integer> a = new SingleLiveEvent();
  
  public HomeViewModel(Application paramApplication) {
    super(paramApplication);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\home\model\HomeViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */