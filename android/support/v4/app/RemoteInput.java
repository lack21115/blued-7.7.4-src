package android.support.v4.app;

import android.os.Bundle;
import java.util.Set;

public final class RemoteInput extends RemoteInputCompatBase$RemoteInput {
  final boolean mAllowFreeFormTextInput;
  
  final Set mAllowedDataTypes;
  
  final CharSequence[] mChoices;
  
  final Bundle mExtras;
  
  final CharSequence mLabel;
  
  final String mResultKey;
  
  static android.app.RemoteInput[] fromCompat(RemoteInput[] paramArrayOfRemoteInput) {
    if (paramArrayOfRemoteInput == null)
      return null; 
    android.app.RemoteInput[] arrayOfRemoteInput = new android.app.RemoteInput[paramArrayOfRemoteInput.length];
    for (int i = 0; i < paramArrayOfRemoteInput.length; i++) {
      RemoteInput remoteInput = paramArrayOfRemoteInput[i];
      arrayOfRemoteInput[i] = (new android.app.RemoteInput.Builder(remoteInput.mResultKey)).setLabel(remoteInput.mLabel).setChoices(remoteInput.mChoices).setAllowFreeFormInput(remoteInput.mAllowFreeFormTextInput).addExtras(remoteInput.mExtras).build();
    } 
    return arrayOfRemoteInput;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\RemoteInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */