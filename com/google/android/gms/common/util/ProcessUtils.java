package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;

public class ProcessUtils {
  private static String zza;
  
  private static int zzb;
  
  @Nullable
  public static String getMyProcessName() {
    if (zza == null) {
      if (zzb == 0)
        zzb = Process.myPid(); 
      zza = zza(zzb);
    } 
    return zza;
  }
  
  private static BufferedReader zza(String paramString) throws IOException {
    StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskReads();
    try {
      return new BufferedReader(new FileReader(paramString));
    } finally {
      StrictMode.setThreadPolicy(threadPolicy);
    } 
  }
  
  @Nullable
  private static String zza(int paramInt) {
    Closeable closeable1;
    Closeable closeable2 = null;
    if (paramInt <= 0)
      return null; 
    try {
      Exception exception;
      StringBuilder stringBuilder = new StringBuilder(25);
      stringBuilder.append("/proc/");
      stringBuilder.append(paramInt);
      stringBuilder.append("/cmdline");
      closeable1 = zza(stringBuilder.toString());
      try {
        return str;
      } catch (IOException null) {
      
      } finally {}
      IOUtils.closeQuietly(closeable1);
      throw exception;
    } catch (IOException iOException) {
    
    } finally {
      closeable1 = closeable2;
      IOUtils.closeQuietly(closeable1);
    } 
    IOUtils.closeQuietly(closeable1);
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\commo\\util\ProcessUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */