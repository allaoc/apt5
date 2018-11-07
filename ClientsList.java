 import java.util.List;
 import java.util.ArrayList;
 import java.lang.Comparable;
 import java.util.Collections;
 public class ClientsList {
       public String[] dataCleanup(String[] names) {
            List<Person> people = new ArrayList<Person>();
			List<String> toret = new ArrayList<String>();
			String first;
			String last;
			for (String name : names) {
				boolean good = (name.indexOf(",") == -1);
				if (good) {
					first = name.split(" ")[0];
					last = name.split(" ")[1];
				}
				else {
					last = name.split(",")[0];
					first = name.split(",")[1];
					first = first.substring(1);
				}
				people.add(new Person(first, last));
			}
			Collections.sort(people);
			for (Person person : people) {
				toret.add(person.toString());
			}
			return toret.toArray(new String[0]);
       }
	   private class Person implements Comparable<Person>{
		   String myFirst;
		   String myLast;
		   public Person(String first, String last) {
			   myFirst = first;
			   myLast = last;
		   }
		   public String getFirst() {
			   return myFirst;
		   }
		   public String getLast() {
			   return myLast;
		   }
		   @Override
		   public int compareTo(Person other) {
			   int comp = myLast.compareTo(other.getLast());
			   if (comp != 0) return comp;
			   return myFirst.compareTo(other.getFirst());
		   }
		   @Override
		   public String toString() {
			   return (myFirst + " " + myLast);
		   }
	   }
   }