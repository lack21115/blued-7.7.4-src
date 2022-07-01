package com.soft.blued.ui.video.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.utils.Log;
import com.blued.android.module.media.selector.contract.IAlbumBaseCallback;
import com.blued.android.module.media.selector.utils.ViewUtils;
import com.blued.android.module.player.media.model.MediaInfo;

public class AlbumSelectHalfAdapter extends RecyclerView.Adapter<AlbumSelectHalfAdapter.ViewHolder> {
  private static final String a = AlbumSelectHalfAdapter.class.getSimpleName();
  
  private IAlbumBaseCallback b;
  
  public AlbumSelectHalfAdapter(IAlbumBaseCallback paramIAlbumBaseCallback) {
    this.b = paramIAlbumBaseCallback;
  }
  
  public ViewHolder a(ViewGroup paramViewGroup, int paramInt) {
    Log.c("", "onCreateViewHolder");
    return new ViewHolder(this, LayoutInflater.from(this.b.a()).inflate(2131494108, null));
  }
  
  public void a(ViewHolder paramViewHolder, int paramInt) {
    paramViewHolder.a(this.b.a(paramInt), paramInt);
  }
  
  public int getItemCount() {
    return this.b.b();
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public class ViewHolder extends RecyclerView.ViewHolder {
    public ImageView p;
    
    public ImageView q;
    
    public RelativeLayout r;
    
    public RelativeLayout s;
    
    public TextView t;
    
    public ViewHolder(AlbumSelectHalfAdapter this$0, View param1View) {
      super(param1View);
      this.r = (RelativeLayout)param1View.findViewById(2131301735);
      this.p = (ImageView)param1View.findViewById(2131301734);
      this.q = (ImageView)param1View.findViewById(2131301736);
      this.s = (RelativeLayout)param1View.findViewById(2131301740);
      this.t = (TextView)param1View.findViewById(2131301493);
    }
    
    public void a(MediaInfo param1MediaInfo, int param1Int) {
      // Byte code:
      //   0: aload_1
      //   1: ifnull -> 297
      //   4: new com/blued/android/core/imagecache/LoadOptions
      //   7: dup
      //   8: invokespecial <init> : ()V
      //   11: astore #9
      //   13: aload #9
      //   15: ldc 2131231369
      //   17: putfield d : I
      //   20: aload #9
      //   22: ldc 2131231369
      //   24: putfield b : I
      //   27: invokestatic a : ()Lcom/blued/android/module/media/selector/utils/ThumbLoader;
      //   30: aload_1
      //   31: aload_0
      //   32: getfield p : Landroid/widget/ImageView;
      //   35: aload #9
      //   37: invokevirtual a : (Lcom/blued/android/module/player/media/model/MediaInfo;Landroid/widget/ImageView;Lcom/blued/android/core/imagecache/LoadOptions;)V
      //   40: aload_1
      //   41: getfield media_type : I
      //   44: istore #4
      //   46: invokestatic m : ()I
      //   49: istore #5
      //   51: iconst_0
      //   52: istore #8
      //   54: iload #4
      //   56: iload #5
      //   58: if_icmpne -> 95
      //   61: aload_0
      //   62: getfield q : Landroid/widget/ImageView;
      //   65: bipush #8
      //   67: invokevirtual setVisibility : (I)V
      //   70: aload_0
      //   71: getfield s : Landroid/widget/RelativeLayout;
      //   74: iconst_0
      //   75: invokevirtual setVisibility : (I)V
      //   78: aload_0
      //   79: getfield t : Landroid/widget/TextView;
      //   82: aload_1
      //   83: getfield videoTime : J
      //   86: invokestatic a : (J)Ljava/lang/String;
      //   89: invokevirtual setText : (Ljava/lang/CharSequence;)V
      //   92: goto -> 112
      //   95: aload_0
      //   96: getfield q : Landroid/widget/ImageView;
      //   99: iconst_0
      //   100: invokevirtual setVisibility : (I)V
      //   103: aload_0
      //   104: getfield s : Landroid/widget/RelativeLayout;
      //   107: bipush #8
      //   109: invokevirtual setVisibility : (I)V
      //   112: aload_0
      //   113: getfield p : Landroid/widget/ImageView;
      //   116: new com/soft/blued/ui/video/adapter/AlbumSelectHalfAdapter$ViewHolder$1
      //   119: dup
      //   120: aload_0
      //   121: iload_2
      //   122: aload_1
      //   123: invokespecial <init> : (Lcom/soft/blued/ui/video/adapter/AlbumSelectHalfAdapter$ViewHolder;ILcom/blued/android/module/player/media/model/MediaInfo;)V
      //   126: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
      //   129: aload_0
      //   130: getfield u : Lcom/soft/blued/ui/video/adapter/AlbumSelectHalfAdapter;
      //   133: invokestatic a : (Lcom/soft/blued/ui/video/adapter/AlbumSelectHalfAdapter;)Lcom/blued/android/module/media/selector/contract/IAlbumBaseCallback;
      //   136: invokeinterface c : ()I
      //   141: istore #6
      //   143: iconst_1
      //   144: istore #5
      //   146: iload #5
      //   148: istore #4
      //   150: iload #8
      //   152: istore #7
      //   154: iload #6
      //   156: ifle -> 236
      //   159: aload_0
      //   160: getfield u : Lcom/soft/blued/ui/video/adapter/AlbumSelectHalfAdapter;
      //   163: invokestatic a : (Lcom/soft/blued/ui/video/adapter/AlbumSelectHalfAdapter;)Lcom/blued/android/module/media/selector/contract/IAlbumBaseCallback;
      //   166: invokeinterface d : ()Z
      //   171: ifeq -> 194
      //   174: aload_1
      //   175: getfield media_type : I
      //   178: invokestatic m : ()I
      //   181: if_icmpeq -> 204
      //   184: aload_1
      //   185: getfield isSelected : Z
      //   188: ifeq -> 204
      //   191: goto -> 229
      //   194: aload_1
      //   195: getfield media_type : I
      //   198: invokestatic m : ()I
      //   201: if_icmpne -> 214
      //   204: iconst_0
      //   205: istore #4
      //   207: iload #8
      //   209: istore #7
      //   211: goto -> 236
      //   214: iload #5
      //   216: istore #4
      //   218: iload #8
      //   220: istore #7
      //   222: aload_1
      //   223: getfield isSelected : Z
      //   226: ifeq -> 236
      //   229: iconst_1
      //   230: istore #7
      //   232: iload #5
      //   234: istore #4
      //   236: aload_0
      //   237: getfield r : Landroid/widget/RelativeLayout;
      //   240: astore #9
      //   242: iload #4
      //   244: ifeq -> 252
      //   247: fconst_1
      //   248: fstore_3
      //   249: goto -> 255
      //   252: ldc 0.5
      //   254: fstore_3
      //   255: aload #9
      //   257: fload_3
      //   258: invokevirtual setAlpha : (F)V
      //   261: aload_1
      //   262: getfield media_type : I
      //   265: invokestatic m : ()I
      //   268: if_icmpeq -> 297
      //   271: aload_0
      //   272: getfield q : Landroid/widget/ImageView;
      //   275: iload #7
      //   277: invokevirtual setSelected : (Z)V
      //   280: aload_0
      //   281: getfield q : Landroid/widget/ImageView;
      //   284: new com/soft/blued/ui/video/adapter/AlbumSelectHalfAdapter$ViewHolder$2
      //   287: dup
      //   288: aload_0
      //   289: aload_1
      //   290: iload_2
      //   291: invokespecial <init> : (Lcom/soft/blued/ui/video/adapter/AlbumSelectHalfAdapter$ViewHolder;Lcom/blued/android/module/player/media/model/MediaInfo;I)V
      //   294: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
      //   297: return
    }
  }
  
  class null implements View.OnClickListener {
    null(AlbumSelectHalfAdapter this$0, int param1Int, MediaInfo param1MediaInfo) {}
    
    public void onClick(View param1View) {
      AlbumSelectHalfAdapter.a(this.c.u).a(this.a, this.b);
    }
  }
  
  class null implements View.OnClickListener {
    null(AlbumSelectHalfAdapter this$0, MediaInfo param1MediaInfo, int param1Int) {}
    
    public void onClick(View param1View) {
      if (this.a.isSelected) {
        this.a.isSelected = false;
        boolean bool = AlbumSelectHalfAdapter.a(this.c.u).d();
        if (AlbumSelectHalfAdapter.a(this.c.u).a(this.a) == 0 || bool) {
          this.c.u.notifyDataSetChanged();
          return;
        } 
        this.c.u.notifyItemChanged(this.b);
        return;
      } 
      if (AlbumSelectHalfAdapter.a(this.c.u).a(this.a, this.b)) {
        ViewUtils.a((View)this.c.q);
        this.a.isSelected = true;
        if (AlbumSelectHalfAdapter.a(this.c.u).d() || AlbumSelectHalfAdapter.a(this.c.u).c() == 1) {
          this.c.u.notifyDataSetChanged();
          return;
        } 
        this.c.u.notifyItemChanged(this.b);
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\adapter\AlbumSelectHalfAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */