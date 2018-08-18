import java.util.*;

public class CalculateSubstrings {


    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        String x = scanner.nextLine();
        scanner.close();
        System.out.println("Result:" + calculateSubstrings(x));

    }

    public static int calculateSubstrings(String x) {
        List<String> res = new ArrayList<>();
        verifyRule1(x, res);
        verifyRule2(x, res);
        verifyRule3(x, res);
        return res.size();
    }

    //verify WYY  pattern
    private static void verifyRule1(String src, List<String> res) {

        for (int i = 0, len = src.length(); i < len -1; i++) {
            if (isDoublePattern(src.substring(i + 1))) {
                res.add(src.substring(0, i + 1));
            }
        }
    }

    //verify YWY pattern
    private static void verifyRule2(String src, List<String> res) {
        int start = 0, end = src.length() -1;
        while(start + 1 < end){
            if(src.charAt(start) == src.charAt(end)){
                res.add(src.substring(start + 1, end+1));
                start ++;
                end --;
            }else{
                return;
            }
        }
    }

    //verify YYW pattern
    private static void verifyRule3(String src, List<String> res) {
        for (int i = src.length()-1; i >1; i--) {
            if (isDoublePattern(src.substring(0,i))) {
                res.add(src.substring(i));
            }
        }
    }
    //verify YY pattern
    private static boolean isDoublePattern(String s) {
        if(s == null || s.length() < 2 || s.length()%2 !=0) return  false;
        int start = 0;
        int mid = s.length()/2;
        while(mid < s.length()){
            if(s.charAt(start++) != s.charAt(mid++)){
                return false;
            }
        }
        return true;
    }
}
