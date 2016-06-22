package com.unirio.acessorios;

import com.unirio.controlador.Controlador;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Element;
/**
 * Classe  responsavel por baixar arquivos da web 
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
    
    //Classe que executa o download do arquivo dados os parâmetros passados
    public static void efetuarDownloadArquivo(String nomeArquivo, String url) throws MalformedURLException, FileNotFoundException, IOException {

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
    //Classe responsável por disparar a solicitação de download do arquivo qualis
     public static void baixarQualis() {
        String url = "https://s3.amazonaws.com/posgraduacao/qualis.xml";
        String nome = "qualis.xml";

        try {
            efetuarDownloadArquivo(nome, url);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     //Classe responsável por disparar a solicitação de download do arquivo de programas.xml 
     public static void baixarProgramasXml() {
       
         String url = "https://s3.amazonaws.com/posgraduacao/programas.xml";
        String nome = "programas.xml";

        try {
            efetuarDownloadArquivo(nome, url);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

     //Classe responsável por disparar a solicitação de download do arquivo contents.xml
    public static void baixarContentsXml() {
       
        String nome = "contents.xml";
        List<Element> myElements = RecuperaXml.getElementoXml("xmls/programas.xml", "programa");

        for (Element e : myElements) {

            //Elemento, InnerTag
            String nomePrograma = LeitorXml.getStringAttribute(e, "nome");
            String url = "https://s3.amazonaws.com/posgraduacao/" + nomePrograma + "/contents.xml";

            try {
                efetuarDownloadArquivo(nome, url);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    //Classe responsável por disparar a solicitação de download dos arquivos curriculo
    public static void baixarCurriculosXml() {

        //Caminho, tagname
        List<Element> myElements = RecuperaXml.getElementoXml("xmls/programas.xml", "programa");

        for (Element e : myElements) {
           
            String nomePrograma = LeitorXml.getStringAttribute(e, "nome");

            //Caminho, tagname
            List<Element> professorElements = RecuperaXml.getElementoXml("xmls/contents.xml" , "professor");

            for (Element e2 : professorElements) {

                String codProfessor = LeitorXml.getStringAttribute(e2, "codigo");

                String url = "https://s3.amazonaws.com/posgraduacao/" + nomePrograma + "/" + codProfessor + ".zip";
                String nome = codProfessor + ".zip";

                try {
                    efetuarDownloadArquivo(nome, url);
                    Unzipper.unzipFile(nome, codProfessor, "xmls");
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        }
    }
}
