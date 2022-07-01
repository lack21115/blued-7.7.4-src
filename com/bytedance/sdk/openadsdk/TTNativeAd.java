package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import java.util.Map;

public interface TTNativeAd {
  Bitmap getAdLogo();
  
  View getAdView();
  
  int getAppCommentNum();
  
  int getAppScore();
  
  int getAppSize();
  
  String getButtonText();
  
  String getDescription();
  
  TTAdDislike getDislikeDialog(Activity paramActivity);
  
  TTAdDislike getDislikeDialog(TTDislikeDialogAbstract paramTTDislikeDialogAbstract);
  
  DownloadStatusController getDownloadStatusController();
  
  List<FilterWord> getFilterWords();
  
  TTImage getIcon();
  
  List<TTImage> getImageList();
  
  int getImageMode();
  
  int getInteractionType();
  
  Map<String, Object> getMediaExtraInfo();
  
  String getSource();
  
  String getTitle();
  
  TTImage getVideoCoverImage();
  
  void registerViewForInteraction(ViewGroup paramViewGroup, View paramView, AdInteractionListener paramAdInteractionListener);
  
  void registerViewForInteraction(ViewGroup paramViewGroup, List<View> paramList1, List<View> paramList2, View paramView, AdInteractionListener paramAdInteractionListener);
  
  void registerViewForInteraction(ViewGroup paramViewGroup, List<View> paramList1, List<View> paramList2, AdInteractionListener paramAdInteractionListener);
  
  void setActivityForDownloadApp(Activity paramActivity);
  
  void setDownloadListener(TTAppDownloadListener paramTTAppDownloadListener);
  
  public static interface AdInteractionListener {
    void onAdClicked(View param1View, TTNativeAd param1TTNativeAd);
    
    void onAdCreativeClick(View param1View, TTNativeAd param1TTNativeAd);
    
    void onAdShow(TTNativeAd param1TTNativeAd);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\TTNativeAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */