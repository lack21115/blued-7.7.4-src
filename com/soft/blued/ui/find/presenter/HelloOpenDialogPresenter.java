package com.soft.blued.ui.find.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.ui.find.manager.CallHelloManager;

public class HelloOpenDialogPresenter extends MvpPresenter {
  private boolean h = false;
  
  private int i;
  
  private int j;
  
  private boolean k = false;
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    if (paramBundle1 != null) {
      this.h = paramBundle1.getBoolean("hello_open_is_buy");
      this.i = paramBundle1.getInt("hello_open_count");
      this.j = paramBundle1.getInt("hello_open_from");
    } 
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {}
  
  public void a(boolean paramBoolean) {
    this.k = paramBoolean;
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
  
  public boolean m() {
    return this.h;
  }
  
  public int n() {
    int i = this.i;
    return (i > 0) ? i : (CallHelloManager.a().b()).pay_count;
  }
  
  public int o() {
    return this.j;
  }
  
  public boolean p() {
    return this.k;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\presenter\HelloOpenDialogPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */