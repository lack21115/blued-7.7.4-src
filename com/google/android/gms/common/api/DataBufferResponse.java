package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataBuffer;
import java.util.Iterator;

public class DataBufferResponse<T, R extends AbstractDataBuffer<T> & Result> extends Response<R> implements DataBuffer<T> {
  public DataBufferResponse() {}
  
  public DataBufferResponse(R paramR) {
    super(paramR);
  }
  
  public void close() {
    ((AbstractDataBuffer)getResult()).close();
  }
  
  public T get(int paramInt) {
    return (T)((AbstractDataBuffer)getResult()).get(paramInt);
  }
  
  public int getCount() {
    return ((AbstractDataBuffer)getResult()).getCount();
  }
  
  public Bundle getMetadata() {
    return ((AbstractDataBuffer)getResult()).getMetadata();
  }
  
  public boolean isClosed() {
    return ((AbstractDataBuffer)getResult()).isClosed();
  }
  
  public Iterator<T> iterator() {
    return ((AbstractDataBuffer)getResult()).iterator();
  }
  
  public void release() {
    ((AbstractDataBuffer)getResult()).release();
  }
  
  public Iterator<T> singleRefIterator() {
    return ((AbstractDataBuffer)getResult()).singleRefIterator();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\DataBufferResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */