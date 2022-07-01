package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.os.CancellationSignal;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@Deprecated
public final class FingerprintManagerCompat {
  private final Context a;
  
  private FingerprintManagerCompat(Context paramContext) {
    this.a = paramContext;
  }
  
  private static FingerprintManager.AuthenticationCallback a(AuthenticationCallback paramAuthenticationCallback) {
    return new FingerprintManager.AuthenticationCallback(paramAuthenticationCallback) {
        public void onAuthenticationError(int param1Int, CharSequence param1CharSequence) {
          this.a.onAuthenticationError(param1Int, param1CharSequence);
        }
        
        public void onAuthenticationFailed() {
          this.a.onAuthenticationFailed();
        }
        
        public void onAuthenticationHelp(int param1Int, CharSequence param1CharSequence) {
          this.a.onAuthenticationHelp(param1Int, param1CharSequence);
        }
        
        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult param1AuthenticationResult) {
          this.a.onAuthenticationSucceeded(new FingerprintManagerCompat.AuthenticationResult(FingerprintManagerCompat.a(param1AuthenticationResult.getCryptoObject())));
        }
      };
  }
  
  private static FingerprintManager.CryptoObject a(CryptoObject paramCryptoObject) {
    FingerprintManager.CryptoObject cryptoObject = null;
    if (paramCryptoObject == null)
      return null; 
    if (paramCryptoObject.getCipher() != null)
      return new FingerprintManager.CryptoObject(paramCryptoObject.getCipher()); 
    if (paramCryptoObject.getSignature() != null)
      return new FingerprintManager.CryptoObject(paramCryptoObject.getSignature()); 
    if (paramCryptoObject.getMac() != null)
      cryptoObject = new FingerprintManager.CryptoObject(paramCryptoObject.getMac()); 
    return cryptoObject;
  }
  
  private static FingerprintManager a(Context paramContext) {
    return (Build.VERSION.SDK_INT == 23) ? (FingerprintManager)paramContext.getSystemService(FingerprintManager.class) : ((Build.VERSION.SDK_INT > 23 && paramContext.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) ? (FingerprintManager)paramContext.getSystemService(FingerprintManager.class) : null);
  }
  
  static CryptoObject a(FingerprintManager.CryptoObject paramCryptoObject) {
    CryptoObject cryptoObject = null;
    if (paramCryptoObject == null)
      return null; 
    if (paramCryptoObject.getCipher() != null)
      return new CryptoObject(paramCryptoObject.getCipher()); 
    if (paramCryptoObject.getSignature() != null)
      return new CryptoObject(paramCryptoObject.getSignature()); 
    if (paramCryptoObject.getMac() != null)
      cryptoObject = new CryptoObject(paramCryptoObject.getMac()); 
    return cryptoObject;
  }
  
  public static FingerprintManagerCompat from(Context paramContext) {
    return new FingerprintManagerCompat(paramContext);
  }
  
  public void authenticate(CryptoObject paramCryptoObject, int paramInt, CancellationSignal paramCancellationSignal, AuthenticationCallback paramAuthenticationCallback, Handler paramHandler) {
    if (Build.VERSION.SDK_INT >= 23) {
      FingerprintManager fingerprintManager = a(this.a);
      if (fingerprintManager != null) {
        if (paramCancellationSignal != null) {
          CancellationSignal cancellationSignal = (CancellationSignal)paramCancellationSignal.getCancellationSignalObject();
        } else {
          paramCancellationSignal = null;
        } 
        fingerprintManager.authenticate(a(paramCryptoObject), (CancellationSignal)paramCancellationSignal, paramInt, a(paramAuthenticationCallback), paramHandler);
      } 
    } 
  }
  
  public boolean hasEnrolledFingerprints() {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i >= 23) {
      FingerprintManager fingerprintManager = a(this.a);
      bool1 = bool2;
      if (fingerprintManager != null) {
        bool1 = bool2;
        if (fingerprintManager.hasEnrolledFingerprints())
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public boolean isHardwareDetected() {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i >= 23) {
      FingerprintManager fingerprintManager = a(this.a);
      bool1 = bool2;
      if (fingerprintManager != null) {
        bool1 = bool2;
        if (fingerprintManager.isHardwareDetected())
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public static abstract class AuthenticationCallback {
    public void onAuthenticationError(int param1Int, CharSequence param1CharSequence) {}
    
    public void onAuthenticationFailed() {}
    
    public void onAuthenticationHelp(int param1Int, CharSequence param1CharSequence) {}
    
    public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult param1AuthenticationResult) {}
  }
  
  public static final class AuthenticationResult {
    private final FingerprintManagerCompat.CryptoObject a;
    
    public AuthenticationResult(FingerprintManagerCompat.CryptoObject param1CryptoObject) {
      this.a = param1CryptoObject;
    }
    
    public FingerprintManagerCompat.CryptoObject getCryptoObject() {
      return this.a;
    }
  }
  
  public static class CryptoObject {
    private final Signature a;
    
    private final Cipher b;
    
    private final Mac c;
    
    public CryptoObject(Signature param1Signature) {
      this.a = param1Signature;
      this.b = null;
      this.c = null;
    }
    
    public CryptoObject(Cipher param1Cipher) {
      this.b = param1Cipher;
      this.a = null;
      this.c = null;
    }
    
    public CryptoObject(Mac param1Mac) {
      this.c = param1Mac;
      this.b = null;
      this.a = null;
    }
    
    public Cipher getCipher() {
      return this.b;
    }
    
    public Mac getMac() {
      return this.c;
    }
    
    public Signature getSignature() {
      return this.a;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\hardware\fingerprint\FingerprintManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */