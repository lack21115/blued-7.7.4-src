package org.chromium.android_webview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class ClientCertLookupTable {
  final Map mCerts = new HashMap<Object, Object>();
  
  final Set mDenieds = new HashSet();
  
  static String hostAndPort(String paramString, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(":");
    stringBuilder.append(paramInt);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\ClientCertLookupTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */