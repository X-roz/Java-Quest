public class Facade {

    /// Facade: One class to control all the functionality and has many dependency of other classes.

    public static void main(String[] args){

        FacadePattern facadePattern = new FacadePattern();
        facadePattern.process();
    }

    static class FacadePattern {
        private final DbRepository dbRepository;
        private final ApiResource apiResource;
        private final ApplicationConfig applicationConfig;
        private final ResourceAdapter resourceAdapter;

        FacadePattern() {
            this.apiResource = new ApiResource();
            this.applicationConfig = new ApplicationConfig();
            this.dbRepository = new DbRepository();
            this.resourceAdapter = new ResourceAdapter();
        }

        public void process() {
            dbRepository.operations();
            apiResource.resource();
            resourceAdapter.adapter();
            applicationConfig.getData();
        }

    }

    static class DbRepository {
        public void operations() {
            System.out.println("DB Class");
        }
    }

    static class ApiResource {
        public void resource() {
            System.out.println("resources");
        }
    }

    static class ResourceAdapter {
        public void adapter() {
            System.out.println("Conversion");
        }
    }

    static class ApplicationConfig {
        public void getData() {
            System.out.println("ApplicationConfig data");
        }
    }

}
