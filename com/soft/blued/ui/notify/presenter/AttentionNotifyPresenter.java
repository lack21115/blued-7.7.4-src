package com.soft.blued.ui.notify.presenter;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.ui.notify.model.FeedNotice;

public class AttentionNotifyPresenter extends MvpPresenter {
  public int h = 1;
  
  private int i = 20;
  
  private boolean j;
  
  private boolean k = true;
  
  public String a(int paramInt) {
    return h().getResources().getString(paramInt);
  }
  
  public void a(long paramLong) {
    FindHttpUtils.a(new BluedUIHttpResponse(this, g()) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            this.a.a("ATTENTION_NOTICE_CLEAR", false);
          }
        }g(), "followers", String.valueOf(paramLong));
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    this.h = 1;
    c(paramIFetchDataListener);
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    c(paramIFetchDataListener);
  }
  
  public void c(IFetchDataListener paramIFetchDataListener) {
    FindHttpUtils.a(new BluedUIHttpResponse<BluedEntity<FeedNotice, BluedEntityBaseExtra>>(this, g(), paramIFetchDataListener) {
          public boolean onUIFailure(int param1Int, String param1String) {
            AttentionNotifyPresenter.a(this.b, false);
            AttentionNotifyPresenter.b(this.b, false);
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            if (!AttentionNotifyPresenter.a(this.b))
              this.a.b(); 
            this.a.a(param1Boolean);
            if (!AttentionNotifyPresenter.b(this.b))
              this.b.a("SHOW_LOAD_ERROR", false); 
          }
          
          public void onUIStart() {
            super.onUIStart();
          }
          
          public void onUIUpdate(BluedEntity<FeedNotice, BluedEntityBaseExtra> param1BluedEntity) {
            if (param1BluedEntity == null || param1BluedEntity.data == null || param1BluedEntity.data.isEmpty()) {
              AttentionNotifyPresenter.a(this.b, false);
              return;
            } 
            AttentionNotifyPresenter.a(this.b, param1BluedEntity.hasMore());
            this.a.a("ATTENTION_NOTICE_LIST", param1BluedEntity.data);
            if (AttentionNotifyPresenter.a(this.b)) {
              AttentionNotifyPresenter attentionNotifyPresenter = this.b;
              attentionNotifyPresenter.h++;
            } 
          }
        }"followers", this.h, this.i, g());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\notify\presenter\AttentionNotifyPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */