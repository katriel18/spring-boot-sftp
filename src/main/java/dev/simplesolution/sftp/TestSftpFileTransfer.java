package dev.simplesolution.sftp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dev.simplesolution.sftp.service.FileTransferService;

@Component
public class TestSftpFileTransfer implements CommandLineRunner {

	@Autowired
	private FileTransferService fileTransferService;
	
	private Logger logger = LoggerFactory.getLogger(TestSftpFileTransfer.class);
	
	@Override
	public void run(String... args) throws Exception {
		//test();
		subir();
	}

	//Si no existe el folder da error
	private void subir(){
		logger.info("Start upload file");
		boolean isUploaded =
				fileTransferService.uploadFile("src/main/resources/readme.txt", "/storage/test/SUCCESS/readme2.txt");
		logger.info("Upload result: " + String.valueOf(isUploaded));
	}
	private void bajar(){
		logger.info("Start download file");
		boolean isDownloaded =
				fileTransferService.downloadFile("src/main/resources/readme.txt", "/storage/test/SUCCESS/readme.txt");
		logger.info("Download result: " + String.valueOf(isDownloaded));
	}


	private void test(){
		logger.info("Start download file");
		//boolean isDownloaded = fileTransferService.downloadFile("/home/simplesolution/readme.txt", "/readme.txt");
		boolean isDownloaded = fileTransferService.downloadFile("src/main/resources/readme.txt", "/storage/readme.txt");
		logger.info("Download result: " + String.valueOf(isDownloaded));

		logger.info("Start upload file");
		//boolean isUploaded = fileTransferService.uploadFile("/home/simplesolution/readme.txt", "/readme2.txt");
		boolean isUploaded = fileTransferService.uploadFile("src/main/resources/readme.txt", "/storage/readme2.txt");
		//boolean isUploaded = fileTransferService.uploadFile("src/main/resources/readmeTest.txt", "/storage/readmeTest.txt");
		logger.info("Upload result: " + String.valueOf(isUploaded));
	}

}

enum Dir{
	SUCCESS,
	IN_PROGRESS,
	ERROR
}