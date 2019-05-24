package ccttll.cn.player;

public class Song {
	private String id;    //����id
	private String name;  //������
	private String singer;  //�ݳ���
	//���췽��
	public Song(String id, String name, String singer) {
		super();
		this.id = id;
		this.name = name;
		this.singer = singer;
	}
	
	//���Ե�get��set����
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	//��дequals��hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((singer == null) ? 0 : singer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		//�ж��������Ƿ�ͬһ����
		if(obj.getClass()==Song.class) {	
			/*
			 * ���ֻ�ȡclass����ķ�����
			 * 1�����е������������ͣ���-���ͣ��������������������Ͷ�����ͨ��.class��ʽ��ȡ�� Class����
			 * 2��Class �� forName(String  name)����һ�����������·��Ҳ���Ի�� Class ����
			 * 3������ͨ����Ķ���ʵ���µ�getClass()��������ȡClass���󣬼� ʵ����getClass()
			 */
			Song song=(Song)obj;
			
			return song.getId().equals(id)&&(song.getName()==name)&&(song.getSinger().equals(singer));	
		}
		return false;
	}
	//��дtoSring
	@Override
	public String toString() {
		return "[����id=" + id + ",��������=" + name + ",�ݳ���=" + singer + "]";
	}
	
	
}

