package cn.tedu.store.controller;
/**
 * 用户注册、登录、修改头像等、控制器
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import cn.tedu.store.entity.User;
import cn.tedu.store.service.IUserservice;
import cn.tedu.store.service.exception.FileSizeOutOfLimitException;
import cn.tedu.store.service.exception.FileTypeNotException;
import cn.tedu.store.service.exception.FileUploadException;
import cn.tedu.store.util.ResponseResult;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
	/**
	 * 上传文件路径
	 */
	private final static String UPLOAD_DIR_NAME = "/upload";
	/**
	 * 限制上传文件大小
	 */
	private final static long FILE_MAX_SIZE= 8L*1024*1024;
	
	/**
	 * 允许文件上传类型
	 */
	private final static List<String> FILE_CONTENT= new ArrayList<String>();
	/**
	 * 初始化允许上传的文件类型的集合
	 */
	static {
		FILE_CONTENT.add("image/jpeg");
		FILE_CONTENT.add("image/png");
		FILE_CONTENT.add("image/gif");
		
	}
	@Autowired
	private IUserservice userService;
	
	@PostMapping("/reg.do")
	public ResponseResult<Void> handleReg(User user){
		userService.reg(user);
		return new ResponseResult<Void>(SUCCESS);
	}
	
	
	@PostMapping("/login.do")
	public ResponseResult<User> handLogin(@RequestParam("username") String username,@RequestParam("password") String password
			,HttpSession session){
		System.out.println("开始处理");
		User login = userService.login(username, password);
		session.setAttribute("uid", login.getId());
		session.setAttribute("username", login.getUsername());
		System.out.println("处理结束");
		return new ResponseResult<User>(SUCCESS,login);
	}
	
	@PostMapping("/updatepassword.do")
	public ResponseResult<Void> updatePassword(
			@RequestParam("oldpassword")String oldpassword,
			@RequestParam("newPassword")String newPassword,
			HttpSession session){
		//获取用户id
		Integer id =  getUidFromSession(session);
		System.out.println("修改密码处获取的id:"+id);
		userService.updatePassword(id, oldpassword, newPassword);
		
		return new ResponseResult<Void>(SUCCESS);
	}
	
	/**
	 * 修改资料返回的用户
	 * @param session
	 * @return
	 */
	@RequestMapping("/info.do")
	public ResponseResult<User> uInfo(HttpSession session){
		User user = userService.infoFormId(getUidFromSession(session));
		return new ResponseResult<User>(SUCCESS,user);
	}
	
	/**
	 * 修改资料
	 * @param user
	 * @param session
	 * @return
	 */
	@PostMapping("/chang_info.do")
	public ResponseResult<Void> updateInfo(User user,HttpSession session){
		//获取id封装到user对象中，因为user是用户提交的数据不包含id
		user.setId(getUidFromSession(session));
		userService.updaInfo(user);
		
		return new ResponseResult<Void>(SUCCESS);
	}
	
	
	@PostMapping("/upload.do")
	public ResponseResult<String> handleUpload(MultipartFile file,HttpSession session) {
		//检查是否存在上传文件
		if (file.isEmpty()) {
			throw new FileUploadException("上传失败，没有选择上传文件！或者上传的文件为空!");
		}
		System.out.println(file.getSize());
		//检查文件的类型以及大小
		if ((file.getSize()>=FILE_MAX_SIZE)) {
			throw new FileSizeOutOfLimitException("上传失败，上传文件过大!!");
			
		}
		
		String conType = file.getContentType();
		if (!FILE_CONTENT.contains(conType)) {
			throw new FileTypeNotException("上传失败，上传的文件类型比匹配!");
			//TODO 头像类型不匹配
		}
		System.out.println("开始接受");
		System.out.println(file);
		//确定上传路径
		String pathString = session.getServletContext().getRealPath(UPLOAD_DIR_NAME);
		System.out.println("上传路径:"+pathString);
		File panretPath = new File(pathString);
		if (!panretPath.exists()) {
			panretPath.mkdirs();
		}
		
		//确定文件名
		String contu = file.getOriginalFilename();
		String name = contu.substring(contu.lastIndexOf("."));
		String  fileName = System.currentTimeMillis()+""+(new Random().nextInt(900000)+100000)+name;
		
		//删除之前的头像
		Integer uidFromSession = getUidFromSession(session);
		User infoFormId = userService.infoFormId(uidFromSession);
		String avatar2 =infoFormId.getAvatar().substring(infoFormId.getAvatar().lastIndexOf("/"));
		File deleteOldAvatar = new File(panretPath+avatar2);
		System.out.println("删除头像"+deleteOldAvatar);
		if (deleteOldAvatar.exists()) {
			System.out.println("一个头像"+avatar2);
			deleteOldAvatar.delete();
			System.out.println("删除上一个头像");
		}else {
			throw new FileUploadException("上一个头像不存在");
		}
		
		//确定文件
		File dest = new File(panretPath,fileName);
		
			try {
				file.transferTo(dest);
				System.err.println("头像更新完成!");
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				//抛出异常，上传失败
				
			}

		String avatar = UPLOAD_DIR_NAME+"/"+fileName;
		System.out.println(avatar);
		
		
		userService.updateAvatar(uidFromSession, avatar);
		
		ResponseResult<String> rr = new ResponseResult<String>();
		rr.setState(SUCCESS);
		rr.setData(avatar);
		return rr;
		
	}
	
	
	
}
