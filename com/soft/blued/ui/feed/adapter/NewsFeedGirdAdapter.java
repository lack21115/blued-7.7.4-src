package com.soft.blued.ui.feed.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.net.IRequestHost;
import com.soft.blued.customview.DragGridBaseAdapter;
import com.soft.blued.ui.feed.manager.SelectPhotoManager;
import com.soft.blued.ui.feed.model.ChildImageInfo;
import com.soft.blued.utils.StringUtils;
import java.util.Collections;
import java.util.List;

public class NewsFeedGirdAdapter extends BaseAdapter implements DragGridBaseAdapter {
  private IRequestHost a;
  
  private LayoutInflater b;
  
  private int c = -1;
  
  private List<ChildImageInfo> d;
  
  public NewsFeedGirdAdapter(Context paramContext, IRequestHost paramIRequestHost, List<ChildImageInfo> paramList) {
    this.b = LayoutInflater.from(paramContext);
    this.a = paramIRequestHost;
    this.d = paramList;
  }
  
  public void a(int paramInt) {
    this.c = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(int paramInt1, int paramInt2) {
    ChildImageInfo childImageInfo = this.d.get(paramInt1);
    if (paramInt1 < paramInt2) {
      while (paramInt1 < paramInt2) {
        List<ChildImageInfo> list = this.d;
        int i = paramInt1 + 1;
        Collections.swap(list, paramInt1, i);
        Collections.swap(SelectPhotoManager.a().c(), paramInt1, i);
        paramInt1 = i;
      } 
    } else if (paramInt1 > paramInt2) {
      while (paramInt1 > paramInt2) {
        List<ChildImageInfo> list = this.d;
        int i = paramInt1 - 1;
        Collections.swap(list, paramInt1, i);
        Collections.swap(SelectPhotoManager.a().c(), paramInt1, i);
        paramInt1--;
      } 
    } 
    this.d.set(paramInt2, childImageInfo);
    SelectPhotoManager.a().c().set(paramInt2, childImageInfo);
  }
  
  public int getCount() {
    return this.d.size();
  }
  
  public Object getItem(int paramInt) {
    return this.d.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ImageWrapper imageWrapper;
    View view = this.b.inflate(2131493617, paramViewGroup, false);
    ImageView imageView2 = (ImageView)view.findViewById(2131297765);
    ImageView imageView1 = (ImageView)view.findViewById(2131297763);
    ChildImageInfo childImageInfo = this.d.get(paramInt);
    if (!StringUtils.e(childImageInfo.mImagePath)) {
      if (childImageInfo.mImagePath.contains("http")) {
        imageWrapper = ImageLoader.a(this.a, childImageInfo.mImagePath);
      } else {
        imageWrapper = ImageLoader.d(this.a, childImageInfo.mImagePath);
      } 
      imageWrapper.a(2131232201).a(imageView2);
    } else {
      imageView2.setVisibility(8);
      imageWrapper.setVisibility(0);
      imageWrapper.setBackgroundResource(2131232200);
    } 
    if (paramInt == this.c)
      view.setVisibility(4); 
    return view;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\adapter\NewsFeedGirdAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */