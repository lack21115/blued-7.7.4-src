package com.blued.android.module.live_china.presenter;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live.base.utils.LiveUserRelationshipUtils;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.live_interface.IFollowView;

public class LiveFollowPresenter {
  private IFollowView a;
  
  private long b;
  
  private IRequestHost c;
  
  public LiveFollowPresenter(IFollowView paramIFollowView, IRequestHost paramIRequestHost, long paramLong) {
    this.a = paramIFollowView;
    this.c = paramIRequestHost;
    this.b = paramLong;
  }
  
  public void a(String paramString) {
    LiveRoomInfo liveRoomInfo = LiveRoomInfo.a();
    LiveUserRelationshipUtils.IAddOrRemoveAttentionDone iAddOrRemoveAttentionDone = new LiveUserRelationshipUtils.IAddOrRemoveAttentionDone(this, paramString) {
        public void R_() {}
        
        public void a(String param1String) {
          LiveFollowPresenter.a(this.b).a(this.a, param1String);
        }
        
        public void b(String param1String) {}
        
        public void d() {}
        
        public void e() {}
      };
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("liveanchor_");
    stringBuilder.append(this.b);
    liveRoomInfo.a(null, iAddOrRemoveAttentionDone, paramString, stringBuilder.toString(), this.c);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\presenter\LiveFollowPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */