import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

public class DiffieHellmanSimulation {


    // Cryptographic security => Generating  random numbers
    SecureRandom randomSecureNumber = new SecureRandom();

    // Generating large prime number for  certain number of bits
    public BigInteger generateLargePrime(int bitLength){

        BigInteger largePrime;
        do{
            largePrime = BigInteger.probablePrime(bitLength, randomSecureNumber);
        }while(!largePrime.isProbablePrime(100));

        return largePrime;
    }

    // Generate a random private key
    public BigInteger generatePrivateKey (int bitLength){
        BigInteger privateKey;

        do {
            privateKey = new BigInteger(bitLength,randomSecureNumber);
        }while (privateKey.compareTo(BigInteger.ZERO)<=0);
        return privateKey;
    }

    // calculate public key
    public BigInteger calculatePublicKey(BigInteger g, BigInteger privateKey, BigInteger p){
        return  g.modPow(privateKey, p);
    }

    // calculating shared key
    public BigInteger calculateSharedKey(BigInteger receivedPublicKey, BigInteger privateKey, BigInteger p){
        return receivedPublicKey.modPow(privateKey, p);
    }



}
