package com.soft.blued.ui.circle.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.http.CircleHttpUtils;
import com.soft.blued.ui.circle.model.MyCircleModel;
import com.soft.blued.utils.BluedPreferences;

public class CircleJoinSettingPresenter extends MvpPresenter {
  private MyCircleModel h;
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    if (paramBundle1 != null)
      this.h = (MyCircleModel)paramBundle1.getSerializable("circle_data"); 
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {}
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
  
  public void d(String paramString) {
    CircleHttpUtils.c(new BluedUIHttpResponse(this, g(), paramString) {
          public void onUIFinish() {
            super.onUIFinish();
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            BluedPreferences.W(this.a.equals("1"));
          }
        }m(), paramString, g());
  }
  
  public String m() {
    return this.h.circle_id;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\presenter\CircleJoinSettingPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */