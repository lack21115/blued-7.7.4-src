package com.blued.android.chat.core.worker.link;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.utils.Log;
import java.util.Timer;
import java.util.TimerTask;

public class ReLinkTimer {
  private static final int MINUTE = 60000;
  
  private static final int SECOND = 1000;
  
  private static final String TAG = "Chat_ReLinkTimer";
  
  private static final int[] TimeFreqBackArrayMs;
  
  private static final int[] TimeFreqForeArrayMs = new int[] { 
      3000, 3000, 5000, 5000, 10000, 10000, 30000, 30000, 30000, 60000, 
      60000, 60000, 300000, 300000, 300000, 600000, 600000, 600000 };
  
  private int _retryCount = 0;
  
  private Timer _timer;
  
  private ReLinkListener listener;
  
  private Object lock = new Object();
  
  static {
    TimeFreqBackArrayMs = new int[] { 
        10000, 30000, 60000, 120000, 180000, 300000, 300000, 600000, 600000, 1800000, 
        3600000 };
  }
  
  public ReLinkTimer(ReLinkListener paramReLinkListener) {
    this.listener = paramReLinkListener;
  }
  
  private int getTimerDelay() {
    int[] arrayOfInt;
    if (ChatManager.getInstance().isAppActived()) {
      arrayOfInt = TimeFreqForeArrayMs;
    } else {
      arrayOfInt = TimeFreqBackArrayMs;
    } 
    int i = this._retryCount;
    return (i < arrayOfInt.length) ? arrayOfInt[i] : arrayOfInt[arrayOfInt.length - 1];
  }
  
  private void startTimer() {
    stopTimer();
    this._timer = new Timer();
    int i = getTimerDelay();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("start ReLinkTimer, delay:");
    stringBuilder.append(i);
    Log.v("Chat_ReLinkTimer", stringBuilder.toString());
    this._timer.schedule(new ReLinkTimerTask(), i);
  }
  
  private void stopTimer() {
    Timer timer = this._timer;
    if (timer != null) {
      timer.cancel();
      this._timer = null;
    } 
  }
  
  public void start() {
    Log.v("Chat_ReLinkTimer", "start ReLinkTimer");
    synchronized (this.lock) {
      startTimer();
      return;
    } 
  }
  
  public void stop() {
    Log.v("Chat_ReLinkTimer", "stop ReLinkTimer");
    synchronized (this.lock) {
      stopTimer();
      this._retryCount = 0;
      return;
    } 
  }
  
  public static interface ReLinkListener {
    boolean onReLink(int param1Int1, int param1Int2);
  }
  
  class ReLinkTimerTask extends TimerTask {
    private ReLinkTimerTask() {}
    
    public void run() {
      synchronized (ReLinkTimer.this.lock) {
        if (ReLinkTimer.this._timer == null)
          return; 
        ReLinkTimer.access$308(ReLinkTimer.this);
        Log.v("Chat_ReLinkTimer", "ReLinkTimer notify relink");
        if (ReLinkTimer.this.listener.onReLink(ReLinkTimer.this._retryCount, ReLinkTimer.this.getTimerDelay()))
          ReLinkTimer.this.start(); 
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\worker\link\ReLinkTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */