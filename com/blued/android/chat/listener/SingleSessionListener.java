package com.blued.android.chat.listener;

import com.blued.android.chat.model.SessionModel;

public interface SingleSessionListener {
  void onSessionDataChanged(SessionModel paramSessionModel);
  
  void onSessionRemoved(short paramShort, long paramLong);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\listener\SingleSessionListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */