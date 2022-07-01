package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.data.Entry;
import java.util.Comparator;

public class EntryXComparator implements Comparator<Entry> {
  public int a(Entry paramEntry1, Entry paramEntry2) {
    int i = paramEntry1.i() - paramEntry2.i() cmp 0.0F;
    return (i == 0) ? 0 : ((i > 0) ? 1 : -1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\chartin\\utils\EntryXComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */