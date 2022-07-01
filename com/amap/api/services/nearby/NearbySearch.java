package com.amap.api.services.nearby;

import android.content.Context;
import com.amap.api.col.s.bb;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.INearbySearch;

public class NearbySearch {
  public static final int AMAP = 1;
  
  public static final int GPS = 0;
  
  private static NearbySearch a;
  
  private INearbySearch b;
  
  private NearbySearch(Context paramContext) {
    if (this.b == null)
      try {
        this.b = (INearbySearch)new bb(paramContext);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public static void destroy() {
    // Byte code:
    //   0: ldc com/amap/api/services/nearby/NearbySearch
    //   2: monitorenter
    //   3: getstatic com/amap/api/services/nearby/NearbySearch.a : Lcom/amap/api/services/nearby/NearbySearch;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull -> 48
    //   11: getstatic com/amap/api/services/nearby/NearbySearch.a : Lcom/amap/api/services/nearby/NearbySearch;
    //   14: astore_0
    //   15: aload_0
    //   16: getfield b : Lcom/amap/api/services/interfaces/INearbySearch;
    //   19: ifnull -> 31
    //   22: aload_0
    //   23: getfield b : Lcom/amap/api/services/interfaces/INearbySearch;
    //   26: invokeinterface destroy : ()V
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield b : Lcom/amap/api/services/interfaces/INearbySearch;
    //   36: goto -> 48
    //   39: astore_0
    //   40: aload_0
    //   41: ldc 'NearbySearch'
    //   43: ldc 'destryoy'
    //   45: invokestatic a : (Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   48: aconst_null
    //   49: putstatic com/amap/api/services/nearby/NearbySearch.a : Lcom/amap/api/services/nearby/NearbySearch;
    //   52: ldc com/amap/api/services/nearby/NearbySearch
    //   54: monitorexit
    //   55: return
    //   56: astore_0
    //   57: ldc com/amap/api/services/nearby/NearbySearch
    //   59: monitorexit
    //   60: aload_0
    //   61: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	56	finally
    //   11	31	39	finally
    //   31	36	39	finally
    //   40	48	56	finally
    //   48	52	56	finally
  }
  
  public static NearbySearch getInstance(Context paramContext) {
    // Byte code:
    //   0: ldc com/amap/api/services/nearby/NearbySearch
    //   2: monitorenter
    //   3: getstatic com/amap/api/services/nearby/NearbySearch.a : Lcom/amap/api/services/nearby/NearbySearch;
    //   6: ifnonnull -> 20
    //   9: new com/amap/api/services/nearby/NearbySearch
    //   12: dup
    //   13: aload_0
    //   14: invokespecial <init> : (Landroid/content/Context;)V
    //   17: putstatic com/amap/api/services/nearby/NearbySearch.a : Lcom/amap/api/services/nearby/NearbySearch;
    //   20: getstatic com/amap/api/services/nearby/NearbySearch.a : Lcom/amap/api/services/nearby/NearbySearch;
    //   23: astore_0
    //   24: ldc com/amap/api/services/nearby/NearbySearch
    //   26: monitorexit
    //   27: aload_0
    //   28: areturn
    //   29: astore_0
    //   30: ldc com/amap/api/services/nearby/NearbySearch
    //   32: monitorexit
    //   33: aload_0
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   3	20	29	finally
    //   20	24	29	finally
  }
  
  public void addNearbyListener(NearbyListener paramNearbyListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Lcom/amap/api/services/interfaces/INearbySearch;
    //   6: ifnull -> 19
    //   9: aload_0
    //   10: getfield b : Lcom/amap/api/services/interfaces/INearbySearch;
    //   13: aload_1
    //   14: invokeinterface addNearbyListener : (Lcom/amap/api/services/nearby/NearbySearch$NearbyListener;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	22	finally
  }
  
  public void clearUserInfoAsyn() {
    INearbySearch iNearbySearch = this.b;
    if (iNearbySearch != null)
      iNearbySearch.clearUserInfoAsyn(); 
  }
  
  public void removeNearbyListener(NearbyListener paramNearbyListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Lcom/amap/api/services/interfaces/INearbySearch;
    //   6: ifnull -> 19
    //   9: aload_0
    //   10: getfield b : Lcom/amap/api/services/interfaces/INearbySearch;
    //   13: aload_1
    //   14: invokeinterface removeNearbyListener : (Lcom/amap/api/services/nearby/NearbySearch$NearbyListener;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: astore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	22	finally
  }
  
  public NearbySearchResult searchNearbyInfo(NearbyQuery paramNearbyQuery) throws AMapException {
    INearbySearch iNearbySearch = this.b;
    return (iNearbySearch != null) ? iNearbySearch.searchNearbyInfo(paramNearbyQuery) : null;
  }
  
  public void searchNearbyInfoAsyn(NearbyQuery paramNearbyQuery) {
    INearbySearch iNearbySearch = this.b;
    if (iNearbySearch != null)
      iNearbySearch.searchNearbyInfoAsyn(paramNearbyQuery); 
  }
  
  public void setUserID(String paramString) {
    INearbySearch iNearbySearch = this.b;
    if (iNearbySearch != null)
      iNearbySearch.setUserID(paramString); 
  }
  
  public void startUploadNearbyInfoAuto(UploadInfoCallback paramUploadInfoCallback, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Lcom/amap/api/services/interfaces/INearbySearch;
    //   6: ifnull -> 20
    //   9: aload_0
    //   10: getfield b : Lcom/amap/api/services/interfaces/INearbySearch;
    //   13: aload_1
    //   14: iload_2
    //   15: invokeinterface startUploadNearbyInfoAuto : (Lcom/amap/api/services/nearby/UploadInfoCallback;I)V
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	23	finally
  }
  
  public void stopUploadNearbyInfoAuto() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield b : Lcom/amap/api/services/interfaces/INearbySearch;
    //   6: ifnull -> 18
    //   9: aload_0
    //   10: getfield b : Lcom/amap/api/services/interfaces/INearbySearch;
    //   13: invokeinterface stopUploadNearbyInfoAuto : ()V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: athrow
    // Exception table:
    //   from	to	target	type
    //   2	18	21	finally
  }
  
  public void uploadNearbyInfoAsyn(UploadInfo paramUploadInfo) {
    INearbySearch iNearbySearch = this.b;
    if (iNearbySearch != null)
      iNearbySearch.uploadNearbyInfoAsyn(paramUploadInfo); 
  }
  
  public static interface NearbyListener {
    void onNearbyInfoSearched(NearbySearchResult param1NearbySearchResult, int param1Int);
    
    void onNearbyInfoUploaded(int param1Int);
    
    void onUserInfoCleared(int param1Int);
  }
  
  public static class NearbyQuery {
    private LatLonPoint a;
    
    private NearbySearchFunctionType b = NearbySearchFunctionType.DISTANCE_SEARCH;
    
    private int c = 1000;
    
    private int d = 1800;
    
    private int e = 1;
    
    public LatLonPoint getCenterPoint() {
      return this.a;
    }
    
    public int getCoordType() {
      return this.e;
    }
    
    public int getRadius() {
      return this.c;
    }
    
    public int getTimeRange() {
      return this.d;
    }
    
    public int getType() {
      int i = NearbySearch.null.a[this.b.ordinal()];
      boolean bool = false;
      if (i != 1) {
        if (i != 2)
          return 0; 
        bool = true;
      } 
      return bool;
    }
    
    public void setCenterPoint(LatLonPoint param1LatLonPoint) {
      this.a = param1LatLonPoint;
    }
    
    public void setCoordType(int param1Int) {
      if (param1Int != 0 && param1Int != 1) {
        this.e = 1;
        return;
      } 
      this.e = param1Int;
    }
    
    public void setRadius(int param1Int) {
      int i = param1Int;
      if (param1Int > 10000)
        i = 10000; 
      this.c = i;
    }
    
    public void setTimeRange(int param1Int) {
      int i;
      if (param1Int < 5) {
        i = 5;
      } else {
        i = param1Int;
        if (param1Int > 86400)
          i = 86400; 
      } 
      this.d = i;
    }
    
    public void setType(NearbySearchFunctionType param1NearbySearchFunctionType) {
      this.b = param1NearbySearchFunctionType;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\nearby\NearbySearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */