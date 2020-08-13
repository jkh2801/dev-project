package controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import logic.DevService;
import logic.Hashtag;
import logic.SNSFile;



@RestController // @ResponseBody: View 없이 직접 데이터를 클라이언트에 전송
@RequestMapping("ajax")
public class AjaxController {
	
	@Autowired
	private DevService service;
	

	@RequestMapping(value = "fileupload", produces = "text/plain; charset=UTF-8", method = RequestMethod.POST)
	public String fileupload(MultipartFile[] files, HttpServletRequest request) {
		System.out.println("ajax");
		System.out.println(files);
		for(MultipartFile file : files) {
			System.out.println(file.getOriginalFilename());
			service.uploadFileCreate(file, request, "test/file/");
			SNSFile f = service.maxfno();
			f.setfileurl("file/");
			f.setFilename(file.getOriginalFilename());
			service.insert_file(f);
		}
		return null;
	}
	
	@RequestMapping(value = "hashtag", produces = "text/plain; charset=UTF-8", method = RequestMethod.POST)
	public String hashtag(HttpServletRequest request) {
		String [] arr = request.getParameterValues("hash");
		System.out.println(Arrays.toString(arr));
		Hashtag hash = new Hashtag();
		hash.setNo(6);
		hash.setWno(service.getmaxcono() + 1);
		for (int i = 0; i < arr.length; i++) {
			hash.setHno(i+1);
			hash.setHashname(arr[i]);
			service.insertHashtag(hash);
		}
		return null;
	}
}
