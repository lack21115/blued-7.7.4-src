package com.bytedance.tea.crash.e;

import android.os.Build;
import com.bytedance.tea.crash.g.f;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class e {
  private static String a(int paramInt) {
    String[] arrayOfString = new String[6];
    arrayOfString[0] = "*:V";
    arrayOfString[1] = "*:D";
    arrayOfString[2] = "*:I";
    arrayOfString[3] = "*:W";
    arrayOfString[4] = "*:E";
    arrayOfString[5] = "*:F";
    return (paramInt >= 0 && paramInt < arrayOfString.length) ? arrayOfString[paramInt] : "*:V";
  }
  
  public static List<String> a(int paramInt1, int paramInt2) {
    CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList();
    String str = a(paramInt2);
    Process process = null;
    try {
      Process process1 = Runtime.getRuntime().exec(new String[] { "logcat", "-t", String.valueOf(paramInt1), str });
      process = process1;
      (new a(process1.getInputStream(), copyOnWriteArrayList)).start();
      process = process1;
      (new a(process1.getErrorStream(), copyOnWriteArrayList)).start();
      process = process1;
      (new b(process1, 3000L)).start();
      process = process1;
      if (Build.VERSION.SDK_INT >= 26) {
        process = process1;
        process1.waitFor(3000L, TimeUnit.MILLISECONDS);
      } else {
        process = process1;
        process1.waitFor();
      } 
    } finally {
      str = null;
    } 
    process.destroy();
    return copyOnWriteArrayList;
  }
  
  static class a extends Thread {
    private InputStream a;
    
    private List<String> b;
    
    a(InputStream param1InputStream, List<String> param1List) {
      this.a = param1InputStream;
      this.b = param1List;
    }
    
    public void run() {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.a));
      int i = 32768;
      try {
        while (true) {
          String str = bufferedReader.readLine();
          if (str != null) {
            if (str.startsWith("---------"))
              continue; 
            i -= (str.getBytes("UTF-8")).length;
            if (i < 0)
              break; 
            this.b.add(str);
            continue;
          } 
          break;
        } 
      } catch (IOException iOException) {
      
      } finally {
        f.a(bufferedReader);
      } 
      f.a(bufferedReader);
    }
  }
  
  static class b extends Thread {
    private Process a;
    
    private long b;
    
    public b(Process param1Process, long param1Long) {
      this.a = param1Process;
      this.b = param1Long;
    }
    
    public void run() {
      try {
        sleep(this.b);
      } catch (InterruptedException interruptedException) {
        interruptedException.printStackTrace();
      } 
      Process process = this.a;
      if (process != null)
        process.destroy(); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\e\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */