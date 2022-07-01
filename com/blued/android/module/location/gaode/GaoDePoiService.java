package com.blued.android.module.location.gaode;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.blued.android.module.location.LocationService;
import com.blued.android.module.location.listener.OnPoiListener;
import com.blued.android.module.location.model.LocationPOIModel;
import com.blued.android.module.location.utils.AppUtils;
import com.blued.android.module.location.utils.LocationCacheUtils;
import java.util.ArrayList;

public class GaoDePoiService {
  private static volatile GaoDePoiService a;
  
  private GaoDePoiService() {
    if (AppUtils.e()) {
      ServiceSettings.getInstance().setLanguage("zh-CN");
      return;
    } 
    ServiceSettings.getInstance().setLanguage("en");
  }
  
  public static GaoDePoiService a() {
    // Byte code:
    //   0: getstatic com/blued/android/module/location/gaode/GaoDePoiService.a : Lcom/blued/android/module/location/gaode/GaoDePoiService;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/module/location/gaode/GaoDePoiService
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/location/gaode/GaoDePoiService.a : Lcom/blued/android/module/location/gaode/GaoDePoiService;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/module/location/gaode/GaoDePoiService
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/module/location/gaode/GaoDePoiService.a : Lcom/blued/android/module/location/gaode/GaoDePoiService;
    //   25: ldc com/blued/android/module/location/gaode/GaoDePoiService
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/module/location/gaode/GaoDePoiService
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/module/location/gaode/GaoDePoiService.a : Lcom/blued/android/module/location/gaode/GaoDePoiService;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(int paramInt, OnPoiListener paramOnPoiListener) {
    try {
      if (AppUtils.e()) {
        ServiceSettings.getInstance().setLanguage("zh-CN");
      } else {
        ServiceSettings.getInstance().setLanguage("en");
      } 
      PoiSearch.Query query = new PoiSearch.Query("", "", "");
      query.setPageSize(20);
      query.setPageNum(paramInt + 1);
      LatLonPoint latLonPoint = new LatLonPoint(Double.parseDouble(LocationService.b()), Double.parseDouble(LocationService.a()));
      PoiSearch poiSearch = new PoiSearch((Context)AppUtils.a(), query);
      poiSearch.setOnPoiSearchListener(new PoiSearch.OnPoiSearchListener(this, paramInt, paramOnPoiListener) {
            public void onPoiItemSearched(PoiItem param1PoiItem, int param1Int) {
              Log.d("高德POI", "onPoiItemSearched");
            }
            
            public void onPoiSearched(PoiResult param1PoiResult, int param1Int) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("onPoiSearched:code=");
              stringBuilder.append(param1Int);
              Log.d("高德POI", stringBuilder.toString());
              if (param1PoiResult != null && param1PoiResult.getPois() != null && param1PoiResult.getPois().size() > 0) {
                ArrayList<PoiItem> arrayList1 = param1PoiResult.getPois();
                ArrayList<LocationPOIModel> arrayList = new ArrayList(arrayList1.size());
                for (param1Int = 0; param1Int < arrayList1.size(); param1Int++) {
                  LocationPOIModel locationPOIModel = new LocationPOIModel();
                  locationPOIModel.name = ((PoiItem)arrayList1.get(param1Int)).getTitle();
                  locationPOIModel.address = ((PoiItem)arrayList1.get(param1Int)).getSnippet();
                  locationPOIModel.province = ((PoiItem)arrayList1.get(param1Int)).getProvinceName();
                  locationPOIModel.city = ((PoiItem)arrayList1.get(param1Int)).getCityName();
                  locationPOIModel.area = ((PoiItem)arrayList1.get(param1Int)).getAdName();
                  StringBuilder stringBuilder1 = new StringBuilder();
                  stringBuilder1.append(((PoiItem)arrayList1.get(param1Int)).getDistance());
                  stringBuilder1.append("");
                  locationPOIModel.distance = stringBuilder1.toString();
                  LatLonPoint latLonPoint = ((PoiItem)arrayList1.get(param1Int)).getLatLonPoint();
                  if (latLonPoint != null) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(latLonPoint.getLongitude());
                    stringBuilder2.append("");
                    locationPOIModel.longitude = stringBuilder2.toString();
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(latLonPoint.getLatitude());
                    stringBuilder2.append("");
                    locationPOIModel.latitude = stringBuilder2.toString();
                  } 
                  arrayList.add(locationPOIModel);
                } 
                if (this.a == 0) {
                  LocationPOIModel locationPOIModel = new LocationPOIModel();
                  locationPOIModel.name = LocationCacheUtils.a();
                  locationPOIModel.address = LocationCacheUtils.g();
                  locationPOIModel.province = LocationCacheUtils.b();
                  locationPOIModel.longitude = LocationCacheUtils.c();
                  locationPOIModel.latitude = LocationCacheUtils.d();
                  locationPOIModel.city = LocationCacheUtils.a();
                  locationPOIModel.area = LocationCacheUtils.g();
                  locationPOIModel.distance = "0";
                  arrayList.add(0, locationPOIModel);
                } 
                OnPoiListener onPoiListener = this.b;
                if (onPoiListener != null) {
                  param1Int = param1PoiResult.getPageCount();
                  int i = this.a;
                  boolean bool = true;
                  if (param1Int <= i + 1)
                    bool = false; 
                  onPoiListener.a(0, arrayList, bool);
                  return;
                } 
              } else if (this.b != null) {
                ArrayList<LocationPOIModel> arrayList = new ArrayList(4);
                if (this.a == 0 && param1Int == 1000) {
                  LocationPOIModel locationPOIModel = new LocationPOIModel();
                  locationPOIModel.name = LocationCacheUtils.a();
                  locationPOIModel.address = LocationCacheUtils.g();
                  locationPOIModel.province = LocationCacheUtils.b();
                  locationPOIModel.longitude = LocationCacheUtils.c();
                  locationPOIModel.latitude = LocationCacheUtils.d();
                  locationPOIModel.city = LocationCacheUtils.a();
                  locationPOIModel.area = LocationCacheUtils.g();
                  locationPOIModel.distance = "0";
                  arrayList.add(locationPOIModel);
                } 
                OnPoiListener onPoiListener = this.b;
                int i = param1Int;
                if (param1Int == 1000)
                  i = 0; 
                onPoiListener.a(i, arrayList, false);
              } 
            }
          });
      poiSearch.setBound(new PoiSearch.SearchBound(latLonPoint, 3000, true));
      poiSearch.searchPOIAsyn();
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("e=");
      stringBuilder.append(exception.getMessage());
      Log.d("高德POI", stringBuilder.toString());
      if (paramOnPoiListener != null)
        paramOnPoiListener.a(-1, null, false); 
      return;
    } 
  }
  
  public void a(int paramInt, String paramString, OnPoiListener paramOnPoiListener) {
    try {
      if (TextUtils.isEmpty(paramString) && paramOnPoiListener != null) {
        paramOnPoiListener.a(-2, null, false);
        return;
      } 
      if (AppUtils.a(paramString)) {
        ServiceSettings.getInstance().setLanguage("zh-CN");
      } else {
        ServiceSettings.getInstance().setLanguage("en");
      } 
      PoiSearch.Query query = new PoiSearch.Query(paramString, "", "");
      query.setPageSize(20);
      query.setPageNum(paramInt + 1);
      LatLonPoint latLonPoint = new LatLonPoint(Double.parseDouble(LocationService.b()), Double.parseDouble(LocationService.a()));
      PoiSearch poiSearch = new PoiSearch((Context)AppUtils.a(), query);
      poiSearch.setOnPoiSearchListener(new PoiSearch.OnPoiSearchListener(this, paramOnPoiListener, paramInt) {
            public void onPoiItemSearched(PoiItem param1PoiItem, int param1Int) {
              Log.d("高德POI", "onPoiItemSearched");
            }
            
            public void onPoiSearched(PoiResult param1PoiResult, int param1Int) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("onPoiSearched:code=");
              stringBuilder.append(param1Int);
              Log.d("高德POI", stringBuilder.toString());
              if (param1PoiResult != null && param1PoiResult.getPois() != null && param1PoiResult.getPois().size() > 0) {
                ArrayList<PoiItem> arrayList1 = param1PoiResult.getPois();
                ArrayList<LocationPOIModel> arrayList = new ArrayList(arrayList1.size());
                for (param1Int = 0; param1Int < arrayList1.size(); param1Int++) {
                  LocationPOIModel locationPOIModel = new LocationPOIModel();
                  locationPOIModel.name = ((PoiItem)arrayList1.get(param1Int)).getTitle();
                  locationPOIModel.address = ((PoiItem)arrayList1.get(param1Int)).getSnippet();
                  locationPOIModel.province = ((PoiItem)arrayList1.get(param1Int)).getProvinceName();
                  locationPOIModel.city = ((PoiItem)arrayList1.get(param1Int)).getCityName();
                  locationPOIModel.area = ((PoiItem)arrayList1.get(param1Int)).getAdName();
                  StringBuilder stringBuilder1 = new StringBuilder();
                  stringBuilder1.append(((PoiItem)arrayList1.get(param1Int)).getDistance());
                  stringBuilder1.append("");
                  locationPOIModel.distance = stringBuilder1.toString();
                  LatLonPoint latLonPoint = ((PoiItem)arrayList1.get(param1Int)).getLatLonPoint();
                  if (latLonPoint != null) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(latLonPoint.getLongitude());
                    stringBuilder2.append("");
                    locationPOIModel.longitude = stringBuilder2.toString();
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(latLonPoint.getLatitude());
                    stringBuilder2.append("");
                    locationPOIModel.latitude = stringBuilder2.toString();
                  } 
                  arrayList.add(locationPOIModel);
                } 
                OnPoiListener onPoiListener = this.a;
                if (onPoiListener != null) {
                  param1Int = param1PoiResult.getPageCount();
                  int i = this.b;
                  boolean bool = true;
                  if (param1Int <= i + 1)
                    bool = false; 
                  onPoiListener.a(0, arrayList, bool);
                  return;
                } 
              } else {
                OnPoiListener onPoiListener = this.a;
                if (onPoiListener != null) {
                  int i = param1Int;
                  if (param1Int == 1000)
                    i = 0; 
                  onPoiListener.a(i, null, false);
                } 
              } 
            }
          });
      poiSearch.setBound(new PoiSearch.SearchBound(latLonPoint, 5000, true));
      poiSearch.searchPOIAsyn();
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("e=");
      stringBuilder.append(exception.getMessage());
      Log.d("高德POI", stringBuilder.toString());
      if (paramOnPoiListener != null)
        paramOnPoiListener.a(-1, null, false); 
      return;
    } 
  }
  
  public void a(int paramInt, String paramString1, String paramString2, OnPoiListener paramOnPoiListener) {
    try {
      if (AppUtils.e()) {
        ServiceSettings.getInstance().setLanguage("zh-CN");
      } else {
        ServiceSettings.getInstance().setLanguage("en");
      } 
      PoiSearch.Query query = new PoiSearch.Query("", "", "");
      query.setPageSize(20);
      query.setPageNum(paramInt + 1);
      LatLonPoint latLonPoint = new LatLonPoint(Double.parseDouble(paramString2), Double.parseDouble(paramString1));
      PoiSearch poiSearch = new PoiSearch((Context)AppUtils.a(), query);
      poiSearch.setOnPoiSearchListener(new PoiSearch.OnPoiSearchListener(this, paramOnPoiListener, paramInt) {
            public void onPoiItemSearched(PoiItem param1PoiItem, int param1Int) {
              Log.d("高德POI", "onPoiItemSearched");
            }
            
            public void onPoiSearched(PoiResult param1PoiResult, int param1Int) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("onPoiSearched:code=");
              stringBuilder.append(param1Int);
              Log.d("高德POI", stringBuilder.toString());
              if (param1PoiResult != null && param1PoiResult.getPois() != null && param1PoiResult.getPois().size() > 0) {
                ArrayList<PoiItem> arrayList1 = param1PoiResult.getPois();
                ArrayList<LocationPOIModel> arrayList = new ArrayList(arrayList1.size());
                for (param1Int = 0; param1Int < arrayList1.size(); param1Int++) {
                  LocationPOIModel locationPOIModel = new LocationPOIModel();
                  locationPOIModel.name = ((PoiItem)arrayList1.get(param1Int)).getTitle();
                  locationPOIModel.address = ((PoiItem)arrayList1.get(param1Int)).getSnippet();
                  locationPOIModel.province = ((PoiItem)arrayList1.get(param1Int)).getProvinceName();
                  locationPOIModel.city = ((PoiItem)arrayList1.get(param1Int)).getCityName();
                  locationPOIModel.area = ((PoiItem)arrayList1.get(param1Int)).getAdName();
                  StringBuilder stringBuilder1 = new StringBuilder();
                  stringBuilder1.append(((PoiItem)arrayList1.get(param1Int)).getDistance());
                  stringBuilder1.append("");
                  locationPOIModel.distance = stringBuilder1.toString();
                  LatLonPoint latLonPoint = ((PoiItem)arrayList1.get(param1Int)).getLatLonPoint();
                  if (latLonPoint != null) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(latLonPoint.getLongitude());
                    stringBuilder2.append("");
                    locationPOIModel.longitude = stringBuilder2.toString();
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(latLonPoint.getLatitude());
                    stringBuilder2.append("");
                    locationPOIModel.latitude = stringBuilder2.toString();
                  } 
                  arrayList.add(locationPOIModel);
                } 
                OnPoiListener onPoiListener = this.a;
                if (onPoiListener != null) {
                  param1Int = param1PoiResult.getPageCount();
                  int i = this.b;
                  boolean bool = true;
                  if (param1Int <= i + 1)
                    bool = false; 
                  onPoiListener.a(0, arrayList, bool);
                  return;
                } 
              } else {
                OnPoiListener onPoiListener = this.a;
                if (onPoiListener != null) {
                  int i = param1Int;
                  if (param1Int == 1000)
                    i = 0; 
                  onPoiListener.a(i, null, false);
                } 
              } 
            }
          });
      poiSearch.setBound(new PoiSearch.SearchBound(latLonPoint, 3000, true));
      poiSearch.searchPOIAsyn();
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("e=");
      stringBuilder.append(exception.getMessage());
      Log.d("高德POI", stringBuilder.toString());
      if (paramOnPoiListener != null)
        paramOnPoiListener.a(-1, null, false); 
      return;
    } 
  }
  
  public void b(int paramInt, String paramString, OnPoiListener paramOnPoiListener) {
    try {
      if (TextUtils.isEmpty(paramString) && paramOnPoiListener != null) {
        paramOnPoiListener.a(-2, null, false);
        return;
      } 
      if (AppUtils.a(paramString)) {
        ServiceSettings.getInstance().setLanguage("zh-CN");
      } else {
        ServiceSettings.getInstance().setLanguage("en");
      } 
      PoiSearch.Query query = new PoiSearch.Query(paramString, "", "");
      query.setPageSize(20);
      query.setPageNum(paramInt + 1);
      PoiSearch poiSearch = new PoiSearch((Context)AppUtils.a(), query);
      poiSearch.setOnPoiSearchListener(new PoiSearch.OnPoiSearchListener(this, paramOnPoiListener, paramInt) {
            public void onPoiItemSearched(PoiItem param1PoiItem, int param1Int) {
              Log.d("高德POI", "onPoiItemSearched");
            }
            
            public void onPoiSearched(PoiResult param1PoiResult, int param1Int) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("onPoiSearched:code=");
              stringBuilder.append(param1Int);
              Log.d("高德POI", stringBuilder.toString());
              if (param1PoiResult != null && param1PoiResult.getPois() != null && param1PoiResult.getPois().size() > 0) {
                ArrayList<PoiItem> arrayList1 = param1PoiResult.getPois();
                ArrayList<LocationPOIModel> arrayList = new ArrayList(arrayList1.size());
                for (param1Int = 0; param1Int < arrayList1.size(); param1Int++) {
                  LocationPOIModel locationPOIModel = new LocationPOIModel();
                  locationPOIModel.name = ((PoiItem)arrayList1.get(param1Int)).getTitle();
                  locationPOIModel.address = ((PoiItem)arrayList1.get(param1Int)).getSnippet();
                  locationPOIModel.province = ((PoiItem)arrayList1.get(param1Int)).getProvinceName();
                  locationPOIModel.city = ((PoiItem)arrayList1.get(param1Int)).getCityName();
                  locationPOIModel.area = ((PoiItem)arrayList1.get(param1Int)).getAdName();
                  StringBuilder stringBuilder1 = new StringBuilder();
                  stringBuilder1.append(((PoiItem)arrayList1.get(param1Int)).getDistance());
                  stringBuilder1.append("");
                  locationPOIModel.distance = stringBuilder1.toString();
                  LatLonPoint latLonPoint = ((PoiItem)arrayList1.get(param1Int)).getLatLonPoint();
                  if (latLonPoint != null) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(latLonPoint.getLongitude());
                    stringBuilder2.append("");
                    locationPOIModel.longitude = stringBuilder2.toString();
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(latLonPoint.getLatitude());
                    stringBuilder2.append("");
                    locationPOIModel.latitude = stringBuilder2.toString();
                  } 
                  arrayList.add(locationPOIModel);
                } 
                OnPoiListener onPoiListener = this.a;
                if (onPoiListener != null) {
                  param1Int = param1PoiResult.getPageCount();
                  int i = this.b;
                  boolean bool = true;
                  if (param1Int <= i + 1)
                    bool = false; 
                  onPoiListener.a(0, arrayList, bool);
                  return;
                } 
              } else {
                OnPoiListener onPoiListener = this.a;
                if (onPoiListener != null) {
                  int i = param1Int;
                  if (param1Int == 1000)
                    i = 0; 
                  onPoiListener.a(i, null, false);
                } 
              } 
            }
          });
      poiSearch.searchPOIAsyn();
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("e=");
      stringBuilder.append(exception.getMessage());
      Log.d("高德POI", stringBuilder.toString());
      if (paramOnPoiListener != null)
        paramOnPoiListener.a(-1, null, false); 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\location\gaode\GaoDePoiService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */