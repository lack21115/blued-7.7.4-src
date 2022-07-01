package com.facebook.stetho.inspector.elements;

import com.facebook.stetho.common.ThreadBound;
import com.facebook.stetho.common.UncheckedCallable;
import com.facebook.stetho.common.Util;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public abstract class Descriptor<E> implements NodeDescriptor<E> {
  private Host mHost;
  
  protected static Map<String, String> parseSetAttributesAsTextArg(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    int k = paramString.length();
    String str2 = "";
    String str1 = str2;
    int i = 0;
    int j = 0;
    while (i < k) {
      char c = paramString.charAt(i);
      if (c == '=') {
        str2 = stringBuilder.toString();
        stringBuilder.setLength(0);
      } else if (c == '"') {
        if (j) {
          str1 = stringBuilder.toString();
          stringBuilder.setLength(0);
        } 
        j ^= 0x1;
      } else if (c == ' ' && j == 0) {
        hashMap.put(str2, str1);
      } else {
        stringBuilder.append(c);
      } 
      i++;
    } 
    if (!str2.isEmpty() && !str1.isEmpty())
      hashMap.put(str2, str1); 
    return (Map)hashMap;
  }
  
  public final boolean checkThreadAccess() {
    return getHost().checkThreadAccess();
  }
  
  public final Host getHost() {
    return this.mHost;
  }
  
  final void initialize(Host paramHost) {
    Util.throwIfNull(paramHost);
    Util.throwIfNotNull(this.mHost);
    this.mHost = paramHost;
  }
  
  final boolean isInitialized() {
    return (this.mHost != null);
  }
  
  public final <V> V postAndWait(UncheckedCallable<V> paramUncheckedCallable) {
    return (V)getHost().postAndWait(paramUncheckedCallable);
  }
  
  public final void postAndWait(Runnable paramRunnable) {
    getHost().postAndWait(paramRunnable);
  }
  
  public final void postDelayed(Runnable paramRunnable, long paramLong) {
    getHost().postDelayed(paramRunnable, paramLong);
  }
  
  public final void removeCallbacks(Runnable paramRunnable) {
    getHost().removeCallbacks(paramRunnable);
  }
  
  public final void verifyThreadAccess() {
    getHost().verifyThreadAccess();
  }
  
  public static interface Host extends ThreadBound {
    @Nullable
    Descriptor<?> getDescriptor(@Nullable Object param1Object);
    
    void onAttributeModified(Object param1Object, String param1String1, String param1String2);
    
    void onAttributeRemoved(Object param1Object, String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\elements\Descriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */