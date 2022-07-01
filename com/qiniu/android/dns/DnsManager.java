package com.qiniu.android.dns;

import android.text.TextUtils;
import com.qiniu.android.dns.local.Hosts;
import com.qiniu.android.dns.util.LruCache;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;

public final class DnsManager {
  private final LruCache<String, Record[]> cache;
  
  private final Hosts hosts = new Hosts();
  
  private volatile int index = 0;
  
  private volatile NetworkInfo info = null;
  
  private final IResolver[] resolvers;
  
  private final IpSorter sorter;
  
  public DnsManager(NetworkInfo paramNetworkInfo, IResolver[] paramArrayOfIResolver) {
    this(paramNetworkInfo, paramArrayOfIResolver, null);
  }
  
  public DnsManager(NetworkInfo paramNetworkInfo, IResolver[] paramArrayOfIResolver, IpSorter paramIpSorter) {
    NetworkInfo networkInfo = paramNetworkInfo;
    if (paramNetworkInfo == null)
      networkInfo = NetworkInfo.normal; 
    this.info = networkInfo;
    this.resolvers = (IResolver[])paramArrayOfIResolver.clone();
    this.cache = new LruCache();
    IpSorter ipSorter = paramIpSorter;
    if (paramIpSorter == null)
      ipSorter = new DummySorter(); 
    this.sorter = ipSorter;
  }
  
  private void clearCache() {
    synchronized (this.cache) {
      this.cache.clear();
      return;
    } 
  }
  
  public static boolean needHttpDns() {
    boolean bool = false;
    try {
      String str = TimeZone.getDefault().getID();
      if (!"Asia/Shanghai".equals(str) && !"Asia/Chongqing".equals(str) && !"Asia/Harbin".equals(str)) {
        boolean bool1 = "Asia/Urumqi".equals(str);
        return bool1 ? true : bool;
      } 
      return true;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  private String[] queryInternal(Domain paramDomain) throws IOException {
    // Byte code:
    //   0: aload_1
    //   1: getfield hostsFirst : Z
    //   4: ifeq -> 35
    //   7: aload_0
    //   8: getfield hosts : Lcom/qiniu/android/dns/local/Hosts;
    //   11: aload_1
    //   12: aload_0
    //   13: getfield info : Lcom/qiniu/android/dns/NetworkInfo;
    //   16: invokevirtual query : (Lcom/qiniu/android/dns/Domain;Lcom/qiniu/android/dns/NetworkInfo;)[Ljava/lang/String;
    //   19: astore #5
    //   21: aload #5
    //   23: ifnull -> 35
    //   26: aload #5
    //   28: arraylength
    //   29: ifeq -> 35
    //   32: aload #5
    //   34: areturn
    //   35: aload_0
    //   36: getfield cache : Lcom/qiniu/android/dns/util/LruCache;
    //   39: astore #7
    //   41: aload #7
    //   43: monitorenter
    //   44: aload_0
    //   45: getfield info : Lcom/qiniu/android/dns/NetworkInfo;
    //   48: getstatic com/qiniu/android/dns/NetworkInfo.normal : Lcom/qiniu/android/dns/NetworkInfo;
    //   51: invokevirtual equals : (Ljava/lang/Object;)Z
    //   54: ifeq -> 96
    //   57: invokestatic isNetworkChanged : ()Z
    //   60: ifeq -> 96
    //   63: aload_0
    //   64: getfield cache : Lcom/qiniu/android/dns/util/LruCache;
    //   67: invokevirtual clear : ()V
    //   70: aload_0
    //   71: getfield resolvers : [Lcom/qiniu/android/dns/IResolver;
    //   74: astore #5
    //   76: aload #5
    //   78: monitorenter
    //   79: aload_0
    //   80: iconst_0
    //   81: putfield index : I
    //   84: aload #5
    //   86: monitorexit
    //   87: goto -> 551
    //   90: astore_1
    //   91: aload #5
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    //   96: aload_0
    //   97: getfield cache : Lcom/qiniu/android/dns/util/LruCache;
    //   100: aload_1
    //   101: getfield domain : Ljava/lang/String;
    //   104: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   107: checkcast [Lcom/qiniu/android/dns/Record;
    //   110: astore #6
    //   112: aload #6
    //   114: astore #5
    //   116: aload #6
    //   118: ifnull -> 164
    //   121: aload #6
    //   123: astore #5
    //   125: aload #6
    //   127: arraylength
    //   128: ifeq -> 164
    //   131: aload #6
    //   133: iconst_0
    //   134: aaload
    //   135: invokevirtual isExpired : ()Z
    //   138: ifne -> 551
    //   141: aload #6
    //   143: arraylength
    //   144: iconst_1
    //   145: if_icmple -> 153
    //   148: aload #6
    //   150: invokestatic rotate : ([Lcom/qiniu/android/dns/Record;)V
    //   153: aload #6
    //   155: invokestatic records2Ip : ([Lcom/qiniu/android/dns/Record;)[Ljava/lang/String;
    //   158: astore_1
    //   159: aload #7
    //   161: monitorexit
    //   162: aload_1
    //   163: areturn
    //   164: aload #7
    //   166: monitorexit
    //   167: aload_0
    //   168: getfield index : I
    //   171: istore_3
    //   172: aconst_null
    //   173: astore #7
    //   175: aload #5
    //   177: astore #6
    //   179: iconst_0
    //   180: istore_2
    //   181: aload #7
    //   183: astore #5
    //   185: aload_0
    //   186: getfield resolvers : [Lcom/qiniu/android/dns/IResolver;
    //   189: astore #9
    //   191: aload #6
    //   193: astore #8
    //   195: aload #5
    //   197: astore #7
    //   199: iload_2
    //   200: aload #9
    //   202: arraylength
    //   203: if_icmpge -> 410
    //   206: aload #9
    //   208: arraylength
    //   209: istore #4
    //   211: aload_0
    //   212: getfield info : Lcom/qiniu/android/dns/NetworkInfo;
    //   215: astore #9
    //   217: invokestatic getIp : ()Ljava/lang/String;
    //   220: astore #10
    //   222: aload_0
    //   223: getfield resolvers : [Lcom/qiniu/android/dns/IResolver;
    //   226: iload_3
    //   227: iload_2
    //   228: iadd
    //   229: iload #4
    //   231: irem
    //   232: aaload
    //   233: aload_1
    //   234: aload_0
    //   235: getfield info : Lcom/qiniu/android/dns/NetworkInfo;
    //   238: invokeinterface resolve : (Lcom/qiniu/android/dns/Domain;Lcom/qiniu/android/dns/NetworkInfo;)[Lcom/qiniu/android/dns/Record;
    //   243: astore #7
    //   245: aload #7
    //   247: astore #6
    //   249: goto -> 288
    //   252: astore #7
    //   254: getstatic android/os/Build$VERSION.SDK_INT : I
    //   257: bipush #9
    //   259: if_icmplt -> 273
    //   262: new java/io/IOException
    //   265: dup
    //   266: aload #7
    //   268: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   271: astore #5
    //   273: aload #7
    //   275: invokevirtual printStackTrace : ()V
    //   278: goto -> 288
    //   281: astore #5
    //   283: aload #5
    //   285: invokevirtual printStackTrace : ()V
    //   288: invokestatic getIp : ()Ljava/lang/String;
    //   291: astore #11
    //   293: aload #6
    //   295: astore #8
    //   297: aload #5
    //   299: astore #7
    //   301: aload_0
    //   302: getfield info : Lcom/qiniu/android/dns/NetworkInfo;
    //   305: aload #9
    //   307: if_acmpne -> 410
    //   310: aload #6
    //   312: ifnull -> 329
    //   315: aload #6
    //   317: astore #8
    //   319: aload #5
    //   321: astore #7
    //   323: aload #6
    //   325: arraylength
    //   326: ifne -> 410
    //   329: aload #6
    //   331: astore #8
    //   333: aload #5
    //   335: astore #7
    //   337: aload #10
    //   339: aload #11
    //   341: invokevirtual equals : (Ljava/lang/Object;)Z
    //   344: ifeq -> 410
    //   347: aload_0
    //   348: getfield resolvers : [Lcom/qiniu/android/dns/IResolver;
    //   351: astore #7
    //   353: aload #7
    //   355: monitorenter
    //   356: aload_0
    //   357: getfield index : I
    //   360: iload_3
    //   361: if_icmpne -> 391
    //   364: aload_0
    //   365: aload_0
    //   366: getfield index : I
    //   369: iconst_1
    //   370: iadd
    //   371: putfield index : I
    //   374: aload_0
    //   375: getfield index : I
    //   378: aload_0
    //   379: getfield resolvers : [Lcom/qiniu/android/dns/IResolver;
    //   382: arraylength
    //   383: if_icmpne -> 391
    //   386: aload_0
    //   387: iconst_0
    //   388: putfield index : I
    //   391: aload #7
    //   393: monitorexit
    //   394: goto -> 403
    //   397: astore_1
    //   398: aload #7
    //   400: monitorexit
    //   401: aload_1
    //   402: athrow
    //   403: iload_2
    //   404: iconst_1
    //   405: iadd
    //   406: istore_2
    //   407: goto -> 185
    //   410: aload #8
    //   412: ifnull -> 485
    //   415: aload #8
    //   417: arraylength
    //   418: ifne -> 424
    //   421: goto -> 485
    //   424: aload #8
    //   426: invokestatic trimCname : ([Lcom/qiniu/android/dns/Record;)[Lcom/qiniu/android/dns/Record;
    //   429: astore #6
    //   431: aload #6
    //   433: arraylength
    //   434: ifeq -> 475
    //   437: aload_0
    //   438: getfield cache : Lcom/qiniu/android/dns/util/LruCache;
    //   441: astore #5
    //   443: aload #5
    //   445: monitorenter
    //   446: aload_0
    //   447: getfield cache : Lcom/qiniu/android/dns/util/LruCache;
    //   450: aload_1
    //   451: getfield domain : Ljava/lang/String;
    //   454: aload #6
    //   456: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/qiniu/android/dns/util/LruCache;
    //   459: pop
    //   460: aload #5
    //   462: monitorexit
    //   463: aload #6
    //   465: invokestatic records2Ip : ([Lcom/qiniu/android/dns/Record;)[Ljava/lang/String;
    //   468: areturn
    //   469: astore_1
    //   470: aload #5
    //   472: monitorexit
    //   473: aload_1
    //   474: athrow
    //   475: new java/net/UnknownHostException
    //   478: dup
    //   479: ldc 'no A records'
    //   481: invokespecial <init> : (Ljava/lang/String;)V
    //   484: athrow
    //   485: aload_1
    //   486: getfield hostsFirst : Z
    //   489: ifne -> 520
    //   492: aload_0
    //   493: getfield hosts : Lcom/qiniu/android/dns/local/Hosts;
    //   496: aload_1
    //   497: aload_0
    //   498: getfield info : Lcom/qiniu/android/dns/NetworkInfo;
    //   501: invokevirtual query : (Lcom/qiniu/android/dns/Domain;Lcom/qiniu/android/dns/NetworkInfo;)[Ljava/lang/String;
    //   504: astore #5
    //   506: aload #5
    //   508: ifnull -> 520
    //   511: aload #5
    //   513: arraylength
    //   514: ifeq -> 520
    //   517: aload #5
    //   519: areturn
    //   520: aload #7
    //   522: ifnull -> 528
    //   525: aload #7
    //   527: athrow
    //   528: new java/net/UnknownHostException
    //   531: dup
    //   532: aload_1
    //   533: getfield domain : Ljava/lang/String;
    //   536: invokespecial <init> : (Ljava/lang/String;)V
    //   539: athrow
    //   540: astore_1
    //   541: aload #7
    //   543: monitorexit
    //   544: aload_1
    //   545: athrow
    //   546: astore #7
    //   548: goto -> 403
    //   551: aconst_null
    //   552: astore #5
    //   554: goto -> 164
    // Exception table:
    //   from	to	target	type
    //   44	79	540	finally
    //   79	87	90	finally
    //   91	94	90	finally
    //   94	96	540	finally
    //   96	112	540	finally
    //   125	153	540	finally
    //   153	162	540	finally
    //   164	167	540	finally
    //   222	245	546	com/qiniu/android/dns/http/DomainNotOwn
    //   222	245	281	java/io/IOException
    //   222	245	252	java/lang/Exception
    //   356	391	397	finally
    //   391	394	397	finally
    //   398	401	397	finally
    //   446	463	469	finally
    //   470	473	469	finally
    //   541	544	540	finally
  }
  
  private static String[] records2Ip(Record[] paramArrayOfRecord) {
    if (paramArrayOfRecord != null) {
      if (paramArrayOfRecord.length == 0)
        return null; 
      ArrayList<String> arrayList = new ArrayList(paramArrayOfRecord.length);
      int j = paramArrayOfRecord.length;
      for (int i = 0; i < j; i++)
        arrayList.add((paramArrayOfRecord[i]).value); 
      return (arrayList.size() == 0) ? null : arrayList.<String>toArray(new String[arrayList.size()]);
    } 
    return null;
  }
  
  private static void rotate(Record[] paramArrayOfRecord) {
    if (paramArrayOfRecord != null && paramArrayOfRecord.length > 1) {
      Record record = paramArrayOfRecord[0];
      System.arraycopy(paramArrayOfRecord, 1, paramArrayOfRecord, 0, paramArrayOfRecord.length - 1);
      paramArrayOfRecord[paramArrayOfRecord.length - 1] = record;
    } 
  }
  
  private static Record[] trimCname(Record[] paramArrayOfRecord) {
    ArrayList<Record> arrayList = new ArrayList(paramArrayOfRecord.length);
    int j = paramArrayOfRecord.length;
    for (int i = 0; i < j; i++) {
      Record record = paramArrayOfRecord[i];
      if (record != null && record.type == 1)
        arrayList.add(record); 
    } 
    return arrayList.<Record>toArray(new Record[arrayList.size()]);
  }
  
  public static boolean validIP(String paramString) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null) {
      bool1 = bool2;
      if (paramString.length() >= 7) {
        if (paramString.length() > 15)
          return false; 
        if (paramString.contains("-"))
          return false; 
        try {
          int i = paramString.indexOf('.');
          if (i != -1 && Integer.parseInt(paramString.substring(0, i)) > 255)
            return false; 
          int j = paramString.indexOf('.', ++i);
          if (j != -1 && Integer.parseInt(paramString.substring(i, j)) > 255)
            return false; 
          i = j + 1;
          j = paramString.indexOf('.', i);
          if (j != -1 && Integer.parseInt(paramString.substring(i, j)) > 255 && Integer.parseInt(paramString.substring(j + 1, paramString.length() - 1)) > 255) {
            i = paramString.charAt(paramString.length() - 1);
            bool1 = bool2;
            return (i == 46) ? true : bool1;
          } 
          return true;
        } catch (NumberFormatException numberFormatException) {
          return false;
        } 
      } 
    } 
    return bool1;
  }
  
  public void invalidDnsResult(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    synchronized (this.cache) {
      this.cache.delete(paramString);
      synchronized (this.resolvers) {
        this.index++;
        if (this.index == this.resolvers.length)
          this.index = 0; 
        return;
      } 
    } 
  }
  
  public void onNetworkChange(NetworkInfo paramNetworkInfo) {
    clearCache();
    null = paramNetworkInfo;
    if (paramNetworkInfo == null)
      null = NetworkInfo.normal; 
    this.info = null;
    synchronized (this.resolvers) {
      this.index = 0;
      return;
    } 
  }
  
  public DnsManager putHosts(String paramString1, String paramString2) {
    this.hosts.put(paramString1, paramString2);
    return this;
  }
  
  public DnsManager putHosts(String paramString1, String paramString2, int paramInt) {
    this.hosts.put(paramString1, new Hosts.Value(paramString2, paramInt));
    return this;
  }
  
  public String[] query(Domain paramDomain) throws IOException {
    if (paramDomain != null) {
      String[] arrayOfString;
      if (paramDomain.domain != null && paramDomain.domain.trim().length() != 0) {
        if (validIP(paramDomain.domain))
          return new String[] { paramDomain.domain }; 
        String[] arrayOfString1 = queryInternal(paramDomain);
        arrayOfString = arrayOfString1;
        if (arrayOfString1 != null) {
          if (arrayOfString1.length <= 1)
            return arrayOfString1; 
          arrayOfString = this.sorter.sort(arrayOfString1);
        } 
        return arrayOfString;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("empty domain ");
      stringBuilder.append(((Domain)arrayOfString).domain);
      throw new IOException(stringBuilder.toString());
    } 
    throw new IOException("null domain");
  }
  
  public String[] query(String paramString) throws IOException {
    return query(new Domain(paramString));
  }
  
  public String[] queryFromCache(String paramString) {
    synchronized (this.cache) {
      if (this.info.equals(NetworkInfo.normal) && Network.isNetworkChanged()) {
        this.cache.clear();
        synchronized (this.resolvers) {
          this.index = 0;
        } 
      } else {
        Record[] arrayOfRecord = (Record[])this.cache.get(paramString);
        if (arrayOfRecord != null && arrayOfRecord.length != 0 && !arrayOfRecord[0].isExpired())
          return records2Ip(arrayOfRecord); 
      } 
      return null;
    } 
  }
  
  public InetAddress[] queryInetAdress(Domain paramDomain) throws IOException {
    String[] arrayOfString = query(paramDomain);
    InetAddress[] arrayOfInetAddress = new InetAddress[arrayOfString.length];
    for (int i = 0; i < arrayOfString.length; i++)
      arrayOfInetAddress[i] = InetAddress.getByName(arrayOfString[i]); 
    return arrayOfInetAddress;
  }
  
  static class DummySorter implements IpSorter {
    private AtomicInteger pos = new AtomicInteger();
    
    private DummySorter() {}
    
    public String[] sort(String[] param1ArrayOfString) {
      return param1ArrayOfString;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\dns\DnsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */