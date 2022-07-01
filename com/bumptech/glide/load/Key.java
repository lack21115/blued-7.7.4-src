package com.bumptech.glide.load;

import java.nio.charset.Charset;
import java.security.MessageDigest;

public interface Key {
  public static final Charset a = Charset.forName("UTF-8");
  
  void a(MessageDigest paramMessageDigest);
  
  boolean equals(Object paramObject);
  
  int hashCode();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\Key.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */