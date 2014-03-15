package chapter2;

/**
 * P11，Builder模式，适用于参数非常多时的对象构造，处理这种情况也可以用JavaBean模式，不过JavaBean模式下容易出现不一致，
 * 而且无法把类做成不可变的。在python中，传参没有这么麻烦
 * 
 */
public class BuilderPattern {
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;

	public static class Builder {
		// 必须出现属性
		private final int servingSize;
		private final int servings;
		// 可选属性
		private int calories;
		private int fat;
		private int sodium;
		private int carbohydrate;

		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}

		public Builder calories(int val) {
			calories = val;
			return this;
		}

		public Builder fat(int val) {
			fat = val;
			return this;
		}

		public Builder sodium(int val) {
			sodium = val;
			return this;
		}

		public Builder carbohydrate(int val) {
			carbohydrate = val;
			return this;
		}

		public BuilderPattern build() {
			return new BuilderPattern(this);
		}
	}

	private BuilderPattern(Builder builder) {
		servings = builder.servings;
		servingSize = builder.servingSize;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}

	public static void main(String[] args) {
		BuilderPattern instance = new BuilderPattern.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();
	}

}
