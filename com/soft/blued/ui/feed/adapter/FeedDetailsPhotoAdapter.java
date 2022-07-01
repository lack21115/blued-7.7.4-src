package com.soft.blued.ui.feed.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.das.client.feed.FeedProtos;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.model.LogData;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;

public class FeedDetailsPhotoAdapter extends BaseAdapter {
  private Context a;
  
  private IRequestHost b;
  
  private BluedIngSelfFeed c;
  
  private LoadOptions d;
  
  private View e;
  
  private String f;
  
  public FeedDetailsPhotoAdapter(Context paramContext, IRequestHost paramIRequestHost, BluedIngSelfFeed paramBluedIngSelfFeed, LoadOptions paramLoadOptions, View paramView, String paramString) {
    this.a = paramContext;
    this.b = paramIRequestHost;
    this.c = paramBluedIngSelfFeed;
    this.d = paramLoadOptions;
    this.e = paramView;
    this.f = paramString;
  }
  
  public int getCount() {
    return this.c.feed_pics.length;
  }
  
  public Object getItem(int paramInt) {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull -> 62
    //   4: aload_0
    //   5: getfield a : Landroid/content/Context;
    //   8: invokestatic from : (Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   11: ldc 2131493122
    //   13: aconst_null
    //   14: invokevirtual inflate : (ILandroid/view/ViewGroup;)Landroid/view/View;
    //   17: astore_2
    //   18: new com/soft/blued/ui/feed/adapter/FeedDetailsPhotoAdapter$ViewHolder
    //   21: dup
    //   22: aload_0
    //   23: aconst_null
    //   24: invokespecial <init> : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsPhotoAdapter;Lcom/soft/blued/ui/feed/adapter/FeedDetailsPhotoAdapter$1;)V
    //   27: astore_3
    //   28: aload_3
    //   29: aload_2
    //   30: ldc 2131299472
    //   32: invokevirtual findViewById : (I)Landroid/view/View;
    //   35: checkcast android/widget/ImageView
    //   38: putfield a : Landroid/widget/ImageView;
    //   41: aload_3
    //   42: aload_2
    //   43: ldc 2131300102
    //   45: invokevirtual findViewById : (I)Landroid/view/View;
    //   48: checkcast com/blued/android/framework/view/shape/ShapeTextView
    //   51: putfield b : Lcom/blued/android/framework/view/shape/ShapeTextView;
    //   54: aload_2
    //   55: aload_3
    //   56: invokevirtual setTag : (Ljava/lang/Object;)V
    //   59: goto -> 70
    //   62: aload_2
    //   63: invokevirtual getTag : ()Ljava/lang/Object;
    //   66: checkcast com/soft/blued/ui/feed/adapter/FeedDetailsPhotoAdapter$ViewHolder
    //   69: astore_3
    //   70: new com/blued/android/core/image/ImageOptions
    //   73: dup
    //   74: invokespecial <init> : ()V
    //   77: astore #9
    //   79: aload #9
    //   81: ldc 2131231369
    //   83: putfield c : I
    //   86: aload #9
    //   88: ldc 2131231369
    //   90: putfield a : I
    //   93: aload_0
    //   94: getfield c : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
    //   97: getfield feed_pics : [Ljava/lang/String;
    //   100: iload_1
    //   101: aaload
    //   102: astore #10
    //   104: aload_0
    //   105: getfield c : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
    //   108: getfield feed_pics : [Ljava/lang/String;
    //   111: iload_1
    //   112: aaload
    //   113: astore #8
    //   115: aload_0
    //   116: getfield c : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
    //   119: getfield feed_pics_width : [Ljava/lang/String;
    //   122: ifnull -> 196
    //   125: aload_0
    //   126: getfield c : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
    //   129: getfield feed_pics_width : [Ljava/lang/String;
    //   132: arraylength
    //   133: iload_1
    //   134: if_icmple -> 196
    //   137: aload_0
    //   138: getfield c : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
    //   141: getfield feed_pics_height : [Ljava/lang/String;
    //   144: ifnull -> 196
    //   147: aload_0
    //   148: getfield c : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
    //   151: getfield feed_pics_height : [Ljava/lang/String;
    //   154: arraylength
    //   155: iload_1
    //   156: if_icmple -> 196
    //   159: aload_0
    //   160: getfield c : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
    //   163: getfield feed_pics_width : [Ljava/lang/String;
    //   166: iload_1
    //   167: aaload
    //   168: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   171: invokevirtual intValue : ()I
    //   174: istore #6
    //   176: aload_0
    //   177: getfield c : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
    //   180: getfield feed_pics_height : [Ljava/lang/String;
    //   183: iload_1
    //   184: aaload
    //   185: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
    //   188: invokevirtual intValue : ()I
    //   191: istore #7
    //   193: goto -> 202
    //   196: iconst_0
    //   197: istore #6
    //   199: iconst_0
    //   200: istore #7
    //   202: iload #7
    //   204: iload #6
    //   206: iconst_3
    //   207: imul
    //   208: if_icmple -> 265
    //   211: aload_3
    //   212: getfield b : Lcom/blued/android/framework/view/shape/ShapeTextView;
    //   215: iconst_0
    //   216: invokevirtual setVisibility : (I)V
    //   219: aload_0
    //   220: getfield c : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
    //   223: iconst_1
    //   224: iload_1
    //   225: invokevirtual getImageMogr : (ZI)Ljava/lang/String;
    //   228: astore #11
    //   230: new java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial <init> : ()V
    //   237: astore #12
    //   239: aload #12
    //   241: aload #8
    //   243: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload #12
    //   249: aload #11
    //   251: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload #12
    //   257: invokevirtual toString : ()Ljava/lang/String;
    //   260: astore #8
    //   262: goto -> 274
    //   265: aload_3
    //   266: getfield b : Lcom/blued/android/framework/view/shape/ShapeTextView;
    //   269: bipush #8
    //   271: invokevirtual setVisibility : (I)V
    //   274: aload_0
    //   275: getfield c : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
    //   278: getfield face_point : [Ljava/lang/String;
    //   281: astore #11
    //   283: ldc -1.0
    //   285: fstore #5
    //   287: aload #11
    //   289: ifnull -> 354
    //   292: aload_0
    //   293: getfield c : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
    //   296: getfield face_point : [Ljava/lang/String;
    //   299: arraylength
    //   300: iload_1
    //   301: if_icmple -> 354
    //   304: aload_0
    //   305: getfield c : Lcom/soft/blued/ui/feed/model/BluedIngSelfFeed;
    //   308: getfield face_point : [Ljava/lang/String;
    //   311: iload_1
    //   312: aaload
    //   313: ldc ','
    //   315: invokevirtual split : (Ljava/lang/String;)[Ljava/lang/String;
    //   318: astore #11
    //   320: aload #11
    //   322: arraylength
    //   323: iconst_2
    //   324: if_icmpne -> 354
    //   327: aload #11
    //   329: iconst_0
    //   330: aaload
    //   331: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Float;
    //   334: invokevirtual floatValue : ()F
    //   337: fstore #5
    //   339: aload #11
    //   341: iconst_1
    //   342: aaload
    //   343: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Float;
    //   346: invokevirtual floatValue : ()F
    //   349: fstore #4
    //   351: goto -> 358
    //   354: ldc -1.0
    //   356: fstore #4
    //   358: aload_0
    //   359: getfield b : Lcom/blued/android/core/net/IRequestHost;
    //   362: aload #8
    //   364: invokestatic a : (Lcom/blued/android/core/net/IRequestHost;Ljava/lang/String;)Lcom/blued/android/core/image/ImageWrapper;
    //   367: aload #9
    //   369: invokevirtual a : (Lcom/blued/android/core/image/ImageOptions;)Lcom/blued/android/core/image/ImageWrapper;
    //   372: ldc 6.0
    //   374: invokevirtual a : (F)Lcom/blued/android/core/image/ImageWrapper;
    //   377: fload #5
    //   379: fload #4
    //   381: invokevirtual a : (FF)Lcom/blued/android/core/image/ImageWrapper;
    //   384: aload_3
    //   385: getfield a : Landroid/widget/ImageView;
    //   388: invokevirtual a : (Landroid/widget/ImageView;)V
    //   391: iload_1
    //   392: ifne -> 404
    //   395: aload_0
    //   396: getfield e : Landroid/view/View;
    //   399: aload #10
    //   401: invokevirtual setTag : (Ljava/lang/Object;)V
    //   404: aload_3
    //   405: getfield a : Landroid/widget/ImageView;
    //   408: new com/soft/blued/ui/feed/adapter/FeedDetailsPhotoAdapter$1
    //   411: dup
    //   412: aload_0
    //   413: iload_1
    //   414: aload_3
    //   415: aload #10
    //   417: invokespecial <init> : (Lcom/soft/blued/ui/feed/adapter/FeedDetailsPhotoAdapter;ILcom/soft/blued/ui/feed/adapter/FeedDetailsPhotoAdapter$ViewHolder;Ljava/lang/String;)V
    //   420: invokevirtual setOnClickListener : (Landroid/view/View$OnClickListener;)V
    //   423: aload_2
    //   424: areturn
  }
  
  class ViewHolder {
    ImageView a;
    
    ShapeTextView b;
    
    private ViewHolder(FeedDetailsPhotoAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\adapter\FeedDetailsPhotoAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */