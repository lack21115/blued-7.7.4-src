package org.chromium.android_webview.services;

import android.os.ParcelFileDescriptor;

final class VariationsSeedServer$1 extends IVariationsSeedServer$Stub {
  public final void getSeed(ParcelFileDescriptor paramParcelFileDescriptor, long paramLong) {
    VariationsSeedHolder variationsSeedHolder = VariationsSeedServer.access$000(VariationsSeedServer.this);
    variationsSeedHolder.mSeedHandler.post(new VariationsSeedHolder$SeedWriter(variationsSeedHolder, paramParcelFileDescriptor, paramLong));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\services\VariationsSeedServer$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */