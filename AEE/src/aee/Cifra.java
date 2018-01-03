package aee;

import java.math.BigInteger;

/**
 * @author Diana Chavez @kodyakckaly
 */
public class Cifra {
    
    final BigInteger[] encripta(String mensaje, BigInteger e, BigInteger n) {
        
        int i;
        byte[] temp = new byte[1];
        byte[] digitos = mensaje.getBytes();
        BigInteger[] bigdigitos = new BigInteger[digitos.length];

        for (i = 0; i < bigdigitos.length; i++) {
            temp[0] = digitos[i];
            bigdigitos[i] = new BigInteger(temp);
        }

        BigInteger[] encriptado = new BigInteger[bigdigitos.length];

        for (i = 0; i < bigdigitos.length; i++) {
            encriptado[i] = bigdigitos[i].modPow(e, n);
        }
        return encriptado;
    }
}
