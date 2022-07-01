package com.blued.android.module.player.media.manager;

import android.app.Activity;
import android.content.Context;
import android.view.ViewParent;
import com.blued.android.core.utils.Log;
import com.blued.android.module.player.media.view.AbBaseVideoView;
import com.blued.android.module.player.media.view.PLTextureVideoViewINT;
import com.blued.android.module.player.media.view.PLVideoPageView;
import com.blued.android.module.player.txplayer.view.BLTxPlayView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class BLVideoViewCache {
  private Activity a;
  
  private LinkedHashMap<String, AbBaseVideoView> b = new LinkedHashMap<String, AbBaseVideoView>(8, 0.75F, true);
  
  private AbBaseVideoView a(Context paramContext, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getVideoView, url = ");
    stringBuilder.append(paramString);
    Log.b("PLVideoViewCache", stringBuilder.toString());
    LinkedHashMap<String, AbBaseVideoView> linkedHashMap = this.b;
    AbBaseVideoView abBaseVideoView2 = linkedHashMap.get(paramString);
    if (abBaseVideoView2 != null)
      return abBaseVideoView2; 
    if (linkedHashMap.size() < 3) {
      BLTxPlayView bLTxPlayView = new BLTxPlayView(paramContext);
      linkedHashMap.put(paramString, bLTxPlayView);
      return (AbBaseVideoView)bLTxPlayView;
    } 
    Iterator<Map.Entry> iterator = linkedHashMap.entrySet().iterator();
    AbBaseVideoView abBaseVideoView1 = abBaseVideoView2;
    if (iterator.hasNext())
      abBaseVideoView1 = linkedHashMap.get(((Map.Entry)iterator.next()).getKey()); 
    return abBaseVideoView1;
  }
  
  private void a(AbBaseVideoView paramAbBaseVideoView) {
    if (paramAbBaseVideoView == null)
      return; 
    paramAbBaseVideoView.c();
    for (ViewParent viewParent = paramAbBaseVideoView.getParent(); viewParent != null; viewParent = viewParent.getParent()) {
      if (viewParent instanceof PLVideoPageView) {
        PLVideoPageView pLVideoPageView = (PLVideoPageView)viewParent;
        pLVideoPageView.h();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PLVideoPageView: it.remove() ");
        stringBuilder.append(pLVideoPageView);
        Log.c("PLVideoViewCache", stringBuilder.toString());
      } else if (viewParent instanceof PLTextureVideoViewINT) {
        ((PLTextureVideoViewINT)viewParent).h();
        Log.c("PLVideoViewCache", "PLTextureVideoViewINT: it.remove()");
      } 
    } 
  }
  
  private String b(String paramString) {
    String str = paramString;
    if (this.a != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.a.toString());
      stringBuilder.append(paramString);
      str = stringBuilder.toString();
    } 
    return str;
  }
  
  public AbBaseVideoView a(String paramString) {
    paramString = b(paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("PLVideoPageView, getViewByKey url ");
    stringBuilder.append(paramString);
    Log.b("PLVideoViewCache", stringBuilder.toString());
    return this.b.get(paramString);
  }
  
  public AbBaseVideoView a(String paramString, Context paramContext) {
    String str = paramString;
    if (this.a != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.a.toString());
      stringBuilder.append(paramString);
      str = stringBuilder.toString();
    } 
    return a(paramContext, str);
  }
  
  public void a() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("clearViewCacheByActivity: activity = ");
    stringBuilder.append(this.a);
    Log.c("PLVideoViewCache", stringBuilder.toString());
    Iterator<Map.Entry> iterator = this.b.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      AbBaseVideoView abBaseVideoView = (AbBaseVideoView)entry.getValue();
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("clearViewCacheByActivity: url ");
      stringBuilder1.append((String)entry.getKey());
      Log.b("PLVideoViewCache", stringBuilder1.toString());
      if (((String)entry.getKey()).contains(this.a.toString())) {
        a(abBaseVideoView);
        iterator.remove();
      } 
    } 
  }
  
  public void a(Activity paramActivity) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setActivity: ");
    stringBuilder.append(paramActivity);
    Log.c("PLVideoViewCache", stringBuilder.toString());
    this.a = paramActivity;
    BLVideoViewLifeFragment.a(this, this.a);
  }
  
  public void a(String paramString, AbBaseVideoView paramAbBaseVideoView) {
    paramString = b(paramString);
    if (this.b.containsValue(paramAbBaseVideoView))
      for (Map.Entry<String, AbBaseVideoView> entry : this.b.entrySet()) {
        if (((AbBaseVideoView)entry.getValue()).equals(paramAbBaseVideoView)) {
          this.b.remove(entry.getKey());
          this.b.put(paramString, paramAbBaseVideoView);
          break;
        } 
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\player\media\manager\BLVideoViewCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */