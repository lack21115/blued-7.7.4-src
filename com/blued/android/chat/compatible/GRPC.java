package com.blued.android.chat.compatible;

public class GRPC {
  private static GRPC instance;
  
  private IOrderSender orderSender;
  
  private IReceiptSender receiptSender;
  
  public static GRPC getInstance() {
    // Byte code:
    //   0: getstatic com/blued/android/chat/compatible/GRPC.instance : Lcom/blued/android/chat/compatible/GRPC;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/chat/compatible/GRPC
    //   8: monitorenter
    //   9: getstatic com/blued/android/chat/compatible/GRPC.instance : Lcom/blued/android/chat/compatible/GRPC;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/chat/compatible/GRPC
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/chat/compatible/GRPC.instance : Lcom/blued/android/chat/compatible/GRPC;
    //   25: ldc com/blued/android/chat/compatible/GRPC
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/chat/compatible/GRPC
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/chat/compatible/GRPC.instance : Lcom/blued/android/chat/compatible/GRPC;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public IOrderSender getOrderSender() {
    return this.orderSender;
  }
  
  public IReceiptSender getReceiptSender() {
    return this.receiptSender;
  }
  
  public void setOrderSender(IOrderSender paramIOrderSender) {
    this.orderSender = paramIOrderSender;
  }
  
  public void setReceiptSender(IReceiptSender paramIReceiptSender) {
    this.receiptSender = paramIReceiptSender;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\compatible\GRPC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */