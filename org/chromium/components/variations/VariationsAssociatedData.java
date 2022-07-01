package org.chromium.components.variations;

public final class VariationsAssociatedData {
  private static native String nativeGetFeedbackVariations();
  
  private static native String nativeGetVariationParamValue(String paramString1, String paramString2);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\variations\VariationsAssociatedData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */