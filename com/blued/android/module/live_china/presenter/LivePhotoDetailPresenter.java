package com.blued.android.module.live_china.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.R;
import java.util.List;

public class LivePhotoDetailPresenter extends MvpPresenter {
  public List<String> h;
  
  private LoadOptions i;
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    this.h = paramBundle1.getStringArrayList("picture_url_list");
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {}
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
  
  public LoadOptions m() {
    if (this.i == null) {
      int i = (h().getResources().getDisplayMetrics()).widthPixels;
      this.i = new LoadOptions();
      this.i.d = R.drawable.defaultpicture;
      this.i.b = R.drawable.defaultpicture;
      LoadOptions loadOptions = this.i;
      i >>= 1;
      loadOptions.a(i, i);
    } 
    return this.i;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\presenter\LivePhotoDetailPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */