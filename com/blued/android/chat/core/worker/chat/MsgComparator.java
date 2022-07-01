package com.blued.android.chat.core.worker.chat;

import com.blued.android.chat.model.ChattingModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MsgComparator implements Comparator<ChattingModel> {
  public static FillInterval getFillTaskIntervalBySortedMsg(ChattingModel paramChattingModel, List<ChattingModel> paramList) {
    int i = paramList.size();
    ChattingModel chattingModel = paramChattingModel;
    if (paramChattingModel == null)
      chattingModel = paramList.get(i - 1); 
    long l3 = chattingModel.msgPreviousId;
    long l2 = chattingModel.msgId;
    boolean bool = false;
    long l1 = ((ChattingModel)paramList.get(0)).msgId;
    while (--i >= 0) {
      boolean bool1;
      long l4;
      long l5;
      paramChattingModel = paramList.get(i);
      if (l3 == paramChattingModel.msgId) {
        l4 = l2;
        l5 = l1;
        bool1 = bool;
        if (!bool) {
          l4 = paramChattingModel.msgId;
          l5 = l1;
          bool1 = bool;
        } 
      } else {
        l4 = l2;
        l5 = l1;
        bool1 = bool;
        if (l3 > paramChattingModel.msgId) {
          l5 = paramChattingModel.msgId;
          bool1 = true;
          l4 = l2;
        } 
      } 
      l3 = paramChattingModel.msgPreviousId;
      i--;
      l2 = l4;
      l1 = l5;
      bool = bool1;
    } 
    return (l2 > 1L + l1) ? new FillInterval(l1, l2) : null;
  }
  
  public static void mergeSortedList(List<ChattingModel> paramList, ChattingModel paramChattingModel) {
    if (paramList != null) {
      if (paramChattingModel == null)
        return; 
      int j = paramList.size();
      if (j == 0) {
        paramList.add(paramChattingModel);
        return;
      } 
      MsgComparator msgComparator = new MsgComparator();
      int i;
      for (i = 0; i < j; i++) {
        int k = msgComparator.compare(paramList.get(i), paramChattingModel);
        if (k == 0) {
          paramList.set(i, paramChattingModel);
          break;
        } 
        if (k > 0) {
          paramList.add(i, paramChattingModel);
          break;
        } 
      } 
      if (i == j)
        paramList.add(paramChattingModel); 
    } 
  }
  
  public static void mergeSortedList(List<ChattingModel> paramList1, List<ChattingModel> paramList2) {
    if (paramList1 != null) {
      int k;
      if (paramList2 == null)
        return; 
      int n = paramList1.size();
      int m = paramList2.size();
      if (n == 0 || m == 0) {
        paramList1.addAll(paramList2);
        return;
      } 
      ArrayList<ChattingModel> arrayList = new ArrayList();
      MsgComparator msgComparator = new MsgComparator();
      int i = 0;
      int j = 0;
      while (true) {
        k = i;
        if (i < n) {
          k = i;
          if (j < m) {
            ChattingModel chattingModel1 = paramList1.get(i);
            ChattingModel chattingModel2 = paramList2.get(j);
            k = msgComparator.compare(chattingModel1, chattingModel2);
            if (k == 0) {
              arrayList.add(chattingModel2);
              i++;
            } else if (k > 0) {
              arrayList.add(chattingModel2);
            } else {
              arrayList.add(chattingModel1);
              i++;
              continue;
            } 
            j++;
            continue;
          } 
        } 
        break;
      } 
      while (true) {
        i = j;
        if (k < n) {
          arrayList.add(paramList1.get(k));
          k++;
          continue;
        } 
        break;
      } 
      while (i < m) {
        arrayList.add(paramList2.get(i));
        i++;
      } 
      paramList1.clear();
      paramList1.addAll(arrayList);
      return;
    } 
  }
  
  private static void removeDuplicatedSorted(List<ChattingModel> paramList) {
    MsgComparator msgComparator = new MsgComparator();
    ArrayList<ChattingModel> arrayList = new ArrayList();
    Iterator<ChattingModel> iterator = paramList.iterator();
    for (ChattingModel chattingModel = null; iterator.hasNext(); chattingModel = chattingModel1) {
      ChattingModel chattingModel1 = iterator.next();
      if (msgComparator.compare(chattingModel, chattingModel1) != 0) {
        arrayList.add(chattingModel1);
      } else if (chattingModel1.dbId > chattingModel.dbId) {
        arrayList.remove(chattingModel);
        arrayList.add(chattingModel1);
      } else {
        continue;
      } 
    } 
    paramList.clear();
    paramList.addAll(arrayList);
  }
  
  public static void sortAndDistinct(List<ChattingModel> paramList) {
    Collections.sort(paramList, new MsgComparator());
    removeDuplicatedSorted(paramList);
  }
  
  public static void sortPair(List<ChattingModel> paramList) {
    Collections.sort(paramList, new MsgPairComparator());
  }
  
  public int compare(ChattingModel paramChattingModel1, ChattingModel paramChattingModel2) {
    if (paramChattingModel1 == null && paramChattingModel2 == null)
      return 0; 
    if (paramChattingModel1 == null)
      return -1; 
    if (paramChattingModel2 == null)
      return 1; 
    int i = paramChattingModel1.msgId - paramChattingModel2.msgId cmp 0L;
    if (i != 0)
      return (i > 0) ? 1 : -1; 
    i = paramChattingModel1.msgLocalId - paramChattingModel2.msgLocalId cmp 0L;
    if (i != 0)
      return (i > 0) ? 1 : -1; 
    if (paramChattingModel1.msgId == 0L && paramChattingModel1.msgLocalId == 0L) {
      i = paramChattingModel1.msgTimestamp - paramChattingModel2.msgTimestamp cmp 0L;
      return (i == 0) ? 0 : ((i > 0) ? 1 : -1);
    } 
    return 0;
  }
  
  public static final class FillInterval {
    long endId;
    
    long startId;
    
    public FillInterval(long param1Long1, long param1Long2) {
      this.startId = param1Long1;
      this.endId = param1Long2;
    }
  }
  
  static class MsgPairComparator implements Comparator<ChattingModel> {
    private MsgPairComparator() {}
    
    public int compare(ChattingModel param1ChattingModel1, ChattingModel param1ChattingModel2) {
      return (new MsgComparator()).compare(param1ChattingModel1, param1ChattingModel2);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\worker\chat\MsgComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */