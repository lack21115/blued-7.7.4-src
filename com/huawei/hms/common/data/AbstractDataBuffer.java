package com.huawei.hms.common.data;

import android.os.Bundle;
import com.huawei.hms.support.api.client.Result;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T> extends Result implements DataBuffer<T> {
  protected final DataHolder mDataHolder;
  
  protected AbstractDataBuffer(DataHolder paramDataHolder) {
    this.mDataHolder = paramDataHolder;
  }
  
  @Deprecated
  public final void close() {
    release();
  }
  
  public abstract T get(int paramInt);
  
  public int getCount() {
    DataHolder dataHolder = this.mDataHolder;
    return (dataHolder == null) ? 0 : dataHolder.getCount();
  }
  
  public Bundle getMetadata() {
    return this.mDataHolder.getMetadata();
  }
  
  @Deprecated
  public boolean isClosed() {
    DataHolder dataHolder = this.mDataHolder;
    return (dataHolder == null) ? true : dataHolder.isClosed();
  }
  
  public Iterator<T> iterator() {
    return new DBInnerIter<T>(this);
  }
  
  public void release() {
    DataHolder dataHolder = this.mDataHolder;
    if (dataHolder != null)
      dataHolder.close(); 
  }
  
  public Iterator<T> singleRefIterator() {
    return new SingleRefDBInnerIter<T>(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\data\AbstractDataBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */