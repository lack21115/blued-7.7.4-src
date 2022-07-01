package com.qiniu.android.dns.local;

import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import java.io.IOException;

public final class HijackingDetectWrapper implements IResolver {
  private final Resolver resolver;
  
  public HijackingDetectWrapper(Resolver paramResolver) {
    this.resolver = paramResolver;
  }
  
  public Record[] resolve(Domain paramDomain, NetworkInfo paramNetworkInfo) throws IOException {
    Record[] arrayOfRecord = this.resolver.resolve(paramDomain, paramNetworkInfo);
    boolean bool = paramDomain.hasCname;
    byte b = 0;
    if (bool) {
      int j = arrayOfRecord.length;
      int i = 0;
      while (true) {
        if (i < j) {
          if (arrayOfRecord[i].isCname()) {
            i = 1;
            break;
          } 
          i++;
          continue;
        } 
        i = 0;
        break;
      } 
      if (i == 0)
        throw new DnshijackingException(paramDomain.domain, this.resolver.address.getHostAddress()); 
    } 
    if (paramDomain.maxTtl != 0) {
      int j = arrayOfRecord.length;
      int i = b;
      while (i < j) {
        Record record = arrayOfRecord[i];
        if (record.isCname() || record.ttl <= paramDomain.maxTtl) {
          i++;
          continue;
        } 
        throw new DnshijackingException(paramDomain.domain, this.resolver.address.getHostAddress(), record.ttl);
      } 
    } 
    return arrayOfRecord;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\dns\local\HijackingDetectWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */