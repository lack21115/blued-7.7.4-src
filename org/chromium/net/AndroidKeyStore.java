package org.chromium.net;

import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;

public class AndroidKeyStore {
  @CalledByNative
  private static Object getOpenSSLEngineForPrivateKey(PrivateKey paramPrivateKey) {
    try {
      Class<?> clazz = Class.forName("org.apache.harmony.xnet.provider.jsse.OpenSSLEngine");
      Object object = getOpenSSLKeyForPrivateKey(paramPrivateKey);
      if (object == null)
        return null; 
      try {
        Method method = object.getClass().getDeclaredMethod("getEngine", new Class[0]);
        try {
          StringBuilder stringBuilder;
          method.setAccessible(true);
          try {
            object = method.invoke(object, new Object[0]);
            method.setAccessible(false);
            if (object == null)
              Log.e("AndroidKeyStore", "getEngine() returned null", new Object[0]); 
          } finally {
            stringBuilder.setAccessible(false);
          } 
        } catch (Exception exception) {
          StringBuilder stringBuilder = new StringBuilder("Exception while trying to retrieve OpenSSLEngine object: ");
          stringBuilder.append(exception);
          Log.e("AndroidKeyStore", stringBuilder.toString(), new Object[0]);
          return null;
        } 
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder("No getEngine() method on OpenSSLKey member:");
        stringBuilder.append(exception);
        Log.e("AndroidKeyStore", stringBuilder.toString(), new Object[0]);
        return null;
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("Cannot find system OpenSSLEngine class: ");
      stringBuilder.append(exception);
      Log.e("AndroidKeyStore", stringBuilder.toString(), new Object[0]);
      return null;
    } 
  }
  
  @CalledByNative
  private static long getOpenSSLHandleForPrivateKey(PrivateKey paramPrivateKey) {
    Object object = getOpenSSLKeyForPrivateKey(paramPrivateKey);
    if (object == null)
      return 0L; 
    try {
      Method method = object.getClass().getDeclaredMethod("getPkeyContext", new Class[0]);
      try {
        method.setAccessible(true);
        try {
          long l = ((Number)method.invoke(object, new Object[0])).longValue();
          method.setAccessible(false);
        } finally {
          method.setAccessible(false);
        } 
      } catch (Exception exception) {
        object = new StringBuilder("Exception while trying to retrieve system EVP_PKEY handle: ");
        object.append(exception);
        Log.e("AndroidKeyStore", object.toString(), new Object[0]);
        return 0L;
      } 
    } catch (Exception exception) {
      object = new StringBuilder("No getPkeyContext() method on OpenSSLKey member:");
      object.append(exception);
      Log.e("AndroidKeyStore", object.toString(), new Object[0]);
      return 0L;
    } 
  }
  
  private static Object getOpenSSLKeyForPrivateKey(PrivateKey paramPrivateKey) {
    if (paramPrivateKey == null) {
      Log.e("AndroidKeyStore", "privateKey == null", new Object[0]);
      return null;
    } 
    if (!(paramPrivateKey instanceof java.security.interfaces.RSAPrivateKey)) {
      Log.e("AndroidKeyStore", "does not implement RSAPrivateKey", new Object[0]);
      return null;
    } 
    try {
      StringBuilder stringBuilder;
      Class<?> clazz = Class.forName("org.apache.harmony.xnet.provider.jsse.OpenSSLRSAPrivateKey");
      if (!clazz.isInstance(paramPrivateKey)) {
        stringBuilder = new StringBuilder("Private key is not an OpenSSLRSAPrivateKey instance, its class name is:");
        stringBuilder.append(paramPrivateKey.getClass().getCanonicalName());
        Log.e("AndroidKeyStore", stringBuilder.toString(), new Object[0]);
        return null;
      } 
      try {
        Method method = stringBuilder.getDeclaredMethod("getOpenSSLKey", new Class[0]);
        method.setAccessible(true);
        try {
          object = method.invoke(paramPrivateKey, new Object[0]);
          method.setAccessible(false);
        } finally {
          method.setAccessible(false);
        } 
      } catch (Exception null) {
        stringBuilder = new StringBuilder("Exception while trying to retrieve system EVP_PKEY handle: ");
        stringBuilder.append(object);
        Log.e("AndroidKeyStore", stringBuilder.toString(), new Object[0]);
        return null;
      } 
    } catch (Exception object) {
      StringBuilder stringBuilder = new StringBuilder("Cannot find system OpenSSLRSAPrivateKey class: ");
      stringBuilder.append(object);
      Log.e("AndroidKeyStore", stringBuilder.toString(), new Object[0]);
      return null;
    } 
    return object;
  }
  
  @CalledByNative
  private static byte[] signWithPrivateKey(PrivateKey paramPrivateKey, String paramString, byte[] paramArrayOfbyte) {
    try {
      Signature signature = Signature.getInstance(paramString);
      try {
        signature.initSign(paramPrivateKey);
        signature.update(paramArrayOfbyte);
        return signature.sign();
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder("Exception while signing message with ");
        stringBuilder.append(paramString);
        stringBuilder.append(" and ");
        stringBuilder.append(paramPrivateKey.getAlgorithm());
        stringBuilder.append(" private key (");
        stringBuilder.append(paramPrivateKey.getClass().getName());
        stringBuilder.append("): ");
        stringBuilder.append(exception);
        Log.e("AndroidKeyStore", stringBuilder.toString(), new Object[0]);
        return null;
      } 
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      StringBuilder stringBuilder = new StringBuilder("Signature algorithm ");
      stringBuilder.append(paramString);
      stringBuilder.append(" not supported: ");
      stringBuilder.append(noSuchAlgorithmException);
      Log.e("AndroidKeyStore", stringBuilder.toString(), new Object[0]);
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\AndroidKeyStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */