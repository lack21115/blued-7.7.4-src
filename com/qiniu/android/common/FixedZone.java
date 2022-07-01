package com.qiniu.android.common;

import com.qiniu.android.collect.LogHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class FixedZone extends Zone {
  public static String[] arrayZoneAs0;
  
  public static String[] arrayzone0 = new String[] { "upload.qiniup.com", "upload-jjh.qiniup.com", "upload-xs.qiniup.com", "up.qiniup.com", "up-jjh.qiniup.com", "up-xs.qiniup.com", "upload.qbox.me", "up.qbox.me" };
  
  public static String[] arrayzone1;
  
  public static String[] arrayzone2;
  
  public static String[] arrayzoneNa0;
  
  private static ZoneInfo preCustomZone;
  
  public static final Zone zone0 = new FixedZone(arrayzone0);
  
  public static final Zone zone1;
  
  public static final Zone zone2;
  
  public static final Zone zoneAs0;
  
  public static final Zone zoneNa0;
  
  private ZoneInfo zoneInfo;
  
  static {
    arrayzone1 = new String[] { "upload-z1.qiniup.com", "up-z1.qiniup.com", "upload-z1.qbox.me", "up-z1.qbox.me" };
    zone1 = new FixedZone(arrayzone1);
    arrayzone2 = new String[] { "upload-z2.qiniup.com", "upload-dg.qiniup.com", "upload-fs.qiniup.com", "up-z2.qiniup.com", "up-dg.qiniup.com", "up-fs.qiniup.com", "upload-z2.qbox.me", "up-z2.qbox.me" };
    zone2 = new FixedZone(arrayzone2);
    arrayzoneNa0 = new String[] { "upload-na0.qiniup.com", "up-na0.qiniup.com", "upload-na0.qbox.me", "up-na0.qbox.me" };
    zoneNa0 = new FixedZone(arrayzoneNa0);
    arrayZoneAs0 = new String[] { "upload-as0.qiniup.com", "up-as0.qiniup.com", "upload-as0.qbox.me", "up-as0.qbox.me" };
    zoneAs0 = new FixedZone(arrayZoneAs0);
  }
  
  public FixedZone(ZoneInfo paramZoneInfo) {
    this.zoneInfo = paramZoneInfo;
  }
  
  public FixedZone(String[] paramArrayOfString) {
    this.zoneInfo = createZoneInfo(paramArrayOfString);
    preCustomZone = this.zoneInfo;
  }
  
  public static ZoneInfo createZoneInfo(String[] paramArrayOfString) {
    ArrayList<String> arrayList = new ArrayList();
    ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<Object, Object>();
    int j = paramArrayOfString.length;
    for (int i = 0; i < j; i++) {
      String str = paramArrayOfString[i];
      arrayList.add(str);
      concurrentHashMap.put(str, Long.valueOf(0L));
    } 
    return new ZoneInfo(0, arrayList, (Map)concurrentHashMap);
  }
  
  public static List<ZoneInfo> getZoneInfos() {
    ArrayList<ZoneInfo> arrayList = new ArrayList();
    arrayList.add(createZoneInfo(arrayzone0));
    arrayList.add(createZoneInfo(arrayzone1));
    arrayList.add(createZoneInfo(arrayzone2));
    arrayList.add(createZoneInfo(arrayzoneNa0));
    arrayList.add(createZoneInfo(arrayZoneAs0));
    ZoneInfo zoneInfo = preCustomZone;
    if (zoneInfo != null)
      arrayList.add(zoneInfo); 
    return arrayList;
  }
  
  public void frozenDomain(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 30
    //   6: aload_1
    //   7: invokestatic create : (Ljava/lang/String;)Ljava/net/URI;
    //   10: invokevirtual getHost : ()Ljava/lang/String;
    //   13: astore_1
    //   14: aload_0
    //   15: getfield zoneInfo : Lcom/qiniu/android/common/ZoneInfo;
    //   18: aload_1
    //   19: invokevirtual frozenDomain : (Ljava/lang/String;)V
    //   22: goto -> 30
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    // Exception table:
    //   from	to	target	type
    //   6	22	25	finally
  }
  
  public void preQuery(LogHandler paramLogHandler, String paramString, Zone.QueryHandler paramQueryHandler) {
    paramQueryHandler.onSuccess();
  }
  
  public boolean preQuery(LogHandler paramLogHandler, String paramString) {
    return true;
  }
  
  public String upHost(String paramString1, boolean paramBoolean, String paramString2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield zoneInfo : Lcom/qiniu/android/common/ZoneInfo;
    //   7: iload_2
    //   8: aload_3
    //   9: invokevirtual upHost : (Lcom/qiniu/android/common/ZoneInfo;ZLjava/lang/String;)Ljava/lang/String;
    //   12: astore_1
    //   13: aload_0
    //   14: getfield zoneInfo : Lcom/qiniu/android/common/ZoneInfo;
    //   17: getfield upDomainsMap : Ljava/util/Map;
    //   20: invokeinterface entrySet : ()Ljava/util/Set;
    //   25: invokeinterface iterator : ()Ljava/util/Iterator;
    //   30: astore_3
    //   31: aload_3
    //   32: invokeinterface hasNext : ()Z
    //   37: ifeq -> 111
    //   40: aload_3
    //   41: invokeinterface next : ()Ljava/lang/Object;
    //   46: checkcast java/util/Map$Entry
    //   49: astore #4
    //   51: new java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial <init> : ()V
    //   58: astore #5
    //   60: aload #5
    //   62: aload #4
    //   64: invokeinterface getKey : ()Ljava/lang/Object;
    //   69: checkcast java/lang/String
    //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload #5
    //   78: ldc ', '
    //   80: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload #5
    //   86: aload #4
    //   88: invokeinterface getValue : ()Ljava/lang/Object;
    //   93: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: ldc 'Qiniu.FixedZone'
    //   99: aload #5
    //   101: invokevirtual toString : ()Ljava/lang/String;
    //   104: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   107: pop
    //   108: goto -> 31
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: areturn
    //   115: astore_1
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_1
    //   119: athrow
    // Exception table:
    //   from	to	target	type
    //   2	31	115	finally
    //   31	108	115	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\common\FixedZone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */