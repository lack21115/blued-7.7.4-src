package com.bytedance.sdk.a.b;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public interface o {
  public static final o a = new o() {
      public List<InetAddress> a(String param1String) throws UnknownHostException {
        if (param1String != null)
          try {
            return Arrays.asList(InetAddress.getAllByName(param1String));
          } catch (NullPointerException nullPointerException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Broken system behaviour for dns lookup of ");
            stringBuilder.append(param1String);
            UnknownHostException unknownHostException = new UnknownHostException(stringBuilder.toString());
            unknownHostException.initCause(nullPointerException);
            throw unknownHostException;
          }  
        throw new UnknownHostException("hostname == null");
      }
    };
  
  List<InetAddress> a(String paramString) throws UnknownHostException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\a\b\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */