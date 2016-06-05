package com.unirio.acessorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * Classe responsável por descompactar arquivos zip
 */
public class Unzipper {

    /**
     * Metodo para realizar o unzip
     *
     * @param arquivoZip Caminho+arquivo em formato Zip
     * @param nomeArquivoDescompactado Nome do arquivo descompactado
     * @param caminhoDestino Diretorio onde o arquivo será salvo
     */
    public static void unzipFile(String arquivoZip, String nomeArquivoDescompactado, String caminhoDestino) {

        byte[] buffer = new byte[1024];

        try {

            //criar pasta para guardar zip, se não existir
            File folder = new File(caminhoDestino);
            if (!folder.exists()) {
                folder.mkdir();
            }

            //Obtem conteudo do zip
            ZipInputStream zis = new ZipInputStream(new FileInputStream(caminhoDestino + File.separator + arquivoZip));
            //Obtem itens dentro do zip
            ZipEntry ze = zis.getNextEntry();

            //Para o caso em que o zip tenha diversos arquivos   
            int contador = 0;
            while (ze != null) {

                String fileName = ze.getName();
                File newFile = new File(caminhoDestino + File.separator + contador+" - "+nomeArquivoDescompactado+ fileName);

                FileOutputStream fos = new FileOutputStream(newFile);

                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }

                fos.close();
                ze = zis.getNextEntry();
            }

            //Deletar zip
            File toDelete = new File(caminhoDestino + File.separator + arquivoZip);
            
            if(toDelete.exists())
                 toDelete.delete();
            
            zis.closeEntry();
            zis.close();
            contador++;
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
