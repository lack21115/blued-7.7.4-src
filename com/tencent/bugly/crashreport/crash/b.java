package com.tencent.bugly.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.common.strategy.a;
import com.tencent.bugly.proguard.a;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ao;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.k;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.t;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b {
  private static int a;
  
  private Context b;
  
  private u c;
  
  private p d;
  
  private a e;
  
  private o f;
  
  private BuglyStrategy.a g;
  
  public b(int paramInt, Context paramContext, u paramu, p paramp, a parama, BuglyStrategy.a parama1, o paramo) {
    a = paramInt;
    this.b = paramContext;
    this.c = paramu;
    this.d = paramp;
    this.e = parama;
    this.g = parama1;
    this.f = paramo;
  }
  
  private static CrashDetailBean a(Cursor paramCursor) {
    if (paramCursor == null)
      return null; 
    try {
      byte[] arrayOfByte = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
      if (arrayOfByte == null)
        return null; 
      long l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      return crashDetailBean;
    } finally {
      paramCursor = null;
      if (!x.a((Throwable)paramCursor))
        paramCursor.printStackTrace(); 
    } 
  }
  
  private CrashDetailBean a(List<a> paramList, CrashDetailBean paramCrashDetailBean) {
    if (paramList != null) {
      String str1;
      CrashDetailBean crashDetailBean2;
      if (paramList.size() == 0)
        return paramCrashDetailBean; 
      CrashDetailBean crashDetailBean3 = null;
      ArrayList<a> arrayList = new ArrayList(10);
      for (a a1 : paramList) {
        if (a1.e)
          arrayList.add(a1); 
      } 
      CrashDetailBean crashDetailBean1 = crashDetailBean3;
      if (arrayList.size() > 0) {
        List<CrashDetailBean> list = b(arrayList);
        crashDetailBean1 = crashDetailBean3;
        if (list != null) {
          crashDetailBean1 = crashDetailBean3;
          if (list.size() > 0) {
            Collections.sort(list);
            crashDetailBean1 = null;
            int i = 0;
            while (i < list.size()) {
              String str;
              CrashDetailBean crashDetailBean = list.get(i);
              if (i == 0) {
                crashDetailBean3 = crashDetailBean;
              } else {
                crashDetailBean3 = crashDetailBean1;
                if (crashDetailBean.s != null) {
                  String[] arrayOfString = crashDetailBean.s.split("\n");
                  crashDetailBean3 = crashDetailBean1;
                  if (arrayOfString != null) {
                    int k = arrayOfString.length;
                    int j = 0;
                    while (true) {
                      crashDetailBean3 = crashDetailBean1;
                      if (j < k) {
                        str = arrayOfString[j];
                        String str3 = crashDetailBean1.s;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        if (!str3.contains(stringBuilder.toString())) {
                          crashDetailBean1.t++;
                          StringBuilder stringBuilder1 = new StringBuilder();
                          stringBuilder1.append(crashDetailBean1.s);
                          stringBuilder1.append(str);
                          stringBuilder1.append("\n");
                          crashDetailBean1.s = stringBuilder1.toString();
                        } 
                        j++;
                        continue;
                      } 
                      break;
                    } 
                  } 
                } 
              } 
              i++;
              str1 = str;
            } 
          } 
        } 
      } 
      String str2 = str1;
      if (str1 == null) {
        paramCrashDetailBean.j = true;
        paramCrashDetailBean.t = 0;
        paramCrashDetailBean.s = "";
        crashDetailBean2 = paramCrashDetailBean;
      } 
      for (a a1 : paramList) {
        if (!a1.e && !a1.d) {
          String str = crashDetailBean2.s;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(a1.b);
          if (!str.contains(stringBuilder.toString())) {
            crashDetailBean2.t++;
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(crashDetailBean2.s);
            stringBuilder1.append(a1.b);
            stringBuilder1.append("\n");
            crashDetailBean2.s = stringBuilder1.toString();
          } 
        } 
      } 
      if (crashDetailBean2.r != paramCrashDetailBean.r) {
        String str = crashDetailBean2.s;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramCrashDetailBean.r);
        if (!str.contains(stringBuilder.toString())) {
          crashDetailBean2.t++;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(crashDetailBean2.s);
          stringBuilder1.append(paramCrashDetailBean.r);
          stringBuilder1.append("\n");
          crashDetailBean2.s = stringBuilder1.toString();
        } 
      } 
      return crashDetailBean2;
    } 
    return paramCrashDetailBean;
  }
  
  private static am a(String paramString1, Context paramContext, String paramString2) {
    // Byte code:
    //   0: aload_2
    //   1: ifnull -> 318
    //   4: aload_1
    //   5: ifnonnull -> 11
    //   8: goto -> 318
    //   11: ldc 'zip %s'
    //   13: iconst_1
    //   14: anewarray java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_2
    //   20: aastore
    //   21: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   24: pop
    //   25: new java/io/File
    //   28: dup
    //   29: aload_2
    //   30: invokespecial <init> : (Ljava/lang/String;)V
    //   33: astore #4
    //   35: new java/io/File
    //   38: dup
    //   39: aload_1
    //   40: invokevirtual getCacheDir : ()Ljava/io/File;
    //   43: aload_0
    //   44: invokespecial <init> : (Ljava/io/File;Ljava/lang/String;)V
    //   47: astore_2
    //   48: aload #4
    //   50: aload_2
    //   51: sipush #5000
    //   54: invokestatic a : (Ljava/io/File;Ljava/io/File;I)Z
    //   57: ifne -> 72
    //   60: ldc 'zip fail!'
    //   62: iconst_0
    //   63: anewarray java/lang/Object
    //   66: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   69: pop
    //   70: aconst_null
    //   71: areturn
    //   72: new java/io/ByteArrayOutputStream
    //   75: dup
    //   76: invokespecial <init> : ()V
    //   79: astore_1
    //   80: new java/io/FileInputStream
    //   83: dup
    //   84: aload_2
    //   85: invokespecial <init> : (Ljava/io/File;)V
    //   88: astore_0
    //   89: sipush #4096
    //   92: newarray byte
    //   94: astore #4
    //   96: aload_0
    //   97: aload #4
    //   99: invokevirtual read : ([B)I
    //   102: istore_3
    //   103: iload_3
    //   104: ifle -> 122
    //   107: aload_1
    //   108: aload #4
    //   110: iconst_0
    //   111: iload_3
    //   112: invokevirtual write : ([BII)V
    //   115: aload_1
    //   116: invokevirtual flush : ()V
    //   119: goto -> 96
    //   122: aload_1
    //   123: invokevirtual toByteArray : ()[B
    //   126: astore_1
    //   127: ldc 'read bytes :%d'
    //   129: iconst_1
    //   130: anewarray java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload_1
    //   136: arraylength
    //   137: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   140: aastore
    //   141: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   144: pop
    //   145: new com/tencent/bugly/proguard/am
    //   148: dup
    //   149: iconst_2
    //   150: aload_2
    //   151: invokevirtual getName : ()Ljava/lang/String;
    //   154: aload_1
    //   155: invokespecial <init> : (BLjava/lang/String;[B)V
    //   158: astore_1
    //   159: aload_0
    //   160: invokevirtual close : ()V
    //   163: goto -> 178
    //   166: astore_0
    //   167: aload_0
    //   168: invokestatic a : (Ljava/lang/Throwable;)Z
    //   171: ifne -> 178
    //   174: aload_0
    //   175: invokevirtual printStackTrace : ()V
    //   178: aload_2
    //   179: invokevirtual exists : ()Z
    //   182: ifeq -> 201
    //   185: ldc_w 'del tmp'
    //   188: iconst_0
    //   189: anewarray java/lang/Object
    //   192: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   195: pop
    //   196: aload_2
    //   197: invokevirtual delete : ()Z
    //   200: pop
    //   201: aload_1
    //   202: areturn
    //   203: astore_1
    //   204: goto -> 210
    //   207: astore_1
    //   208: aconst_null
    //   209: astore_0
    //   210: aload_1
    //   211: invokestatic a : (Ljava/lang/Throwable;)Z
    //   214: ifne -> 221
    //   217: aload_1
    //   218: invokevirtual printStackTrace : ()V
    //   221: aload_0
    //   222: ifnull -> 244
    //   225: aload_0
    //   226: invokevirtual close : ()V
    //   229: goto -> 244
    //   232: astore_0
    //   233: aload_0
    //   234: invokestatic a : (Ljava/lang/Throwable;)Z
    //   237: ifne -> 244
    //   240: aload_0
    //   241: invokevirtual printStackTrace : ()V
    //   244: aload_2
    //   245: invokevirtual exists : ()Z
    //   248: ifeq -> 267
    //   251: ldc_w 'del tmp'
    //   254: iconst_0
    //   255: anewarray java/lang/Object
    //   258: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   261: pop
    //   262: aload_2
    //   263: invokevirtual delete : ()Z
    //   266: pop
    //   267: aconst_null
    //   268: areturn
    //   269: astore_1
    //   270: aload_0
    //   271: ifnull -> 293
    //   274: aload_0
    //   275: invokevirtual close : ()V
    //   278: goto -> 293
    //   281: astore_0
    //   282: aload_0
    //   283: invokestatic a : (Ljava/lang/Throwable;)Z
    //   286: ifne -> 293
    //   289: aload_0
    //   290: invokevirtual printStackTrace : ()V
    //   293: aload_2
    //   294: invokevirtual exists : ()Z
    //   297: ifeq -> 316
    //   300: ldc_w 'del tmp'
    //   303: iconst_0
    //   304: anewarray java/lang/Object
    //   307: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   310: pop
    //   311: aload_2
    //   312: invokevirtual delete : ()Z
    //   315: pop
    //   316: aload_1
    //   317: athrow
    //   318: ldc_w 'rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}'
    //   321: iconst_0
    //   322: anewarray java/lang/Object
    //   325: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   328: pop
    //   329: aconst_null
    //   330: areturn
    // Exception table:
    //   from	to	target	type
    //   80	89	207	finally
    //   89	96	203	finally
    //   96	103	203	finally
    //   107	119	203	finally
    //   122	159	203	finally
    //   159	163	166	java/io/IOException
    //   210	221	269	finally
    //   225	229	232	java/io/IOException
    //   274	278	281	java/io/IOException
  }
  
  private static an a(Context paramContext, CrashDetailBean paramCrashDetailBean, a parama) {
    String str4;
    boolean bool = false;
    if (paramContext == null || paramCrashDetailBean == null || parama == null) {
      x.d("enExp args == null", new Object[0]);
      return null;
    } 
    an an = new an();
    switch (paramCrashDetailBean.b) {
      default:
        x.e("crash type error! %d", new Object[] { Integer.valueOf(paramCrashDetailBean.b) });
        break;
      case 7:
        if (paramCrashDetailBean.j) {
          str4 = "208";
        } else {
          str4 = "108";
        } 
        an.a = str4;
        break;
      case 6:
        if (paramCrashDetailBean.j) {
          str4 = "206";
        } else {
          str4 = "106";
        } 
        an.a = str4;
        break;
      case 5:
        if (paramCrashDetailBean.j) {
          str4 = "207";
        } else {
          str4 = "107";
        } 
        an.a = str4;
        break;
      case 4:
        if (paramCrashDetailBean.j) {
          str4 = "204";
        } else {
          str4 = "104";
        } 
        an.a = str4;
        break;
      case 3:
        if (paramCrashDetailBean.j) {
          str4 = "203";
        } else {
          str4 = "103";
        } 
        an.a = str4;
        break;
      case 2:
        if (paramCrashDetailBean.j) {
          str4 = "202";
        } else {
          str4 = "102";
        } 
        an.a = str4;
        break;
      case 1:
        if (paramCrashDetailBean.j) {
          str4 = "201";
        } else {
          str4 = "101";
        } 
        an.a = str4;
        break;
      case 0:
        if (paramCrashDetailBean.j) {
          str4 = "200";
        } else {
          str4 = "100";
        } 
        an.a = str4;
        break;
    } 
    an.b = paramCrashDetailBean.r;
    an.c = paramCrashDetailBean.n;
    an.d = paramCrashDetailBean.o;
    an.e = paramCrashDetailBean.p;
    an.g = paramCrashDetailBean.q;
    an.h = paramCrashDetailBean.z;
    an.i = paramCrashDetailBean.c;
    an.j = null;
    an.l = paramCrashDetailBean.m;
    an.m = paramCrashDetailBean.e;
    an.f = paramCrashDetailBean.B;
    an.t = a.b().i();
    an.n = null;
    if (paramCrashDetailBean.i != null && paramCrashDetailBean.i.size() > 0) {
      an.o = new ArrayList();
      for (Map.Entry<String, PlugInBean> entry : paramCrashDetailBean.i.entrySet()) {
        ak ak = new ak();
        ak.a = ((PlugInBean)entry.getValue()).a;
        ak.c = ((PlugInBean)entry.getValue()).c;
        ak.d = ((PlugInBean)entry.getValue()).b;
        ak.b = parama.r();
        an.o.add(ak);
      } 
    } 
    if (paramCrashDetailBean.h != null && paramCrashDetailBean.h.size() > 0) {
      an.p = new ArrayList();
      for (Map.Entry<String, PlugInBean> entry : paramCrashDetailBean.h.entrySet()) {
        ak ak = new ak();
        ak.a = ((PlugInBean)entry.getValue()).a;
        ak.c = ((PlugInBean)entry.getValue()).c;
        ak.d = ((PlugInBean)entry.getValue()).b;
        an.p.add(ak);
      } 
    } 
    if (paramCrashDetailBean.j) {
      boolean bool4;
      an.k = paramCrashDetailBean.t;
      if (paramCrashDetailBean.s != null && paramCrashDetailBean.s.length() > 0) {
        if (an.q == null)
          an.q = new ArrayList(); 
        try {
          an.q.add(new am((byte)1, "alltimes.txt", paramCrashDetailBean.s.getBytes("utf-8")));
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
          unsupportedEncodingException.printStackTrace();
          an.q = null;
        } 
      } 
      int i = an.k;
      if (an.q != null) {
        bool4 = an.q.size();
      } else {
        bool4 = false;
      } 
      x.c("crashcount:%d sz:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(bool4) });
    } 
    if (paramCrashDetailBean.w != null) {
      if (an.q == null)
        an.q = new ArrayList(); 
      try {
        an.q.add(new am((byte)1, "log.txt", paramCrashDetailBean.w.getBytes("utf-8")));
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException.printStackTrace();
        an.q = null;
      } 
    } 
    if (paramCrashDetailBean.x != null) {
      if (an.q == null)
        an.q = new ArrayList(); 
      try {
        an.q.add(new am((byte)1, "jniLog.txt", paramCrashDetailBean.x.getBytes("utf-8")));
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException.printStackTrace();
        an.q = null;
      } 
    } 
    if (!z.a(paramCrashDetailBean.V)) {
      if (an.q == null)
        an.q = new ArrayList(); 
      try {
        am am = new am((byte)1, "crashInfos.txt", paramCrashDetailBean.V.getBytes("utf-8"));
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException.printStackTrace();
        unsupportedEncodingException = null;
      } 
      if (unsupportedEncodingException != null) {
        x.c("attach crash infos", new Object[0]);
        an.q.add(unsupportedEncodingException);
      } 
    } 
    if (paramCrashDetailBean.W != null) {
      if (an.q == null)
        an.q = new ArrayList(); 
      am am = a("backupRecord.zip", paramContext, paramCrashDetailBean.W);
      if (am != null) {
        x.c("attach backup record", new Object[0]);
        an.q.add(am);
      } 
    } 
    if (paramCrashDetailBean.y != null && paramCrashDetailBean.y.length > 0) {
      am am = new am((byte)2, "buglylog.zip", paramCrashDetailBean.y);
      x.c("attach user log", new Object[0]);
      if (an.q == null)
        an.q = new ArrayList(); 
      an.q.add(am);
    } 
    if (paramCrashDetailBean.b == 3) {
      if (an.q == null)
        an.q = new ArrayList(); 
      x.c("crashBean.anrMessages:%s", new Object[] { paramCrashDetailBean.P });
      if (paramCrashDetailBean.P != null && paramCrashDetailBean.P.containsKey("BUGLY_CR_01")) {
        try {
          if (!TextUtils.isEmpty(paramCrashDetailBean.P.get("BUGLY_CR_01"))) {
            an.q.add(new am((byte)1, "anrMessage.txt", ((String)paramCrashDetailBean.P.get("BUGLY_CR_01")).getBytes("utf-8")));
            x.c("attach anr message", new Object[0]);
          } 
        } catch (UnsupportedEncodingException unsupportedEncodingException) {
          unsupportedEncodingException.printStackTrace();
          an.q = null;
        } 
        paramCrashDetailBean.P.remove("BUGLY_CR_01");
      } 
      if (paramCrashDetailBean.v != null) {
        am am = a("trace.zip", paramContext, paramCrashDetailBean.v);
        if (am != null) {
          x.c("attach traces", new Object[0]);
          an.q.add(am);
        } 
      } 
    } 
    if (paramCrashDetailBean.b == 1) {
      if (an.q == null)
        an.q = new ArrayList(); 
      if (paramCrashDetailBean.v != null) {
        am am = a("tomb.zip", paramContext, paramCrashDetailBean.v);
        if (am != null) {
          x.c("attach tombs", new Object[0]);
          an.q.add(am);
        } 
      } 
    } 
    if (parama.E != null && !parama.E.isEmpty()) {
      if (an.q == null)
        an.q = new ArrayList(); 
      StringBuilder stringBuilder1 = new StringBuilder();
      Iterator<String> iterator = parama.E.iterator();
      while (iterator.hasNext())
        stringBuilder1.append(iterator.next()); 
      try {
        an.q.add(new am((byte)1, "martianlog.txt", stringBuilder1.toString().getBytes("utf-8")));
        x.c("attach pageTracingList", new Object[0]);
      } catch (UnsupportedEncodingException unsupportedEncodingException) {
        unsupportedEncodingException.printStackTrace();
      } 
    } 
    if (paramCrashDetailBean.U != null && paramCrashDetailBean.U.length > 0) {
      if (an.q == null)
        an.q = new ArrayList(); 
      an.q.add(new am((byte)1, "userExtraByteData", paramCrashDetailBean.U));
      x.c("attach extraData", new Object[0]);
    } 
    an.r = new HashMap<Object, Object>();
    Map<String, String> map = an.r;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramCrashDetailBean.C);
    map.put("A9", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramCrashDetailBean.D);
    map.put("A11", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramCrashDetailBean.E);
    map.put("A10", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramCrashDetailBean.f);
    map.put("A23", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(parama.g);
    map.put("A7", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(parama.s());
    map.put("A6", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(parama.r());
    map.put("A5", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(parama.h());
    map.put("A22", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramCrashDetailBean.G);
    map.put("A2", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramCrashDetailBean.F);
    map.put("A1", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(parama.i);
    map.put("A24", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramCrashDetailBean.H);
    map.put("A17", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(parama.k());
    map.put("A3", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(parama.m());
    map.put("A16", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(parama.n());
    map.put("A25", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(parama.l());
    map.put("A14", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(parama.w());
    map.put("A15", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(parama.x());
    map.put("A13", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramCrashDetailBean.A);
    map.put("A34", stringBuilder.toString());
    if (parama.y != null) {
      map = an.r;
      stringBuilder = new StringBuilder();
      stringBuilder.append(parama.y);
      map.put("productIdentify", stringBuilder.toString());
    } 
    try {
      map = an.r;
      stringBuilder = new StringBuilder();
      stringBuilder.append(URLEncoder.encode(paramCrashDetailBean.I, "utf-8"));
      map.put("A26", stringBuilder.toString());
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      unsupportedEncodingException.printStackTrace();
    } 
    if (paramCrashDetailBean.b == 1) {
      map = an.r;
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramCrashDetailBean.K);
      map.put("A27", stringBuilder.toString());
      map = an.r;
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramCrashDetailBean.J);
      map.put("A28", stringBuilder.toString());
      map = an.r;
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramCrashDetailBean.k);
      map.put("A29", stringBuilder.toString());
    } 
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramCrashDetailBean.L);
    map.put("A30", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramCrashDetailBean.M);
    map.put("A18", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramCrashDetailBean.N ^ true);
    map.put("A36", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(parama.r);
    map.put("F02", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(parama.s);
    map.put("F03", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(parama.e());
    map.put("F04", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(parama.t);
    map.put("F05", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(parama.q);
    map.put("F06", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(parama.w);
    map.put("F08", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(parama.x);
    map.put("F09", stringBuilder.toString());
    map = an.r;
    stringBuilder = new StringBuilder();
    stringBuilder.append(parama.u);
    map.put("F10", stringBuilder.toString());
    if (paramCrashDetailBean.Q >= 0) {
      map = an.r;
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramCrashDetailBean.Q);
      map.put("C01", stringBuilder.toString());
    } 
    if (paramCrashDetailBean.R >= 0) {
      map = an.r;
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramCrashDetailBean.R);
      map.put("C02", stringBuilder.toString());
    } 
    if (paramCrashDetailBean.S != null && paramCrashDetailBean.S.size() > 0)
      for (Map.Entry<String, String> entry : paramCrashDetailBean.S.entrySet()) {
        Map map1 = an.r;
        StringBuilder stringBuilder1 = new StringBuilder("C03_");
        stringBuilder1.append((String)entry.getKey());
        map1.put(stringBuilder1.toString(), entry.getValue());
      }  
    if (paramCrashDetailBean.T != null && paramCrashDetailBean.T.size() > 0)
      for (Map.Entry<String, String> entry : paramCrashDetailBean.T.entrySet()) {
        Map map1 = an.r;
        StringBuilder stringBuilder1 = new StringBuilder("C04_");
        stringBuilder1.append((String)entry.getKey());
        map1.put(stringBuilder1.toString(), entry.getValue());
      }  
    an.s = null;
    if (paramCrashDetailBean.O != null && paramCrashDetailBean.O.size() > 0) {
      an.s = paramCrashDetailBean.O;
      x.a("setted message size %d", new Object[] { Integer.valueOf(an.s.size()) });
    } 
    String str1 = paramCrashDetailBean.n;
    String str3 = paramCrashDetailBean.c;
    String str2 = parama.e();
    long l = (paramCrashDetailBean.r - paramCrashDetailBean.M) / 1000L;
    boolean bool1 = paramCrashDetailBean.k;
    boolean bool2 = paramCrashDetailBean.N;
    boolean bool3 = paramCrashDetailBean.j;
    if (paramCrashDetailBean.b == 1)
      bool = true; 
    x.c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", new Object[] { 
          str1, str3, str2, Long.valueOf(l), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool), Integer.valueOf(paramCrashDetailBean.t), paramCrashDetailBean.s, 
          Boolean.valueOf(paramCrashDetailBean.d), Integer.valueOf(an.r.size()) });
    return an;
  }
  
  private static List<a> a(List<a> paramList) {
    if (paramList == null || paramList.size() == 0)
      return null; 
    long l = System.currentTimeMillis();
    ArrayList<a> arrayList = new ArrayList();
    for (a a1 : paramList) {
      if (a1.d && a1.b <= l - 86400000L)
        arrayList.add(a1); 
    } 
    return arrayList;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, CrashDetailBean paramCrashDetailBean) {
    a a1 = a.b();
    if (a1 == null)
      return; 
    x.e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
    x.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
    x.e("# PKG NAME: %s", new Object[] { a1.c });
    x.e("# APP VER: %s", new Object[] { a1.k });
    x.e("# SDK VER: %s", new Object[] { a1.f });
    x.e("# LAUNCH TIME: %s", new Object[] { z.a(new Date((a.b()).a)) });
    x.e("# CRASH TYPE: %s", new Object[] { paramString1 });
    x.e("# CRASH TIME: %s", new Object[] { paramString2 });
    x.e("# CRASH PROCESS: %s", new Object[] { paramString3 });
    x.e("# CRASH THREAD: %s", new Object[] { paramString4 });
    if (paramCrashDetailBean != null) {
      x.e("# REPORT ID: %s", new Object[] { paramCrashDetailBean.c });
      paramString2 = a1.h;
      if (a1.x().booleanValue()) {
        paramString1 = "ROOTED";
      } else {
        paramString1 = "UNROOT";
      } 
      x.e("# CRASH DEVICE: %s %s", new Object[] { paramString2, paramString1 });
      x.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", new Object[] { Long.valueOf(paramCrashDetailBean.C), Long.valueOf(paramCrashDetailBean.D), Long.valueOf(paramCrashDetailBean.E) });
      x.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", new Object[] { Long.valueOf(paramCrashDetailBean.F), Long.valueOf(paramCrashDetailBean.G), Long.valueOf(paramCrashDetailBean.H) });
      if (!z.a(paramCrashDetailBean.K)) {
        x.e("# EXCEPTION FIRED BY %s %s", new Object[] { paramCrashDetailBean.K, paramCrashDetailBean.J });
      } else if (paramCrashDetailBean.b == 3) {
        String str;
        if (paramCrashDetailBean.P == null) {
          paramString1 = "null";
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(paramCrashDetailBean.P.get("BUGLY_CR_01"));
          str = stringBuilder.toString();
        } 
        x.e("# EXCEPTION ANR MESSAGE:\n %s", new Object[] { str });
      } 
    } 
    if (!z.a(paramString5)) {
      x.e("# CRASH STACK: ", new Object[0]);
      x.e(paramString5, new Object[0]);
    } 
    x.e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
  }
  
  public static void a(boolean paramBoolean, List<CrashDetailBean> paramList) {
    if (paramList != null && paramList.size() > 0) {
      x.c("up finish update state %b", new Object[] { Boolean.valueOf(paramBoolean) });
      for (CrashDetailBean crashDetailBean : paramList) {
        x.c("pre uid:%s uc:%d re:%b me:%b", new Object[] { crashDetailBean.c, Integer.valueOf(crashDetailBean.l), Boolean.valueOf(crashDetailBean.d), Boolean.valueOf(crashDetailBean.j) });
        crashDetailBean.l++;
        crashDetailBean.d = paramBoolean;
        x.c("set uid:%s uc:%d re:%b me:%b", new Object[] { crashDetailBean.c, Integer.valueOf(crashDetailBean.l), Boolean.valueOf(crashDetailBean.d), Boolean.valueOf(crashDetailBean.j) });
      } 
      for (CrashDetailBean crashDetailBean : paramList)
        c.a().a(crashDetailBean); 
      x.c("update state size %d", new Object[] { Integer.valueOf(paramList.size()) });
    } 
    if (!paramBoolean)
      x.b("[crash] upload fail.", new Object[0]); 
  }
  
  private static a b(Cursor paramCursor) {
    if (paramCursor == null)
      return null; 
    try {
      a a1 = new a();
      a1.a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      a1.b = paramCursor.getLong(paramCursor.getColumnIndex("_tm"));
      a1.c = paramCursor.getString(paramCursor.getColumnIndex("_s1"));
      int i = paramCursor.getInt(paramCursor.getColumnIndex("_up"));
      boolean bool2 = false;
      if (i == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      a1.d = bool1;
      boolean bool1 = bool2;
      if (paramCursor.getInt(paramCursor.getColumnIndex("_me")) == 1)
        bool1 = true; 
      return a1;
    } finally {
      paramCursor = null;
      if (!x.a((Throwable)paramCursor))
        paramCursor.printStackTrace(); 
    } 
  }
  
  private List<a> b() {
    Cursor cursor;
    ArrayList<a> arrayList = new ArrayList();
    try {
      Cursor cursor1 = p.a().a("t_cr", new String[] { "_id", "_tm", "_s1", "_up", "_me", "_uc" }, null, null, null, true);
      if (cursor1 == null)
        return null; 
    } finally {
      null = null;
    } 
    try {
      if (!x.a(null))
        null.printStackTrace(); 
      return arrayList;
    } finally {
      if (cursor != null)
        cursor.close(); 
    } 
  }
  
  private List<CrashDetailBean> b(List<a> paramList) {
    if (paramList != null) {
      StringBuilder stringBuilder1;
      if (paramList.size() == 0)
        return null; 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("_id in ");
      stringBuilder2.append("(");
      Iterator<a> iterator = paramList.iterator();
      while (iterator.hasNext()) {
        stringBuilder2.append(((a)iterator.next()).a);
        stringBuilder2.append(",");
      } 
      if (stringBuilder2.toString().contains(",")) {
        stringBuilder1 = new StringBuilder(stringBuilder2.substring(0, stringBuilder2.lastIndexOf(",")));
      } else {
        stringBuilder1 = stringBuilder2;
      } 
      stringBuilder1.append(")");
      null = stringBuilder1.toString();
      stringBuilder1.setLength(0);
      try {
        Cursor cursor = p.a().a("t_cr", null, null, null, null, true);
        if (cursor == null)
          return null; 
      } finally {
        null = null;
      } 
      try {
        if (!x.a((Throwable)null))
          null.printStackTrace(); 
        return null;
      } finally {
        if (stringBuilder1 != null)
          stringBuilder1.close(); 
      } 
    } 
    return null;
  }
  
  private static void c(List<a> paramList) {
    if (paramList != null) {
      if (paramList.size() == 0)
        return; 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("_id in ");
      stringBuilder2.append("(");
      Iterator<a> iterator = paramList.iterator();
      while (iterator.hasNext()) {
        stringBuilder2.append(((a)iterator.next()).a);
        stringBuilder2.append(",");
      } 
      StringBuilder stringBuilder1 = new StringBuilder(stringBuilder2.substring(0, stringBuilder2.lastIndexOf(",")));
      stringBuilder1.append(")");
      String str = stringBuilder1.toString();
      stringBuilder1.setLength(0);
      try {
        return;
      } finally {
        stringBuilder1 = null;
      } 
    } 
  }
  
  private static void d(List<CrashDetailBean> paramList) {
    if (paramList != null)
      try {
        if (paramList.size() == 0)
          return; 
        StringBuilder stringBuilder = new StringBuilder();
        for (CrashDetailBean crashDetailBean : paramList) {
          stringBuilder.append(" or _id");
          stringBuilder.append(" = ");
          stringBuilder.append(crashDetailBean.a);
        } 
        String str2 = stringBuilder.toString();
        String str1 = str2;
        if (str2.length() > 0)
          str1 = str2.substring(4); 
        stringBuilder.setLength(0);
        return;
      } finally {
        paramList = null;
      }  
  }
  
  private static ContentValues f(CrashDetailBean paramCrashDetailBean) {
    ContentValues contentValues;
    if (paramCrashDetailBean == null)
      return null; 
    try {
      boolean bool1;
      contentValues = new ContentValues();
      if (paramCrashDetailBean.a > 0L)
        contentValues.put("_id", Long.valueOf(paramCrashDetailBean.a)); 
      contentValues.put("_tm", Long.valueOf(paramCrashDetailBean.r));
      contentValues.put("_s1", paramCrashDetailBean.u);
      boolean bool3 = paramCrashDetailBean.d;
      boolean bool2 = true;
      if (bool3) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
    } finally {
      paramCrashDetailBean = null;
      if (!x.a((Throwable)paramCrashDetailBean))
        paramCrashDetailBean.printStackTrace(); 
    } 
    boolean bool = false;
    contentValues.put("_me", Integer.valueOf(bool));
    contentValues.put("_uc", Integer.valueOf(paramCrashDetailBean.l));
    contentValues.put("_dt", z.a(paramCrashDetailBean));
    return contentValues;
  }
  
  public final List<CrashDetailBean> a() {
    StrategyBean strategyBean = a.a().c();
    if (strategyBean == null) {
      x.d("have not synced remote!", new Object[0]);
      return null;
    } 
    if (!strategyBean.g) {
      x.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
      x.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
      return null;
    } 
    long l1 = System.currentTimeMillis();
    long l2 = z.b();
    List<a> list = b();
    x.c("Size of crash list loaded from DB: %s", new Object[] { Integer.valueOf(list.size()) });
    if (list != null) {
      if (list.size() <= 0)
        return null; 
      ArrayList<a> arrayList = new ArrayList();
      arrayList.addAll(a(list));
      list.removeAll(arrayList);
      Iterator<a> iterator = list.iterator();
      while (iterator.hasNext()) {
        a a1 = iterator.next();
        if (a1.b < l2 - c.g) {
          iterator.remove();
          arrayList.add(a1);
          continue;
        } 
        if (a1.d) {
          if (a1.b >= l1 - 86400000L) {
            iterator.remove();
            continue;
          } 
          if (!a1.e) {
            iterator.remove();
            arrayList.add(a1);
          } 
          continue;
        } 
        if (a1.f >= 3L && a1.b < l1 - 86400000L) {
          iterator.remove();
          arrayList.add(a1);
        } 
      } 
      if (arrayList.size() > 0)
        c(arrayList); 
      arrayList = new ArrayList<a>();
      list = (List)b(list);
      if (list != null && list.size() > 0) {
        String str = (a.b()).k;
        Iterator<a> iterator1 = list.iterator();
        while (iterator1.hasNext()) {
          CrashDetailBean crashDetailBean = (CrashDetailBean)iterator1.next();
          if (!str.equals(crashDetailBean.f)) {
            iterator1.remove();
            arrayList.add(crashDetailBean);
          } 
        } 
      } 
      if (arrayList.size() > 0)
        d((List)arrayList); 
      return (List)list;
    } 
    return null;
  }
  
  public final void a(CrashDetailBean paramCrashDetailBean, long paramLong, boolean paramBoolean) {
    if (c.l) {
      boolean bool;
      x.a("try to upload right now", new Object[0]);
      ArrayList<CrashDetailBean> arrayList = new ArrayList();
      arrayList.add(paramCrashDetailBean);
      if (paramCrashDetailBean.b == 7) {
        bool = true;
      } else {
        bool = false;
      } 
      a(arrayList, 3000L, paramBoolean, bool, paramBoolean);
    } 
  }
  
  public final void a(List<CrashDetailBean> paramList, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    if (!(a.a(this.b)).e)
      return; 
    u u1 = this.c;
    if (u1 == null)
      return; 
    if (!paramBoolean3 && !u1.b(c.a))
      return; 
    StrategyBean strategyBean = this.e.c();
    if (!strategyBean.g) {
      x.d("remote report is disable!", new Object[0]);
      x.b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
      return;
    } 
    if (paramList != null) {
      if (paramList.size() == 0)
        return; 
      try {
        char c;
        String str1;
        String str2;
        CrashDetailBean crashDetailBean;
        if (this.c.a) {
          str1 = strategyBean.s;
        } else {
          str1 = ((StrategyBean)str1).t;
        } 
        if (this.c.a) {
          str2 = StrategyBean.c;
        } else {
          str2 = StrategyBean.a;
        } 
        if (this.c.a) {
          c = '̾';
        } else {
          c = 'ɶ';
        } 
        Context context = this.b;
        a a1 = a.b();
        if (context == null || paramList == null || paramList.size() == 0 || a1 == null) {
          x.d("enEXPPkg args == null!", new Object[0]);
          crashDetailBean = null;
        } else {
          ao ao = new ao();
          ao.a = new ArrayList();
          Iterator<CrashDetailBean> iterator = paramList.iterator();
          while (true) {
            ao ao1 = ao;
            if (iterator.hasNext()) {
              crashDetailBean = iterator.next();
              ao.a.add(a(context, crashDetailBean, a1));
              continue;
            } 
            break;
          } 
        } 
        if (crashDetailBean == null)
          return; 
        byte[] arrayOfByte = a.a((k)crashDetailBean);
        if (arrayOfByte == null)
          return; 
        ap ap = a.a(this.b, c, arrayOfByte);
        if (ap == null)
          return; 
        t t = new t(this, paramList) {
            public final void a(boolean param1Boolean) {
              b b1 = this.b;
              b.a(param1Boolean, this.a);
            }
          };
        return;
      } finally {
        paramList = null;
        x.e("req cr error %s", new Object[] { paramList.toString() });
      } 
    } 
  }
  
  public final boolean a(CrashDetailBean paramCrashDetailBean) {
    return b(paramCrashDetailBean);
  }
  
  public final boolean b(CrashDetailBean paramCrashDetailBean) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 6
    //   4: iconst_1
    //   5: ireturn
    //   6: getstatic com/tencent/bugly/crashreport/crash/c.n : Ljava/lang/String;
    //   9: ifnull -> 64
    //   12: getstatic com/tencent/bugly/crashreport/crash/c.n : Ljava/lang/String;
    //   15: invokevirtual isEmpty : ()Z
    //   18: ifne -> 64
    //   21: ldc_w 'Crash filter for crash stack is: %s'
    //   24: iconst_1
    //   25: anewarray java/lang/Object
    //   28: dup
    //   29: iconst_0
    //   30: getstatic com/tencent/bugly/crashreport/crash/c.n : Ljava/lang/String;
    //   33: aastore
    //   34: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   37: pop
    //   38: aload_1
    //   39: getfield q : Ljava/lang/String;
    //   42: getstatic com/tencent/bugly/crashreport/crash/c.n : Ljava/lang/String;
    //   45: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   48: ifeq -> 64
    //   51: ldc_w 'This crash contains the filter string set. It will not be record and upload.'
    //   54: iconst_0
    //   55: anewarray java/lang/Object
    //   58: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   61: pop
    //   62: iconst_1
    //   63: ireturn
    //   64: getstatic com/tencent/bugly/crashreport/crash/c.o : Ljava/lang/String;
    //   67: ifnull -> 128
    //   70: getstatic com/tencent/bugly/crashreport/crash/c.o : Ljava/lang/String;
    //   73: invokevirtual isEmpty : ()Z
    //   76: ifne -> 128
    //   79: ldc_w 'Crash regular filter for crash stack is: %s'
    //   82: iconst_1
    //   83: anewarray java/lang/Object
    //   86: dup
    //   87: iconst_0
    //   88: getstatic com/tencent/bugly/crashreport/crash/c.o : Ljava/lang/String;
    //   91: aastore
    //   92: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   95: pop
    //   96: getstatic com/tencent/bugly/crashreport/crash/c.o : Ljava/lang/String;
    //   99: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   102: aload_1
    //   103: getfield q : Ljava/lang/String;
    //   106: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   109: invokevirtual find : ()Z
    //   112: ifeq -> 128
    //   115: ldc_w 'This crash matches the regular filter string set. It will not be record and upload.'
    //   118: iconst_0
    //   119: anewarray java/lang/Object
    //   122: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   125: pop
    //   126: iconst_1
    //   127: ireturn
    //   128: aload_1
    //   129: getfield b : I
    //   132: iconst_2
    //   133: if_icmpeq -> 204
    //   136: new com/tencent/bugly/proguard/r
    //   139: dup
    //   140: invokespecial <init> : ()V
    //   143: astore_3
    //   144: aload_3
    //   145: iconst_1
    //   146: putfield b : I
    //   149: aload_3
    //   150: aload_1
    //   151: getfield A : Ljava/lang/String;
    //   154: putfield c : Ljava/lang/String;
    //   157: aload_3
    //   158: aload_1
    //   159: getfield B : Ljava/lang/String;
    //   162: putfield d : Ljava/lang/String;
    //   165: aload_3
    //   166: aload_1
    //   167: getfield r : J
    //   170: putfield e : J
    //   173: aload_0
    //   174: getfield d : Lcom/tencent/bugly/proguard/p;
    //   177: iconst_1
    //   178: invokevirtual b : (I)V
    //   181: aload_0
    //   182: getfield d : Lcom/tencent/bugly/proguard/p;
    //   185: aload_3
    //   186: invokevirtual a : (Lcom/tencent/bugly/proguard/r;)Z
    //   189: pop
    //   190: ldc_w '[crash] a crash occur, handling...'
    //   193: iconst_0
    //   194: anewarray java/lang/Object
    //   197: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   200: pop
    //   201: goto -> 215
    //   204: ldc_w '[crash] a caught exception occur, handling...'
    //   207: iconst_0
    //   208: anewarray java/lang/Object
    //   211: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   214: pop
    //   215: aload_0
    //   216: invokespecial b : ()Ljava/util/List;
    //   219: astore #6
    //   221: aconst_null
    //   222: astore #4
    //   224: aload #4
    //   226: astore_3
    //   227: aload #6
    //   229: ifnull -> 634
    //   232: aload #4
    //   234: astore_3
    //   235: aload #6
    //   237: invokeinterface size : ()I
    //   242: ifle -> 634
    //   245: new java/util/ArrayList
    //   248: dup
    //   249: bipush #10
    //   251: invokespecial <init> : (I)V
    //   254: astore #4
    //   256: new java/util/ArrayList
    //   259: dup
    //   260: bipush #10
    //   262: invokespecial <init> : (I)V
    //   265: astore #5
    //   267: aload #4
    //   269: aload #6
    //   271: invokestatic a : (Ljava/util/List;)Ljava/util/List;
    //   274: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   279: pop
    //   280: aload #6
    //   282: aload #4
    //   284: invokeinterface removeAll : (Ljava/util/Collection;)Z
    //   289: pop
    //   290: aload #6
    //   292: invokeinterface size : ()I
    //   297: i2l
    //   298: ldc2_w 20
    //   301: lcmp
    //   302: ifle -> 432
    //   305: new java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial <init> : ()V
    //   312: astore_3
    //   313: aload_3
    //   314: ldc_w '_id in '
    //   317: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload_3
    //   322: ldc_w '('
    //   325: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload_3
    //   330: ldc_w 'SELECT _id'
    //   333: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload_3
    //   338: ldc_w ' FROM t_cr'
    //   341: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload_3
    //   346: ldc_w ' order by _id'
    //   349: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload_3
    //   354: ldc_w ' limit 5'
    //   357: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: aload_3
    //   362: ldc_w ')'
    //   365: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload_3
    //   370: invokevirtual toString : ()Ljava/lang/String;
    //   373: astore #7
    //   375: aload_3
    //   376: iconst_0
    //   377: invokevirtual setLength : (I)V
    //   380: ldc_w 'deleted first record %s data %d'
    //   383: iconst_2
    //   384: anewarray java/lang/Object
    //   387: dup
    //   388: iconst_0
    //   389: ldc_w 't_cr'
    //   392: aastore
    //   393: dup
    //   394: iconst_1
    //   395: invokestatic a : ()Lcom/tencent/bugly/proguard/p;
    //   398: ldc_w 't_cr'
    //   401: aload #7
    //   403: aconst_null
    //   404: aconst_null
    //   405: iconst_1
    //   406: invokevirtual a : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/tencent/bugly/proguard/o;Z)I
    //   409: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   412: aastore
    //   413: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   416: pop
    //   417: goto -> 432
    //   420: astore_3
    //   421: aload_3
    //   422: invokestatic a : (Ljava/lang/Throwable;)Z
    //   425: ifne -> 432
    //   428: aload_3
    //   429: invokevirtual printStackTrace : ()V
    //   432: aload #4
    //   434: astore_3
    //   435: getstatic com/tencent/bugly/b.c : Z
    //   438: ifne -> 634
    //   441: aload #4
    //   443: astore_3
    //   444: getstatic com/tencent/bugly/crashreport/crash/c.d : Z
    //   447: ifeq -> 634
    //   450: aload #6
    //   452: invokeinterface iterator : ()Ljava/util/Iterator;
    //   457: astore_3
    //   458: iconst_0
    //   459: istore_2
    //   460: aload_3
    //   461: invokeinterface hasNext : ()Z
    //   466: ifeq -> 518
    //   469: aload_3
    //   470: invokeinterface next : ()Ljava/lang/Object;
    //   475: checkcast com/tencent/bugly/crashreport/crash/a
    //   478: astore #6
    //   480: aload_1
    //   481: getfield u : Ljava/lang/String;
    //   484: aload #6
    //   486: getfield c : Ljava/lang/String;
    //   489: invokevirtual equals : (Ljava/lang/Object;)Z
    //   492: ifeq -> 460
    //   495: aload #6
    //   497: getfield e : Z
    //   500: ifeq -> 505
    //   503: iconst_1
    //   504: istore_2
    //   505: aload #5
    //   507: aload #6
    //   509: invokeinterface add : (Ljava/lang/Object;)Z
    //   514: pop
    //   515: goto -> 460
    //   518: iload_2
    //   519: ifne -> 538
    //   522: aload #4
    //   524: astore_3
    //   525: aload #5
    //   527: invokeinterface size : ()I
    //   532: getstatic com/tencent/bugly/crashreport/crash/c.c : I
    //   535: if_icmplt -> 634
    //   538: ldc_w 'same crash occur too much do merged!'
    //   541: iconst_0
    //   542: anewarray java/lang/Object
    //   545: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   548: pop
    //   549: aload_0
    //   550: aload #5
    //   552: aload_1
    //   553: invokespecial a : (Ljava/util/List;Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;
    //   556: astore_1
    //   557: aload #5
    //   559: invokeinterface iterator : ()Ljava/util/Iterator;
    //   564: astore_3
    //   565: aload_3
    //   566: invokeinterface hasNext : ()Z
    //   571: ifeq -> 611
    //   574: aload_3
    //   575: invokeinterface next : ()Ljava/lang/Object;
    //   580: checkcast com/tencent/bugly/crashreport/crash/a
    //   583: astore #5
    //   585: aload #5
    //   587: getfield a : J
    //   590: aload_1
    //   591: getfield a : J
    //   594: lcmp
    //   595: ifeq -> 565
    //   598: aload #4
    //   600: aload #5
    //   602: invokeinterface add : (Ljava/lang/Object;)Z
    //   607: pop
    //   608: goto -> 565
    //   611: aload_0
    //   612: aload_1
    //   613: invokevirtual e : (Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   616: aload #4
    //   618: invokestatic c : (Ljava/util/List;)V
    //   621: ldc_w '[crash] save crash success. For this device crash many times, it will not upload crashes immediately'
    //   624: iconst_0
    //   625: anewarray java/lang/Object
    //   628: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   631: pop
    //   632: iconst_1
    //   633: ireturn
    //   634: aload_0
    //   635: aload_1
    //   636: invokevirtual e : (Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   639: aload_3
    //   640: ifnull -> 656
    //   643: aload_3
    //   644: invokeinterface isEmpty : ()Z
    //   649: ifne -> 656
    //   652: aload_3
    //   653: invokestatic c : (Ljava/util/List;)V
    //   656: ldc_w '[crash] save crash success'
    //   659: iconst_0
    //   660: anewarray java/lang/Object
    //   663: invokestatic b : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   666: pop
    //   667: iconst_0
    //   668: ireturn
    // Exception table:
    //   from	to	target	type
    //   380	417	420	finally
  }
  
  public final void c(CrashDetailBean paramCrashDetailBean) {
    int i = paramCrashDetailBean.b;
    if (i != 0) {
      if (i != 1) {
        if (i == 3 && !c.a().p())
          return; 
      } else if (!c.a().o()) {
        return;
      } 
    } else if (!c.a().o()) {
      return;
    } 
    if (this.f != null) {
      x.c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
      o o1 = this.f;
      i = paramCrashDetailBean.b;
    } 
  }
  
  public final void d(CrashDetailBean paramCrashDetailBean) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 5
    //   4: return
    //   5: aload_0
    //   6: getfield g : Lcom/tencent/bugly/BuglyStrategy$a;
    //   9: ifnonnull -> 20
    //   12: aload_0
    //   13: getfield f : Lcom/tencent/bugly/proguard/o;
    //   16: ifnonnull -> 20
    //   19: return
    //   20: aload_1
    //   21: getfield b : I
    //   24: tableswitch default -> 896, 0 -> 131, 1 -> 121, 2 -> 903, 3 -> 109, 4 -> 97, 5 -> 85, 6 -> 72, 7 -> 897
    //   72: bipush #6
    //   74: istore_2
    //   75: invokestatic a : ()Lcom/tencent/bugly/crashreport/crash/c;
    //   78: invokevirtual s : ()Z
    //   81: ifne -> 141
    //   84: return
    //   85: iconst_5
    //   86: istore_2
    //   87: invokestatic a : ()Lcom/tencent/bugly/crashreport/crash/c;
    //   90: invokevirtual r : ()Z
    //   93: ifne -> 141
    //   96: return
    //   97: iconst_3
    //   98: istore_2
    //   99: invokestatic a : ()Lcom/tencent/bugly/crashreport/crash/c;
    //   102: invokevirtual q : ()Z
    //   105: ifne -> 141
    //   108: return
    //   109: iconst_4
    //   110: istore_2
    //   111: invokestatic a : ()Lcom/tencent/bugly/crashreport/crash/c;
    //   114: invokevirtual p : ()Z
    //   117: ifne -> 141
    //   120: return
    //   121: invokestatic a : ()Lcom/tencent/bugly/crashreport/crash/c;
    //   124: invokevirtual o : ()Z
    //   127: ifne -> 908
    //   130: return
    //   131: invokestatic a : ()Lcom/tencent/bugly/crashreport/crash/c;
    //   134: invokevirtual o : ()Z
    //   137: ifne -> 913
    //   140: return
    //   141: aload_1
    //   142: getfield b : I
    //   145: istore_3
    //   146: aload_1
    //   147: getfield n : Ljava/lang/String;
    //   150: astore #6
    //   152: aload_1
    //   153: getfield p : Ljava/lang/String;
    //   156: astore #6
    //   158: aload_1
    //   159: getfield q : Ljava/lang/String;
    //   162: astore #6
    //   164: aload_1
    //   165: getfield r : J
    //   168: lstore #4
    //   170: aload_0
    //   171: getfield f : Lcom/tencent/bugly/proguard/o;
    //   174: astore #6
    //   176: aconst_null
    //   177: astore #8
    //   179: aload #6
    //   181: ifnull -> 254
    //   184: ldc_w 'Calling 'onCrashHandleStart' of RQD crash listener.'
    //   187: iconst_0
    //   188: anewarray java/lang/Object
    //   191: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   194: pop
    //   195: aload_0
    //   196: getfield f : Lcom/tencent/bugly/proguard/o;
    //   199: astore #6
    //   201: ldc_w 'Calling 'getCrashExtraMessage' of RQD crash listener.'
    //   204: iconst_0
    //   205: anewarray java/lang/Object
    //   208: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   211: pop
    //   212: aload_0
    //   213: getfield f : Lcom/tencent/bugly/proguard/o;
    //   216: invokeinterface b : ()Ljava/lang/String;
    //   221: astore #7
    //   223: aload #7
    //   225: ifnull -> 918
    //   228: new java/util/HashMap
    //   231: dup
    //   232: iconst_1
    //   233: invokespecial <init> : (I)V
    //   236: astore #6
    //   238: aload #6
    //   240: ldc_w 'userData'
    //   243: aload #7
    //   245: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   250: pop
    //   251: goto -> 921
    //   254: aload_0
    //   255: getfield g : Lcom/tencent/bugly/BuglyStrategy$a;
    //   258: ifnull -> 924
    //   261: ldc_w 'Calling 'onCrashHandleStart' of Bugly crash listener.'
    //   264: iconst_0
    //   265: anewarray java/lang/Object
    //   268: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   271: pop
    //   272: aload_0
    //   273: getfield g : Lcom/tencent/bugly/BuglyStrategy$a;
    //   276: iload_2
    //   277: aload_1
    //   278: getfield n : Ljava/lang/String;
    //   281: aload_1
    //   282: getfield o : Ljava/lang/String;
    //   285: aload_1
    //   286: getfield q : Ljava/lang/String;
    //   289: invokevirtual onCrashHandleStart : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   292: astore #6
    //   294: goto -> 297
    //   297: aload #6
    //   299: ifnull -> 613
    //   302: aload #6
    //   304: invokeinterface size : ()I
    //   309: ifle -> 613
    //   312: aload_1
    //   313: new java/util/LinkedHashMap
    //   316: dup
    //   317: aload #6
    //   319: invokeinterface size : ()I
    //   324: invokespecial <init> : (I)V
    //   327: putfield O : Ljava/util/Map;
    //   330: aload #6
    //   332: invokeinterface entrySet : ()Ljava/util/Set;
    //   337: invokeinterface iterator : ()Ljava/util/Iterator;
    //   342: astore #9
    //   344: aload #9
    //   346: invokeinterface hasNext : ()Z
    //   351: ifeq -> 613
    //   354: aload #9
    //   356: invokeinterface next : ()Ljava/lang/Object;
    //   361: checkcast java/util/Map$Entry
    //   364: astore #10
    //   366: aload #10
    //   368: invokeinterface getKey : ()Ljava/lang/Object;
    //   373: checkcast java/lang/String
    //   376: invokestatic a : (Ljava/lang/String;)Z
    //   379: ifne -> 344
    //   382: aload #10
    //   384: invokeinterface getKey : ()Ljava/lang/Object;
    //   389: checkcast java/lang/String
    //   392: astore #7
    //   394: aload #7
    //   396: astore #6
    //   398: aload #7
    //   400: invokevirtual length : ()I
    //   403: bipush #100
    //   405: if_icmple -> 442
    //   408: aload #7
    //   410: iconst_0
    //   411: bipush #100
    //   413: invokevirtual substring : (II)Ljava/lang/String;
    //   416: astore #6
    //   418: ldc_w 'setted key length is over limit %d substring to %s'
    //   421: iconst_2
    //   422: anewarray java/lang/Object
    //   425: dup
    //   426: iconst_0
    //   427: bipush #100
    //   429: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   432: aastore
    //   433: dup
    //   434: iconst_1
    //   435: aload #6
    //   437: aastore
    //   438: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   441: pop
    //   442: aload #10
    //   444: invokeinterface getValue : ()Ljava/lang/Object;
    //   449: checkcast java/lang/String
    //   452: invokestatic a : (Ljava/lang/String;)Z
    //   455: ifne -> 537
    //   458: aload #10
    //   460: invokeinterface getValue : ()Ljava/lang/Object;
    //   465: checkcast java/lang/String
    //   468: invokevirtual length : ()I
    //   471: sipush #30000
    //   474: if_icmple -> 537
    //   477: aload #10
    //   479: invokeinterface getValue : ()Ljava/lang/Object;
    //   484: checkcast java/lang/String
    //   487: aload #10
    //   489: invokeinterface getValue : ()Ljava/lang/Object;
    //   494: checkcast java/lang/String
    //   497: invokevirtual length : ()I
    //   500: sipush #30000
    //   503: isub
    //   504: invokevirtual substring : (I)Ljava/lang/String;
    //   507: astore #7
    //   509: ldc_w 'setted %s value length is over limit %d substring'
    //   512: iconst_2
    //   513: anewarray java/lang/Object
    //   516: dup
    //   517: iconst_0
    //   518: aload #6
    //   520: aastore
    //   521: dup
    //   522: iconst_1
    //   523: sipush #30000
    //   526: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   529: aastore
    //   530: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   533: pop
    //   534: goto -> 569
    //   537: new java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial <init> : ()V
    //   544: astore #7
    //   546: aload #7
    //   548: aload #10
    //   550: invokeinterface getValue : ()Ljava/lang/Object;
    //   555: checkcast java/lang/String
    //   558: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: pop
    //   562: aload #7
    //   564: invokevirtual toString : ()Ljava/lang/String;
    //   567: astore #7
    //   569: aload_1
    //   570: getfield O : Ljava/util/Map;
    //   573: aload #6
    //   575: aload #7
    //   577: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   582: pop
    //   583: ldc_w 'add setted key %s value size:%d'
    //   586: iconst_2
    //   587: anewarray java/lang/Object
    //   590: dup
    //   591: iconst_0
    //   592: aload #6
    //   594: aastore
    //   595: dup
    //   596: iconst_1
    //   597: aload #7
    //   599: invokevirtual length : ()I
    //   602: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   605: aastore
    //   606: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   609: pop
    //   610: goto -> 344
    //   613: ldc_w '[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()'
    //   616: iconst_0
    //   617: anewarray java/lang/Object
    //   620: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   623: pop
    //   624: aload_0
    //   625: getfield f : Lcom/tencent/bugly/proguard/o;
    //   628: ifnull -> 656
    //   631: ldc_w 'Calling 'getCrashExtraData' of RQD crash listener.'
    //   634: iconst_0
    //   635: anewarray java/lang/Object
    //   638: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   641: pop
    //   642: aload_0
    //   643: getfield f : Lcom/tencent/bugly/proguard/o;
    //   646: invokeinterface a : ()[B
    //   651: astore #6
    //   653: goto -> 700
    //   656: aload #8
    //   658: astore #6
    //   660: aload_0
    //   661: getfield g : Lcom/tencent/bugly/BuglyStrategy$a;
    //   664: ifnull -> 700
    //   667: ldc_w 'Calling 'onCrashHandleStart2GetExtraDatas' of Bugly crash listener.'
    //   670: iconst_0
    //   671: anewarray java/lang/Object
    //   674: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   677: pop
    //   678: aload_0
    //   679: getfield g : Lcom/tencent/bugly/BuglyStrategy$a;
    //   682: iload_2
    //   683: aload_1
    //   684: getfield n : Ljava/lang/String;
    //   687: aload_1
    //   688: getfield o : Ljava/lang/String;
    //   691: aload_1
    //   692: getfield q : Ljava/lang/String;
    //   695: invokevirtual onCrashHandleStart2GetExtraDatas : (ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)[B
    //   698: astore #6
    //   700: aload_1
    //   701: aload #6
    //   703: putfield U : [B
    //   706: aload #6
    //   708: ifnull -> 781
    //   711: aload #6
    //   713: arraylength
    //   714: sipush #30000
    //   717: if_icmple -> 761
    //   720: ldc_w 'extra bytes size %d is over limit %d will drop over part'
    //   723: iconst_2
    //   724: anewarray java/lang/Object
    //   727: dup
    //   728: iconst_0
    //   729: aload #6
    //   731: arraylength
    //   732: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   735: aastore
    //   736: dup
    //   737: iconst_1
    //   738: sipush #30000
    //   741: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   744: aastore
    //   745: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   748: pop
    //   749: aload_1
    //   750: aload #6
    //   752: sipush #30000
    //   755: invokestatic copyOf : ([BI)[B
    //   758: putfield U : [B
    //   761: ldc_w 'add extra bytes %d '
    //   764: iconst_1
    //   765: anewarray java/lang/Object
    //   768: dup
    //   769: iconst_0
    //   770: aload #6
    //   772: arraylength
    //   773: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   776: aastore
    //   777: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   780: pop
    //   781: aload_0
    //   782: getfield f : Lcom/tencent/bugly/proguard/o;
    //   785: ifnull -> 861
    //   788: ldc_w 'Calling 'onCrashSaving' of RQD crash listener.'
    //   791: iconst_0
    //   792: anewarray java/lang/Object
    //   795: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   798: pop
    //   799: aload_0
    //   800: getfield f : Lcom/tencent/bugly/proguard/o;
    //   803: astore #6
    //   805: aload_1
    //   806: getfield o : Ljava/lang/String;
    //   809: astore #7
    //   811: aload_1
    //   812: getfield m : Ljava/lang/String;
    //   815: astore #7
    //   817: aload_1
    //   818: getfield e : Ljava/lang/String;
    //   821: astore #7
    //   823: aload_1
    //   824: getfield c : Ljava/lang/String;
    //   827: astore #7
    //   829: aload_1
    //   830: getfield A : Ljava/lang/String;
    //   833: astore #7
    //   835: aload_1
    //   836: getfield B : Ljava/lang/String;
    //   839: astore_1
    //   840: aload #6
    //   842: invokeinterface c : ()Z
    //   847: ifne -> 861
    //   850: ldc_w 'Crash listener 'onCrashSaving' return 'false' thus will not handle this crash.'
    //   853: iconst_0
    //   854: anewarray java/lang/Object
    //   857: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   860: pop
    //   861: return
    //   862: astore_1
    //   863: ldc_w 'crash handle callback something wrong! %s'
    //   866: iconst_1
    //   867: anewarray java/lang/Object
    //   870: dup
    //   871: iconst_0
    //   872: aload_1
    //   873: invokevirtual getClass : ()Ljava/lang/Class;
    //   876: invokevirtual getName : ()Ljava/lang/String;
    //   879: aastore
    //   880: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   883: pop
    //   884: aload_1
    //   885: invokestatic a : (Ljava/lang/Throwable;)Z
    //   888: ifne -> 895
    //   891: aload_1
    //   892: invokevirtual printStackTrace : ()V
    //   895: return
    //   896: return
    //   897: bipush #7
    //   899: istore_2
    //   900: goto -> 141
    //   903: iconst_1
    //   904: istore_2
    //   905: goto -> 141
    //   908: iconst_2
    //   909: istore_2
    //   910: goto -> 141
    //   913: iconst_0
    //   914: istore_2
    //   915: goto -> 141
    //   918: aconst_null
    //   919: astore #6
    //   921: goto -> 297
    //   924: aconst_null
    //   925: astore #6
    //   927: goto -> 297
    // Exception table:
    //   from	to	target	type
    //   20	72	862	finally
    //   75	84	862	finally
    //   87	96	862	finally
    //   99	108	862	finally
    //   111	120	862	finally
    //   121	130	862	finally
    //   131	140	862	finally
    //   141	176	862	finally
    //   184	223	862	finally
    //   228	251	862	finally
    //   254	294	862	finally
    //   302	344	862	finally
    //   344	394	862	finally
    //   398	442	862	finally
    //   442	534	862	finally
    //   537	569	862	finally
    //   569	610	862	finally
    //   613	653	862	finally
    //   660	700	862	finally
    //   700	706	862	finally
    //   711	761	862	finally
    //   761	781	862	finally
    //   781	861	862	finally
  }
  
  public final void e(CrashDetailBean paramCrashDetailBean) {
    if (paramCrashDetailBean == null)
      return; 
    ContentValues contentValues = f(paramCrashDetailBean);
    if (contentValues != null) {
      long l = p.a().a("t_cr", contentValues, null, true);
      if (l >= 0L) {
        x.c("insert %s success!", new Object[] { "t_cr" });
        paramCrashDetailBean.a = l;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\crashreport\crash\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */