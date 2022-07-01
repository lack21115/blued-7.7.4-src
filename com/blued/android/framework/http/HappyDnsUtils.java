package com.blued.android.framework.http;

import com.qiniu.android.dns.DnsManager;
import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.IpSorter;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import com.qiniu.android.dns.http.DnspodEnterprise;
import com.qiniu.android.dns.http.GoogleHttpsDns;
import com.qiniu.android.dns.local.AndroidDnsServer;
import com.qiniu.android.dns.local.Resolver;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimeZone;

public class HappyDnsUtils {
  private static DnsManager a;
  
  public static boolean a() {
    return true;
  }
  
  public static String[] a(String[] paramArrayOfString) {
    if (paramArrayOfString != null) {
      if (paramArrayOfString.length <= 0)
        return paramArrayOfString; 
      ArrayList<Integer> arrayList = new ArrayList();
      int i;
      for (i = 0; i < paramArrayOfString.length; i++)
        arrayList.add(Integer.valueOf(i)); 
      String[] arrayOfString = new String[paramArrayOfString.length];
      Random random = new Random(System.currentTimeMillis());
      for (i = 0; arrayList.size() > 1; i++)
        arrayOfString[i] = paramArrayOfString[((Integer)arrayList.remove(random.nextInt(arrayList.size()))).intValue()]; 
      arrayOfString[i] = paramArrayOfString[((Integer)arrayList.remove(0)).intValue()];
      return arrayOfString;
    } 
    return paramArrayOfString;
  }
  
  public static boolean b() {
    boolean bool = false;
    try {
      String str = TimeZone.getDefault().getID();
      if (!"Asia/Jakarta".equalsIgnoreCase(str) && !"Asia/Pontianak".equalsIgnoreCase(str) && !"Asia/Makassar".equalsIgnoreCase(str) && !"Asia/Jayapura".equalsIgnoreCase(str) && !"Asia/Dubai".equalsIgnoreCase(str)) {
        boolean bool1 = "Asia/Riyadh".equalsIgnoreCase(str);
        return bool1 ? true : bool;
      } 
      return true;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public static boolean c() {
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
  
  public static DnsManager d() {
    if (a == null) {
      IResolver[] arrayOfIResolver;
      if (b()) {
        GoogleHttpsDns googleHttpsDns = new GoogleHttpsDns();
        DnspodEnterprise dnspodEnterprise = new DnspodEnterprise("9874", "jUG67TU4");
        arrayOfIResolver = new IResolver[2];
        arrayOfIResolver[0] = (IResolver)googleHttpsDns;
        arrayOfIResolver[1] = (IResolver)dnspodEnterprise;
      } else if (c()) {
        arrayOfIResolver = new IResolver[] { (IResolver)new DnspodEnterprise("9874", "jUG67TU4"), AndroidDnsServer.defaultResolver() };
      } else {
        GoogleHttpsDns googleHttpsDns = new GoogleHttpsDns();
        Resolver resolver = null;
        try {
          Resolver resolver1 = new Resolver(InetAddress.getByName("8.8.8.8"));
          resolver = resolver1;
        } catch (UnknownHostException unknownHostException) {
          unknownHostException.printStackTrace();
        } 
        IResolver iResolver = AndroidDnsServer.defaultResolver();
        if (resolver != null) {
          arrayOfIResolver = new IResolver[] { (IResolver)googleHttpsDns, (IResolver)resolver, iResolver };
        } else {
          arrayOfIResolver = new IResolver[2];
          arrayOfIResolver[0] = (IResolver)googleHttpsDns;
          arrayOfIResolver[1] = iResolver;
        } 
      } 
      a = new DnsManager(NetworkInfo.normal, arrayOfIResolver, new IpSorter() {
            public String[] sort(String[] param1ArrayOfString) {
              return HappyDnsUtils.a(param1ArrayOfString);
            }
          });
    } 
    return a;
  }
  
  public static class FixIpResolver implements IResolver {
    private String a;
    
    private String b;
    
    public Record[] resolve(Domain param1Domain, NetworkInfo param1NetworkInfo) throws IOException {
      return param1Domain.domain.equalsIgnoreCase(this.a) ? new Record[] { new Record(this.b, 1, 600, System.currentTimeMillis() / 1000L) } : null;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\http\HappyDnsUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */