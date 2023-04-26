package com.ssafy.simple.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileDownController {
	@GetMapping("/download")
	public void download(HttpServletResponse resp) throws IOException {
//		제대로 구현하려면 파일 번호를 파라미터로 받아서 DB select한 다음에
//		저장된 파일명과 원래 어떤 이름이었는지 조회해서 진행해야함
		String savedPath = "c:/MyStorage/uploaded";
		String savedName = "9876543";
		String originalName = "귀여운 가오나시.jpg";
		
		resp.setHeader("Content-Disposition", "attachment; filename=\""+originalName+"\";");
//      resp.setHeader("Content-Disposition","attachment; filename=\"귀여운 가오나시.jpg\";");
		resp.setHeader("Content-Transfer-Encoding", "binary");
		
		File savedFile = new File(savedPath+"/"+savedName); // c: 드라이브에 저장된 파일 오픈
		FileInputStream fis = new FileInputStream(savedFile);
		OutputStream os = resp.getOutputStream();
		FileCopyUtils.copy(fis, os);
	}
}
