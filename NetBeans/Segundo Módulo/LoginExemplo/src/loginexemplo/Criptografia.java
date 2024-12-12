package loginexemplo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {
    public static String getMD5(String texto) {
        try {

            // O método estático getInstance é chamado com hash MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // O método digest() é chamado para calcular a hash da mensagem
            // E enfim temos o vetor da mensagem
            byte[] messageDigest = md.digest(texto.getBytes());

            // Convertemos o vetor de bytes em um BigInt
            BigInteger no = new BigInteger(1, messageDigest);

            // A mensagem em BigInt é convertida para hexadecimal
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // Em caso de erro, é lançada uma exceção
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

//Em Java, utiliza-se a classe MessageDigest para calcular o valor hash de um texto. A
//classe fornece as funções de hash em MD5, SHA-1 e SHA-256.
//
//Esses algoritmos são inicializados no método estático chamado getInstance(). Depois de
//selecionar o algoritmo, ele calcula o valor e retorna os resultados na matriz de bytes.
