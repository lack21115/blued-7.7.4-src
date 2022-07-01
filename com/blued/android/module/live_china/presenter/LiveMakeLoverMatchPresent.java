package com.blued.android.module.live_china.presenter;

import android.app.Activity;
import android.content.Context;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveMakeLoverReleationModel;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;

public class LiveMakeLoverMatchPresent extends MvpPresenter {
  public BluedUIHttpResponse h = new BluedUIHttpResponse<BluedEntityA<LiveRoomUserModel>>(this, g()) {
      protected void a(BluedEntityA<LiveRoomUserModel> param1BluedEntityA) {
        if (param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
          LiveRoomUserModel liveRoomUserModel = param1BluedEntityA.data.get(0);
          if (liveRoomUserModel != null) {
            LiveMakeLoverReleationModel liveMakeLoverReleationModel = new LiveMakeLoverReleationModel();
            liveMakeLoverReleationModel.relation = liveRoomUserModel.relationship;
            this.a.a("MAKE_LOVER_RELATION", liveMakeLoverReleationModel);
          } 
        } 
      }
    };
  
  public void a(IFetchDataListener paramIFetchDataListener) {}
  
  public void a(String paramString, long paramLong, short paramShort) {
    LiveRoomHttpUtils.a((Context)h(), this.h, paramString, "", Long.valueOf(paramLong), Short.valueOf(paramShort), g());
  }
  
  public void a(String paramString1, String paramString2) {
    LiveRoomInfo liveRoomInfo = LiveRoomInfo.a();
    Activity activity = h();
    LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone = new LiveUserRelationshipUtils.IAddOrRemoveAttentionDone(this) {
        public void R_() {
          this.a.e_("MAKE_LOVER_RELATION_ADD");
        }
        
        public void a(String param1String) {
          this.a.b("MAKE_LOVER_RELATION_ADD", true);
        }
        
        public void b(String param1String) {
          this.a.b("MAKE_LOVER_RELATION_ADD", true);
        }
        
        public void d() {
          this.a.b("MAKE_LOVER_RELATION_ADD", true);
        }
        
        public void e() {
          this.a.b("MAKE_LOVER_RELATION_ADD", false);
        }
      };
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("liveanchor_");
    stringBuilder.append(paramString1);
    liveRoomInfo.a((Context)activity, iAddOrRemoveAttentionDone, paramString2, stringBuilder.toString(), g());
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
  
  public boolean c() {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\presenter\LiveMakeLoverMatchPresent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */