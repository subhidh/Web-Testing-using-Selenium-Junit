package drivers.strategies;

public class DriverStrategyImplement {
    public static DriverStrategy chooseStrategy(String strategy){
        switch(strategy)
        {
            case "drivers.strategies.Chrome":
                return new Chrome();

            case "drivers.strategies.Firefox":
                return new Firefox();

            case "drivers.strategies.Edge":
                return new Edge();

            default:
                return null;

        }
    }
}
