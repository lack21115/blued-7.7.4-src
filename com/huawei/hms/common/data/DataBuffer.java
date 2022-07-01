package com.huawei.hms.common.data;

import android.os.Bundle;
import com.huawei.hms.common.api.Releasable;
import java.util.Iterator;

public interface DataBuffer<T> extends Releasable, Iterable<T> {
  @Deprecated
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\data\DataBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */