
public class Primes {

    public static void main(String[] args) {
        // Parse input argument for n
        int n = Integer.parseInt(args[0]);
        sieveOfEratosthenes(n);
    }

    /**
     * Implements the Sieve of Eratosthenes algorithm to find all prime numbers
     * up to n.
     *
     * @param n The upper limit for generating prime numbers.
     */
    public static void sieveOfEratosthenes(int n) {
        if (n < 2) {
            System.out.println("No primes available less than 2.");
            return;
        }

        // Step 1: Initialize the isPrime array
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true; // Assume all numbers >= 2 are prime
        }

        // Step 2: Apply the sieve
        int p = 2;
        while (p * p <= n) {
            // If isPrime[p] is true, mark all multiples of p as non-prime
            if (isPrime[p]) {
                for (int multiple = p * p; multiple <= n; multiple += p) {
                    isPrime[multiple] = false;
                }
            }
            p++;
        }

        // Step 3: Print the prime numbers and count them
        System.out.println("Prime numbers up to " + n + ":");
        int primeCount = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.println(i);
                primeCount++;
            }
        }

        // Step 4: Calculate and print the percentage
        double percentage = (primeCount * 100.0) / n;
        System.out.println("There are " + primeCount + " primes between 2 and " + n
                + " (" + (int) percentage + "% are primes)");
    }
}
