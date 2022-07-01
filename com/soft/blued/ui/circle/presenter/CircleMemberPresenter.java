package com.soft.blued.ui.circle.presenter;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.AppUtils;
import java.util.ArrayList;
import java.util.List;

public class CircleMemberPresenter extends MvpPresenter {
  private String h;
  
  private int i;
  
  private List<String> j;
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    if (paramBundle1 != null) {
      this.h = paramBundle1.getString("circle_id");
      this.i = paramBundle1.getInt("admin_level", 0);
    } 
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {}
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
  
  public List<String> m() {
    if (this.j == null) {
      this.j = new ArrayList<String>();
      this.j.add(AppUtils.a(2131755904));
      if (n())
        this.j.add(AppUtils.a(2131755858)); 
    } 
    return this.j;
  }
  
  public boolean n() {
    int i = this.i;
    boolean bool = true;
    if (i != 1) {
      if (i == 2)
        return true; 
      bool = false;
    } 
    return bool;
  }
  
  public String o() {
    if (TextUtils.isEmpty(this.h))
      this.h = ""; 
    return this.h;
  }
  
  public int p() {
    return this.i;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\presenter\CircleMemberPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */