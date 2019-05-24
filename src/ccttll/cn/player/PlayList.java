package ccttll.cn.player;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class PlayList {
	private String playListName;  //�����б�����
	private List<Song> musicList; //�����б�ĸ�������
	
	public PlayList(String playListName, List musicList) {
		super();
		this.playListName = playListName;
		this.musicList = musicList;
	}

	public String getPlayListName() {
		return playListName;
	}

	public void setPlayListName(String playListName) {
		this.playListName = playListName;
	}

	public List getMusicList() {
		return musicList;
	}

	public void setMusicList(List musicList) {
		this.musicList = musicList;
	}
	
	//��������ӵ������б�
	public void addToPlayList(Song song) {
		musicList.add(song);
	}
	//��ʾ�����б������и���
	public void displayAllSong() {
		for(int i=0;i<musicList.size();i++) {
			System.out.println("��"+(i+1)+"�׸���:"+musicList.get(i));
		}
		
	}
	//ͨ��id��ѯ����
	public Song searchSongById(String id) {
		Iterator<Song> it=musicList.iterator();
		Song song=null;
		//Ϊʲô��������next()���������
		//ԭ��δ֪��ʹ�ü���ʱ��Ҫ��ε���next(),���в�Ҫ�ر�ɨ����ʱ�ѱ�׼���������Ҳ�ر��ˣ�����δ֪�쳣��
		while(it.hasNext()) {	
			Song temp=it.next();
			if(temp.getId().equals(id)) {
				song=temp;  //�Żض������ֱ������������ô����ڼ��ݸ���ƽ̨				
			}	
		}
			return song;	
	}
	//ͨ���������Ʋ�ѯ����
	public Song searchSongByName(String n) {
		Iterator<Song> it=musicList.iterator();	
		while(it.hasNext()) {	
			Song song=it.next();
			if(song.getName().equals(n)) {
//				song=it.next();	
//���Ͻ��й��ڵ���������ʱ��,ע�ⲻҪ���ʹ�� next()����,����ɲ���Ԥ֪�Ĵ���.
				return song;
			}		
		}
		return null;
	}
	
	//�޸ĸ���������id���䣬ɾ���ɸ�����Ϣ����������¸�����
	/*
	 * ����:ArrayList������ģ���ôɾ��һ��Ԫ�غ����ᱣ����λ����
	 * ��JDK�ĵ����ͣ�����Ԫ������
	 */
	public void updateSong(Song song) {
		Iterator<Song> it=musicList.iterator();	 
		while(it.hasNext()) {	
			if(it.next().equals(song)) {
//			if(it.next()==song) {			
//			==�Ƚϵ��ǵ�ַ����Ҫ����д��equals�������Ƚ϶����Ƿ����
//			String�����equals()�Ѿ�����д���Ƚ����������Ƿ����
				musicList.remove(song);
				String newID=song.getId();	
				String newName;
				String newSinger;
				Scanner input=new Scanner(System.in);
				System.out.println("�������µĸ�����:");
				newName=input.nextLine();
				System.out.println("�������µĸ����ݳ���:");
				newSinger =input.nextLine();
				Song newSong=new Song(newID,newName,newSinger);
				musicList.add(newSong);
				
//				input.close();
			}
		}			
	}
	
	//ͨ������idɾ������
	public void deleteSong(String id) {
		Iterator<Song> it=musicList.iterator();
		while(it.hasNext()) {
			Song s=it.next();
			if(s.getId().equals(id)) {				
				musicList.remove(s);
				//musicList.remove(it.next());  	
				//����ָ��ɾ��û���⣿
				//�����⣡����JDK�ϵ�˵����⣬ÿ�ε��� next ֻ�ܵ���һ�δ˷���,Ҳ��ζ���ڵ���remove()֮ǰ�����ȵ���next() ��
				break;		
				//���Ǽ�����ѭ�����쳣��������ɾ��Ԫ�غ󼯺��ƶ������仯
			}
		}
	}
	
	//���������б�Ϊ�赥
	//ʵ�ַ�������musicList������Ϣ�����txt�ļ����򽫸������ݶ������л�
	//Ҫ�������л�����д���ַ����ľͲ�����
	public void exportPlayList() {
		//�ֽ������+�ֽ��ַ�ת�������+�ַ����������
		try {
			FileOutputStream fos=new FileOutputStream("C:\\Users\\Administrator\\Desktop\\"+this.getPlayListName()+".txt");
			OutputStreamWriter osw=new OutputStreamWriter(fos);
			BufferedWriter bw=new BufferedWriter(osw);
			
			Iterator<Song> it=musicList.iterator();
			while(it.hasNext()) {			
				String s=it.next().toString();
				bw.write(s,0, s.length());
				bw.flush();
				//Ϊʲô������ǿ��ˢ�£��ᱨUnKnow Source�Ĵ���
				}	
			
			fos.close();
			osw.close();
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}

