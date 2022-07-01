package com.soft.blued.ui.video.presenter;

import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.media.selector.contract.IAlbumBaseCallback;
import com.blued.android.module.media.selector.present.AlbumBasePresenter;
import com.soft.blued.ui.video.adapter.AlbumSelectHalfAdapter;

public class AlbumSelectHalfPresenter extends AlbumBasePresenter {
  public RecyclerView.Adapter k() {
    return (RecyclerView.Adapter)new AlbumSelectHalfAdapter((IAlbumBaseCallback)this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\presenter\AlbumSelectHalfPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */