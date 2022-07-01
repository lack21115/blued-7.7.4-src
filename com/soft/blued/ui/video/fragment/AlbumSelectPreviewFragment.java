package com.soft.blued.ui.video.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;

public class AlbumSelectPreviewFragment extends AlbumPreviewFragment {
  public static void b(BaseFragment paramBaseFragment, int paramInt1, int paramInt2, int paramInt3) {
    Bundle bundle = b(paramInt2);
    bundle.putInt("from", paramInt1);
    TerminalActivity.a((Fragment)paramBaseFragment, AlbumSelectPreviewFragment.class, bundle, paramInt3);
  }
  
  public boolean a(AlbumSelectInfo paramAlbumSelectInfo) {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\fragment\AlbumSelectPreviewFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */