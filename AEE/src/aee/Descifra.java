package aee;

import java.math.BigInteger;

/**
 * @author Diana Chavez @kodyakckaly
 */
public class Descifra {
    
    final String desencripta(BigInteger[] encriptado, BigInteger d, BigInteger n) {
        
        BigInteger[] desencriptado = new BigInteger[encriptado.length];

        for (int i = 0; i < desencriptado.length; i++) {
            desencriptado[i] = encriptado[i].modPow(d, n);
        }

        char[] charArray = new char[desencriptado.length];

        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) (desencriptado[i].intValue());
        }

        return (new String(charArray));
    }
}
