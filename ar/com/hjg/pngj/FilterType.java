package ar.com.hjg.pngj;

import java.util.HashMap;

public enum FilterType {
  a(0),
  b(1),
  c(2),
  d(3),
  e(4),
  f(-1),
  g(-2),
  h(-4),
  i(-4),
  j(-3),
  k(-2),
  l(-10),
  m(-40),
  n(-50),
  o(-100);
  
  private static HashMap<Integer, FilterType> q;
  
  public final int p;
  
  static {
    q = new HashMap<Integer, FilterType>();
    FilterType[] arrayOfFilterType = values();
    int j = arrayOfFilterType.length;
    while (i < j) {
      FilterType filterType = arrayOfFilterType[i];
      q.put(Integer.valueOf(filterType.p), filterType);
      i++;
    } 
  }
  
  FilterType(int paramInt1) {
    this.p = paramInt1;
  }
  
  public static FilterType a(int paramInt) {
    return q.get(Integer.valueOf(paramInt));
  }
  
  public static boolean b(int paramInt) {
    return (paramInt >= 0 && paramInt <= 4);
  }
  
  static {
    int i = 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\FilterType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */