package com.blued.android.chat.core.worker;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.utils.Log;

public class BaseWorker {
  private static final int PAUSE = 1;
  
  private static final int STOP = 0;
  
  private static final String TAG = "Chat_Worker";
  
  private static final int WORK = 2;
  
  private int state = 0;
  
  private int changeState(int paramInt) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getWorkerName());
      stringBuilder.append(" state changed from ");
      stringBuilder.append(this.state);
      stringBuilder.append(" to ");
      stringBuilder.append(paramInt);
      Log.v("Chat_Worker", stringBuilder.toString());
    } 
    int i = this.state;
    this.state = paramInt;
    return i;
  }
  
  public int getState() {
    return this.state;
  }
  
  protected String getWorkerName() {
    return "worker";
  }
  
  public boolean isWorking() {
    return (this.state == 2);
  }
  
  protected void onPause() {}
  
  protected void onResume() {}
  
  protected void onStart() {}
  
  protected void onStop() {}
  
  public void pause() {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getWorkerName());
      stringBuilder.append(" pause()");
      Log.v("Chat_Worker", stringBuilder.toString());
    } 
    if (this.state == 2) {
      changeState(1);
      onPause();
    } 
  }
  
  public void resume() {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getWorkerName());
      stringBuilder.append(" resume()");
      Log.v("Chat_Worker", stringBuilder.toString());
    } 
    if (this.state == 1) {
      changeState(2);
      onResume();
    } 
  }
  
  public void start() {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getWorkerName());
      stringBuilder.append(" start()");
      Log.v("Chat_Worker", stringBuilder.toString());
    } 
    int i = changeState(2);
    if (i == 0) {
      onStart();
      onResume();
      return;
    } 
    if (i == 1)
      onResume(); 
  }
  
  public void stop() {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getWorkerName());
      stringBuilder.append(" stop()");
      Log.v("Chat_Worker", stringBuilder.toString());
    } 
    int i = changeState(0);
    if (i == 2) {
      onPause();
      onStop();
      return;
    } 
    if (i == 1)
      onStop(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\worker\BaseWorker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */