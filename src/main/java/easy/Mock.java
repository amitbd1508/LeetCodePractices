package easy;

public class Mock {
  public boolean checkRecord(String s) {
    int absentCount = 0;
    int conLate = 0;
    for (int i = 0; i < s.length(); i++) {
      if(s.charAt(i) == 'A') {
        absentCount ++;
        if(absentCount >2) return false;
      }
      if(i >1 && s.charAt(i) == s.charAt(i-1) && s.charAt(i) == 'L'){
        conLate++;
        if(conLate >= 2) return false;
      } else {
        conLate = 0;
      }
    }

    return true;
  }
}
