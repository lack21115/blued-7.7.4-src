package com.blued.android.module.media.selector.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.utils.Log;
import com.blued.android.module.media.selector.R;
import com.blued.android.module.media.selector.contract.IAlbumBaseCallback;
import com.blued.android.module.media.selector.utils.ViewUtils;
import com.blued.android.module.player.media.model.MediaInfo;

public class AlbumBaseAdapter extends RecyclerView.Adapter {
  private static final String a = AlbumBaseAdapter.class.getSimpleName();
  
  private IAlbumBaseCallback b;
  
  public AlbumBaseAdapter(IAlbumBaseCallback paramIAlbumBaseCallback) {
    this.b = paramIAlbumBaseCallback;
  }
  
  public int getItemCount() {
    return this.b.b();
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt) {
    MediaInfo mediaInfo = this.b.a(paramInt);
    paramViewHolder = paramViewHolder;
    if (paramViewHolder != null)
      paramViewHolder.a(mediaInfo, paramInt); 
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt) {
    Log.c("", "onCreateViewHolder");
    return new ViewHolder(this, LayoutInflater.from(this.b.a()).inflate(R.layout.select_file_item_v, null));
  }
  
  public class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView p;
    
    public ImageView q;
    
    public RelativeLayout r;
    
    public RelativeLayout s;
    
    public TextView t;
    
    public ViewHolder(AlbumBaseAdapter this$0, View param1View) {
      super(param1View);
      this.r = (RelativeLayout)param1View.findViewById(R.id.vr_select_item_v);
      this.p = (ImageView)param1View.findViewById(R.id.vr_header_view);
      this.q = (ImageView)param1View.findViewById(R.id.vr_select_view);
      this.s = (RelativeLayout)param1View.findViewById(R.id.vr_video_type_cover_v);
      this.t = (TextView)param1View.findViewById(R.id.tv_video_time);
    }
    
    public void a(MediaInfo param1MediaInfo, int param1Int) {
      // Byte code:
      //   0: aload_1
      //   1: ifnull -> 299
      //   4: new com/blued/android/core/imagecache/LoadOptions
      //   7: dup
      //   8: invokespecial <init> : ()V
      //   11: astore #9
      //   13: aload #9
      //   15: getstatic com/blued/android/module/media/selector/R$drawable.defaultpicture : I
      //   18: putfield d : I
      //   21: aload #9
      //   23: getstatic com/blued/android/module/media/selector/R$drawable.defaultpicture : I
      //   26: putfield b : I
      //   29: invokestatic a : ()Lcom/blued/android/module/media/selector/utils/ThumbLoader;
      //   32: aload_1
      //   33: aload_0
      //   34: getfield p : Landroid/widget/ImageView;
      //   37: aload #9
      //   39: invokevirtual a : (Lcom/blued/android/module/player/media/model/MediaInfo;Landroid/widget/ImageView;Lcom/blued/android/core/imagecache/LoadOptions;)V
      //   42: aload_1
      //   43: getfield media_type : I
      //   46: istore #4
      //   48: invokestatic m : ()I
      //   51: istore #5
      //   53: iconst_0
      //   54: istore #8
      //   56: iload #4
      //   58: iload #5
      //   60: if_icmpne -> 97
      //   63: aload_0
      //   64: getfield q : Landroid/widget/ImageView;
      //   67: bipush #8
      //   69: invokevirtual setVisibility : (I)V
      //   72: aload_0
      //   73: getfield s : Landroid/widget/RelativeLayout;
      //   76: iconst_0
      //   77: invokevirtual setVisibility : (I)V
      //   80: aload_0
      //   81: getfield t : Landroid/widget/TextView;
      //   84: aload_1
      //   85: getfield videoTime : J
      //   88: invokestatic a : (J)Ljava/lang/String;
      //   91: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   94: goto -> 114
      //   97: aload_0
      //   98: getfield q : Landroid/widget/ImageView;
      //   101: iconst_0
      //   102: invokevirtual setVisibility : (I)V
      //   105: aload_0
      //   106: getfield s : Landroid/widget/RelativeLayout;
      //   109: bipush #8
      //   111: invokevirtual setVisibility : (I)V
      //   114: aload_0
      //   115: getfield p : Landroid/widget/ImageView;
      //   118: new com/blued/android/module/media/selector/adapter/AlbumBaseAdapter$ViewHolder$1
      //   121: dup
      //   122: aload_0
      //   123: iload_2
      //   124: aload_1
      //   125: invokespecial <init> : (Lcom/blued/android/module/media/selector/adapter/AlbumBaseAdapter$ViewHolder;ILcom/blued/android/module/player/media/model/MediaInfo;)V
      //   128: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
      //   131: aload_0
      //   132: getfield u : Lcom/blued/android/module/media/selector/adapter/AlbumBaseAdapter;
      //   135: invokestatic a : (Lcom/blued/android/module/media/selector/adapter/AlbumBaseAdapter;)Lcom/blued/android/module/media/selector/contract/IAlbumBaseCallback;
      //   138: invokeinterface c : ()I
      //   143: istore #6
      //   145: iconst_1
      //   146: istore #5
      //   148: iload #5
      //   150: istore #4
      //   152: iload #8
      //   154: istore #7
      //   156: iload #6
      //   158: ifle -> 238
      //   161: aload_0
      //   162: getfield u : Lcom/blued/android/module/media/selector/adapter/AlbumBaseAdapter;
      //   165: invokestatic a : (Lcom/blued/android/module/media/selector/adapter/AlbumBaseAdapter;)Lcom/blued/android/module/media/selector/contract/IAlbumBaseCallback;
      //   168: invokeinterface d : ()Z
      //   173: ifeq -> 196
      //   176: aload_1
      //   177: getfield media_type : I
      //   180: invokestatic m : ()I
      //   183: if_icmpeq -> 206
      //   186: aload_1
      //   187: getfield isSelected : Z
      //   190: ifeq -> 206
      //   193: goto -> 231
      //   196: aload_1
      //   197: getfield media_type : I
      //   200: invokestatic m : ()I
      //   203: if_icmpne -> 216
      //   206: iconst_0
      //   207: istore #4
      //   209: iload #8
      //   211: istore #7
      //   213: goto -> 238
      //   216: iload #5
      //   218: istore #4
      //   220: iload #8
      //   222: istore #7
      //   224: aload_1
      //   225: getfield isSelected : Z
      //   228: ifeq -> 238
      //   231: iconst_1
      //   232: istore #7
      //   234: iload #5
      //   236: istore #4
      //   238: aload_0
      //   239: getfield r : Landroid/widget/RelativeLayout;
      //   242: astore #9
      //   244: iload #4
      //   246: ifeq -> 254
      //   249: fconst_1
      //   250: fstore_3
      //   251: goto -> 257
      //   254: ldc 0.5
      //   256: fstore_3
      //   257: aload #9
      //   259: fload_3
      //   260: invokevirtual setAlpha : (F)V
      //   263: aload_1
      //   264: getfield media_type : I
      //   267: invokestatic m : ()I
      //   270: if_icmpeq -> 299
      //   273: aload_0
      //   274: getfield q : Landroid/widget/ImageView;
      //   277: iload #7
      //   279: invokevirtual setSelected : (Z)V
      //   282: aload_0
      //   283: getfield q : Landroid/widget/ImageView;
      //   286: new com/blued/android/module/media/selector/adapter/AlbumBaseAdapter$ViewHolder$2
      //   289: dup
      //   290: aload_0
      //   291: aload_1
      //   292: iload_2
      //   293: invokespecial <init> : (Lcom/blued/android/module/media/selector/adapter/AlbumBaseAdapter$ViewHolder;Lcom/blued/android/module/player/media/model/MediaInfo;I)V
      //   296: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
      //   299: return
    }
  }
  
  class null implements View.OnClickListener {
    null(AlbumBaseAdapter this$0, int param1Int, MediaInfo param1MediaInfo) {}
    
    public void onClick(View param1View) {
      AlbumBaseAdapter.a(this.c.u).a(this.a, this.b);
    }
  }
  
  class null implements View.OnClickListener {
    null(AlbumBaseAdapter this$0, MediaInfo param1MediaInfo, int param1Int) {}
    
    public void onClick(View param1View) {
      if (this.a.isSelected) {
        this.a.isSelected = false;
        boolean bool = AlbumBaseAdapter.a(this.c.u).d();
        if (AlbumBaseAdapter.a(this.c.u).a(this.a) == 0 || bool) {
          this.c.u.notifyDataSetChanged();
          return;
        } 
        this.c.u.notifyItemChanged(this.b);
        return;
      } 
      if (AlbumBaseAdapter.a(this.c.u).a(this.a, this.b)) {
        ViewUtils.a((View)this.c.q);
        this.a.isSelected = true;
        if (AlbumBaseAdapter.a(this.c.u).d() || AlbumBaseAdapter.a(this.c.u).c() == 1) {
          this.c.u.notifyDataSetChanged();
          return;
        } 
        this.c.u.notifyItemChanged(this.b);
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\selector\adapter\AlbumBaseAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */