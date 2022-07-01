package com.blued.android.module.im.biz.receipt;

import com.blued.android.module.im.grpc.ChannelManager;
import com.blued.android.module.im.grpc.IMThreadManager;
import com.blued.im.private_chat.ReceiptGrpc;
import com.blued.im.private_chat.ReceiptOuterClass;

public class DeleteSession extends ReceiptBase {
  public DeleteSession(ChannelManager paramChannelManager, IMThreadManager paramIMThreadManager) {
    super(paramChannelManager, paramIMThreadManager);
  }
  
  protected ReceiptOuterClass.ReceiptResponse a(ReceiptGrpc.ReceiptBlockingStub paramReceiptBlockingStub, ReceiptOuterClass.ReceiptRequest paramReceiptRequest) {
    return paramReceiptBlockingStub.delSession(paramReceiptRequest);
  }
  
  protected String a() {
    return "deleteSession";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\im\biz\receipt\DeleteSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */