package a.a.a.a.a.e;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.EGL14;
import android.os.Build;
import android.text.TextUtils;
import android.view.WindowManager;
import com.qiniu.android.dns.DnsManager;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.http.DnspodFree;
import com.qiniu.android.dns.local.AndroidDnsServer;
import com.qiniu.android.dns.local.Resolver;
import com.qiniu.pili.droid.streaming.CameraStreamingSetting;
import com.qiniu.pili.droid.streaming.StreamingProfile;
import com.qiniu.pili.droid.streaming.av.common.PLBufferInfo;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.security.SignatureException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.json.JSONException;
import org.json.JSONObject;

public class h {
  public static final long a = Runtime.getRuntime().maxMemory() * 60L / 100L;
  
  public static final long b = Runtime.getRuntime().maxMemory() * 90L / 100L;
  
  public static final long c = Runtime.getRuntime().maxMemory() * 60L / 100L;
  
  public static Random d = new Random();
  
  public static boolean e = g();
  
  public static float a(List<Float> paramList) {
    float f3 = 0.0F;
    float f1 = 0.0F;
    float f2 = 0.0F;
    if (paramList != null) {
      if (paramList.size() == 0)
        return 0.0F; 
      if (paramList instanceof java.util.RandomAccess) {
        int i = 0;
        int j = paramList.size();
        f1 = f2;
        while (true) {
          f2 = f1;
          if (i < j) {
            f1 += ((Float)paramList.get(i)).floatValue();
            i++;
            continue;
          } 
          break;
        } 
      } else {
        Iterator<Float> iterator = paramList.iterator();
        f1 = f3;
        while (true) {
          f2 = f1;
          if (iterator.hasNext()) {
            f1 += ((Float)iterator.next()).floatValue();
            continue;
          } 
          break;
        } 
      } 
      f1 = f2 / paramList.size();
    } 
    return f1;
  }
  
  public static int a(float paramFloat) {
    return Math.round((Math.round(paramFloat / 16.0F) * 16));
  }
  
  public static int a(int paramInt) {
    return (int)(paramInt * (Resources.getSystem().getDisplayMetrics()).density);
  }
  
  public static int a(int paramInt1, int paramInt2) {
    int i = paramInt1;
    if (paramInt2 > paramInt1) {
      i = paramInt1;
      if (paramInt1 % 16 != 0)
        i = (paramInt1 / 16 + 1) * 16; 
    } 
    return i;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3) {
    return (paramInt1 > paramInt3) ? paramInt3 : ((paramInt1 < paramInt2) ? paramInt2 : paramInt1);
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return (paramInt1 / paramInt2 > paramInt3 / paramInt4) ? (paramInt1 / paramInt3) : (paramInt2 / paramInt4);
  }
  
  public static int a(Context paramContext) {
    return ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRotation();
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2) {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    e e = e.c;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("options.width:");
    stringBuilder.append(m);
    stringBuilder.append(",options.height:");
    stringBuilder.append(k);
    stringBuilder.append(",reqWidth:");
    stringBuilder.append(paramInt1);
    stringBuilder.append(",reqHeight:");
    stringBuilder.append(paramInt2);
    e.c("CameraStreamingUtil", stringBuilder.toString());
    int j = 1;
    int i = 1;
    if (k > paramInt2 || m > paramInt1) {
      k /= 2;
      m /= 2;
      while (true) {
        j = i;
        if (k / i > paramInt2) {
          j = i;
          if (m / i > paramInt1) {
            i *= 2;
            continue;
          } 
        } 
        break;
      } 
    } 
    e = e.c;
    stringBuilder = new StringBuilder();
    stringBuilder.append("inSampleSize:");
    stringBuilder.append(j);
    e.c("CameraStreamingUtil", stringBuilder.toString());
    return j;
  }
  
  public static Bitmap a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3) {
    BitmapFactory.Options options;
    if (paramInt2 > 0 && paramInt3 > 0) {
      options = new BitmapFactory.Options();
      options.inJustDecodeBounds = true;
      BitmapFactory.decodeResource(paramResources, paramInt1, options);
      options.inScaled = true;
      options.inJustDecodeBounds = false;
      options.inSampleSize = a(options.outWidth, options.outHeight, paramInt2, paramInt3);
    } else {
      options = null;
    } 
    return BitmapFactory.decodeResource(paramResources, paramInt1, options);
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2) {
    Bitmap bitmap = paramBitmap;
    if (paramInt1 > 0) {
      bitmap = paramBitmap;
      if (paramInt2 > 0)
        bitmap = Bitmap.createScaledBitmap(paramBitmap, paramInt1, paramInt2, true); 
    } 
    return bitmap;
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2) {
    BitmapFactory.Options options;
    if (paramInt1 > 0 && paramInt2 > 0) {
      options = new BitmapFactory.Options();
      options.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, options);
      options.inJustDecodeBounds = false;
      options.inScaled = true;
      options.inSampleSize = a(options.outWidth, options.outHeight, paramInt1, paramInt2);
    } else {
      options = null;
    } 
    return BitmapFactory.decodeFile(paramString, options);
  }
  
  public static Bitmap a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    if (paramInt5 != 90) {
      int m = paramInt3;
      int k = paramInt4;
      if (paramInt5 == 270) {
        k = paramInt3;
        m = paramInt4;
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(paramArrayOfbyte, paramInt1, paramInt2, options2);
        options2.inSampleSize = a(options2, m, k);
        options2.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(paramArrayOfbyte, paramInt1, paramInt2, options2);
      } 
      BitmapFactory.Options options1 = new BitmapFactory.Options();
      options1.inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(paramArrayOfbyte, paramInt1, paramInt2, options1);
      options1.inSampleSize = a(options1, m, k);
      options1.inJustDecodeBounds = false;
      return BitmapFactory.decodeByteArray(paramArrayOfbyte, paramInt1, paramInt2, options1);
    } 
    int i = paramInt3;
    int j = paramInt4;
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeByteArray(paramArrayOfbyte, paramInt1, paramInt2, options);
    options.inSampleSize = a(options, j, i);
    options.inJustDecodeBounds = false;
    return BitmapFactory.decodeByteArray(paramArrayOfbyte, paramInt1, paramInt2, options);
  }
  
  public static String a(StreamingProfile.Stream paramStream, String paramString) {
    return String.format("%s://%s/%s/%s?key=%s", new Object[] { paramString, paramStream.getPublishRtmpHost(), paramStream.getHubName(), paramStream.getTitle(), paramStream.getPublishKey() });
  }
  
  public static String a(String paramString1, String paramString2) {
    String str = paramString1.toLowerCase(Locale.getDefault());
    return (str.startsWith("unknown") || str.startsWith("alps") || str.startsWith("android") || str.startsWith("sprd") || str.startsWith("spreadtrum") || str.startsWith("rockchip") || str.startsWith("wondermedia") || str.startsWith("mtk") || str.startsWith("mt65") || str.startsWith("nvidia") || str.startsWith("brcm") || str.startsWith("marvell") || paramString2.toLowerCase(Locale.getDefault()).contains(str)) ? null : paramString1;
  }
  
  public static Map<String, String> a(URI paramURI) {
    // Byte code:
    //   0: new java/util/HashMap
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #6
    //   9: aload_0
    //   10: ifnonnull -> 16
    //   13: aload #6
    //   15: areturn
    //   16: aload_0
    //   17: invokevirtual getQuery : ()Ljava/lang/String;
    //   20: astore_0
    //   21: aload_0
    //   22: ifnonnull -> 28
    //   25: aload #6
    //   27: areturn
    //   28: aload_0
    //   29: ldc_w '&'
    //   32: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   35: astore #7
    //   37: aload #7
    //   39: arraylength
    //   40: istore_2
    //   41: iconst_0
    //   42: istore_1
    //   43: iload_1
    //   44: iload_2
    //   45: if_icmpge -> 156
    //   48: aload #7
    //   50: iload_1
    //   51: aaload
    //   52: astore #5
    //   54: aload #5
    //   56: ldc_w '='
    //   59: invokevirtual indexOf : (Ljava/lang/String;)I
    //   62: istore #4
    //   64: iload #4
    //   66: ifle -> 159
    //   69: aload #5
    //   71: iconst_0
    //   72: iload #4
    //   74: invokevirtual substring : (II)Ljava/lang/String;
    //   77: ldc_w 'UTF-8'
    //   80: invokestatic decode : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   83: astore_0
    //   84: goto -> 87
    //   87: iload #4
    //   89: ifle -> 165
    //   92: aload #5
    //   94: invokevirtual length : ()I
    //   97: istore_3
    //   98: iload #4
    //   100: iconst_1
    //   101: iadd
    //   102: istore #4
    //   104: iload_3
    //   105: iload #4
    //   107: if_icmple -> 165
    //   110: aload #5
    //   112: iload #4
    //   114: invokevirtual substring : (I)Ljava/lang/String;
    //   117: ldc_w 'UTF-8'
    //   120: invokestatic decode : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   123: astore #5
    //   125: goto -> 128
    //   128: aload #5
    //   130: ifnull -> 144
    //   133: aload #6
    //   135: aload_0
    //   136: aload #5
    //   138: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   143: pop
    //   144: iload_1
    //   145: iconst_1
    //   146: iadd
    //   147: istore_1
    //   148: goto -> 43
    //   151: astore_0
    //   152: aload_0
    //   153: invokevirtual printStackTrace : ()V
    //   156: aload #6
    //   158: areturn
    //   159: aload #5
    //   161: astore_0
    //   162: goto -> 87
    //   165: aconst_null
    //   166: astore #5
    //   168: goto -> 128
    // Exception table:
    //   from	to	target	type
    //   37	41	151	java/io/UnsupportedEncodingException
    //   54	64	151	java/io/UnsupportedEncodingException
    //   69	84	151	java/io/UnsupportedEncodingException
    //   92	98	151	java/io/UnsupportedEncodingException
    //   110	125	151	java/io/UnsupportedEncodingException
    //   133	144	151	java/io/UnsupportedEncodingException
  }
  
  public static void a(Matrix paramMatrix, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3) {
    if (paramBoolean) {
      f1 = -1.0F;
    } else {
      f1 = 1.0F;
    } 
    paramMatrix.setScale(f1, 1.0F);
    paramMatrix.postRotate(paramInt1);
    float f1 = paramInt2;
    float f2 = f1 / 2000.0F;
    float f3 = paramInt3;
    paramMatrix.postScale(f2, f3 / 2000.0F);
    paramMatrix.postTranslate(f1 / 2.0F, f3 / 2.0F);
  }
  
  public static void a(RectF paramRectF, Rect paramRect) {
    paramRect.left = Math.round(paramRectF.left);
    paramRect.top = Math.round(paramRectF.top);
    paramRect.right = Math.round(paramRectF.right);
    paramRect.bottom = Math.round(paramRectF.bottom);
  }
  
  public static void a(boolean paramBoolean) {
    if (paramBoolean)
      return; 
    throw new AssertionError();
  }
  
  public static boolean a() {
    return (Build.VERSION.SDK_INT >= 19);
  }
  
  public static boolean a(PLBufferInfo paramPLBufferInfo) {
    return ((paramPLBufferInfo.flags & 0x1) != 0);
  }
  
  public static boolean a(String paramString) {
    return (paramString != null && !paramString.trim().isEmpty());
  }
  
  public static boolean a(String paramString, List<String> paramList) {
    return (paramList != null && paramList.indexOf(paramString) >= 0);
  }
  
  public static byte[] a(int paramInt1, int paramInt2, Bitmap paramBitmap, boolean paramBoolean) {
    if (paramBitmap == null)
      return null; 
    int[] arrayOfInt = new int[paramInt1 * paramInt2];
    try {
      paramBitmap.getPixels(arrayOfInt, 0, paramInt1, 0, 0, paramInt1, paramInt2);
      if (paramBitmap != null && !paramBitmap.isRecycled())
        paramBitmap.recycle(); 
      return paramBoolean ? a(arrayOfInt, paramInt1, paramInt2) : b(arrayOfInt, paramInt1, paramInt2);
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public static byte[] a(int[] paramArrayOfint, int paramInt1, int paramInt2) {
    int j = paramInt1 * paramInt2;
    byte[] arrayOfByte = new byte[j * 3 / 2];
    int k = 0;
    int i = 0;
    int m = 0;
    while (k < paramInt2) {
      int n = 0;
      while (n < paramInt1) {
        int i1 = paramArrayOfint[m];
        i1 = (paramArrayOfint[m] & 0xFF0000) >> 16;
        int i3 = (paramArrayOfint[m] & 0xFF00) >> 8;
        int i5 = (paramArrayOfint[m] & 0xFF) >> 0;
        int i4 = (i1 * 66 + i3 * 129 + i5 * 25 + 128 >> 8) + 16;
        int i2 = (i1 * -38 - i3 * 74 + i5 * 112 + 128 >> 8) + 128;
        i3 = (i1 * 112 - i3 * 94 - i5 * 18 + 128 >> 8) + 128;
        if (i4 < 0) {
          i1 = 0;
        } else {
          i1 = i4;
          if (i4 > 255)
            i1 = 255; 
        } 
        arrayOfByte[i] = (byte)i1;
        i1 = j;
        if (k % 2 == 0) {
          i1 = j;
          if (m % 2 == 0) {
            i4 = j + 1;
            if (i3 < 0) {
              i1 = 0;
            } else {
              i1 = i3;
              if (i3 > 255)
                i1 = 255; 
            } 
            arrayOfByte[j] = (byte)i1;
            i1 = i4 + 1;
            if (i2 < 0) {
              j = 0;
            } else {
              j = i2;
              if (i2 > 255)
                j = 255; 
            } 
            arrayOfByte[i4] = (byte)j;
          } 
        } 
        m++;
        n++;
        i++;
        j = i1;
      } 
      k++;
    } 
    return arrayOfByte;
  }
  
  public static int b(int paramInt1, int paramInt2) {
    return (Build.VERSION.SDK_INT >= 21) ? ThreadLocalRandom.current().nextInt(paramInt1, paramInt2 + 1) : c(paramInt1, paramInt2);
  }
  
  public static int b(Context paramContext) {
    int i = a(paramContext);
    return (i != 1) ? ((i != 2) ? ((i != 3) ? 0 : 270) : 180) : 90;
  }
  
  public static String b(StreamingProfile.Stream paramStream, String paramString) {
    long l = System.currentTimeMillis() / 1000L;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("/");
    stringBuilder.append(paramStream.getHubName());
    stringBuilder.append("/");
    stringBuilder.append(paramStream.getTitle());
    stringBuilder.append("?nonce=");
    stringBuilder.append(l);
    String str = stringBuilder.toString();
    try {
      String str1 = a.b(paramStream.getPublishKey(), str);
    } catch (SignatureException signatureException) {
      signatureException.printStackTrace();
      signatureException = null;
    } 
    return String.format("%s://%s%s&token=%s", new Object[] { paramString, paramStream.getPublishRtmpHost(), str, signatureException });
  }
  
  public static String b(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    int j = paramString.length();
    for (int i = 0; i < j; i++) {
      char c = paramString.charAt(i);
      if (c > '\037' && c < '')
        stringBuilder.append(c); 
    } 
    return stringBuilder.toString();
  }
  
  public static boolean b() {
    return (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() >= a);
  }
  
  public static boolean b(int paramInt) {
    return (paramInt == CameraStreamingSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT.ordinal());
  }
  
  public static boolean b(PLBufferInfo paramPLBufferInfo) {
    return ((paramPLBufferInfo.flags & 0x2) != 0);
  }
  
  public static byte[] b(int[] paramArrayOfint, int paramInt1, int paramInt2) {
    int i = paramInt1 * paramInt2;
    int k = i / 4;
    byte[] arrayOfByte = new byte[i * 3 / 2];
    int j = i;
    k += i;
    int m = 0;
    i = 0;
    int n = 0;
    while (m < paramInt2) {
      int i1 = i;
      int i2 = 0;
      i = k;
      k = j;
      j = i1;
      while (i2 < paramInt1) {
        i1 = (paramArrayOfint[n] & 0xFF0000) >> 16;
        int i5 = (paramArrayOfint[n] & 0xFF00) >> 8;
        int i3 = paramArrayOfint[n];
        char c = 'ÿ';
        int i6 = (i3 & 0xFF) >> 0;
        i3 = (i1 * 66 + i5 * 129 + i6 * 25 + 128 >> 8) + 16;
        int i4 = (i1 * -38 - i5 * 74 + i6 * 112 + 128 >> 8) + 128;
        i5 = (i1 * 112 - i5 * 94 - i6 * 18 + 128 >> 8) + 128;
        if (i3 < 0) {
          i1 = 0;
        } else {
          i1 = i3;
          if (i3 > 255)
            i1 = 255; 
        } 
        arrayOfByte[j] = (byte)i1;
        i3 = k;
        i1 = i;
        if (m % 2 == 0) {
          i3 = k;
          i1 = i;
          if (n % 2 == 0) {
            if (i4 < 0) {
              i1 = 0;
            } else {
              i1 = i4;
              if (i4 > 255)
                i1 = 255; 
            } 
            arrayOfByte[i] = (byte)i1;
            if (i5 < 0) {
              i1 = 0;
            } else if (i5 > 255) {
              i1 = c;
            } else {
              i1 = i5;
            } 
            arrayOfByte[k] = (byte)i1;
            i3 = k + 1;
            i1 = i + 1;
          } 
        } 
        n++;
        i2++;
        j++;
        k = i3;
        i = i1;
      } 
      m++;
      i1 = j;
      j = k;
      k = i;
      i = i1;
    } 
    return arrayOfByte;
  }
  
  public static int c(int paramInt) {
    return (paramInt & 0xFFFF0000) >> 16;
  }
  
  public static int c(int paramInt1, int paramInt2) {
    return d.nextInt(paramInt2 - paramInt1 + 1) + paramInt1;
  }
  
  public static boolean c() {
    return (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() >= b);
  }
  
  public static boolean c(Context paramContext) {
    Point point = d(paramContext);
    return (point.x > point.y);
  }
  
  public static boolean c(PLBufferInfo paramPLBufferInfo) {
    return ((paramPLBufferInfo.flags & 0x4) != 0);
  }
  
  public static boolean c(String paramString) {
    return (paramString != null && paramString.matches("(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?(([0-9]{1,3}\\.){3}[0-9]{1,3}|([0-9a-z_!~*'()-]+\\.)*([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\.[a-z]{2,6})(:[0-9]{1,4})?((/?)|(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$"));
  }
  
  public static int d(int paramInt1, int paramInt2) {
    Random random = new Random();
    int i = paramInt1;
    if (paramInt2 > paramInt1)
      i = paramInt1 + random.nextInt(paramInt2 - paramInt1); 
    return i;
  }
  
  public static Point d(Context paramContext) {
    Point point = new Point();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getSize(point);
    return point;
  }
  
  public static boolean d() {
    return (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() >= c);
  }
  
  public static boolean d(PLBufferInfo paramPLBufferInfo) {
    return paramPLBufferInfo.isNeedAddHeader;
  }
  
  public static boolean d(String paramString) {
    return (paramString == null) ? false : paramString.matches("^(\\-|\\+)?\\d+(\\.\\d+)?$");
  }
  
  public static boolean e() {
    return (Build.HARDWARE.startsWith("mt") || Build.HARDWARE.startsWith("MT"));
  }
  
  public static boolean e(Context paramContext) {
    return paramContext.getPackageManager().hasSystemFeature("android.hardware.camera");
  }
  
  public static int f(Context paramContext) {
    int i = (((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo()).reqGlEsVersion;
    return (i != 0) ? c(i) : 1;
  }
  
  public static DnsManager f() {
    DnspodFree dnspodFree = new DnspodFree();
    IResolver iResolver = AndroidDnsServer.defaultResolver();
    try {
      Resolver resolver = new Resolver(InetAddress.getByName("119.29.29.29"));
    } catch (IOException iOException) {
      iOException.printStackTrace();
      iOException = null;
    } 
    return new DnsManager(NetworkInfo.normal, new IResolver[] { (IResolver)dnspodFree, iResolver, (IResolver)iOException });
  }
  
  public static boolean g() {
    if (Build.VERSION.SDK_INT >= 17)
      try {
        EGL14.eglGetCurrentContext();
        return true;
      } catch (NoClassDefFoundError noClassDefFoundError) {
        e.c.c("CameraStreamingUtil", "EGL14 isn't supported on this platform, change to use EGL10.");
      }  
    return false;
  }
  
  public static String[] g(Context paramContext) {
    try {
      PackageInfo packageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      String str1 = packageInfo.packageName;
      String str2 = packageInfo.versionName;
      return new String[] { str1, str2 };
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return null;
    } 
  }
  
  public static String h(Context paramContext) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put("device_model", i());
      jSONObject.put("os_version", j());
      jSONObject.put("sdk_version", "librtmp-1.1.0;PLDroidCameraStreaming-3.0.0");
      jSONObject.put("app_name", i(paramContext));
      jSONObject.put("app_version", j(paramContext));
      jSONObject.put("gl_version", f(paramContext));
      return jSONObject.toString();
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return jSONException.toString();
    } 
  }
  
  public static boolean h() {
    return e;
  }
  
  public static String i() {
    String str3 = Build.MODEL.trim();
    String str2 = a(Build.MANUFACTURER.trim(), str3);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
      str1 = a(Build.BRAND.trim(), str3); 
    StringBuilder stringBuilder = new StringBuilder();
    str2 = str1;
    if (str1 == null)
      str2 = ""; 
    stringBuilder.append(str2);
    stringBuilder.append(str3);
    return b(stringBuilder.toString()).replace(" ", "_");
  }
  
  public static String i(Context paramContext) {
    try {
      return (paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0)).packageName;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return "";
    } 
  }
  
  public static String j() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("os version:");
    stringBuilder.append(Build.VERSION.RELEASE);
    stringBuilder.append(", Android SDK_INT:");
    stringBuilder.append(Build.VERSION.SDK_INT);
    stringBuilder.append(", SoC Hardware:");
    stringBuilder.append(Build.HARDWARE);
    return b(stringBuilder.toString().trim());
  }
  
  public static String j(Context paramContext) {
    try {
      return (paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0)).versionName;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return "";
    } 
  }
  
  public static String k() {
    Random random = new Random();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append("");
    stringBuilder.append(random.nextInt(999));
    return stringBuilder.toString();
  }
  
  public static String k(Context paramContext) {
    SharedPreferences sharedPreferences = paramContext.getSharedPreferences("qos", 0);
    String str2 = sharedPreferences.getString("deviceId", "");
    String str1 = str2;
    if ("".equals(str2)) {
      str1 = k();
      SharedPreferences.Editor editor = sharedPreferences.edit();
      editor.putString("deviceId", str1);
      editor.commit();
    } 
    return str1;
  }
  
  public static String l(Context paramContext) {
    try {
      return (paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0)).packageName;
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      nameNotFoundException.printStackTrace();
      return "";
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\e\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */