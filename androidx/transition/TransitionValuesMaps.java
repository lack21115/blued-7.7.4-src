package androidx.transition;

import android.util.SparseArray;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;

class TransitionValuesMaps {
  final ArrayMap<View, TransitionValues> a = new ArrayMap();
  
  final SparseArray<View> b = new SparseArray();
  
  final LongSparseArray<View> c = new LongSparseArray();
  
  final ArrayMap<String, View> d = new ArrayMap();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\TransitionValuesMaps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */