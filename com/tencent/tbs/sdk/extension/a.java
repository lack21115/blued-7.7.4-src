package com.tencent.tbs.sdk.extension;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class a {
  private static a f;
  
  private static boolean h = false;
  
  private String a = "EmergenceMsgPublisher";
  
  private String b = "tbs_emergence";
  
  private String c = "emergence_executed_ids";
  
  private String d = "emergence_ids";
  
  private String e = "";
  
  private final Map<Integer, a> g = new LinkedHashMap<Integer, a>();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static a a() {
    if (f == null)
      f = new a(); 
    return f;
  }
  
  private void a(Context paramContext, b paramb, a parama) {
    if (parama != null) {
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("Executed command: ");
      stringBuilder2.append(paramb.b);
      stringBuilder2.append(", extra: ");
      stringBuilder2.append(paramb.c);
      a(stringBuilder2.toString());
      parama.a(paramb.c);
      SharedPreferences sharedPreferences = paramContext.getSharedPreferences(this.b, 4);
      String str = sharedPreferences.getString(this.c, "");
      HashSet<Integer> hashSet = new HashSet();
      if (!TextUtils.isEmpty(str)) {
        String[] arrayOfString = str.split(",");
        if (arrayOfString != null && arrayOfString.length > 0)
          try {
            int j = arrayOfString.length;
            int i;
            for (i = 0; i < j; i++)
              hashSet.add(Integer.valueOf(Integer.parseInt(arrayOfString[i]))); 
          } catch (Throwable throwable) {
            throwable.printStackTrace();
          }  
      } 
      hashSet.add(Integer.valueOf(paramb.a));
      StringBuilder stringBuilder1 = new StringBuilder();
      Iterator<Integer> iterator = hashSet.iterator();
      while (iterator.hasNext()) {
        stringBuilder1.append(iterator.next());
        stringBuilder1.append(",");
      } 
      SharedPreferences.Editor editor = sharedPreferences.edit();
      editor.putString(this.c, stringBuilder1.toString());
      editor.commit();
    } 
  }
  
  private void a(String paramString) {
    String str = this.a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Proc[");
    stringBuilder.append(this.e);
    stringBuilder.append("]: ");
    stringBuilder.append(paramString);
    stringBuilder.toString();
  }
  
  public static String c(Context paramContext) {
    try {
      List list = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (list == null)
        return null; 
      int i = Process.myPid();
      for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
        if (runningAppProcessInfo.pid == i)
          return runningAppProcessInfo.processName; 
      } 
    } catch (Throwable throwable) {}
    return "";
  }
  
  public Map<Integer, b> a(Context paramContext) {
    // Byte code:
    //   0: new java/util/HashMap
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #7
    //   9: aload_0
    //   10: getfield b : Ljava/lang/String;
    //   13: astore #8
    //   15: iconst_0
    //   16: istore #4
    //   18: aload_1
    //   19: aload #8
    //   21: iconst_0
    //   22: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   25: astore #8
    //   27: aload_1
    //   28: ifnonnull -> 42
    //   31: ldc 'Unexpected null context!'
    //   33: astore_1
    //   34: aload_0
    //   35: aload_1
    //   36: invokespecial a : (Ljava/lang/String;)V
    //   39: aload #7
    //   41: areturn
    //   42: aload #8
    //   44: aload_0
    //   45: getfield d : Ljava/lang/String;
    //   48: ldc ''
    //   50: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   55: astore_1
    //   56: aload_1
    //   57: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   60: ifeq -> 69
    //   63: ldc 'Empty local emergence ids!'
    //   65: astore_1
    //   66: goto -> 34
    //   69: new java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial <init> : ()V
    //   76: astore #9
    //   78: aload #9
    //   80: ldc 'Local emergence ids: '
    //   82: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload #9
    //   88: aload_1
    //   89: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_0
    //   94: aload #9
    //   96: invokevirtual toString : ()Ljava/lang/String;
    //   99: invokespecial a : (Ljava/lang/String;)V
    //   102: aload_1
    //   103: ldc ';'
    //   105: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   108: astore_1
    //   109: aload_1
    //   110: ifnull -> 257
    //   113: aload_1
    //   114: arraylength
    //   115: istore_3
    //   116: iconst_0
    //   117: istore_2
    //   118: iload_2
    //   119: iload_3
    //   120: if_icmpge -> 257
    //   123: aload_1
    //   124: iload_2
    //   125: aaload
    //   126: astore #9
    //   128: aload #9
    //   130: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   133: ifeq -> 139
    //   136: goto -> 250
    //   139: aload #9
    //   141: ldc ','
    //   143: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   146: astore #10
    //   148: aload #10
    //   150: ifnull -> 250
    //   153: aload #10
    //   155: arraylength
    //   156: iconst_4
    //   157: if_icmpeq -> 163
    //   160: goto -> 250
    //   163: new com/tencent/tbs/sdk/extension/a$b
    //   166: dup
    //   167: invokespecial <init> : ()V
    //   170: astore #9
    //   172: aload #9
    //   174: aload #10
    //   176: iconst_0
    //   177: aaload
    //   178: invokestatic parseInt : (Ljava/lang/String;)I
    //   181: putfield a : I
    //   184: aload #9
    //   186: aload #10
    //   188: iconst_1
    //   189: aaload
    //   190: invokestatic parseInt : (Ljava/lang/String;)I
    //   193: putfield b : I
    //   196: aload #9
    //   198: aload #10
    //   200: iconst_2
    //   201: aaload
    //   202: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   205: putfield c : Ljava/lang/String;
    //   208: aload #9
    //   210: aload #10
    //   212: iconst_3
    //   213: aaload
    //   214: invokestatic parseLong : (Ljava/lang/String;)J
    //   217: putfield d : J
    //   220: invokestatic currentTimeMillis : ()J
    //   223: aload #9
    //   225: getfield d : J
    //   228: lcmp
    //   229: ifge -> 250
    //   232: aload #7
    //   234: aload #9
    //   236: getfield a : I
    //   239: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   242: aload #9
    //   244: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   249: pop
    //   250: iload_2
    //   251: iconst_1
    //   252: iadd
    //   253: istore_2
    //   254: goto -> 118
    //   257: aload #8
    //   259: aload_0
    //   260: getfield c : Ljava/lang/String;
    //   263: ldc ''
    //   265: invokeinterface getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   270: astore_1
    //   271: new java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial <init> : ()V
    //   278: astore #8
    //   280: aload #8
    //   282: ldc 'Executed ids: '
    //   284: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload #8
    //   290: aload_1
    //   291: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload_0
    //   296: aload #8
    //   298: invokevirtual toString : ()Ljava/lang/String;
    //   301: invokespecial a : (Ljava/lang/String;)V
    //   304: aload_1
    //   305: ldc ','
    //   307: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   310: astore_1
    //   311: aload_1
    //   312: ifnull -> 434
    //   315: new java/util/ArrayList
    //   318: dup
    //   319: invokespecial <init> : ()V
    //   322: astore #8
    //   324: aload_1
    //   325: arraylength
    //   326: istore #6
    //   328: iconst_0
    //   329: istore_2
    //   330: iload #4
    //   332: istore_3
    //   333: iload_2
    //   334: iload #6
    //   336: if_icmpge -> 400
    //   339: aload_1
    //   340: iload_2
    //   341: aaload
    //   342: astore #9
    //   344: aload #9
    //   346: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   349: ifeq -> 355
    //   352: goto -> 393
    //   355: iconst_m1
    //   356: istore_3
    //   357: aload #9
    //   359: invokestatic parseInt : (Ljava/lang/String;)I
    //   362: istore #5
    //   364: iload #5
    //   366: istore_3
    //   367: goto -> 377
    //   370: astore #9
    //   372: aload #9
    //   374: invokevirtual printStackTrace : ()V
    //   377: iload_3
    //   378: ifle -> 393
    //   381: aload #8
    //   383: iload_3
    //   384: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   387: invokeinterface add : (Ljava/lang/Object;)Z
    //   392: pop
    //   393: iload_2
    //   394: iconst_1
    //   395: iadd
    //   396: istore_2
    //   397: goto -> 330
    //   400: iload_3
    //   401: aload #8
    //   403: invokeinterface size : ()I
    //   408: if_icmpge -> 434
    //   411: aload #7
    //   413: aload #8
    //   415: iload_3
    //   416: invokeinterface get : (I)Ljava/lang/Object;
    //   421: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   426: pop
    //   427: iload_3
    //   428: iconst_1
    //   429: iadd
    //   430: istore_3
    //   431: goto -> 400
    //   434: aload #7
    //   436: areturn
    //   437: astore #10
    //   439: goto -> 220
    // Exception table:
    //   from	to	target	type
    //   172	220	437	java/lang/Throwable
    //   357	364	370	java/lang/Throwable
  }
  
  public void a(Context paramContext, Integer paramInteger, a parama) {
    this.e = c(paramContext);
    Map<Integer, b> map = a(paramContext);
    Iterator iterator = map.keySet().iterator();
    while (iterator.hasNext()) {
      if (((b)map.get((Integer)iterator.next())).b == paramInteger.intValue()) {
        a(paramContext, map.get(paramInteger), parama);
        return;
      } 
    } 
    if (!h) {
      this.g.put(paramInteger, parama);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Emergence config did not arrived yet, code[");
      stringBuilder.append(paramInteger);
      stringBuilder.append("] has been suspended");
      a(stringBuilder.toString());
    } 
  }
  
  public void b(Context paramContext) {
    Map<Integer, b> map = a(paramContext);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("On notify emergence, validate commands: ");
    stringBuilder.append(map);
    a(stringBuilder.toString());
    h = true;
    for (Integer integer : this.g.keySet()) {
      for (Integer integer1 : map.keySet()) {
        if (((b)map.get(integer1)).b == integer.intValue())
          a(paramContext, map.get(integer1), this.g.get(integer)); 
      } 
    } 
    if (!this.g.isEmpty()) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Emergency code[");
      stringBuilder1.append(this.g.keySet());
      stringBuilder1.append("] did not happen, clear suspended queries");
      a(stringBuilder1.toString());
      this.g.clear();
    } 
  }
  
  public static interface a {
    void a(String param1String);
  }
  
  public static class b {
    public int a = -1;
    
    public int b = -1;
    
    public String c = "";
    
    public long d = -1L;
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("{seqId=");
      stringBuilder.append(this.a);
      stringBuilder.append(", code=");
      stringBuilder.append(this.b);
      stringBuilder.append(", extra='");
      stringBuilder.append(this.c);
      stringBuilder.append('\'');
      stringBuilder.append(", expired=");
      stringBuilder.append(this.d);
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */