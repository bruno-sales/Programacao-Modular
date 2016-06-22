package com.unirio.acessorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
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
            File diretorio = new File(caminhoDestino);
            if (!diretorio.exists()) {
                diretorio.mkdir();
            }

            //Obtem conteudo do zip
            ZipInputStream zis = new ZipInputStream(new FileInputStream(caminhoDestino + File.separator + arquivoZip));
            //Obtem itens dentro do zip
            ZipEntry ze = zis.getNextEntry();

            //Para o caso em que o zip tenha diversos arquivos   
            while (ze != null) {

                String fileName = ze.getName();
                
                File newFile = new File(caminhoDestino + File.separator + nomeArquivoDescompactado + fileName);

                //Só fazer salvar arquivo unzipped se ele não já existir
                if (newFile.exists() == false) {
                    FileOutputStream fos = new FileOutputStream(newFile);

                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }

                    fos.close();
                }
                ze = zis.getNextEntry();
            }

            zis.closeEntry();
            zis.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Deletar arquivos zip
     *
     * @param caminho: Caminho para a pasta
     */
    public static void deleteZipFiles(String caminho) {

        // Entrar na pasta
        File folder = new File(caminho);

        try {
            File[] listaArquivos = folder.listFiles();

            // Varrer arquivos
            for (File f : listaArquivos) {
                //Se terminar com .zip, deleta
                if (f.getName().endsWith(".zip")) {
                    f.delete();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
