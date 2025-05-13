import java.util.HashMap;
import java.util.Map;

public class PluginHolder {
    private static final Map<String, Plugin> pluginRegistry = new HashMap<>();

    public static void addPlugin(String pluginName,Plugin newPlugin) {
        pluginRegistry.put(pluginName, newPlugin);
    }

    public static void removePlugin(String pluginName) {
        pluginRegistry.remove(pluginName);
    }

    public static Plugin getPlugin(String pluginName){
        return pluginRegistry.get(pluginName);
    }
}
