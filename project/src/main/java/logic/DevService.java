package logic;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dao.BoardDao;
import dao.CoworkingDao;
import dao.MessageDao;
import dao.ProjectDao;
import dao.ReplyDao;
import dao.ReportDao;
import dao.SubcribeDao;
import dao.TilDao;
import dao.UserDao;
import dao.UserGroupDao;
import dao.fileDao;

@Service
public class DevService {

	@Autowired
	private fileDao filedao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private BoardDao boardDao;

	@Autowired
	private CoworkingDao coworkingDao;

	@Autowired
	private ReplyDao replyDao;
	
	@Autowired
	private UserGroupDao usergroupDao;

	@Autowired
	private MessageDao messageDao;

	@Autowired
	private ReportDao reportDao;
	
	@Autowired
	private TilDao tilDao;
	
	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private SubcribeDao subcribeDao;
	
	private Map<String, Object> map = new HashMap<>();

	public void uploadFileCreate(MultipartFile picture, HttpServletRequest request, String path, User user) {
		String orgFile = picture.getOriginalFilename();
		String uploadPath = request.getServletContext().getRealPath("/") + path;
		// 웹 어플리케이션의 경로를 구하기 (webapp폴더까지)
		System.out.println(uploadPath);
		System.out.println("orgFile: " + orgFile);
		File fpath = new File(uploadPath);
		if (!fpath.exists())
			fpath.mkdirs();
		try {
			picture.transferTo(new File(uploadPath + user.getName()+".jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert_file(UserFile f) {
		filedao.insert_file(f);
	}

	public void update_file(UserFile f) {
		filedao.update_file(f);
	}
	
	public User getUser(String id) {
		return userDao.selectOne(id);
	}

	public void userInsert(User user) {
		userDao.insert(user);
	}

	public void update(User user) {
		userDao.update(user);
	}

	public void delete(String id) {
		userDao.delete(id);
	}

	public int getmaxuno() {
		return userDao.getmaxuno();
	}

	public int boardCount(int no, String searchtype, String searchcontent) {
		map.clear();
		if (searchtype != null) {
			String[] cols = searchtype.split(",");
			map.put("col1", cols[0]);
			if (cols.length > 1) {
				map.put("col2", cols[1]);
			}
			if (cols.length > 2) {
				map.put("col3", cols[2]);
			}
		}
		map.put("searchcontent", searchcontent);
		return boardDao.count(no, searchtype, searchcontent);
	}

	public List<Board> boardlist(int no, Integer pageNum, int limit, String searchtype, String searchcontent) {
		return boardDao.list(no, pageNum, limit, searchtype, searchcontent);
	}

	public void boardWrite(Board board, HttpServletRequest request) {

		int max = boardDao.maxnum(board.getNo());
		board.setBno(++max);
		boardDao.insert(board);
	}

	public Board selectOne(int no, int bno) {
		return boardDao.detail(no, bno);
	}

	public Board getBoard(Integer no, Integer bno, boolean able) {
//		if(able) {
//			boardDao.readcnt(no,bno);
//		}
		return boardDao.detail(no, bno);
	}

	public int getmaxcono() {
		return coworkingDao.getmaxno();
	}

	public void coworkingInsert(Coworking coworking) {
		coworkingDao.insert(coworking);
	}

	public Coworking getdetails(Integer gno) {
		return coworkingDao.getdetails(gno);
	}

	public List<User> getUserList() {
		return userDao.getUserList();
	}

	public List<Coworking> getWorkinglist(String searchtype, String searchinput, String searchsort, int category, int num, int limit) {
		return coworkingDao.getWorkinglist(searchtype, searchinput, searchsort, category, num, limit);
	}

	public void insertHashtag(Hashtag hash) {
		coworkingDao.insertHashtag(hash);
	}

	public List<Hashtag> getHashtaglist() {
		return coworkingDao.getHashtaglist();
	}

	public String findId(String name, String email) {
		return userDao.findId(name, email);
	}

	public void replyInsert(Reply reply) {

		int max = replyDao.maxnum(reply);
		reply.setRno(++max);

		replyDao.replyInsert(reply);

	}

	public List<Reply> replyList(Reply reply) {
		return replyDao.replyList(reply);

	}

	public void boardDelete(Board board) {
		boardDao.delete(board);
	}

	public void boardUpdate(Board board) {
		boardDao.update(board);
	}
	
	public void ugroupJoin(int gno, String name, String lang, String comment) {
		usergroupDao.join(gno,name,lang,comment);
	}

	public List<Usergroup> getMemberList(int gno) {
		return usergroupDao.getMemberList(gno);
	}

	public void ugroupJoinMaster(int cono, String name) {
		usergroupDao.ugroupJoinMaster(cono,name);
	}

	public List<Usergroup> getApplyList(int gno) {
		return usergroupDao.getApplyList(gno);
	}

	public void accept(String name) {
		usergroupDao.accept(name);
	}

	public void deport(String name, int gno) {
		usergroupDao.deport(name,gno);
	}

	public List<Usergroup> getMember(int gno) {
		return usergroupDao.getMember(gno);
	}

	public int getMembercount(int gno) {
		return usergroupDao.getMembercount(gno);
	}

	public int getMembermax(int gno) {
		return usergroupDao.getMembermax(gno);
	}

	public List<Coworking> getUsergroup(String name) {
		return coworkingDao.getUsergroup(name);
	}

	public String getMembermaset(int gno) {
		return usergroupDao.getMembermaset(gno);
	}
	
	public String findPw(String id, String name, String email) {
		return userDao.findPw(id, name, email);
	}

	public void changepw(String id, String newpw) {
		userDao.changepw(id, newpw);
	}

	public int maxmno() {
		return messageDao.maxmno();
	}

	public void messageInsert(Message msg) {
		messageDao.messageInsert(msg);
	}

	public List<Message> getMessageList(String name) {
		return messageDao.getMessageList(name);
	}

	public int getmaxwno_Report(int no) {
		return reportDao.getmaxwno(no);
	}

	public int getmaxreno_Report() {
		return reportDao.getmaxreno();
	}

	public void reportInsert(Report report) {
		reportDao.reportInsert(report);
	}

	public List<Report> getReports() {
		return reportDao.getReports();
	}
	
	public void Til_insert(TIL til) {
		int max=tilDao.maxnum();
		System.out.println(max);
		til.setBno(++max);
		til.setNo(3);
		System.out.println(til);
		tilDao.insert(til); 
	}

	public List<TIL> tillist() {
		
		return tilDao.list();
	}

	public TIL getTil(Integer no, Integer bno) {
		
		return tilDao.selectOne(no,bno);
	}

	public void tilDelete(TIL til) {
		tilDao.delete(til);
		
	}

	public void tilUpdate(TIL til, HttpServletRequest request) {
		tilDao.update(til);
		
	}

	public void positionTagsClear(int positionNo, int userno) {
		projectDao.positionTagsClear(positionNo, userno);
	}

	public void skillsTagsClear(int skillsNo, int userno) {
		projectDao.skillsTagsClear(skillsNo, userno);
	}

	public int getMaxTno() {
		return projectDao.getMaxTno();
	}

	public void insertTag(Tag tag) {
		projectDao.insert(tag);
	}

	public List<Tag> getTags(int userno) {
		return projectDao.getTags(userno);
	}
	
	public void likeit(Integer no, Integer bno,Integer gno, String name) {
		boardDao.likeit(no,bno,gno, name);

	}

	public int maxgno(Integer no, Integer bno) {
		return boardDao.maxgno(no,bno);
	}

	public int likechk(Integer no, Integer bno, String name) {
		return boardDao.likechk(no,bno,name);
	}

	public List<Goodorbad> goodorbadlist(Integer no,Integer pageNum, int limit) {
		return boardDao.goodorbadlist(no,pageNum,limit);
	}
	
	public int getpoint(Integer no, Integer bno) {
		return boardDao.getpoint(no,bno);
	}
	
	public void subinsert(Subscribe sub) {
		subcribeDao.insert(sub);
		
	}

	public void subdelete(Subscribe sub) {
		subcribeDao.delete(sub);
		
	}

	public Subscribe getSubscribe(String scrapper, String scrapped) {
		return subcribeDao.getSubscribe(scrapper, scrapped);
	}

	public List<TIL> mytillist(String name) {
		return tilDao.mytillist(name);
	}

	public List<Board> getCommunitylist(int no, int num, int limit) {
		return boardDao.getCommunitylist(no, num, limit);
	}
	
	public int getMaxProno(String name) {
		return projectDao.getMaxProno(name);
	}

	public void addProject(Project newproject) {
		projectDao.addProject(newproject);
	}

	public List<Project> getProjects(String name) {
		return projectDao.getProjects(name);
	}

	public void updateProjectAble(String username, int prono) {
		projectDao.updateProjectAble(username, prono);
	}

	public void clearProjectable(String name) {
		projectDao.clearProjectable(name);
	}

	public void giturlUpdate(User dbUser) {
		userDao.giturlUpdate(dbUser);
	}
}
