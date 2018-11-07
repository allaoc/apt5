import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;
public class SyllableSorting {
	  public String[] sortWords(String[] words) {
		  Map<List<String>, String> map = new HashMap<List<String>, String>();
		  List<List<String>> decomps = new ArrayList<List<String>>();
		  List<String> toret = new ArrayList<String>();
         for (String word : words) {
			 List<String> syllables = decompose(word);
			 map.put(syllables, word);
			 decomps.add(syllables);
		 }
		 Collections.sort(decomps, new SyllComp());
		 for (List<String> sylls : decomps) {
			 toret.add(map.get(sylls));
		 }
		 return toret.toArray(new String[0]);
      }
	  private class SyllComp implements Comparator<List<String>> {
		  @Override
		  public int compare (List<String> a, List<String> b) {
			  List<String> asorted = new ArrayList<String>(a);
			  List<String> bsorted = new ArrayList<String>(b);
			  Collections.sort(asorted);
			  Collections.sort(bsorted);
			  int c = 0;
			  int comp;
			  while (c < asorted.size() && c < bsorted.size()) {
				  comp = asorted.get(c).compareTo(bsorted.get(c));
				  if (comp != 0) return comp;
				  c++;
			  }
			  comp = a.size()-b.size();
			  if (comp != 0) return comp;
			  for (int k = 0; k < a.size(); k++) {
				  comp = a.get(k).compareTo(b.get(k));
				  if (comp != 0) return comp;
			  }
			  return 0;
		  }
	  }
	  private boolean isvowel (char comp) {
		  if (comp == 'a' || comp == 'e' || comp == 'i' || comp == 'o' || comp == 'u') return true;
		  return false;
	  }
	  private List<String> decompose(String word) {
		  StringBuilder toadd = new StringBuilder();
		  List<String> toret = new ArrayList<String>();
		  boolean vowel = false;
		  for (int c = 0; c < word.length(); c++) {
			  char comp = word.charAt(c);
			  if (!vowel) {
				  toadd.append(comp);
				  vowel = isvowel(comp);
			  }
			  else {
				  if (isvowel(comp)) toadd.append(comp);
				  else {
					  toret.add(toadd.toString());
					  toadd = new StringBuilder();
					  toadd.append(comp);
					  vowel = false;
				  }
			  }
		  }
		  toret.add(toadd.toString());
		  return toret;
	  }
		  
   }