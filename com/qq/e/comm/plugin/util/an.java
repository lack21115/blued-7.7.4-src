package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
import com.qq.e.comm.util.GDTLogger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.CRC32;

public class an {
  private static final String[] a = new String[] { "Y29tLnRlbmNlbnQubW0=", "Y29tLnRlbmNlbnQubW9iaWxlcXE=" };
  
  private static String a() {
    return Build.VERSION.RELEASE;
  }
  
  public static String a(Context paramContext) {
    String str1;
    StringBuilder stringBuilder;
    String str2 = "01000000000000000000000000000000";
    System.currentTimeMillis();
    try {
      Context context = paramContext.getApplicationContext();
      String str6 = a();
      Pair<Integer, Integer> pair = c(context);
      String str7 = e();
      long l1 = d(context);
      long l2 = d();
      String str3 = b();
      String str4 = b(context);
      String str5 = c();
      List<Long> list = e(context);
      str6 = String.format(Locale.US, "%s|%d|%d|%s|%d|%d", new Object[] { str6, pair.first, pair.second, str7, Long.valueOf(l1), Long.valueOf(l2) });
      str3 = String.format(Locale.US, "%s|%s|%s|%s", new Object[] { str3, str4, str5, TextUtils.join("|", list) });
      char[] arrayOfChar2 = b(str6);
      char[] arrayOfChar1 = b(str3);
      a(arrayOfChar2);
      b(arrayOfChar2, arrayOfChar1);
      str1 = a(arrayOfChar2, arrayOfChar1);
    } catch (Error error) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("createQADID error: ");
      str1 = error.getMessage();
    } finally {
      paramContext = null;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("createQADID exception: ");
    } 
    GDTLogger.d(stringBuilder.toString());
    return str1;
  }
  
  private static String a(String paramString) {
    return new String(Base64.decode(paramString, 2));
  }
  
  private static String a(char[] paramArrayOfchar1, char[] paramArrayOfchar2) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < 32; i++) {
      char c;
      if (i < 16) {
        c = paramArrayOfchar1[i];
      } else {
        c = paramArrayOfchar2[i - 16];
      } 
      stringBuilder.append(c);
    } 
    return stringBuilder.toString();
  }
  
  private static void a(char[] paramArrayOfchar) {
    String str = Integer.toHexString(1).toUpperCase();
    if (str.length() < 2) {
      paramArrayOfchar[0] = (char)'0';
      paramArrayOfchar[1] = str.charAt(0);
      return;
    } 
    paramArrayOfchar[0] = str.charAt(0);
    paramArrayOfchar[1] = str.charAt(1);
  }
  
  private static long b(char[] paramArrayOfchar) {
    StringBuilder stringBuilder = new StringBuilder();
    int j = paramArrayOfchar.length;
    for (int i = 0; i < j; i++)
      stringBuilder.append(paramArrayOfchar[i]); 
    byte[] arrayOfByte = d(stringBuilder.toString());
    CRC32 cRC32 = new CRC32();
    cRC32.update(arrayOfByte);
    return cRC32.getValue();
  }
  
  private static String b() {
    return Locale.getDefault().getLanguage();
  }
  
  private static String b(Context paramContext) {
    return (paramContext.getApplicationContext().getResources().getConfiguration()).locale.getCountry();
  }
  
  private static void b(char[] paramArrayOfchar1, char[] paramArrayOfchar2) {
    char[] arrayOfChar = new char[30];
    for (int i = 0; i < 30; i++) {
      if (i < 16) {
        arrayOfChar[i] = (char)paramArrayOfchar1[i];
      } else {
        arrayOfChar[i] = (char)paramArrayOfchar2[i - 16];
      } 
    } 
    String str = Integer.toHexString((int)(b(arrayOfChar) % 256L)).toUpperCase();
    if (str.length() < 2) {
      paramArrayOfchar2[14] = (char)'0';
      paramArrayOfchar2[15] = str.charAt(0);
      return;
    } 
    paramArrayOfchar2[14] = str.charAt(0);
    paramArrayOfchar2[15] = str.charAt(1);
  }
  
  private static char[] b(String paramString) {
    paramString = c(paramString);
    char[] arrayOfChar = new char[16];
    for (int i = 8; i < 24; i++)
      arrayOfChar[i - 8] = paramString.charAt(i); 
    return arrayOfChar;
  }
  
  private static Pair<Integer, Integer> c(Context paramContext) {
    DisplayMetrics displayMetrics = new DisplayMetrics();
    WindowManager windowManager = (WindowManager)paramContext.getSystemService("window");
    if (windowManager != null) {
      int i = Build.VERSION.SDK_INT;
      Display display = windowManager.getDefaultDisplay();
      if (i >= 17) {
        display.getRealMetrics(displayMetrics);
      } else {
        display.getMetrics(displayMetrics);
      } 
    } 
    return new Pair(Integer.valueOf(Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels)), Integer.valueOf(Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels)));
  }
  
  private static String c() {
    try {
      return TimeZone.getDefault().getDisplayName(false, 0);
    } catch (AssertionError|Exception assertionError) {
      return "";
    } 
  }
  
  private static String c(String paramString) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(paramString.getBytes());
      byte[] arrayOfByte = messageDigest.digest();
      StringBuilder stringBuilder = new StringBuilder();
      int j = arrayOfByte.length;
      for (int i = 0; i < j; i++) {
        int k = arrayOfByte[i] & 0xFF;
        if (k < 16)
          stringBuilder.append("0"); 
        stringBuilder.append(Integer.toHexString(k));
      } 
      return stringBuilder.toString().toUpperCase();
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      return "";
    } 
  }
  
  private static long d() {
    long l1;
    long l2;
    StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
    if (Build.VERSION.SDK_INT >= 18) {
      l1 = statFs.getBlockSizeLong();
      l2 = statFs.getBlockCountLong();
    } else {
      l1 = statFs.getBlockSize();
      l2 = statFs.getBlockCount();
    } 
    return l2 * l1;
  }
  
  private static long d(Context paramContext) {
    // Byte code:
    //   0: getstatic android/os/Build$VERSION.SDK_INT : I
    //   3: istore_1
    //   4: lconst_0
    //   5: lstore #4
    //   7: iload_1
    //   8: bipush #16
    //   10: if_icmplt -> 49
    //   13: aload_0
    //   14: ldc_w 'activity'
    //   17: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   20: checkcast android/app/ActivityManager
    //   23: astore_0
    //   24: new android/app/ActivityManager$MemoryInfo
    //   27: dup
    //   28: invokespecial <init> : ()V
    //   31: astore #6
    //   33: aload_0
    //   34: ifnull -> 280
    //   37: aload_0
    //   38: aload #6
    //   40: invokevirtual getMemoryInfo : (Landroid/app/ActivityManager$MemoryInfo;)V
    //   43: aload #6
    //   45: getfield totalMem : J
    //   48: lreturn
    //   49: aconst_null
    //   50: astore #7
    //   52: aconst_null
    //   53: astore #9
    //   55: aconst_null
    //   56: astore #8
    //   58: new java/io/FileReader
    //   61: dup
    //   62: ldc_w '/proc/meminfo'
    //   65: invokespecial <init> : (Ljava/lang/String;)V
    //   68: astore_0
    //   69: new java/io/BufferedReader
    //   72: dup
    //   73: aload_0
    //   74: sipush #4096
    //   77: invokespecial <init> : (Ljava/io/Reader;I)V
    //   80: astore #6
    //   82: aload #6
    //   84: invokevirtual readLine : ()Ljava/lang/String;
    //   87: astore #7
    //   89: aload #7
    //   91: ifnull -> 105
    //   94: aload #7
    //   96: ldc_w 'MemTotal'
    //   99: invokevirtual contains : (Ljava/lang/CharSequence;)Z
    //   102: ifeq -> 82
    //   105: lload #4
    //   107: lstore_2
    //   108: aload #7
    //   110: ifnull -> 136
    //   113: aload #7
    //   115: ldc_w '\s+'
    //   118: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   121: iconst_1
    //   122: aaload
    //   123: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Long;
    //   126: invokevirtual longValue : ()J
    //   129: lstore_2
    //   130: lload_2
    //   131: ldc2_w 1024
    //   134: lmul
    //   135: lstore_2
    //   136: aload #6
    //   138: invokevirtual close : ()V
    //   141: aload_0
    //   142: invokevirtual close : ()V
    //   145: lload_2
    //   146: lreturn
    //   147: astore #7
    //   149: aload #6
    //   151: astore #8
    //   153: aload_0
    //   154: astore #6
    //   156: aload #7
    //   158: astore_0
    //   159: goto -> 197
    //   162: goto -> 228
    //   165: goto -> 257
    //   168: astore #7
    //   170: aload_0
    //   171: astore #6
    //   173: aload #7
    //   175: astore_0
    //   176: goto -> 197
    //   179: aload #7
    //   181: astore #6
    //   183: goto -> 228
    //   186: aload #9
    //   188: astore #6
    //   190: goto -> 257
    //   193: astore_0
    //   194: aconst_null
    //   195: astore #6
    //   197: aload #8
    //   199: ifnull -> 210
    //   202: aload #8
    //   204: invokevirtual close : ()V
    //   207: goto -> 210
    //   210: aload #6
    //   212: ifnull -> 220
    //   215: aload #6
    //   217: invokevirtual close : ()V
    //   220: aload_0
    //   221: athrow
    //   222: aconst_null
    //   223: astore_0
    //   224: aload #7
    //   226: astore #6
    //   228: aload #6
    //   230: ifnull -> 241
    //   233: aload #6
    //   235: invokevirtual close : ()V
    //   238: goto -> 241
    //   241: aload_0
    //   242: ifnull -> 280
    //   245: lload #4
    //   247: lstore_2
    //   248: goto -> 141
    //   251: aconst_null
    //   252: astore_0
    //   253: aload #9
    //   255: astore #6
    //   257: aload #6
    //   259: ifnull -> 270
    //   262: aload #6
    //   264: invokevirtual close : ()V
    //   267: goto -> 270
    //   270: aload_0
    //   271: ifnull -> 280
    //   274: lload #4
    //   276: lstore_2
    //   277: goto -> 141
    //   280: lconst_0
    //   281: lreturn
    //   282: astore_0
    //   283: goto -> 251
    //   286: astore_0
    //   287: goto -> 222
    //   290: astore #6
    //   292: goto -> 186
    //   295: astore #6
    //   297: goto -> 179
    //   300: astore #7
    //   302: goto -> 165
    //   305: astore #7
    //   307: goto -> 162
    //   310: astore #6
    //   312: goto -> 141
    //   315: astore_0
    //   316: lload_2
    //   317: lreturn
    //   318: astore #7
    //   320: goto -> 210
    //   323: astore #6
    //   325: goto -> 220
    //   328: astore #6
    //   330: goto -> 241
    //   333: astore #6
    //   335: goto -> 270
    // Exception table:
    //   from	to	target	type
    //   58	69	282	java/io/FileNotFoundException
    //   58	69	286	java/io/IOException
    //   58	69	193	finally
    //   69	82	290	java/io/FileNotFoundException
    //   69	82	295	java/io/IOException
    //   69	82	168	finally
    //   82	89	300	java/io/FileNotFoundException
    //   82	89	305	java/io/IOException
    //   82	89	147	finally
    //   94	105	300	java/io/FileNotFoundException
    //   94	105	305	java/io/IOException
    //   94	105	147	finally
    //   113	130	300	java/io/FileNotFoundException
    //   113	130	305	java/io/IOException
    //   113	130	147	finally
    //   136	141	310	java/io/IOException
    //   141	145	315	java/io/IOException
    //   202	207	318	java/io/IOException
    //   215	220	323	java/io/IOException
    //   233	238	328	java/io/IOException
    //   262	267	333	java/io/IOException
  }
  
  private static byte[] d(String paramString) {
    int j = paramString.length();
    byte[] arrayOfByte = new byte[j / 2];
    for (int i = 0; i < j; i += 2)
      arrayOfByte[i / 2] = (byte)(byte)((Character.digit(paramString.charAt(i), 16) << 4) + Character.digit(paramString.charAt(i + 1), 16)); 
    return arrayOfByte;
  }
  
  private static String e() {
    // Byte code:
    //   0: ldc_w 'os.version'
    //   3: invokestatic getProperty : (Ljava/lang/String;)Ljava/lang/String;
    //   6: astore_2
    //   7: aconst_null
    //   8: astore #4
    //   10: aconst_null
    //   11: astore #5
    //   13: aconst_null
    //   14: astore_3
    //   15: new java/io/FileReader
    //   18: dup
    //   19: ldc_w '/proc/version'
    //   22: invokespecial <init> : (Ljava/lang/String;)V
    //   25: astore_0
    //   26: new java/io/BufferedReader
    //   29: dup
    //   30: aload_0
    //   31: sipush #8192
    //   34: invokespecial <init> : (Ljava/io/Reader;I)V
    //   37: astore_1
    //   38: aload_1
    //   39: invokevirtual readLine : ()Ljava/lang/String;
    //   42: astore_3
    //   43: aload_3
    //   44: ifnull -> 49
    //   47: aload_3
    //   48: astore_2
    //   49: aload_1
    //   50: invokevirtual close : ()V
    //   53: aload_0
    //   54: invokevirtual close : ()V
    //   57: aload_2
    //   58: areturn
    //   59: astore_3
    //   60: aload_1
    //   61: astore_2
    //   62: aload_3
    //   63: astore_1
    //   64: goto -> 96
    //   67: goto -> 122
    //   70: goto -> 145
    //   73: astore_1
    //   74: aload_3
    //   75: astore_2
    //   76: goto -> 96
    //   79: aload #4
    //   81: astore_1
    //   82: goto -> 122
    //   85: aload #5
    //   87: astore_1
    //   88: goto -> 145
    //   91: astore_1
    //   92: aconst_null
    //   93: astore_0
    //   94: aload_3
    //   95: astore_2
    //   96: aload_2
    //   97: ifnull -> 107
    //   100: aload_2
    //   101: invokevirtual close : ()V
    //   104: goto -> 107
    //   107: aload_0
    //   108: ifnull -> 115
    //   111: aload_0
    //   112: invokevirtual close : ()V
    //   115: aload_1
    //   116: athrow
    //   117: aconst_null
    //   118: astore_0
    //   119: aload #4
    //   121: astore_1
    //   122: aload_1
    //   123: ifnull -> 133
    //   126: aload_1
    //   127: invokevirtual close : ()V
    //   130: goto -> 133
    //   133: aload_0
    //   134: ifnull -> 163
    //   137: goto -> 53
    //   140: aconst_null
    //   141: astore_0
    //   142: aload #5
    //   144: astore_1
    //   145: aload_1
    //   146: ifnull -> 156
    //   149: aload_1
    //   150: invokevirtual close : ()V
    //   153: goto -> 156
    //   156: aload_0
    //   157: ifnull -> 163
    //   160: goto -> 53
    //   163: aload_2
    //   164: areturn
    //   165: astore_0
    //   166: goto -> 140
    //   169: astore_0
    //   170: goto -> 117
    //   173: astore_1
    //   174: goto -> 85
    //   177: astore_1
    //   178: goto -> 79
    //   181: astore_3
    //   182: goto -> 70
    //   185: astore_3
    //   186: goto -> 67
    //   189: astore_1
    //   190: goto -> 53
    //   193: astore_0
    //   194: aload_2
    //   195: areturn
    //   196: astore_2
    //   197: goto -> 107
    //   200: astore_0
    //   201: goto -> 115
    //   204: astore_1
    //   205: goto -> 133
    //   208: astore_1
    //   209: goto -> 156
    // Exception table:
    //   from	to	target	type
    //   15	26	165	java/io/FileNotFoundException
    //   15	26	169	java/io/IOException
    //   15	26	91	finally
    //   26	38	173	java/io/FileNotFoundException
    //   26	38	177	java/io/IOException
    //   26	38	73	finally
    //   38	43	181	java/io/FileNotFoundException
    //   38	43	185	java/io/IOException
    //   38	43	59	finally
    //   49	53	189	java/io/IOException
    //   53	57	193	java/io/IOException
    //   100	104	196	java/io/IOException
    //   111	115	200	java/io/IOException
    //   126	130	204	java/io/IOException
    //   149	153	208	java/io/IOException
  }
  
  private static List<Long> e(Context paramContext) {
    ArrayList<Long> arrayList = new ArrayList();
    PackageManager packageManager = paramContext.getPackageManager();
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (true) {
      if (i < j) {
        String str = arrayOfString[i];
        try {
          arrayList.add(Long.valueOf((packageManager.getPackageInfo(a(str), 0)).firstInstallTime));
        } catch (Exception exception) {
          arrayList.add(Long.valueOf(-1L));
        } 
        i++;
        continue;
      } 
      return arrayList;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */