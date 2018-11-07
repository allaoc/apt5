 import java.util.ArrayList;
 import java.util.List;
 import java.lang.Comparable;
 import java.util.Collections;
public class SortedFreqs {
      public int[] freqs(String[] data) {
        List<Counts> strcounts = new ArrayList<Counts>();
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
		  int[] toret = new int[strcounts.size()];
		  int index = 0;
		  for (Counts k : strcounts) {
			  toret[index] = k.getCount();
			  index++;
		  }
		  return toret;
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
			  return myName.compareTo(other.toString());
		  }
	  }
   }