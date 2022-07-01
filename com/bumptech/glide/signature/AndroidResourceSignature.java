package com.bumptech.glide.signature;

import android.content.Context;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class AndroidResourceSignature implements Key {
  private final int b;
  
  private final Key c;
  
  private AndroidResourceSignature(int paramInt, Key paramKey) {
    this.b = paramInt;
    this.c = paramKey;
  }
  
  public static Key a(Context paramContext) {
    Key key = ApplicationVersionSignature.a(paramContext);
    return new AndroidResourceSignature((paramContext.getResources().getConfiguration()).uiMode & 0x30, key);
  }
  
  public void a(MessageDigest paramMessageDigest) {
    this.c.a(paramMessageDigest);
    paramMessageDigest.update(ByteBuffer.allocate(4).putInt(this.b).array());
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof AndroidResourceSignature;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      bool1 = bool2;
      if (this.b == ((AndroidResourceSignature)paramObject).b) {
        bool1 = bool2;
        if (this.c.equals(((AndroidResourceSignature)paramObject).c))
          bool1 = true; 
      } 
    } 
    return bool1;
  }
  
  public int hashCode() {
    return Util.a(this.c, this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\signature\AndroidResourceSignature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */