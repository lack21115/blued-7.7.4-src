package com.soft.blued.ui.circle.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.http.CircleHttpUtils;
import com.soft.blued.ui.circle.model.CircleConstants;
import com.soft.blued.ui.circle.model.MyCircleExtra;
import com.soft.blued.ui.circle.model.MyCircleModel;

public class CircleListPresenter extends MvpPresenter {
  private int h = 1;
  
  private CircleConstants.CIRCLE_FROM_PAGE i = CircleConstants.CIRCLE_FROM_PAGE.JOINED_CIRCLE;
  
  private void c(IFetchDataListener paramIFetchDataListener) {
    int i = null.a[this.i.ordinal()];
    if (i != 1) {
      if (i != 2 && i != 3) {
        if (i != 4)
          return; 
        CircleHttpUtils.b(d(paramIFetchDataListener), this.h);
        return;
      } 
      CircleHttpUtils.c(d(paramIFetchDataListener), this.h);
      return;
    } 
    CircleHttpUtils.a(d(paramIFetchDataListener), this.h);
  }
  
  private BluedUIHttpResponse d(IFetchDataListener paramIFetchDataListener) {
    return new BluedUIHttpResponse<BluedEntity<MyCircleModel, MyCircleExtra>>(this, g(), paramIFetchDataListener) {
        public void onUIFinish(boolean param1Boolean) {
          super.onUIFinish(param1Boolean);
          if (!param1Boolean)
            CircleListPresenter.a(this.b); 
          this.a.a(param1Boolean);
        }
        
        public void onUIStart() {
          super.onUIStart();
          this.a.a();
        }
        
        public void onUIUpdate(BluedEntity<MyCircleModel, MyCircleExtra> param1BluedEntity) {
          if (param1BluedEntity != null) {
            this.a.a("CIRCLE_DATA_LIST", param1BluedEntity.data);
            if (!param1BluedEntity.hasMore())
              this.a.b(); 
            if (param1BluedEntity.extra != null)
              this.b.a("CIRCLE_ADMIN_COUNT", param1BluedEntity.extra); 
          } 
        }
        
        public BluedEntity<MyCircleModel, MyCircleExtra> parseData(String param1String) {
          return super.parseData(param1String);
        }
      };
  }
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    if (paramBundle1 != null)
      this.i = (CircleConstants.CIRCLE_FROM_PAGE)paramBundle1.getSerializable("circle_list_page"); 
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    this.h = 1;
    c(paramIFetchDataListener);
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    this.h++;
    c(paramIFetchDataListener);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\presenter\CircleListPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */