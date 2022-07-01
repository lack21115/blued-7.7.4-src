package com.huawei.hms.common.data;

import com.huawei.hms.common.internal.Preconditions;

public class SingleRefDBInnerIter<T> extends DBInnerIter<T> {
  public SingleRefDBInnerIter(DataBuffer<T> paramDataBuffer) {
    super(paramDataBuffer);
  }
  
  public T next() {
    if (!hasNext())
      return null; 
    int i = this.index + 1;
    this.index = i;
    if (i == 0) {
      boolean bool = this.dataBuffer.get(0) instanceof DataBufferRef;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("DataBuffer reference of type ");
      stringBuilder.append(this.dataBuffer.get(0).getClass());
      stringBuilder.append(" is not movable");
      Preconditions.checkState(bool, stringBuilder.toString());
      ((DataBufferRef)this.dataBuffer.get(0)).getWindowIndex(this.index);
    } 
    return this.dataBuffer.get(0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\data\SingleRefDBInnerIter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */