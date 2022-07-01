package com.blued.android.module.external_sense_library.manager;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.module.external_sense_library.config.BluedFilterType;
import com.blued.android.module.external_sense_library.model.FilterDataModel;
import com.blued.android.module.external_sense_library.utils.FileUtils;
import com.blued.android.module.external_sense_library.utils.SenseLibSPMgr;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilterDataManager {
  private static FilterDataManager instance;
  
  private Map<BluedFilterType.FILER, String> modelItemMap = new HashMap<BluedFilterType.FILER, String>();
  
  private void copyFilterToSd() {
    FilterDataModel filterDataModel = new FilterDataModel();
    Map<? extends BluedFilterType.FILER, ? extends String> map = FileUtils.b(AppInfo.d(), "filters");
    if (map != null && map.size() > 0) {
      for (Map.Entry entry : map.entrySet())
        filterDataModel.a((BluedFilterType.FILER)entry.getKey(), (String)entry.getValue()); 
      String str = AppInfo.f().toJson(filterDataModel);
      SenseLibSPMgr.a().b(str);
      this.modelItemMap.putAll(map);
    } 
  }
  
  public static FilterDataManager getInstance() {
    // Byte code:
    //   0: getstatic com/blued/android/module/external_sense_library/manager/FilterDataManager.instance : Lcom/blued/android/module/external_sense_library/manager/FilterDataManager;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/module/external_sense_library/manager/FilterDataManager
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/external_sense_library/manager/FilterDataManager.instance : Lcom/blued/android/module/external_sense_library/manager/FilterDataManager;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/module/external_sense_library/manager/FilterDataManager
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/module/external_sense_library/manager/FilterDataManager.instance : Lcom/blued/android/module/external_sense_library/manager/FilterDataManager;
    //   25: ldc com/blued/android/module/external_sense_library/manager/FilterDataManager
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/module/external_sense_library/manager/FilterDataManager
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/module/external_sense_library/manager/FilterDataManager.instance : Lcom/blued/android/module/external_sense_library/manager/FilterDataManager;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public List<BluedFilterType.FILER> getFilters() {
    if (this.modelItemMap.size() > 0) {
      ArrayList<BluedFilterType.FILER> arrayList1 = new ArrayList();
      arrayList1.addAll(this.modelItemMap.keySet());
      return arrayList1;
    } 
    String str = SenseLibSPMgr.a().c();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str)) {
      FilterDataModel filterDataModel = (FilterDataModel)AppInfo.f().fromJson(str, (new TypeToken<FilterDataModel>() {
          
          }).getType());
      bool1 = bool2;
      if (filterDataModel != null) {
        bool1 = bool2;
        if (filterDataModel.a != null) {
          bool1 = bool2;
          if (filterDataModel.a.size() > 0) {
            List list = FileUtils.c(AppInfo.d(), "filters");
            bool1 = bool2;
            if (list.size() == filterDataModel.a.size()) {
              for (FilterDataModel.FilterItemData filterItemData : filterDataModel.a) {
                if (filterItemData != null) {
                  this.modelItemMap.put(filterItemData.a, filterItemData.b);
                  list.remove(filterItemData.a.getValue());
                } 
              } 
              bool1 = bool2;
              if (list.size() <= 0)
                bool1 = false; 
            } 
          } 
        } 
      } 
    } 
    if (bool1)
      copyFilterToSd(); 
    ArrayList<BluedFilterType.FILER> arrayList = new ArrayList();
    arrayList.addAll(this.modelItemMap.keySet());
    return arrayList;
  }
  
  public String getModel(BluedFilterType.FILER paramFILER) {
    if (paramFILER == null)
      return ""; 
    String str = this.modelItemMap.get(paramFILER);
    if (!TextUtils.isEmpty(str) && (new File(str)).exists())
      return str; 
    copyFilterToSd();
    return this.modelItemMap.get(paramFILER);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\manager\FilterDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */