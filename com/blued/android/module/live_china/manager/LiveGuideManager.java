package com.blued.android.module.live_china.manager;

import android.os.Handler;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.module.live_china.observer.LiveRelationshipObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.log.InstantLog;

public class LiveGuideManager implements LiveRelationshipObserver.ILiveRelationshipObserver {
  private boolean a = true;
  
  private boolean b = true;
  
  private Handler c = new Handler();
  
  private PlayingOnliveFragment d;
  
  private ChatCardTask e = new ChatCardTask(this);
  
  private AttentionCardTask f = new AttentionCardTask(this);
  
  private boolean g = true;
  
  private boolean h;
  
  public LiveGuideManager(PlayingOnliveFragment paramPlayingOnliveFragment) {
    this.d = paramPlayingOnliveFragment;
    Logger.a("rrb", new Object[] { "--------开始倒计时-------" });
    this.c.postDelayed(this.e, 60000L);
    this.c.postDelayed(this.e, 300000L);
    this.c.postDelayed(this.e, 900000L);
    this.c.postDelayed(this.f, 240000L);
    LiveRelationshipObserver.a().a(this);
  }
  
  public void a() {
    this.a = false;
    AppInfo.n().removeCallbacks(this.e);
  }
  
  public void b() {
    this.c.removeCallbacksAndMessages(null);
    LiveRelationshipObserver.a().b(this);
  }
  
  public void b(String paramString1, String paramString2) {
    if (CommonStringUtils.c(paramString2) == LiveRoomManager.a().d()) {
      if ("1".equals(paramString1) || "3".equals(paramString1)) {
        this.h = true;
        return;
      } 
      this.h = false;
      return;
    } 
  }
  
  class AttentionCardTask implements Runnable {
    AttentionCardTask(LiveGuideManager this$0) {}
    
    public void run() {
      if (!LiveGuideManager.c(this.a)) {
        LiveMsgSendManager.a().h();
        InstantLog.a("live_follow_guide_show");
      } 
    }
  }
  
  class ChatCardTask implements Runnable {
    ChatCardTask(LiveGuideManager this$0) {}
    
    public void run() {
      if (LiveGuideManager.a(this.a)) {
        LiveMsgSendManager.a().i();
        InstantLog.a("live_chat_guide_show");
        if (LiveGuideManager.b(this.a)) {
          LiveGuideManager.a(this.a, false);
          LiveSetDataObserver.a().j();
        } 
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\manager\LiveGuideManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */