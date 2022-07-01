package androidx.transition;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Scene {
  private Context a;
  
  private int b = -1;
  
  private ViewGroup c;
  
  private View d;
  
  private Runnable e;
  
  private Runnable f;
  
  public Scene(ViewGroup paramViewGroup) {
    this.c = paramViewGroup;
  }
  
  private Scene(ViewGroup paramViewGroup, int paramInt, Context paramContext) {
    this.a = paramContext;
    this.c = paramViewGroup;
    this.b = paramInt;
  }
  
  public Scene(ViewGroup paramViewGroup, View paramView) {
    this.c = paramViewGroup;
    this.d = paramView;
  }
  
  static void a(ViewGroup paramViewGroup, Scene paramScene) {
    paramViewGroup.setTag(R.id.transition_current_scene, paramScene);
  }
  
  public static Scene getCurrentScene(ViewGroup paramViewGroup) {
    return (Scene)paramViewGroup.getTag(R.id.transition_current_scene);
  }
  
  public static Scene getSceneForLayout(ViewGroup paramViewGroup, int paramInt, Context paramContext) {
    SparseArray sparseArray2 = (SparseArray)paramViewGroup.getTag(R.id.transition_scene_layoutid_cache);
    SparseArray sparseArray1 = sparseArray2;
    if (sparseArray2 == null) {
      sparseArray1 = new SparseArray();
      paramViewGroup.setTag(R.id.transition_scene_layoutid_cache, sparseArray1);
    } 
    Scene scene2 = (Scene)sparseArray1.get(paramInt);
    if (scene2 != null)
      return scene2; 
    Scene scene1 = new Scene(paramViewGroup, paramInt, paramContext);
    sparseArray1.put(paramInt, scene1);
    return scene1;
  }
  
  boolean a() {
    return (this.b > 0);
  }
  
  public void enter() {
    if (this.b > 0 || this.d != null) {
      getSceneRoot().removeAllViews();
      if (this.b > 0) {
        LayoutInflater.from(this.a).inflate(this.b, this.c);
      } else {
        this.c.addView(this.d);
      } 
    } 
    Runnable runnable = this.e;
    if (runnable != null)
      runnable.run(); 
    a(this.c, this);
  }
  
  public void exit() {
    if (getCurrentScene(this.c) == this) {
      Runnable runnable = this.f;
      if (runnable != null)
        runnable.run(); 
    } 
  }
  
  public ViewGroup getSceneRoot() {
    return this.c;
  }
  
  public void setEnterAction(Runnable paramRunnable) {
    this.e = paramRunnable;
  }
  
  public void setExitAction(Runnable paramRunnable) {
    this.f = paramRunnable;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\Scene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */