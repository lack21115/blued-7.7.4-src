package com.loopj.android.http;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

class RetryHandler implements HttpRequestRetryHandler {
  private static final HashSet<Class<?>> exceptionBlacklist;
  
  private static final HashSet<Class<?>> exceptionWhitelist = new HashSet<Class<?>>();
  
  private final int maxRetries;
  
  private final int retrySleepTimeMS;
  
  static {
    exceptionBlacklist = new HashSet<Class<?>>();
    exceptionWhitelist.add(NoHttpResponseException.class);
    exceptionWhitelist.add(UnknownHostException.class);
    exceptionWhitelist.add(SocketException.class);
    exceptionBlacklist.add(InterruptedIOException.class);
    exceptionBlacklist.add(SSLException.class);
  }
  
  public RetryHandler(int paramInt1, int paramInt2) {
    this.maxRetries = paramInt1;
    this.retrySleepTimeMS = paramInt2;
  }
  
  static void addClassToBlacklist(Class<?> paramClass) {
    exceptionBlacklist.add(paramClass);
  }
  
  static void addClassToWhitelist(Class<?> paramClass) {
    exceptionWhitelist.add(paramClass);
  }
  
  protected boolean isInList(HashSet<Class<?>> paramHashSet, Throwable paramThrowable) {
    Iterator<Class<?>> iterator = paramHashSet.iterator();
    while (iterator.hasNext()) {
      if (((Class)iterator.next()).isInstance(paramThrowable))
        return true; 
    } 
    return false;
  }
  
  public boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext) {
    // Byte code:
    //   0: aload_3
    //   1: ldc 'http.request_sent'
    //   3: invokeinterface getAttribute : (Ljava/lang/String;)Ljava/lang/Object;
    //   8: checkcast java/lang/Boolean
    //   11: astore #5
    //   13: iconst_1
    //   14: istore #4
    //   16: aload #5
    //   18: ifnull -> 32
    //   21: aload #5
    //   23: invokevirtual booleanValue : ()Z
    //   26: ifeq -> 32
    //   29: goto -> 32
    //   32: iload_2
    //   33: aload_0
    //   34: getfield maxRetries : I
    //   37: if_icmple -> 46
    //   40: iconst_0
    //   41: istore #4
    //   43: goto -> 74
    //   46: aload_0
    //   47: getstatic com/loopj/android/http/RetryHandler.exceptionWhitelist : Ljava/util/HashSet;
    //   50: aload_1
    //   51: invokevirtual isInList : (Ljava/util/HashSet;Ljava/lang/Throwable;)Z
    //   54: ifeq -> 60
    //   57: goto -> 74
    //   60: aload_0
    //   61: getstatic com/loopj/android/http/RetryHandler.exceptionBlacklist : Ljava/util/HashSet;
    //   64: aload_1
    //   65: invokevirtual isInList : (Ljava/util/HashSet;Ljava/lang/Throwable;)Z
    //   68: ifeq -> 74
    //   71: goto -> 40
    //   74: iload #4
    //   76: ifeq -> 95
    //   79: aload_3
    //   80: ldc 'http.request'
    //   82: invokeinterface getAttribute : (Ljava/lang/String;)Ljava/lang/Object;
    //   87: checkcast org/apache/http/client/methods/HttpUriRequest
    //   90: ifnonnull -> 95
    //   93: iconst_0
    //   94: ireturn
    //   95: iload #4
    //   97: ifeq -> 111
    //   100: aload_0
    //   101: getfield retrySleepTimeMS : I
    //   104: i2l
    //   105: invokestatic sleep : (J)V
    //   108: iload #4
    //   110: ireturn
    //   111: aload_1
    //   112: invokevirtual printStackTrace : ()V
    //   115: iload #4
    //   117: ireturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loopj\android\http\RetryHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */