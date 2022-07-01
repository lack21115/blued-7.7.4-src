package org.chromium.android_webview;

import org.chromium.base.annotations.CalledByNative;
import org.chromium.components.variations.firstrun.VariationsSeedFetcher;

public class AwVariationsSeedBridge {
  private static VariationsSeedFetcher.SeedInfo sSeed;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  @CalledByNative
  private static void clearSeed() {
    sSeed = null;
  }
  
  @CalledByNative
  private static String getCountry() {
    return sSeed.country;
  }
  
  @CalledByNative
  private static byte[] getData() {
    return sSeed.seedData;
  }
  
  @CalledByNative
  private static String getDate() {
    return sSeed.date;
  }
  
  @CalledByNative
  private static boolean getIsGzipCompressed() {
    return sSeed.isGzipCompressed;
  }
  
  @CalledByNative
  private static String getSignature() {
    return sSeed.signature;
  }
  
  @CalledByNative
  private static boolean haveSeed() {
    return (sSeed != null);
  }
  
  public static void setSeed(VariationsSeedFetcher.SeedInfo paramSeedInfo) {
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwVariationsSeedBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */