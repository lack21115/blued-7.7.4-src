package com.blued.android.chat.core.worker;

import android.os.SystemClock;
import android.util.Pair;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.pack.BasePackage;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.utils.TimeoutUtils;
import com.blued.android.chat.utils.DataUtils;
import java.util.concurrent.ConcurrentHashMap;

public class PackSendHelper extends BaseWorker implements TimeoutUtils.TimeoutListener {
  private static final String TAG = "Chat_PackSendHelper";
  
  private static PackCallback emptyPackCallback = new PackCallback() {
      public void onAckTimeout(BasePackage param1BasePackage) {}
      
      public void onReceiveAck(BasePackage param1BasePackage1, BasePackage param1BasePackage2) {}
      
      public void onSendFailed(BasePackage param1BasePackage) {}
      
      public void onSendFinish(BasePackage param1BasePackage) {}
      
      public void onSendTimeout(BasePackage param1BasePackage) {}
    };
  
  private Connector connector;
  
  private ConcurrentHashMap<Long, Pair<StatePackage, PackCallback>> sendingList = new ConcurrentHashMap<Long, Pair<StatePackage, PackCallback>>();
  
  private ConcurrentHashMap<Short, Pair<StatePackage, PackCallback>> sendingListForType = new ConcurrentHashMap<Short, Pair<StatePackage, PackCallback>>();
  
  public PackSendHelper(Connector paramConnector) {
    this.connector = paramConnector;
  }
  
  protected String getWorkerName() {
    return "PackSendHelper";
  }
  
  public boolean handlePackageSendFailed(BasePackage paramBasePackage, String paramString) {
    Pair pair;
    if (paramBasePackage.localId > 0L) {
      pair = this.sendingList.remove(Long.valueOf(paramBasePackage.localId));
    } else {
      pair = this.sendingListForType.remove(Short.valueOf(((BasePackage)pair).type));
    } 
    if (pair != null) {
      DataUtils.imMessageFailed(BasePackage.typeToString(((StatePackage)pair.first).basePackage), SystemClock.uptimeMillis() - ((StatePackage)pair.first).basePackage.sendTime, paramString);
      ((StatePackage)pair.first).changeState(2);
      PackCallback packCallback = (PackCallback)pair.second;
      if (packCallback != null)
        packCallback.onSendFailed(((StatePackage)pair.first).basePackage); 
      return true;
    } 
    return false;
  }
  
  public boolean handlePackageSendFinish(BasePackage paramBasePackage) {
    Pair pair;
    if (paramBasePackage.localId > 0L) {
      pair = this.sendingList.get(Long.valueOf(paramBasePackage.localId));
    } else {
      pair = this.sendingListForType.get(Short.valueOf(((BasePackage)pair).type));
    } 
    if (pair != null) {
      ((StatePackage)pair.first).changeState(3);
      PackCallback packCallback = (PackCallback)pair.second;
      if (packCallback != null)
        packCallback.onSendFinish(((StatePackage)pair.first).basePackage); 
      return true;
    } 
    return false;
  }
  
  public boolean handleReceiveAckPackage(BasePackage paramBasePackage) {
    Pair pair;
    if (paramBasePackage.localId > 0L) {
      pair = this.sendingList.remove(Long.valueOf(paramBasePackage.localId));
    } else {
      pair = this.sendingListForType.remove(Short.valueOf(paramBasePackage.type));
    } 
    if (pair != null) {
      if (ChatManager.debug) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append(paramBasePackage.localId);
        stringBuilder.append(") receive ack: ");
        stringBuilder.append(paramBasePackage);
        Log.v("Chat_PackSendHelper", stringBuilder.toString());
      } 
      DataUtils.imMessageSuccess(BasePackage.typeToString(((StatePackage)pair.first).basePackage), SystemClock.uptimeMillis() - ((StatePackage)pair.first).basePackage.sendTime);
      ((StatePackage)pair.first).changeState(4);
      PackCallback packCallback = (PackCallback)pair.second;
      if (packCallback != null)
        packCallback.onReceiveAck(((StatePackage)pair.first).basePackage, paramBasePackage); 
      return true;
    } 
    return false;
  }
  
  public void onPackageTimeout(long paramLong, Object paramObject) {
    Pair pair = this.sendingList.remove(Long.valueOf(paramLong));
    paramObject = pair;
    if (pair == null)
      paramObject = this.sendingListForType.remove(Long.valueOf(paramLong)); 
    if (paramObject != null) {
      int i = ((StatePackage)((Pair)paramObject).first).getState();
      ((StatePackage)((Pair)paramObject).first).changeState(2);
      String str = BasePackage.typeToString(((StatePackage)((Pair)paramObject).first).basePackage);
      paramLong = SystemClock.uptimeMillis();
      long l = ((StatePackage)((Pair)paramObject).first).basePackage.sendTime;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("package timeout, old state:");
      stringBuilder.append(((StatePackage)((Pair)paramObject).first).stateToString(i));
      stringBuilder.append(", connect state:");
      stringBuilder.append(this.connector.getConnectStatus());
      DataUtils.imMessageFailed(str, paramLong - l, stringBuilder.toString());
      PackCallback packCallback = (PackCallback)((Pair)paramObject).second;
      if (packCallback != null) {
        if (i == 1) {
          packCallback.onSendTimeout(((StatePackage)((Pair)paramObject).first).basePackage);
          return;
        } 
        if (i == 3)
          packCallback.onAckTimeout(((StatePackage)((Pair)paramObject).first).basePackage); 
      } 
    } 
  }
  
  public void onStop() {
    this.sendingList.clear();
    this.sendingListForType.clear();
  }
  
  public void sendPackage(BasePackage paramBasePackage, int paramInt, PackCallback paramPackCallback) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("(");
      stringBuilder.append(paramBasePackage.localId);
      stringBuilder.append(") sendPackage: ");
      stringBuilder.append(paramBasePackage);
      Log.v("Chat_PackSendHelper", stringBuilder.toString());
    } 
    PackCallback packCallback = paramPackCallback;
    if (ChatManager.debug) {
      packCallback = paramPackCallback;
      if (paramPackCallback == null)
        packCallback = emptyPackCallback; 
    } 
    if (paramBasePackage.localId > 0L && packCallback != null) {
      StatePackage statePackage = new StatePackage(paramBasePackage);
      statePackage.changeState(1);
      this.sendingList.put(Long.valueOf(paramBasePackage.localId), new Pair(statePackage, packCallback));
      TimeoutUtils.addTimeoutPackage(paramBasePackage.localId, paramBasePackage, paramInt, this);
    } 
    this.connector.sendPackage(paramBasePackage);
  }
  
  public void sendPackage(BasePackage paramBasePackage, PackCallback paramPackCallback) {
    sendPackage(paramBasePackage, 30000, paramPackCallback);
  }
  
  public static interface PackCallback {
    void onAckTimeout(BasePackage param1BasePackage);
    
    void onReceiveAck(BasePackage param1BasePackage1, BasePackage param1BasePackage2);
    
    void onSendFailed(BasePackage param1BasePackage);
    
    void onSendFinish(BasePackage param1BasePackage);
    
    void onSendTimeout(BasePackage param1BasePackage);
  }
  
  static class StatePackage {
    public static final int ACK_FINISHED = 4;
    
    public static final int IDLE = 0;
    
    public static final int SENDING = 1;
    
    public static final int SENDING_FAILED = 2;
    
    public static final int WAITING_ACK = 3;
    
    private long _lastStateTime;
    
    private int _state;
    
    final BasePackage basePackage;
    
    public StatePackage(BasePackage param1BasePackage) {
      this.basePackage = param1BasePackage;
      this._state = 0;
      this._lastStateTime = System.currentTimeMillis();
    }
    
    public void changeState(int param1Int) {
      long l = System.currentTimeMillis();
      if (ChatManager.debug) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append(this.basePackage.localId);
        stringBuilder.append(") change state: ");
        stringBuilder.append(stateToString(this._state));
        stringBuilder.append(" -> ");
        stringBuilder.append(stateToString(param1Int));
        stringBuilder.append(", take time: ");
        stringBuilder.append(l - this._lastStateTime);
        Log.v("Chat_PackSendHelper", stringBuilder.toString());
      } 
      this._state = param1Int;
      this._lastStateTime = l;
    }
    
    public int getState() {
      return this._state;
    }
    
    protected String stateToString(int param1Int) {
      if (param1Int != 0) {
        if (param1Int != 1) {
          if (param1Int != 2) {
            if (param1Int != 3) {
              if (param1Int != 4) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("UNKNOWN(");
                stringBuilder.append(param1Int);
                stringBuilder.append(")");
                return stringBuilder.toString();
              } 
              return "ACK_FINISHED";
            } 
            return "WAITING_ACK";
          } 
          return "SENDING_FAILED";
        } 
        return "SENDING";
      } 
      return "IDLE";
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\worker\PackSendHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */