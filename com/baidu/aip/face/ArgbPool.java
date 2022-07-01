package com.baidu.aip.face;

import androidx.core.util.Pools;

public class ArgbPool {
  Pools.SynchronizedPool<int[]> pool = new Pools.SynchronizedPool(5);
  
  public int[] acquire(int paramInt1, int paramInt2) {
    int[] arrayOfInt = (int[])this.pool.acquire();
    if (arrayOfInt != null) {
      int[] arrayOfInt1 = arrayOfInt;
      return (arrayOfInt.length != paramInt1 * paramInt2) ? new int[paramInt1 * paramInt2] : arrayOfInt1;
    } 
    return new int[paramInt1 * paramInt2];
  }
  
  public void release(int[] paramArrayOfint) {
    try {
      this.pool.release(paramArrayOfint);
      return;
    } catch (IllegalStateException illegalStateException) {
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\aip\face\ArgbPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */