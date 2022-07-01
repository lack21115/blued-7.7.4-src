package org.chromium.base;

public class FieldTrialList {
  private static native String nativeFindFullName(String paramString);
  
  private static native String nativeGetVariationParameter(String paramString1, String paramString2);
  
  private static native boolean nativeTrialExists(String paramString);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\FieldTrialList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */