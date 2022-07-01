package androidx.constraintlayout.solver.widgets;

import java.util.ArrayList;

public class Snapshot {
  private int a;
  
  private int b;
  
  private int c;
  
  private int d;
  
  private ArrayList<Connection> e = new ArrayList<Connection>();
  
  public Snapshot(ConstraintWidget paramConstraintWidget) {
    this.a = paramConstraintWidget.getX();
    this.b = paramConstraintWidget.getY();
    this.c = paramConstraintWidget.getWidth();
    this.d = paramConstraintWidget.getHeight();
    ArrayList<ConstraintAnchor> arrayList = paramConstraintWidget.getAnchors();
    int j = arrayList.size();
    for (int i = 0; i < j; i++) {
      ConstraintAnchor constraintAnchor = arrayList.get(i);
      this.e.add(new Connection(constraintAnchor));
    } 
  }
  
  public void applyTo(ConstraintWidget paramConstraintWidget) {
    paramConstraintWidget.setX(this.a);
    paramConstraintWidget.setY(this.b);
    paramConstraintWidget.setWidth(this.c);
    paramConstraintWidget.setHeight(this.d);
    int j = this.e.size();
    for (int i = 0; i < j; i++)
      ((Connection)this.e.get(i)).applyTo(paramConstraintWidget); 
  }
  
  public void updateFrom(ConstraintWidget paramConstraintWidget) {
    this.a = paramConstraintWidget.getX();
    this.b = paramConstraintWidget.getY();
    this.c = paramConstraintWidget.getWidth();
    this.d = paramConstraintWidget.getHeight();
    int j = this.e.size();
    for (int i = 0; i < j; i++)
      ((Connection)this.e.get(i)).updateFrom(paramConstraintWidget); 
  }
  
  static class Connection {
    private ConstraintAnchor a;
    
    private ConstraintAnchor b;
    
    private int c;
    
    private ConstraintAnchor.Strength d;
    
    private int e;
    
    public Connection(ConstraintAnchor param1ConstraintAnchor) {
      this.a = param1ConstraintAnchor;
      this.b = param1ConstraintAnchor.getTarget();
      this.c = param1ConstraintAnchor.getMargin();
      this.d = param1ConstraintAnchor.getStrength();
      this.e = param1ConstraintAnchor.getConnectionCreator();
    }
    
    public void applyTo(ConstraintWidget param1ConstraintWidget) {
      param1ConstraintWidget.getAnchor(this.a.getType()).connect(this.b, this.c, this.d, this.e);
    }
    
    public void updateFrom(ConstraintWidget param1ConstraintWidget) {
      this.a = param1ConstraintWidget.getAnchor(this.a.getType());
      ConstraintAnchor constraintAnchor = this.a;
      if (constraintAnchor != null) {
        this.b = constraintAnchor.getTarget();
        this.c = this.a.getMargin();
        this.d = this.a.getStrength();
        this.e = this.a.getConnectionCreator();
        return;
      } 
      this.b = null;
      this.c = 0;
      this.d = ConstraintAnchor.Strength.STRONG;
      this.e = 0;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\constraintlayout\solver\widgets\Snapshot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */