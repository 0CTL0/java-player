package ccttll.cn.player;

public class Song {
	private String id;    //歌曲id
	private String name;  //歌曲名
	private String singer;  //演唱者
	//构造方法
	public Song(String id, String name, String singer) {
		super();
		this.id = id;
		this.name = name;
		this.singer = singer;
	}
	
	//属性的get、set方法
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
	
	//重写equals和hashcode
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
		//判断两个类是否同一类型
		if(obj.getClass()==Song.class) {	
			/*
			 * 几种获取class对象的方法：
			 * 1，所有的引用数据类型（类-类型）的类名、基本数据类型都可以通过.class方式获取其 Class对象。
			 * 2，Class 的 forName(String  name)传入一个类的完整类路径也可以获得 Class 对象。
			 * 3，还可通过类的对象实例下的getClass()方法来获取Class对象，即 实例名getClass()
			 */
			Song song=(Song)obj;
			
			return song.getId().equals(id)&&(song.getName()==name)&&(song.getSinger().equals(singer));	
		}
		return false;
	}
	//重写toSring
	@Override
	public String toString() {
		return "[歌曲id=" + id + ",歌曲名称=" + name + ",演唱者=" + singer + "]";
	}
	
	
}

