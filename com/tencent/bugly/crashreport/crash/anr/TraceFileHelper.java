package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.x;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class TraceFileHelper {
  private static String a(BufferedReader paramBufferedReader) throws IOException {
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < 3; i++) {
      String str = paramBufferedReader.readLine();
      if (str == null)
        return null; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append("\n");
      stringBuffer.append(stringBuilder.toString());
    } 
    return stringBuffer.toString();
  }
  
  private static Object[] a(BufferedReader paramBufferedReader, Pattern... paramVarArgs) throws IOException {
    if (paramBufferedReader != null) {
      if (paramVarArgs == null)
        return null; 
      while (true) {
        String str = paramBufferedReader.readLine();
        if (str != null) {
          int j = paramVarArgs.length;
          for (int i = 0; i < j; i++) {
            Pattern pattern = paramVarArgs[i];
            if (pattern.matcher(str).matches())
              return new Object[] { pattern, str }; 
          } 
          continue;
        } 
        break;
      } 
    } 
    return null;
  }
  
  private static String b(BufferedReader paramBufferedReader) throws IOException {
    StringBuffer stringBuffer = new StringBuffer();
    while (true) {
      String str = paramBufferedReader.readLine();
      if (str != null && str.trim().length() > 0) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("\n");
        stringBuffer.append(stringBuilder.toString());
        continue;
      } 
      break;
    } 
    return stringBuffer.toString();
  }
  
  public static a readFirstDumpInfo(String paramString, boolean paramBoolean) {
    if (paramString == null) {
      x.e("path:%s", new Object[] { paramString });
      return null;
    } 
    a a = new a();
    readTraceFile(paramString, new b(a, paramBoolean) {
          public final boolean a(long param1Long) {
            x.c("process end %d", new Object[] { Long.valueOf(param1Long) });
            return false;
          }
          
          public final boolean a(long param1Long1, long param1Long2, String param1String) {
            x.c("new process %s", new Object[] { param1String });
            TraceFileHelper.a a1 = this.a;
            a1.a = param1Long1;
            a1.b = param1String;
            a1.c = param1Long2;
            return !!this.b;
          }
          
          public final boolean a(String param1String1, int param1Int, String param1String2, String param1String3) {
            x.c("new thread %s", new Object[] { param1String1 });
            if (this.a.d == null)
              this.a.d = (Map)new HashMap<String, String>(); 
            Map<String, String[]> map = this.a.d;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(param1Int);
            map.put(param1String1, new String[] { param1String2, param1String3, stringBuilder.toString() });
            return true;
          }
        });
    if (a.a > 0L && a.c > 0L && a.b != null)
      return a; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a.a);
    stringBuilder.append(" ");
    stringBuilder.append(a.c);
    stringBuilder.append(" ");
    stringBuilder.append(a.b);
    x.e("first dump error %s", new Object[] { stringBuilder.toString() });
    return null;
  }
  
  public static a readTargetDumpInfo(String paramString1, String paramString2, boolean paramBoolean) {
    if (paramString1 != null) {
      if (paramString2 == null)
        return null; 
      a a = new a();
      readTraceFile(paramString2, new b(a, paramString1, paramBoolean) {
            public final boolean a(long param1Long) {
              x.c("process end %d", new Object[] { Long.valueOf(param1Long) });
              return (this.a.a > 0L && this.a.c > 0L) ? ((this.a.b == null)) : true;
            }
            
            public final boolean a(long param1Long1, long param1Long2, String param1String) {
              x.c("new process %s", new Object[] { param1String });
              if (!param1String.equals(this.b))
                return true; 
              TraceFileHelper.a a1 = this.a;
              a1.a = param1Long1;
              a1.b = param1String;
              a1.c = param1Long2;
              return !!this.c;
            }
            
            public final boolean a(String param1String1, int param1Int, String param1String2, String param1String3) {
              x.c("new thread %s", new Object[] { param1String1 });
              if (this.a.a > 0L && this.a.c > 0L) {
                if (this.a.b == null)
                  return true; 
                if (this.a.d == null)
                  this.a.d = (Map)new HashMap<String, String>(); 
                Map<String, String[]> map = this.a.d;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(param1Int);
                map.put(param1String1, new String[] { param1String2, param1String3, stringBuilder.toString() });
              } 
              return true;
            }
          });
      if (a.a > 0L && a.c > 0L && a.b != null)
        return a; 
    } 
    return null;
  }
  
  public static void readTraceFile(String paramString, b paramb) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 688
    //   4: aload_1
    //   5: ifnonnull -> 9
    //   8: return
    //   9: new java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial <init> : (Ljava/lang/String;)V
    //   17: astore #7
    //   19: aload #7
    //   21: invokevirtual exists : ()Z
    //   24: ifne -> 28
    //   27: return
    //   28: aload #7
    //   30: invokevirtual lastModified : ()J
    //   33: pop2
    //   34: aload #7
    //   36: invokevirtual length : ()J
    //   39: pop2
    //   40: aconst_null
    //   41: astore #8
    //   43: aconst_null
    //   44: astore_0
    //   45: new java/io/BufferedReader
    //   48: dup
    //   49: new java/io/FileReader
    //   52: dup
    //   53: aload #7
    //   55: invokespecial <init> : (Ljava/io/File;)V
    //   58: invokespecial <init> : (Ljava/io/Reader;)V
    //   61: astore #7
    //   63: ldc '-{5}\spid\s\d+\sat\s\d+-\d+-\d+\s\d{2}:\d{2}:\d{2}\s-{5}'
    //   65: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   68: astore #8
    //   70: ldc '-{5}\send\s\d+\s-{5}'
    //   72: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   75: astore #9
    //   77: ldc 'Cmd\sline:\s(\S+)'
    //   79: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   82: astore #10
    //   84: ldc '".+"\s(daemon\s){0,1}prio=\d+\stid=\d+\s.*'
    //   86: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   89: astore #11
    //   91: new java/text/SimpleDateFormat
    //   94: dup
    //   95: ldc 'yyyy-MM-dd HH:mm:ss'
    //   97: getstatic java/util/Locale.US : Ljava/util/Locale;
    //   100: invokespecial <init> : (Ljava/lang/String;Ljava/util/Locale;)V
    //   103: astore_0
    //   104: aload #7
    //   106: iconst_1
    //   107: anewarray java/util/regex/Pattern
    //   110: dup
    //   111: iconst_0
    //   112: aload #8
    //   114: aastore
    //   115: invokestatic a : (Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   118: astore #12
    //   120: aload #12
    //   122: ifnull -> 514
    //   125: aload #12
    //   127: iconst_1
    //   128: aaload
    //   129: invokevirtual toString : ()Ljava/lang/String;
    //   132: ldc '\s'
    //   134: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   137: astore #12
    //   139: aload #12
    //   141: iconst_2
    //   142: aaload
    //   143: invokestatic parseLong : (Ljava/lang/String;)J
    //   146: lstore_2
    //   147: new java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial <init> : ()V
    //   154: astore #13
    //   156: aload #13
    //   158: aload #12
    //   160: iconst_4
    //   161: aaload
    //   162: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload #13
    //   168: ldc ' '
    //   170: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload #13
    //   176: aload #12
    //   178: iconst_5
    //   179: aaload
    //   180: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_0
    //   185: aload #13
    //   187: invokevirtual toString : ()Ljava/lang/String;
    //   190: invokevirtual parse : (Ljava/lang/String;)Ljava/util/Date;
    //   193: invokevirtual getTime : ()J
    //   196: lstore #4
    //   198: aload #7
    //   200: iconst_1
    //   201: anewarray java/util/regex/Pattern
    //   204: dup
    //   205: iconst_0
    //   206: aload #10
    //   208: aastore
    //   209: invokestatic a : (Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   212: astore #12
    //   214: aload #12
    //   216: ifnonnull -> 238
    //   219: aload #7
    //   221: invokevirtual close : ()V
    //   224: return
    //   225: astore_0
    //   226: aload_0
    //   227: invokestatic a : (Ljava/lang/Throwable;)Z
    //   230: ifne -> 237
    //   233: aload_0
    //   234: invokevirtual printStackTrace : ()V
    //   237: return
    //   238: aload #10
    //   240: aload #12
    //   242: iconst_1
    //   243: aaload
    //   244: invokevirtual toString : ()Ljava/lang/String;
    //   247: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   250: astore #12
    //   252: aload #12
    //   254: invokevirtual find : ()Z
    //   257: pop
    //   258: aload #12
    //   260: iconst_1
    //   261: invokevirtual group : (I)Ljava/lang/String;
    //   264: pop
    //   265: aload_1
    //   266: lload_2
    //   267: lload #4
    //   269: aload #12
    //   271: iconst_1
    //   272: invokevirtual group : (I)Ljava/lang/String;
    //   275: invokeinterface a : (JJLjava/lang/String;)Z
    //   280: istore #6
    //   282: iload #6
    //   284: ifne -> 306
    //   287: aload #7
    //   289: invokevirtual close : ()V
    //   292: return
    //   293: astore_0
    //   294: aload_0
    //   295: invokestatic a : (Ljava/lang/Throwable;)Z
    //   298: ifne -> 305
    //   301: aload_0
    //   302: invokevirtual printStackTrace : ()V
    //   305: return
    //   306: aload #7
    //   308: iconst_2
    //   309: anewarray java/util/regex/Pattern
    //   312: dup
    //   313: iconst_0
    //   314: aload #11
    //   316: aastore
    //   317: dup
    //   318: iconst_1
    //   319: aload #9
    //   321: aastore
    //   322: invokestatic a : (Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   325: astore #12
    //   327: aload #12
    //   329: ifnull -> 511
    //   332: aload #12
    //   334: iconst_0
    //   335: aaload
    //   336: aload #11
    //   338: if_acmpne -> 462
    //   341: aload #12
    //   343: iconst_1
    //   344: aaload
    //   345: invokevirtual toString : ()Ljava/lang/String;
    //   348: astore #12
    //   350: ldc '".+"'
    //   352: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   355: aload #12
    //   357: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   360: astore #13
    //   362: aload #13
    //   364: invokevirtual find : ()Z
    //   367: pop
    //   368: aload #13
    //   370: invokevirtual group : ()Ljava/lang/String;
    //   373: astore #13
    //   375: aload #13
    //   377: iconst_1
    //   378: aload #13
    //   380: invokevirtual length : ()I
    //   383: iconst_1
    //   384: isub
    //   385: invokevirtual substring : (II)Ljava/lang/String;
    //   388: astore #13
    //   390: aload #12
    //   392: ldc 'NATIVE'
    //   394: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   397: pop
    //   398: ldc 'tid=\d+'
    //   400: invokestatic compile : (Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   403: aload #12
    //   405: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   408: astore #12
    //   410: aload #12
    //   412: invokevirtual find : ()Z
    //   415: pop
    //   416: aload #12
    //   418: invokevirtual group : ()Ljava/lang/String;
    //   421: astore #12
    //   423: aload_1
    //   424: aload #13
    //   426: aload #12
    //   428: aload #12
    //   430: ldc '='
    //   432: invokevirtual indexOf : (Ljava/lang/String;)I
    //   435: iconst_1
    //   436: iadd
    //   437: invokevirtual substring : (I)Ljava/lang/String;
    //   440: invokestatic parseInt : (Ljava/lang/String;)I
    //   443: aload #7
    //   445: invokestatic a : (Ljava/io/BufferedReader;)Ljava/lang/String;
    //   448: aload #7
    //   450: invokestatic b : (Ljava/io/BufferedReader;)Ljava/lang/String;
    //   453: invokeinterface a : (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Z
    //   458: pop
    //   459: goto -> 306
    //   462: aload_1
    //   463: aload #12
    //   465: iconst_1
    //   466: aaload
    //   467: invokevirtual toString : ()Ljava/lang/String;
    //   470: ldc '\s'
    //   472: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   475: iconst_2
    //   476: aaload
    //   477: invokestatic parseLong : (Ljava/lang/String;)J
    //   480: invokeinterface a : (J)Z
    //   485: istore #6
    //   487: iload #6
    //   489: ifne -> 511
    //   492: aload #7
    //   494: invokevirtual close : ()V
    //   497: return
    //   498: astore_0
    //   499: aload_0
    //   500: invokestatic a : (Ljava/lang/Throwable;)Z
    //   503: ifne -> 510
    //   506: aload_0
    //   507: invokevirtual printStackTrace : ()V
    //   510: return
    //   511: goto -> 104
    //   514: aload #7
    //   516: invokevirtual close : ()V
    //   519: return
    //   520: astore_0
    //   521: aload_0
    //   522: invokestatic a : (Ljava/lang/Throwable;)Z
    //   525: ifne -> 532
    //   528: aload_0
    //   529: invokevirtual printStackTrace : ()V
    //   532: return
    //   533: astore_0
    //   534: goto -> 661
    //   537: astore_0
    //   538: aload #7
    //   540: astore_1
    //   541: aload_0
    //   542: astore #7
    //   544: goto -> 561
    //   547: astore_1
    //   548: aload_0
    //   549: astore #7
    //   551: aload_1
    //   552: astore_0
    //   553: goto -> 661
    //   556: astore #7
    //   558: aload #8
    //   560: astore_1
    //   561: aload_1
    //   562: astore_0
    //   563: aload #7
    //   565: invokestatic a : (Ljava/lang/Throwable;)Z
    //   568: ifne -> 578
    //   571: aload_1
    //   572: astore_0
    //   573: aload #7
    //   575: invokevirtual printStackTrace : ()V
    //   578: aload_1
    //   579: astore_0
    //   580: aload #7
    //   582: invokevirtual getClass : ()Ljava/lang/Class;
    //   585: invokevirtual getName : ()Ljava/lang/String;
    //   588: astore #8
    //   590: aload_1
    //   591: astore_0
    //   592: new java/lang/StringBuilder
    //   595: dup
    //   596: invokespecial <init> : ()V
    //   599: astore #9
    //   601: aload_1
    //   602: astore_0
    //   603: aload #9
    //   605: aload #7
    //   607: invokevirtual getMessage : ()Ljava/lang/String;
    //   610: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: pop
    //   614: aload_1
    //   615: astore_0
    //   616: ldc 'trace open fail:%s : %s'
    //   618: iconst_2
    //   619: anewarray java/lang/Object
    //   622: dup
    //   623: iconst_0
    //   624: aload #8
    //   626: aastore
    //   627: dup
    //   628: iconst_1
    //   629: aload #9
    //   631: invokevirtual toString : ()Ljava/lang/String;
    //   634: aastore
    //   635: invokestatic d : (Ljava/lang/String;[Ljava/lang/Object;)Z
    //   638: pop
    //   639: aload_1
    //   640: ifnull -> 660
    //   643: aload_1
    //   644: invokevirtual close : ()V
    //   647: return
    //   648: astore_0
    //   649: aload_0
    //   650: invokestatic a : (Ljava/lang/Throwable;)Z
    //   653: ifne -> 660
    //   656: aload_0
    //   657: invokevirtual printStackTrace : ()V
    //   660: return
    //   661: aload #7
    //   663: ifnull -> 686
    //   666: aload #7
    //   668: invokevirtual close : ()V
    //   671: goto -> 686
    //   674: astore_1
    //   675: aload_1
    //   676: invokestatic a : (Ljava/lang/Throwable;)Z
    //   679: ifne -> 686
    //   682: aload_1
    //   683: invokevirtual printStackTrace : ()V
    //   686: aload_0
    //   687: athrow
    //   688: return
    // Exception table:
    //   from	to	target	type
    //   45	63	556	java/lang/Exception
    //   45	63	547	finally
    //   63	104	537	java/lang/Exception
    //   63	104	533	finally
    //   104	120	537	java/lang/Exception
    //   104	120	533	finally
    //   125	214	537	java/lang/Exception
    //   125	214	533	finally
    //   219	224	225	java/io/IOException
    //   238	282	537	java/lang/Exception
    //   238	282	533	finally
    //   287	292	293	java/io/IOException
    //   306	327	537	java/lang/Exception
    //   306	327	533	finally
    //   341	459	537	java/lang/Exception
    //   341	459	533	finally
    //   462	487	537	java/lang/Exception
    //   462	487	533	finally
    //   492	497	498	java/io/IOException
    //   514	519	520	java/io/IOException
    //   563	571	547	finally
    //   573	578	547	finally
    //   580	590	547	finally
    //   592	601	547	finally
    //   603	614	547	finally
    //   616	639	547	finally
    //   643	647	648	java/io/IOException
    //   666	671	674	java/io/IOException
  }
  
  public static final class a {
    public long a;
    
    public String b;
    
    public long c;
    
    public Map<String, String[]> d;
  }
  
  public static interface b {
    boolean a(long param1Long);
    
    boolean a(long param1Long1, long param1Long2, String param1String);
    
    boolean a(String param1String1, int param1Int, String param1String2, String param1String3);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\crashreport\crash\anr\TraceFileHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */