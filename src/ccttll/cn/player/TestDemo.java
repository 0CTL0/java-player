package ccttll.cn.player;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class TestDemo {
	//实例化播放器类
	PlayListCollection playListCollection=new PlayListCollection(new HashMap());
	//实例化主播放列表
	PlayList mainPlayList=new PlayList("主播放列表",new ArrayList());
	//问题：主方法中的变量能被里面调用的方法访问吗？
	//实际证明不能，得移到方法外作为全局变量。

	public static void main(String[] args) {
		TestDemo testdemo=new TestDemo();
//		testdemo.testSong();   查到1个bug,已解决
//		testdemo.testPlayList();  查到3个bug，已解决
//		testdemo.testPlayListCollection();  找到几个逻辑问题，已优化。
//		testdemo.mainMeu();
//		testdemo.playerMenu();  
//		testdemo.playListMenu();
/*
 * 发现个问题：标准输入，连续调用多次，但只输入一次？
 * 答：因为System.in.read()每次读取一个字节，不能过滤换行符，换行符占两个字节，
 * 一般情况下都不直接使用！
 */
		testdemo.test();
	}
	/*
	 * 一定要测试，由于不熟，逻辑不严谨、语法运用不熟等原因导致问题，不可避免。
	 * 学会调式很重要，可以快速找到Bug
	 * 测试逻辑时，最好设计测试用例，一个个手动测试太耗时耗里。
	 */
	//测试歌曲类
	public void testSong() {
		Song s1=new Song("s001","两只老虎","贝多芬");
		System.out.println(s1.getId());
		System.out.println(s1.getName());
		System.out.println(s1.getSinger());
		System.out.println(s1.toString());	
	};
	//测试播放列表类
	public void testPlayList() {
		PlayList dj=new PlayList(new String(), new ArrayList());
		System.out.println("添加三首歌曲");
		Song dj1=new Song("dj001","lalala","apple");
		Song dj2=new Song("dj002","wowowo","orange");
		Song dj3=new Song("dj003","hahaha","carrot");
		dj.addToPlayList(dj1);
		dj.addToPlayList(dj2);
		dj.addToPlayList(dj3);
		dj.displayAllSong();
		System.out.println("查找id为dj001的歌曲：");
		System.out.println(dj.searchSongById("dj002"));
		System.out.println("查找名称为lalala的歌曲：");
		System.out.println(dj.searchSongByName("lalala"));
		System.out.println("修改第2首的歌曲信息：");
		dj.updateSong(dj2);
		System.out.println("删除id为dj003的歌曲：");
		dj.deleteSong("dj003");
		System.out.println("将该歌曲列表导到桌面：PlayList");
		dj.exportPlayList();
	};
	//测试播放器类
	public void testPlayListCollection() {
		PlayListCollection playListCollection=new PlayListCollection(new HashMap());
		PlayList dj=new PlayList("dj1", new ArrayList());
		PlayList dj2=new PlayList("dj2", new ArrayList());
		PlayList dj3=new PlayList("dj3", new ArrayList());
		System.out.println("添加三个播放列表：");
		playListCollection.addPlayList(dj);
		playListCollection.addPlayList(dj2);
		playListCollection.addPlayList(dj3);
		playListCollection.displayPlayListName();
		System.out.println("查询名字为dj2的播放列表并删除");
		PlayList temp=playListCollection.searchPlayListByName("dj2");
		playListCollection.deletePlayList(temp);
		playListCollection.displayPlayListName();
	};
	
	
	//主菜单
	public void mainMeu() {
		playListCollection.addPlayList(mainPlayList);
		System.out.println("**************************************************");
		System.out.println("             **主菜单**");
		System.out.println("             1--播发器管理");
		System.out.println("             2--播放列表管理");
		System.out.println("             0--退出");
		System.out.println("**************************************************");
		System.out.println("请输入对应数字进行操作：");
	}
	
	//播放器菜单
		public void playerMenu() {		
			while(true) {
				System.out.println("**************************************************");
				System.out.println("             **播放器管理**");
				System.out.println("             1--向播放器添加播放列表");
				System.out.println("             2--从播放器删除播放列表");
				System.out.println("             3--通过名字查询播放列表");
				System.out.println("             4--显示所有播放列表名称");
				System.out.println("             9--返回上一级菜单");
				System.out.println("**************************************************");
				System.out.println("请输入对应数字对播放器进行管理：");
				Scanner console=new Scanner(System.in);
				String n=console.next();
//				console.close();
				switch(n) {
				case "1":
					System.out.println("请输入需要添加的播放列表名称：");
					Scanner console1=new Scanner(System.in);
					String playListName1=console1.next();
					PlayList pl=new PlayList(playListName1,new ArrayList());
					playListCollection.addPlayList(pl);
					System.out.println("已添加播放列表："+playListName1);
					break;
				case "2":
					System.out.println("请输入需要删除的播放列表名称：");
					Scanner console2=new Scanner(System.in);
					String playListName2=console2.next();		
					if(playListCollection.searchPlayListByName(playListName2)!=null) {
						playListCollection.deletePlayList(playListCollection.searchPlayListByName(playListName2));
						System.out.println("已删除播放列表："+playListName2);
					}
					else {
						System.out.println("没有该播放列表:"+playListName2);
					}					
					break;
				case "3":
					System.out.println("请输入需要查找的播放列表名称：");
					Scanner console3=new Scanner(System.in);
					String playListName3=console3.next();		
					if(playListCollection.searchPlayListByName(playListName3)!=null) {
						System.out.println("已找到播放列表："+playListName3);
					}
					else {
						System.out.println("没有找出该时播放列表:"+playListName3);
					}		
					break;
				case "4":
					playListCollection.displayPlayListName();
					break;
				case "9":
					return;
				default:
					System.out.println("请输入正确的数字选项进行操作:");
				}
			}			
		}
		
	//播放列表管理菜单
	/*
	 * 需求：
	 * 添加歌曲到普通播放列表时，会同步添加到主播放列表，若主播放列表存在该歌曲ID，则从主播放列表中添加；
	 * 从主播放列表中删除某ID歌曲，含有该歌曲的所有播放列表都删除，而从普通播放列表中删除，只会删除本身的歌曲；
	 * 从任意播放列表中修改某歌曲，所有含有相同歌曲ID的列表均发生改变。
	 * 如何实现？？？
	 * 想：最笨的方法————所有歌曲列表集合遍历操作一遍。
	 */
	public void playListMenu() {	
		while(true) {
			System.out.println("**************************************************");
			System.out.println("             **播放列表管理**");
			System.out.println("             1--将歌曲添加到主播放列表");
			System.out.println("             2--将歌曲添加到普通播放列表");
			System.out.println("             3--通过歌曲id查询播放列表的歌曲");
			System.out.println("             4--通过歌曲名称查询播放列表中的歌曲");
			System.out.println("             5--修改播放列表中的歌曲");
			System.out.println("             6--删除播放列表中的歌曲");
			System.out.println("             7--显示播放列表中的所有歌曲");
			System.out.println("             8--导出歌单");
			System.out.println("             9--返回上一级菜单");
			System.out.println("**************************************************");
			System.out.println("请输入对应数字对播放器进行管理：");
			Scanner console=new Scanner(System.in);
			String n=console.next();
//			console.close();
			switch(n) {
			//将歌曲添加到主播放列表
			case "1":
				System.out.println("请输入添加歌曲信息的数量:");
				int i=console.nextInt();  
				for(int t=1;t<=i;t++) {
					System.out.println("请输入第"+t+"首歌曲Id:");
					String songId=console.next();
					if(mainPlayList.searchSongById(songId)!=null) {
						System.out.println("该歌曲ID已存在");
						continue;
					}
					System.out.println("请输入第"+t+"首歌曲名字:");
					String songName=console.next();
					System.out.println("请输入第"+t+"首歌曲演唱者名称:");
					String songSinger=console.next();
					Song s=new Song(songId,songName,songSinger);
					mainPlayList.addToPlayList(s);
				}
				break;
			//将歌曲添加到普通播放列表，歌曲将同步添加到主播放列表，若主播放列表中已存在，将从主播放列表中添加
			case "2":
				System.out.println("请输入添加歌曲的普通播放列表名称:");
				String playListName2=console.next();
				PlayList pl2=playListCollection.searchPlayListByName(playListName2);
				if(pl2!=null) {
					System.out.println("请输入添加歌曲信息的数量:");
					int i2=console.nextInt(); 
					for(int t=1;t<=i2;t++) {
						System.out.println("请输入第"+t+"首歌曲Id:");
						String songId2=console.next();
						Song s2=mainPlayList.searchSongById(songId2);
						if(s2!=null) {
							System.out.println("主播放器列表有该Id歌曲，已自动添加");	
							pl2.addToPlayList(s2);
							continue;
						}
						else {
							System.out.println("主播放器列表没有该歌曲！");	
							System.out.println("请输入第"+t+"首歌曲名字:");
							String songName2=console.next();
							System.out.println("请输入第"+t+"首歌曲演唱者名称:");
							String songSinger2=console.next();
							Song s=new Song(songId2,songName2,songSinger2);
							pl2.addToPlayList(s);
							mainPlayList.addToPlayList(s);	
						}										
					}
					System.out.println("主播放列表的歌曲：");
					mainPlayList.displayAllSong();
					System.out.println(playListName2+"播放列表的歌曲：");
					pl2.displayAllSong();
				}
				else {
					System.out.println("没有该播放列表，请先将播放列表添加到播放器中");
				}
				break;
				//通过歌曲ID查询播放列表的歌曲
			case "3":
				System.out.println("请输入查询的播放列表名称：");
				String playListName3=console.next();	
				PlayList pl3=playListCollection.searchPlayListByName(playListName3);
				if(pl3!=null) {
					System.out.println("请输入查询的歌曲Id：");
					String songId3=console.next();
					Song s3=pl3.searchSongById(songId3);
					if(s3!=null) {	
						System.out.println("已找到该歌曲：");
						System.out.println(s3.toString());
						
					}
					else {
						System.out.println("没有此歌曲！");					}					
				}
				else {
					System.out.println("没有该播放列表!");
				}
				break;
				//通过歌曲名称查询播放列表的歌曲
			case "4":
				System.out.println("请输入查询的播放列表名称：");
				String playListName4=console.next();	
				PlayList pl4=playListCollection.searchPlayListByName(playListName4);
				if(pl4!=null) {
					System.out.println("请输入查询的歌曲名称：");
					String songName4=console.next();
					Song s4=pl4.searchSongByName(songName4);
					if(s4!=null) {	
						System.out.println("已找到该歌曲：");
						System.out.println(s4.toString());						
					}
					else {
						System.out.println("没有此歌曲！");					
						}					
				}
				else {
					System.out.println("没有该播放列表!");
				}
				break;
			//修改播放列表的歌曲，所有列表中含有相同名称的歌曲信息都会同步更新
			case "5":
				System.out.println("请输入修改的歌曲名称：");
				String songName5=console.next();
				//遍历主播放器的所有歌曲，若存在该歌曲，则更新歌曲。利用歌曲ID不变的特点，更新播放器所有列表中的相同歌曲。
				Song s5=mainPlayList.searchSongByName(songName5);
				if(s5!=null) {					
					String songId5=s5.getId();
					mainPlayList.updateSong(s5);					
					Song newS5=mainPlayList.searchSongById(songId5);
					for(PlayList pl5:playListCollection.getPlayListMap().values()) {
						if(pl5.searchSongByName(songName5)!=null) {
							pl5.deleteSong(songId5);
							pl5.addToPlayList(newS5);
						}
						
					}
				}
/*
 * 			Map迭代方法一：
				if(s5!=null) {				
					Iterator it=playListCollection.getPlayListMap().values().iterator();
					while(it.hasNext()) {
						PlayList pl5=(PlayList)it.next();
						pl5.updateSong(s5);
						//为什么无法使用迭代器对象元素的方法？？？					
						 * 分析：
						 * values方法返回的是Collection对象，跟这有关？
						 * 应该要向下转型！
				}
			Map迭代方法二：增强型for循环。还能使用keyset()、entrySet()来遍历key和values。
					for(PlayList pl:playListCollection.getPlayListMap().values()) {
						
					}
				}
*/
				else {
					System.out.println("该歌曲不存在!");
				}					
				break;
				//删除播放列表的歌曲，若删除的是主播放列表的歌曲，所有含有该歌曲的普通播放列表也会同步删除
			case "6":
				System.out.println("请输入需要删除歌曲的播放列表：");
				String pln6=console.next();
				System.out.println("请输入需要删除的歌曲Id:");
				String sId6=console.next();	
				if(pln6.equals("主播放列表")) {						
					for(PlayList pl6:playListCollection.getPlayListMap().values()) {
						if(pl6.searchSongById(sId6)!=null) {
							pl6.deleteSong(sId6);
						}			
					}
				}
				else {
					PlayList pl6=playListCollection.searchPlayListByName(pln6);
					if(pl6!=null) {
						pl6.deleteSong(sId6);
					}
				}
				break;
				//显示播放列表中所有的歌曲
			case "7":
				System.out.println("请输入显示所有歌曲的播放列表名称:");
				String pln7=console.next();
				PlayList pl7=playListCollection.searchPlayListByName(pln7);
				if(pl7!=null) {
					pl7.displayAllSong();
				}
				break;
				//导出播放列表名称和歌单
			case "8":
				System.out.println("请输入需要导出的播放列表：");
				String pln8=console.next();
				PlayList pl8=playListCollection.searchPlayListByName(pln8);
				if(pl8!=null) {
					pl8.exportPlayList();
				}
				break;
				//返回上一级菜单
			case "9":
				return;
			default:
				System.out.println("请输入以下的数字选项:");
			}
		}		
	}
	
	
	
	//主流程实现----核心-----   //实际上练这个方法都可以省略的，直接把逻辑写到mainMeu()方法中。
	public void test() {		
		while(true) {
			this.mainMeu();	
			Scanner console=new Scanner(System.in);
			String n=console.next();
//			console.close();  为什么关闭会有异常?
//			因为关闭顺便会把标准输入流关闭了，标准输入输出流随Jvm的启动而建立的。
			switch(n) {
			case "1":
				this.playerMenu();									
				break;
			case "2":
				this.playListMenu();		
				break;
			case "0":
				System.exit(0);
			default:
				System.out.println("请输入以下的数字选项");
		}	
		}
								
	}
	
	/*
	 * 小结：语法运用方面没有什么问题，逻辑方面问题也不大，关于JDK文档的使用还很多不熟练，
	 * 最大的疑惑在于，什么是面向对象设计编程，我这个还是像用C一样，在客户端类中整理出程
	 * 序逻辑流程，搭好框架，然后分模块编程的，这究竟是面向对象编程还是面向过程编程？
	 * 。。。。。。暂时理不清，还是面向工资编程好了。
	 */
	
}

