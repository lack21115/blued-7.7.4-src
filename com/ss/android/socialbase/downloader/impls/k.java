package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.b.f;
import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.g.b;
import com.ss.android.socialbase.downloader.g.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class k implements k {
  private final SparseArray<c> a = new SparseArray();
  
  private final SparseArray<List<b>> b = new SparseArray();
  
  public SparseArray<c> a() {
    return this.a;
  }
  
  public c a(int paramInt1, int paramInt2) {
    c c = b(paramInt1);
    if (c != null)
      c.c(paramInt2); 
    return c;
  }
  
  public c a(int paramInt, long paramLong) {
    c c = b(paramInt);
    if (c != null) {
      c.a(paramLong, false);
      if (c.q() != -3 && c.q() != -2 && !f.g(c.q()) && c.q() != -4)
        c.b(4); 
    } 
    return c;
  }
  
  public c a(int paramInt, long paramLong, String paramString1, String paramString2) {
    c c = b(paramInt);
    if (c != null) {
      c.c(paramLong);
      c.b(paramString1);
      if (TextUtils.isEmpty(c.h()) && !TextUtils.isEmpty(paramString2))
        c.c(paramString2); 
      c.b(3);
    } 
    return c;
  }
  
  public List<c> a(String paramString) {
    ArrayList<c> arrayList = new ArrayList();
    SparseArray<c> sparseArray = this.a;
    /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{android/util/SparseArray<ObjectType{com/ss/android/socialbase/downloader/g/c}>}, name=null} */
    try {
      int j = this.a.size();
      for (int i = 0; i < j; i++) {
        c c = (c)this.a.valueAt(i);
        if (paramString != null && paramString.equals(c.j()))
          arrayList.add(c); 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } finally {}
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{android/util/SparseArray<ObjectType{com/ss/android/socialbase/downloader/g/c}>}, name=null} */
    return arrayList;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, long paramLong) {
    List<b> list = c(paramInt1);
    if (list == null)
      return; 
    for (b b : list) {
      if (b != null && b.s() == paramInt3 && !b.f()) {
        if (b.g() == null)
          return; 
        for (b b : b.g()) {
          if (b != null && b.s() == paramInt2) {
            b.b(paramLong);
            break;
          } 
        } 
        break;
      } 
    } 
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong) {
    List<b> list = c(paramInt1);
    if (list == null)
      return; 
    for (b b : list) {
      if (b != null && b.s() == paramInt2) {
        b.b(paramLong);
        break;
      } 
    } 
  }
  
  public void a(int paramInt, List<b> paramList) {
    if (paramList == null)
      return; 
    d(paramInt);
    for (b b : paramList) {
      if (b == null)
        continue; 
      a(b);
      if (b.f()) {
        Iterator<b> iterator = b.g().iterator();
        while (iterator.hasNext())
          a(iterator.next()); 
      } 
    } 
  }
  
  public void a(b paramb) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual k : ()I
    //   6: istore_2
    //   7: aload_0
    //   8: getfield b : Landroid/util/SparseArray;
    //   11: iload_2
    //   12: invokevirtual get : (I)Ljava/lang/Object;
    //   15: checkcast java/util/List
    //   18: astore #4
    //   20: aload #4
    //   22: astore_3
    //   23: aload #4
    //   25: ifnonnull -> 45
    //   28: new java/util/ArrayList
    //   31: dup
    //   32: invokespecial <init> : ()V
    //   35: astore_3
    //   36: aload_0
    //   37: getfield b : Landroid/util/SparseArray;
    //   40: iload_2
    //   41: aload_3
    //   42: invokevirtual put : (ILjava/lang/Object;)V
    //   45: aload_3
    //   46: aload_1
    //   47: invokeinterface add : (Ljava/lang/Object;)Z
    //   52: pop
    //   53: aload_0
    //   54: monitorexit
    //   55: return
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	56	finally
    //   28	45	56	finally
    //   45	53	56	finally
  }
  
  public boolean a(c paramc) {
    boolean bool = true;
    if (paramc == null)
      return true; 
    synchronized (this.a) {
      if (this.a.get(paramc.g()) == null)
        bool = false; 
      this.a.put(paramc.g(), paramc);
      return bool;
    } 
  }
  
  public c b(int paramInt) {
    Exception exception;
    SparseArray<c> sparseArray = this.a;
    /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{android/util/SparseArray<ObjectType{com/ss/android/socialbase/downloader/g/c}>}, name=null} */
    try {
      c c = (c)this.a.get(paramInt);
    } catch (Exception null) {
      exception.printStackTrace();
      exception = null;
    } finally {}
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{android/util/SparseArray<ObjectType{com/ss/android/socialbase/downloader/g/c}>}, name=null} */
    return (c)exception;
  }
  
  public c b(int paramInt, long paramLong) {
    c c = b(paramInt);
    if (c != null) {
      c.a(paramLong, false);
      c.b(-1);
      c.f(false);
    } 
    return c;
  }
  
  public List<c> b(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    synchronized (this.a) {
      if (this.a.size() == 0)
        return null; 
      ArrayList<c> arrayList = new ArrayList();
      for (int i = 0;; i++) {
        if (i < this.a.size()) {
          int j = this.a.keyAt(i);
          c c = (c)this.a.get(j);
          if (c != null && !TextUtils.isEmpty(c.ah()) && c.ah().equals(paramString) && f.g(c.q()))
            arrayList.add(c); 
        } else {
          return arrayList;
        } 
      } 
    } 
  }
  
  public void b() {
    synchronized (this.a) {
      this.a.clear();
      this.b.clear();
      return;
    } 
  }
  
  public void b(int paramInt, List<b> paramList) {}
  
  public void b(b paramb) {}
  
  public void b(c paramc) {
    a(paramc);
  }
  
  public c c(int paramInt, long paramLong) {
    c c = b(paramInt);
    if (c != null) {
      c.a(paramLong, false);
      c.b(-3);
      c.f(false);
      c.g(false);
    } 
    return c;
  }
  
  public List<b> c(int paramInt) {
    return (List<b>)this.b.get(paramInt);
  }
  
  public List<c> c(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    synchronized (this.a) {
      if (this.a.size() == 0)
        return null; 
      ArrayList<c> arrayList = new ArrayList();
      for (int i = 0;; i++) {
        if (i < this.a.size()) {
          int j = this.a.keyAt(i);
          c c = (c)this.a.get(j);
          if (c != null && !TextUtils.isEmpty(c.ah()) && c.ah().equals(paramString) && c.q() == -3)
            arrayList.add(c); 
        } else {
          return arrayList;
        } 
      } 
    } 
  }
  
  public boolean c() {
    return false;
  }
  
  public c d(int paramInt, long paramLong) {
    c c = b(paramInt);
    if (c != null) {
      c.a(paramLong, false);
      c.b(-2);
    } 
    return c;
  }
  
  public List<c> d(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    synchronized (this.a) {
      if (this.a.size() == 0)
        return null; 
      ArrayList<c> arrayList = new ArrayList();
      for (int i = 0;; i++) {
        if (i < this.a.size()) {
          int j = this.a.keyAt(i);
          c c = (c)this.a.get(j);
          if (c != null && !TextUtils.isEmpty(c.ah()) && c.ah().equals(paramString) && f.f(c.q()))
            arrayList.add(c); 
        } else {
          return arrayList;
        } 
      } 
    } 
  }
  
  public void d(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Landroid/util/SparseArray;
    //   6: iload_1
    //   7: invokevirtual remove : (I)V
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: astore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_2
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	13	finally
  }
  
  public boolean d() {
    return false;
  }
  
  public SparseArray<List<b>> e() {
    return this.b;
  }
  
  public boolean e(int paramInt) {
    synchronized (this.a) {
      this.a.remove(paramInt);
      return true;
    } 
  }
  
  public boolean f(int paramInt) {
    e(paramInt);
    d(paramInt);
    return true;
  }
  
  public c g(int paramInt) {
    c c = b(paramInt);
    if (c != null)
      c.b(2); 
    return c;
  }
  
  public c h(int paramInt) {
    c c = b(paramInt);
    if (c != null) {
      c.b(5);
      c.f(false);
    } 
    return c;
  }
  
  public c i(int paramInt) {
    c c = b(paramInt);
    if (c != null)
      c.b(1); 
    return c;
  }
  
  public c j(int paramInt) {
    c c = b(paramInt);
    if (c != null)
      c.b(-7); 
    return c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\impls\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */