package com.qiniu.android.http;

import com.qiniu.android.collect.Config;
import com.qiniu.android.collect.LogHandler;
import com.qiniu.android.collect.UploadInfo;
import com.qiniu.android.collect.UploadInfoElementCollector;
import com.qiniu.android.common.FixedZone;
import com.qiniu.android.common.ZoneInfo;
import com.qiniu.android.http.custom.DnsCacheKey;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.persistent.DnsCacheFile;
import com.qiniu.android.utils.AndroidNetwork;
import com.qiniu.android.utils.StringUtils;
import com.qiniu.android.utils.UrlSafeBase64;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.Dns;
import org.json.JSONException;
import org.json.JSONObject;

public class DnsPrefetcher {
  private static Configuration config;
  
  public static DnsPrefetcher dnsPrefetcher;
  
  private static ConcurrentHashMap<String, List<InetAddress>> mConcurrentHashMap = new ConcurrentHashMap<String, List<InetAddress>>();
  
  private static AtomicReference mDnsCacheKey = new AtomicReference();
  
  public static String target_region_id = "";
  
  private static String token;
  
  public static boolean checkRePrefetchDns(String paramString, Configuration paramConfiguration) {
    if (mDnsCacheKey.get() == null)
      return true; 
    String str1 = String.valueOf(System.currentTimeMillis());
    String str2 = AndroidNetwork.getHostIP();
    paramString = StringUtils.getAkAndScope(paramString);
    if (str1 != null && str2 != null) {
      if (paramString == null)
        return true; 
      DnsCacheKey dnsCacheKey = mDnsCacheKey.get();
      if (dnsCacheKey != null) {
        if (dnsCacheKey.getCurrentTime() == null)
          return true; 
        long l = (Long.parseLong(str1) - Long.parseLong(dnsCacheKey.getCurrentTime())) / 1000L;
        if (str2.equals(dnsCacheKey.getLocalIp()) && l <= paramConfiguration.dnsCacheTimeMs)
          return !paramString.equals(dnsCacheKey.getAkScope()); 
      } 
    } 
    return true;
  }
  
  public static DnsPrefetcher getDnsPrefetcher() {
    // Byte code:
    //   0: getstatic com/qiniu/android/http/DnsPrefetcher.dnsPrefetcher : Lcom/qiniu/android/http/DnsPrefetcher;
    //   3: ifnonnull -> 37
    //   6: ldc com/qiniu/android/http/DnsPrefetcher
    //   8: monitorenter
    //   9: getstatic com/qiniu/android/http/DnsPrefetcher.dnsPrefetcher : Lcom/qiniu/android/http/DnsPrefetcher;
    //   12: ifnonnull -> 25
    //   15: new com/qiniu/android/http/DnsPrefetcher
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/qiniu/android/http/DnsPrefetcher.dnsPrefetcher : Lcom/qiniu/android/http/DnsPrefetcher;
    //   25: ldc com/qiniu/android/http/DnsPrefetcher
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/qiniu/android/http/DnsPrefetcher
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/qiniu/android/http/DnsPrefetcher.dnsPrefetcher : Lcom/qiniu/android/http/DnsPrefetcher;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void preFetch(List<String> paramList) {
    ArrayList<String> arrayList = new ArrayList();
    for (String str : paramList) {
      try {
        List<InetAddress> list = Dns.a.lookup(str);
        mConcurrentHashMap.put(str, list);
      } catch (UnknownHostException unknownHostException) {
        unknownHostException.printStackTrace();
        arrayList.add(str);
      } 
    } 
    if (arrayList.size() > 0)
      rePreFetch(arrayList, (Dns)null); 
  }
  
  private List<String> preHosts() {
    HashSet<String> hashSet = new HashSet();
    ArrayList<String> arrayList = new ArrayList();
    ZoneInfo zoneInfo = getPreQueryZone();
    if (zoneInfo != null)
      for (String str : zoneInfo.upDomainsList) {
        if (hashSet.add(str))
          arrayList.add(str); 
      }  
    Iterator<ZoneInfo> iterator = getLocalZone().iterator();
    while (iterator.hasNext()) {
      for (String str : ((ZoneInfo)iterator.next()).upDomainsList) {
        if (hashSet.add(str))
          arrayList.add(str); 
      } 
    } 
    if (hashSet.add(Config.preQueryHost))
      arrayList.add(Config.preQueryHost); 
    return arrayList;
  }
  
  private void rePreFetch(List<String> paramList, Dns paramDns) {
    for (String str : paramList) {
      int i = 0;
      while (i < Config.rePreHost) {
        i++;
        if (rePreFetch(str, paramDns))
          break; 
      } 
    } 
  }
  
  private boolean rePreFetch(String paramString, Dns paramDns) {
    if (paramDns == null)
      try {
        list = Dns.a.lookup(paramString);
        mConcurrentHashMap.put(paramString, list);
        return true;
      } catch (UnknownHostException unknownHostException) {
        unknownHostException.printStackTrace();
        return false;
      }  
    List<InetAddress> list = list.lookup((String)unknownHostException);
    mConcurrentHashMap.put(unknownHostException, list);
    return true;
  }
  
  public static boolean recoverCache(Configuration paramConfiguration) {
    try {
      DnsCacheFile dnsCacheFile = new DnsCacheFile(Config.dnscacheDir);
      String str1 = dnsCacheFile.getFileName();
      if (str1 == null)
        return true; 
      byte[] arrayOfByte = dnsCacheFile.get(str1);
      if (arrayOfByte == null)
        return true; 
      DnsCacheKey dnsCacheKey = DnsCacheKey.toCacheKey(str1);
      if (dnsCacheKey == null)
        return true; 
      String str2 = String.valueOf(System.currentTimeMillis());
      String str3 = AndroidNetwork.getHostIP();
      if (str2 != null) {
        if (str3 == null)
          return true; 
        long l = (Long.parseLong(str2) - Long.parseLong(dnsCacheKey.getCurrentTime())) / 1000L;
        if (dnsCacheKey.getLocalIp().equals(str3)) {
          if (l > paramConfiguration.dnsCacheTimeMs)
            return true; 
          mDnsCacheKey.set(dnsCacheKey);
          return recoverDnsCache(arrayOfByte);
        } 
      } 
      return true;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return true;
    } 
  }
  
  public static boolean recoverDnsCache(byte[] paramArrayOfbyte) {
    try {
      ConcurrentHashMap<String, List<InetAddress>> concurrentHashMap = (ConcurrentHashMap)StringUtils.toObject(paramArrayOfbyte);
      if (concurrentHashMap == null)
        return true; 
      getDnsPrefetcher().setConcurrentHashMap(concurrentHashMap);
      return false;
    } catch (Exception exception) {
      return true;
    } 
  }
  
  public static void startPrefetchDns(String paramString, Configuration paramConfiguration) {
    String str1 = String.valueOf(System.currentTimeMillis());
    String str2 = AndroidNetwork.getHostIP();
    String str3 = StringUtils.getAkAndScope(paramString);
    if (str1 != null && str2 != null) {
      if (str3 == null)
        return; 
      DnsCacheKey dnsCacheKey = new DnsCacheKey(str1, str2, str3);
      str1 = dnsCacheKey.toString();
      try {
        DnsCacheFile dnsCacheFile = new DnsCacheFile(Config.dnscacheDir);
        DnsPrefetcher dnsPrefetcher = getDnsPrefetcher().init(paramString, paramConfiguration);
        mDnsCacheKey.set(dnsCacheKey);
        if (paramConfiguration.dns != null)
          getDnsPrefetcher().dnsPreByCustom(paramConfiguration.dns); 
        if (dnsPrefetcher != null) {
          byte[] arrayOfByte = StringUtils.toByteArray(dnsPrefetcher.getConcurrentHashMap());
          if (arrayOfByte == null)
            return; 
          dnsCacheFile.set(str1, arrayOfByte);
        } 
        return;
      } catch (IOException iOException) {
        iOException.printStackTrace();
      } 
    } 
  }
  
  public void dnsPreByCustom(Dns paramDns) {
    ArrayList<String> arrayList = new ArrayList();
    ConcurrentHashMap<String, List<InetAddress>> concurrentHashMap = mConcurrentHashMap;
    if (concurrentHashMap != null && concurrentHashMap.size() > 0)
      for (String str : mConcurrentHashMap.keySet()) {
        if (str != null && str.length() != 0)
          try {
            List<InetAddress> list = paramDns.lookup(str);
            mConcurrentHashMap.put(str, list);
          } catch (UnknownHostException unknownHostException) {
            unknownHostException.printStackTrace();
            arrayList.add(str);
          }  
      }  
    rePreFetch(arrayList, paramDns);
  }
  
  public ConcurrentHashMap<String, List<InetAddress>> getConcurrentHashMap() {
    return mConcurrentHashMap;
  }
  
  public List<InetAddress> getInetAddressByHost(String paramString) {
    return mConcurrentHashMap.get(paramString);
  }
  
  public List<ZoneInfo> getLocalZone() {
    return FixedZone.getZoneInfos();
  }
  
  public ZoneInfo getPreQueryZone() {
    return preQueryIndex(ZoneIndex.getFromToken(token));
  }
  
  ResponseInfo getZoneJsonSync(ZoneIndex paramZoneIndex) {
    String str2;
    Client client = new Client();
    if (!config.useHttps) {
      str2 = "http://";
    } else {
      str2 = "https://";
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str2);
    stringBuilder.append(Config.preQueryHost);
    stringBuilder.append("/v2/query?ak=");
    stringBuilder.append(paramZoneIndex.accessKey);
    stringBuilder.append("&bucket=");
    stringBuilder.append(paramZoneIndex.bucket);
    String str1 = stringBuilder.toString();
    LogHandler logHandler = UploadInfoElementCollector.getUplogHandler(UploadInfo.getReqInfo());
    logHandler.send("up_type", "uc_query");
    return client.syncGet(logHandler, str1, null);
  }
  
  public DnsPrefetcher init(String paramString, Configuration paramConfiguration) throws UnknownHostException {
    token = paramString;
    config = paramConfiguration;
    List<String> list = preHosts();
    if (list != null && list.size() > 0)
      preFetch(list); 
    return this;
  }
  
  public void localFetch() {
    ArrayList<String> arrayList = new ArrayList();
    Iterator<ZoneInfo> iterator = getLocalZone().iterator();
    while (iterator.hasNext()) {
      Iterator<String> iterator1 = ((ZoneInfo)iterator.next()).upDomainsList.iterator();
      while (iterator1.hasNext())
        arrayList.add(iterator1.next()); 
    } 
    arrayList.add(Config.preQueryHost);
    if (arrayList.size() > 0)
      preFetch(arrayList); 
  }
  
  ZoneInfo preQueryIndex(ZoneIndex paramZoneIndex) {
    try {
      ResponseInfo responseInfo = getZoneJsonSync(paramZoneIndex);
      if (responseInfo.response == null)
        return null; 
      ZoneInfo zoneInfo = ZoneInfo.buildFromJson(responseInfo.response);
      if (zoneInfo == null)
        return null; 
      if (zoneInfo.upDomainsList.size() > 0) {
        if (zoneInfo.upDomainsList.contains(FixedZone.arrayzone0[0])) {
          target_region_id = "z0";
          return zoneInfo;
        } 
        if (zoneInfo.upDomainsList.contains(FixedZone.arrayzone1[0])) {
          target_region_id = "z1";
          return zoneInfo;
        } 
        if (zoneInfo.upDomainsList.contains(FixedZone.arrayzone2[0])) {
          target_region_id = "z2";
          return zoneInfo;
        } 
        if (zoneInfo.upDomainsList.contains(FixedZone.arrayZoneAs0[0])) {
          target_region_id = "as0";
          return zoneInfo;
        } 
        if (zoneInfo.upDomainsList.contains(FixedZone.arrayzoneNa0[0]))
          target_region_id = "na"; 
      } 
      return zoneInfo;
    } catch (JSONException jSONException) {
      jSONException.printStackTrace();
      return null;
    } 
  }
  
  public void setConcurrentHashMap(ConcurrentHashMap<String, List<InetAddress>> paramConcurrentHashMap) {
    mConcurrentHashMap = paramConcurrentHashMap;
  }
  
  public void setToken(String paramString) {
    token = paramString;
  }
  
  static class ZoneIndex {
    final String accessKey;
    
    final String bucket;
    
    ZoneIndex(String param1String1, String param1String2) {
      this.accessKey = param1String1;
      this.bucket = param1String2;
    }
    
    static ZoneIndex getFromToken(String param1String) {
      String[] arrayOfString = param1String.split(":");
      String str = arrayOfString[0];
      try {
        return new ZoneIndex(str, (new JSONObject(new String(UrlSafeBase64.decode(arrayOfString[2]), "utf-8"))).getString("scope").split(":")[0]);
      } catch (Exception exception) {
        exception.printStackTrace();
        return null;
      } 
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object != this) {
        if (param1Object != null && param1Object instanceof ZoneIndex) {
          param1Object = param1Object;
          if (((ZoneIndex)param1Object).accessKey.equals(this.accessKey) && ((ZoneIndex)param1Object).bucket.equals(this.bucket))
            return true; 
        } 
        return false;
      } 
      return true;
    }
    
    public int hashCode() {
      return this.accessKey.hashCode() * 37 + this.bucket.hashCode();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\http\DnsPrefetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */