package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DataBufferIterator<T> implements Iterator<T> {
  protected final DataBuffer<T> zaa;
  
  protected int zab;
  
  public DataBufferIterator(DataBuffer<T> paramDataBuffer) {
    this.zaa = (DataBuffer<T>)Preconditions.checkNotNull(paramDataBuffer);
    this.zab = -1;
  }
  
  public boolean hasNext() {
    return (this.zab < this.zaa.getCount() - 1);
  }
  
  public T next() {
    if (hasNext()) {
      DataBuffer<T> dataBuffer = this.zaa;
      int j = this.zab + 1;
      this.zab = j;
      return dataBuffer.get(j);
    } 
    int i = this.zab;
    StringBuilder stringBuilder = new StringBuilder(46);
    stringBuilder.append("Cannot advance the iterator beyond ");
    stringBuilder.append(i);
    throw new NoSuchElementException(stringBuilder.toString());
  }
  
  public void remove() {
    throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\data\DataBufferIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */