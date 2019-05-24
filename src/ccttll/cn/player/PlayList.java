package ccttll.cn.player;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class PlayList {
	private String playListName;  //播放列表名称
	private List<Song> musicList; //播放列表的歌曲集合
	
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
	
	//将歌曲添加到播放列表
	public void addToPlayList(Song song) {
		musicList.add(song);
	}
	//显示播放列表中所有歌曲
	public void displayAllSong() {
		for(int i=0;i<musicList.size();i++) {
			System.out.println("第"+(i+1)+"首歌曲:"+musicList.get(i));
		}
		
	}
	//通过id查询歌曲
	public Song searchSongById(String id) {
		Iterator<Song> it=musicList.iterator();
		Song song=null;
		//为什么调用两次next()方法会出错？
		//原因未知，使用集合时不要多次调用next(),还有不要关闭扫描仪时把标准输入输出流也关闭了，都有未知异常。
		while(it.hasNext()) {	
			Song temp=it.next();
			if(temp.getId().equals(id)) {
				song=temp;  //放回对象而不直接输出，这样好处在于兼容各种平台				
			}	
		}
			return song;	
	}
	//通过歌曲名称查询歌曲
	public Song searchSongByName(String n) {
		Iterator<Song> it=musicList.iterator();	
		while(it.hasNext()) {	
			Song song=it.next();
			if(song.getName().equals(n)) {
//				song=it.next();	
//集合进行关于迭代工作的时候,注意不要多次使用 next()方法,会造成不可预知的错误.
				return song;
			}		
		}
		return null;
	}
	
	//修改歌曲（歌曲id不变，删除旧歌曲信息，重新添加新歌曲）
	/*
	 * 问题:ArrayList是有序的，那么删除一个元素后，它会保留该位置吗？
	 * 答：JDK文档解释，后续元素左移
	 */
	public void updateSong(Song song) {
		Iterator<Song> it=musicList.iterator();	 
		while(it.hasNext()) {	
			if(it.next().equals(song)) {
//			if(it.next()==song) {			
//			==比较的是地址，需要用重写的equals方法来比较对象是否相等
//			String对象的equals()已经被重写，比较两者内容是否相等
				musicList.remove(song);
				String newID=song.getId();	
				String newName;
				String newSinger;
				Scanner input=new Scanner(System.in);
				System.out.println("请输入新的歌曲名:");
				newName=input.nextLine();
				System.out.println("请输入新的歌曲演唱者:");
				newSinger =input.nextLine();
				Song newSong=new Song(newID,newName,newSinger);
				musicList.add(newSong);
				
//				input.close();
			}
		}			
	}
	
	//通过歌曲id删除歌曲
	public void deleteSong(String id) {
		Iterator<Song> it=musicList.iterator();
		while(it.hasNext()) {
			Song s=it.next();
			if(s.getId().equals(id)) {				
				musicList.remove(s);
				//musicList.remove(it.next());  	
				//这样指定删除没问题？
				//有问题！按照JDK上的说法理解，每次调用 next 只能调用一次此方法,也意味着在调用remove()之前必须先调用next() 。
				break;		
				//忘记加跳出循环有异常，可能是删除元素后集合移动发生变化
			}
		}
	}
	
	//导出播放列表为歌单
	//实现方法：将musicList歌曲信息输出到txt文件，或将歌曲数据对象序列化
	//要求是序列化，我写了字符流的就不改了
	public void exportPlayList() {
		//字节输出流+字节字符转换输出流+字符输出缓冲流
		try {
			FileOutputStream fos=new FileOutputStream("C:\\Users\\Administrator\\Desktop\\"+this.getPlayListName()+".txt");
			OutputStreamWriter osw=new OutputStreamWriter(fos);
			BufferedWriter bw=new BufferedWriter(osw);
			
			Iterator<Song> it=musicList.iterator();
			while(it.hasNext()) {			
				String s=it.next().toString();
				bw.write(s,0, s.length());
				bw.flush();
				//为什么不加入强制刷新，会报UnKnow Source的错误？
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

