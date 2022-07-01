package com.ishumei.l111l11111Il.l1111l111111Il;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;

public class l111l1111llIl {
  private static final long l1111l111111Il = 150L;
  
  private l111l1111lI1l l111l11111I1l;
  
  private final Context l111l11111lIl;
  
  public l111l1111llIl() {}
  
  public l111l1111llIl(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial <init> : ()V
    //   4: aload_0
    //   5: aload_1
    //   6: putfield l111l11111lIl : Landroid/content/Context;
    //   9: aload_0
    //   10: getfield l111l11111lIl : Landroid/content/Context;
    //   13: ifnull -> 287
    //   16: getstatic android/os/Build.MANUFACTURER : Ljava/lang/String;
    //   19: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   22: astore_1
    //   23: aload_1
    //   24: ldc 'asus'
    //   26: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   29: ifeq -> 47
    //   32: new com/ishumei/l111l11111Il/l1111l111111Il/l1111l111111Il
    //   35: dup
    //   36: aload_0
    //   37: getfield l111l11111lIl : Landroid/content/Context;
    //   40: invokespecial <init> : (Landroid/content/Context;)V
    //   43: astore_1
    //   44: goto -> 289
    //   47: aload_1
    //   48: ldc 'huawei'
    //   50: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   53: ifeq -> 71
    //   56: new com/ishumei/l111l11111Il/l1111l111111Il/l111l11111lIl
    //   59: dup
    //   60: aload_0
    //   61: getfield l111l11111lIl : Landroid/content/Context;
    //   64: invokespecial <init> : (Landroid/content/Context;)V
    //   67: astore_1
    //   68: goto -> 289
    //   71: aload_1
    //   72: ldc 'lenovo'
    //   74: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   77: ifeq -> 95
    //   80: new com/ishumei/l111l11111Il/l1111l111111Il/l111l11111I1l
    //   83: dup
    //   84: aload_0
    //   85: getfield l111l11111lIl : Landroid/content/Context;
    //   88: invokespecial <init> : (Landroid/content/Context;)V
    //   91: astore_1
    //   92: goto -> 289
    //   95: aload_1
    //   96: ldc 'meizu'
    //   98: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   101: ifeq -> 119
    //   104: new com/ishumei/l111l11111Il/l1111l111111Il/l111l11111Il
    //   107: dup
    //   108: aload_0
    //   109: getfield l111l11111lIl : Landroid/content/Context;
    //   112: invokespecial <init> : (Landroid/content/Context;)V
    //   115: astore_1
    //   116: goto -> 289
    //   119: aload_1
    //   120: ldc 'nubia'
    //   122: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   125: ifeq -> 143
    //   128: new com/ishumei/l111l11111Il/l1111l111111Il/l111l1111l1Il
    //   131: dup
    //   132: aload_0
    //   133: getfield l111l11111lIl : Landroid/content/Context;
    //   136: invokespecial <init> : (Landroid/content/Context;)V
    //   139: astore_1
    //   140: goto -> 289
    //   143: aload_1
    //   144: ldc 'oneplus'
    //   146: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   149: ifeq -> 167
    //   152: new com/ishumei/l111l11111Il/l1111l111111Il/l111l1111lIl
    //   155: dup
    //   156: aload_0
    //   157: getfield l111l11111lIl : Landroid/content/Context;
    //   160: invokespecial <init> : (Landroid/content/Context;)V
    //   163: astore_1
    //   164: goto -> 289
    //   167: aload_1
    //   168: ldc 'oppo'
    //   170: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   173: ifeq -> 191
    //   176: new com/ishumei/l111l11111Il/l1111l111111Il/l11l1111lIIl
    //   179: dup
    //   180: aload_0
    //   181: getfield l111l11111lIl : Landroid/content/Context;
    //   184: invokespecial <init> : (Landroid/content/Context;)V
    //   187: astore_1
    //   188: goto -> 289
    //   191: aload_1
    //   192: ldc 'samsung'
    //   194: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   197: ifeq -> 215
    //   200: new com/ishumei/l111l11111Il/l1111l111111Il/l11l1111I11l
    //   203: dup
    //   204: aload_0
    //   205: getfield l111l11111lIl : Landroid/content/Context;
    //   208: invokespecial <init> : (Landroid/content/Context;)V
    //   211: astore_1
    //   212: goto -> 289
    //   215: aload_1
    //   216: ldc 'vivo'
    //   218: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   221: ifeq -> 239
    //   224: new com/ishumei/l111l11111Il/l1111l111111Il/l11l1111I1l
    //   227: dup
    //   228: aload_0
    //   229: getfield l111l11111lIl : Landroid/content/Context;
    //   232: invokespecial <init> : (Landroid/content/Context;)V
    //   235: astore_1
    //   236: goto -> 289
    //   239: aload_1
    //   240: ldc 'xiaomi'
    //   242: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   245: ifeq -> 263
    //   248: new com/ishumei/l111l11111Il/l1111l111111Il/l11l1111I1ll
    //   251: dup
    //   252: aload_0
    //   253: getfield l111l11111lIl : Landroid/content/Context;
    //   256: invokespecial <init> : (Landroid/content/Context;)V
    //   259: astore_1
    //   260: goto -> 289
    //   263: aload_1
    //   264: ldc 'zte'
    //   266: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   269: ifeq -> 287
    //   272: new com/ishumei/l111l11111Il/l1111l111111Il/l11l1111Il
    //   275: dup
    //   276: aload_0
    //   277: getfield l111l11111lIl : Landroid/content/Context;
    //   280: invokespecial <init> : (Landroid/content/Context;)V
    //   283: astore_1
    //   284: goto -> 289
    //   287: aconst_null
    //   288: astore_1
    //   289: aload_0
    //   290: aload_1
    //   291: putfield l111l11111I1l : Lcom/ishumei/l111l11111Il/l1111l111111Il/l111l1111lI1l;
    //   294: return
  }
  
  private l111l1111lI1l l111l11111I1l() {
    if (this.l111l11111lIl == null)
      return null; 
    String str = Build.MANUFACTURER.toLowerCase();
    return (l111l1111lI1l)(str.contains("asus") ? new l1111l111111Il(this.l111l11111lIl) : (str.contains("huawei") ? new l111l11111lIl(this.l111l11111lIl) : (str.contains("lenovo") ? new l111l11111I1l(this.l111l11111lIl) : (str.contains("meizu") ? new l111l11111Il(this.l111l11111lIl) : (str.contains("nubia") ? new l111l1111l1Il(this.l111l11111lIl) : (str.contains("oneplus") ? new l111l1111lIl(this.l111l11111lIl) : (str.contains("oppo") ? new l11l1111lIIl(this.l111l11111lIl) : (str.contains("samsung") ? new l11l1111I11l(this.l111l11111lIl) : (str.contains("vivo") ? new l11l1111I1l(this.l111l11111lIl) : (str.contains("xiaomi") ? new l11l1111I1ll(this.l111l11111lIl) : (str.contains("zte") ? new l11l1111Il(this.l111l11111lIl) : null)))))))))));
  }
  
  public static Map<String, Integer> l111l11111lIl() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    Context context = com.ishumei.l1111l111111Il.l111l1111llIl.l1111l111111Il.l111l11111Il;
    if (context == null)
      return (Map)hashMap; 
    try {
      Intent intent = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if (intent == null)
        return (Map)hashMap; 
      int i = intent.getIntExtra("status", 0);
      int j = intent.getIntExtra("level", 0);
      int k = intent.getIntExtra("scale", 100);
      int m = intent.getIntExtra("temperature", 0);
      int n = intent.getIntExtra("voltage", 0);
      hashMap.put("status", Integer.valueOf(i));
      hashMap.put("level", Integer.valueOf(j));
      hashMap.put("scale", Integer.valueOf(k));
      hashMap.put("temp", Integer.valueOf(m));
      hashMap.put("vol", Integer.valueOf(n));
      return (Map)hashMap;
    } catch (Exception exception) {
      return (Map)hashMap;
    } 
  }
  
  public final String l1111l111111Il() {
    l111l1111lI1l l111l1111lI1l1 = this.l111l11111I1l;
    return (l111l1111lI1l1 == null) ? "" : l111l1111lI1l1.l1111l111111Il(150L);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111Il\l1111l111111Il\l111l1111llIl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */