package com.blued.android.module.shortvideo.model;

import com.blued.android.module.external_sense_library.config.BluedFilterType;
import com.blued.android.module.external_sense_library.manager.FilterDataManager;
import com.blued.android.module.shortvideo.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FilterConfigModel extends IModel {
  private List<FilterItem> filtersDatas = new ArrayList<FilterItem>();
  
  private final int[] mFilterIconRsIds = new int[] { R.drawable.stv_flash_ruby, R.drawable.stv_flash_pansy, R.drawable.stv_flash_modern, R.drawable.stv_flash_city, R.drawable.stv_flash_babypink };
  
  private Map<BluedFilterType.FILER, FilterItem> mFilterNameMap = new HashMap<BluedFilterType.FILER, FilterItem>();
  
  private final int[] mFilterShowNameRsIds = new int[] { R.string.flash_filter_ruby, R.string.flash_filter_pansy, R.string.flash_filter_morden, R.string.flash_filter_city, R.string.flash_filter_babypink };
  
  private final FilterItem nullKwFilter = new FilterItem(null, R.drawable.stv_flash_origin, R.string.live_filter_off);
  
  public List<FilterItem> getFilters() {
    if (this.filtersDatas.size() > 0)
      return this.filtersDatas; 
    this.filtersDatas.add(this.nullKwFilter);
    List list = FilterDataManager.getInstance().getFilters();
    FilterItem[] arrayOfFilterItem = new FilterItem[5];
    if (this.mFilterNameMap.size() <= 0) {
      Iterator<BluedFilterType.FILER> iterator = list.iterator();
      while (true) {
        boolean bool = iterator.hasNext();
        int j = 0;
        int i = 0;
        if (bool) {
          BluedFilterType.FILER fILER = iterator.next();
          if (fILER != null) {
            j = null.a[fILER.ordinal()];
            if (j != 1)
              if (j != 2) {
                if (j != 3) {
                  if (j != 4) {
                    i = 4;
                  } else {
                    i = 3;
                  } 
                } else {
                  i = 2;
                } 
              } else {
                i = 1;
              }  
            arrayOfFilterItem[i] = new FilterItem(fILER, this.mFilterIconRsIds[i], this.mFilterShowNameRsIds[i]);
          } 
          continue;
        } 
        int k = arrayOfFilterItem.length;
        for (i = j; i < k; i++) {
          FilterItem filterItem = arrayOfFilterItem[i];
          if (filterItem != null && filterItem.b() != null) {
            this.mFilterNameMap.put(filterItem.b(), filterItem);
            this.filtersDatas.add(filterItem);
          } 
        } 
        return this.filtersDatas;
      } 
    } 
    this.filtersDatas.addAll(this.mFilterNameMap.values());
    return this.filtersDatas;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\model\FilterConfigModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */