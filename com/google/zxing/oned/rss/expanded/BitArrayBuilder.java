package com.google.zxing.oned.rss.expanded;

import com.google.zxing.common.BitArray;
import java.util.List;

final class BitArrayBuilder {
  static BitArray a(List<ExpandedPair> paramList) {
    int j = (paramList.size() << 1) - 1;
    int i = j;
    if (((ExpandedPair)paramList.get(paramList.size() - 1)).b() == null)
      i = j - 1; 
    BitArray bitArray = new BitArray(i * 12);
    int k = ((ExpandedPair)paramList.get(0)).b().a();
    j = 11;
    i = 0;
    while (j >= 0) {
      if ((1 << j & k) != 0)
        bitArray.b(i); 
      i++;
      j--;
    } 
    for (k = 1; k < paramList.size(); k++) {
      ExpandedPair expandedPair = paramList.get(k);
      int m = expandedPair.a().a();
      for (j = 11; j >= 0; j--) {
        if ((1 << j & m) != 0)
          bitArray.b(i); 
        i++;
      } 
      j = i;
      if (expandedPair.b() != null) {
        int n = expandedPair.b().a();
        m = 11;
        while (true) {
          j = i;
          if (m >= 0) {
            if ((1 << m & n) != 0)
              bitArray.b(i); 
            i++;
            m--;
            continue;
          } 
          break;
        } 
      } 
      i = j;
    } 
    return bitArray;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\expanded\BitArrayBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */