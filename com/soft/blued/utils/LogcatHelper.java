package com.soft.blued.utils;

import android.util.Log;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogcatHelper {
  private static LogcatHelper a;
  
  public static String a() {
    return (new SimpleDateFormat("yyyy-MM-dd HH-mm-ss")).format(new Date(System.currentTimeMillis()));
  }
  
  class LogDumper extends Thread {
    String a;
    
    private Process b;
    
    private BufferedReader c;
    
    private boolean d;
    
    private String e;
    
    private FileOutputStream f;
    
    public void run() {
      try {
        this.b = Runtime.getRuntime().exec(this.a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("logcatProc:");
        stringBuilder.append(this.b.toString());
        Log.v("pk", stringBuilder.toString());
        this.c = new BufferedReader(new InputStreamReader(this.b.getInputStream()), 1024);
        while (this.d) {
          String str = this.c.readLine();
          if (str == null || !this.d)
            break; 
          if (str.length() != 0 && this.f != null && str.contains(this.e)) {
            FileOutputStream fileOutputStream1 = this.f;
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(LogcatHelper.a());
            stringBuilder1.append("  ");
            stringBuilder1.append(str);
            stringBuilder1.append("\n");
            fileOutputStream1.write(stringBuilder1.toString().getBytes());
          } 
        } 
        Process process = this.b;
        if (process != null) {
          process.destroy();
          this.b = null;
        } 
        BufferedReader bufferedReader = this.c;
        if (bufferedReader != null)
          try {
            bufferedReader.close();
            this.c = null;
          } catch (IOException iOException) {
            iOException.printStackTrace();
          }  
        FileOutputStream fileOutputStream = this.f;
        if (fileOutputStream != null) {
          try {
            fileOutputStream.close();
          } catch (IOException iOException) {
            iOException.printStackTrace();
          } 
        } else {
          return;
        } 
      } catch (IOException iOException) {
        iOException.printStackTrace();
        Process process = this.b;
        if (process != null) {
          process.destroy();
          this.b = null;
        } 
        BufferedReader bufferedReader = this.c;
        if (bufferedReader != null)
          try {
            bufferedReader.close();
            this.c = null;
          } catch (IOException iOException1) {
            iOException1.printStackTrace();
          }  
        FileOutputStream fileOutputStream = this.f;
        if (fileOutputStream != null) {
          try {
            fileOutputStream.close();
          } catch (IOException iOException1) {
            iOException1.printStackTrace();
          } 
        } else {
          return;
        } 
      } finally {
        Exception exception;
      } 
      this.f = null;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\LogcatHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */