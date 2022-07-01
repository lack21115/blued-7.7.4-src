package c.t.maploc.lite.tsa;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class s extends p {
  public static final s a = new s(Collections.emptyList(), 0L, 0);
  
  public final List b;
  
  public final long c;
  
  private final int d;
  
  public s(List<?> paramList, long paramLong, int paramInt) {
    this.c = paramLong;
    this.d = paramInt;
    this.b = new ArrayList(paramList);
  }
  
  private static String a(List<ScanResult> paramList) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < paramList.size(); i++) {
      ScanResult scanResult = paramList.get(i);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(scanResult.BSSID);
      stringBuilder1.append("&");
      stringBuilder1.append(scanResult.level);
      stringBuilder1.append("&");
      stringBuilder1.append(scanResult.SSID.replaceAll("[& ,|]", ""));
      String str = stringBuilder1.toString();
      if (i != 0)
        stringBuilder.append('|'); 
      stringBuilder.append(str);
      if (i == 2) {
        stringBuilder.append("|...");
        break;
      } 
    } 
    return stringBuilder.toString();
  }
  
  public static boolean a(List paramList1, List paramList2) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #9
    //   3: iconst_0
    //   4: istore #8
    //   6: aload_0
    //   7: ifnull -> 338
    //   10: aload_1
    //   11: ifnonnull -> 17
    //   14: goto -> 338
    //   17: iload #9
    //   19: istore #7
    //   21: aload_0
    //   22: aload_1
    //   23: if_acmpeq -> 341
    //   26: aload_0
    //   27: invokeinterface size : ()I
    //   32: istore #5
    //   34: aload_1
    //   35: invokeinterface size : ()I
    //   40: istore #6
    //   42: iload #5
    //   44: ifne -> 56
    //   47: iload #9
    //   49: istore #7
    //   51: iload #6
    //   53: ifeq -> 341
    //   56: iload #5
    //   58: ifeq -> 338
    //   61: iload #6
    //   63: ifne -> 69
    //   66: goto -> 338
    //   69: aload_0
    //   70: invokeinterface size : ()I
    //   75: aload_1
    //   76: invokeinterface size : ()I
    //   81: if_icmple -> 90
    //   84: aload_1
    //   85: astore #10
    //   87: goto -> 93
    //   90: aload_0
    //   91: astore #10
    //   93: aload #10
    //   95: aload_1
    //   96: if_acmpne -> 102
    //   99: goto -> 104
    //   102: aload_1
    //   103: astore_0
    //   104: aload #10
    //   106: invokeinterface iterator : ()Ljava/util/Iterator;
    //   111: astore_1
    //   112: iconst_0
    //   113: istore_3
    //   114: iconst_0
    //   115: istore_2
    //   116: aload_1
    //   117: invokeinterface hasNext : ()Z
    //   122: ifeq -> 213
    //   125: aload_1
    //   126: invokeinterface next : ()Ljava/lang/Object;
    //   131: checkcast android/net/wifi/ScanResult
    //   134: astore #10
    //   136: aload_0
    //   137: invokeinterface iterator : ()Ljava/util/Iterator;
    //   142: astore #11
    //   144: aload #11
    //   146: invokeinterface hasNext : ()Z
    //   151: ifeq -> 116
    //   154: aload #11
    //   156: invokeinterface next : ()Ljava/lang/Object;
    //   161: checkcast android/net/wifi/ScanResult
    //   164: astore #12
    //   166: aload #12
    //   168: getfield BSSID : Ljava/lang/String;
    //   171: aload #10
    //   173: getfield BSSID : Ljava/lang/String;
    //   176: invokevirtual equals : (Ljava/lang/Object;)Z
    //   179: ifeq -> 144
    //   182: iload_2
    //   183: iconst_1
    //   184: iadd
    //   185: istore #4
    //   187: iload #4
    //   189: istore_2
    //   190: aload #12
    //   192: getfield level : I
    //   195: aload #10
    //   197: getfield level : I
    //   200: if_icmpne -> 116
    //   203: iload_3
    //   204: iconst_1
    //   205: iadd
    //   206: istore_3
    //   207: iload #4
    //   209: istore_2
    //   210: goto -> 116
    //   213: iload #5
    //   215: iload #6
    //   217: if_icmpne -> 230
    //   220: iload #9
    //   222: istore #7
    //   224: iload_3
    //   225: iload #5
    //   227: if_icmpeq -> 341
    //   230: iload #6
    //   232: iload #5
    //   234: iadd
    //   235: istore #4
    //   237: iload_2
    //   238: iconst_1
    //   239: ishl
    //   240: i2d
    //   241: iload #4
    //   243: i2d
    //   244: ldc2_w 0.85
    //   247: dmul
    //   248: dcmpg
    //   249: iflt -> 261
    //   252: iload #8
    //   254: istore #7
    //   256: iload_2
    //   257: iconst_5
    //   258: if_icmpgt -> 264
    //   261: iconst_1
    //   262: istore #7
    //   264: new java/lang/StringBuilder
    //   267: dup
    //   268: ldc 'isDiffrent:l1='
    //   270: invokespecial <init> : (Ljava/lang/String;)V
    //   273: astore_0
    //   274: aload_0
    //   275: iload #5
    //   277: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload_0
    //   282: ldc ',f='
    //   284: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload_0
    //   289: iload #4
    //   291: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload_0
    //   296: ldc ',c_m='
    //   298: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload_0
    //   303: iload_2
    //   304: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload_0
    //   309: ldc ',c_mr='
    //   311: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload_0
    //   316: iload_3
    //   317: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload_0
    //   322: ldc ',d='
    //   324: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload_0
    //   329: iload #7
    //   331: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: iload #7
    //   337: ireturn
    //   338: iconst_1
    //   339: istore #7
    //   341: iload #7
    //   343: ireturn
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder("TxWifiInfo[time=");
    stringBuilder.append(this.c);
    stringBuilder.append(", wifiStatus=");
    stringBuilder.append(this.d);
    stringBuilder.append(", size=");
    stringBuilder.append(this.b.size());
    stringBuilder.append(", list=");
    stringBuilder.append(a(this.b));
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */