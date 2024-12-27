import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        DiffieHellmanSimulation test = new DiffieHellmanSimulation();

        BigInteger testingPrime = test.generateLargePrime(2048);
        System.out.println("Prosti broj (p): " + testingPrime);

        BigInteger generator = BigInteger.TWO;
        System.out.println("Generator (g): " + generator);

        System.out.println();

        BigInteger alicePrivateKey =  test.generatePrivateKey(1000);
        BigInteger bobPrivateKey =  test.generatePrivateKey(900);

        System.out.println("Privatni ključ Alice: " + alicePrivateKey);
        System.out.println("Privatni ključ Bob: " +bobPrivateKey);

        System.out.println();

        BigInteger alicePublicKey = test.calculatePublicKey(generator,alicePrivateKey,testingPrime);
        BigInteger bobPublicKey = test.calculatePublicKey(generator,bobPrivateKey,testingPrime);

        System.out.println("Javni Ključ Alice: " + alicePublicKey);
        System.out.println("Javni Ključ Alice: " + bobPublicKey);

        BigInteger aliceSharedKey = test.calculateSharedKey(bobPublicKey,alicePrivateKey,testingPrime);
        BigInteger bobSharedKey = test.calculateSharedKey(alicePublicKey,bobPrivateKey,testingPrime);

        System.out.println();

        System.out.println("Zajednički tajni ključ (Alice): " + aliceSharedKey);
        System.out.println("Zajednički tajni ključ (Bob): " + bobSharedKey);

    }
}