package ccttll.cn.player;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class TestDemo {
	//ʵ������������
	PlayListCollection playListCollection=new PlayListCollection(new HashMap());
	//ʵ�����������б�
	PlayList mainPlayList=new PlayList("�������б�",new ArrayList());
	//���⣺�������еı����ܱ�������õķ���������
	//ʵ��֤�����ܣ����Ƶ���������Ϊȫ�ֱ�����

	public static void main(String[] args) {
		TestDemo testdemo=new TestDemo();
//		testdemo.testSong();   �鵽1��bug,�ѽ��
//		testdemo.testPlayList();  �鵽3��bug���ѽ��
//		testdemo.testPlayListCollection();  �ҵ������߼����⣬���Ż���
//		testdemo.mainMeu();
//		testdemo.playerMenu();  
//		testdemo.playListMenu();
/*
 * ���ָ����⣺��׼���룬�������ö�Σ���ֻ����һ�Σ�
 * ����ΪSystem.in.read()ÿ�ζ�ȡһ���ֽڣ����ܹ��˻��з������з�ռ�����ֽڣ�
 * һ������¶���ֱ��ʹ�ã�
 */
		testdemo.test();
	}
	/*
	 * һ��Ҫ���ԣ����ڲ��죬�߼����Ͻ����﷨���ò����ԭ�������⣬���ɱ��⡣
	 * ѧ���ʽ����Ҫ�����Կ����ҵ�Bug
	 * �����߼�ʱ�������Ʋ���������һ�����ֶ�����̫��ʱ���
	 */
	//���Ը�����
	public void testSong() {
		Song s1=new Song("s001","��ֻ�ϻ�","�����");
		System.out.println(s1.getId());
		System.out.println(s1.getName());
		System.out.println(s1.getSinger());
		System.out.println(s1.toString());	
	};
	//���Բ����б���
	public void testPlayList() {
		PlayList dj=new PlayList(new String(), new ArrayList());
		System.out.println("������׸���");
		Song dj1=new Song("dj001","lalala","apple");
		Song dj2=new Song("dj002","wowowo","orange");
		Song dj3=new Song("dj003","hahaha","carrot");
		dj.addToPlayList(dj1);
		dj.addToPlayList(dj2);
		dj.addToPlayList(dj3);
		dj.displayAllSong();
		System.out.println("����idΪdj001�ĸ�����");
		System.out.println(dj.searchSongById("dj002"));
		System.out.println("��������Ϊlalala�ĸ�����");
		System.out.println(dj.searchSongByName("lalala"));
		System.out.println("�޸ĵ�2�׵ĸ�����Ϣ��");
		dj.updateSong(dj2);
		System.out.println("ɾ��idΪdj003�ĸ�����");
		dj.deleteSong("dj003");
		System.out.println("���ø����б������棺PlayList");
		dj.exportPlayList();
	};
	//���Բ�������
	public void testPlayListCollection() {
		PlayListCollection playListCollection=new PlayListCollection(new HashMap());
		PlayList dj=new PlayList("dj1", new ArrayList());
		PlayList dj2=new PlayList("dj2", new ArrayList());
		PlayList dj3=new PlayList("dj3", new ArrayList());
		System.out.println("������������б�");
		playListCollection.addPlayList(dj);
		playListCollection.addPlayList(dj2);
		playListCollection.addPlayList(dj3);
		playListCollection.displayPlayListName();
		System.out.println("��ѯ����Ϊdj2�Ĳ����б�ɾ��");
		PlayList temp=playListCollection.searchPlayListByName("dj2");
		playListCollection.deletePlayList(temp);
		playListCollection.displayPlayListName();
	};
	
	
	//���˵�
	public void mainMeu() {
		playListCollection.addPlayList(mainPlayList);
		System.out.println("**************************************************");
		System.out.println("             **���˵�**");
		System.out.println("             1--����������");
		System.out.println("             2--�����б����");
		System.out.println("             0--�˳�");
		System.out.println("**************************************************");
		System.out.println("�������Ӧ���ֽ��в�����");
	}
	
	//�������˵�
		public void playerMenu() {		
			while(true) {
				System.out.println("**************************************************");
				System.out.println("             **����������**");
				System.out.println("             1--�򲥷�����Ӳ����б�");
				System.out.println("             2--�Ӳ�����ɾ�������б�");
				System.out.println("             3--ͨ�����ֲ�ѯ�����б�");
				System.out.println("             4--��ʾ���в����б�����");
				System.out.println("             9--������һ���˵�");
				System.out.println("**************************************************");
				System.out.println("�������Ӧ���ֶԲ��������й���");
				Scanner console=new Scanner(System.in);
				String n=console.next();
//				console.close();
				switch(n) {
				case "1":
					System.out.println("��������Ҫ��ӵĲ����б����ƣ�");
					Scanner console1=new Scanner(System.in);
					String playListName1=console1.next();
					PlayList pl=new PlayList(playListName1,new ArrayList());
					playListCollection.addPlayList(pl);
					System.out.println("����Ӳ����б�"+playListName1);
					break;
				case "2":
					System.out.println("��������Ҫɾ���Ĳ����б����ƣ�");
					Scanner console2=new Scanner(System.in);
					String playListName2=console2.next();		
					if(playListCollection.searchPlayListByName(playListName2)!=null) {
						playListCollection.deletePlayList(playListCollection.searchPlayListByName(playListName2));
						System.out.println("��ɾ�������б�"+playListName2);
					}
					else {
						System.out.println("û�иò����б�:"+playListName2);
					}					
					break;
				case "3":
					System.out.println("��������Ҫ���ҵĲ����б����ƣ�");
					Scanner console3=new Scanner(System.in);
					String playListName3=console3.next();		
					if(playListCollection.searchPlayListByName(playListName3)!=null) {
						System.out.println("���ҵ������б�"+playListName3);
					}
					else {
						System.out.println("û���ҳ���ʱ�����б�:"+playListName3);
					}		
					break;
				case "4":
					playListCollection.displayPlayListName();
					break;
				case "9":
					return;
				default:
					System.out.println("��������ȷ������ѡ����в���:");
				}
			}			
		}
		
	//�����б����˵�
	/*
	 * ����
	 * ��Ӹ�������ͨ�����б�ʱ����ͬ����ӵ��������б����������б���ڸø���ID������������б�����ӣ�
	 * ���������б���ɾ��ĳID���������иø��������в����б�ɾ����������ͨ�����б���ɾ����ֻ��ɾ������ĸ�����
	 * �����ⲥ���б����޸�ĳ���������к�����ͬ����ID���б�������ı䡣
	 * ���ʵ�֣�����
	 * �룺��ķ��������������и����б��ϱ�������һ�顣
	 */
	public void playListMenu() {	
		while(true) {
			System.out.println("**************************************************");
			System.out.println("             **�����б����**");
			System.out.println("             1--��������ӵ��������б�");
			System.out.println("             2--��������ӵ���ͨ�����б�");
			System.out.println("             3--ͨ������id��ѯ�����б�ĸ���");
			System.out.println("             4--ͨ���������Ʋ�ѯ�����б��еĸ���");
			System.out.println("             5--�޸Ĳ����б��еĸ���");
			System.out.println("             6--ɾ�������б��еĸ���");
			System.out.println("             7--��ʾ�����б��е����и���");
			System.out.println("             8--�����赥");
			System.out.println("             9--������һ���˵�");
			System.out.println("**************************************************");
			System.out.println("�������Ӧ���ֶԲ��������й���");
			Scanner console=new Scanner(System.in);
			String n=console.next();
//			console.close();
			switch(n) {
			//��������ӵ��������б�
			case "1":
				System.out.println("��������Ӹ�����Ϣ������:");
				int i=console.nextInt();  
				for(int t=1;t<=i;t++) {
					System.out.println("�������"+t+"�׸���Id:");
					String songId=console.next();
					if(mainPlayList.searchSongById(songId)!=null) {
						System.out.println("�ø���ID�Ѵ���");
						continue;
					}
					System.out.println("�������"+t+"�׸�������:");
					String songName=console.next();
					System.out.println("�������"+t+"�׸����ݳ�������:");
					String songSinger=console.next();
					Song s=new Song(songId,songName,songSinger);
					mainPlayList.addToPlayList(s);
				}
				break;
			//��������ӵ���ͨ�����б�������ͬ����ӵ��������б����������б����Ѵ��ڣ������������б������
			case "2":
				System.out.println("��������Ӹ�������ͨ�����б�����:");
				String playListName2=console.next();
				PlayList pl2=playListCollection.searchPlayListByName(playListName2);
				if(pl2!=null) {
					System.out.println("��������Ӹ�����Ϣ������:");
					int i2=console.nextInt(); 
					for(int t=1;t<=i2;t++) {
						System.out.println("�������"+t+"�׸���Id:");
						String songId2=console.next();
						Song s2=mainPlayList.searchSongById(songId2);
						if(s2!=null) {
							System.out.println("���������б��и�Id���������Զ����");	
							pl2.addToPlayList(s2);
							continue;
						}
						else {
							System.out.println("���������б�û�иø�����");	
							System.out.println("�������"+t+"�׸�������:");
							String songName2=console.next();
							System.out.println("�������"+t+"�׸����ݳ�������:");
							String songSinger2=console.next();
							Song s=new Song(songId2,songName2,songSinger2);
							pl2.addToPlayList(s);
							mainPlayList.addToPlayList(s);	
						}										
					}
					System.out.println("�������б�ĸ�����");
					mainPlayList.displayAllSong();
					System.out.println(playListName2+"�����б�ĸ�����");
					pl2.displayAllSong();
				}
				else {
					System.out.println("û�иò����б����Ƚ������б���ӵ���������");
				}
				break;
				//ͨ������ID��ѯ�����б�ĸ���
			case "3":
				System.out.println("�������ѯ�Ĳ����б����ƣ�");
				String playListName3=console.next();	
				PlayList pl3=playListCollection.searchPlayListByName(playListName3);
				if(pl3!=null) {
					System.out.println("�������ѯ�ĸ���Id��");
					String songId3=console.next();
					Song s3=pl3.searchSongById(songId3);
					if(s3!=null) {	
						System.out.println("���ҵ��ø�����");
						System.out.println(s3.toString());
						
					}
					else {
						System.out.println("û�д˸�����");					}					
				}
				else {
					System.out.println("û�иò����б�!");
				}
				break;
				//ͨ���������Ʋ�ѯ�����б�ĸ���
			case "4":
				System.out.println("�������ѯ�Ĳ����б����ƣ�");
				String playListName4=console.next();	
				PlayList pl4=playListCollection.searchPlayListByName(playListName4);
				if(pl4!=null) {
					System.out.println("�������ѯ�ĸ������ƣ�");
					String songName4=console.next();
					Song s4=pl4.searchSongByName(songName4);
					if(s4!=null) {	
						System.out.println("���ҵ��ø�����");
						System.out.println(s4.toString());						
					}
					else {
						System.out.println("û�д˸�����");					
						}					
				}
				else {
					System.out.println("û�иò����б�!");
				}
				break;
			//�޸Ĳ����б�ĸ����������б��к�����ͬ���Ƶĸ�����Ϣ����ͬ������
			case "5":
				System.out.println("�������޸ĵĸ������ƣ�");
				String songName5=console.next();
				//�����������������и����������ڸø���������¸��������ø���ID������ص㣬���²����������б��е���ͬ������
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
 * 			Map��������һ��
				if(s5!=null) {				
					Iterator it=playListCollection.getPlayListMap().values().iterator();
					while(it.hasNext()) {
						PlayList pl5=(PlayList)it.next();
						pl5.updateSong(s5);
						//Ϊʲô�޷�ʹ�õ���������Ԫ�صķ���������					
						 * ������
						 * values�������ص���Collection���󣬸����йأ�
						 * Ӧ��Ҫ����ת�ͣ�
				}
			Map��������������ǿ��forѭ��������ʹ��keyset()��entrySet()������key��values��
					for(PlayList pl:playListCollection.getPlayListMap().values()) {
						
					}
				}
*/
				else {
					System.out.println("�ø���������!");
				}					
				break;
				//ɾ�������б�ĸ�������ɾ�������������б�ĸ��������к��иø�������ͨ�����б�Ҳ��ͬ��ɾ��
			case "6":
				System.out.println("��������Ҫɾ�������Ĳ����б�");
				String pln6=console.next();
				System.out.println("��������Ҫɾ���ĸ���Id:");
				String sId6=console.next();	
				if(pln6.equals("�������б�")) {						
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
				//��ʾ�����б������еĸ���
			case "7":
				System.out.println("��������ʾ���и����Ĳ����б�����:");
				String pln7=console.next();
				PlayList pl7=playListCollection.searchPlayListByName(pln7);
				if(pl7!=null) {
					pl7.displayAllSong();
				}
				break;
				//���������б����ƺ͸赥
			case "8":
				System.out.println("��������Ҫ�����Ĳ����б�");
				String pln8=console.next();
				PlayList pl8=playListCollection.searchPlayListByName(pln8);
				if(pl8!=null) {
					pl8.exportPlayList();
				}
				break;
				//������һ���˵�
			case "9":
				return;
			default:
				System.out.println("���������µ�����ѡ��:");
			}
		}		
	}
	
	
	
	//������ʵ��----����-----   //ʵ�������������������ʡ�Եģ�ֱ�Ӱ��߼�д��mainMeu()�����С�
	public void test() {		
		while(true) {
			this.mainMeu();	
			Scanner console=new Scanner(System.in);
			String n=console.next();
//			console.close();  Ϊʲô�رջ����쳣?
//			��Ϊ�ر�˳���ѱ�׼�������ر��ˣ���׼�����������Jvm�������������ġ�
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
				System.out.println("���������µ�����ѡ��");
		}	
		}
								
	}
	
	/*
	 * С�᣺�﷨���÷���û��ʲô���⣬�߼���������Ҳ���󣬹���JDK�ĵ���ʹ�û��ܶ಻������
	 * �����ɻ����ڣ�ʲô�����������Ʊ�̣��������������Cһ�����ڿͻ��������������
	 * ���߼����̣���ÿ�ܣ�Ȼ���ģ���̵ģ��⾿������������̻���������̱�̣�
	 * ��������������ʱ���壬���������ʱ�̺��ˡ�
	 */
	
}

