public class Answer {   
    public static int answer(long n) { 
        if (n / 10 == 0) return (int) n;
        return answer(sumDigits(n));
    } 
    
    private static int sumDigits(long n) {
        if (n / 10 == 0) return (int) n;
        return ((int) n % 10) + sumDigits(n / 10);
    }

    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(answer(n));
    }
}