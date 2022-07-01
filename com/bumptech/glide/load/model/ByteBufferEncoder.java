package com.bumptech.glide.load.model;

import android.util.Log;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferEncoder implements Encoder<ByteBuffer> {
  public boolean a(ByteBuffer paramByteBuffer, File paramFile, Options paramOptions) {
    try {
      ByteBufferUtil.a(paramByteBuffer, paramFile);
      return true;
    } catch (IOException iOException) {
      if (Log.isLoggable("ByteBufferEncoder", 3))
        Log.d("ByteBufferEncoder", "Failed to write data", iOException); 
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\model\ByteBufferEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */