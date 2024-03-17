package kr.or.davizn.boardService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import kr.or.davizn.boardDTO.QandAReplyDTO;
import kr.or.davizn.boardDTO.QandAboardDTO;
import kr.or.davizn.boardInterface.QandAboardDAO;

@Service
public class QandAboard {

	@Autowired
	private SqlSession SqlSession;

	public List<QandAboardDTO> notices(String pg, Model model, int rowSize)
			throws ClassNotFoundException, SQLException {

		int page = 1;
		if (pg != null) {
			page = Integer.parseInt(pg);
		}

		int start = (page * rowSize) - (rowSize - 1);
		int end = page * rowSize;

		QandAboardDAO QandAboardDao = SqlSession.getMapper(QandAboardDAO.class);
		int total = QandAboardDao.getCount();

		// ... 목록
		int allPage = (int) Math.ceil(total / (double) rowSize); // 페이지수
		int block = 5;
		int fromPage = ((page - 1) / block * block) + 1; // 보여줄 페이지의 시작
		int toPage = ((page - 1) / block * block) + block; // 보여줄 페이지의 끝
		if (toPage > allPage) // 예) 20>17
		{
			toPage = allPage;
		}

		// start와 end 값을 map에 담음
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);

		List<QandAboardDTO> list = QandAboardDao.getNotices(map);
		System.out.println("hash : " + QandAboardDao);
		model.addAttribute("list", list);
		model.addAttribute("rowSize", rowSize);
		model.addAttribute("pg", page);
		model.addAttribute("allPage", allPage);
		model.addAttribute("block", block);
		model.addAttribute("fromPage", fromPage);
		model.addAttribute("toPage", toPage);
		return list;
	}

	// 게시글 상세보기
	@Transactional
	public QandAboardDTO noticeDetail(int boardseq) throws ClassNotFoundException, SQLException {
		QandAboardDAO QandAboardDao = SqlSession.getMapper(QandAboardDAO.class);
		System.out.println("들어옴!!");
		QandAboardDTO notice = QandAboardDao.getNotice(boardseq);
		QandAboardDao.boardCount(boardseq);
		String result=QandAboardDao.checkPwd(boardseq);
		System.out.println("결과 :"+result);
		System.out.println("000000");
		notice.setBoardpwd(result);
		return notice;
	}

	// 게시글 등록
	public String noticeReg(QandAboardDTO n, HttpServletRequest request) throws Exception {
		QandAboardDAO QandAboardDao = SqlSession.getMapper(QandAboardDAO.class);
		QandAboardDao.insert(n);
		System.out.println("hash : " + QandAboardDao);
		return "redirect:/QnAList.dvn";
	}

	// 게시글 삭제
	public String noticeDel(String boardseq) throws ClassNotFoundException, SQLException {
		QandAboardDAO QandAboardDao = SqlSession.getMapper(QandAboardDAO.class);
		QandAboardDao.delete(boardseq);
		System.out.println("hash : " + QandAboardDao);
		return "redirect:/QnAList.dvn";
	}

	// 게시글 수정
	public QandAboardDTO noticeEdit1(int boardseq) throws ClassNotFoundException, SQLException {
		QandAboardDAO QandAboardDao = SqlSession.getMapper(QandAboardDAO.class);
		QandAboardDTO notice = QandAboardDao.getNotice(boardseq);
		return notice;
	}

	// 게시글 수정 확인!
	public String noticeEdit2(QandAboardDTO n, HttpServletRequest request)
			throws ClassNotFoundException, SQLException, IOException {
		QandAboardDAO QandAboardDao = SqlSession.getMapper(QandAboardDAO.class);
		QandAboardDao.update(n);
		return "redirect:/QnAList.dvn";

	}

	// 댓글 상세보기
	public List<QandAReplyDTO> replyDetail(int boardseq) throws ClassNotFoundException, SQLException {
		QandAboardDAO QandAboardDao = SqlSession.getMapper(QandAboardDAO.class);
		List<QandAReplyDTO> reqlylist = QandAboardDao.replylist(boardseq);
		System.out.println("hash : " + QandAboardDao);
		return reqlylist;
	}

	public List<QandAboardDTO> boardList(String keyfield, String keyword) throws ClassNotFoundException, SQLException {
		QandAboardDAO QandAboardDao = SqlSession.getMapper(QandAboardDAO.class);
		Map<String, String> map = new HashMap<String, String>();
		map.put("keyfield", keyfield);
		map.put("keyword", keyword);
		List<QandAboardDTO> serchlist = QandAboardDao.boardSearch(map);
		return serchlist;
	}

}