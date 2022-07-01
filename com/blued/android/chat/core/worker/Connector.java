package com.blued.android.chat.core.worker;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.IMDebuger;
import com.blued.android.chat.core.pack.BasePackage;
import com.blued.android.chat.core.pack.ConnAckPackage;
import com.blued.android.chat.core.pack.ConnPackage;
import com.blued.android.chat.core.pack.DisconnectPackage;
import com.blued.android.chat.core.pack.PackageHandler;
import com.blued.android.chat.core.pack.SendMsgPackage;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.utils.TimeoutUtils;
import com.blued.android.chat.core.worker.link.LinkListener;
import com.blued.android.chat.core.worker.link.Linker;
import com.blued.android.chat.data.ConnectState;
import com.blued.android.chat.listener.ChatTipsListener;
import com.blued.android.chat.listener.ConnectListener;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.chat.utils.DataUtils;
import java.util.HashSet;
import java.util.Set;

public class Connector extends BaseWorker implements PackageHandler, TimeoutUtils.TimeoutListener, LinkListener {
  private static final int MAX_RETRY_COUNT = 2;
  
  private static final String TAG = "Chat_Connector";
  
  private PackSendHelper _packageSendHelper;
  
  private long connPackLocalId = 0L;
  
  private int connPackSendRetryCount = 0;
  
  private boolean connectForbidden = false;
  
  private Set<ConnectListener> connectListenerList = new HashSet<ConnectListener>();
  
  private ConnectState currentState = ConnectState.DISCONNECT;
  
  private Object disconnectWaiting = new Object();
  
  private Linker linker;
  
  private SparseArray<PackageHandler> packHandlerList = new SparseArray();
  
  public Connector() {
    init();
    this._packageSendHelper = new PackSendHelper(this);
  }
  
  private void changeState(ConnectState paramConnectState) {
    HashSet<ConnectListener> hashSet = new HashSet();
    synchronized (this.connectListenerList) {
      hashSet.addAll(this.connectListenerList);
      this.currentState = paramConnectState;
      for (ConnectListener connectListener : hashSet) {
        if (paramConnectState == ConnectState.DISCONNECT) {
          IMDebuger.setImStatus("disconnect");
          connectListener.onDisconnected();
          continue;
        } 
        if (paramConnectState == ConnectState.CONNECTING) {
          IMDebuger.setImStatus("connecting");
          connectListener.onConnecting();
          continue;
        } 
        if (paramConnectState == ConnectState.CONNECTED) {
          IMDebuger.setImStatus("connected");
          this.connPackSendRetryCount = 0;
          connectListener.onConnected();
        } 
      } 
      return;
    } 
  }
  
  private void connect() {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("connect(), connectForbidden:");
      stringBuilder.append(this.connectForbidden);
      stringBuilder.append(", state:");
      stringBuilder.append(getState());
      Log.v("Chat_Connector", stringBuilder.toString());
    } 
    if (!this.connectForbidden) {
      if (!isWorking())
        return; 
      this.linker.link();
    } 
  }
  
  private void disconnect() {
    if (ChatManager.debug)
      Log.v("Chat_Connector", "disconnect()"); 
    this.linker.unlink();
  }
  
  private void notifyDisconnect(int paramInt, String paramString) {
    ChatTipsListener chatTipsListener = ChatManager.getInstance().getTipsListener();
    if (chatTipsListener != null) {
      if (ChatManager.debug) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("notify tipsListener disconnect, code:");
        stringBuilder.append(paramInt);
        stringBuilder.append(", reason:");
        stringBuilder.append(paramString);
        Log.v("Chat_Connector", stringBuilder.toString());
      } 
      chatTipsListener.onDisconnect(paramInt, paramString);
    } 
  }
  
  private void notifyPackageSendFailed(BasePackage paramBasePackage, String paramString) {
    if (this._packageSendHelper.handlePackageSendFailed(paramBasePackage, paramString))
      return; 
    PackageHandler packageHandler = (PackageHandler)this.packHandlerList.get(paramBasePackage.type);
    if (packageHandler != null)
      packageHandler.onSendFailed(paramBasePackage, paramString); 
  }
  
  private void receiveConnAck(ConnAckPackage paramConnAckPackage) {
    ConnPackage connPackage = (ConnPackage)TimeoutUtils.cancelTimeoutPackage(this.connPackLocalId);
    if (connPackage != null)
      DataUtils.imMessageSuccess(BasePackage.typeToString((BasePackage)connPackage), SystemClock.uptimeMillis() - connPackage.sendTime); 
    switch (paramConnAckPackage.code) {
      default:
        disconnect();
        return;
      case 5:
        if (ChatManager.debug)
          Log.v("Chat_Connector", "conn ack failed, auth failed, forbidden connect and unlink"); 
        this.connectForbidden = true;
        disconnect();
        notifyDisconnect(1, paramConnAckPackage.reason);
        return;
      case 4:
      case 6:
        if (ChatManager.debug)
          Log.v("Chat_Connector", "conn ack failed, connect reject, forbidden connect and unlink"); 
        this.connectForbidden = true;
        disconnect();
        notifyDisconnect(3, paramConnAckPackage.reason);
        return;
      case 1:
      case 2:
      case 3:
        if (ChatManager.debug)
          Log.v("Chat_Connector", "conn ack failed, need reconnect"); 
        reconnect();
        return;
      case 0:
        break;
    } 
    if (ChatManager.debug)
      Log.v("Chat_Connector", "conn ack success, change to authed"); 
    this.linker.linkAuthed();
  }
  
  private void reconnect() {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("reconnect(), connectForbidden:");
      stringBuilder.append(this.connectForbidden);
      stringBuilder.append(", state:");
      stringBuilder.append(getState());
      Log.v("Chat_Connector", stringBuilder.toString());
    } 
    if (!this.connectForbidden) {
      if (!isWorking())
        return; 
      this.linker.relink(false);
    } 
  }
  
  private void recvDisconnectPackage(DisconnectPackage paramDisconnectPackage) {
    if (paramDisconnectPackage.code == 3) {
      this.connectForbidden = true;
      notifyDisconnect(3, paramDisconnectPackage.reason);
      disconnect();
      return;
    } 
    if (paramDisconnectPackage.code == 4) {
      this.connectForbidden = true;
      notifyDisconnect(4, paramDisconnectPackage.reason);
      disconnect();
      return;
    } 
    disconnect();
  }
  
  private boolean sendConnPack() {
    if (TextUtils.isEmpty(ChatManager.userInfo.encryToken))
      return false; 
    ConnPackage connPackage = new ConnPackage(ChatManager.userInfo.uid, ChatManager.userInfo.encryToken);
    long l = this.connPackLocalId;
    if (l != 0L)
      TimeoutUtils.cancelTimeoutPackage(l); 
    this.connPackLocalId = ChatHelper.getLocalId();
    this.linker.sendPackage((BasePackage)connPackage);
    TimeoutUtils.addTimeoutPackage(this.connPackLocalId, connPackage, 30000L, this);
    return true;
  }
  
  private void sendConnPackFailed(ConnPackage paramConnPackage, String paramString) {
    if (paramConnPackage != null)
      DataUtils.imMessageFailed(BasePackage.typeToString((BasePackage)paramConnPackage), SystemClock.uptimeMillis() - paramConnPackage.sendTime, paramString); 
    if (!isWorking() || this.connectForbidden) {
      if (ChatManager.debug)
        Log.v("Chat_Connector", "don't deal this conn pack"); 
      return;
    } 
    int i = ++this.connPackSendRetryCount;
    if (i < 2) {
      if (ChatManager.debug) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("retry send conn pack, connPackSendRetryCount:");
        stringBuilder.append(this.connPackSendRetryCount);
        Log.v("Chat_Connector", stringBuilder.toString());
      } 
      sendConnPack();
      return;
    } 
    if (i == 2) {
      switchToBackupLink();
      return;
    } 
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("retry limited, disconnect, connPackSendRetryCount:");
      stringBuilder.append(this.connPackSendRetryCount);
      Log.v("Chat_Connector", stringBuilder.toString());
    } 
    disconnect();
    ChatTipsListener chatTipsListener = ChatManager.getInstance().getTipsListener();
    if (chatTipsListener != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("connect package failed, excep:");
      stringBuilder.append(paramString);
      chatTipsListener.onConnectException(stringBuilder.toString());
    } 
  }
  
  private void sendDisconnectPack() {
    DisconnectPackage disconnectPackage = new DisconnectPackage();
    this.linker.sendPackage((BasePackage)disconnectPackage, false);
    try {
      if (ChatManager.debug)
        Log.v("Chat_Connector", "waiting disconnect package"); 
      synchronized (this.disconnectWaiting) {
        this.disconnectWaiting.wait(3000L);
        if (ChatManager.debug)
          Log.v("Chat_Connector", "receive disconnect package, stop wait"); 
      } 
    } catch (InterruptedException interruptedException) {
      interruptedException.printStackTrace();
    } 
    this.linker.cancelPackage((BasePackage)disconnectPackage);
  }
  
  private void switchToBackupLink() {
    if (ChatManager.debug)
      Log.v("Chat_Connector", "switchToBackupLink()"); 
    this.linker.relink(true);
  }
  
  public void appActiveChanged(boolean paramBoolean) {
    if (!this.connectForbidden) {
      if (!isWorking())
        return; 
      this.linker.appActiveChanged(paramBoolean);
    } 
  }
  
  public void cancelPackage(BasePackage paramBasePackage) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("cancelPackage(), pack:");
      stringBuilder.append(paramBasePackage);
      Log.v("Chat_Connector", stringBuilder.toString());
    } 
    this.linker.cancelPackage(paramBasePackage);
  }
  
  public void checkNet() {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("checkNet(), connectForbidden:");
      stringBuilder.append(this.connectForbidden);
      stringBuilder.append(", state:");
      stringBuilder.append(getState());
      Log.v("Chat_Connector", stringBuilder.toString());
    } 
    if (!this.connectForbidden) {
      if (!isWorking())
        return; 
      this.linker.checkNet();
    } 
  }
  
  public ConnectState getConnectStatus() {
    return this.currentState;
  }
  
  public PackSendHelper getPackageSendHelper() {
    return this._packageSendHelper;
  }
  
  protected String getWorkerName() {
    return "Connector";
  }
  
  public void init() {
    if (this.linker == null)
      this.linker = new Linker(); 
    this.linker.registerLinkListener(this);
    registerPackageHandler(1, this);
    registerPackageHandler(14, this);
    registerPackageHandler(13, this);
  }
  
  public void onLinkReceive(BasePackage paramBasePackage) {
    if (paramBasePackage.ack && this._packageSendHelper.handleReceiveAckPackage(paramBasePackage))
      return; 
    PackageHandler packageHandler = (PackageHandler)this.packHandlerList.get(paramBasePackage.type);
    if (packageHandler != null) {
      packageHandler.onReceive(paramBasePackage);
      return;
    } 
    if (ChatManager.debug)
      Log.v("Chat_Connector", "none handler need this pack"); 
  }
  
  public void onLinkSendFailed(BasePackage paramBasePackage, String paramString) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onLinkSendFailed(), pack:");
      stringBuilder.append(paramBasePackage);
      stringBuilder.append(", failedMessage: ");
      stringBuilder.append(paramString);
      Log.v("Chat_Connector", stringBuilder.toString());
    } 
    notifyPackageSendFailed(paramBasePackage, paramString);
  }
  
  public void onLinkSendSuccess(BasePackage paramBasePackage) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onLinkSendSuccess(), pack:");
      stringBuilder.append(paramBasePackage);
      Log.v("Chat_Connector", stringBuilder.toString());
    } 
    if (this._packageSendHelper.handlePackageSendFinish(paramBasePackage))
      return; 
    PackageHandler packageHandler = (PackageHandler)this.packHandlerList.get(paramBasePackage.type);
    if (packageHandler != null) {
      packageHandler.onSendSuccess(paramBasePackage);
      return;
    } 
    if (ChatManager.debug)
      Log.v("Chat_Connector", "none handler need this pack"); 
  }
  
  public void onLinkStateChanged(int paramInt) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onLinkStateChanged(), newState:");
      stringBuilder.append(paramInt);
      Log.v("Chat_Connector", stringBuilder.toString());
    } 
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt != 3) {
            if (ChatManager.debug) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("unknown link state:");
              stringBuilder.append(paramInt);
              Log.e("Chat_Connector", stringBuilder.toString());
              return;
            } 
          } else {
            changeState(ConnectState.CONNECTED);
            if (ChatManager.debug && (ChatManager.getInstance()).debugTipsListener != null) {
              (ChatManager.getInstance()).debugTipsListener.onTips("鉴权成功");
              return;
            } 
          } 
        } else if (!sendConnPack()) {
          if (ChatManager.debug)
            Log.v("Chat_Connector", "sendConnPack failed, unlink linker"); 
          this.linker.unlink();
          return;
        } 
      } else {
        changeState(ConnectState.CONNECTING);
        return;
      } 
    } else {
      changeState(ConnectState.DISCONNECT);
      if (ChatManager.debug && (ChatManager.getInstance()).debugTipsListener != null)
        (ChatManager.getInstance()).debugTipsListener.onTips("连接失败"); 
    } 
  }
  
  public void onPackageTimeout(long paramLong, Object paramObject) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onPackageTimeout(), keyId:");
      stringBuilder.append(paramLong);
      stringBuilder.append(", data:");
      stringBuilder.append(paramObject);
      Log.v("Chat_Connector", stringBuilder.toString());
    } 
    if (paramObject instanceof ConnPackage) {
      if (paramLong != this.connPackLocalId) {
        if (ChatManager.debug) {
          paramObject = new StringBuilder();
          paramObject.append("the timeout pack is not current connPack, timeout id:");
          paramObject.append(paramLong);
          paramObject.append(", current id:");
          paramObject.append(this.connPackLocalId);
          Log.v("Chat_Connector", paramObject.toString());
        } 
        return;
      } 
      paramObject = paramObject;
      if (paramObject != null)
        DataUtils.imMessageFailed(BasePackage.typeToString((BasePackage)paramObject), SystemClock.uptimeMillis() - ((ConnPackage)paramObject).sendTime, "package timeout"); 
      if (this.linker.getState() < 3 && this.linker.getState() >= 2)
        sendConnPackFailed((ConnPackage)paramObject, "send timeout"); 
    } 
  }
  
  protected void onPause() {
    super.onPause();
    if (ChatManager.debug)
      Log.v("Chat_Connector", "onPause()"); 
    sendDisconnectPack();
    this._packageSendHelper.stop();
    disconnect();
  }
  
  public void onReceive(BasePackage paramBasePackage) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onReceive(), pack:");
      stringBuilder.append(paramBasePackage);
      Log.v("Chat_Connector", stringBuilder.toString());
    } 
    short s = paramBasePackage.type;
    if (s != 1) {
      if (s != 13) {
        if (s != 14) {
          if (ChatManager.debug) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("receive unknown package, pack:");
            stringBuilder.append(paramBasePackage);
            Log.e("Chat_Connector", stringBuilder.toString());
            return;
          } 
        } else {
          synchronized (this.disconnectWaiting) {
            this.disconnectWaiting.notify();
            if (paramBasePackage instanceof DisconnectPackage) {
              recvDisconnectPackage((DisconnectPackage)paramBasePackage);
              return;
            } 
            if (ChatManager.debug) {
              Log.e("Chat_Connector", "can't handle this DISCONNECT pack");
              return;
            } 
          } 
        } 
      } else {
        reconnect();
        return;
      } 
    } else {
      if (paramBasePackage.ack && paramBasePackage instanceof ConnAckPackage) {
        receiveConnAck((ConnAckPackage)paramBasePackage);
        return;
      } 
      if (ChatManager.debug)
        Log.e("Chat_Connector", "can't handle this CONNECT pack"); 
    } 
  }
  
  protected void onResume() {
    super.onResume();
    if (ChatManager.debug)
      Log.v("Chat_Connector", "onResume()"); 
    this._packageSendHelper.start();
    connect();
  }
  
  public void onSendFailed(BasePackage paramBasePackage, String paramString) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onSendFailed(), pack:");
      stringBuilder.append(paramBasePackage);
      Log.v("Chat_Connector", stringBuilder.toString());
    } 
    if (paramBasePackage.type == 1 && paramBasePackage instanceof ConnPackage) {
      TimeoutUtils.cancelTimeoutPackage(this.connPackLocalId);
      ConnPackage connPackage = (ConnPackage)paramBasePackage;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("send failed: ");
      stringBuilder.append(paramString);
      sendConnPackFailed(connPackage, stringBuilder.toString());
    } 
  }
  
  public void onSendSuccess(BasePackage paramBasePackage) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onSendSuccess(), pack:");
      stringBuilder.append(paramBasePackage);
      Log.v("Chat_Connector", stringBuilder.toString());
    } 
  }
  
  public void onStart() {
    if (ChatManager.debug)
      Log.v("Chat_Connector", "start()"); 
    this.connectForbidden = false;
  }
  
  public void onStop() {
    if (ChatManager.debug)
      Log.v("Chat_Connector", "stop()"); 
  }
  
  public void pingFailed() {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("pingFailed(), currentState:");
      stringBuilder.append(this.currentState);
      Log.v("Chat_Connector", stringBuilder.toString());
    } 
    if (this.currentState == ConnectState.CONNECTED) {
      reconnect();
      return;
    } 
    checkNet();
  }
  
  public void registerConnectListener(ConnectListener paramConnectListener) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("registerConnectListener(), listener:");
      stringBuilder.append(paramConnectListener);
      Log.v("Chat_Connector", stringBuilder.toString());
    } 
    if (paramConnectListener == null)
      return; 
    synchronized (this.connectListenerList) {
      this.connectListenerList.add(paramConnectListener);
      int i = null.$SwitchMap$com$blued$android$chat$data$ConnectState[this.currentState.ordinal()];
      if (i != 1) {
        if (i != 2) {
          if (i != 3)
            return; 
          paramConnectListener.onConnected();
          return;
        } 
        paramConnectListener.onConnecting();
        return;
      } 
      paramConnectListener.onDisconnected();
      return;
    } 
  }
  
  public void registerPackageHandler(int paramInt, PackageHandler paramPackageHandler) {
    this.packHandlerList.put(paramInt, paramPackageHandler);
  }
  
  public void sendPackage(BasePackage paramBasePackage) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sendPackage(), pack:");
      stringBuilder.append(paramBasePackage);
      Log.v("Chat_Connector", stringBuilder.toString());
    } 
    if (this.connectForbidden || !isWorking()) {
      if (ChatManager.debug)
        Log.v("Chat_Connector", "stopped, notifyPackageSendFailed"); 
      boolean bool = paramBasePackage instanceof SendMsgPackage;
      String str = "";
      if (bool) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(", msgType: ");
        stringBuilder1.append(((SendMsgPackage)paramBasePackage).msgType);
        stringBuilder1.append("");
        str = stringBuilder1.toString();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("stopped, state: ");
      stringBuilder.append(getState());
      stringBuilder.append(", connectState: ");
      stringBuilder.append(getConnectStatus());
      stringBuilder.append(", connectForbidden: ");
      stringBuilder.append(this.connectForbidden);
      stringBuilder.append(", packageType: ");
      stringBuilder.append(paramBasePackage.type);
      stringBuilder.append(", name: ");
      stringBuilder.append(paramBasePackage.getClass().getSimpleName());
      stringBuilder.append(str);
      notifyPackageSendFailed(paramBasePackage, stringBuilder.toString());
      return;
    } 
    this.linker.sendPackage(paramBasePackage);
  }
  
  public void unregisterConnectListener(ConnectListener paramConnectListener) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unregisterConnectListener(), listener:");
      stringBuilder.append(paramConnectListener);
      Log.v("Chat_Connector", stringBuilder.toString());
    } 
    synchronized (this.connectListenerList) {
      this.connectListenerList.remove(paramConnectListener);
      return;
    } 
  }
  
  public void unregisterPackageHandler(int paramInt, PackageHandler paramPackageHandler) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unregisterPackageHandler(), type:");
      stringBuilder.append(paramInt);
      stringBuilder.append(", handler:");
      stringBuilder.append(paramPackageHandler);
      Log.v("Chat_Connector", stringBuilder.toString());
    } 
    if (this.packHandlerList.get(paramInt) == paramPackageHandler)
      this.packHandlerList.remove(paramInt); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\worker\Connector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */