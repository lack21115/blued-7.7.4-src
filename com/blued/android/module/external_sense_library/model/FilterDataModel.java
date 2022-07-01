package com.blued.android.module.external_sense_library.model;

import com.blued.android.module.external_sense_library.config.BluedFilterType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FilterDataModel implements Serializable {
  public List<FilterItemData> a = new ArrayList<FilterItemData>();
  
  public void a(BluedFilterType.FILER paramFILER, String paramString) {
    FilterItemData filterItemData = new FilterItemData(this);
    filterItemData.a = paramFILER;
    filterItemData.b = paramString;
    this.a.add(filterItemData);
  }
  
  public class FilterItemData implements Serializable {
    public BluedFilterType.FILER a;
    
    public String b;
    
    public FilterItemData(FilterDataModel this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\model\FilterDataModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */