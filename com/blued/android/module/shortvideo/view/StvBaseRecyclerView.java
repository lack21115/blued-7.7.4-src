package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.imagecache.ImageLoadEngine;
import com.blued.android.module.shortvideo.widget.StvItemDecoration;

public class StvBaseRecyclerView extends RecyclerView {
  public StvBaseRecyclerView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    addItemDecoration((RecyclerView.ItemDecoration)new StvItemDecoration(paramContext, paramAttributeSet));
    setOnScrollListener(new RecyclerView.OnScrollListener(this) {
          public void onScrollStateChanged(RecyclerView param1RecyclerView, int param1Int) {
            if (param1Int != 0) {
              if (param1Int != 1) {
                if (param1Int != 2)
                  return; 
                ImageLoadEngine.a();
                return;
              } 
              ImageLoadEngine.a();
              return;
            } 
            ImageLoadEngine.b();
          }
          
          public void onScrolled(RecyclerView param1RecyclerView, int param1Int1, int param1Int2) {
            super.onScrolled(param1RecyclerView, param1Int1, param1Int2);
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\view\StvBaseRecyclerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */