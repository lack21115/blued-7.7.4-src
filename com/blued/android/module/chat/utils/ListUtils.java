package com.blued.android.module.chat.utils;

import com.blued.android.chat.model.SessionModel;
import com.blued.android.module.chat.tools.SessionModelComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListUtils {
  public static List<SessionModel> sortSessionModelList(List<SessionModel> paramList) {
    if (paramList != null && paramList.size() > 0)
      Collections.sort(paramList, (Comparator<? super SessionModel>)new SessionModelComparator()); 
    return paramList;
  }
  
  public static List<Long[]> splitList(List<Long> paramList, int paramInt) {
    int j = paramList.size();
    int k = (j + paramInt - 1) / paramInt;
    ArrayList<Long[]> arrayList = new ArrayList();
    int i = 0;
    while (true) {
      int m = i;
      if (m < k) {
        int n = m + 1;
        i = n * paramInt;
        if (i >= j)
          i = j; 
        List<Long> list = paramList.subList(m * paramInt, i);
        Long[] arrayOfLong = new Long[list.size()];
        list.toArray(arrayOfLong);
        arrayList.add(arrayOfLong);
        i = n;
        continue;
      } 
      return (List<Long[]>)arrayList;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\cha\\utils\ListUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */