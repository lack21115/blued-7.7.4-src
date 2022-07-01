package a.a.a.a.a.k;

import a.a.a.a.a.e.e;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public final class a {
  public static final Object a = new Object();
  
  public static a b;
  
  public final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> c = new HashMap<BroadcastReceiver, ArrayList<IntentFilter>>();
  
  public final HashMap<String, ArrayList<c>> d = new HashMap<String, ArrayList<c>>();
  
  public final ArrayList<b> e = new ArrayList<b>();
  
  public Context f;
  
  public Handler g;
  
  public HandlerThread h;
  
  public boolean i = false;
  
  public boolean j = false;
  
  public static a a() {
    synchronized (a) {
      if (b == null)
        b = new a(); 
      return b;
    } 
  }
  
  public void a(BroadcastReceiver paramBroadcastReceiver) {
    ArrayList<IntentFilter> arrayList;
    if (this.f != null) {
      synchronized (this.c) {
        arrayList = this.c.remove(paramBroadcastReceiver);
        if (arrayList == null)
          return; 
      } 
    } else {
      throw new IllegalStateException("Context is NULL");
    } 
    for (int i = 0;; i++) {
      if (i < arrayList.size()) {
        IntentFilter intentFilter = arrayList.get(i);
        int j;
        for (j = 0; j < intentFilter.countActions(); j++) {
          String str = intentFilter.getAction(j);
          ArrayList arrayList1 = this.d.get(str);
          if (arrayList1 != null)
            for (int k = 0;; k = m + 1) {
              int m;
              if (k < arrayList1.size()) {
                m = k;
                if (((c)arrayList1.get(k)).b == paramBroadcastReceiver) {
                  arrayList1.remove(k);
                  m = k - 1;
                } 
              } else {
                if (arrayList1.size() <= 0)
                  this.d.remove(str); 
                break;
              } 
            }  
        } 
      } else {
        /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_6} */
        return;
      } 
    } 
  }
  
  public void a(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter) {
    if (this.f == null)
      e.c.e("QosBroadcastManager", "Context is NULL"); 
    synchronized (this.c) {
      c c = new c(paramIntentFilter, paramBroadcastReceiver);
      ArrayList<IntentFilter> arrayList2 = this.c.get(paramBroadcastReceiver);
      ArrayList<IntentFilter> arrayList1 = arrayList2;
      if (arrayList2 == null) {
        arrayList1 = new ArrayList(1);
        this.c.put(paramBroadcastReceiver, arrayList1);
      } 
      arrayList1.add(paramIntentFilter);
      for (int i = 0; i < paramIntentFilter.countActions(); i++) {
        String str = paramIntentFilter.getAction(i);
        arrayList1 = (ArrayList<IntentFilter>)this.d.get(str);
        ArrayList<IntentFilter> arrayList = arrayList1;
        if (arrayList1 == null) {
          arrayList = new ArrayList<IntentFilter>(1);
          this.d.put(str, arrayList);
        } 
        arrayList.add(c);
      } 
      return;
    } 
  }
  
  public void a(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : Ljava/util/HashMap;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnull -> 75
    //   11: aload_0
    //   12: getfield j : Z
    //   15: ifeq -> 21
    //   18: goto -> 75
    //   21: aload_0
    //   22: iconst_1
    //   23: putfield j : Z
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   31: putfield f : Landroid/content/Context;
    //   34: new android/os/HandlerThread
    //   37: dup
    //   38: ldc 'QosBroadcastManager'
    //   40: invokespecial <init> : (Ljava/lang/String;)V
    //   43: astore_1
    //   44: aload_0
    //   45: aload_1
    //   46: putfield h : Landroid/os/HandlerThread;
    //   49: aload_1
    //   50: invokevirtual start : ()V
    //   53: aload_0
    //   54: new a/a/a/a/a/k/a$a
    //   57: dup
    //   58: aload_0
    //   59: aload_0
    //   60: getfield h : Landroid/os/HandlerThread;
    //   63: invokevirtual getLooper : ()Landroid/os/Looper;
    //   66: invokespecial <init> : (La/a/a/a/a/k/a;Landroid/os/Looper;)V
    //   69: putfield g : Landroid/os/Handler;
    //   72: aload_2
    //   73: monitorexit
    //   74: return
    //   75: aload_2
    //   76: monitorexit
    //   77: return
    //   78: astore_1
    //   79: aload_2
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Exception table:
    //   from	to	target	type
    //   11	18	78	finally
    //   21	74	78	finally
    //   75	77	78	finally
    //   79	81	78	finally
  }
  
  public void a(boolean paramBoolean) {
    this.i = paramBoolean;
  }
  
  public boolean a(Intent paramIntent) {
    int i;
    String str1;
    ArrayList<c> arrayList;
    String str2;
    Uri uri;
    String str3;
    Set set;
    synchronized (this.c) {
      if (!this.i || this.f == null || !this.j)
        return false; 
      str1 = paramIntent.getAction();
      str2 = paramIntent.resolveTypeIfNeeded(this.f.getContentResolver());
      uri = paramIntent.getData();
      str3 = paramIntent.getScheme();
      set = paramIntent.getCategories();
      if ((paramIntent.getFlags() & 0x8) != 0) {
        i = 1;
      } else {
        i = 0;
      } 
      if (i) {
        e e1 = e.c;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Resolving type ");
        stringBuilder.append(str2);
        stringBuilder.append(" scheme ");
        stringBuilder.append(str3);
        stringBuilder.append(" of intent ");
        stringBuilder.append(paramIntent);
        e1.a("QosBroadcastManager", stringBuilder.toString());
      } 
      arrayList = this.d.get(paramIntent.getAction());
      if (arrayList != null) {
        if (i) {
          e e1 = e.c;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Action list: ");
          stringBuilder.append(arrayList);
          e1.a("QosBroadcastManager", stringBuilder.toString());
        } 
      } else {
        return false;
      } 
    } 
    e e = null;
    for (int j = 0; j < arrayList.size(); j++) {
      c c = arrayList.get(j);
      if (i) {
        e e1 = e.c;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Matching against filter ");
        stringBuilder.append(c.a);
        e1.a("QosBroadcastManager", stringBuilder.toString());
      } 
      if (c.c) {
        if (i)
          e.c.a("QosBroadcastManager", "  Filter's target already added"); 
      } else {
        IntentFilter intentFilter = c.a;
        e e1 = e;
        int k = intentFilter.match(str1, str2, str3, uri, set, "QosBroadcastManager");
        if (k >= 0) {
          ArrayList<c> arrayList1;
          if (i) {
            e = e.c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("  Filter matched!  match=0x");
            stringBuilder.append(Integer.toHexString(k));
            e.a("QosBroadcastManager", stringBuilder.toString());
          } 
          e = e1;
          if (e1 == null)
            arrayList1 = new ArrayList(); 
          arrayList1.add(c);
          c.c = true;
        } else {
          e = e1;
          if (i) {
            String str;
            if (k != -4) {
              if (k != -3) {
                if (k != -2) {
                  if (k != -1) {
                    str = "unknown reason";
                  } else {
                    str = "type";
                  } 
                } else {
                  str = "data";
                } 
              } else {
                str = "action";
              } 
            } else {
              str = "category";
            } 
            e e2 = e.c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("  Filter did not match: ");
            stringBuilder.append(str);
            e2.a("QosBroadcastManager", stringBuilder.toString());
            e = e1;
          } 
        } 
      } 
    } 
    if (e != null) {
      for (i = 0; i < e.size(); i++)
        ((c)e.get(i)).c = false; 
      this.e.add(new b(paramIntent, (ArrayList<c>)e));
      if (!this.g.hasMessages(1))
        this.g.sendEmptyMessage(1); 
      /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_10} */
      return true;
    } 
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_10} */
    return false;
  }
  
  public void b() {
    synchronized (this.c) {
      if (!this.j)
        return; 
      this.j = false;
      this.h.quit();
      this.h = null;
      return;
    } 
  }
  
  public final void c() {
    while (true) {
      HashMap<BroadcastReceiver, ArrayList<IntentFilter>> hashMap;
      b b;
      synchronized (this.c) {
        int j = this.e.size();
        if (j <= 0)
          return; 
        b[] arrayOfB = new b[j];
        this.e.toArray(arrayOfB);
        this.e.clear();
        for (int i = 0; i < j; i++) {
          b = arrayOfB[i];
          for (int k = 0; k < b.b.size(); k++)
            ((c)b.b.get(k)).b.onReceive(this.f, b.a); 
        } 
      } 
    } 
  }
  
  public class a extends Handler {
    public a(a this$0, Looper param1Looper) {
      super(param1Looper);
    }
    
    public void handleMessage(Message param1Message) {
      if (param1Message.what != 1) {
        super.handleMessage(param1Message);
        return;
      } 
      a.a(this.a);
    }
  }
  
  public static class b {
    public final Intent a;
    
    public final ArrayList<a.c> b;
    
    public b(Intent param1Intent, ArrayList<a.c> param1ArrayList) {
      this.a = param1Intent;
      this.b = param1ArrayList;
    }
  }
  
  public static class c {
    public final IntentFilter a;
    
    public final BroadcastReceiver b;
    
    public boolean c;
    
    public c(IntentFilter param1IntentFilter, BroadcastReceiver param1BroadcastReceiver) {
      this.a = param1IntentFilter;
      this.b = param1BroadcastReceiver;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder(128);
      stringBuilder.append("Receiver{");
      stringBuilder.append(this.b);
      stringBuilder.append(" filter=");
      stringBuilder.append(this.a);
      stringBuilder.append("}");
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\k\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */