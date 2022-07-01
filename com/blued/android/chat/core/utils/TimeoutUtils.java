package com.blued.android.chat.core.utils;

import androidx.collection.LongSparseArray;
import com.blued.android.chat.ChatManager;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

public class TimeoutUtils {
  private static final String TAG = "Chat_TimeoutUtils";
  
  private final Object lock = new Object();
  
  private Timer timer;
  
  private LongSparseArray<TimeoutObject> timerObjectMap;
  
  private Stack<TimeoutObject> timerObjectStack;
  
  private void addTimeoutObject(TimeoutObject paramTimeoutObject) {
    synchronized (this.lock) {
      if (this.timerObjectMap == null)
        this.timerObjectMap = new LongSparseArray(); 
      if (this.timerObjectStack == null)
        this.timerObjectStack = new Stack<TimeoutObject>(); 
      if (this.timerObjectMap.get(paramTimeoutObject.keyId) != null && ChatManager.debug) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("the time objet keyid is exist, timeObject:");
        stringBuilder.append(paramTimeoutObject);
        Log.e("Chat_TimeoutUtils", stringBuilder.toString());
      } 
      this.timerObjectMap.put(paramTimeoutObject.keyId, paramTimeoutObject);
      if (insertTimeoutObject(paramTimeoutObject) == 0)
        startTimerForObject(paramTimeoutObject); 
      return;
    } 
  }
  
  public static void addTimeoutPackage(long paramLong1, Object paramObject, long paramLong2, TimeoutListener paramTimeoutListener) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("addTimeoutPackage(), keyId:");
      stringBuilder.append(paramLong1);
      stringBuilder.append(", data:");
      stringBuilder.append(paramObject);
      stringBuilder.append(", timeoutMs:");
      stringBuilder.append(paramLong2);
      Log.v("Chat_TimeoutUtils", stringBuilder.toString());
    } 
    TimeoutObject timeoutObject = new TimeoutObject();
    timeoutObject.keyId = paramLong1;
    timeoutObject.data = paramObject;
    timeoutObject.stopTimeMs = System.currentTimeMillis() + paramLong2;
    timeoutObject.listener = paramTimeoutListener;
    getInstance().addTimeoutObject(timeoutObject);
  }
  
  private Object cancelTimeoutObject(long paramLong) {
    synchronized (this.lock) {
      if (this.timerObjectMap != null) {
        TimeoutObject timeoutObject = (TimeoutObject)this.timerObjectMap.get(paramLong);
        if (timeoutObject != null) {
          this.timerObjectMap.delete(paramLong);
          this.timerObjectStack.remove(timeoutObject);
          return timeoutObject.data;
        } 
      } 
      return null;
    } 
  }
  
  public static Object cancelTimeoutPackage(long paramLong) {
    return getInstance().cancelTimeoutObject(paramLong);
  }
  
  private static TimeoutUtils getInstance() {
    return SingletonCreator.instance;
  }
  
  private int insertTimeoutObject(TimeoutObject paramTimeoutObject) {
    synchronized (this.lock) {
      int j = this.timerObjectStack.size();
      for (int i = 0;; i++) {
        if (i < j) {
          TimeoutObject timeoutObject = this.timerObjectStack.get(i);
          if (paramTimeoutObject.stopTimeMs < timeoutObject.stopTimeMs) {
            this.timerObjectStack.add(i, paramTimeoutObject);
            return i;
          } 
        } else {
          this.timerObjectStack.add(paramTimeoutObject);
          i = this.timerObjectStack.size();
          return i - 1;
        } 
      } 
    } 
  }
  
  private void startTimerForObject(TimeoutObject paramTimeoutObject) {
    Timer timer = this.timer;
    if (timer != null) {
      timer.cancel();
      this.timer.purge();
    } 
    this.timer = new Timer();
    long l2 = paramTimeoutObject.stopTimeMs - System.currentTimeMillis();
    long l1 = l2;
    if (l2 < 0L)
      l1 = 0L; 
    this.timer.schedule(new MyTimerTask(paramTimeoutObject.keyId), l1);
  }
  
  class MyTimerTask extends TimerTask {
    private long keyId;
    
    public MyTimerTask(long param1Long) {
      this.keyId = param1Long;
    }
    
    public void run() {
      synchronized (TimeoutUtils.this.lock) {
        null = (TimeoutUtils.TimeoutObject)TimeoutUtils.this.timerObjectMap.get(this.keyId);
        if (null != null) {
          TimeoutUtils.this.timerObjectMap.delete(this.keyId);
          TimeoutUtils.this.timerObjectStack.remove(null);
        } 
        if (null != null)
          null.listener.onPackageTimeout(null.keyId, null.data); 
        synchronized (TimeoutUtils.this.lock) {
          if (TimeoutUtils.this.timerObjectStack.size() > 0) {
            null = TimeoutUtils.this.timerObjectStack.get(0);
            TimeoutUtils.this.startTimerForObject(null);
          } 
          return;
        } 
      } 
    }
  }
  
  static class SingletonCreator {
    private static final TimeoutUtils instance = new TimeoutUtils();
  }
  
  public static interface TimeoutListener {
    void onPackageTimeout(long param1Long, Object param1Object);
  }
  
  static class TimeoutObject {
    public Object data;
    
    public long keyId;
    
    public TimeoutUtils.TimeoutListener listener;
    
    public long stopTimeMs;
    
    private TimeoutObject() {}
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("[keyId:");
      stringBuilder.append(this.keyId);
      stringBuilder.append(", data:");
      stringBuilder.append(this.data);
      stringBuilder.append(", stopTimeMs:");
      stringBuilder.append(this.stopTimeMs);
      stringBuilder.append("]");
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\cor\\utils\TimeoutUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */