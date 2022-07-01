package org.chromium.android_webview;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.chromium.base.Callback;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;

public final class AwTokenBindingManager {
  @CalledByNative
  private static void onDeletionComplete(Callback paramCallback) {
    paramCallback.onResult(Boolean.valueOf(true));
  }
  
  @CalledByNative
  private static void onKeyReady(Callback paramCallback, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    NoSuchAlgorithmException noSuchAlgorithmException2 = null;
    if (paramArrayOfbyte1 == null || paramArrayOfbyte2 == null) {
      paramCallback.onResult(null);
      return;
    } 
    try {
      KeyFactory keyFactory = KeyFactory.getInstance("EC");
      PrivateKey privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(paramArrayOfbyte1));
      KeyPair keyPair = new KeyPair(keyFactory.generatePublic(new X509EncodedKeySpec(paramArrayOfbyte2)), privateKey);
    } catch (NoSuchAlgorithmException|java.security.spec.InvalidKeySpecException noSuchAlgorithmException1) {
      Log.e("TokenBindingManager", "Failed converting key ", new Object[] { noSuchAlgorithmException1 });
      noSuchAlgorithmException1 = noSuchAlgorithmException2;
    } 
    paramCallback.onResult(noSuchAlgorithmException1);
  }
  
  public final native void nativeDeleteAllTokenBindingKeys(Callback paramCallback);
  
  public final native void nativeDeleteTokenBindingKey(String paramString, Callback paramCallback);
  
  public final native void nativeEnableTokenBinding();
  
  public final native void nativeGetTokenBindingKey(String paramString, Callback paramCallback);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwTokenBindingManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */