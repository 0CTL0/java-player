package ccttll.cn.player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PlayListCollection {
	private Map<String,PlayList> playListMap;  //存放播放列表的集合

	public PlayListCollection(Map<String,PlayList> playListMap) {
		super();
		this.playListMap = playListMap;
	}

	public Map<String,PlayList> getPlayListMap() {
		return playListMap;
	}

	public void setPlayListMap(Map<String,PlayList> playListMap) {
		this.playListMap = playListMap;
	}
	
	//显示所有播放列表名称
		public void displayPlayListName() {
			if (!playListMap.isEmpty()) {
//				通常不是这样用的，视频的方法链：
//				Set s=playListMap.keySet();
				Iterator it=playListMap.keySet().iterator();
				while(it.hasNext()) {
					System.out.println(it.next());
				}
			}
			else {
				System.out.println("还没有创建播放列表");
			}
		}
	
	//添加播放列表
	public void addPlayList(PlayList playList) {
//		System.out.println("请输入播放列表的名称：");
//		Scanner console=new Scanner(System.in);
//		String playListName=console.next();
		String playListName=playList.getPlayListName();
		playListMap.put(playListName, playList);
	}
	
	//删除播放列表：如何通过传入的值来删除键值对？
	//百度找到了思路，改善代码，用集合元素的成员——播放列表的名称作为键。
	public void deletePlayList(PlayList playList) {		
		playListMap.remove(playList.getPlayListName());
	}
	
	//通过名字查询播放列表
	public PlayList searchPlayListByName(String playListName) {
		if (playListMap.containsKey(playListName)) {
			return playListMap.get(playListName);
		}
		else {
			return null;
		}			
	}
	
	
	
}

