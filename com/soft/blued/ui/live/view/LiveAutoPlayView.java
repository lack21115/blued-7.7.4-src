package com.soft.blued.ui.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.soft.blued.ui.live.manager.LiveAutoPlayManager;
import com.soft.blued.ui.live.manager.LiveListAutoPlay;
import com.soft.blued.ui.live.model.BluedLiveListData;
import com.soft.blued.utils.NetworkUtils;

public class LiveAutoPlayView extends FrameLayout {
  boolean a = true;
  
  Runnable b = new Runnable(this) {
      public void run() {
        Log.i("LiveAutoPlayView", "resumeRunnable");
        LiveAutoPlayView.a(this.a);
      }
    };
  
  Runnable c = new Runnable(this) {
      public void run() {
        if (this.a.getChildCount() > 0)
          this.a.removeAllViews(); 
      }
    };
  
  private long d = -1L;
  
  private int e = -1;
  
  private BluedLiveListData f = new BluedLiveListData();
  
  private String g;
  
  private boolean h = false;
  
  private int i;
  
  private int j;
  
  private boolean k = true;
  
  private boolean l = false;
  
  private LiveListAutoPlay m;
  
  public LiveAutoPlayView(Context paramContext) {
    super(paramContext);
  }
  
  public LiveAutoPlayView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  private void e() {
    if (this.l)
      return; 
    if (LiveFloatManager.a().F()) {
      Log.i("LiveAutoPlayView", "prepare play but float window showing");
      return;
    } 
    removeCallbacks(this.c);
    if (this.h) {
      Log.i("LiveAutoPlayView", "prepare play");
      if (this.e == 0) {
        if (this.d == LiveAutoPlayManager.a().f() && LiveAutoPlayManager.a().k() && getChildCount() != 0) {
          Log.i("LiveAutoPlayView", "return for playing");
          return;
        } 
        f();
        return;
      } 
    } else {
      Log.i("LiveAutoPlayView", "prepare pause");
      if (getChildCount() > 0)
        removeAllViews(); 
      LiveAutoPlayManager.a().e();
    } 
  }
  
  private void f() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("autoPlay:");
    stringBuilder.append(this.f.title);
    stringBuilder.append(this.f.description);
    Log.i("LiveAutoPlayView", stringBuilder.toString());
    if (NetworkUtils.a())
      return; 
    if (this.f.anchor != null) {
      LiveRoomData liveRoomData = new LiveRoomData(CommonTools.a(this.f.lid), this.f.screen_pattern, this.g, this.f.uid, this.f.anchor.name, this.f.anchor.avatar, this.f.anchor.vbadge);
      liveRoomData.live_url = this.f.live_play;
      LiveAutoPlayManager.a().a(liveRoomData, this.g, this, this.i, this.j);
      this.k = false;
    } 
  }
  
  public void a() {
    removeCallbacks(this.b);
    AppInfo.n().postDelayed(this.b, 500L);
  }
  
  public void a(LiveListAutoPlay paramLiveListAutoPlay, BluedLiveListData paramBluedLiveListData, String paramString, int paramInt1, int paramInt2) {
    if (paramBluedLiveListData == null)
      return; 
    this.m = paramLiveListAutoPlay;
    this.f = paramBluedLiveListData;
    this.g = paramString;
    this.i = paramInt1;
    this.j = paramInt2;
    this.d = Long.parseLong(paramBluedLiveListData.lid);
    this.e = paramBluedLiveListData.positionReal;
    if (this.e == 0) {
      String str;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setSessionData name:");
      stringBuilder.append(paramBluedLiveListData.title);
      stringBuilder.append(paramBluedLiveListData.description);
      if (paramBluedLiveListData.auth != null) {
        str = paramBluedLiveListData.anchor.name;
      } else {
        str = "";
      } 
      stringBuilder.append(str);
      stringBuilder.append("  position:");
      stringBuilder.append(this.e);
      Log.i("LiveAutoPlayView", stringBuilder.toString());
    } 
  }
  
  public void a(boolean paramBoolean) {
    this.l = paramBoolean;
    if (this.l)
      removeCallbacks(this.b); 
  }
  
  public void b() {
    removeCallbacks(this.b);
    removeCallbacks(this.c);
    AppInfo.n().postDelayed(this.c, 300L);
    LiveAutoPlayManager.a().e();
  }
  
  public void c() {
    if (getChildCount() > 0)
      removeAllViews(); 
  }
  
  public boolean d() {
    int[] arrayOfInt = new int[2];
    getLocationOnScreen(arrayOfInt);
    boolean bool2 = false;
    int i = arrayOfInt[0];
    i = arrayOfInt[1];
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("y:");
    stringBuilder.append(i);
    Log.i("LiveAutoPlayView", stringBuilder.toString());
    boolean bool1 = bool2;
    if (this.h) {
      bool1 = bool2;
      if (this.e == 0)
        bool1 = true; 
    } 
    return bool1;
  }
  
  public long getSessionId() {
    return this.d;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    if (this.e == 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("AttachedToWindow： ");
      stringBuilder.append(this.f.title);
      stringBuilder.append(this.f.description);
      Log.i("LiveAutoPlayView", stringBuilder.toString());
    } 
    this.h = true;
    if (this.e == 0 && this.k) {
      Log.i("LiveAutoPlayView", "firstLoadData");
      LiveListAutoPlay liveListAutoPlay = this.m;
      if (liveListAutoPlay != null)
        liveListAutoPlay.B(); 
    } 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.h = false;
    if (this.e == 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onDetachedFromWindow： ");
      stringBuilder.append(this.f.title);
      stringBuilder.append(this.f.description);
      Log.i("LiveAutoPlayView", stringBuilder.toString());
    } 
    removeCallbacks(this.c);
    AppInfo.n().postDelayed(this.c, 300L);
    removeCallbacks(this.b);
    this.m = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\view\LiveAutoPlayView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */