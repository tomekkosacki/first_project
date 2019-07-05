package pl.comarch.tomasz.kosacki;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import pl.comarch.tomasz.kosacki.projectConfiguration.ProjectConfiguration;
import pl.comarch.tomasz.kosacki.projectHealthCheck.RestStubCheck;
import pl.comarch.tomasz.kosacki.resources.PersonService;

public class ClientServiceApp extends Application<ProjectConfiguration> {
    public static void main(String[] args) throws Exception {
        new ClientServiceApp().run(args);
    }

    @Override
    public void run(ProjectConfiguration config, Environment env){
        final PersonService personService = new PersonService();
        env.jersey().register(personService);

        env.healthChecks().register("template",
                new RestStubCheck(config.getVersion()));
    }

}
