import java.util.Arrays;
import java.util.Comparator;
public class Dirsort {
     public String[] sort(String[] dirs) {
          Arrays.sort(dirs, new DirComp());
		  return dirs;
     }
	 private class DirComp implements Comparator<String> {
		 @Override
		 public int compare(String a, String b) {
			 String[] asplit = a.split("/");
			 String[] bsplit = b.split("/");
			 int comp = asplit.length-bsplit.length;
			 if (comp != 0) return comp;
			 for (int c = 0; c < asplit.length; c++) {
				 comp = asplit[c].compareTo(bsplit[c]);
				 if (comp != 0) return comp;
			 }
			 return 0;
		 }
	 }
  }