import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// class IsMoon implements StringChecker {
//   public boolean checkString(String s) {
//     return s.equalsIgnoreCase("moon");
//   }
// }
class StringChecker2 implements StringChecker {
  public boolean checkString(String s) {
      if (s.charAt(0) == 's') {
          return true;
      }
      return false;
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test
    public void testFilter() {
        List<String> stringList = new ArrayList<String>();
        stringList.add("string");
        stringList.add("ey");
        stringList.add("s2");
        List<String> stringList2 = new ArrayList<String>();
        stringList2.add("string");
        stringList2.add("s2");
        StringChecker2 sc = new StringChecker2();
        assertEquals(stringList2, ListExamples.filter(stringList, sc));
    }

    @Test
    public void testMerge() {
        List<String> stringList = new ArrayList<String>();
        stringList.add("a");
        stringList.add("b");
        List<String> stringList2 = new ArrayList<String>();
        stringList2.add("a");
        stringList2.add("d");
        List<String> stringList3 = new ArrayList<String>();
        stringList3.add("a");
        stringList3.add("a");
        stringList3.add("b");
        stringList3.add("d");
        assertEquals(stringList3, ListExamples.merge(stringList, stringList2));
    }
}
