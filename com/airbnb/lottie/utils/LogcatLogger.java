package com.airbnb.lottie.utils;

import android.util.Log;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieLogger;
import java.util.HashSet;
import java.util.Set;

public class LogcatLogger implements LottieLogger {
  private static final Set<String> a = new HashSet<String>();
  
  public void a(String paramString) {
    b(paramString, null);
  }
  
  public void a(String paramString, Throwable paramThrowable) {
    if (a.contains(paramString))
      return; 
    Log.w("LOTTIE", paramString, paramThrowable);
    a.add(paramString);
  }
  
  public void b(String paramString) {
    a(paramString, null);
  }
  
  public void b(String paramString, Throwable paramThrowable) {
    if (L.a)
      Log.d("LOTTIE", paramString, paramThrowable); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lotti\\utils\LogcatLogger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */