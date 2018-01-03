package aee;

import java.math.BigInteger;
import java.util.Random;

/**
 * @author Diana Chavez @kodyakckaly
 */
public class GeneraClaves {

    BigInteger n, p, q, phi, e, d;
    Main m = new Main();
    int tamPrimo;

    public void setTamPrimo(int tamPrimo) {
        this.tamPrimo = tamPrimo;
    }

    public void generarClaves(int tamPrimo) {
        // Generamos los numeros primos p y q.
        p = new BigInteger(tamPrimo, 10, new Random());
        do {
            q = new BigInteger(tamPrimo, 10, new Random());
        } while (q.compareTo(p) == 0);

        // APLICAMOS FORMULA [ n = p * q ]
        n = p.multiply(q);

        // APLICAMOS FORMULA [phi(n) = (p-1)*(q-1)]
        phi = p.subtract(BigInteger.valueOf(1));
        phi = phi.multiply(q.subtract(BigInteger.valueOf(1)));
        /* NOTA. LOS NÚMEROS SIEMPRE SON MENOR A N.
         *Así que Elegimos un e coprimo de y menor que n */
        do {
            e = new BigInteger(2 * tamPrimo, new Random());
        } while ((e.compareTo(phi) != -1) || (e.gcd(phi).compareTo(BigInteger.valueOf(1)) != 0));

        // d = e^1 mod phi
        d = e.modInverse(phi);

        System.out.println("Tam clave: " + tamPrimo);
        System.out.println("p:[" + getP() + "]   q:[" + getQ() + "]   n:[" + getN() + "]\n Clave publica (e):\n "
                + "e:[" + getE() + "]\nClave privada (d):\n" + "d:[" + getD() + "]");
    }

    public BigInteger[] encripta(String mensaje) {
        // Cifrar C = m ^e (mod n)
        byte[] temp = new byte[1]; 
        byte[] digitos = mensaje.getBytes();
        BigInteger[] bigdigitos = new BigInteger[digitos.length];

        for (int i = 0; i < bigdigitos.length; i++) {
            temp[0] = digitos[i];
            bigdigitos[i] = new BigInteger(temp);
        }

        BigInteger[] encriptado = new BigInteger[bigdigitos.length];

        for (int i = 0; i < bigdigitos.length; i++) {
            encriptado[i] = bigdigitos[i].modPow(e, n); //Calcula MCD entre e y phi para poder aplicar [ mod n]
        }
        return encriptado;
    }
    
    final String desencripta(BigInteger[] encriptado) {
        // Aplicamos la formula Mensaje = C ^d (mod n)
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

    public BigInteger getN() {
        return n;
    }

    public BigInteger getQ() {
        return q;
    }

    public BigInteger getP() {
        return p;
    }

    public BigInteger getPhi() {
        return phi;
    }

    public BigInteger getE() {
        return e;
    }

    public BigInteger getD() {
        return d;
    }
}
