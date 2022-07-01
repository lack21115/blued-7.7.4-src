package com.blued.android.chat.grpc.core.order;

import com.blued.android.chat.compatible.IOrderSender;
import com.blued.android.chat.grpc.PrivateChatManager;
import com.blued.android.chat.grpc.utils.ChatLog;
import com.blued.android.chat.listener.RetractionListener;
import com.blued.android.module.im.IM;
import com.blued.android.module.im.biz.receipt.OnReceiptResponseListener;

public class a implements IOrderSender {
  public static final String a = a.class.getSimpleName();
  
  public void deleteAllSessions(boolean paramBoolean) {
    IM.a(Integer.parseInt((PrivateChatManager.getInstance().getUserInfo()).uid), paramBoolean, new c(this));
  }
  
  public void deleteOneSession(short paramShort, long paramLong, boolean paramBoolean) {
    boolean bool;
    if (paramShort == 3) {
      bool = true;
    } else {
      bool = false;
    } 
    IM.a(bool, paramShort, Integer.parseInt((PrivateChatManager.getInstance().getUserInfo()).uid), (int)paramLong, paramBoolean, new b(this));
  }
  
  public void retractMsg(short paramShort, long paramLong1, long paramLong2, RetractionListener paramRetractionListener) {
    boolean bool;
    if (paramShort == 3) {
      bool = true;
    } else {
      bool = false;
    } 
    IM.c(bool, paramShort, Integer.parseInt((PrivateChatManager.getInstance().getUserInfo()).uid), (int)paramLong1, (int)paramLong2, new a(this, paramLong1, paramLong2, paramRetractionListener));
  }
  
  class a implements OnReceiptResponseListener {
    a(a this$0, long param1Long1, long param1Long2, RetractionListener param1RetractionListener) {}
    
    public void onFailure(int param1Int, Exception param1Exception) {
      String str = a.a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("retractMsg---error: ");
      stringBuilder.append(param1Int);
      stringBuilder.append("  e: ");
      stringBuilder.append(param1Exception);
      ChatLog.d(str, stringBuilder.toString());
      RetractionListener retractionListener = this.c;
      if (retractionListener != null) {
        if (param1Int == 13) {
          retractionListener.onMsgRetractedTimeout();
          return;
        } 
        retractionListener.onRetractFailed();
      } 
    }
    
    public void onSuccess(long param1Long1, long param1Long2) {
      String str = a.a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("retractMsg-sessionId : ");
      stringBuilder.append(this.a);
      stringBuilder.append(" msgId: ");
      stringBuilder.append(this.b);
      ChatLog.d(str, stringBuilder.toString());
      RetractionListener retractionListener = this.c;
      if (retractionListener != null)
        retractionListener.onRetractSuccess(); 
    }
  }
  
  class b implements OnReceiptResponseListener {
    b(a this$0) {}
    
    public void onFailure(int param1Int, Exception param1Exception) {}
    
    public void onSuccess(long param1Long1, long param1Long2) {}
  }
  
  class c implements OnReceiptResponseListener {
    c(a this$0) {}
    
    public void onFailure(int param1Int, Exception param1Exception) {}
    
    public void onSuccess(long param1Long1, long param1Long2) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\grpc\core\order\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */