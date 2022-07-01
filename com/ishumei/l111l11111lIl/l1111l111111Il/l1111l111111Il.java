package com.ishumei.l111l11111lIl.l1111l111111Il;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import com.ishumei.l111l11111lIl.l111l11111lIl;
import com.ishumei.l111l1111llIl.l111l1111lI1l;
import com.ishumei.l111l1111llIl.l111l1111lIl;
import com.ishumei.smantifraud.SmAntiFraud;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class l1111l111111Il {
  private static final String l1111l111111Il = l111l1111lI1l.l111l11111Il("9c9092d18c978a929a96");
  
  private static final String l111l11111I1l = "sm";
  
  private static final String l111l11111Il = "_SUFFIX_TIME";
  
  private static final String l111l11111lIl = l111l1111lI1l.l111l11111Il("9b9a89969c9a969b");
  
  private static final int l111l1111l1Il = 7;
  
  private Map<String, String> l111l1111lI1l = new ConcurrentHashMap<String, String>();
  
  private Runnable l111l1111lIl = new Runnable(this) {
      public final void run() {
        try {
          SmAntiFraud.SmOption smOption = SmAntiFraud.l1111l111111Il;
          String str1 = smOption.l11l1111Il1l();
          String str2 = smOption.l111l1111lIl();
          Iterator<String> iterator = l1111l111111Il.l1111l111111Il(this.l1111l111111Il, new String[] { str1, str2 }).iterator();
          while (true)
            return; 
        } finally {
          Exception exception = null;
        } 
      }
    };
  
  private AtomicBoolean l111l1111llIl = new AtomicBoolean(false);
  
  private l1111l111111Il() {}
  
  public static l1111l111111Il l1111l111111Il() {
    return l1111l111111Il.l1111l111111Il();
  }
  
  private String l1111l111111Il(String paramString) {
    return l1111l111111Il(paramString, false);
  }
  
  private Set<String> l1111l111111Il(String... paramVarArgs) {
    HashSet<String> hashSet = new HashSet();
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++) {
      String str = l111l1111lIl.l111l1111lI1l(paramVarArgs[i]);
      if (!TextUtils.isEmpty(str) && !l111l1111lIl.l111l1111lIl(str))
        hashSet.add(str); 
    } 
    Map<String, String> map = this.l111l1111lI1l;
    if (map != null && map.size() > 0)
      hashSet.addAll(this.l111l1111lI1l.keySet()); 
    return hashSet;
  }
  
  private static String l111l11111I1l(String paramString) {
    try {
      InetAddress inetAddress = InetAddress.getByName(paramString);
      if (inetAddress != null) {
        String str = inetAddress.getHostAddress();
        boolean bool = TextUtils.isEmpty(str);
        return bool ? null : str;
      } 
      return null;
    } catch (Exception exception) {
      return null;
    } 
  }
  
  private void l111l11111I1l() {
    if (this.l111l1111llIl.compareAndSet(false, true)) {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
      if (context != null) {
        HashSet<String> hashSet = new HashSet();
        for (Map.Entry entry : context.getSharedPreferences(l1111l111111Il, 0).getAll().entrySet()) {
          String str = (String)entry.getKey();
          entry = (Map.Entry)entry.getValue();
          if (!str.equals(l111l11111lIl)) {
            if (str.endsWith("_SUFFIX_TIME")) {
              if (entry instanceof Long && System.currentTimeMillis() - ((Long)entry).longValue() > 604800000L)
                hashSet.add(str.substring(0, str.indexOf("_SUFFIX_TIME"))); 
              continue;
            } 
            if (entry instanceof String)
              hashMap.put(str, entry); 
          } 
        } 
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext())
          hashMap.remove(iterator.next()); 
      } 
      this.l111l1111lI1l.putAll(hashMap);
      com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il(this.l111l1111lIl, 7);
    } 
  }
  
  private static Map<String, String> l111l11111Il() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
    if (context == null)
      return (Map)hashMap; 
    HashSet<String> hashSet = new HashSet();
    for (Map.Entry entry : context.getSharedPreferences(l1111l111111Il, 0).getAll().entrySet()) {
      String str = (String)entry.getKey();
      entry = (Map.Entry)entry.getValue();
      if (!str.equals(l111l11111lIl)) {
        if (str.endsWith("_SUFFIX_TIME")) {
          if (entry instanceof Long && System.currentTimeMillis() - ((Long)entry).longValue() > 604800000L)
            hashSet.add(str.substring(0, str.indexOf("_SUFFIX_TIME"))); 
          continue;
        } 
        if (entry instanceof String)
          hashMap.put(str, entry); 
      } 
    } 
    Iterator<String> iterator = hashSet.iterator();
    while (iterator.hasNext())
      hashMap.remove(iterator.next()); 
    return (Map)hashMap;
  }
  
  private String l111l11111lIl(String paramString) {
    return l1111l111111Il(l111l1111lIl.l111l1111lI1l(paramString), false);
  }
  
  private String l111l11111lIl(String paramString, boolean paramBoolean) {
    return l1111l111111Il(l111l1111lIl.l111l1111lI1l(paramString), false);
  }
  
  private static void l111l11111lIl(String paramString1, String paramString2) {
    Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
    if (context == null)
      return; 
    SharedPreferences.Editor editor = context.getSharedPreferences(l1111l111111Il, 0).edit();
    editor.putString(paramString1, paramString2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString1);
    stringBuilder.append("_SUFFIX_TIME");
    editor.putLong(stringBuilder.toString(), System.currentTimeMillis());
    editor.apply();
  }
  
  public final String l1111l111111Il(String paramString, boolean paramBoolean) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    l111l11111lIl l111l11111lIl = com.ishumei.l111l11111lIl.l1111l111111Il.l1111l111111Il().l111l11111lIl();
    if (l111l11111lIl != null) {
      if (!l111l11111lIl.l111l1111lI1l())
        return null; 
      if (!this.l111l1111llIl.get() && this.l111l1111llIl.compareAndSet(false, true)) {
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        if (context != null) {
          HashSet<String> hashSet = new HashSet();
          for (Map.Entry entry : context.getSharedPreferences(l1111l111111Il, 0).getAll().entrySet()) {
            String str1 = (String)entry.getKey();
            entry = (Map.Entry)entry.getValue();
            if (!str1.equals(l111l11111lIl)) {
              if (str1.endsWith("_SUFFIX_TIME")) {
                if (entry instanceof Long && System.currentTimeMillis() - ((Long)entry).longValue() > 604800000L)
                  hashSet.add(str1.substring(0, str1.indexOf("_SUFFIX_TIME"))); 
                continue;
              } 
              if (entry instanceof String)
                hashMap.put(str1, entry); 
            } 
          } 
          Iterator<String> iterator = hashSet.iterator();
          while (iterator.hasNext())
            hashMap.remove(iterator.next()); 
        } 
        this.l111l1111lI1l.putAll(hashMap);
        com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il(this.l111l1111lIl, 7);
      } 
      if (l111l1111lIl.l111l1111lIl(paramString))
        return null; 
      if (paramBoolean)
        return l111l11111I1l(paramString); 
      String str = this.l111l1111lI1l.get(paramString);
      return TextUtils.isEmpty(str) ? l111l11111I1l(paramString) : str;
    } 
    return null;
  }
  
  public final void l1111l111111Il(String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   6: ifne -> 125
    //   9: aload_2
    //   10: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   13: ifeq -> 19
    //   16: goto -> 125
    //   19: aload_1
    //   20: invokestatic l111l1111lIl : (Ljava/lang/String;)Z
    //   23: istore_3
    //   24: iload_3
    //   25: ifeq -> 31
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: aload_0
    //   32: getfield l111l1111lI1l : Ljava/util/Map;
    //   35: aload_1
    //   36: aload_2
    //   37: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   42: pop
    //   43: getstatic com/ishumei/l1111l111111Il/l111l1111llIl$l1111l111111Il.l111l11111Il : Landroid/content/Context;
    //   46: astore #4
    //   48: aload #4
    //   50: ifnull -> 122
    //   53: aload #4
    //   55: getstatic com/ishumei/l111l11111lIl/l1111l111111Il/l1111l111111Il.l1111l111111Il : Ljava/lang/String;
    //   58: iconst_0
    //   59: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   62: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   67: astore #4
    //   69: aload #4
    //   71: aload_1
    //   72: aload_2
    //   73: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   78: pop
    //   79: new java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial <init> : ()V
    //   86: astore_2
    //   87: aload_2
    //   88: aload_1
    //   89: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_2
    //   94: ldc '_SUFFIX_TIME'
    //   96: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload #4
    //   102: aload_2
    //   103: invokevirtual toString : ()Ljava/lang/String;
    //   106: invokestatic currentTimeMillis : ()J
    //   109: invokeinterface putLong : (Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;
    //   114: pop
    //   115: aload #4
    //   117: invokeinterface apply : ()V
    //   122: aload_0
    //   123: monitorexit
    //   124: return
    //   125: aload_0
    //   126: monitorexit
    //   127: return
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    //   133: aload_0
    //   134: monitorexit
    //   135: return
    //   136: astore_1
    //   137: goto -> 133
    // Exception table:
    //   from	to	target	type
    //   2	16	136	java/lang/Exception
    //   2	16	128	finally
    //   19	24	136	java/lang/Exception
    //   19	24	128	finally
    //   31	48	136	java/lang/Exception
    //   31	48	128	finally
    //   53	122	136	java/lang/Exception
    //   53	122	128	finally
  }
  
  public final Map<String, String> l111l11111lIl() {
    return new HashMap<String, String>(this.l111l1111lI1l);
  }
  
  static final class l1111l111111Il {
    private static final l1111l111111Il l1111l111111Il = new l1111l111111Il((byte)0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111lIl\l1111l111111Il\l1111l111111Il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */