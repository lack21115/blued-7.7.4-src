package com.squareup.okhttp;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public interface Dns {
  public static final Dns SYSTEM = new Dns() {
      public List<InetAddress> lookup(String param1String) throws UnknownHostException {
        if (param1String != null)
          return Arrays.asList(InetAddress.getAllByName(param1String)); 
        throw new UnknownHostException("hostname == null");
      }
    };
  
  List<InetAddress> lookup(String paramString) throws UnknownHostException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\Dns.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */