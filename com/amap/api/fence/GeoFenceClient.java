package com.amap.api.fence;

import android.app.PendingIntent;
import android.content.Context;
import com.amap.api.location.DPoint;
import com.loc.a;
import com.loc.ej;
import java.util.ArrayList;
import java.util.List;

public class GeoFenceClient {
  public static final int GEOFENCE_IN = 1;
  
  public static final int GEOFENCE_OUT = 2;
  
  public static final int GEOFENCE_STAYED = 4;
  
  Context a = null;
  
  a b = null;
  
  public GeoFenceClient(Context paramContext) {
    if (paramContext != null)
      try {
        return;
      } finally {
        paramContext = null;
        ej.a((Throwable)paramContext, "GeoFenceClient", "<init>");
      }  
    throw new IllegalArgumentException("Context参数不能为null");
  }
  
  public void addGeoFence(DPoint paramDPoint, float paramFloat, String paramString) {
    try {
      return;
    } finally {
      paramDPoint = null;
      ej.a((Throwable)paramDPoint, "GeoFenceClient", "addGeoFence round");
    } 
  }
  
  public void addGeoFence(String paramString1, String paramString2) {
    try {
      return;
    } finally {
      paramString1 = null;
      ej.a((Throwable)paramString1, "GeoFenceClient", "addGeoFence district");
    } 
  }
  
  public void addGeoFence(String paramString1, String paramString2, DPoint paramDPoint, float paramFloat, int paramInt, String paramString3) {
    try {
      return;
    } finally {
      paramString1 = null;
      ej.a((Throwable)paramString1, "GeoFenceClient", "addGeoFence searche");
    } 
  }
  
  public void addGeoFence(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4) {
    try {
      return;
    } finally {
      paramString1 = null;
      ej.a((Throwable)paramString1, "GeoFenceClient", "addGeoFence searche");
    } 
  }
  
  public void addGeoFence(List<DPoint> paramList, String paramString) {
    try {
      return;
    } finally {
      paramList = null;
      ej.a((Throwable)paramList, "GeoFenceClient", "addGeoFence polygon");
    } 
  }
  
  public PendingIntent createPendingIntent(String paramString) {
    try {
      return this.b.a(paramString);
    } finally {
      paramString = null;
      ej.a((Throwable)paramString, "GeoFenceClient", "creatPendingIntent");
    } 
  }
  
  public List<GeoFence> getAllGeoFence() {
    ArrayList<GeoFence> arrayList = new ArrayList();
    try {
      return this.b.b();
    } finally {
      Exception exception = null;
      ej.a(exception, "GeoFenceClient", "getGeoFenceList");
    } 
  }
  
  public boolean isPause() {
    try {
      return this.b.j();
    } finally {
      Exception exception = null;
      ej.a(exception, "GeoFenceClient", "isPause");
    } 
  }
  
  public void pauseGeoFence() {
    try {
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "GeoFenceClient", "pauseGeoFence");
    } 
  }
  
  public void removeGeoFence() {
    try {
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "GeoFenceClient", "removeGeoFence");
    } 
  }
  
  public boolean removeGeoFence(GeoFence paramGeoFence) {
    try {
      return this.b.a(paramGeoFence);
    } finally {
      paramGeoFence = null;
      ej.a((Throwable)paramGeoFence, "GeoFenceClient", "removeGeoFence1");
    } 
  }
  
  public void resumeGeoFence() {
    try {
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "GeoFenceClient", "resumeGeoFence");
    } 
  }
  
  public void setActivateAction(int paramInt) {
    try {
      return;
    } finally {
      Exception exception = null;
      ej.a(exception, "GeoFenceClient", "setActivatesAction");
    } 
  }
  
  public void setGeoFenceAble(String paramString, boolean paramBoolean) {
    try {
      return;
    } finally {
      paramString = null;
      ej.a((Throwable)paramString, "GeoFenceClient", "setGeoFenceAble");
    } 
  }
  
  public void setGeoFenceListener(GeoFenceListener paramGeoFenceListener) {
    try {
      return;
    } finally {
      paramGeoFenceListener = null;
      ej.a((Throwable)paramGeoFenceListener, "GeoFenceClient", "setGeoFenceListener");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\fence\GeoFenceClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */