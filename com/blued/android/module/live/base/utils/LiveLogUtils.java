package com.blued.android.module.live.base.utils;

import com.blued.android.core.AppMethods;
import com.blued.android.framework.pool.ThreadManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class LiveLogUtils {
  public static String a() {
    return "audio_log.txt";
  }
  
  public static void a(String paramString1, String paramString2) {
    ThreadManager.a().b(new Runnable(paramString2, paramString1) {
          public void run() {
            Exception exception;
            try {
              File file = new File(LiveLogUtils.b());
              if (!file.exists() && !file.mkdirs())
                return; 
              file = new File(file, this.a);
              boolean bool = file.exists();
              if (!bool) {
                try {
                  file.createNewFile();
                } catch (IOException iOException) {
                  iOException.printStackTrace();
                } 
              } else {
                long l = file.length();
                if (l > 102400L)
                  try {
                    if (file.delete())
                      file.createNewFile(); 
                  } catch (IOException iOException) {
                    iOException.printStackTrace();
                  }  
              } 
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("\r\n");
              stringBuilder.append(LiveTimeAndDateUtils.b(System.currentTimeMillis()));
              stringBuilder.append(" ::::: ");
              stringBuilder.append(this.b);
              String str = stringBuilder.toString();
              FileOutputStream fileOutputStream = new FileOutputStream(file, true);
              try {
                fileOutputStream.write(str.getBytes());
                fileOutputStream.close();
                return;
              } catch (Exception null) {
              
              } finally {}
            } catch (Exception null) {
            
            } finally {}
            exception.printStackTrace();
          }
        });
  }
  
  public static String b() {
    return AppMethods.a("LiveLog");
  }
  
  public static String c() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(b());
    stringBuilder.append("/");
    stringBuilder.append(a());
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\bas\\utils\LiveLogUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */