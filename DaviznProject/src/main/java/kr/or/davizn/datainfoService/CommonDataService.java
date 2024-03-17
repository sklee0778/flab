package kr.or.davizn.datainfoService;

import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.davizn.datainfoInterface.CommonDataDAO;
import kr.or.davizn.datainfoInterface.GroupDataDAO;

@Service
public class CommonDataService {
	@Autowired
	SqlSession sqlsession;
	
	@Transactional
	public void makeFile(int datatype, String datahtml, String userid,
			HttpServletRequest request, String fileName) throws IOException {
		String fpath = "";
		String fullPath="";
		
		if(datatype == 1) fpath = request.getRealPath("/resources/notefile");
		else if(datatype == 2) fpath = request.getRealPath("/resources/sketchfile");
		else if(datatype == 3) fpath = request.getRealPath("/resources/goalfile");
		else if(datatype == 4) fpath = request.getRealPath("/resources/schedulefile");
		
		fullPath = fpath + "\\" + fileName;
		FileWriter fw = new FileWriter(fullPath);
		fw.write(datahtml);
		fw.close();
	}
	public String getFileName(String userid){
		String fname = userid + System.currentTimeMillis();
		String endformat = ".txt";
		String fileName = fname + endformat;
		return fileName;
	}
	
	public void addDataseq(int dataseq){
		CommonDataDAO commonDAO = sqlsession.getMapper(CommonDataDAO.class);
		commonDAO.addDataseq(dataseq);
	}
	public void deleteDataseq(int dataseq){
		CommonDataDAO commonDAO = sqlsession.getMapper(CommonDataDAO.class);
		commonDAO.deleteDataseq(dataseq);
	}
}
