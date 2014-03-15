package chapter2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * P7,服务提供者框架
 * 
 */
public class ServiceProviderFramework {
	private ServiceProviderFramework() {
	}

	private static final Map<String, Provider> providers = new ConcurrentHashMap<String, Provider>();

	public static void registerProvider(String name, Provider provider) {
		providers.put(name, provider);
	}

	public static Service newServiceInstance(String name) {
		if (providers.containsKey(name) == false) {
			throw new IllegalArgumentException("No privider " + name);
		}
		return providers.get(name).newService();
	}

}
