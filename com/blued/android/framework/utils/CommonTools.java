package com.blued.android.framework.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Environment;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import java.io.File;
import java.io.Reader;
import java.util.List;

public class CommonTools {
  public static final String a;
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("blued");
    stringBuilder.append(File.separator);
    stringBuilder.append("patch");
    a = stringBuilder.toString();
  }
  
  public static long a(String paramString) {
    try {
      return Long.valueOf(paramString).longValue();
    } catch (Exception exception) {
      exception.printStackTrace();
      return 0L;
    } 
  }
  
  public static String a() {
    String str2 = b(a);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = c(a); 
    return str1;
  }
  
  public static void a(Reader paramReader) {
    if (paramReader != null)
      try {
        paramReader.close();
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public static boolean a(Activity paramActivity) {
    return (paramActivity == null) ? false : ((paramActivity != null) ? (!paramActivity.isFinishing()) : false);
  }
  
  public static boolean a(Context paramContext) {
    if (!((PowerManager)paramContext.getSystemService("power")).isScreenOn())
      return false; 
    String str = paramContext.getPackageName();
    ActivityManager activityManager = (ActivityManager)paramContext.getSystemService("activity");
    List list = activityManager.getRunningAppProcesses();
    if (list == null)
      return false; 
    for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
      if (runningAppProcessInfo.processName.equals(str) && runningAppProcessInfo.importance == 100) {
        List list1 = activityManager.getRunningTasks(1);
        if (!list1.isEmpty()) {
          ComponentName componentName = ((ActivityManager.RunningTaskInfo)list1.get(0)).topActivity;
          if (componentName != null && componentName.getPackageName().equals(str))
            return true; 
        } 
      } 
    } 
    return false;
  }
  
  public static boolean a(Fragment paramFragment) {
    return (paramFragment == null || !paramFragment.isAdded()) ? false : a((Activity)paramFragment.getActivity());
  }
  
  public static String b(String paramString) {
    File file;
    if (Environment.getExternalStorageState().equals("mounted")) {
      file = Environment.getExternalStorageDirectory();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("downloadDirs parent:");
      stringBuilder.append(file);
      Log.i("PTH", stringBuilder.toString());
    } else {
      file = null;
    } 
    if (file != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(file.getAbsolutePath());
      stringBuilder.append(File.separator);
      stringBuilder.append(paramString);
      File file1 = new File(stringBuilder.toString());
      if (!file1.exists())
        file1.mkdirs(); 
      if (file1.canRead() && file1.canWrite())
        return file1.getAbsolutePath(); 
      Log.i("PTH", "sdCard can not read or write:");
    } 
    return null;
  }
  
  public static String c(String paramString) {
    File file = AppInfo.d().getFilesDir();
    if (file != null) {
      File file1 = new File(file, paramString);
      if (file1.exists() || file1.mkdirs())
        return file1.getAbsolutePath(); 
    } 
    return null;
  }
  
  public static String d(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifeq -> 10
    //   7: ldc ''
    //   9: areturn
    //   10: iconst_0
    //   11: istore_2
    //   12: new java/net/URL
    //   15: dup
    //   16: aload_0
    //   17: invokespecial <init> : (Ljava/lang/String;)V
    //   20: invokevirtual openConnection : ()Ljava/net/URLConnection;
    //   23: astore_3
    //   24: aload_3
    //   25: ifnonnull -> 30
    //   28: aconst_null
    //   29: areturn
    //   30: aload_3
    //   31: invokevirtual getHeaderFields : ()Ljava/util/Map;
    //   34: astore #8
    //   36: aload #8
    //   38: ifnonnull -> 43
    //   41: aconst_null
    //   42: areturn
    //   43: aload #8
    //   45: invokeinterface keySet : ()Ljava/util/Set;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnonnull -> 57
    //   55: aconst_null
    //   56: areturn
    //   57: aload_3
    //   58: invokeinterface iterator : ()Ljava/util/Iterator;
    //   63: astore #9
    //   65: ldc ''
    //   67: astore #4
    //   69: aload #4
    //   71: astore #5
    //   73: aload #4
    //   75: astore #6
    //   77: aload #4
    //   79: astore #7
    //   81: aload #4
    //   83: astore_3
    //   84: aload #9
    //   86: invokeinterface hasNext : ()Z
    //   91: ifeq -> 445
    //   94: aload #4
    //   96: astore #5
    //   98: aload #4
    //   100: astore #6
    //   102: aload #4
    //   104: astore #7
    //   106: aload #8
    //   108: aload #9
    //   110: invokeinterface next : ()Ljava/lang/Object;
    //   115: checkcast java/lang/String
    //   118: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   123: checkcast java/util/List
    //   126: invokeinterface iterator : ()Ljava/util/Iterator;
    //   131: astore #10
    //   133: aload #4
    //   135: astore_3
    //   136: iload_2
    //   137: istore_1
    //   138: aload_3
    //   139: astore #5
    //   141: aload_3
    //   142: astore #6
    //   144: aload_3
    //   145: astore #7
    //   147: aload #10
    //   149: invokeinterface hasNext : ()Z
    //   154: ifeq -> 301
    //   157: aload_3
    //   158: astore #5
    //   160: aload_3
    //   161: astore #6
    //   163: aload_3
    //   164: astore #7
    //   166: aload #10
    //   168: invokeinterface next : ()Ljava/lang/Object;
    //   173: checkcast java/lang/String
    //   176: astore #4
    //   178: aload_3
    //   179: astore #5
    //   181: aload_3
    //   182: astore #6
    //   184: aload_3
    //   185: astore #7
    //   187: new java/lang/String
    //   190: dup
    //   191: aload #4
    //   193: ldc 'ISO-8859-1'
    //   195: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   198: ldc_w 'GBK'
    //   201: invokespecial <init> : ([BLjava/lang/String;)V
    //   204: astore #4
    //   206: aload_3
    //   207: astore #5
    //   209: aload_3
    //   210: astore #6
    //   212: aload_3
    //   213: astore #7
    //   215: aload #4
    //   217: ldc_w 'filename'
    //   220: invokevirtual indexOf : (Ljava/lang/String;)I
    //   223: istore_2
    //   224: iload_2
    //   225: iflt -> 138
    //   228: aload_3
    //   229: astore #5
    //   231: aload_3
    //   232: astore #6
    //   234: aload_3
    //   235: astore #7
    //   237: aload #4
    //   239: iload_2
    //   240: bipush #8
    //   242: iadd
    //   243: invokevirtual substring : (I)Ljava/lang/String;
    //   246: astore #4
    //   248: aload_3
    //   249: astore #5
    //   251: aload_3
    //   252: astore #6
    //   254: aload_3
    //   255: astore #7
    //   257: aload #4
    //   259: aload #4
    //   261: ldc_w '='
    //   264: invokevirtual indexOf : (Ljava/lang/String;)I
    //   267: iconst_1
    //   268: iadd
    //   269: invokevirtual substring : (I)Ljava/lang/String;
    //   272: astore #4
    //   274: aload #4
    //   276: astore_3
    //   277: iconst_1
    //   278: istore_1
    //   279: goto -> 138
    //   282: astore #4
    //   284: aload_3
    //   285: astore #5
    //   287: aload_3
    //   288: astore #6
    //   290: aload_3
    //   291: astore #7
    //   293: aload #4
    //   295: invokevirtual printStackTrace : ()V
    //   298: goto -> 138
    //   301: iload_1
    //   302: istore_2
    //   303: aload_3
    //   304: astore #4
    //   306: iload_1
    //   307: ifeq -> 69
    //   310: aload_3
    //   311: astore #5
    //   313: aload_3
    //   314: astore #6
    //   316: aload_3
    //   317: astore #7
    //   319: new java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial <init> : ()V
    //   326: astore #4
    //   328: aload_3
    //   329: astore #5
    //   331: aload_3
    //   332: astore #6
    //   334: aload_3
    //   335: astore #7
    //   337: aload #4
    //   339: ldc_w 'filename from UrlConnection: '
    //   342: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload_3
    //   347: astore #5
    //   349: aload_3
    //   350: astore #6
    //   352: aload_3
    //   353: astore #7
    //   355: aload #4
    //   357: aload_3
    //   358: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload_3
    //   363: astore #5
    //   365: aload_3
    //   366: astore #6
    //   368: aload_3
    //   369: astore #7
    //   371: ldc 'PTH'
    //   373: aload #4
    //   375: invokevirtual toString : ()Ljava/lang/String;
    //   378: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   381: pop
    //   382: goto -> 445
    //   385: astore #4
    //   387: aload #5
    //   389: astore_3
    //   390: goto -> 414
    //   393: astore #4
    //   395: aload #6
    //   397: astore_3
    //   398: goto -> 427
    //   401: astore #4
    //   403: aload #7
    //   405: astore_3
    //   406: goto -> 440
    //   409: astore #4
    //   411: ldc ''
    //   413: astore_3
    //   414: aload #4
    //   416: invokevirtual printStackTrace : ()V
    //   419: goto -> 445
    //   422: astore #4
    //   424: ldc ''
    //   426: astore_3
    //   427: aload #4
    //   429: invokevirtual printStackTrace : ()V
    //   432: goto -> 445
    //   435: astore #4
    //   437: ldc ''
    //   439: astore_3
    //   440: aload #4
    //   442: invokevirtual printStackTrace : ()V
    //   445: aload_3
    //   446: ifnull -> 461
    //   449: aload_3
    //   450: astore #4
    //   452: ldc ''
    //   454: aload_3
    //   455: invokevirtual equals : (Ljava/lang/Object;)Z
    //   458: ifeq -> 509
    //   461: aload_0
    //   462: aload_0
    //   463: ldc_w '/'
    //   466: invokevirtual lastIndexOf : (Ljava/lang/String;)I
    //   469: iconst_1
    //   470: iadd
    //   471: invokevirtual substring : (I)Ljava/lang/String;
    //   474: astore #4
    //   476: new java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial <init> : ()V
    //   483: astore_3
    //   484: aload_3
    //   485: ldc_w 'filename from url : '
    //   488: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload_3
    //   493: aload #4
    //   495: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: pop
    //   499: ldc 'PTH'
    //   501: aload_3
    //   502: invokevirtual toString : ()Ljava/lang/String;
    //   505: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   508: pop
    //   509: aload #4
    //   511: ifnull -> 527
    //   514: aload #4
    //   516: astore_3
    //   517: ldc ''
    //   519: aload #4
    //   521: invokevirtual equals : (Ljava/lang/Object;)Z
    //   524: ifeq -> 611
    //   527: new java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial <init> : ()V
    //   534: astore_3
    //   535: aload_3
    //   536: ldc_w 'temp_'
    //   539: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: aload_3
    //   544: invokestatic currentTimeMillis : ()J
    //   547: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload_3
    //   552: ldc_w '_'
    //   555: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: pop
    //   559: aload_3
    //   560: aload_0
    //   561: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   564: invokevirtual trim : ()Ljava/lang/String;
    //   567: invokestatic a : (Ljava/lang/String;)Ljava/lang/String;
    //   570: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: aload_3
    //   575: invokevirtual toString : ()Ljava/lang/String;
    //   578: astore_3
    //   579: new java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial <init> : ()V
    //   586: astore_0
    //   587: aload_0
    //   588: ldc_w 'filename from temp_time_url(md5) : '
    //   591: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: pop
    //   595: aload_0
    //   596: aload_3
    //   597: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: pop
    //   601: ldc 'PTH'
    //   603: aload_0
    //   604: invokevirtual toString : ()Ljava/lang/String;
    //   607: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   610: pop
    //   611: aload_3
    //   612: areturn
    // Exception table:
    //   from	to	target	type
    //   12	24	435	java/net/MalformedURLException
    //   12	24	422	java/io/IOException
    //   12	24	409	java/lang/Exception
    //   30	36	435	java/net/MalformedURLException
    //   30	36	422	java/io/IOException
    //   30	36	409	java/lang/Exception
    //   43	51	435	java/net/MalformedURLException
    //   43	51	422	java/io/IOException
    //   43	51	409	java/lang/Exception
    //   57	65	435	java/net/MalformedURLException
    //   57	65	422	java/io/IOException
    //   57	65	409	java/lang/Exception
    //   84	94	401	java/net/MalformedURLException
    //   84	94	393	java/io/IOException
    //   84	94	385	java/lang/Exception
    //   106	133	401	java/net/MalformedURLException
    //   106	133	393	java/io/IOException
    //   106	133	385	java/lang/Exception
    //   147	157	401	java/net/MalformedURLException
    //   147	157	393	java/io/IOException
    //   147	157	385	java/lang/Exception
    //   166	178	401	java/net/MalformedURLException
    //   166	178	393	java/io/IOException
    //   166	178	385	java/lang/Exception
    //   187	206	282	java/io/UnsupportedEncodingException
    //   187	206	401	java/net/MalformedURLException
    //   187	206	393	java/io/IOException
    //   187	206	385	java/lang/Exception
    //   215	224	282	java/io/UnsupportedEncodingException
    //   215	224	401	java/net/MalformedURLException
    //   215	224	393	java/io/IOException
    //   215	224	385	java/lang/Exception
    //   237	248	282	java/io/UnsupportedEncodingException
    //   237	248	401	java/net/MalformedURLException
    //   237	248	393	java/io/IOException
    //   237	248	385	java/lang/Exception
    //   257	274	282	java/io/UnsupportedEncodingException
    //   257	274	401	java/net/MalformedURLException
    //   257	274	393	java/io/IOException
    //   257	274	385	java/lang/Exception
    //   293	298	401	java/net/MalformedURLException
    //   293	298	393	java/io/IOException
    //   293	298	385	java/lang/Exception
    //   319	328	401	java/net/MalformedURLException
    //   319	328	393	java/io/IOException
    //   319	328	385	java/lang/Exception
    //   337	346	401	java/net/MalformedURLException
    //   337	346	393	java/io/IOException
    //   337	346	385	java/lang/Exception
    //   355	362	401	java/net/MalformedURLException
    //   355	362	393	java/io/IOException
    //   355	362	385	java/lang/Exception
    //   371	382	401	java/net/MalformedURLException
    //   371	382	393	java/io/IOException
    //   371	382	385	java/lang/Exception
  }
  
  public static long e(String paramString) {
    try {
      return Long.valueOf(paramString).longValue();
    } catch (Exception exception) {
      return 0L;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\utils\CommonTools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */