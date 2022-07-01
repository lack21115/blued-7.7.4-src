package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.Preconditions;
import java.util.NoSuchElementException;

public class SingleRefDataBufferIterator<T> extends DataBufferIterator<T> {
  private T zac;
  
  public SingleRefDataBufferIterator(DataBuffer<T> paramDataBuffer) {
    super(paramDataBuffer);
  }
  
  public T next() {
    if (hasNext()) {
      this.zab++;
      if (this.zab == 0) {
        this.zac = (T)Preconditions.checkNotNull(this.zaa.get(0));
        T t = this.zac;
        if (!(t instanceof DataBufferRef)) {
          String str = String.valueOf(t.getClass());
          StringBuilder stringBuilder1 = new StringBuilder(String.valueOf(str).length() + 44);
          stringBuilder1.append("DataBuffer reference of type ");
          stringBuilder1.append(str);
          stringBuilder1.append(" is not movable");
          throw new IllegalStateException(stringBuilder1.toString());
        } 
      } else {
        ((DataBufferRef)Preconditions.checkNotNull(this.zac)).zaa(this.zab);
      } 
      return this.zac;
    } 
    int i = this.zab;
    StringBuilder stringBuilder = new StringBuilder(46);
    stringBuilder.append("Cannot advance the iterator beyond ");
    stringBuilder.append(i);
    throw new NoSuchElementException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\data\SingleRefDataBufferIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */