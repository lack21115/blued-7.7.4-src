package com.blued.android.module.yy_china.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRankModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;

public class YYRankItemPresenter extends MvpPresenter {
  private int h;
  
  private int i = 1;
  
  private boolean j = false;
  
  private void c(IFetchDataListener paramIFetchDataListener) {
    YYRoomHttpUtils.f((YYRoomInfoManager.d().b()).room_id, this.i, e(paramIFetchDataListener), g());
  }
  
  private void d(IFetchDataListener paramIFetchDataListener) {
    YYRoomHttpUtils.g((YYRoomInfoManager.d().b()).room_id, this.i, e(paramIFetchDataListener), g());
  }
  
  private BluedUIHttpResponse e(IFetchDataListener paramIFetchDataListener) {
    return new BluedUIHttpResponse<BluedEntityA<YYRankModel>>(this, g(), paramIFetchDataListener) {
        protected void a(BluedEntityA<YYRankModel> param1BluedEntityA) {
          if (param1BluedEntityA == null || !param1BluedEntityA.hasData()) {
            if (YYRankItemPresenter.a(this.b) == 1)
              this.b.b("show_nodata_layout"); 
            return;
          } 
          if (YYRankItemPresenter.a(this.b) == 1) {
            if (param1BluedEntityA.data.size() >= 1)
              this.b.a("show_no1_layout", param1BluedEntityA.data.get(0)); 
            if (param1BluedEntityA.data.size() >= 2)
              this.b.a("show_no2_layout", param1BluedEntityA.data.get(1)); 
            if (param1BluedEntityA.data.size() >= 3)
              this.b.a("show_no3_layout", param1BluedEntityA.data.get(2)); 
            if (param1BluedEntityA.data.size() > 3)
              this.a.a("show_list_layout", param1BluedEntityA.data.subList(3, param1BluedEntityA.data.size() - 1)); 
          } else {
            this.a.a("show_list_layout", param1BluedEntityA.data);
          } 
          YYRankItemPresenter.a(this.b, param1BluedEntityA.hasMore());
          if (YYRankItemPresenter.b(this.b))
            YYRankItemPresenter.c(this.b); 
        }
        
        public void onUIFinish(boolean param1Boolean) {
          super.onUIFinish(param1Boolean);
          Logger.e("YYRankItemPresenter", new Object[] { "onFinish" });
          if (!YYRankItemPresenter.b(this.b))
            this.a.b(); 
          this.a.a(param1Boolean);
        }
      };
  }
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    this.h = paramBundle1.getInt("position", 0);
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null && this.h == 1)
      EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_LIST_PAGE_SEND_SHOW, yYRoomModel.room_id, yYRoomModel.uid); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onInit position = ");
    stringBuilder.append(this.h);
    Logger.e("YYRankItemPresenter", new Object[] { stringBuilder.toString() });
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    this.i = 1;
    if (this.h == 0) {
      d(paramIFetchDataListener);
      return;
    } 
    c(paramIFetchDataListener);
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    if (this.h == 0) {
      d(paramIFetchDataListener);
      return;
    } 
    c(paramIFetchDataListener);
  }
  
  public int m() {
    return this.h;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\presenter\YYRankItemPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */