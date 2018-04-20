package cn.zhouyafeng.itchat4j.demo.demo1;

import cn.zhouyafeng.itchat4j.Wechat;
import cn.zhouyafeng.itchat4j.api.WechatTools;
import cn.zhouyafeng.itchat4j.face.IMsgHandlerFace;
import com.alibaba.fastjson.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author https://github.com/yaphone
 * @date 创建时间：2017年4月28日 上午12:44:10
 * @version 1.0
 *
 */
public class MyTest {
	public static void main(String[] args) {
		String qrPath = "D://itchat4j//login"; // 保存登陆二维码图片的路径，这里需要在本地新建目录
		IMsgHandlerFace msgHandler = new SimpleDemo(); // 实现IMsgHandlerFace接口的类
		Wechat wechat = new Wechat(msgHandler, qrPath); // 【注入】
		wechat.start(); // 启动服务，会在qrPath下生成一张二维码图片，扫描即可登陆，注意，二维码图片如果超过一定时间未扫描会过期，过期时会自动更新，所以你可能需要重新打开图片
//

		String msg = "test 20180420 hahaha";
		String group_id = "@@c7167edbaa8a37cf74d9c482c5ce9c13ffdc503427c9e73589ab02ea5d7a76e5";
		String group_name = "Amis";
		System.out.println("开始发送短信");
		String bw_id = "@6ef193b23cc3c0e86ca3b0fe59b2607e";
//		webWxSendMsg(1, msg, group_name);
//		sendMsgByNickName
		WechatTools.getContactNickNameList();
		List<JSONObject> people = WechatTools.getContactList();
		for (JSONObject person: people
				) {
			String jsonString = person.toJSONString();
			System.out.println(jsonString);
		}

		String liu = WechatTools.getUserNameByNickName("刘宏博");
		WechatTools.sendMsgByUserName(msg, liu);
//		WechatTools.sendMsgByUserName(msg, group_name);
//		WechatTools.sendMsgByNickName(msg, group_name);
//		{"ChatRoomId":0,"Sex":2,"AttrStatus":98663,"Statues":0,"PYQuanPin":"Amis","EncryChatRoomId":"","DisplayName":"",
//				"VerifyFlag":0,"UniFriend":0,"ContactFlag":10307,"UserName":"@6ef193b23cc3c0e86ca3b0fe59b2607e",
//				"MemberList":[],"StarFriend":1,"HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=621210242&username=@6ef193b23cc3c0e86ca3b0fe59b2607e&skey=",
//				"AppAccountFlag":0,"MemberCount":0,"RemarkPYInitial":"LBW","City":"杨浦","NickName":"Amis",
//				"Province":"上海","SnsFlag":49,"Alias":"","KeyWord":"lib","HideInputBarFlag":0,"Signature":"",
//				"RemarkName":"李碧雯","RemarkPYQuanPin":"libiwen","Uin":0,"OwnerUin":0,"IsOwner":0,"PYInitial":"AMIS"}
//		{"ChatRoomId":0,"Sex":1,"AttrStatus":110691,"Statues":0,"PYQuanPin":"liuhongbo","EncryChatRoomId":"",
//				"DisplayName":"","VerifyFlag":0,"UniFriend":0,"ContactFlag":259,"UserName":"@5b358c0e3b77e023a36caf3ec4ce9f56",
//				"MemberList":[],"StarFriend":0,"HeadImgUrl":"/cgi-bin/mmwebwx-bin/webwxgeticon?seq=657546743&username=@5b358c0e3b77e023a36caf3ec4ce9f56&skey=",
//				"AppAccountFlag":0,"MemberCount":0,"RemarkPYInitial":"","City":"","NickName":"刘宏博","Province":"",
//				"SnsFlag":17,"Alias":"","KeyWord":"liu","HideInputBarFlag":0,"Signature":"","RemarkName":"","RemarkPYQuanPin":"",
//				"Uin":0,"OwnerUin":0,"IsOwner":0,"PYInitial":"LHB"}
		System.out.println("发送短信结束");
		List<JSONObject> groups =  WechatTools.getGroupList();
		for (JSONObject a_group: groups
			 ) {
			String jsonString = a_group.toJSONString();
			System.out.println(jsonString);
		}
		List<String> group_ids = WechatTools.getGroupIdList();
		String groupName = "自动消息测试群";
		String wechat_group = WechatTools.getGroupUserNameByGroupNickName(groupName);
//		"发送时间：" + datetime.now().strftime("%Y-%m-%d %H:%M:%S") + "\n"
//                                                                   "发送到：" + name + "\n"
//                                                                                   "发送内容：" + context + "\n"
		for (int i = 0; i < 2; i++) {
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String cur_time = "发送时间：" + sdf.format(d);
//			System.out.println("当前时间：" + sdf.format(d));
			String group_msg_content = "<20180419-09:16:23.205, FIX.4.4:ESolution->CiticNewedge, incoming> " +
					"(8=FIX.4.4 9=110 35=4 34=143 43=Y 49=CiticNewedge 52=20180419-09:17:21.109 " +
					"56=ESolution 122=20180419-09:17:21.109 36=147 123=Y 10=052 )";
			groupName = "自动消息测试群";
			String group_msg = String.format("测试,请忽略。\n %s \n 发送到：%s \n 发送内容：%s\n", cur_time, groupName, group_msg_content);
//			msg = i + "testing";
			WechatTools.sendMsgByUserName(group_msg, wechat_group);
		}
//		WechatTools.sendMsgByUserName(msg, wechat_group);
		for (String a_id: group_ids
			 ) {
			System.out.println(a_id);
		}
	}
}
