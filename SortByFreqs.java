 import java.util.ArrayList;
 import java.util.List;
 import java.lang.Comparable;
 import java.util.Collections;
 public class SortByFreqs {
      public String[] sort(String[] data) {
          List<Counts> strcounts = new ArrayList<Counts>();
		  List<String> toret = new ArrayList<String>();
		  for (String name : data) {
			  boolean in = false;
			  for (Counts k : strcounts) {
				  if (name.equals(k.toString())) {
					  in = true;
					  k.increment();
					  break;
				  }
			  }
			  if (!in) strcounts.add(new Counts(name));
		  }
		  Collections.sort(strcounts);
		  for (Counts k : strcounts) {
			  toret.add(k.toString());
		  }
		  return toret.toArray(new String[0]);
      }
	  private class Counts implements Comparable<Counts>{
		  String myName;
		  int myCount;
		  public Counts(String name) {
			  myName = name;
			  myCount = 1;
		  }
		  public void increment() {
			  myCount++;
		  }
		  public int getCount() {
			  return myCount;
		  }
		  @Override
		  public String toString() {
			  return myName;
		  }
		  @Override
		  public int compareTo(Counts other) {
			  int comp = other.getCount() - myCount;
			  if (comp != 0) return comp;
			  return myName.compareTo(other.toString());
		  }
	  }
   }