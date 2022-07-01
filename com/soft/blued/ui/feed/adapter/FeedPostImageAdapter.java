package com.soft.blued.ui.feed.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.feed.manager.SelectPhotoManager;
import com.soft.blued.ui.feed.model.ChildImageInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class FeedPostImageAdapter extends BaseItemDraggableAdapter<ChildImageInfo, BaseViewHolder> {
  private int o;
  
  private ChildImageInfo p = new ChildImageInfo();
  
  private IRequestHost q;
  
  public FeedPostImageAdapter(IRequestHost paramIRequestHost) {
    super(2131493513, null);
    this.q = paramIRequestHost;
    this.o = (AppInfo.l - DensityUtils.a(AppInfo.d(), 20.0F)) / 3;
  }
  
  public int A() {
    Iterator<ChildImageInfo> iterator = n().iterator();
    int i = 0;
    while (iterator.hasNext()) {
      ChildImageInfo childImageInfo = iterator.next();
      if (childImageInfo != null && !TextUtils.isEmpty(childImageInfo.mImagePath))
        i++; 
    } 
    return i;
  }
  
  public boolean B() {
    for (ChildImageInfo childImageInfo : n()) {
      if (childImageInfo != null && !TextUtils.isEmpty(childImageInfo.mImagePath))
        return true; 
    } 
    return false;
  }
  
  public boolean C() {
    for (ChildImageInfo childImageInfo : n()) {
      if (childImageInfo == null || TextUtils.isEmpty(childImageInfo.mImagePath))
        return true; 
    } 
    return false;
  }
  
  public int D() {
    return (this.n != null) ? ((this.n.size() >= 1 && C()) ? (this.n.size() - 1) : this.n.size()) : 0;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, ChildImageInfo paramChildImageInfo) {
    View view = paramBaseViewHolder.d(2131299753);
    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
    int i = this.o;
    layoutParams.height = i;
    layoutParams.width = i;
    view.setLayoutParams(layoutParams);
    ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297499);
    if (paramChildImageInfo.height > paramChildImageInfo.width * 3) {
      ImageLoader.d(this.q, paramChildImageInfo.mImagePath).a(2131232201).a(true, 0.0F).a(imageView);
      paramBaseViewHolder.b(2131300102, true);
    } else {
      ImageLoader.d(this.q, paramChildImageInfo.mImagePath).a(2131232201).a(imageView);
      paramBaseViewHolder.b(2131300102, false);
    } 
    imageView = (ImageView)paramBaseViewHolder.d(2131297813);
    paramBaseViewHolder.c(2131297813);
    if (!TextUtils.isEmpty(paramChildImageInfo.mImagePath)) {
      paramBaseViewHolder.b(2131297422, false);
      paramBaseViewHolder.b(2131297499, true);
      return;
    } 
    paramBaseViewHolder.b(2131297422, true);
    paramBaseViewHolder.b(2131297499, false);
    paramBaseViewHolder.c(2131297422);
  }
  
  public void c() {
    c(new ArrayList());
    Iterator<ChildImageInfo> iterator = SelectPhotoManager.a().c().iterator();
    while (iterator.hasNext())
      a(iterator.next()); 
    d();
  }
  
  public void d() {
    if (n().indexOf(this.p) >= 0)
      n().remove(this.p); 
    SelectPhotoManager.a().d();
    for (ChildImageInfo childImageInfo : n())
      SelectPhotoManager.a().a(childImageInfo); 
    n().add(this.p);
    if (getItemCount() > 9 && n().indexOf(this.p) >= 0)
      n().remove(this.p); 
    notifyDataSetChanged();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\adapter\FeedPostImageAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */