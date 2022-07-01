package com.blued.android.module.shortvideo.contract;

import android.widget.VideoView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.shortvideo.model.TrimDataModel;
import com.blued.android.module.shortvideo.view.RangeSeekBar;

public interface ITrimView extends IView {
  BaseFragment a();
  
  void a(double paramDouble);
  
  void a(RecyclerView.OnScrollListener paramOnScrollListener);
  
  void a(TrimDataModel paramTrimDataModel);
  
  void a(RangeSeekBar.OnRangeSeekBarChangeListener paramOnRangeSeekBarChangeListener);
  
  void ag_();
  
  VideoView b();
  
  void c(int paramInt);
  
  long d();
  
  long e();
  
  FragmentActivity getActivity();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\contract\ITrimView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */