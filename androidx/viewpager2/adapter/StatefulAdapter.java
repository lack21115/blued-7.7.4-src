package androidx.viewpager2.adapter;

import android.os.Parcelable;

public interface StatefulAdapter {
  void restoreState(Parcelable paramParcelable);
  
  Parcelable saveState();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\viewpager2\adapter\StatefulAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */