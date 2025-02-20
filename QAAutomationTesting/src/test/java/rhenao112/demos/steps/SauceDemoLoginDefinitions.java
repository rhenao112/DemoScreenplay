package rhenao112.demos.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;
import rhenao112.demos.enums.Exceptions;
import rhenao112.demos.exceptions.NotTextFound;
import rhenao112.demos.models.User;
import rhenao112.demos.tasks.Login;
import rhenao112.demos.utils.GetList;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;
import static rhenao112.demos.userinterfaces.SauceHomePage.TITTLE;


public class SauceDemoLoginDefinitions {


    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());

    }

    @Given("{string} desea iniciar sesión en la página {string}")
    public void deseaIniciarSesionEnLaPagina(String actorName, String app) {
        theActorCalled(actorName).wasAbleTo(Open.browserOn().thePageNamed("urls.".concat(app)));
    }

    @When("ingresa la información del usuario de {string}")
    public void ingresaLaInformacionDelUsuarioDe(String app, User user) {
        theActorInTheSpotlight().attemptsTo(Login.into(user, new GetList().theTargets(app)));
    }

    @Then("valida que se presenta el mensaje de éxito {string}")
    public void validaQueSePresentaElMensajeDeExito(String msg) {
        theActorInTheSpotlight().should(seeThat(Text.of(TITTLE), equalTo(msg)).orComplainWith(NotTextFound.class,
                String.format(Exceptions.LOGIN_FAIL.getTextoExepcion(), msg, Text.of(TITTLE).answeredBy(theActorInTheSpotlight()))));
    }

}