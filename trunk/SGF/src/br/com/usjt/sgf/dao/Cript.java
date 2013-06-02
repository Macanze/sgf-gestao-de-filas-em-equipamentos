package br.com.usjt.sgf.dao;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException; // para Base-64.  
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 * Classe responsável pela criptografia do sistema 
 *@author dgsantos
 * @since  17/04/2012
 */
public final class Cript {  
    private static SecretKey skey;  
    private static KeySpec ks;  
    private static PBEParameterSpec ps;  
    private static final String algorithm = "PBEWithMD5AndDES";  
    private static BASE64Encoder enc = new BASE64Encoder();  
    private static BASE64Decoder dec = new BASE64Decoder();  
    static {  
        try {  
            SecretKeyFactory skf = SecretKeyFactory.getInstance(algorithm);  
            ps = new PBEParameterSpec (new byte[]{3,1,4,1,5,9,2,6}, 20);  
  
            ks = new PBEKeySpec ("dsdfsdafef+sdfsdfsdf122389+723sdfdf".toCharArray()); // esta Ã© a chave que vocÃª quer manter secreta.  
           //  ks = new PBEKeySpec ("InTeRfAcEDiMeP1904".toCharArray()); // esta Ã© a chave que vocÃª quer manter secreta.  
            // Obviamente quando vocÃª for implantar na sua empresa, use alguma outra coisa - por exemplo,  
            // "05Bc5hswRWpwp1sew+MSoHcj28rQ0MK8". Nao use caracteres especiais (como Ã§) para nao dar problemas.  
  
            skey = skf.generateSecret (ks);  
        } catch (java.security.NoSuchAlgorithmException ex) {  
         System.out.println(ex.getLocalizedMessage());
        } catch (java.security.spec.InvalidKeySpecException ex) {  
            ex.printStackTrace();  
        }  
    }  
  
    /** 
     * Criptografa uma String 
     * @param text texto a ser criptografado
     * @return texto criptografado
     * @throws Exception 
     */
    public static String encrypt(final String text)  
       { 
        try {
            final Cipher cipher = Cipher.getInstance(algorithm);  
            cipher.init(Cipher.ENCRYPT_MODE, skey, ps);  
            return enc.encode (cipher.doFinal(text.getBytes()));
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Cript.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Cript.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Cript.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(Cript.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Cript.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Cript.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }  
    /**
     *  Faz a descriptografia de um texto
     * @param text texto a ser descriptografado
     * @return texto descriptografado
     * @throws Exception 
     */
    public static String decrypt(final String text)  {  
        try {
            final Cipher cipher = Cipher.getInstance(algorithm);  
            cipher.init(Cipher.DECRYPT_MODE, skey, ps);  
            String ret = null;  
           
                ret = new String(cipher.doFinal(dec.decodeBuffer (text)));  
           
            return ret;
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Cript.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Cript.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Cript.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(Cript.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cript.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Cript.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Cript.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }  
  
}  