package com.soft.blued.ui.discover.observer;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.soft.blued.ui.notify.model.ViewpointNoticeCount;

public class SystemNoticeViewModel extends AndroidViewModel {
  public int a = 0;
  
  public ViewpointNoticeCount b = new ViewpointNoticeCount();
  
  public int c = 0;
  
  public MutableLiveData<Integer> d = new MutableLiveData();
  
  public MutableLiveData<Integer> e = new MutableLiveData();
  
  public MutableLiveData<Integer> f = new MutableLiveData();
  
  public MutableLiveData<Integer> g = new MutableLiveData();
  
  public MutableLiveData<ViewpointNoticeCount> h = new MutableLiveData();
  
  public SystemNoticeViewModel(Application paramApplication) {
    super(paramApplication);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\observer\SystemNoticeViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */