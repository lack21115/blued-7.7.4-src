package com.blued.android.chat.grpc.core.chat;

import android.util.Log;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.compatible.GRPC;
import com.blued.android.chat.compatible.IOrderSender;
import com.blued.android.chat.compatible.IReceiptSender;
import com.blued.android.chat.db.DBOper;
import com.blued.android.chat.grpc.core.a;
import com.blued.android.chat.grpc.core.order.b;
import com.blued.android.chat.grpc.listener.ChatTipsListener;
import com.blued.android.chat.grpc.listener.ConnectListener;
import com.blued.android.chat.grpc.listener.MsgConsumer;
import com.blued.android.chat.grpc.utils.MsgConverter;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.module.im.IM;
import com.blued.android.module.im.biz.privatechat.OnPrivateChatResponseListener;
import com.blued.im.private_chat.PrivateChatOuterClass;
import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.HashMap;

public class a extends a implements MsgConsumer {
  private com.blued.android.chat.grpc.core.link.a b;
  
  private IReceiptSender c;
  
  private IOrderSender d;
  
  public a(com.blued.android.chat.grpc.core.link.a parama) {
    new HashMap<Object, Object>();
    this.c = (IReceiptSender)new b();
    this.d = (IOrderSender)new com.blued.android.chat.grpc.core.order.a();
    if (parama != null) {
      this.b = parama;
      GRPC.getInstance().setReceiptSender(this.c);
      GRPC.getInstance().setOrderSender(this.d);
      return;
    } 
    throw new RuntimeException(" connector is null");
  }
  
  public void a(DBOper paramDBOper) {
    if (paramDBOper != null)
      return; 
    throw new RuntimeException(" dbOperImpl is null");
  }
  
  public void a(ChatTipsListener paramChatTipsListener) {
    com.blued.android.chat.grpc.core.link.a a1 = this.b;
    if (a1 != null)
      a1.a((ConnectListener)paramChatTipsListener); 
  }
  
  public void a(ChattingModel paramChattingModel) {
    a a1 = new a(this, paramChattingModel);
    if (paramChattingModel.sessionType == 3) {
      IM.b(paramChattingModel.msgType, (int)paramChattingModel.msgLocalId, (int)paramChattingModel.toId, (int)paramChattingModel.fromId, MsgConverter.convertGRPCMsgBody(paramChattingModel), a1);
      return;
    } 
    IM.a(paramChattingModel.msgType, (int)paramChattingModel.msgLocalId, (int)paramChattingModel.toId, (int)paramChattingModel.fromId, MsgConverter.convertGRPCMsgBody(paramChattingModel), a1);
  }
  
  public boolean consumeMsg(Any paramAny) {
    if (paramAny.is(PrivateChatOuterClass.Receive.class)) {
      try {
        PrivateChatOuterClass.Receive receive = (PrivateChatOuterClass.Receive)paramAny.unpack(PrivateChatOuterClass.Receive.class);
        if (receive != null) {
          ChattingModel chattingModel = MsgConverter.convertReceiveMsg(receive);
          ChatManager.getInstance().onReceiveMsgFromGRPC(chattingModel, receive.getIsRead(), receive.getIsDeleted());
        } 
      } catch (InvalidProtocolBufferException invalidProtocolBufferException) {
        invalidProtocolBufferException.printStackTrace();
      } 
      return true;
    } 
    return false;
  }
  
  public void d() {
    super.d();
    this.b.a(this);
  }
  
  public void e() {
    this.b.b(this);
  }
  
  class a implements OnPrivateChatResponseListener {
    a(a this$0, ChattingModel param1ChattingModel) {}
    
    public void onFailure(int param1Int1, int param1Int2, Exception param1Exception) {
      String str = a.j();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("grpc error: ");
      stringBuilder.append(param1Int2);
      stringBuilder.append(" || exception : ");
      stringBuilder.append(param1Exception);
      Log.e(str, stringBuilder.toString());
      ChatManager chatManager = ChatManager.getInstance();
      param1Int2 = MsgConverter.convertErrorCode(param1Int2);
      ChattingModel chattingModel = this.a;
      chatManager.notifySendStateForGRPC(param1Int2, chattingModel.sessionType, chattingModel.sessionId, chattingModel.msgId, param1Int1, chattingModel.msgTimestamp);
    }
    
    public void onSuccess(int param1Int, long param1Long1, long param1Long2) {
      ChatManager chatManager = ChatManager.getInstance();
      ChattingModel chattingModel = this.a;
      chatManager.notifySendStateForGRPC(0, chattingModel.sessionType, chattingModel.sessionId, param1Long1, param1Int, param1Long2);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\grpc\core\chat\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */