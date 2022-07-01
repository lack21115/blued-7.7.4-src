package com.alibaba.mtl.appmonitor.model;

import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.f.a;
import com.alibaba.mtl.log.model.LogField;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UTDimensionValueSet extends DimensionValueSet {
  private static final Set<LogField> a = new HashSet<LogField>() {
    
    };
  
  public static UTDimensionValueSet create(Map<String, String> paramMap) {
    return (UTDimensionValueSet)a.a().a(UTDimensionValueSet.class, new Object[] { paramMap });
  }
  
  public void clean() {
    super.clean();
  }
  
  public void fill(Object... paramVarArgs) {
    super.fill(paramVarArgs);
  }
  
  public Integer getEventId() {
    if (this.map != null) {
      String str = this.map.get(LogField.EVENTID.toString());
      if (str != null)
        try {
          int i = a.a(str);
          return Integer.valueOf(i);
        } catch (NumberFormatException numberFormatException) {} 
    } 
    boolean bool = false;
    return Integer.valueOf(bool);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\model\UTDimensionValueSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */