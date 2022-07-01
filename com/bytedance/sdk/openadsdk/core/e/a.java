package com.bytedance.sdk.openadsdk.core.e;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.DownloadStatusController;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.dislike.b;
import com.bytedance.sdk.openadsdk.f.a.d;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class a implements TTNativeAd {
  private int a;
  
  protected final n g;
  
  protected final k h;
  
  protected final Context i;
  
  protected TTAdDislike j;
  
  protected DownloadStatusController k;
  
  protected int l;
  
  public a(Context paramContext, k paramk, int paramInt) {
    y.a(paramk, "materialMeta不能为null");
    this.h = paramk;
    this.i = paramContext;
    this.l = paramInt;
    this.g = new n(this.i, this, paramk, a(paramInt));
  }
  
  private String a(int paramInt) {
    String str = "embeded_ad";
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 5)
          return (paramInt != 9) ? "embeded_ad" : "draw_ad"; 
      } else {
        return "interaction";
      } 
    } else {
      str = "banner_ad";
    } 
    return str;
  }
  
  private List<View> a(List<View> paramList1, List<View> paramList2) {
    LinkedList<View> linkedList = new LinkedList();
    byte b = 0;
    if (paramList1 != null && !paramList1.isEmpty()) {
      int j = paramList1.size();
      for (int i = 0; i < j; i++)
        linkedList.add(paramList1.get(i)); 
    } 
    if (paramList2 != null && !paramList2.isEmpty()) {
      int j = paramList2.size();
      for (int i = b; i < j; i++)
        linkedList.add(paramList2.get(i)); 
    } 
    return linkedList;
  }
  
  private void a(Activity paramActivity) {
    Context context1;
    Context context2 = this.i;
    Activity activity = paramActivity;
    if (context2 instanceof Activity) {
      activity = paramActivity;
      if (!((Activity)context2).isFinishing())
        context1 = this.i; 
    } 
    this.j = (TTAdDislike)new b(context1, this.h);
  }
  
  private void a(boolean paramBoolean) {
    int i = ah.d(this.h.P());
    d d = d.b().a(this.l).c(String.valueOf(i));
    if (paramBoolean) {
      com.bytedance.sdk.openadsdk.f.a.a().i(d);
      return;
    } 
    com.bytedance.sdk.openadsdk.f.a.a().j(d);
  }
  
  private boolean a() {
    k k1 = this.h;
    boolean bool = false;
    if (k1 == null)
      return false; 
    if (k1.B() == 5)
      return false; 
    if (this.a == 0)
      this.a = ah.d(this.h.P()); 
    if (o.h().d(this.a) == 1)
      bool = true; 
    return bool;
  }
  
  public Bitmap getAdLogo() {
    return BitmapFactory.decodeResource(this.i.getResources(), ab.d(o.a(), "tt_ad_logo_small"));
  }
  
  public View getAdView() {
    return null;
  }
  
  public int getAppCommentNum() {
    return (this.h.N() != null) ? this.h.N().f() : 0;
  }
  
  public int getAppScore() {
    return (this.h.N() != null) ? this.h.N().e() : 0;
  }
  
  public int getAppSize() {
    return (this.h.N() != null) ? this.h.N().g() : 0;
  }
  
  public String getButtonText() {
    return this.h.L();
  }
  
  public String getDescription() {
    return !TextUtils.isEmpty(this.h.J()) ? this.h.J() : this.h.K();
  }
  
  public TTAdDislike getDislikeDialog(Activity paramActivity) {
    if (this.j == null)
      a(paramActivity); 
    return this.j;
  }
  
  public TTAdDislike getDislikeDialog(TTDislikeDialogAbstract paramTTDislikeDialogAbstract) {
    if (paramTTDislikeDialogAbstract != null) {
      paramTTDislikeDialogAbstract.setMaterialMeta(this.h);
      return new TTAdDislike(this, paramTTDislikeDialogAbstract) {
          public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback param1DislikeInteractionCallback) {}
          
          public void showDislikeDialog() {
            boolean bool;
            if (this.a.getContext() instanceof Activity && !((Activity)this.a.getContext()).isFinishing()) {
              bool = true;
            } else {
              bool = false;
            } 
            if (bool)
              this.a.show(); 
          }
        };
    } 
    throw new IllegalArgumentException("dialog is null, please check");
  }
  
  public DownloadStatusController getDownloadStatusController() {
    if (this.k == null) {
      n n1 = this.g;
      if (n1 != null) {
        com.bytedance.sdk.openadsdk.downloadnew.core.a a1 = n1.a();
        if (a1 != null)
          this.k = new DownloadStatusController(this, a1) {
              public void cancelDownload() {
                this.a.g();
              }
              
              public void changeDownloadStatus() {
                this.a.f();
              }
            }; 
      } 
    } 
    return this.k;
  }
  
  public List<FilterWord> getFilterWords() {
    k k1 = this.h;
    return (k1 == null) ? null : k1.R();
  }
  
  public TTImage getIcon() {
    return (this.h.C() == null) ? null : j.a(this.h.C());
  }
  
  public List<TTImage> getImageList() {
    ArrayList<TTImage> arrayList = new ArrayList();
    if (this.h.F() != null && !this.h.F().isEmpty()) {
      Iterator<j> iterator = this.h.F().iterator();
      while (iterator.hasNext())
        arrayList.add(j.a(iterator.next())); 
    } 
    return arrayList;
  }
  
  public int getImageMode() {
    k k1 = this.h;
    return (k1 == null) ? -1 : k1.Q();
  }
  
  public int getInteractionType() {
    k k1 = this.h;
    return (k1 == null) ? -1 : k1.B();
  }
  
  public Map<String, Object> getMediaExtraInfo() {
    k k1 = this.h;
    return (k1 != null) ? k1.X() : null;
  }
  
  public String getSource() {
    return this.h.A();
  }
  
  public String getTitle() {
    return (this.h.N() != null && !TextUtils.isEmpty(this.h.N().c())) ? this.h.N().c() : (!TextUtils.isEmpty(getSource()) ? getSource() : this.h.J());
  }
  
  public TTImage getVideoCoverImage() {
    k k1 = this.h;
    if (k1 != null && k1.z() != null) {
      String str = this.h.z().f();
      return new TTImage(this.h.z().a(), this.h.z().b(), str);
    } 
    return null;
  }
  
  public void registerViewForInteraction(ViewGroup paramViewGroup, View paramView, TTNativeAd.AdInteractionListener paramAdInteractionListener) {
    y.a(paramViewGroup, "container不能为null");
    y.a(paramView, "clickView不能为null");
    ArrayList<View> arrayList = new ArrayList(1);
    arrayList.add(paramView);
    registerViewForInteraction(paramViewGroup, arrayList, null, paramAdInteractionListener);
  }
  
  public void registerViewForInteraction(ViewGroup paramViewGroup, List<View> paramList1, List<View> paramList2, View paramView, TTNativeAd.AdInteractionListener paramAdInteractionListener) {
    boolean bool1;
    y.a(paramViewGroup, "container不能为null");
    y.a(paramList1, "clickView不能为null");
    int i = paramList1.size();
    boolean bool2 = true;
    if (i > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    y.a(bool1, "clickViews数量必须大于等于1");
    if (paramList2 != null && paramList2.size() > 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    } 
    a(bool1);
    List<View> list = paramList2;
    if (a())
      list = a(paramList1, paramList2); 
    this.g.a(paramViewGroup, paramList1, list, paramView, paramAdInteractionListener);
  }
  
  public void registerViewForInteraction(ViewGroup paramViewGroup, List<View> paramList1, List<View> paramList2, TTNativeAd.AdInteractionListener paramAdInteractionListener) {
    boolean bool;
    y.a(paramViewGroup, "container不能为null");
    y.a(paramList1, "clickView不能为null");
    if (paramList1.size() > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    y.a(bool, "clickViews数量必须大于等于1");
    registerViewForInteraction(paramViewGroup, paramList1, paramList2, null, paramAdInteractionListener);
  }
  
  public void setActivityForDownloadApp(Activity paramActivity) {
    if (paramActivity != null)
      this.g.a(paramActivity); 
  }
  
  public void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener) {
    y.a(paramTTAppDownloadListener, "downloadListener不能为null");
    this.g.a(paramTTAppDownloadListener);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */