package com.blued.android.chat.core.worker.heart;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.pack.BasePackage;
import com.blued.android.chat.core.pack.PackageHandler;
import com.blued.android.chat.core.pack.PingPackage;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.worker.BaseWorker;
import com.blued.android.chat.core.worker.Connector;
import com.blued.android.chat.core.worker.PackSendHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Heart extends BaseWorker implements PackageHandler {
  private static final int BACK_FREQ_SEC = 300;
  
  private static final int FORE_FREQ_SEC = 30;
  
  private static final String TAG = "Chat_Heart";
  
  private boolean appActived = false;
  
  private Connector connector;
  
  private short heartFreq = 0;
  
  private PackSendHelper packSendHelper;
  
  private HashSet<PingReceiveListener> pingReceiveListeners = new HashSet<PingReceiveListener>();
  
  public Heart(Connector paramConnector) {
    this.connector = paramConnector;
    this.packSendHelper = paramConnector.getPackageSendHelper();
    init();
  }
  
  private short getCurrentHeartFreq() {
    return getHeartFreq(this.appActived);
  }
  
  private short getHeartFreq(boolean paramBoolean) {
    char c;
    if (paramBoolean) {
      c = '\036';
    } else {
      c = 'Ĭ';
    } 
    return (short)c;
  }
  
  private void init() {
    this.connector.registerPackageHandler(2, this);
  }
  
  private void sendHeartPackage() {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sendHeartPackage(), heartFreq:");
      stringBuilder.append(this.heartFreq);
      Log.v("Chat_Heart", stringBuilder.toString());
    } 
    this.packSendHelper.sendPackage((BasePackage)new PingPackage(this.heartFreq), null);
  }
  
  public void appActiveChanged(boolean paramBoolean) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("appActiveChanged(), actived:");
      stringBuilder.append(paramBoolean);
      stringBuilder.append(", old actived:");
      stringBuilder.append(this.appActived);
      Log.v("Chat_Heart", stringBuilder.toString());
    } 
    this.heartFreq = getHeartFreq(paramBoolean);
    if (this.appActived != paramBoolean && isWorking())
      sendHeartPackage(); 
    this.appActived = paramBoolean;
    if (paramBoolean)
      PingCheckerManager.getInstance().checkImLink(null); 
  }
  
  public String getWorkerName() {
    return "Heart";
  }
  
  public void onReceive(BasePackage paramBasePackage) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onReceive(), pack:");
      stringBuilder.append(paramBasePackage);
      Log.v("Chat_Heart", stringBuilder.toString());
    } 
    if (paramBasePackage.type != 2) {
      if (ChatManager.debug) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("receive unknown package, pack:");
        stringBuilder.append(paramBasePackage);
        Log.e("Chat_Heart", stringBuilder.toString());
        return;
      } 
    } else {
      HashSet<PingReceiveListener> hashSet;
      Iterator<PingReceiveListener> iterator;
      ArrayList<PingReceiveListener> arrayList = new ArrayList();
      synchronized (this.pingReceiveListeners) {
        arrayList.addAll(this.pingReceiveListeners);
        iterator = arrayList.iterator();
        while (iterator.hasNext())
          ((PingReceiveListener)iterator.next()).onReceivePing(); 
        if (!paramBasePackage.ack) {
          if (paramBasePackage instanceof PingPackage) {
            int i = ((PingPackage)paramBasePackage).freqMs;
            short s = this.heartFreq;
            if (i == s) {
              if (ChatManager.debug)
                Log.v("Chat_Heart", "ping pack, equal heart freq"); 
              this.heartFreq = 0;
            } else if (s == 0) {
              this.heartFreq = getCurrentHeartFreq();
            } 
          } 
          if (isWorking()) {
            sendHeartPackage();
            return;
          } 
          if (ChatManager.debug)
            Log.e("Chat_Heart", "stopped, drop the ping pack"); 
        } 
        return;
      } 
    } 
  }
  
  public void onSendFailed(BasePackage paramBasePackage, String paramString) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("BasePackage(), pack:");
      stringBuilder.append(paramBasePackage);
      stringBuilder.append(", failedMessage: ");
      stringBuilder.append(paramString);
      Log.v("Chat_Heart", stringBuilder.toString());
    } 
  }
  
  public void onSendSuccess(BasePackage paramBasePackage) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onSendSuccess(), pack:");
      stringBuilder.append(paramBasePackage);
      Log.v("Chat_Heart", stringBuilder.toString());
    } 
  }
  
  public void onStart() {
    this.heartFreq = getCurrentHeartFreq();
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onStart(), heartFreq:");
      stringBuilder.append(this.heartFreq);
      Log.v("Chat_Heart", stringBuilder.toString());
    } 
  }
  
  public void onStop() {
    if (ChatManager.debug)
      Log.v("Chat_Heart", "onStop()"); 
  }
  
  protected void pingTest() {
    if (ChatManager.debug)
      Log.v("Chat_Heart", "pingTest()"); 
    this.packSendHelper.sendPackage((BasePackage)new PingPackage(), null);
  }
  
  public void registerPingReceiveListener(PingReceiveListener paramPingReceiveListener) {
    synchronized (this.pingReceiveListeners) {
      this.pingReceiveListeners.add(paramPingReceiveListener);
      return;
    } 
  }
  
  public void unregisterPingReceiveListener(PingReceiveListener paramPingReceiveListener) {
    synchronized (this.pingReceiveListeners) {
      this.pingReceiveListeners.remove(paramPingReceiveListener);
      return;
    } 
  }
  
  public static interface PingReceiveListener {
    void onReceivePing();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\worker\heart\Heart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */