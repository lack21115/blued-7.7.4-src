package com.google.firebase;

import com.google.android.gms.common.internal.Preconditions;

public class FirebaseException extends Exception {
  @Deprecated
  protected FirebaseException() {}
  
  public FirebaseException(String paramString) {
    super(Preconditions.checkNotEmpty(paramString, "Detail message must not be empty"));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\firebase\FirebaseException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */