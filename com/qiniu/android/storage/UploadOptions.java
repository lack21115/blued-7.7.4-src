package com.qiniu.android.storage;

import android.os.Looper;
import android.util.Log;
import com.qiniu.android.utils.AndroidNetwork;
import java.util.HashMap;
import java.util.Map;

public final class UploadOptions {
  final UpCancellationSignal cancellationSignal;
  
  final boolean checkCrc;
  
  final String mimeType;
  
  final NetReadyHandler netReadyHandler;
  
  final Map<String, String> params;
  
  final UpProgressHandler progressHandler;
  
  public UploadOptions(Map<String, String> paramMap, String paramString, boolean paramBoolean, UpProgressHandler paramUpProgressHandler, UpCancellationSignal paramUpCancellationSignal) {
    this(paramMap, paramString, paramBoolean, paramUpProgressHandler, paramUpCancellationSignal, null);
  }
  
  public UploadOptions(Map<String, String> paramMap, String paramString, boolean paramBoolean, UpProgressHandler paramUpProgressHandler, UpCancellationSignal paramUpCancellationSignal, NetReadyHandler paramNetReadyHandler) {
    final byte finalNetReadyCheckTime;
    byte b2 = 6;
    try {
      String str = paramMap.get("netCheckTime");
      b1 = b2;
      if (str != null)
        b1 = Integer.parseInt(str); 
    } catch (Exception exception) {
      exception.printStackTrace();
      b1 = b2;
    } 
    this.params = filterParam(paramMap);
    this.mimeType = mime(paramString);
    this.checkCrc = paramBoolean;
    if (paramUpProgressHandler == null)
      paramUpProgressHandler = new UpProgressHandler() {
          public void progress(String param1String, double param1Double) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(param1Double);
            Log.d("Qiniu.UploadProgress", stringBuilder.toString());
          }
        }; 
    this.progressHandler = paramUpProgressHandler;
    if (paramUpCancellationSignal == null)
      paramUpCancellationSignal = new UpCancellationSignal() {
          public boolean isCancelled() {
            return false;
          }
        }; 
    this.cancellationSignal = paramUpCancellationSignal;
    if (paramNetReadyHandler == null)
      paramNetReadyHandler = new NetReadyHandler() {
          public void waitReady() {
            if (Thread.currentThread() == Looper.getMainLooper().getThread())
              return; 
            for (int i = 0; i < finalNetReadyCheckTime; i++) {
              try {
                Thread.sleep(500L);
              } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
              } 
              if (AndroidNetwork.isNetWorkReady())
                return; 
            } 
          }
        }; 
    this.netReadyHandler = paramNetReadyHandler;
  }
  
  static UploadOptions defaultOptions() {
    return new UploadOptions(null, null, false, null, null);
  }
  
  private static Map<String, String> filterParam(Map<String, String> paramMap) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramMap == null)
      return (Map)hashMap; 
    for (Map.Entry<String, String> entry : paramMap.entrySet()) {
      if (((String)entry.getKey()).startsWith("x:") && entry.getValue() != null && !((String)entry.getValue()).equals(""))
        hashMap.put(entry.getKey(), entry.getValue()); 
    } 
    return (Map)hashMap;
  }
  
  private static String mime(String paramString) {
    return (paramString == null || paramString.equals("")) ? "application/octet-stream" : paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\storage\UploadOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */