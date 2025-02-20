package rhenao112.demos.utils;

import net.serenitybdd.screenplay.targets.Target;
import rhenao112.demos.userinterfaces.GuruLoginPage;
import rhenao112.demos.userinterfaces.SauceLoginPage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetList {

    private Map<String, List<Target>> targets;

    public GetList() {
        super();
        targets = new HashMap<>();
        targets.put("sauceDemo",  new SauceLoginPage().getTargets());
        targets.put("guru", new GuruLoginPage().getFields());
    }

    public List<Target> theTargets(String pageName) {
        return targets.get(pageName);
    }


}
