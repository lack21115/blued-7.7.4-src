package c.t.maploc.lite.tsa;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

final class x extends Handler {
  private byte[] a = new byte[0];
  
  private File b;
  
  private FileOutputStream c;
  
  private BufferedOutputStream d;
  
  private StringBuffer e;
  
  private SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
  
  public x(v paramv, Looper paramLooper) {
    super(paramLooper);
  }
  
  private String a(j paramj, Location paramLocation, List<ScanResult> paramList1, List<m> paramList2) {
    int i;
    boolean bool;
    if (paramList1 != null) {
      i = paramList1.size();
    } else {
      i = 0;
    } 
    if (paramList2 != null) {
      bool = paramList2.size();
    } else {
      bool = false;
    } 
    if (!i && !bool)
      return ""; 
    k k = paramj.b;
    StringBuilder stringBuilder4 = new StringBuilder();
    StringBuilder stringBuilder5 = new StringBuilder();
    StringBuilder stringBuilder6 = new StringBuilder();
    stringBuilder4.append(0);
    stringBuilder4.append(",");
    stringBuilder4.append(String.format("%.6f", new Object[] { Double.valueOf(paramLocation.getLatitude()) }));
    stringBuilder4.append(",");
    stringBuilder4.append(String.format("%.6f", new Object[] { Double.valueOf(paramLocation.getLongitude()) }));
    stringBuilder4.append(",");
    stringBuilder4.append((int)paramLocation.getAltitude());
    stringBuilder4.append(",");
    stringBuilder4.append((int)paramLocation.getAccuracy());
    stringBuilder4.append(",");
    stringBuilder4.append((int)paramLocation.getBearing());
    stringBuilder4.append(",");
    stringBuilder4.append(String.format("%.1f", new Object[] { Float.valueOf(paramLocation.getSpeed()) }));
    stringBuilder4.append(",");
    stringBuilder4.append(paramLocation.getTime());
    if (paramList2 != null && paramList2.size() > 0)
      for (i = 0; i < paramList2.size(); i++) {
        String str;
        m m = paramList2.get(i);
        if (i == 0) {
          str = "";
        } else {
          str = ";";
        } 
        stringBuilder5.append(str);
        stringBuilder5.append(m.b);
        stringBuilder5.append(",");
        stringBuilder5.append(m.c);
        stringBuilder5.append(",");
        stringBuilder5.append(m.d);
        stringBuilder5.append(",");
        stringBuilder5.append(m.e);
        stringBuilder5.append(",");
        stringBuilder5.append(m.f);
      }  
    if (paramList1 != null && paramList1.size() > 0)
      for (i = 0; i < paramList1.size(); i++) {
        String str;
        ScanResult scanResult = paramList1.get(i);
        if (i == 0) {
          str = "";
        } else {
          str = "&";
        } 
        stringBuilder6.append(str);
        stringBuilder6.append(scanResult.BSSID.replaceAll(":", "").toLowerCase());
        stringBuilder6.append("&");
        stringBuilder6.append(scanResult.level);
      }  
    StringBuilder stringBuilder1 = new StringBuilder();
    String str1 = ai.a(paramj.a);
    if (str1 != null && str1.length() > 5)
      try {
        JSONObject jSONObject = new JSONObject(str1);
        stringBuilder1.append(jSONObject.optString("mac").replaceAll(":", "").toLowerCase());
        stringBuilder1.append("&");
        stringBuilder1.append(jSONObject.optString("ssid"));
        stringBuilder1.append("&");
        stringBuilder1.append(jSONObject.optString("rssi"));
      } finally {
        str1 = null;
      }  
    str1 = k.c.replaceAll("[| _]", "");
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str1);
    stringBuilder2.append("_");
    stringBuilder2.append(k.a);
    str1 = stringBuilder2.toString();
    String str2 = Build.MANUFACTURER.replaceAll("[| _]", "");
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(str2);
    stringBuilder3.append("_");
    stringBuilder3.append(Build.MODEL.replaceAll("[| _]", ""));
    str2 = stringBuilder3.toString();
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append("[");
    stringBuilder3.append(this.f.format(new Date()));
    stringBuilder3.append("]:");
    stringBuilder3.append(k.a());
    stringBuilder3.append("|209|");
    stringBuilder3.append(k.i());
    stringBuilder3.append("|||||||||");
    stringBuilder3.append(stringBuilder4);
    stringBuilder3.append("||");
    stringBuilder3.append(stringBuilder5);
    stringBuilder3.append("|");
    stringBuilder3.append(stringBuilder6);
    stringBuilder3.append("||||||||||||||||sdk_lite");
    stringBuilder3.append("||||");
    stringBuilder3.append(stringBuilder1);
    stringBuilder3.append("|||");
    stringBuilder3.append(str1);
    stringBuilder3.append("|||");
    stringBuilder3.append(str2);
    return stringBuilder3.toString();
  }
  
  private void a() {
    StringBuffer stringBuffer = this.e;
    if (stringBuffer != null && stringBuffer.length() != 0) {
      if (this.d == null)
        return; 
      byte[] arrayOfByte = a(this.e.toString());
      this.e.setLength(0);
      if (arrayOfByte.length != 0)
        try {
          return;
        } finally {
          arrayOfByte = null;
          this.b = null;
          v.a(this.d);
        }  
    } 
  }
  
  private void a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: getfield g : Lc/t/maploc/lite/tsa/v;
    //   4: invokestatic b : (Lc/t/maploc/lite/tsa/v;)[B
    //   7: astore_2
    //   8: aload_2
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield g : Lc/t/maploc/lite/tsa/v;
    //   14: invokestatic c : (Lc/t/maploc/lite/tsa/v;)Lc/t/maploc/lite/tsa/n;
    //   17: astore #7
    //   19: aload_0
    //   20: getfield g : Lc/t/maploc/lite/tsa/v;
    //   23: invokestatic d : (Lc/t/maploc/lite/tsa/v;)Lc/t/maploc/lite/tsa/s;
    //   26: astore #4
    //   28: aload_0
    //   29: getfield g : Lc/t/maploc/lite/tsa/v;
    //   32: invokestatic e : (Lc/t/maploc/lite/tsa/v;)Ljava/util/List;
    //   35: astore #6
    //   37: aload_2
    //   38: monitorexit
    //   39: aload_0
    //   40: getfield a : [B
    //   43: astore #5
    //   45: aload #5
    //   47: monitorenter
    //   48: aload_0
    //   49: invokespecial b : ()V
    //   52: aconst_null
    //   53: astore_3
    //   54: aconst_null
    //   55: astore_2
    //   56: iload_1
    //   57: iconst_2
    //   58: if_icmpne -> 280
    //   61: aload_0
    //   62: getfield g : Lc/t/maploc/lite/tsa/v;
    //   65: invokestatic f : (Lc/t/maploc/lite/tsa/v;)Lc/t/maploc/lite/tsa/j;
    //   68: astore #4
    //   70: aload #7
    //   72: getfield b : Landroid/location/Location;
    //   75: astore_3
    //   76: aload_0
    //   77: aload #4
    //   79: aload_3
    //   80: aload_2
    //   81: aload #6
    //   83: invokespecial a : (Lc/t/maploc/lite/tsa/j;Landroid/location/Location;Ljava/util/List;Ljava/util/List;)Ljava/lang/String;
    //   86: astore_2
    //   87: goto -> 120
    //   90: aload #4
    //   92: getfield b : Ljava/util/List;
    //   95: invokestatic unmodifiableList : (Ljava/util/List;)Ljava/util/List;
    //   98: astore_2
    //   99: aload_0
    //   100: getfield g : Lc/t/maploc/lite/tsa/v;
    //   103: invokestatic f : (Lc/t/maploc/lite/tsa/v;)Lc/t/maploc/lite/tsa/j;
    //   106: astore #4
    //   108: aload #7
    //   110: getfield b : Landroid/location/Location;
    //   113: astore_3
    //   114: goto -> 76
    //   117: ldc ''
    //   119: astore_2
    //   120: aload_0
    //   121: getfield d : Ljava/io/BufferedOutputStream;
    //   124: ifnull -> 265
    //   127: aload_2
    //   128: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   131: ifeq -> 137
    //   134: goto -> 265
    //   137: aload_0
    //   138: getfield e : Ljava/lang/StringBuffer;
    //   141: ifnonnull -> 158
    //   144: aload_0
    //   145: new java/lang/StringBuffer
    //   148: dup
    //   149: sipush #25600
    //   152: invokespecial <init> : (I)V
    //   155: putfield e : Ljava/lang/StringBuffer;
    //   158: aload_0
    //   159: getfield e : Ljava/lang/StringBuffer;
    //   162: astore_3
    //   163: aload_3
    //   164: aload_2
    //   165: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   168: pop
    //   169: aload_3
    //   170: ldc_w '\\n'
    //   173: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   176: pop
    //   177: aload_0
    //   178: getfield e : Ljava/lang/StringBuffer;
    //   181: invokevirtual length : ()I
    //   184: sipush #25600
    //   187: if_icmpgt -> 209
    //   190: aload_0
    //   191: getfield b : Ljava/io/File;
    //   194: ifnull -> 234
    //   197: aload_0
    //   198: getfield b : Ljava/io/File;
    //   201: invokevirtual length : ()J
    //   204: lconst_0
    //   205: lcmp
    //   206: ifne -> 234
    //   209: aload_0
    //   210: invokespecial a : ()V
    //   213: aload_0
    //   214: getfield b : Ljava/io/File;
    //   217: invokevirtual length : ()J
    //   220: ldc2_w 102400
    //   223: lcmp
    //   224: ifle -> 234
    //   227: aload_0
    //   228: getfield g : Lc/t/maploc/lite/tsa/v;
    //   231: invokestatic g : (Lc/t/maploc/lite/tsa/v;)V
    //   234: new java/lang/StringBuilder
    //   237: dup
    //   238: ldc_w 'write:'
    //   241: invokespecial <init> : (Ljava/lang/String;)V
    //   244: astore_3
    //   245: aload_3
    //   246: aload_2
    //   247: iconst_0
    //   248: bipush #60
    //   250: invokevirtual substring : (II)Ljava/lang/String;
    //   253: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload_3
    //   258: ldc_w '***'
    //   261: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload #5
    //   267: monitorexit
    //   268: return
    //   269: astore_2
    //   270: aload #5
    //   272: monitorexit
    //   273: aload_2
    //   274: athrow
    //   275: astore_3
    //   276: aload_2
    //   277: monitorexit
    //   278: aload_3
    //   279: athrow
    //   280: iload_1
    //   281: iconst_1
    //   282: if_icmpne -> 117
    //   285: aload #4
    //   287: ifnonnull -> 90
    //   290: aload_3
    //   291: astore_2
    //   292: goto -> 99
    // Exception table:
    //   from	to	target	type
    //   10	39	275	finally
    //   48	52	269	finally
    //   61	76	269	finally
    //   76	87	269	finally
    //   90	99	269	finally
    //   99	114	269	finally
    //   120	134	269	finally
    //   137	158	269	finally
    //   158	209	269	finally
    //   209	234	269	finally
    //   234	265	269	finally
    //   265	268	269	finally
    //   270	273	269	finally
    //   276	278	275	finally
  }
  
  private void a(long paramLong) {
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  private static byte[] a(String paramString) {
    byte[] arrayOfByte = new byte[0];
    try {
      byte[] arrayOfByte1 = a(paramString.getBytes("GBK"));
      byte[] arrayOfByte2 = ak.a(arrayOfByte1, "0PEq^X$sjtWqEqa2$dg4TG2PT^4dFEep");
      arrayOfByte1 = arrayOfByte;
      return arrayOfByte1;
    } finally {
      paramString = null;
    } 
  }
  
  private static byte[] a(byte[] paramArrayOfbyte) {
    byte[] arrayOfByte2 = null;
    byte[] arrayOfByte1 = arrayOfByte2;
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfbyte.length);
      arrayOfByte1 = arrayOfByte2;
      GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
      arrayOfByte1 = arrayOfByte2;
      gZIPOutputStream.write(paramArrayOfbyte);
      arrayOfByte1 = arrayOfByte2;
      gZIPOutputStream.close();
      arrayOfByte1 = arrayOfByte2;
      paramArrayOfbyte = byteArrayOutputStream.toByteArray();
      arrayOfByte1 = paramArrayOfbyte;
      return paramArrayOfbyte;
    } finally {
      paramArrayOfbyte = null;
    } 
  }
  
  private void b() {
    File file = this.b;
    if (file == null || !file.exists() || this.d == null || !"fclite".equals(this.b.getName())) {
      this.b = d();
      try {
        boolean bool = this.b.exists();
        this.c = new FileOutputStream(this.b, true);
        this.d = new BufferedOutputStream(this.c, 1024);
        return;
      } finally {
        file = null;
      } 
    } 
  }
  
  private void c() {
    File[] arrayOfFile = v.a(this.g).listFiles();
    if (arrayOfFile != null) {
      if (arrayOfFile.length == 0)
        return; 
      long l = System.currentTimeMillis();
      int j = arrayOfFile.length;
      for (int i = 0; i < j; i++) {
        File file = arrayOfFile[i];
        if (file.isFile() && file.exists() && file.getName().startsWith("fclite_") && (l - file.lastModified() > 2592000000L || file.length() == 0L)) {
          (new StringBuilder("delete expired file:")).append(file.getName());
          file.delete();
        } 
      } 
    } 
  }
  
  private File d() {
    File file = v.a(this.g);
    if (!file.exists())
      file.mkdirs(); 
    return new File(file, "fclite");
  }
  
  private long e() {
    try {
      return (v.f(this.g)).h.getLong("fc_lite_create", 0L);
    } finally {
      Exception exception = null;
    } 
  }
  
  public final void handleMessage(Message paramMessage) {
    int i = paramMessage.what;
    if (i != 1 && i != 2)
      if (i != 3) {
        if (i != 4) {
          if (i != 5) {
            if (i != 16)
              return; 
          } else {
            b();
            if (v.a(this.g) != null) {
              File file = this.b;
              if (file != null && file.exists()) {
                a();
                if (this.b.length() > 102400L || System.currentTimeMillis() - e() > 259200000L)
                  try {
                    return;
                  } finally {
                    file = null;
                  }  
              } 
            } 
            return;
          } 
        } else {
          try {
            a();
            if (this.e != null)
              this.e.setLength(0); 
          } finally {}
          this.b = null;
          v.a(this.d);
          v.a(this.c);
          return;
        } 
      } else {
        if (this.d != null) {
          this.d.flush();
          return;
        } 
        return;
      }  
    a(paramMessage.what);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */