package com.blued.android.module.chat;

import com.blued.android.chat.listener.SessionListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public abstract class StableSessionListListener implements SessionListener {
  private static final long MIN_CALLBACK_SPAN_MS = 500L;
  
  private AtomicLong currentTime = new AtomicLong(-1L);
  
  private AtomicLong lastDataChangedTime = new AtomicLong(-1L);
  
  private AtomicLong lastNotifyTime = new AtomicLong(-1L);
  
  private AtomicLong nextMinNotifyTime = new AtomicLong(-1L);
  
  private UICallbackTask uiCallback = new UICallbackTask();
  
  public final void onSessionDataChanged(List<SessionModel> paramList, long paramLong) {
    if (this.lastDataChangedTime.get() == paramLong)
      return; 
    this.lastDataChangedTime.set(paramLong);
    AppInfo.n().removeCallbacks(this.uiCallback);
    ArrayList<SessionModel> arrayList = new ArrayList();
    if (paramList != null)
      arrayList.addAll(paramList); 
    this.uiCallback.setData(arrayList);
    this.currentTime.set(System.currentTimeMillis());
    if (this.currentTime.get() < this.nextMinNotifyTime.get()) {
      AppInfo.n().postDelayed(this.uiCallback, this.nextMinNotifyTime.get() - this.currentTime.get());
      this.lastNotifyTime.set(this.nextMinNotifyTime.get());
      return;
    } 
    if (this.currentTime.get() >= this.lastNotifyTime.get() + 500L) {
      AppInfo.n().post(this.uiCallback);
      this.nextMinNotifyTime.set(this.currentTime.get() + 500L);
      this.lastNotifyTime.set(this.currentTime.get());
      return;
    } 
    AtomicLong atomicLong = this.nextMinNotifyTime;
    atomicLong.set(atomicLong.get() + 500L);
    AppInfo.n().postDelayed(this.uiCallback, this.nextMinNotifyTime.get() - this.currentTime.get());
    this.lastNotifyTime.set(this.nextMinNotifyTime.get());
  }
  
  public abstract void onUISessionDataChanged(List<SessionModel> paramList);
  
  public void reset() {
    this.nextMinNotifyTime.set(-1L);
    this.lastNotifyTime.set(-1L);
    this.lastDataChangedTime.set(-1L);
    this.currentTime.set(-1L);
  }
  
  class UICallbackTask implements Runnable {
    private List<SessionModel> data;
    
    private UICallbackTask() {}
    
    public void run() {
      StableSessionListListener.this.onUISessionDataChanged(this.data);
    }
    
    public void setData(List<SessionModel> param1List) {
      this.data = param1List;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\chat\StableSessionListListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */