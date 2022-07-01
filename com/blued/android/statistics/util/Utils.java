package com.blued.android.statistics.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.squareup.okhttp.ConnectionSpec;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.android.AndroidChannelBuilder;
import io.grpc.okhttp.OkHttpChannelBuilder;
import io.grpc.stub.AbstractStub;
import io.grpc.stub.MetadataUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Utils {
  private static Handler a = new Handler(Looper.getMainLooper());
  
  public static Metadata.Key<String> a(String paramString) {
    return Metadata.Key.of(paramString, Metadata.ASCII_STRING_MARSHALLER);
  }
  
  public static Metadata a(ConcurrentHashMap<String, String> paramConcurrentHashMap, Metadata paramMetadata, String paramString1, String paramString2) {
    Metadata metadata;
    Iterator<Map.Entry> iterator;
    if (TextUtils.isEmpty(paramString1))
      return paramMetadata; 
    String str = paramString2;
    if (paramString2 == null)
      str = ""; 
    boolean bool = paramConcurrentHashMap.containsKey(paramString1);
    if (bool && ((String)paramConcurrentHashMap.get(paramString1)).equals(str))
      return paramMetadata; 
    paramConcurrentHashMap.put(paramString1, str);
    if (bool) {
      paramMetadata = new Metadata();
      iterator = paramConcurrentHashMap.entrySet().iterator();
      while (true) {
        metadata = paramMetadata;
        if (iterator.hasNext()) {
          Map.Entry entry = iterator.next();
          paramString2 = (String)entry.getValue();
          if (!TextUtils.isEmpty(paramString2))
            paramMetadata.put(a((String)entry.getKey()), paramString2); 
          continue;
        } 
        break;
      } 
    } else {
      metadata = paramMetadata;
      if (str.length() > 0) {
        paramMetadata.put(a((String)iterator), str);
        metadata = paramMetadata;
      } 
    } 
    return metadata;
  }
  
  public static AndroidChannelBuilder a(Context paramContext, String paramString, int paramInt) {
    return AndroidChannelBuilder.usingBuilder((ManagedChannelBuilder)a(paramString, paramInt)).context(paramContext);
  }
  
  public static OkHttpChannelBuilder a(String paramString, int paramInt) {
    OkHttpChannelBuilder okHttpChannelBuilder = (OkHttpChannelBuilder)OkHttpChannelBuilder.forAddress(paramString, paramInt).connectionSpec(ConnectionSpec.MODERN_TLS).directExecutor();
    String str = System.getProperty("http.agent");
    if (!TextUtils.isEmpty(str))
      okHttpChannelBuilder.userAgent(str); 
    return okHttpChannelBuilder;
  }
  
  public static <T extends AbstractStub<T>> T a(T paramT, Metadata paramMetadata) {
    AbstractStub abstractStub;
    T t = paramT;
    if (paramMetadata != null) {
      t = paramT;
      if (paramMetadata.keys().size() > 0)
        abstractStub = MetadataUtils.attachHeaders((AbstractStub)paramT, paramMetadata); 
    } 
    return (T)abstractStub;
  }
  
  public static String a(Throwable paramThrowable) {
    String str2 = "";
    if (paramThrowable == null)
      return ""; 
    Status status = Status.fromThrowable(paramThrowable);
    if (status.getCode() == Status.Code.UNKNOWN)
      return paramThrowable.toString(); 
    Throwable throwable = status.getCause();
    String str3 = status.getDescription();
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append("code=");
    stringBuffer.append(status.getCode());
    stringBuffer.append(", description=");
    String str1 = str3;
    if (str3 == null)
      str1 = ""; 
    stringBuffer.append(str1);
    stringBuffer.append(", cause=");
    if (throwable == null) {
      str1 = str2;
    } else {
      str1 = throwable.toString();
    } 
    stringBuffer.append(str1);
    return stringBuffer.toString();
  }
  
  public static void a(Runnable paramRunnable) {
    a.post(paramRunnable);
  }
  
  public static void a(Runnable paramRunnable, long paramLong) {
    a.postDelayed(paramRunnable, paramLong);
  }
  
  public static String b(String paramString) {
    String str = paramString;
    if (paramString == null)
      str = ""; 
    return str;
  }
  
  public static void b(Runnable paramRunnable) {
    a.removeCallbacks(paramRunnable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\statistic\\util\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */