package com.huawei.hms.common.data;

public interface DataBufferObserver {
  void onDataChanged();
  
  void onDataRangeChanged(int paramInt1, int paramInt2);
  
  void onDataRangeInserted(int paramInt1, int paramInt2);
  
  void onDataRangeMoved(int paramInt1, int paramInt2, int paramInt3);
  
  void onDataRangeRemoved(int paramInt1, int paramInt2);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\data\DataBufferObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */