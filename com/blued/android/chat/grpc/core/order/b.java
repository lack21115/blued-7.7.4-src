package com.blued.android.chat.grpc.core.order;

import android.util.Log;
import androidx.collection.ArrayMap;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.compatible.IReceiptSender;
import com.blued.android.chat.data.SessionHeader;
import com.blued.android.chat.grpc.PrivateChatManager;
import com.blued.android.module.im.IM;
import com.blued.android.module.im.biz.receipt.OnReceiptResponseListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class b implements IReceiptSender {
  private final Object a = new Object();
  
  private Map<String, d> b = (Map<String, d>)new ArrayMap();
  
  private Timer c;
  
  private long d;
  
  private void a() {
    synchronized (this.a) {
      if (this.c == null) {
        this.c = new Timer();
        this.c.scheduleAtFixedRate(new c(null), 5000L, 5000L);
        if (ChatManager.debug)
          Log.v("Chat_ReceiptSender", "start timer"); 
      } 
      return;
    } 
  }
  
  private void a(d paramd) {
    IReceiptSender.ReceiptType receiptType = paramd.d;
    if (receiptType == IReceiptSender.ReceiptType.READED) {
      short s = paramd.a;
      if (s == 3)
        return; 
      IM.b(false, s, Integer.parseInt((PrivateChatManager.getInstance().getUserInfo()).uid), (int)paramd.b, (int)paramd.c, new a(this));
      return;
    } 
    if (receiptType == IReceiptSender.ReceiptType.RECEIVED) {
      boolean bool;
      if (paramd.a == 3) {
        bool = true;
      } else {
        bool = false;
      } 
      IM.a(bool, paramd.a, Integer.parseInt((PrivateChatManager.getInstance().getUserInfo()).uid), (int)paramd.b, (int)paramd.c, new b(this));
    } 
  }
  
  private void b() {
    if (ChatManager.debug)
      Log.v("Chat_ReceiptSender", "timeout to processPendingList()"); 
    synchronized (this.b) {
      Collection<d> collection = this.b.values();
      if (collection.size() > 0) {
        boolean bool = ChatManager.debug;
        if (bool) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("pending list size:");
          stringBuilder.append(collection.size());
          Log.v("Chat_ReceiptSender", stringBuilder.toString());
        } 
        Iterator<d> iterator = collection.iterator();
        while (iterator.hasNext())
          a(iterator.next()); 
        this.b.clear();
      } 
      if (System.currentTimeMillis() - this.d > 3000L)
        synchronized (this.a) {
          if (this.c != null) {
            this.c.cancel();
            this.c.purge();
            this.c = null;
            if (ChatManager.debug)
              Log.v("Chat_ReceiptSender", "close timer"); 
          } 
        }  
      return;
    } 
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
      Log.v("Chat_ReceiptSender", stringBuilder.toString());
    } 
    if (paramShort != 2)
      paramReceiptType = IReceiptSender.ReceiptType.RECEIVED; 
    null = SessionHeader.getSessionKey(paramShort, paramLong1);
    d d = new d(this, paramShort, paramLong1, paramLong2, paramReceiptType);
    synchronized (this.b) {
      d d1 = this.b.get(null);
      if (d1 == null) {
        if (ChatManager.debug)
          Log.v("Chat_ReceiptSender", "save this readed pack to pending list"); 
        this.d = System.currentTimeMillis();
        this.b.put(null, d);
        a();
      } else {
        StringBuilder stringBuilder;
        if (d1.c > d.c) {
          boolean bool = ChatManager.debug;
          if (bool) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("why current id is lower than older, oldId:");
            stringBuilder.append(d1.c);
            Log.e("Chat_ReceiptSender", stringBuilder.toString());
          } 
          return;
        } 
        this.b.remove(stringBuilder);
        if (d.c - d1.c > 20L) {
          if (ChatManager.debug)
            Log.v("Chat_ReceiptSender", "current is larger than older more, so send it now"); 
          a(d);
        } else {
          if (ChatManager.debug)
            Log.v("Chat_ReceiptSender", "save this readed pack to pending list"); 
          this.d = System.currentTimeMillis();
          this.b.put(stringBuilder, d);
          a();
        } 
        if (d1.d != d.d) {
          if (ChatManager.debug)
            Log.v("Chat_ReceiptSender", "old readed type is not equal this one, so send old now"); 
          a(d1);
        } 
      } 
      return;
    } 
  }
  
  public void sendReceiptImmediate(short paramShort, long paramLong1, long paramLong2, IReceiptSender.ReceiptType paramReceiptType) {
    Map<String, d> map;
    d d;
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
      Log.v("Chat_ReceiptSender", stringBuilder.toString());
    } 
    IReceiptSender.ReceiptType receiptType = paramReceiptType;
    if (paramShort != 2)
      receiptType = IReceiptSender.ReceiptType.RECEIVED; 
    null = SessionHeader.getSessionKey(paramShort, paramLong1);
    synchronized (this.b) {
      d d1 = this.b.remove(null);
      if (d1 == null) {
        if (receiptType == IReceiptSender.ReceiptType.READED) {
          if (paramShort == 3)
            return; 
          IM.b(false, paramShort, Integer.parseInt((PrivateChatManager.getInstance().getUserInfo()).uid), (int)paramLong1, (int)paramLong2, new a(this));
          return;
        } 
        if (receiptType == IReceiptSender.ReceiptType.RECEIVED) {
          boolean bool;
          if (paramShort == 3) {
            bool = true;
          } else {
            bool = false;
          } 
          IM.a(bool, paramShort, Integer.parseInt((PrivateChatManager.getInstance().getUserInfo()).uid), (int)paramLong1, (int)paramLong2, new b(this));
          return;
        } 
      } else {
        d d2 = new d(this, paramShort, paramLong1, paramLong2, receiptType);
        if (d1.c > d2.c) {
          d = d1;
        } else {
          d = d2;
        } 
        IReceiptSender.ReceiptType receiptType1 = d2.d;
        IReceiptSender.ReceiptType receiptType2 = IReceiptSender.ReceiptType.READED;
        if (receiptType1 == receiptType2 || d1.d != receiptType2)
          d1 = d2; 
        if (d == d1) {
          a(d1);
          return;
        } 
        a(d1);
        a(d);
      } 
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
      Log.v("Chat_ReceiptSender", stringBuilder.toString());
    } 
    IReceiptSender.ReceiptType receiptType = paramReceiptType;
    if (paramShort != 2) {
      receiptType = paramReceiptType;
      if (paramShort != 3)
        receiptType = IReceiptSender.ReceiptType.RECEIVED; 
    } 
    if (receiptType == IReceiptSender.ReceiptType.READED) {
      if (paramShort == 3)
        return; 
      IM.b(false, paramShort, Integer.parseInt((PrivateChatManager.getInstance().getUserInfo()).uid), (int)paramLong1, (int)paramLong2, new a(this));
      return;
    } 
    if (receiptType == IReceiptSender.ReceiptType.RECEIVED) {
      if (paramShort == 3) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      } 
      IM.a(paramBoolean, paramShort, Integer.parseInt((PrivateChatManager.getInstance().getUserInfo()).uid), (int)paramLong1, (int)paramLong2, new b(this));
    } 
  }
  
  class a implements OnReceiptResponseListener {
    a(b this$0) {}
    
    public void onFailure(int param1Int, Exception param1Exception) {}
    
    public void onSuccess(long param1Long1, long param1Long2) {}
  }
  
  class b implements OnReceiptResponseListener {
    b(b this$0) {}
    
    public void onFailure(int param1Int, Exception param1Exception) {}
    
    public void onSuccess(long param1Long1, long param1Long2) {}
  }
  
  class c extends TimerTask {
    private c(b this$0) {}
    
    public void run() {
      b.a(this.a);
    }
  }
  
  class d {
    public short a;
    
    public long b;
    
    public long c;
    
    public IReceiptSender.ReceiptType d;
    
    public d(b this$0, short param1Short, long param1Long1, long param1Long2, IReceiptSender.ReceiptType param1ReceiptType) {
      this.a = param1Short;
      this.b = param1Long1;
      this.c = param1Long2;
      this.d = param1ReceiptType;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\grpc\core\order\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */