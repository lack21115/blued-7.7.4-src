package com.qiniu.android.http;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public interface Dns {
  List<InetAddress> lookup(String paramString) throws UnknownHostException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\http\Dns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */