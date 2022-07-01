package com.soft.blued.ui.circle.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.ui.circle.model.MyCircleModel;

public class CircleSettingPresenter extends MvpPresenter {
  private MyCircleModel h;
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    if (paramBundle1 != null)
      this.h = (MyCircleModel)paramBundle1.getSerializable("circle_data"); 
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {}
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
  
  public MyCircleModel m() {
    return this.h;
  }
  
  public String n() {
    return this.h.circle_id;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\presenter\CircleSettingPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */