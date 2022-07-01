package com.soft.blued.ui.user.adapter;

import android.content.Context;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.model.BluedAlbum;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class UserinfoNewAlbumAdapter extends BaseQuickAdapter<BluedAlbum, BaseViewHolder> {
  public Context a;
  
  private IRequestHost b;
  
  private String c;
  
  private boolean d;
  
  private int e;
  
  public UserinfoNewAlbumAdapter(IRequestHost paramIRequestHost, Context paramContext, String paramString, boolean paramBoolean, int paramInt) {
    super(2131493673, new ArrayList());
    this.a = paramContext;
    this.b = paramIRequestHost;
    this.c = paramString;
    this.d = paramBoolean;
    this.e = paramInt;
  }
  
  public void a() {
    if (this.n != null && this.n.size() > 0)
      ((BluedAlbum)this.n.get(0)).applyStatus = 2; 
    notifyDataSetChanged();
  }
  
  public void a(int paramInt) {
    this.e = paramInt;
    notifyDataSetChanged();
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, BluedAlbum paramBluedAlbum) {
    if (paramBaseViewHolder != null) {
      ImageView imageView1 = (ImageView)paramBaseViewHolder.d(2131297463);
      ImageView imageView2 = (ImageView)paramBaseViewHolder.d(2131297518);
      ShapeTextView shapeTextView = (ShapeTextView)paramBaseViewHolder.d(2131301456);
      shapeTextView.setVisibility(0);
      ShapeHelper.b((ShapeHelper.ShapeView)shapeTextView, 2131100897);
      int i = paramBluedAlbum.applyStatus;
      if (i != 1) {
        if (i != 2) {
          if (paramBluedAlbum.audit_status == 1) {
            ShapeHelper.b((ShapeHelper.ShapeView)shapeTextView, 2131100735);
            shapeTextView.setText(2131758382);
          } else {
            shapeTextView.setVisibility(8);
          } 
          ImageLoader.a(this.b, paramBluedAlbum.getUrl()).a(2131232201).a(6.0F).a(imageView1);
        } else {
          shapeTextView.setText(2131759183);
          ImageLoader.a(this.b, paramBluedAlbum.getUrl()).a(2131233538).a(6.0F).a(imageView1);
        } 
      } else {
        shapeTextView.setText(2131759182);
        ImageLoader.a(this.b, paramBluedAlbum.getUrl()).a(2131233538).a(6.0F).a(imageView1);
      } 
      if (this.d) {
        if (this.e == 2) {
          imageView2.setImageResource(2131232790);
          return;
        } 
        imageView2.setImageResource(2131232789);
        return;
      } 
      if (paramBluedAlbum.applyStatus == 0) {
        imageView2.setImageResource(2131232790);
        return;
      } 
      imageView2.setImageResource(2131232789);
    } 
  }
  
  public void a(boolean paramBoolean, String paramString) {
    if (!StringUtils.e(paramString) && !paramBoolean) {
      Iterator<BluedAlbum> iterator = this.n.iterator();
      while (iterator.hasNext()) {
        if (paramString.equals(((BluedAlbum)iterator.next()).getPid()))
          iterator.remove(); 
      } 
    } 
    notifyDataSetChanged();
  }
  
  public void b() {
    if (this.n != null && this.n.size() > 0)
      ((BluedAlbum)this.n.get(0)).applyStatus = 1; 
    notifyDataSetChanged();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\adapter\UserinfoNewAlbumAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */