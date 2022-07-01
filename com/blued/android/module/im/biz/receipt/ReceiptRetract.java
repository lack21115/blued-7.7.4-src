package com.blued.android.module.im.biz.receipt;

import com.blued.android.module.im.grpc.ChannelManager;
import com.blued.android.module.im.grpc.IMThreadManager;
import com.blued.im.private_chat.ReceiptGrpc;
import com.blued.im.private_chat.ReceiptOuterClass;

public class ReceiptRetract extends ReceiptBase {
  public ReceiptRetract(ChannelManager paramChannelManager, IMThreadManager paramIMThreadManager) {
    super(paramChannelManager, paramIMThreadManager);
  }
  
  protected ReceiptOuterClass.ReceiptResponse a(ReceiptGrpc.ReceiptBlockingStub paramReceiptBlockingStub, ReceiptOuterClass.ReceiptRequest paramReceiptRequest) {
    return paramReceiptBlockingStub.retract(paramReceiptRequest);
  }
  
  protected String a() {
    return "retract";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\im\biz\receipt\ReceiptRetract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */