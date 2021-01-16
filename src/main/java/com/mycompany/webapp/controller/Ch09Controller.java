
package com.mycompany.webapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.webapp.controller.dto.Ch09user;

@Controller
@RequestMapping("/ch09")
public class Ch09Controller {
		private static final Logger logger = LoggerFactory.getLogger(Ch09Controller.class);
	
		@GetMapping("/content")
		public String content() {
			logger.info("실행");
			return "ch09/content";
		}
		@PostMapping("/photoupload")
		public String fileupload(Ch09user user) {
			logger.info("파일이 성공적으로 업로드 되었습니다.");
			
			//문자파트 정보 읽기
			String uid = user.getUid();
			String uname = user.getUname();
			String upassword = user.getUname();
			logger.info("uid: " + uid);
			logger.info("uname: " + uname);
			logger.info("upassword: " + upassword);
			//파일 타입 정보 얻기
			MultipartFile uphoto = user.getUphoto();
			if(!uphoto.isEmpty()) {//파일이 있을 경우에만 이것을 실행함
				String originalFileName = uphoto.getOriginalFilename();
				String contentType = uphoto.getContentType();
				//리턴타입으로 long변환
				long size = uphoto.getSize();
				logger.info("originalFileName: "+originalFileName);
				logger.info("contentType: "+contentType);
				logger.info("size: "+size);	
				
				//파일저장 이름 및 경로
				String saveDirPath = "D:/MyWorkSpace/uploadfiles/";
				//(만약 오리지널로 사용된다면 향후 같은 이름이 있을 경우에는 덮어쓰기가 된다==>날짜와 시간을 이용하는게 가장 편함)
				String fileName = new Date().getTime() + "-" + originalFileName;
				String filePath = saveDirPath + fileName;
				File file = new File(filePath);//파일객체는 파일의 정보를 가지고 있는 객체로 파일의 정보.크기.경로를 얻거나 할떄 ㅅ사용된다.
				//예외처리
				try {
					uphoto.transferTo(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return "redirect:/ch09/content";
		}
		@GetMapping("/photolist")
		public String photoList(Model model) {
			String saveDirPath ="D:/MyWorkSpace/uploadfiles/";
			File dir = new File(saveDirPath);
			String[] fileNames = dir.list();
			model.addAttribute("fileNames", fileNames);
			return "ch09/photolist";
		}
		@GetMapping("/photodownload")
		public void photodownload(String photo, HttpServletResponse response) {
			String saveDirPath = "D:/MyWorkSpace/uploadfiles/";
			String filePath = saveDirPath + photo;
			
			//응답 본문 데이터의 종류를 응답 헤더에 추가
			response.setContentType("contentType");
			
			
			//응답 본문 데이터를 파일로 다운로드 할  수 있도록 응답 헤더에 추가
			try {
				photo = new String(photo.getBytes("UTF-8"), "ISO-8859-1");
				//HTTP규약에 따라 헤더에는 한글을 넣지 못한다. 그렇기에 UTF-8을 다시 ISO-8859-1로 인코딩 해줘야 한다.
			} catch (Exception e1) {
				
			} 
			response.setHeader("Content-Disposition", "attachment; filename= \"" +photo+"\" ");
			
			try {
				OutputStream os = response.getOutputStream();
				InputStream is = new FileInputStream(filePath);
//				byte[] data = new byte[1024];
//				while(true) {
//					int readByteNum = is.read(data);
//					if(readByteNum == -1)break;
//					os.write(data, 0, readByteNum);
//				}
				FileCopyUtils.copy(is, os);
				os.flush();
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//void는 응답을 주지 않는다.
			//요청을 했을때 응답을 처리해줄게 없는 경우에는 .jsp를 다운로드하려고하는 특성이 있다. 
		}
		
}



