package com.unirio.acessorios;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 *
 * Esta classe deverá ser a responsavel por baixar o zip e fazer o unzip
 */
public class Baixador {
    
    /**
     * 
     * @param nome Nome do Arquivo a ser criado
     * @param url URL do arquivo disponivel na web
     * @throws MalformedURLException
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static void BaixarArquivo(String nome, String url) throws MalformedURLException, FileNotFoundException, IOException
    {
        URL website = new URL(url);
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream(nome);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    }
}
