package com.bytedance.tea.crash.a;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import android.util.Printer;
import com.bytedance.tea.crash.e.c;
import com.bytedance.tea.crash.e.f;
import com.bytedance.tea.crash.e.h;
import com.bytedance.tea.crash.g.j;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g {
  public static long a = 0L;
  
  public static long b = 0L;
  
  private static boolean c = false;
  
  private static boolean d = true;
  
  private static int e;
  
  private static List<a> f;
  
  private static volatile AtomicLong g = new AtomicLong(-1L);
  
  private static long h = 100L;
  
  private static long i;
  
  private static HandlerThread j;
  
  private static long k;
  
  private static long l;
  
  private static Handler m;
  
  private static int n;
  
  private static boolean o;
  
  private static volatile String p = null;
  
  private static volatile boolean q = false;
  
  private static int r = -1;
  
  private static int s;
  
  private static MessageQueue t;
  
  private static Field u;
  
  private static Field v;
  
  static {
    a = -1L;
    b = -1L;
    s = -1;
    t = null;
    u = null;
    v = null;
  }
  
  private static Message a(Message paramMessage) {
    StringBuilder stringBuilder;
    Field field = v;
    if (field == null)
      try {
        v = Class.forName("android.os.Message").getDeclaredField("next");
        v.setAccessible(true);
        paramMessage = (Message)v.get(paramMessage);
        if (c) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("[getNextMessage] success get next msg :");
          stringBuilder.append(paramMessage);
          Log.i("LooperMonitor", stringBuilder.toString());
        } 
        return paramMessage;
      } catch (Exception exception) {
        return null;
      }  
    try {
      return (Message)stringBuilder.get(exception);
    } catch (Exception exception1) {
      return null;
    } 
  }
  
  private static Message a(MessageQueue paramMessageQueue) {
    Field field = u;
    if (field == null)
      try {
        u = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");
        u.setAccessible(true);
        return (Message)u.get(paramMessageQueue);
      } catch (Exception exception) {
        return null;
      }  
    try {
      return (Message)field.get(exception);
    } catch (Exception exception1) {
      return null;
    } 
  }
  
  public static JSONArray a(int paramInt, long paramLong) {
    // Byte code:
    //   0: invokestatic d : ()Landroid/os/MessageQueue;
    //   3: astore #6
    //   5: new org/json/JSONArray
    //   8: dup
    //   9: invokespecial <init> : ()V
    //   12: astore #7
    //   14: aload #6
    //   16: ifnonnull -> 22
    //   19: aload #7
    //   21: areturn
    //   22: aload #6
    //   24: monitorenter
    //   25: aload #6
    //   27: invokestatic a : (Landroid/os/MessageQueue;)Landroid/os/Message;
    //   30: astore #5
    //   32: aload #5
    //   34: ifnonnull -> 118
    //   37: aload #6
    //   39: monitorexit
    //   40: aload #7
    //   42: areturn
    //   43: aload #5
    //   45: ifnull -> 99
    //   48: iload_3
    //   49: iload_0
    //   50: if_icmpge -> 99
    //   53: iload_3
    //   54: iconst_1
    //   55: iadd
    //   56: istore_3
    //   57: iload #4
    //   59: iconst_1
    //   60: iadd
    //   61: istore #4
    //   63: aload #5
    //   65: lload_1
    //   66: invokestatic a : (Landroid/os/Message;J)Lorg/json/JSONObject;
    //   69: astore #8
    //   71: aload #8
    //   73: ldc 'id'
    //   75: iload #4
    //   77: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   80: pop
    //   81: aload #7
    //   83: aload #8
    //   85: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   88: pop
    //   89: aload #5
    //   91: invokestatic a : (Landroid/os/Message;)Landroid/os/Message;
    //   94: astore #5
    //   96: goto -> 43
    //   99: aload #6
    //   101: monitorexit
    //   102: aload #7
    //   104: areturn
    //   105: astore #5
    //   107: aload #6
    //   109: monitorexit
    //   110: aload #5
    //   112: athrow
    //   113: astore #9
    //   115: goto -> 81
    //   118: iconst_0
    //   119: istore_3
    //   120: iconst_0
    //   121: istore #4
    //   123: goto -> 43
    // Exception table:
    //   from	to	target	type
    //   25	32	105	finally
    //   37	40	105	finally
    //   63	71	105	finally
    //   71	81	113	org/json/JSONException
    //   71	81	105	finally
    //   81	96	105	finally
    //   99	102	105	finally
    //   107	110	105	finally
  }
  
  public static JSONObject a(long paramLong) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("message", p);
      jSONObject.put("currentMessageCost", e());
      return jSONObject;
    } finally {
      Exception exception = null;
      j.a(exception);
    } 
  }
  
  private static JSONObject a(Message paramMessage, long paramLong) {
    JSONObject jSONObject = new JSONObject();
    if (paramMessage == null)
      return jSONObject; 
    try {
      jSONObject.put("when", paramMessage.getWhen() - paramLong);
      if (paramMessage.getCallback() != null)
        jSONObject.put("callback", paramMessage.getCallback()); 
      jSONObject.put("what", paramMessage.what);
      if (paramMessage.getTarget() != null) {
        jSONObject.put("target", paramMessage.getTarget());
      } else {
        jSONObject.put("barrier", paramMessage.arg1);
      } 
      jSONObject.put("arg1", paramMessage.arg1);
      jSONObject.put("arg2", paramMessage.arg2);
      if (paramMessage.obj != null) {
        jSONObject.put("obj", paramMessage.obj);
        return jSONObject;
      } 
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
    } 
    return jSONObject;
  }
  
  public static void a() {
    com.bytedance.tea.crash.e.g.a(4L);
    f.a().b();
    f.a().b(new Printer() {
          public void println(String param1String) {
            boolean bool;
            if (!g.f())
              return; 
            g.a(param1String);
            if (!g.g()) {
              g.a(true);
              g.a(Process.myTid());
              g.h();
            } 
            g.a = g.i().get();
            if (g.b == -1L)
              return; 
            long l1 = g.a - g.b;
            if (l1 <= 0L) {
              g.j();
              return;
            } 
            if (l1 == 1L) {
              if (g.k() > 1) {
                bool = true;
              } else if (g.k() == 1) {
                bool = true;
              } else {
                bool = false;
              } 
            } else if (g.k() > 1) {
              bool = true;
            } else if (g.k() == 1) {
              bool = true;
            } else {
              bool = true;
            } 
            long l2 = g.l();
            long l3 = SystemClock.uptimeMillis();
            if (!g.m())
              g.a(g.n(), l2 - g.o(), l3 - g.p(), l1, bool, g.k(), null); 
            g.b(l2);
            g.c(l3);
            g.b(1);
          }
        });
    f.a().a(new Printer() {
          public void println(String param1String) {
            g.b = g.i().get();
            if (g.a <= 0L)
              return; 
            long l1 = g.b - g.a;
            if (l1 <= 0L)
              return; 
            long l2 = g.l();
            long l3 = SystemClock.uptimeMillis();
            int i = l1 cmp 1L;
            if (i == 0 && g.k() > 1) {
              i = 9;
            } else if (i == 0 && g.k() == 1) {
              i = 2;
            } else if (i > 0 && g.k() > 1) {
              i = 4;
            } else if (i > 0 && g.k() == 1) {
              i = 8;
            } else {
              i = 0;
            } 
            if (!g.m())
              g.a(g.n(), l2 - g.o(), l3 - g.p(), l1, i, g.k(), param1String); 
            g.b(l2);
            g.c(l3);
            g.b(0);
            g.a = -1L;
          }
        });
    k = v();
    l = SystemClock.uptimeMillis();
  }
  
  public static void a(int paramInt1, int paramInt2) {
    if (!d)
      return; 
    if (paramInt1 > 10)
      e = paramInt1; 
    if (paramInt2 > 10)
      h = paramInt2; 
    f = new ArrayList<a>();
    a();
    a(d());
  }
  
  public static JSONArray b() {
    JSONArray jSONArray = new JSONArray();
    List<a> list = c();
    if (list == null)
      return jSONArray; 
    int i = 0;
    for (a a : list) {
      if (a == null)
        continue; 
      i++;
      JSONObject jSONObject = new JSONObject();
      try {
        jSONObject.put("msg", a.g);
        jSONObject.put("cpuDuration", a.e);
        jSONObject.put("duration", a.d);
        jSONObject.put("tick", a.c);
        jSONObject.put("type", a.b);
        jSONObject.put("count", a.a);
        jSONObject.put("id", i);
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
      jSONArray.put(jSONObject);
    } 
    return jSONArray;
  }
  
  private static void b(a parama, long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, String paramString) {
    parama.e = paramLong1;
    parama.c = paramLong3;
    parama.d = paramLong2;
    parama.f = false;
    parama.a = paramInt2;
    if (paramString != null)
      parama.g = paramString; 
    parama.b = paramInt1;
  }
  
  public static List<a> c() {
    if (f == null)
      return null; 
    q = true;
    ArrayList<a> arrayList = new ArrayList();
    if (f.size() == e) {
      int i;
      for (i = s; i < f.size(); i++)
        arrayList.add(f.get(i)); 
      for (i = 0; i < s; i++)
        arrayList.add(f.get(i)); 
    } else {
      arrayList.addAll(f);
    } 
    q = false;
    return arrayList;
  }
  
  public static MessageQueue d() {
    if (t == null && Looper.getMainLooper() != null) {
      Looper looper = Looper.getMainLooper();
      if (looper == Looper.myLooper()) {
        t = Looper.myQueue();
      } else if (Build.VERSION.SDK_INT >= 23) {
        t = looper.getQueue();
      } else {
        try {
          Field field = looper.getClass().getDeclaredField("mQueue");
          field.setAccessible(true);
          t = (MessageQueue)field.get(looper);
        } finally {
          looper = null;
        } 
      } 
    } 
    return t;
  }
  
  public static long e() {
    if (a < 0L) {
      long l4 = SystemClock.uptimeMillis() - i;
      long l5 = b;
      long l6 = h;
      return l4 - l5 * l6;
    } 
    long l1 = SystemClock.uptimeMillis() - i;
    long l2 = a;
    long l3 = h;
    return l1 - l2 * l3;
  }
  
  private static a t() {
    int i = f.size();
    int j = e;
    if (i == j) {
      s = (s + 1) % j;
      return f.get(s);
    } 
    a a = new a();
    f.add(a);
    s++;
    return a;
  }
  
  private static void u() {
    j = h.a();
    i = SystemClock.uptimeMillis();
    m = new Handler(j.getLooper());
    com.bytedance.tea.crash.e.g.a(8L);
    m.postDelayed(new Runnable() {
          public void run() {
            long l1 = SystemClock.uptimeMillis();
            g.i().set((l1 - g.q()) / g.r());
            long l2 = (SystemClock.uptimeMillis() - g.q()) % g.r();
            if (l2 >= 95L) {
              g.i().incrementAndGet();
              l1 = g.r() << 1L;
            } else {
              l1 = g.r();
            } 
            g.s().postDelayed(this, l1 - l2);
          }
        }h);
  }
  
  private static long v() {
    return c.a(r);
  }
  
  public static class a {
    public int a;
    
    public int b;
    
    public long c;
    
    public long d;
    
    public long e;
    
    public boolean f;
    
    public String g;
    
    public String toString() {
      int i = this.b;
      if (i == 0) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("[[[ IDLE  ]]] cost ");
        stringBuilder1.append(this.c);
        stringBuilder1.append(" tick , mDuration：");
        stringBuilder1.append(this.d);
        stringBuilder1.append(",cpuTime:");
        stringBuilder1.append(this.e);
        return stringBuilder1.toString();
      } 
      if (i == 1) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("[[[ Long IDLE  ]]] cost ");
        stringBuilder1.append(this.c);
        stringBuilder1.append(" tick , mDuration：");
        stringBuilder1.append(this.d);
        stringBuilder1.append(",cpuTime:");
        stringBuilder1.append(this.e);
        return stringBuilder1.toString();
      } 
      if (i == 2) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("[[[  1 msg  ]]] cost ");
        stringBuilder1.append(this.c);
        stringBuilder1.append(" tick , mDuration：");
        stringBuilder1.append(this.d);
        stringBuilder1.append(",cpuTime:");
        stringBuilder1.append(this.e);
        stringBuilder1.append(", msg:");
        stringBuilder1.append(this.g);
        return stringBuilder1.toString();
      } 
      if (i == 3) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("[[[ 1 msg + IDLE  ]]] cost ");
        stringBuilder1.append(this.c);
        stringBuilder1.append(" tick , mDuration：");
        stringBuilder1.append(this.d);
        stringBuilder1.append(",cpuTime:");
        stringBuilder1.append(this.e);
        return stringBuilder1.toString();
      } 
      if (i == 4) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("[[[ ");
        stringBuilder1.append(this.a - 1);
        stringBuilder1.append(" msgs  ]]] cost less than 1 tick, [[[  last msg ]]] cost more than ");
        stringBuilder1.append(this.c - 1L);
        stringBuilder1.append("tick ,, mDuration：");
        stringBuilder1.append(this.d);
        stringBuilder1.append("cpuTime:");
        stringBuilder1.append(this.e);
        stringBuilder1.append(" msg:");
        stringBuilder1.append(this.g);
        return stringBuilder1.toString();
      } 
      if (i == 5) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("[[[ ");
        stringBuilder1.append(this.a);
        stringBuilder1.append(" msgs ]]] cost less than 1 tick but [[[  IDLE ]]] cost more than");
        stringBuilder1.append(this.c - 1L);
        stringBuilder1.append(" ticks, , mDuration：");
        stringBuilder1.append(this.d);
        stringBuilder1.append("cpuTime:");
        stringBuilder1.append(this.e);
        return stringBuilder1.toString();
      } 
      if (i == 6) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("[[[  1 msg  ]]] cost less than 1 tick , but [[[  IDLE ]]] cost more than");
        stringBuilder1.append(this.c - 1L);
        stringBuilder1.append(", , mDuration：");
        stringBuilder1.append(this.d);
        stringBuilder1.append("cpuTime:");
        stringBuilder1.append(this.e);
        return stringBuilder1.toString();
      } 
      if (i == 7) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("[[[ ");
        stringBuilder1.append(this.a);
        stringBuilder1.append(" msgs + IDLE  ]]] cost 1 tick , mDuration：");
        stringBuilder1.append(this.d);
        stringBuilder1.append(" cost cpuTime:");
        stringBuilder1.append(this.e);
        return stringBuilder1.toString();
      } 
      if (i == 8) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("[[[ 1 msgs ]]] cost ");
        stringBuilder1.append(this.c);
        stringBuilder1.append(" ticks , mDuration：");
        stringBuilder1.append(this.d);
        stringBuilder1.append(" cost cpuTime:");
        stringBuilder1.append(this.e);
        stringBuilder1.append(" msg:");
        stringBuilder1.append(this.g);
        return stringBuilder1.toString();
      } 
      if (i == 9) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("[[[ ");
        stringBuilder1.append(this.a);
        stringBuilder1.append(" msgs ]]] cost 1 tick , mDuration：");
        stringBuilder1.append(this.d);
        stringBuilder1.append(" cost cpuTime:");
        stringBuilder1.append(this.e);
        return stringBuilder1.toString();
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("=========   UNKNOW =========  Type:");
      stringBuilder.append(this.b);
      stringBuilder.append(" cost ticks ");
      stringBuilder.append(this.c);
      stringBuilder.append(" msgs:");
      stringBuilder.append(this.a);
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\crash\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */