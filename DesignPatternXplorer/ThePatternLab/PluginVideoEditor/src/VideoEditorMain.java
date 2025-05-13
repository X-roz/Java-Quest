public class VideoEditorMain {
    public static void main(String[] args) {

        Plugin filterPlugin = new filterPlugin();
        Plugin fastForwardPlugin = new fastForwardPlugin();

        PluginHolder.addPlugin("filter", filterPlugin);
        PluginHolder.addPlugin("fast-forward", fastForwardPlugin);

        filterPlugin.pluginOperation();
        fastForwardPlugin.pluginOperation();

        PluginHolder.removePlugin("fast-forward");
    }
}
