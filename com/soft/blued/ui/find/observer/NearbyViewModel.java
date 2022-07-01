package com.soft.blued.ui.find.observer;

import android.app.Application;
import android.graphics.Rect;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class NearbyViewModel extends AndroidViewModel {
  public MutableLiveData<Rect> a = new MutableLiveData();
  
  public MutableLiveData<Void> b = new MutableLiveData();
  
  public MutableLiveData<Void> c = new MutableLiveData();
  
  public MutableLiveData<Void> d = new MutableLiveData();
  
  public NearbyViewModel(Application paramApplication) {
    super(paramApplication);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\observer\NearbyViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */