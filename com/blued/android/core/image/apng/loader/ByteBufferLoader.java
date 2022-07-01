package com.blued.android.core.image.apng.loader;

import com.blued.android.core.image.apng.io.ByteBufferReader;
import com.blued.android.core.image.apng.io.Reader;
import java.nio.ByteBuffer;

public abstract class ByteBufferLoader {
  public abstract ByteBuffer a();
  
  public Reader b() {
    return (Reader)new ByteBufferReader(a());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\apng\loader\ByteBufferLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */