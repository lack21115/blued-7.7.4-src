package com.blued.android.module.live_china.presenter;

import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.model.LiveFansMemberModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

public class LiveFansRecordMemberPresent extends MvpPresenter {
  BluedUIHttpResponse h = new BluedUIHttpResponse<BluedEntityA<LiveFansMemberModel>>(this, g()) {
      protected void a(BluedEntityA<LiveFansMemberModel> param1BluedEntityA) {
        if (param1BluedEntityA == null)
          return; 
        if (param1BluedEntityA.data != null && LiveFansRecordMemberPresent.a(this.a) != null)
          LiveFansRecordMemberPresent.a(this.a).a("MEMBER_DATA", param1BluedEntityA.data); 
        if (!param1BluedEntityA.hasMore() && LiveFansRecordMemberPresent.a(this.a) != null)
          LiveFansRecordMemberPresent.a(this.a).b(); 
      }
      
      public boolean onUIFailure(int param1Int, String param1String) {
        AppMethods.a(param1String);
        if (LiveFansRecordMemberPresent.b(this.a) > 1)
          LiveFansRecordMemberPresent.c(this.a); 
        return true;
      }
      
      public void onUIFinish() {
        super.onUIFinish();
        if (LiveFansRecordMemberPresent.a(this.a) != null)
          LiveFansRecordMemberPresent.a(this.a).a(true); 
      }
      
      public void onUIStart() {
        super.onUIStart();
        if (LiveFansRecordMemberPresent.a(this.a) != null)
          LiveFansRecordMemberPresent.a(this.a).a(); 
      }
    };
  
  private int i = 0;
  
  private int j = 1;
  
  private IFetchDataListener k;
  
  public void a(int paramInt) {
    this.i = paramInt;
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    this.j = 1;
    c(paramIFetchDataListener);
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    this.j++;
    c(paramIFetchDataListener);
  }
  
  public void c(IFetchDataListener paramIFetchDataListener) {
    this.k = paramIFetchDataListener;
    int i = this.i;
    if (i == 0) {
      LiveRoomHttpUtils.a(this.j, this.h, g());
      return;
    } 
    if (i == 1) {
      LiveRoomHttpUtils.b(this.j, this.h, g());
      return;
    } 
    if (i == 2)
      LiveRoomHttpUtils.c(this.j, this.h, g()); 
  }
  
  public boolean c() {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\presenter\LiveFansRecordMemberPresent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */