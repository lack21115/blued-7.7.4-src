package com.blued.android.chat.core.worker.chat;

import androidx.collection.ArrayMap;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.compatible.GRPC;
import com.blued.android.chat.compatible.IReceiptSender;
import com.blued.android.chat.core.pack.BasePackage;
import com.blued.android.chat.core.pack.SendReceiptPackage;
import com.blued.android.chat.core.utils.Log;
import com.blued.android.chat.core.worker.Connector;
import com.blued.android.chat.data.SessionHeader;
import java.util.Collection;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class ReadedFlagSender implements IReceiptSender {
  private static final int FREQ_MS = 5000;
  
  private static final int IDLE_MS = 3000;
  
  private static final int MAX_ID_DIFF = 20;
  
  private static final String TAG = "Chat_ReadedFlagSender";
  
  private Connector connector;
  
  private long lastTime;
  
  private Map<String, SendReceiptPackage> readedPackagePending = (Map<String, SendReceiptPackage>)new ArrayMap();
  
  private Timer timer;
  
  private final Object timerLock = new Object();
  
  public ReadedFlagSender(Connector paramConnector) {
    this.connector = paramConnector;
  }
  
  private void checkTimer() {
    synchronized (this.timerLock) {
      if (this.timer == null) {
        this.timer = new Timer();
        this.timer.scheduleAtFixedRate(new MyTimerTask(), 5000L, 5000L);
        if (ChatManager.debug)
          Log.v("Chat_ReadedFlagSender", "start timer"); 
      } 
      return;
    } 
  }
  
  private void processPendingList() {
    if (ChatManager.debug)
      Log.v("Chat_ReadedFlagSender", "timeout to processPendingList()"); 
    synchronized (this.readedPackagePending) {
      Collection<SendReceiptPackage> collection = this.readedPackagePending.values();
      if (collection.size() > 0) {
        if (ChatManager.debug) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("pending list size:");
          stringBuilder.append(collection.size());
          Log.v("Chat_ReadedFlagSender", stringBuilder.toString());
        } 
        for (SendReceiptPackage sendReceiptPackage : collection)
          this.connector.sendPackage((BasePackage)sendReceiptPackage); 
        this.readedPackagePending.clear();
      } 
      if (System.currentTimeMillis() - this.lastTime > 3000L)
        synchronized (this.timerLock) {
          if (this.timer != null) {
            this.timer.cancel();
            this.timer.purge();
            this.timer = null;
            if (ChatManager.debug)
              Log.v("Chat_ReadedFlagSender", "close timer"); 
          } 
        }  
      return;
    } 
  }
  
  private void saveToPendingList(String paramString, SendReceiptPackage paramSendReceiptPackage) {
    this.lastTime = System.currentTimeMillis();
    this.readedPackagePending.put(paramString, paramSendReceiptPackage);
    checkTimer();
  }
  
  public void sendReceipt(short paramShort, long paramLong1, long paramLong2, IReceiptSender.ReceiptType paramReceiptType) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("send readed flag, sessionType:");
      stringBuilder.append(paramShort);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(paramLong1);
      stringBuilder.append(", msgId:");
      stringBuilder.append(paramLong2);
      stringBuilder.append(", receiptType:");
      stringBuilder.append(paramReceiptType);
      Log.v("Chat_ReadedFlagSender", stringBuilder.toString());
    } 
    if (paramShort != 2)
      paramReceiptType = IReceiptSender.ReceiptType.RECEIVED; 
    if (ChatManager.clientType == ChatManager.ClientType.CHINA && paramShort == 3 && GRPC.getInstance().getReceiptSender() != null) {
      GRPC.getInstance().getReceiptSender().sendReceipt(paramShort, paramLong1, paramLong2, paramReceiptType);
      return;
    } 
    null = SessionHeader.getSessionKey(paramShort, paramLong1);
    SendReceiptPackage sendReceiptPackage = new SendReceiptPackage(paramShort, paramLong1, paramLong2, paramReceiptType);
    synchronized (this.readedPackagePending) {
      SendReceiptPackage sendReceiptPackage1 = this.readedPackagePending.get(null);
      if (sendReceiptPackage1 == null) {
        if (ChatManager.debug)
          Log.v("Chat_ReadedFlagSender", "save this readed pack to pending list"); 
        saveToPendingList(null, sendReceiptPackage);
      } else {
        StringBuilder stringBuilder;
        if (sendReceiptPackage1.msgId > sendReceiptPackage.msgId) {
          if (ChatManager.debug) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("why current id is lower than older, oldId:");
            stringBuilder.append(sendReceiptPackage1.msgId);
            Log.e("Chat_ReadedFlagSender", stringBuilder.toString());
          } 
          return;
        } 
        this.readedPackagePending.remove(stringBuilder);
        if (sendReceiptPackage.msgId - sendReceiptPackage1.msgId > 20L) {
          if (ChatManager.debug)
            Log.v("Chat_ReadedFlagSender", "current is larger than older more, so send it now"); 
          this.connector.sendPackage((BasePackage)sendReceiptPackage);
        } else {
          if (ChatManager.debug)
            Log.v("Chat_ReadedFlagSender", "save this readed pack to pending list"); 
          saveToPendingList((String)stringBuilder, sendReceiptPackage);
        } 
        if (sendReceiptPackage1.msgHeader.isReaded != sendReceiptPackage.msgHeader.isReaded) {
          if (ChatManager.debug)
            Log.v("Chat_ReadedFlagSender", "old readed type is not equal this one, so send old now"); 
          this.connector.sendPackage((BasePackage)sendReceiptPackage1);
        } 
      } 
      return;
    } 
  }
  
  public void sendReceiptImmediate(short paramShort, long paramLong1, long paramLong2, IReceiptSender.ReceiptType paramReceiptType) {
    Map<String, SendReceiptPackage> map;
    SendReceiptPackage sendReceiptPackage;
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sendImmediate readed flag, sessionType:");
      stringBuilder.append(paramShort);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(paramLong1);
      stringBuilder.append(", msgId:");
      stringBuilder.append(paramLong2);
      stringBuilder.append(", receiptType:");
      stringBuilder.append(paramReceiptType);
      Log.v("Chat_ReadedFlagSender", stringBuilder.toString());
    } 
    IReceiptSender.ReceiptType receiptType = paramReceiptType;
    if (paramShort != 2)
      receiptType = IReceiptSender.ReceiptType.RECEIVED; 
    if (ChatManager.clientType == ChatManager.ClientType.CHINA && paramShort == 3 && GRPC.getInstance().getReceiptSender() != null) {
      GRPC.getInstance().getReceiptSender().sendReceiptImmediate(paramShort, paramLong1, paramLong2, receiptType);
      return;
    } 
    null = SessionHeader.getSessionKey(paramShort, paramLong1);
    synchronized (this.readedPackagePending) {
      SendReceiptPackage sendReceiptPackage1 = this.readedPackagePending.remove(null);
      if (sendReceiptPackage1 == null) {
        sendReceiptPackage1 = new SendReceiptPackage(paramShort, paramLong1, paramLong2, receiptType);
        this.connector.sendPackage((BasePackage)sendReceiptPackage1);
        return;
      } 
      SendReceiptPackage sendReceiptPackage2 = new SendReceiptPackage(paramShort, paramLong1, paramLong2, receiptType);
      if (sendReceiptPackage1.msgId > sendReceiptPackage2.msgId) {
        sendReceiptPackage = sendReceiptPackage1;
      } else {
        sendReceiptPackage = sendReceiptPackage2;
      } 
      if (sendReceiptPackage2.msgHeader.isReaded || !sendReceiptPackage1.msgHeader.isReaded)
        sendReceiptPackage1 = sendReceiptPackage2; 
      if (sendReceiptPackage == sendReceiptPackage1) {
        this.connector.sendPackage((BasePackage)sendReceiptPackage1);
        return;
      } 
      this.connector.sendPackage((BasePackage)sendReceiptPackage1);
      this.connector.sendPackage((BasePackage)sendReceiptPackage);
      return;
    } 
  }
  
  public void sendReceiptImmediateForOrder(short paramShort, long paramLong1, long paramLong2, IReceiptSender.ReceiptType paramReceiptType, boolean paramBoolean) {
    if (ChatManager.debug) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("sendImmediateForRetraction readed flag, sessionType:");
      stringBuilder.append(paramShort);
      stringBuilder.append(", sessionId:");
      stringBuilder.append(paramLong1);
      stringBuilder.append(", msgId:");
      stringBuilder.append(paramLong2);
      stringBuilder.append(", receiptType:");
      stringBuilder.append(paramReceiptType);
      stringBuilder.append(", isOrder:");
      stringBuilder.append(paramBoolean);
      Log.v("Chat_ReadedFlagSender", stringBuilder.toString());
    } 
    IReceiptSender.ReceiptType receiptType = paramReceiptType;
    if (paramShort != 2) {
      receiptType = paramReceiptType;
      if (paramShort != 3)
        receiptType = IReceiptSender.ReceiptType.RECEIVED; 
    } 
    if (ChatManager.clientType == ChatManager.ClientType.CHINA && paramShort == 3 && GRPC.getInstance().getReceiptSender() != null) {
      GRPC.getInstance().getReceiptSender().sendReceiptImmediateForOrder(paramShort, paramLong1, paramLong2, receiptType, paramBoolean);
      return;
    } 
    SendReceiptPackage sendReceiptPackage = new SendReceiptPackage(paramShort, paramLong1, paramLong2, receiptType, paramBoolean);
    this.connector.sendPackage((BasePackage)sendReceiptPackage);
  }
  
  class MyTimerTask extends TimerTask {
    private MyTimerTask() {}
    
    public void run() {
      ReadedFlagSender.this.processPendingList();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\worker\chat\ReadedFlagSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */