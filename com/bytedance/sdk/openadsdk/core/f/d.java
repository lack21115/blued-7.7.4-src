package com.bytedance.sdk.openadsdk.core.f;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ab;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class d {
  private static final String a = d.class.getSimpleName();
  
  private static d e = null;
  
  private static final Map<String, Integer> f = new HashMap<String, Integer>();
  
  private final Set<String> b = new HashSet<String>(1);
  
  private final List<WeakReference<e>> c = new ArrayList<WeakReference<e>>(1);
  
  private final List<e> d = new ArrayList<e>(1);
  
  static {
    f.put("android.permission.ACCESS_COARSE_LOCATION", Integer.valueOf(ab.b(o.a(), "tt_request_permission_descript_location")));
    f.put("android.permission.ACCESS_FINE_LOCATION", Integer.valueOf(ab.b(o.a(), "tt_request_permission_descript_location")));
    f.put("android.permission.READ_PHONE_STATE", Integer.valueOf(ab.b(o.a(), "tt_request_permission_descript_read_phone_state")));
    f.put("android.permission.WRITE_EXTERNAL_STORAGE", Integer.valueOf(ab.b(o.a(), "tt_request_permission_descript_external_storage")));
    if (Build.VERSION.SDK_INT >= 16)
      f.put("android.permission.READ_EXTERNAL_STORAGE", Integer.valueOf(ab.b(o.a(), "tt_request_permission_descript_external_storage"))); 
  }
  
  private d() {
    b();
  }
  
  public static d a() {
    if (e == null)
      e = new d(); 
    return e;
  }
  
  private void a(e parame) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield c : Ljava/util/List;
    //   6: invokeinterface iterator : ()Ljava/util/Iterator;
    //   11: astore_2
    //   12: aload_2
    //   13: invokeinterface hasNext : ()Z
    //   18: ifeq -> 55
    //   21: aload_2
    //   22: invokeinterface next : ()Ljava/lang/Object;
    //   27: checkcast java/lang/ref/WeakReference
    //   30: astore_3
    //   31: aload_3
    //   32: invokevirtual get : ()Ljava/lang/Object;
    //   35: aload_1
    //   36: if_acmpeq -> 46
    //   39: aload_3
    //   40: invokevirtual get : ()Ljava/lang/Object;
    //   43: ifnonnull -> 12
    //   46: aload_2
    //   47: invokeinterface remove : ()V
    //   52: goto -> 12
    //   55: aload_0
    //   56: getfield d : Ljava/util/List;
    //   59: invokeinterface iterator : ()Ljava/util/Iterator;
    //   64: astore_2
    //   65: aload_2
    //   66: invokeinterface hasNext : ()Z
    //   71: ifeq -> 96
    //   74: aload_2
    //   75: invokeinterface next : ()Ljava/lang/Object;
    //   80: checkcast com/bytedance/sdk/openadsdk/core/f/e
    //   83: aload_1
    //   84: if_acmpne -> 65
    //   87: aload_2
    //   88: invokeinterface remove : ()V
    //   93: goto -> 65
    //   96: aload_0
    //   97: monitorexit
    //   98: return
    //   99: astore_1
    //   100: aload_0
    //   101: monitorexit
    //   102: aload_1
    //   103: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	99	finally
    //   12	46	99	finally
    //   46	52	99	finally
    //   55	65	99	finally
    //   65	93	99	finally
  }
  
  private void a(String[] paramArrayOfString, e parame) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnonnull -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_2
    //   10: aload_1
    //   11: invokevirtual a : ([Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield d : Ljava/util/List;
    //   18: aload_2
    //   19: invokeinterface add : (Ljava/lang/Object;)Z
    //   24: pop
    //   25: aload_0
    //   26: getfield c : Ljava/util/List;
    //   29: new java/lang/ref/WeakReference
    //   32: dup
    //   33: aload_2
    //   34: invokespecial <init> : (Ljava/lang/Object;)V
    //   37: invokeinterface add : (Ljava/lang/Object;)Z
    //   42: pop
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Exception table:
    //   from	to	target	type
    //   9	43	46	finally
  }
  
  private void a(String[] paramArrayOfString1, int[] paramArrayOfint, String[] paramArrayOfString2) {
    try {
      int j = paramArrayOfString1.length;
      int i = j;
      if (paramArrayOfint.length < j)
        i = paramArrayOfint.length; 
      Iterator<WeakReference<e>> iterator = this.c.iterator();
      while (true) {
        if (iterator.hasNext()) {
          e e = ((WeakReference<e>)iterator.next()).get();
          for (j = 0; j < i; j++) {
            if (e == null || e.a(paramArrayOfString1[j], paramArrayOfint[j])) {
              iterator.remove();
              break;
            } 
          } 
          continue;
        } 
        Iterator<e> iterator1 = this.d.iterator();
        return;
      } 
    } finally {
      paramArrayOfString1 = null;
    } 
  }
  
  private void b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc android/Manifest$permission
    //   4: invokevirtual getFields : ()[Ljava/lang/reflect/Field;
    //   7: astore #4
    //   9: aload #4
    //   11: arraylength
    //   12: istore_2
    //   13: iconst_0
    //   14: istore_1
    //   15: iload_1
    //   16: iload_2
    //   17: if_icmpge -> 69
    //   20: aload #4
    //   22: iload_1
    //   23: aaload
    //   24: astore_3
    //   25: aload_3
    //   26: ldc ''
    //   28: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast java/lang/String
    //   34: astore_3
    //   35: goto -> 51
    //   38: astore_3
    //   39: getstatic com/bytedance/sdk/openadsdk/core/f/d.a : Ljava/lang/String;
    //   42: ldc 'Could not access field'
    //   44: aload_3
    //   45: invokestatic e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   48: pop
    //   49: aconst_null
    //   50: astore_3
    //   51: aload_0
    //   52: getfield b : Ljava/util/Set;
    //   55: aload_3
    //   56: invokeinterface add : (Ljava/lang/Object;)Z
    //   61: pop
    //   62: iload_1
    //   63: iconst_1
    //   64: iadd
    //   65: istore_1
    //   66: goto -> 15
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: astore_3
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_3
    //   76: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	72	finally
    //   25	35	38	java/lang/IllegalAccessException
    //   25	35	72	finally
    //   39	49	72	finally
    //   51	62	72	finally
  }
  
  private void b(Activity paramActivity, String[] paramArrayOfString, e parame) {
    int j = paramArrayOfString.length;
    int i;
    for (i = 0; i < j; i++) {
      String str = paramArrayOfString[i];
      if (parame != null)
        try {
          boolean bool;
          if (!this.b.contains(str)) {
            bool = parame.a(str, c.c);
          } else if (b.a((Context)paramActivity, str) != 0) {
            bool = parame.a(str, c.b);
          } else {
            bool = parame.a(str, c.a);
          } 
        } finally {
          str = null;
        }  
    } 
    a(parame);
  }
  
  private List<String> c(Activity paramActivity, String[] paramArrayOfString, e parame) {
    ArrayList<String> arrayList = new ArrayList(paramArrayOfString.length);
    int j = paramArrayOfString.length;
    int i;
    for (i = 0; i < j; i++) {
      String str = paramArrayOfString[i];
      if (!this.b.contains(str)) {
        if (parame != null)
          parame.a(str, c.c); 
      } else if (!a((Context)paramActivity, str)) {
        arrayList.add(str);
      } else if (parame != null) {
        parame.a(str, c.a);
      } 
    } 
    return arrayList;
  }
  
  public void a(Activity paramActivity, String[] paramArrayOfString, e parame) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: aload_2
    //   11: aload_3
    //   12: invokespecial a : ([Ljava/lang/String;Lcom/bytedance/sdk/openadsdk/core/f/e;)V
    //   15: getstatic android/os/Build$VERSION.SDK_INT : I
    //   18: bipush #23
    //   20: if_icmpge -> 33
    //   23: aload_0
    //   24: aload_1
    //   25: aload_2
    //   26: aload_3
    //   27: invokespecial b : (Landroid/app/Activity;[Ljava/lang/String;Lcom/bytedance/sdk/openadsdk/core/f/e;)V
    //   30: goto -> 89
    //   33: aload_0
    //   34: aload_1
    //   35: aload_2
    //   36: aload_3
    //   37: invokespecial c : (Landroid/app/Activity;[Ljava/lang/String;Lcom/bytedance/sdk/openadsdk/core/f/e;)Ljava/util/List;
    //   40: astore_2
    //   41: aload_2
    //   42: invokeinterface isEmpty : ()Z
    //   47: ifeq -> 58
    //   50: aload_0
    //   51: aload_3
    //   52: invokespecial a : (Lcom/bytedance/sdk/openadsdk/core/f/e;)V
    //   55: goto -> 89
    //   58: aload_1
    //   59: aload_2
    //   60: aload_2
    //   61: invokeinterface size : ()I
    //   66: anewarray java/lang/String
    //   69: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   74: checkcast [Ljava/lang/String;
    //   77: iconst_1
    //   78: invokestatic a : (Landroid/app/Activity;[Ljava/lang/String;I)V
    //   81: goto -> 89
    //   84: astore_1
    //   85: aload_1
    //   86: invokevirtual printStackTrace : ()V
    //   89: aload_0
    //   90: monitorexit
    //   91: return
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    // Exception table:
    //   from	to	target	type
    //   9	30	84	finally
    //   33	55	84	finally
    //   58	81	84	finally
    //   85	89	92	finally
  }
  
  public void a(Activity paramActivity, String[] paramArrayOfString, int[] paramArrayOfint) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/ArrayList
    //   5: dup
    //   6: iconst_3
    //   7: invokespecial <init> : (I)V
    //   10: pop
    //   11: iconst_0
    //   12: istore #4
    //   14: aload_2
    //   15: arraylength
    //   16: istore #5
    //   18: iload #4
    //   20: iload #5
    //   22: if_icmpge -> 57
    //   25: aload_2
    //   26: iload #4
    //   28: aaload
    //   29: astore #6
    //   31: aload_3
    //   32: iload #4
    //   34: iaload
    //   35: iconst_m1
    //   36: if_icmpeq -> 80
    //   39: invokestatic e : ()Z
    //   42: ifeq -> 93
    //   45: aload_1
    //   46: aload #6
    //   48: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   51: ifne -> 93
    //   54: goto -> 80
    //   57: aload_0
    //   58: aload_2
    //   59: aload_3
    //   60: aconst_null
    //   61: invokespecial a : ([Ljava/lang/String;[I[Ljava/lang/String;)V
    //   64: goto -> 72
    //   67: astore_1
    //   68: aload_1
    //   69: invokevirtual printStackTrace : ()V
    //   72: aload_0
    //   73: monitorexit
    //   74: return
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    //   80: aload_3
    //   81: iload #4
    //   83: iaload
    //   84: iconst_m1
    //   85: if_icmpeq -> 93
    //   88: aload_3
    //   89: iload #4
    //   91: iconst_m1
    //   92: iastore
    //   93: iload #4
    //   95: iconst_1
    //   96: iadd
    //   97: istore #4
    //   99: goto -> 18
    // Exception table:
    //   from	to	target	type
    //   2	11	67	finally
    //   14	18	67	finally
    //   39	54	67	finally
    //   57	64	67	finally
    //   68	72	75	finally
  }
  
  public boolean a(Context paramContext, String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_3
    //   4: iconst_0
    //   5: istore #4
    //   7: aload_1
    //   8: ifnonnull -> 15
    //   11: aload_0
    //   12: monitorexit
    //   13: iconst_0
    //   14: ireturn
    //   15: invokestatic e : ()Z
    //   18: ifeq -> 66
    //   21: iload #4
    //   23: istore_3
    //   24: aload_1
    //   25: aload_2
    //   26: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)Z
    //   29: ifeq -> 62
    //   32: aload_1
    //   33: aload_2
    //   34: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)I
    //   37: ifeq -> 60
    //   40: aload_0
    //   41: getfield b : Ljava/util/Set;
    //   44: aload_2
    //   45: invokeinterface contains : (Ljava/lang/Object;)Z
    //   50: istore #5
    //   52: iload #4
    //   54: istore_3
    //   55: iload #5
    //   57: ifne -> 62
    //   60: iconst_1
    //   61: istore_3
    //   62: aload_0
    //   63: monitorexit
    //   64: iload_3
    //   65: ireturn
    //   66: aload_1
    //   67: aload_2
    //   68: invokestatic a : (Landroid/content/Context;Ljava/lang/String;)I
    //   71: ifeq -> 91
    //   74: aload_0
    //   75: getfield b : Ljava/util/Set;
    //   78: aload_2
    //   79: invokeinterface contains : (Ljava/lang/Object;)Z
    //   84: istore #4
    //   86: iload #4
    //   88: ifne -> 93
    //   91: iconst_1
    //   92: istore_3
    //   93: aload_0
    //   94: monitorexit
    //   95: iload_3
    //   96: ireturn
    //   97: astore_1
    //   98: aload_0
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    // Exception table:
    //   from	to	target	type
    //   15	21	97	finally
    //   24	52	97	finally
    //   66	86	97	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\f\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */