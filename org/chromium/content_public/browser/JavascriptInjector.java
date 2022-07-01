package org.chromium.content_public.browser;

import java.util.Map;

public interface JavascriptInjector {
  void addPossiblyUnsafeInterface(Object paramObject, String paramString, Class paramClass);
  
  Map getInterfaces();
  
  void removeInterface(String paramString);
  
  void setAllowInspection(boolean paramBoolean);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content_public\browser\JavascriptInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */