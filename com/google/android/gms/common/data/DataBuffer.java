package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.api.Releasable;
import java.io.Closeable;
import java.util.Iterator;

public interface DataBuffer<T> extends Releasable, Closeable, Iterable<T> {
  void close();
  
  T get(int paramInt);
  
  int getCount();
  
  Bundle getMetadata();
  
  @Deprecated
  boolean isClosed();
  
  Iterator<T> iterator();
  
  void release();
  
  Iterator<T> singleRefIterator();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\data\DataBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */