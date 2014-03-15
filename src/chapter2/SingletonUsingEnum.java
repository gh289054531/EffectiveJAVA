package chapter2;

/**
 * P15，使用Enum枚举实现单例，最好的单例实现，支持序列化，抵抗反射攻击。使用SingletonUsingEnum.INSTANCE调用。
 * 
 */
enum SingletonUsingEnum {
	INSTANCE;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
