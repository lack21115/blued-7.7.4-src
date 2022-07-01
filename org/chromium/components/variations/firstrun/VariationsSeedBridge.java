package org.chromium.components.variations.firstrun;

import android.util.Base64;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;

public class VariationsSeedBridge {
  @CalledByNative
  private static void clearFirstRunPrefs() {
    ContextUtils.Holder.access$100().edit().remove("variations_seed_base64").remove("variations_seed_signature").remove("variations_seed_country").remove("variations_seed_date").remove("variations_seed_is_gzip_compressed").apply();
  }
  
  @CalledByNative
  private static String getVariationsFirstRunSeedCountry() {
    return getVariationsFirstRunSeedPref("variations_seed_country");
  }
  
  @CalledByNative
  private static byte[] getVariationsFirstRunSeedData() {
    return Base64.decode(getVariationsFirstRunSeedPref("variations_seed_base64"), 2);
  }
  
  @CalledByNative
  private static String getVariationsFirstRunSeedDate() {
    return getVariationsFirstRunSeedPref("variations_seed_date");
  }
  
  @CalledByNative
  private static boolean getVariationsFirstRunSeedIsGzipCompressed() {
    return ContextUtils.Holder.access$100().getBoolean("variations_seed_is_gzip_compressed", false);
  }
  
  private static String getVariationsFirstRunSeedPref(String paramString) {
    return ContextUtils.Holder.access$100().getString(paramString, "");
  }
  
  @CalledByNative
  private static String getVariationsFirstRunSeedSignature() {
    return getVariationsFirstRunSeedPref("variations_seed_signature");
  }
  
  @CalledByNative
  private static void markVariationsSeedAsStored() {
    ContextUtils.Holder.access$100().edit().putBoolean("variations_seed_native_stored", true).apply();
  }
  
  @CalledByNative
  public static void setVariationsFirstRunSeed(byte[] paramArrayOfbyte, String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    ContextUtils.Holder.access$100().edit().putString("variations_seed_base64", Base64.encodeToString(paramArrayOfbyte, 2)).putString("variations_seed_signature", paramString1).putString("variations_seed_country", paramString2).putString("variations_seed_date", paramString3).putBoolean("variations_seed_is_gzip_compressed", paramBoolean).apply();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\variations\firstrun\VariationsSeedBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */