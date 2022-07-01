package com.bun.miitmdid.b;

import android.content.Context;
import android.os.AsyncTask;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

public class b {
  private static boolean h;
  
  private String a = null;
  
  private b b = null;
  
  private Object c = null;
  
  private Map<String, String> d = new HashMap<String, String>();
  
  private Map<String, String> e = new HashMap<String, String>();
  
  private Map<String, String> f = new HashMap<String, String>();
  
  private String g = "GET";
  
  private b(Context paramContext) {}
  
  public static native b a(Context paramContext);
  
  private native void a(HttpURLConnection paramHttpURLConnection);
  
  private native c b();
  
  private static native void b(String paramString);
  
  private native c c();
  
  private native String d();
  
  public native b a();
  
  public native b a(b paramb);
  
  public native b a(Object paramObject);
  
  public native b a(String paramString);
  
  public native b a(String paramString1, String paramString2);
  
  public native b a(Map<String, String> paramMap);
  
  class a extends AsyncTask<Void, Void, c> {
    b a = this.b;
    
    a(b this$0) {}
    
    protected native b.c a(Void... param1VarArgs);
    
    protected native void a(b.c param1c);
  }
  
  public static interface b {
    void a(Exception param1Exception, int param1Int, String param1String);
  }
  
  class c {
    private String a;
    
    private int b;
    
    private Exception c;
    
    public c(b this$0, String param1String, Exception param1Exception, int param1Int) {
      this.a = param1String;
      this.c = param1Exception;
      this.b = param1Int;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bun\miitmdid\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */