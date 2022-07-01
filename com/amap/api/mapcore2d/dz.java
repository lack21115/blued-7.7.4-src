package com.amap.api.mapcore2d;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import java.io.RandomAccessFile;

public class dz implements et.a {
  protected ea a;
  
  protected da b;
  
  protected String c;
  
  protected RandomAccessFile d;
  
  protected Context e;
  
  private et f;
  
  public dz(Context paramContext, ea paramea, da paramda) {
    try {
      this.e = paramContext.getApplicationContext();
      this.b = paramda;
      if (paramea == null)
        return; 
      this.a = paramea;
      return;
    } finally {
      paramContext = null;
      eh.a((Throwable)paramContext, "dDownLoad", "DexDownLoad()");
    } 
  }
  
  private void a(Context paramContext, String paramString) {
    try {
      SharedPreferences.Editor editor = paramContext.getSharedPreferences(paramString, 0).edit();
      return;
    } finally {
      paramContext = null;
      eh.a((Throwable)paramContext, "dDownLoad", "clearMarker()");
    } 
  }
  
  private void a(String paramString) {
    String str = this.a.c();
    dt dt = new dt(this.e, ed.c());
    eb.a.a(dt, (new ee.a(this.a.b, paramString, this.a.c, str, this.a.e)).a("copy").a(), ee.a(this.a.b, this.a.c, str, this.a.e));
    a(this.e, this.a.c);
    try {
      return;
    } finally {
      paramString = null;
      eh.a((Throwable)paramString, "dDownLoad", "onFinish1");
    } 
  }
  
  public void a() {
    try {
      return;
    } finally {
      Exception exception = null;
      eh.a(exception, "dDownLoad", "startDownload()");
    } 
  }
  
  public void a(Throwable paramThrowable) {
    try {
      return;
    } finally {
      paramThrowable = null;
      paramThrowable.printStackTrace();
    } 
  }
  
  public void a(byte[] paramArrayOfbyte, long paramLong) {
    try {
      if (this.d == null) {
        File file1 = new File(this.c);
        File file2 = file1.getParentFile();
        if (!file2.exists())
          file2.mkdirs(); 
        this.d = new RandomAccessFile(file1, "rw");
      } 
      return;
    } finally {
      paramArrayOfbyte = null;
      eh.a((Throwable)paramArrayOfbyte, "dDownLoad", "onDownload()");
    } 
  }
  
  public void b() {}
  
  public void c() {
    try {
      if (this.d == null)
        return; 
      eh.a(this.d);
      String str = this.a.b();
    } finally {
      Exception exception = null;
      eh.a(exception, "dDownLoad", "onFinish()");
    } 
  }
  
  boolean d() {
    boolean bool;
    ea ea1 = this.a;
    if (ea1 != null && ea1.d()) {
      bool = true;
    } else {
      bool = false;
    } 
    try {
      return false;
    } finally {
      ea1 = null;
      eh.a((Throwable)ea1, "dDownLoad", "isNeedDownload()");
    } 
  }
  
  class a implements Runnable {
    private int b;
    
    private dt c;
    
    private String d;
    
    a(dz this$0, int param1Int) {
      this.b = param1Int;
    }
    
    a(dz this$0, dt param1dt, int param1Int) {
      this.b = param1Int;
      this.c = param1dt;
    }
    
    public void run() {
      int i = this.b;
      if (i != 0) {
        if (i != 1 && i != 2) {
          if (i != 3)
            return; 
          try {
            return;
          } finally {
            Exception exception = null;
            eh.a(exception, "dDownLoad", "processDownloadedFile()");
          } 
        } 
        try {
          return;
        } finally {
          Exception exception = null;
          eh.a(exception, "dDownLoad", "onFinish2");
        } 
      } 
      try {
        if (this.a.d()) {
          ff ff = new ff(this.a.e, this.a.b.a(), this.a.b.b(), "O008");
          ff.a("{\"param_int_first\":0}");
          fg.a(ff, this.a.e);
          return;
        } 
      } finally {
        Exception exception = null;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\dz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */