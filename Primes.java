
public class Primes {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        sieveOfEratosthenes(n);
    }

    public static void sieveOfEratosthenes(int n) {
        if (n < 2) {
            System.out.println("No primes available less than 2.");
            return;
        }

        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        int p = 2;
        while (p * p <= n) {
            if (isPrime[p]) {
                for (int multiple = p * p; multiple <= n; multiple += p) {
                    isPrime[multiple] = false;
                }
            }
            p++;
        }

        System.out.println("Prime numbers up to " + n + ":");
        int primeCount = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.println(i);
                primeCount++;
            }
        }

        double percentage = (primeCount * 100.0) / (n - 1);
        System.out.println("There are " + primeCount + " primes between 2 and " + n
                + " (" + Math.round(percentage * 100) / 100.0 + "% are primes)");
    }

}
