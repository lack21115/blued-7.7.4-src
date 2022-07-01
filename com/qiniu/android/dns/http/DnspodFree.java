package com.qiniu.android.dns.http;

import com.qiniu.android.dns.Domain;
import com.qiniu.android.dns.IResolver;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.Record;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class DnspodFree implements IResolver {
  private final String ip;
  
  private final int timeout;
  
  public DnspodFree() {
    this("119.29.29.29");
  }
  
  public DnspodFree(String paramString) {
    this(paramString, 10);
  }
  
  public DnspodFree(String paramString, int paramInt) {
    this.ip = paramString;
    this.timeout = paramInt;
  }
  
  public Record[] resolve(Domain paramDomain, NetworkInfo paramNetworkInfo) throws IOException {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("http://");
    stringBuilder.append(this.ip);
    stringBuilder.append("/d?ttl=1&dn=");
    stringBuilder.append(paramDomain.domain);
    HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL(stringBuilder.toString())).openConnection();
    httpURLConnection.setConnectTimeout(3000);
    httpURLConnection.setReadTimeout(this.timeout * 1000);
    int i = httpURLConnection.getResponseCode();
    paramDomain = null;
    if (i != 200)
      return null; 
    i = httpURLConnection.getContentLength();
    if (i > 0) {
      if (i > 1024)
        return null; 
      InputStream inputStream = httpURLConnection.getInputStream();
      byte[] arrayOfByte = new byte[i];
      int j = inputStream.read(arrayOfByte);
      inputStream.close();
      if (j <= 0)
        return null; 
      i = 0;
      String[] arrayOfString = (new String(arrayOfByte, 0, j)).split(",");
      if (arrayOfString.length != 2)
        return null; 
      try {
        Record[] arrayOfRecord1;
        j = Integer.parseInt(arrayOfString[1]);
        String[] arrayOfString1 = arrayOfString[0].split(";");
        if (arrayOfString1.length == 0)
          return null; 
        Record[] arrayOfRecord2 = new Record[arrayOfString1.length];
        long l = System.currentTimeMillis() / 1000L;
        while (true) {
          arrayOfRecord1 = arrayOfRecord2;
          if (i < arrayOfString1.length) {
            arrayOfRecord2[i] = new Record(arrayOfString1[i], 1, j, l);
            i++;
            continue;
          } 
          break;
        } 
        return arrayOfRecord1;
      } catch (Exception exception) {
        return null;
      } 
    } 
    return (Record[])exception;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\dns\http\DnspodFree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */