package com.unirio.acessorios;

import java.io.File;
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

    private static final String DIRETORIO = "xmls";

    /**
     *
     * @param nomeArquivo
     * @param url URL do arquivo disponivel na web
     * @throws MalformedURLException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void BaixarArquivo(String nomeArquivo, String url) throws MalformedURLException, FileNotFoundException, IOException {

        File file = new File(DIRETORIO + File.separator + nomeArquivo);

        //Só baixar se arquivo já não existir
        if (!file.exists()){
            new File(file.getParent()).mkdirs();
            
            FileOutputStream fos = new FileOutputStream(file);
            URL website = new URL(url);
            
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
    }
}
