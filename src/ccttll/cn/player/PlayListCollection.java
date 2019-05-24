package ccttll.cn.player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PlayListCollection {
	private Map<String,PlayList> playListMap;  //��Ų����б�ļ���

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
	
	//��ʾ���в����б�����
		public void displayPlayListName() {
			if (!playListMap.isEmpty()) {
//				ͨ�����������õģ���Ƶ�ķ�������
//				Set s=playListMap.keySet();
				Iterator it=playListMap.keySet().iterator();
				while(it.hasNext()) {
					System.out.println(it.next());
				}
			}
			else {
				System.out.println("��û�д��������б�");
			}
		}
	
	//��Ӳ����б�
	public void addPlayList(PlayList playList) {
//		System.out.println("�����벥���б�����ƣ�");
//		Scanner console=new Scanner(System.in);
//		String playListName=console.next();
		String playListName=playList.getPlayListName();
		playListMap.put(playListName, playList);
	}
	
	//ɾ�������б����ͨ�������ֵ��ɾ����ֵ�ԣ�
	//�ٶ��ҵ���˼·�����ƴ��룬�ü���Ԫ�صĳ�Ա���������б��������Ϊ����
	public void deletePlayList(PlayList playList) {		
		playListMap.remove(playList.getPlayListName());
	}
	
	//ͨ�����ֲ�ѯ�����б�
	public PlayList searchPlayListByName(String playListName) {
		if (playListMap.containsKey(playListName)) {
			return playListMap.get(playListName);
		}
		else {
			return null;
		}			
	}
	
	
	
}

