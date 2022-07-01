package org.chromium.content_public.common;

import org.chromium.base.annotations.CalledByNative;

public final class ResourceRequestBody {
  private byte[] mEncodedNativeForm;
  
  private ResourceRequestBody(byte[] paramArrayOfbyte) {
    this.mEncodedNativeForm = paramArrayOfbyte;
  }
  
  public static ResourceRequestBody createFromBytes(byte[] paramArrayOfbyte) {
    return createFromEncodedNativeForm(nativeCreateResourceRequestBodyFromBytes(paramArrayOfbyte));
  }
  
  @CalledByNative
  private static ResourceRequestBody createFromEncodedNativeForm(byte[] paramArrayOfbyte) {
    return new ResourceRequestBody(paramArrayOfbyte);
  }
  
  @CalledByNative
  private byte[] getEncodedNativeForm() {
    return this.mEncodedNativeForm;
  }
  
  private static native byte[] nativeCreateResourceRequestBodyFromBytes(byte[] paramArrayOfbyte);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content_public\common\ResourceRequestBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */