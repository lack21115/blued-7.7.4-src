package com.huawei.hms.common.data;

import com.huawei.hms.common.internal.Preconditions;
import java.util.Iterator;

public class DBInnerIter<O> implements Iterator<O> {
  protected final DataBuffer<O> dataBuffer;
  
  protected int index = -1;
  
  public DBInnerIter(DataBuffer<O> paramDataBuffer) {
    Preconditions.checkNotNull(paramDataBuffer, "dataBuffer cannot be null");
    this.dataBuffer = paramDataBuffer;
  }
  
  public boolean hasNext() {
    return (this.index + 1 < this.dataBuffer.getCount());
  }
  
  public O next() {
    if (hasNext()) {
      DataBuffer<O> dataBuffer = this.dataBuffer;
      int i = this.index + 1;
      this.index = i;
      return dataBuffer.get(i);
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\data\DBInnerIter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */