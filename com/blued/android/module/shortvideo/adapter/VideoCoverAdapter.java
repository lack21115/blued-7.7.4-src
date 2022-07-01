package com.blued.android.module.shortvideo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.model.VideoFrameInfo;
import java.util.ArrayList;
import java.util.List;

public class VideoCoverAdapter extends RecyclerView.Adapter {
  private List<VideoFrameInfo> a = new ArrayList<VideoFrameInfo>();
  
  private LayoutInflater b;
  
  private LoadOptions c;
  
  private int d;
  
  public VideoCoverAdapter(Context paramContext, int paramInt) {
    this.b = LayoutInflater.from(paramContext);
    this.d = paramInt;
    this.c = new LoadOptions();
    LoadOptions loadOptions = this.c;
    loadOptions.l = false;
    loadOptions.a(paramInt, DensityUtils.a(paramContext, 54.0F));
  }
  
  public void a(VideoFrameInfo paramVideoFrameInfo) {
    this.a.add(paramVideoFrameInfo);
    notifyItemInserted(this.a.size());
  }
  
  public int getItemCount() {
    return this.a.size();
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt) {
    if (this.a.size() > paramInt) {
      VideoFrameInfo videoFrameInfo = this.a.get(paramInt);
      if (videoFrameInfo != null) {
        paramViewHolder = paramViewHolder;
        ImageLoader.d(null, videoFrameInfo.path).a(((EditViewHolder)paramViewHolder).p);
      } 
    } 
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt) {
    return new EditViewHolder(this, this.b.inflate(R.layout.stv_trim_video_item, paramViewGroup, false));
  }
  
  final class EditViewHolder extends RecyclerView.ViewHolder {
    public ImageView p;
    
    EditViewHolder(VideoCoverAdapter this$0, View param1View) {
      super(param1View);
      this.p = (ImageView)param1View.findViewById(R.id.id_image);
      ((LinearLayout.LayoutParams)this.p.getLayoutParams()).width = VideoCoverAdapter.a(this$0);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\adapter\VideoCoverAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */