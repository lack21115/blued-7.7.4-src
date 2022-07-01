package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.qrcode.detector.FinderPattern;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
import com.google.zxing.qrcode.detector.FinderPatternInfo;
import java.io.Serializable;
import java.util.Comparator;

final class MultiFinderPatternFinder extends FinderPatternFinder {
  private static final FinderPatternInfo[] a = new FinderPatternInfo[0];
  
  static final class ModuleSizeComparator implements Serializable, Comparator<FinderPattern> {
    public int a(FinderPattern param1FinderPattern1, FinderPattern param1FinderPattern2) {
      double d = (param1FinderPattern2.c() - param1FinderPattern1.c());
      return (d < 0.0D) ? -1 : ((d > 0.0D) ? 1 : 0);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\multi\qrcode\detector\MultiFinderPatternFinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */