package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.module.shortvideo.adapter.VideoCoverAdapter;
import com.blued.android.module.shortvideo.contract.IGetFrameCallback;
import com.blued.android.module.shortvideo.model.VideoFrameInfo;
import com.blued.android.module.shortvideo.model.VideoFrameModel;
import com.blued.android.module.shortvideo.widget.SpacesItemDecoration;

public class VideoFrameView extends RelativeLayout implements IGetFrameCallback {
  private RecyclerView a;
  
  private VideoCoverAdapter b;
  
  private String c;
  
  private long d;
  
  private int e;
  
  private int f;
  
  private int g;
  
  private int h;
  
  public VideoFrameView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public VideoFrameView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoFrameView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a() {
    RecyclerView recyclerView = this.a;
    if (recyclerView != null)
      recyclerView.clearOnScrollListeners(); 
  }
  
  public void a(RecyclerView.OnScrollListener paramOnScrollListener) {
    this.a.addOnScrollListener(paramOnScrollListener);
  }
  
  public void a(VideoFrameInfo paramVideoFrameInfo) {
    AppInfo.n().post(new Runnable(this, paramVideoFrameInfo) {
          public void run() {
            if (VideoFrameView.a(this.b) != null)
              VideoFrameView.a(this.b).a(this.a); 
          }
        });
  }
  
  public void a(String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.c = paramString;
    this.d = paramLong;
    this.e = paramInt1;
    this.f = paramInt2;
    this.g = paramInt3;
    this.h = paramInt4;
    this.a = new RecyclerView(getContext());
    this.a.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(getContext(), 0, false));
    this.b = new VideoCoverAdapter(getContext(), paramInt1);
    this.a.setAdapter((RecyclerView.Adapter)this.b);
    SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(0, 0, paramInt4);
    spacesItemDecoration.a(paramInt3, 0, paramInt3, 0);
    spacesItemDecoration.a(true, true);
    this.a.addItemDecoration((RecyclerView.ItemDecoration)spacesItemDecoration);
    VideoFrameModel.getInstance().getVideoFrame(paramString, 0L, paramLong, paramInt4, paramInt1, paramInt2, this);
    addView((View)this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\view\VideoFrameView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */