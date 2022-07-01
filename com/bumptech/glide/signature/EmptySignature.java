package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

public final class EmptySignature implements Key {
  private static final EmptySignature b = new EmptySignature();
  
  public static EmptySignature a() {
    return b;
  }
  
  public void a(MessageDigest paramMessageDigest) {}
  
  public String toString() {
    return "EmptySignature";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\signature\EmptySignature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */