package androidx.constraintlayout.solver;

public class Cache {
  Pools.Pool<ArrayRow> a = new Pools.SimplePool<ArrayRow>(256);
  
  Pools.Pool<SolverVariable> b = new Pools.SimplePool<SolverVariable>(256);
  
  SolverVariable[] c = new SolverVariable[32];
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\constraintlayout\solver\Cache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */