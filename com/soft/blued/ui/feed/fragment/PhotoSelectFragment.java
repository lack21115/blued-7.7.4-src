package com.soft.blued.ui.feed.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.imagecache.ImageLoadEngine;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.FileUtils;
import com.blued.android.framework.utils.Houyi;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.view.PauseOnScrollListener;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.constant.PhotoConstants;
import com.soft.blued.customview.PopMenu;
import com.soft.blued.ui.feed.manager.ChildPhotoManager;
import com.soft.blued.ui.feed.manager.SelectPhotoManager;
import com.soft.blued.ui.feed.model.ChildImageInfo;
import com.soft.blued.ui.feed.model.GroupImageInfo;
import com.soft.blued.ui.msg.ChatBgPicturePreFragment;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.CameraUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PhotoSelectFragment extends BaseFragment implements LoaderManager.LoaderCallbacks<Cursor>, MemoryRequest.MemoryListener {
  public static List<ChildImageInfo> d = new ArrayList<ChildImageInfo>();
  
  private String A;
  
  private String B;
  
  private boolean C = false;
  
  private PauseOnScrollListener D;
  
  private LoaderManager E;
  
  private boolean F = false;
  
  private String G;
  
  String e = "http://a.hiphotos.baidu.com/image/pic/item/86d6277f9e2f070818f2fa06ea24b899a801f2c5.jpg";
  
  private Context f;
  
  private View g;
  
  private View h;
  
  private TextView i;
  
  private ImageView j;
  
  private ImageView k;
  
  private ImageView l;
  
  private LayoutInflater m;
  
  private LinkedHashMap<String, List<ChildImageInfo>> n = new LinkedHashMap<String, List<ChildImageInfo>>();
  
  private List<GroupImageInfo> o = new ArrayList<GroupImageInfo>();
  
  private Dialog p;
  
  private GridView q;
  
  private FeedPhotoAdapter r;
  
  private SinglePhotoAdapter s;
  
  private TextView t;
  
  private TextView u;
  
  private TextView v;
  
  private LinearLayout w;
  
  private PopMenu x;
  
  private PopAdapter y;
  
  private int z = 0;
  
  private List<GroupImageInfo> a(LinkedHashMap<String, List<ChildImageInfo>> paramLinkedHashMap) {
    if (paramLinkedHashMap.size() == 0)
      return null; 
    ArrayList<GroupImageInfo> arrayList = new ArrayList();
    for (Map.Entry<String, List<ChildImageInfo>> entry : paramLinkedHashMap.entrySet()) {
      GroupImageInfo groupImageInfo = new GroupImageInfo();
      String str = (String)entry.getKey();
      List<?> list = (List)entry.getValue();
      Collections.reverse(list);
      groupImageInfo.setFolderName(str);
      groupImageInfo.setImageCounts(list.size());
      if (list.size() > 0) {
        groupImageInfo.setTopImagePath(((ChildImageInfo)list.get(0)).mImagePath);
        groupImageInfo.topImgUri = ((ChildImageInfo)list.get(0)).imgUri;
      } 
      ChildImageInfo childImageInfo = new ChildImageInfo();
      childImageInfo.mTakePhoto = true;
      list.add(0, childImageInfo);
      arrayList.add(groupImageInfo);
    } 
    return arrayList;
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean) {
    Bundle bundle = new Bundle();
    bundle.putInt("select_photo", paramInt1);
    bundle.putBoolean("IF_JUMP_TO_SHOOT", paramBoolean);
    TerminalActivity.a(paramContext, PhotoSelectFragment.class, bundle, paramInt2);
  }
  
  private void a(ImageView paramImageView) {
    ScaleAnimation scaleAnimation1 = new ScaleAnimation(1.0F, 1.1F, 1.0F, 1.1F, 1, 0.5F, 1, 0.5F);
    scaleAnimation1.setDuration(200L);
    ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.5F, 1.1F, 0.5F, 1.1F, 1, 0.5F, 1, 0.5F);
    scaleAnimation2.setDuration(100L);
    ScaleAnimation scaleAnimation3 = new ScaleAnimation(1.1F, 1.0F, 1.1F, 1.0F, 1, 0.5F, 1, 0.5F);
    scaleAnimation3.setDuration(50L);
    scaleAnimation1.setAnimationListener(new Animation.AnimationListener(this, paramImageView, scaleAnimation2) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.setImageResource(2131233514);
            this.a.startAnimation((Animation)this.b);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    scaleAnimation2.setAnimationListener(new Animation.AnimationListener(this, paramImageView, scaleAnimation3) {
          public void onAnimationEnd(Animation param1Animation) {
            this.a.startAnimation((Animation)this.b);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    paramImageView.startAnimation((Animation)scaleAnimation1);
  }
  
  public static void a(BaseFragment paramBaseFragment, int paramInt1, int paramInt2) {
    Bundle bundle = new Bundle();
    bundle.putInt("select_photo", paramInt1);
    TerminalActivity.a((Fragment)paramBaseFragment, PhotoSelectFragment.class, bundle, paramInt2);
  }
  
  public static void a(BaseFragment paramBaseFragment, int paramInt1, int paramInt2, boolean paramBoolean) {
    Bundle bundle = new Bundle();
    bundle.putInt("select_photo", paramInt1);
    bundle.putBoolean("IF_JUMP_TO_SHOOT", paramBoolean);
    TerminalActivity.a((Fragment)paramBaseFragment, PhotoSelectFragment.class, bundle, paramInt2);
  }
  
  private void l() {
    this.C = AppUtils.b();
    this.E = LoaderManager.getInstance((LifecycleOwner)this);
    this.E.initLoader(100, null, this);
    this.D = new PauseOnScrollListener(false, true);
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.z = bundle.getInt("select_photo");
      this.A = bundle.getString("msg_path");
      this.F = bundle.getBoolean("IF_JUMP_TO_SHOOT");
    } 
    int i = this.z;
    if (i != 5) {
      if (i != 7) {
        PhotoConstants.CONFIG.a = 9;
        return;
      } 
      PhotoConstants.CONFIG.a = 6;
      d.addAll(SelectPhotoManager.a().c());
      SelectPhotoManager.a().d();
      return;
    } 
    PhotoConstants.CONFIG.a = 9;
    d.addAll(SelectPhotoManager.a().c());
    SelectPhotoManager.a().d();
  }
  
  private void m() {
    this.m = LayoutInflater.from(this.f);
    this.q = (GridView)this.g.findViewById(2131297262);
    this.p = DialogUtils.a(this.f);
    this.t = (TextView)this.g.findViewById(2131299509);
    this.u = (TextView)this.g.findViewById(2131299407);
    this.v = (TextView)this.g.findViewById(2131299383);
    this.w = (LinearLayout)this.g.findViewById(2131296557);
    int i = this.z;
    if (i != 5) {
      if (i != 7) {
        if (i != 10 && i != 11) {
          this.s = new SinglePhotoAdapter(this);
          this.w.setVisibility(8);
        } else {
          this.r = new FeedPhotoAdapter(this);
        } 
      } else {
        this.r = new FeedPhotoAdapter(this);
      } 
    } else {
      this.r = new FeedPhotoAdapter(this);
      if (SelectPhotoManager.a().b() > 0) {
        q();
      } else {
        r();
      } 
    } 
    this.v.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            int i = PhotoSelectFragment.a(this.a);
            if (i == 5 || i == 7)
              SelectPhotoManager.a().c().addAll(0, PhotoSelectFragment.d); 
            for (ChildImageInfo childImageInfo : SelectPhotoManager.a().c()) {
              if (PhotoSelectFragment.b(this.a) && !TextUtils.isEmpty(childImageInfo.imgUri) && !AppUtils.b(childImageInfo.mImagePath)) {
                String str = RecyclingUtils.e("photo");
                boolean bool = FileUtils.a(childImageInfo.imgUri, str);
                childImageInfo.mImagePath = str;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("SaveSelectPhoto: ");
                stringBuilder.append(str);
                stringBuilder.append(" ");
                stringBuilder.append(bool);
                LogUtils.c(stringBuilder.toString());
              } 
            } 
            this.a.getActivity().finish();
            i = PhotoSelectFragment.a(this.a);
            if (i != 5 && i != 7)
              FeedPostFragment.a(PhotoSelectFragment.c(this.a)); 
            PhotosRefreshObserver.a().b();
          }
        });
    this.t.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (SelectPhotoManager.a().b() > 0) {
              PhotoSelectFragment photoSelectFragment = this.a;
              PhotoSelectedPagerFragment.a(photoSelectFragment, 0, PhotoSelectFragment.a(photoSelectFragment));
            } 
          }
        });
    this.q.setOnScrollListener(new AbsListView.OnScrollListener(this) {
          public void onScroll(AbsListView param1AbsListView, int param1Int1, int param1Int2, int param1Int3) {}
          
          public void onScrollStateChanged(AbsListView param1AbsListView, int param1Int) {
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
        });
  }
  
  private void n() {
    ListView listView = new ListView(this.f);
    listView.setDivider(null);
    this.y = new PopAdapter(this);
    listView.setAdapter((ListAdapter)this.y);
    this.x = new PopMenu(this.f, (View)listView);
  }
  
  private void o() {
    this.h = this.g.findViewById(2131300273);
    this.j = (ImageView)this.h.findViewById(2131296863);
    this.j.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            int i = PhotoSelectFragment.a(this.a);
            if (i != 5) {
              if (i != 7) {
                SelectPhotoManager.a().d();
              } else {
                SelectPhotoManager.a().d();
                SelectPhotoManager.a().c().addAll(PhotoSelectFragment.d);
              } 
            } else {
              SelectPhotoManager.a().d();
              SelectPhotoManager.a().c().addAll(PhotoSelectFragment.d);
            } 
            PhotosRefreshObserver.a().b();
            this.a.getActivity().finish();
          }
        });
    this.i = (TextView)this.h.findViewById(2131296857);
    this.k = (ImageView)this.h.findViewById(2131296867);
    this.l = (ImageView)this.h.findViewById(2131296860);
    this.k.setVisibility(4);
    this.i.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            PhotoSelectFragment.e(this.a).a(PhotoSelectFragment.d(this.a));
            PhotoSelectFragment.f(this.a).setImageDrawable(BluedSkinUtils.b(PhotoSelectFragment.c(this.a), 2131233085));
          }
        });
    this.l.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            PhotoSelectFragment.e(this.a).a(PhotoSelectFragment.d(this.a));
            PhotoSelectFragment.f(this.a).setImageDrawable(BluedSkinUtils.b(PhotoSelectFragment.c(this.a), 2131233085));
          }
        });
    this.x.a(new PopupWindow.OnDismissListener(this) {
          public void onDismiss() {
            PhotoSelectFragment.f(this.a).setImageDrawable(BluedSkinUtils.b(PhotoSelectFragment.c(this.a), 2131233084));
          }
        });
  }
  
  private void p() {
    if (SelectPhotoManager.a().b() + d.size() < PhotoConstants.CONFIG.a) {
      int i = this.z;
      if (i != 5) {
        if (i != 7) {
          if (i != 10 && i != 11) {
            s();
            return;
          } 
          TakePhotoFragment.a(this, 2, this.z, this.B);
          return;
        } 
        TakePhotoFragment.a(this, 2, i, null);
        return;
      } 
      TakePhotoFragment.a(this, 2, i, null);
      return;
    } 
    AppMethods.a(String.format(getResources().getString(2131757865), new Object[] { Integer.valueOf(PhotoConstants.CONFIG.a) }));
  }
  
  private void q() {
    this.u.setVisibility(0);
    this.t.setTextColor(getResources().getColor(2131100323));
    TextView textView = this.u;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(SelectPhotoManager.a().b());
    stringBuilder.append("");
    textView.setText(stringBuilder.toString());
    this.v.setText(getString(2131758381));
  }
  
  private void r() {
    this.u.setVisibility(8);
    this.t.setTextColor(getResources().getColor(2131100322));
    this.v.setText(getString(2131756447));
  }
  
  private void s() {
    this.G = CameraUtils.a((Fragment)this);
  }
  
  private void t() {
    FeedPhotoAdapter feedPhotoAdapter = this.r;
    if (feedPhotoAdapter != null)
      feedPhotoAdapter.notifyDataSetChanged(); 
    if (SelectPhotoManager.a().b() > 0) {
      q();
      return;
    } 
    r();
  }
  
  public boolean V_() {
    getActivity().setResult(-1);
    int i = this.z;
    if (i != 5) {
      if (i != 7) {
        SelectPhotoManager.a().d();
      } else {
        SelectPhotoManager.a().d();
        SelectPhotoManager.a().c().addAll(d);
      } 
    } else {
      SelectPhotoManager.a().d();
      SelectPhotoManager.a().c().addAll(d);
    } 
    return false;
  }
  
  public void a() {}
  
  public void a(Dialog paramDialog) {
    if (paramDialog != null && !paramDialog.isShowing())
      paramDialog.show(); 
  }
  
  public void a(Loader<Cursor> paramLoader, Cursor paramCursor) {
    // Byte code:
    //   0: aload_0
    //   1: getfield n : Ljava/util/LinkedHashMap;
    //   4: invokevirtual clear : ()V
    //   7: ldc_w 'onLoadFinished start'
    //   10: invokestatic c : (Ljava/lang/String;)I
    //   13: pop
    //   14: aload_2
    //   15: ifnull -> 306
    //   18: new java/util/ArrayList
    //   21: dup
    //   22: invokespecial <init> : ()V
    //   25: astore_1
    //   26: aload_0
    //   27: getfield n : Ljava/util/LinkedHashMap;
    //   30: aload_0
    //   31: getfield f : Landroid/content/Context;
    //   34: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   37: ldc_w 2131755284
    //   40: invokevirtual getString : (I)Ljava/lang/String;
    //   43: aload_1
    //   44: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   47: pop
    //   48: aload_2
    //   49: invokeinterface moveToNext : ()Z
    //   54: ifeq -> 306
    //   57: aload_2
    //   58: aload_2
    //   59: ldc_w '_data'
    //   62: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   67: invokeinterface getString : (I)Ljava/lang/String;
    //   72: astore_1
    //   73: goto -> 85
    //   76: astore_1
    //   77: aload_1
    //   78: invokevirtual printStackTrace : ()V
    //   81: ldc_w ''
    //   84: astore_1
    //   85: aload_2
    //   86: aload_2
    //   87: ldc_w '_id'
    //   90: invokeinterface getColumnIndexOrThrow : (Ljava/lang/String;)I
    //   95: invokeinterface getLong : (I)J
    //   100: lstore #4
    //   102: new java/io/File
    //   105: dup
    //   106: aload_1
    //   107: invokespecial <init> : (Ljava/lang/String;)V
    //   110: invokevirtual getParentFile : ()Ljava/io/File;
    //   113: invokevirtual getName : ()Ljava/lang/String;
    //   116: astore #6
    //   118: new com/soft/blued/ui/feed/model/ChildImageInfo
    //   121: dup
    //   122: invokespecial <init> : ()V
    //   125: astore #7
    //   127: aload_0
    //   128: getfield C : Z
    //   131: ifeq -> 169
    //   134: aload_1
    //   135: invokestatic b : (Ljava/lang/String;)Z
    //   138: ifne -> 169
    //   141: aload #7
    //   143: getstatic android/provider/MediaStore$Images$Media.EXTERNAL_CONTENT_URI : Landroid/net/Uri;
    //   146: lload #4
    //   148: invokestatic valueOf : (J)Ljava/lang/String;
    //   151: invokestatic withAppendedPath : (Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   154: invokevirtual toString : ()Ljava/lang/String;
    //   157: putfield imgUri : Ljava/lang/String;
    //   160: aload #7
    //   162: aload_1
    //   163: putfield mImagePath : Ljava/lang/String;
    //   166: goto -> 175
    //   169: aload #7
    //   171: aload_1
    //   172: putfield mImagePath : Ljava/lang/String;
    //   175: aload_0
    //   176: getfield n : Ljava/util/LinkedHashMap;
    //   179: aload #6
    //   181: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   184: ifne -> 249
    //   187: new java/util/ArrayList
    //   190: dup
    //   191: invokespecial <init> : ()V
    //   194: astore_1
    //   195: aload_1
    //   196: aload #7
    //   198: invokeinterface add : (Ljava/lang/Object;)Z
    //   203: pop
    //   204: aload_0
    //   205: getfield n : Ljava/util/LinkedHashMap;
    //   208: aload #6
    //   210: aload_1
    //   211: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   214: pop
    //   215: aload_0
    //   216: getfield n : Ljava/util/LinkedHashMap;
    //   219: aload_0
    //   220: getfield f : Landroid/content/Context;
    //   223: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   226: ldc_w 2131755284
    //   229: invokevirtual getString : (I)Ljava/lang/String;
    //   232: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   235: checkcast java/util/List
    //   238: aload #7
    //   240: invokeinterface add : (Ljava/lang/Object;)Z
    //   245: pop
    //   246: goto -> 48
    //   249: aload_0
    //   250: getfield n : Ljava/util/LinkedHashMap;
    //   253: aload #6
    //   255: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   258: checkcast java/util/List
    //   261: aload #7
    //   263: invokeinterface add : (Ljava/lang/Object;)Z
    //   268: pop
    //   269: aload_0
    //   270: getfield n : Ljava/util/LinkedHashMap;
    //   273: aload_0
    //   274: getfield f : Landroid/content/Context;
    //   277: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   280: ldc_w 2131755284
    //   283: invokevirtual getString : (I)Ljava/lang/String;
    //   286: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   289: checkcast java/util/List
    //   292: aload #7
    //   294: invokeinterface add : (Ljava/lang/Object;)Z
    //   299: pop
    //   300: goto -> 48
    //   303: goto -> 48
    //   306: ldc_w 'onLoadFinished end'
    //   309: invokestatic c : (Ljava/lang/String;)I
    //   312: pop
    //   313: aload_0
    //   314: aload_0
    //   315: aload_0
    //   316: getfield n : Ljava/util/LinkedHashMap;
    //   319: invokespecial a : (Ljava/util/LinkedHashMap;)Ljava/util/List;
    //   322: putfield o : Ljava/util/List;
    //   325: aload_0
    //   326: getfield o : Ljava/util/List;
    //   329: astore_1
    //   330: aload_1
    //   331: ifnull -> 448
    //   334: aload_1
    //   335: invokeinterface size : ()I
    //   340: ifle -> 448
    //   343: invokestatic aR : ()Ljava/lang/String;
    //   346: astore_1
    //   347: aload_0
    //   348: getfield n : Ljava/util/LinkedHashMap;
    //   351: aload_1
    //   352: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   355: checkcast java/util/List
    //   358: astore_2
    //   359: aload_2
    //   360: ifnull -> 390
    //   363: aload_2
    //   364: invokeinterface size : ()I
    //   369: ifle -> 390
    //   372: aload_0
    //   373: getfield i : Landroid/widget/TextView;
    //   376: aload_1
    //   377: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   380: invokestatic a : ()Lcom/soft/blued/ui/feed/manager/ChildPhotoManager;
    //   383: aload_2
    //   384: invokevirtual a : (Ljava/util/List;)V
    //   387: goto -> 517
    //   390: aload_0
    //   391: getfield i : Landroid/widget/TextView;
    //   394: aload_0
    //   395: getfield o : Ljava/util/List;
    //   398: iconst_0
    //   399: invokeinterface get : (I)Ljava/lang/Object;
    //   404: checkcast com/soft/blued/ui/feed/model/GroupImageInfo
    //   407: invokevirtual getFolderName : ()Ljava/lang/String;
    //   410: invokevirtual setText : (Ljava/lang/CharSequence;)V
    //   413: invokestatic a : ()Lcom/soft/blued/ui/feed/manager/ChildPhotoManager;
    //   416: aload_0
    //   417: getfield n : Ljava/util/LinkedHashMap;
    //   420: aload_0
    //   421: getfield o : Ljava/util/List;
    //   424: iconst_0
    //   425: invokeinterface get : (I)Ljava/lang/Object;
    //   430: checkcast com/soft/blued/ui/feed/model/GroupImageInfo
    //   433: invokevirtual getFolderName : ()Ljava/lang/String;
    //   436: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   439: checkcast java/util/List
    //   442: invokevirtual a : (Ljava/util/List;)V
    //   445: goto -> 517
    //   448: new java/util/ArrayList
    //   451: dup
    //   452: invokespecial <init> : ()V
    //   455: astore_1
    //   456: new com/soft/blued/ui/feed/model/ChildImageInfo
    //   459: dup
    //   460: invokespecial <init> : ()V
    //   463: astore_2
    //   464: aload_2
    //   465: iconst_1
    //   466: putfield mTakePhoto : Z
    //   469: aload_1
    //   470: aload_2
    //   471: invokeinterface add : (Ljava/lang/Object;)Z
    //   476: pop
    //   477: aload_0
    //   478: getfield n : Ljava/util/LinkedHashMap;
    //   481: ldc_w 'nophoto'
    //   484: aload_1
    //   485: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   488: pop
    //   489: invokestatic a : ()Lcom/soft/blued/ui/feed/manager/ChildPhotoManager;
    //   492: aload_0
    //   493: getfield n : Ljava/util/LinkedHashMap;
    //   496: ldc_w 'nophoto'
    //   499: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   502: checkcast java/util/List
    //   505: invokevirtual a : (Ljava/util/List;)V
    //   508: aload_0
    //   509: getfield l : Landroid/widget/ImageView;
    //   512: bipush #8
    //   514: invokevirtual setVisibility : (I)V
    //   517: aload_0
    //   518: getfield z : I
    //   521: istore_3
    //   522: iload_3
    //   523: iconst_5
    //   524: if_icmpeq -> 587
    //   527: iload_3
    //   528: bipush #7
    //   530: if_icmpeq -> 573
    //   533: iload_3
    //   534: bipush #10
    //   536: if_icmpeq -> 559
    //   539: iload_3
    //   540: bipush #11
    //   542: if_icmpeq -> 559
    //   545: aload_0
    //   546: getfield q : Landroid/widget/GridView;
    //   549: aload_0
    //   550: getfield s : Lcom/soft/blued/ui/feed/fragment/PhotoSelectFragment$SinglePhotoAdapter;
    //   553: invokevirtual setAdapter : (Landroid/widget/ListAdapter;)V
    //   556: goto -> 598
    //   559: aload_0
    //   560: getfield q : Landroid/widget/GridView;
    //   563: aload_0
    //   564: getfield r : Lcom/soft/blued/ui/feed/fragment/PhotoSelectFragment$FeedPhotoAdapter;
    //   567: invokevirtual setAdapter : (Landroid/widget/ListAdapter;)V
    //   570: goto -> 598
    //   573: aload_0
    //   574: getfield q : Landroid/widget/GridView;
    //   577: aload_0
    //   578: getfield r : Lcom/soft/blued/ui/feed/fragment/PhotoSelectFragment$FeedPhotoAdapter;
    //   581: invokevirtual setAdapter : (Landroid/widget/ListAdapter;)V
    //   584: goto -> 598
    //   587: aload_0
    //   588: getfield q : Landroid/widget/GridView;
    //   591: aload_0
    //   592: getfield r : Lcom/soft/blued/ui/feed/fragment/PhotoSelectFragment$FeedPhotoAdapter;
    //   595: invokevirtual setAdapter : (Landroid/widget/ListAdapter;)V
    //   598: aload_0
    //   599: getfield y : Lcom/soft/blued/ui/feed/fragment/PhotoSelectFragment$PopAdapter;
    //   602: astore_1
    //   603: aload_1
    //   604: ifnull -> 611
    //   607: aload_1
    //   608: invokevirtual notifyDataSetChanged : ()V
    //   611: aload_0
    //   612: aload_0
    //   613: getfield p : Landroid/app/Dialog;
    //   616: invokevirtual b : (Landroid/app/Dialog;)V
    //   619: aload_0
    //   620: getfield E : Landroidx/loader/app/LoaderManager;
    //   623: bipush #100
    //   625: invokevirtual getLoader : (I)Landroidx/loader/content/Loader;
    //   628: ifnull -> 640
    //   631: aload_0
    //   632: getfield E : Landroidx/loader/app/LoaderManager;
    //   635: bipush #100
    //   637: invokevirtual destroyLoader : (I)V
    //   640: return
    //   641: astore_1
    //   642: goto -> 303
    // Exception table:
    //   from	to	target	type
    //   57	73	76	java/lang/Exception
    //   102	118	641	java/lang/Exception
  }
  
  public void b(Dialog paramDialog) {
    if (paramDialog != null && paramDialog.isShowing())
      paramDialog.cancel(); 
  }
  
  protected void finalize() throws Throwable {
    super.finalize();
  }
  
  public void k() {
    LinkedHashMap<String, List<ChildImageInfo>> linkedHashMap = this.n;
    if (linkedHashMap != null && linkedHashMap.size() > 0)
      this.n.clear(); 
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == 0) {
      if (paramInt1 == 22) {
        if (paramIntent != null && paramIntent.getBooleanExtra("finish", false))
          getActivity().finish(); 
        return;
      } 
      if (this.F)
        getActivity().finish(); 
      t();
      return;
    } 
    if (paramInt1 != 0) {
      if (paramInt1 != 1) {
        if (paramInt1 != 2) {
          if (paramInt1 != 22) {
            if (paramInt1 == 24) {
              getActivity().setResult(-1, paramIntent);
              getActivity().finish();
            } 
          } else if (paramIntent != null) {
            getActivity().setResult(-1, paramIntent);
            getActivity().finish();
          } 
        } else {
          getActivity().finish();
        } 
      } else if (paramIntent != null) {
        int i = paramIntent.getIntExtra("page_state", 0);
        if (i == 0) {
          t();
        } else if (i == 1) {
          getActivity().finish();
        } 
      } 
    } else {
      int i = this.z;
      if (i != 6) {
        if (i != 14) {
          String str;
          List<ChildImageInfo> list1;
          Intent intent;
          List<ChildImageInfo> list2;
          ChildImageInfo childImageInfo;
          switch (i) {
            default:
              ClipPhotoFragment.a(this, i, this.G, 22);
              break;
            case 10:
            case 11:
              Houyi.a().a(this.G).b();
              ImageFileLoader.a((IRequestHost)w_()).c(this.G).a();
              childImageInfo = new ChildImageInfo();
              childImageInfo.mImagePath = this.G;
              childImageInfo.mSelect = true;
              ChildPhotoManager.a().a(1, childImageInfo);
              SelectPhotoManager.a().a(childImageInfo);
              str = this.i.getText().toString();
              list2 = this.n.get(str);
              list1 = list2;
              if (list2 == null)
                list1 = this.n.get("nophoto"); 
              list1.add(1, childImageInfo);
              t();
              break;
            case 12:
              intent = new Intent();
              intent.putExtra("photo_path", this.G);
              getActivity().setResult(-1, intent);
              getActivity().finish();
              break;
          } 
        } else {
          ClipBgFragment.a(this, i, this.G, 22);
        } 
      } else {
      
      } 
    } 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public Loader<Cursor> onCreateLoader(int paramInt, Bundle paramBundle) {
    a(this.p);
    return (Loader<Cursor>)new CursorLoader(this.f, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.f = (Context)getActivity();
    View view = this.g;
    if (view == null) {
      this.g = paramLayoutInflater.inflate(2131493266, paramViewGroup, false);
      l();
      n();
      o();
      m();
      if (this.F)
        p(); 
    } else if (view.getParent() != null) {
      ((ViewGroup)this.g.getParent()).removeView(this.g);
    } 
    if (paramBundle != null)
      this.G = paramBundle.getString("path"); 
    return this.g;
  }
  
  public void onDestroy() {
    d.clear();
    MemoryRequest.a().b(this);
    super.onDestroy();
  }
  
  public void onDetach() {
    k();
    super.onDetach();
  }
  
  public void onLoaderReset(Loader<Cursor> paramLoader) {}
  
  public void onSaveInstanceState(Bundle paramBundle) {
    paramBundle.putString("path", this.G);
    super.onSaveInstanceState(paramBundle);
  }
  
  public void onStart() {
    super.onStart();
    MemoryRequest.a().b(this);
  }
  
  public void onStop() {
    super.onStop();
    MemoryRequest.a().a(this);
  }
  
  public class CurrentAdapter extends BaseAdapter {
    public int getCount() {
      return 4;
    }
    
    public Object getItem(int param1Int) {
      return Integer.valueOf(param1Int);
    }
    
    public long getItemId(int param1Int) {
      return param1Int;
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      ViewHolder viewHolder1;
      ViewHolder viewHolder2;
      if (param1View == null) {
        View view = LayoutInflater.from(PhotoSelectFragment.c(this.a)).inflate(2131493118, param1ViewGroup, false);
        viewHolder1 = new ViewHolder();
        viewHolder1.a = (ImageView)view.findViewById(2131297362);
        view.setTag(viewHolder1);
      } else {
        ViewHolder viewHolder = (ViewHolder)viewHolder1.getTag();
        viewHolder2 = viewHolder1;
        viewHolder1 = viewHolder;
      } 
      ImageLoader.a((IRequestHost)this.a.w_(), 2131233510).a(2.0F).a(viewHolder1.a);
      return (View)viewHolder2;
    }
    
    class ViewHolder {
      ImageView a;
      
      private ViewHolder(PhotoSelectFragment.CurrentAdapter this$0) {}
    }
  }
  
  class ViewHolder {
    ImageView a;
    
    private ViewHolder(PhotoSelectFragment this$0) {}
  }
  
  public class FeedPhotoAdapter extends BaseAdapter {
    public FeedPhotoAdapter(PhotoSelectFragment this$0) {}
    
    public int getCount() {
      return ChildPhotoManager.a().b();
    }
    
    public Object getItem(int param1Int) {
      return Integer.valueOf(param1Int);
    }
    
    public long getItemId(int param1Int) {
      return param1Int;
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      PhotoSelectFragment.ViewHolder viewHolder;
      if (param1View == null) {
        param1View = PhotoSelectFragment.g(this.a).inflate(2131493267, param1ViewGroup, false);
        viewHolder = new PhotoSelectFragment.ViewHolder(this.a);
        viewHolder.a = (ImageView)param1View.findViewById(2131297362);
        viewHolder.b = (LinearLayout)param1View.findViewById(2131300179);
        viewHolder.c = (ImageView)param1View.findViewById(2131299888);
        param1View.setTag(viewHolder);
      } else {
        viewHolder = (PhotoSelectFragment.ViewHolder)param1View.getTag();
      } 
      ChildImageInfo childImageInfo = ChildPhotoManager.a().a(param1Int);
      if (childImageInfo != null) {
        ImageWrapper imageWrapper;
        if (childImageInfo.mTakePhoto) {
          viewHolder.b.setVisibility(0);
          viewHolder.c.setVisibility(8);
          viewHolder.a.setVisibility(8);
          viewHolder.b.setOnClickListener(new View.OnClickListener(this) {
                public void onClick(View param2View) {
                  PhotoSelectFragment.h(this.a.a);
                }
              });
          return param1View;
        } 
        viewHolder.c.setVisibility(0);
        viewHolder.b.setVisibility(8);
        viewHolder.a.setVisibility(0);
        if (!TextUtils.isEmpty(childImageInfo.imgUri)) {
          imageWrapper = ImageLoader.b((IRequestHost)this.a.w_(), childImageInfo.imgUri);
        } else {
          imageWrapper = ImageLoader.d((IRequestHost)this.a.w_(), childImageInfo.mImagePath);
        } 
        imageWrapper.a(2131231369).a(viewHolder.a);
        viewHolder.a.setOnClickListener(new View.OnClickListener(this, param1Int) {
              public void onClick(View param2View) {
                PhotoPagerFragment.a(this.b.a, this.a, PhotoSelectFragment.a(this.b.a), PhotoSelectFragment.i(this.b.a));
              }
            });
        if (childImageInfo.mSelect) {
          viewHolder.c.setImageResource(2131233514);
        } else {
          viewHolder.c.setImageResource(2131233518);
        } 
        viewHolder.c.setOnClickListener(new View.OnClickListener(this, childImageInfo, viewHolder) {
              public void onClick(View param2View) {
                if (this.a.mSelect) {
                  this.a.mSelect = false;
                  SelectPhotoManager.a().b(this.a);
                  this.b.c.setImageResource(2131233518);
                  if (SelectPhotoManager.a().b() > 0) {
                    PhotoSelectFragment.j(this.c.a);
                    return;
                  } 
                  PhotoSelectFragment.k(this.c.a);
                  return;
                } 
                if (SelectPhotoManager.a().b() + PhotoSelectFragment.d.size() < PhotoConstants.CONFIG.a) {
                  PhotoSelectFragment.a(this.c.a, this.b.c);
                  this.a.mSelect = true;
                  SelectPhotoManager.a().a(this.a);
                  PhotoSelectFragment.j(this.c.a);
                  return;
                } 
                AppMethods.a(String.format(this.c.a.getResources().getString(2131757865), new Object[] { Integer.valueOf(PhotoConstants.CONFIG.a) }));
              }
            });
      } 
      return param1View;
    }
  }
  
  class null implements View.OnClickListener {
    null(PhotoSelectFragment this$0) {}
    
    public void onClick(View param1View) {
      PhotoSelectFragment.h(this.a.a);
    }
  }
  
  class null implements View.OnClickListener {
    null(PhotoSelectFragment this$0, int param1Int) {}
    
    public void onClick(View param1View) {
      PhotoPagerFragment.a(this.b.a, this.a, PhotoSelectFragment.a(this.b.a), PhotoSelectFragment.i(this.b.a));
    }
  }
  
  class null implements View.OnClickListener {
    null(PhotoSelectFragment this$0, ChildImageInfo param1ChildImageInfo, PhotoSelectFragment.ViewHolder param1ViewHolder) {}
    
    public void onClick(View param1View) {
      if (this.a.mSelect) {
        this.a.mSelect = false;
        SelectPhotoManager.a().b(this.a);
        this.b.c.setImageResource(2131233518);
        if (SelectPhotoManager.a().b() > 0) {
          PhotoSelectFragment.j(this.c.a);
          return;
        } 
        PhotoSelectFragment.k(this.c.a);
        return;
      } 
      if (SelectPhotoManager.a().b() + PhotoSelectFragment.d.size() < PhotoConstants.CONFIG.a) {
        PhotoSelectFragment.a(this.c.a, this.b.c);
        this.a.mSelect = true;
        SelectPhotoManager.a().a(this.a);
        PhotoSelectFragment.j(this.c.a);
        return;
      } 
      AppMethods.a(String.format(this.c.a.getResources().getString(2131757865), new Object[] { Integer.valueOf(PhotoConstants.CONFIG.a) }));
    }
  }
  
  public class PopAdapter extends BaseAdapter {
    public PopAdapter(PhotoSelectFragment this$0) {}
    
    public int getCount() {
      return (PhotoSelectFragment.m(this.a) == null) ? 0 : PhotoSelectFragment.m(this.a).size();
    }
    
    public Object getItem(int param1Int) {
      return PhotoSelectFragment.m(this.a).get(param1Int);
    }
    
    public long getItemId(int param1Int) {
      return param1Int;
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      ViewHolder viewHolder;
      ImageWrapper imageWrapper;
      if (param1View == null) {
        param1View = LayoutInflater.from(PhotoSelectFragment.c(this.a)).inflate(2131493268, param1ViewGroup, false);
        viewHolder = new ViewHolder();
        param1View.setTag(viewHolder);
        viewHolder.a = (ImageView)param1View.findViewById(2131297362);
        viewHolder.b = (TextView)param1View.findViewById(2131299358);
      } else {
        viewHolder = (ViewHolder)param1View.getTag();
      } 
      GroupImageInfo groupImageInfo = PhotoSelectFragment.m(this.a).get(param1Int);
      if (!TextUtils.isEmpty(groupImageInfo.topImgUri)) {
        imageWrapper = ImageLoader.b((IRequestHost)this.a.w_(), groupImageInfo.topImgUri);
      } else {
        imageWrapper = ImageLoader.d((IRequestHost)this.a.w_(), groupImageInfo.getTopImagePath());
      } 
      imageWrapper.a(2131231369).a(viewHolder.a);
      if (!TextUtils.isEmpty(groupImageInfo.getFolderName())) {
        viewHolder.b.setText(groupImageInfo.getFolderName());
      } else {
        viewHolder.b.setText("");
      } 
      param1View.setOnClickListener(new View.OnClickListener(this, groupImageInfo) {
            public void onClick(View param2View) {
              ChildPhotoManager.a().a((List)PhotoSelectFragment.n(this.b.a).get(this.a.getFolderName()));
              PhotoSelectFragment.o(this.b.a).setText(this.a.getFolderName());
              BluedPreferences.C(this.a.getFolderName());
              PhotoSelectFragment.e(this.b.a).d();
              int i = PhotoSelectFragment.a(this.b.a);
              if (i != 5) {
                if (i != 7) {
                  if (i != 10 && i != 11) {
                    PhotoSelectFragment.q(this.b.a).notifyDataSetChanged();
                    return;
                  } 
                  PhotoSelectFragment.p(this.b.a).notifyDataSetChanged();
                  return;
                } 
                PhotoSelectFragment.p(this.b.a).notifyDataSetChanged();
                return;
              } 
              PhotoSelectFragment.p(this.b.a).notifyDataSetChanged();
            }
          });
      return param1View;
    }
    
    class ViewHolder {
      ImageView a;
      
      TextView b;
      
      private ViewHolder(PhotoSelectFragment.PopAdapter this$0) {}
    }
  }
  
  class null implements View.OnClickListener {
    null(PhotoSelectFragment this$0, GroupImageInfo param1GroupImageInfo) {}
    
    public void onClick(View param1View) {
      ChildPhotoManager.a().a((List)PhotoSelectFragment.n(this.b.a).get(this.a.getFolderName()));
      PhotoSelectFragment.o(this.b.a).setText(this.a.getFolderName());
      BluedPreferences.C(this.a.getFolderName());
      PhotoSelectFragment.e(this.b.a).d();
      int i = PhotoSelectFragment.a(this.b.a);
      if (i != 5) {
        if (i != 7) {
          if (i != 10 && i != 11) {
            PhotoSelectFragment.q(this.b.a).notifyDataSetChanged();
            return;
          } 
          PhotoSelectFragment.p(this.b.a).notifyDataSetChanged();
          return;
        } 
        PhotoSelectFragment.p(this.b.a).notifyDataSetChanged();
        return;
      } 
      PhotoSelectFragment.p(this.b.a).notifyDataSetChanged();
    }
  }
  
  class ViewHolder {
    ImageView a;
    
    TextView b;
    
    private ViewHolder(PhotoSelectFragment this$0) {}
  }
  
  public class SinglePhotoAdapter extends BaseAdapter {
    public SinglePhotoAdapter(PhotoSelectFragment this$0) {}
    
    public int getCount() {
      return ChildPhotoManager.a().b();
    }
    
    public Object getItem(int param1Int) {
      return Integer.valueOf(param1Int);
    }
    
    public long getItemId(int param1Int) {
      return param1Int;
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      PhotoSelectFragment.ViewHolder viewHolder;
      if (param1View == null) {
        param1View = PhotoSelectFragment.g(this.a).inflate(2131493267, param1ViewGroup, false);
        viewHolder = new PhotoSelectFragment.ViewHolder(this.a);
        viewHolder.a = (ImageView)param1View.findViewById(2131297362);
        viewHolder.b = (LinearLayout)param1View.findViewById(2131300179);
        viewHolder.c = (ImageView)param1View.findViewById(2131299888);
        param1View.setTag(viewHolder);
      } else {
        viewHolder = (PhotoSelectFragment.ViewHolder)param1View.getTag();
      } 
      ChildImageInfo childImageInfo = ChildPhotoManager.a().a(param1Int);
      if (childImageInfo != null) {
        ImageWrapper imageWrapper;
        if (childImageInfo.mTakePhoto) {
          viewHolder.b.setVisibility(0);
          viewHolder.c.setVisibility(8);
          viewHolder.a.setVisibility(8);
          viewHolder.b.setOnClickListener(new View.OnClickListener(this) {
                public void onClick(View param2View) {
                  PhotoSelectFragment.l(this.a.a);
                }
              });
          return param1View;
        } 
        viewHolder.c.setVisibility(8);
        viewHolder.b.setVisibility(8);
        viewHolder.a.setVisibility(0);
        if (!TextUtils.isEmpty(childImageInfo.imgUri)) {
          imageWrapper = ImageLoader.b((IRequestHost)this.a.w_(), childImageInfo.imgUri);
        } else {
          imageWrapper = ImageLoader.d((IRequestHost)this.a.w_(), childImageInfo.mImagePath);
        } 
        imageWrapper.a(2131231369).a(viewHolder.a);
        viewHolder.a.setOnClickListener(new View.OnClickListener(this, childImageInfo) {
              public void onClick(View param2View) {
                if (PhotoSelectFragment.b(this.b.a) && !AppUtils.b(this.a.mImagePath)) {
                  String str = RecyclingUtils.e("photo");
                  boolean bool = FileUtils.a(this.a.mImagePath, str);
                  this.a.mImagePath = str;
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("SaveSelectPhoto: ");
                  stringBuilder.append(str);
                  stringBuilder.append(" ");
                  stringBuilder.append(bool);
                  LogUtils.c(stringBuilder.toString());
                } 
                int i = PhotoSelectFragment.a(this.b.a);
                if (i != 6) {
                  if (i != 12) {
                    if (i != 14) {
                      ClipPhotoFragment.a(this.b.a, PhotoSelectFragment.a(this.b.a), this.a.mImagePath, 22);
                      return;
                    } 
                    ClipBgFragment.a(this.b.a, PhotoSelectFragment.a(this.b.a), this.a.mImagePath, 22);
                    return;
                  } 
                  ChatBgPicturePreFragment.a(this.b.a, this.a.mImagePath, 4, null, false, 24);
                  return;
                } 
                Intent intent = new Intent();
                intent.putExtra("photo_path", this.a.mImagePath);
                this.b.a.getActivity().setResult(-1, intent);
                this.b.a.getActivity().finish();
              }
            });
      } 
      return param1View;
    }
  }
  
  class null implements View.OnClickListener {
    null(PhotoSelectFragment this$0) {}
    
    public void onClick(View param1View) {
      PhotoSelectFragment.l(this.a.a);
    }
  }
  
  class null implements View.OnClickListener {
    null(PhotoSelectFragment this$0, ChildImageInfo param1ChildImageInfo) {}
    
    public void onClick(View param1View) {
      if (PhotoSelectFragment.b(this.b.a) && !AppUtils.b(this.a.mImagePath)) {
        String str = RecyclingUtils.e("photo");
        boolean bool = FileUtils.a(this.a.mImagePath, str);
        this.a.mImagePath = str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SaveSelectPhoto: ");
        stringBuilder.append(str);
        stringBuilder.append(" ");
        stringBuilder.append(bool);
        LogUtils.c(stringBuilder.toString());
      } 
      int i = PhotoSelectFragment.a(this.b.a);
      if (i != 6) {
        if (i != 12) {
          if (i != 14) {
            ClipPhotoFragment.a(this.b.a, PhotoSelectFragment.a(this.b.a), this.a.mImagePath, 22);
            return;
          } 
          ClipBgFragment.a(this.b.a, PhotoSelectFragment.a(this.b.a), this.a.mImagePath, 22);
          return;
        } 
        ChatBgPicturePreFragment.a(this.b.a, this.a.mImagePath, 4, null, false, 24);
        return;
      } 
      Intent intent = new Intent();
      intent.putExtra("photo_path", this.a.mImagePath);
      this.b.a.getActivity().setResult(-1, intent);
      this.b.a.getActivity().finish();
    }
  }
  
  public class ViewHolder {
    public ImageView a;
    
    public LinearLayout b;
    
    public ImageView c;
    
    public ViewHolder(PhotoSelectFragment this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\PhotoSelectFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */