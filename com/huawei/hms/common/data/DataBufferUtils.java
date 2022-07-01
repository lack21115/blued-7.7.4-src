package com.huawei.hms.common.data;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

public final class DataBufferUtils {
  public static final int ARGS_BUNDLE = 4;
  
  public static final int ARGS_COLUMN = 1;
  
  public static final int ARGS_CURSOR = 2;
  
  public static final int ARGS_STATUS = 3;
  
  public static final int ARGS_VERSION = 1000;
  
  public static final String NEXT_PAGE = "next_page";
  
  public static final String PREV_PAGE = "prev_page";
  
  private static boolean containKey(Bundle paramBundle, String paramString) {
    boolean bool = false;
    if (paramBundle == null)
      return false; 
    if (paramBundle.getString(paramString) != null)
      bool = true; 
    return bool;
  }
  
  public static <T, E extends Freezable<T>> ArrayList<T> freezeAndClose(DataBuffer<E> paramDataBuffer) {
    ArrayList<T> arrayList = new ArrayList(paramDataBuffer.getCount());
    Iterator<E> iterator = paramDataBuffer.iterator();
    while (iterator.hasNext())
      arrayList.add(((Freezable)iterator.next()).freeze()); 
    paramDataBuffer.release();
    return arrayList;
  }
  
  public static boolean hasData(DataBuffer<?> paramDataBuffer) {
    boolean bool = false;
    if (paramDataBuffer == null)
      return false; 
    if (paramDataBuffer.getCount() > 0)
      bool = true; 
    return bool;
  }
  
  public static boolean hasNextPage(DataBuffer<?> paramDataBuffer) {
    return containKey(paramDataBuffer.getMetadata(), "next_page");
  }
  
  public static boolean hasPrevPage(DataBuffer<?> paramDataBuffer) {
    return containKey(paramDataBuffer.getMetadata(), "prev_page");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\data\DataBufferUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */