package com.blued.android.chat.compatible;

import com.blued.android.chat.listener.RetractionListener;

public interface IOrderSender {
  void deleteAllSessions(boolean paramBoolean);
  
  void deleteOneSession(short paramShort, long paramLong, boolean paramBoolean);
  
  void retractMsg(short paramShort, long paramLong1, long paramLong2, RetractionListener paramRetractionListener);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\compatible\IOrderSender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */