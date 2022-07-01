package com.soft.blued.ui.live.presenter;

import android.util.Log;
import com.blued.android.core.AppInfo;
import com.soft.blued.ui.live.contract.LiveListContract;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveListPresenterHolder {
  private static final String a = LiveListPresenterHolder.class.getSimpleName();
  
  private HashMap<String, LiveListContract.IPresenter> b = new HashMap<String, LiveListContract.IPresenter>(10);
  
  private Lock c = new ReentrantLock();
  
  public LiveListContract.IPresenter a(String paramString, int paramInt) {
    this.c.lock();
    HashMap<String, LiveListContract.IPresenter> hashMap = this.b;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(paramInt);
    LiveListContract.IPresenter iPresenter2 = hashMap.get(stringBuilder.toString());
    Log.d(a, "getPresenter");
    LiveListContract.IPresenter iPresenter1 = iPresenter2;
    if (iPresenter2 == null) {
      Log.d(a, "Create a new presenter");
      iPresenter1 = new LiveListPresenter(AppInfo.d(), paramString, paramInt);
      HashMap<String, LiveListContract.IPresenter> hashMap1 = this.b;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramString);
      stringBuilder1.append(paramInt);
      hashMap1.put(stringBuilder1.toString(), iPresenter1);
    } 
    this.c.unlock();
    return iPresenter1;
  }
  
  public void a() {
    this.c.lock();
    Iterator<Map.Entry> iterator = this.b.entrySet().iterator();
    while (iterator.hasNext()) {
      LiveListContract.IPresenter iPresenter = (LiveListContract.IPresenter)((Map.Entry)iterator.next()).getValue();
      if (iPresenter != null) {
        iPresenter.c();
        iPresenter.e();
      } 
      iterator.remove();
    } 
    this.c.unlock();
  }
  
  public void b(String paramString, int paramInt) {
    this.c.lock();
    HashMap<String, LiveListContract.IPresenter> hashMap = this.b;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(paramInt);
    LiveListContract.IPresenter iPresenter = hashMap.get(stringBuilder.toString());
    Log.d(a, "deletePresenter");
    if (iPresenter != null)
      iPresenter.e(); 
    this.c.unlock();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\presenter\LiveListPresenterHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */