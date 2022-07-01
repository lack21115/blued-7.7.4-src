package com.blued.android.chat.compatible;

public interface IReceiptSender {
  void sendReceipt(short paramShort, long paramLong1, long paramLong2, ReceiptType paramReceiptType);
  
  void sendReceiptImmediate(short paramShort, long paramLong1, long paramLong2, ReceiptType paramReceiptType);
  
  void sendReceiptImmediateForOrder(short paramShort, long paramLong1, long paramLong2, ReceiptType paramReceiptType, boolean paramBoolean);
  
  public enum ReceiptType {
    READED, RECEIVED;
    
    static {
    
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\compatible\IReceiptSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */