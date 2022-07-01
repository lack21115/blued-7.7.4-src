package org.chromium.content_public.browser;

import android.os.Handler;
import org.chromium.base.annotations.UsedByReflection;

@UsedByReflection
public interface MessagePort {
  void close();
  
  boolean isClosed();
  
  boolean isStarted();
  
  boolean isTransferred();
  
  void postMessage(String paramString, MessagePort[] paramArrayOfMessagePort);
  
  void setMessageCallback(MessagePort$MessageCallback paramMessagePort$MessageCallback, Handler paramHandler);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content_public\browser\MessagePort.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */