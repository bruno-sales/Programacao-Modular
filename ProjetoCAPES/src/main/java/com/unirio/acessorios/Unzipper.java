package com.unirio.acessorios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * 
 * Classe responsável por descompactar arquivos zip
 */
public class Unzipper {

    List<String> fileList;
		      
    /**
     * Metodo para realizar o unzip
     * @param arquivoZip Caminho+arquivo em formato Zip
     * @param caminhoDestino Diretorio onde o arquivo será salvo
     */
    public void unzipFile(String arquivoZip, String caminhoDestino){

     byte[] buffer = new byte[1024];
    	
     try{
    		
    	//criar pasta para guardar zip, se não existir
    	File folder = new File(caminhoDestino);
    	if(!folder.exists()){
    		folder.mkdir();
    	}
    		
    	//Obtem conteudo do zip
    	ZipInputStream zis = new ZipInputStream(new FileInputStream(arquivoZip));
    	//Obtem itens dentro do zip
    	ZipEntry ze = zis.getNextEntry();
    		
    	while(ze!=null){
    			
    	   String fileName = ze.getName();
           File newFile = new File(caminhoDestino + File.separator + fileName);
                
            //create all non exists folders
            //else you will hit FileNotFoundException for compressed folder
            new File(newFile.getParent()).mkdirs();              
            FileOutputStream fos = new FileOutputStream(newFile);             

            int len;
            while ((len = zis.read(buffer)) > 0) {
       		fos.write(buffer, 0, len);
            }
        		
            fos.close();   
            ze = zis.getNextEntry();
    	}
    	
        zis.closeEntry();
    	zis.close();
    		
    }catch(IOException ex){
       ex.printStackTrace(); 
    }
   }    
}
